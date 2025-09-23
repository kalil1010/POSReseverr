package net.p003sf.scuba.tlv;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.p003sf.scuba.util.Hex;

/* loaded from: classes.dex */
class TLVOutputState {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    private boolean isAtStartOfLength;
    private boolean isAtStartOfTag;
    private boolean isReadingValue;
    private Deque<TLVStruct> state;

    public TLVOutputState() {
        this(new ArrayDeque(), true, false, false);
    }

    public TLVOutputState(TLVOutputState original) {
        this(original.getDeepCopyOfState(), original.isAtStartOfTag, original.isAtStartOfLength, original.isReadingValue);
    }

    private TLVOutputState(Deque<TLVStruct> state, boolean isAtStartOfTag, boolean isAtStartOfLength, boolean isReadingValue) {
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
        TLVStruct currentObject = this.state.peek();
        return currentObject.getTag();
    }

    public int getLength() {
        if (this.state.isEmpty()) {
            throw new IllegalStateException("Length not yet known.");
        }
        TLVStruct currentObject = this.state.peek();
        int length = currentObject.getLength();
        if (length < 0) {
            throw new IllegalStateException("Length not yet knwon.");
        }
        return length;
    }

    public int getValueBytesProcessed() {
        TLVStruct currentObject = this.state.peek();
        return currentObject.getValueBytesProcessed();
    }

    public int getValueBytesLeft() {
        if (this.state.isEmpty()) {
            throw new IllegalStateException("Length of value is unknown.");
        }
        TLVStruct currentObject = this.state.peek();
        int currentLength = currentObject.getLength();
        int valueBytesRead = currentObject.getValueBytesProcessed();
        return currentLength - valueBytesRead;
    }

    public void setTagProcessed(int tag) {
        TLVStruct obj = new TLVStruct(this, tag);
        if (!this.state.isEmpty()) {
            TLVStruct parent = this.state.peek();
            byte[] tagBytes = TLVUtil.getTagAsBytes(tag);
            parent.write(tagBytes, 0, tagBytes.length);
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

    public boolean isDummyLengthSet() {
        if (this.state.isEmpty()) {
            return false;
        }
        return !this.state.peek().isLengthSet();
    }

    public void setLengthProcessed(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Cannot set negative length (length = " + length + ").");
        }
        TLVStruct obj = this.state.pop();
        if (!this.state.isEmpty()) {
            TLVStruct parent = this.state.peek();
            byte[] lengthBytes = TLVUtil.getLengthAsBytes(length);
            parent.write(lengthBytes, 0, lengthBytes.length);
        }
        obj.setLength(length);
        this.state.push(obj);
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public void updatePreviousLength(int byteCount) {
        if (this.state.isEmpty()) {
            return;
        }
        TLVStruct currentObject = this.state.peek();
        if (currentObject.isLengthSet && currentObject.getLength() == byteCount) {
            return;
        }
        currentObject.setLength(byteCount);
        if (currentObject.getValueBytesProcessed() == currentObject.getLength()) {
            this.state.pop();
            byte[] lengthBytes = TLVUtil.getLengthAsBytes(byteCount);
            byte[] value = currentObject.getValue();
            updateValueBytesProcessed(lengthBytes, 0, lengthBytes.length);
            updateValueBytesProcessed(value, 0, value.length);
            this.isAtStartOfTag = true;
            this.isAtStartOfLength = false;
            this.isReadingValue = false;
        }
    }

    public void updateValueBytesProcessed(byte[] bytes, int offset, int length) {
        if (this.state.isEmpty()) {
            return;
        }
        TLVStruct currentObject = this.state.peek();
        int bytesLeft = currentObject.getLength() - currentObject.getValueBytesProcessed();
        if (length > bytesLeft) {
            throw new IllegalArgumentException("Cannot process " + length + " bytes! Only " + bytesLeft + " bytes left in this TLV object " + currentObject);
        }
        currentObject.write(bytes, offset, length);
        if (currentObject.getValueBytesProcessed() == currentObject.getLength()) {
            this.state.pop();
            updateValueBytesProcessed(currentObject.getValue(), 0, currentObject.getLength());
            this.isAtStartOfTag = true;
            this.isAtStartOfLength = false;
            this.isReadingValue = false;
            return;
        }
        this.isAtStartOfTag = false;
        this.isAtStartOfLength = false;
        this.isReadingValue = true;
    }

    public byte[] getValue() {
        if (this.state.isEmpty()) {
            throw new IllegalStateException("Cannot get value yet.");
        }
        return this.state.peek().getValue();
    }

    public String toString() {
        return this.state.toString();
    }

    public boolean canBeWritten() {
        for (TLVStruct stackFrame : this.state) {
            if (!stackFrame.isLengthSet()) {
                return false;
            }
        }
        return true;
    }

    private Deque<TLVStruct> getDeepCopyOfState() {
        Deque<TLVStruct> newStack = new ArrayDeque<>(this.state.size());
        for (TLVStruct tlvStruct : this.state) {
            newStack.add(new TLVStruct(this, tlvStruct));
        }
        return newStack;
    }

    private class TLVStruct {
        private boolean isLengthSet;
        private int length;
        private int tag;
        private ByteArrayOutputStream value;

        public TLVStruct(TLVOutputState tLVOutputState, TLVStruct original) {
            this(original.tag, original.length, original.isLengthSet, original.getValue());
        }

        public TLVStruct(TLVOutputState tLVOutputState, int tag) {
            this(tag, Integer.MAX_VALUE, false, null);
        }

        public TLVStruct(int tag, int length, boolean isLengthSet, byte[] value) {
            this.tag = tag;
            this.length = length;
            this.isLengthSet = isLengthSet;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.value = byteArrayOutputStream;
            if (value != null) {
                try {
                    byteArrayOutputStream.write(value);
                } catch (IOException ioe) {
                    TLVOutputState.LOGGER.log(Level.FINE, "Exception writing bytes in memory", (Throwable) ioe);
                }
            }
        }

        public void setLength(int length) {
            this.length = length;
            this.isLengthSet = true;
        }

        public int getTag() {
            return this.tag;
        }

        public int getLength() {
            return this.length;
        }

        public boolean isLengthSet() {
            return this.isLengthSet;
        }

        public int getValueBytesProcessed() {
            return this.value.size();
        }

        public byte[] getValue() {
            return this.value.toByteArray();
        }

        public void write(byte[] bytes, int offset, int length) {
            this.value.write(bytes, offset, length);
        }

        public String toString() {
            byte[] valueBytes = this.value.toByteArray();
            StringBuilder sb = new StringBuilder();
            sb.append("[TLVStruct ");
            sb.append(Integer.toHexString(this.tag));
            sb.append(", ");
            sb.append(this.isLengthSet ? Integer.valueOf(this.length) : "UNDEFINED");
            sb.append(", ");
            sb.append(Hex.bytesToHexString(valueBytes));
            sb.append("(");
            sb.append(valueBytes.length);
            sb.append(") ]");
            return sb.toString();
        }
    }
}
