package net.p003sf.scuba.tlv;

import java.util.ArrayDeque;
import java.util.Deque;

/* loaded from: classes.dex */
class TLVInputState {
    private boolean isAtStartOfLength;
    private boolean isAtStartOfTag;
    private boolean isReadingValue;
    private Deque<TLStruct> state;

    public TLVInputState() {
        this(new ArrayDeque(), true, false, false);
    }

    public TLVInputState(TLVInputState original) {
        this(original.getDeepCopyOfState(), original.isAtStartOfTag, original.isAtStartOfLength, original.isReadingValue);
    }

    private TLVInputState(Deque<TLStruct> state, boolean isAtStartOfTag, boolean isAtStartOfLength, boolean isReadingValue) {
        this.state = state;
        this.isAtStartOfTag = isAtStartOfTag;
        this.isAtStartOfLength = isAtStartOfLength;
        this.isReadingValue = isReadingValue;
    }

    public boolean isAtStartOfTag() {
        return this.isAtStartOfTag;
    }

    public boolean isAtStartOfLength() {
        return this.isAtStartOfLength;
    }

    public boolean isProcessingValue() {
        return this.isReadingValue;
    }

    public int getTag() {
        if (this.state.isEmpty()) {
            throw new IllegalStateException("Tag not yet read.");
        }
        TLStruct currentObject = this.state.peek();
        return currentObject.getTag();
    }

    public int getLength() {
        if (this.state.isEmpty()) {
            throw new IllegalStateException("Length not yet known.");
        }
        TLStruct currentObject = this.state.peek();
        return currentObject.getLength();
    }

    public int getValueBytesProcessed() {
        TLStruct currentObject = this.state.peek();
        return currentObject.getValueBytesProcessed();
    }

    public int getValueBytesLeft() {
        if (this.state.isEmpty()) {
            throw new IllegalStateException("Length of value is unknown.");
        }
        TLStruct currentObject = this.state.peek();
        int currentLength = currentObject.getLength();
        int valueBytesRead = currentObject.getValueBytesProcessed();
        return currentLength - valueBytesRead;
    }

    public void setTagProcessed(int tag, int byteCount) {
        TLStruct obj = new TLStruct(this, tag);
        if (!this.state.isEmpty()) {
            TLStruct parent = this.state.peek();
            parent.updateValueBytesProcessed(byteCount);
        }
        this.state.push(obj);
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = true;
        this.isReadingValue = false;
    }

    public void setDummyLengthProcessed() {
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public void setLengthProcessed(int length, int byteCount) {
        if (length < 0) {
            throw new IllegalArgumentException("Cannot set negative length (length = " + length + ", 0x" + Integer.toHexString(length) + " for tag " + Integer.toHexString(getTag()) + ").");
        }
        TLStruct obj = this.state.pop();
        if (!this.state.isEmpty()) {
            TLStruct parent = this.state.peek();
            parent.updateValueBytesProcessed(byteCount);
        }
        obj.setLength(length);
        this.state.push(obj);
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public void updateValueBytesProcessed(int byteCount) {
        if (this.state.isEmpty()) {
            return;
        }
        TLStruct currentObject = this.state.peek();
        int bytesLeft = currentObject.getLength() - currentObject.getValueBytesProcessed();
        if (byteCount > bytesLeft) {
            throw new IllegalArgumentException("Cannot process " + byteCount + " bytes! Only " + bytesLeft + " bytes left in this TLV object " + currentObject);
        }
        currentObject.updateValueBytesProcessed(byteCount);
        int currentLength = currentObject.getLength();
        if (currentObject.getValueBytesProcessed() == currentLength) {
            this.state.pop();
            updateValueBytesProcessed(currentLength);
            this.isAtStartOfTag = true;
            this.isAtStartOfLength = false;
            this.isReadingValue = false;
            return;
        }
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public String toString() {
        return this.state.toString();
    }

    private Deque<TLStruct> getDeepCopyOfState() {
        Deque<TLStruct> newStack = new ArrayDeque<>(this.state.size());
        for (TLStruct tlStruct : this.state) {
            newStack.addLast(new TLStruct(this, tlStruct));
        }
        return newStack;
    }

    private class TLStruct {
        private int length;
        private int tag;
        private int valueBytesRead;

        public TLStruct(TLVInputState tLVInputState, int tag) {
            this(tag, Integer.MAX_VALUE, 0);
        }

        public TLStruct(TLVInputState tLVInputState, TLStruct original) {
            this(original.tag, original.length, original.valueBytesRead);
        }

        public TLStruct(int tag, int length, int valueBytesRead) {
            this.tag = tag;
            this.length = length;
            this.valueBytesRead = valueBytesRead;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getTag() {
            return this.tag;
        }

        public int getLength() {
            return this.length;
        }

        public int getValueBytesProcessed() {
            return this.valueBytesRead;
        }

        public void updateValueBytesProcessed(int n) {
            this.valueBytesRead += n;
        }

        public String toString() {
            return "[TLStruct " + Integer.toHexString(this.tag) + ", " + this.length + ", " + this.valueBytesRead + "]";
        }
    }
}
