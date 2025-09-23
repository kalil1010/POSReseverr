package net.p003sf.scuba.smartcards;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class CommandAPDU implements Serializable {
    private static final int MAX_APDU_SIZE = 65544;
    private static final long serialVersionUID = 398698301286670877L;
    private byte[] apdu;
    private transient int dataOffset;

    /* renamed from: nc */
    private transient int f838nc;

    /* renamed from: ne */
    private transient int f839ne;

    public CommandAPDU(byte[] apdu) {
        this.apdu = (byte[]) apdu.clone();
        parse();
    }

    public CommandAPDU(byte[] apdu, int apduOffset, int apduLength) {
        checkArrayBounds(apdu, apduOffset, apduLength);
        byte[] bArr = new byte[apduLength];
        this.apdu = bArr;
        System.arraycopy(apdu, apduOffset, bArr, 0, apduLength);
        parse();
    }

    private void checkArrayBounds(byte[] b, int ofs, int len) {
        if (ofs < 0 || len < 0) {
            throw new IllegalArgumentException("Offset and length must not be negative");
        }
        if (b == null) {
            if (ofs != 0 && len != 0) {
                throw new IllegalArgumentException("offset and length must be 0 if array is null");
            }
        } else if (ofs > b.length - len) {
            throw new IllegalArgumentException("Offset plus length exceed array size");
        }
    }

    public CommandAPDU(ByteBuffer apdu) {
        byte[] bArr = new byte[apdu.remaining()];
        this.apdu = bArr;
        apdu.get(bArr);
        parse();
    }

    public CommandAPDU(int cla, int ins, int p1, int p2) {
        this(cla, ins, p1, p2, null, 0, 0, 0);
    }

    public CommandAPDU(int cla, int ins, int p1, int p2, int ne) {
        this(cla, ins, p1, p2, null, 0, 0, ne);
    }

    public CommandAPDU(int cla, int ins, int p1, int p2, byte[] data) {
        this(cla, ins, p1, p2, data, 0, arrayLength(data), 0);
    }

    public CommandAPDU(int cla, int ins, int p1, int p2, byte[] data, int dataOffset, int dataLength) {
        this(cla, ins, p1, p2, data, dataOffset, dataLength, 0);
    }

    public CommandAPDU(int cla, int ins, int p1, int p2, byte[] data, int ne) {
        this(cla, ins, p1, p2, data, 0, arrayLength(data), ne);
    }

    private static int arrayLength(byte[] b) {
        if (b != null) {
            return b.length;
        }
        return 0;
    }

    private void parse() {
        byte[] bArr = this.apdu;
        if (bArr.length < 4) {
            throw new IllegalArgumentException("apdu must be at least 4 bytes long");
        }
        if (bArr.length == 4) {
            return;
        }
        int l1 = bArr[4] & UByte.MAX_VALUE;
        if (bArr.length == 5) {
            this.f839ne = l1 != 0 ? l1 : 256;
            return;
        }
        if (l1 != 0) {
            if (bArr.length == l1 + 5) {
                this.f838nc = l1;
                this.dataOffset = 5;
                return;
            }
            if (bArr.length != l1 + 6) {
                throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + l1);
            }
            this.f838nc = l1;
            this.dataOffset = 5;
            int l2 = bArr[bArr.length - 1] & UByte.MAX_VALUE;
            this.f839ne = l2 != 0 ? l2 : 256;
            return;
        }
        if (bArr.length < 7) {
            throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + l1);
        }
        int l22 = ((bArr[5] & UByte.MAX_VALUE) << 8) | (bArr[6] & UByte.MAX_VALUE);
        if (bArr.length == 7) {
            this.f839ne = l22 != 0 ? l22 : 65536;
            return;
        }
        if (l22 == 0) {
            throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + l1 + ", b2||b3=" + l22);
        }
        if (bArr.length == l22 + 7) {
            this.f838nc = l22;
            this.dataOffset = 7;
            return;
        }
        if (bArr.length != l22 + 9) {
            throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + l1 + ", b2||b3=" + l22);
        }
        this.f838nc = l22;
        this.dataOffset = 7;
        int leOfs = bArr.length - 2;
        int l3 = (bArr[leOfs + 1] & UByte.MAX_VALUE) | ((bArr[leOfs] & UByte.MAX_VALUE) << 8);
        this.f839ne = l3 != 0 ? l3 : 65536;
    }

    public CommandAPDU(int cla, int ins, int p1, int p2, byte[] data, int dataOffset, int dataLength, int ne) {
        byte l1;
        byte l2;
        checkArrayBounds(data, dataOffset, dataLength);
        if (dataLength > 65535) {
            throw new IllegalArgumentException("dataLength is too large");
        }
        if (ne < 0) {
            throw new IllegalArgumentException("ne must not be negative");
        }
        if (ne > 65536) {
            throw new IllegalArgumentException("ne is too large");
        }
        this.f839ne = ne;
        this.f838nc = dataLength;
        if (dataLength == 0) {
            if (ne == 0) {
                this.apdu = new byte[4];
                setHeader(cla, ins, p1, p2);
                return;
            }
            if (ne <= 256) {
                byte len = ne != 256 ? (byte) ne : (byte) 0;
                this.apdu = new byte[5];
                setHeader(cla, ins, p1, p2);
                this.apdu[4] = len;
                return;
            }
            if (ne == 65536) {
                l1 = 0;
                l2 = 0;
            } else {
                l1 = (byte) (ne >> 8);
                l2 = (byte) ne;
            }
            this.apdu = new byte[7];
            setHeader(cla, ins, p1, p2);
            byte[] bArr = this.apdu;
            bArr[5] = l1;
            bArr[6] = l2;
            return;
        }
        if (ne == 0) {
            if (dataLength <= 255) {
                this.apdu = new byte[dataLength + 5];
                setHeader(cla, ins, p1, p2);
                byte[] bArr2 = this.apdu;
                bArr2[4] = (byte) dataLength;
                this.dataOffset = 5;
                System.arraycopy(data, dataOffset, bArr2, 5, dataLength);
                return;
            }
            this.apdu = new byte[dataLength + 7];
            setHeader(cla, ins, p1, p2);
            byte[] bArr3 = this.apdu;
            bArr3[4] = 0;
            bArr3[5] = (byte) (dataLength >> 8);
            bArr3[6] = (byte) dataLength;
            this.dataOffset = 7;
            System.arraycopy(data, dataOffset, bArr3, 7, dataLength);
            return;
        }
        if (dataLength > 255 || ne > 256) {
            this.apdu = new byte[dataLength + 9];
            setHeader(cla, ins, p1, p2);
            byte[] bArr4 = this.apdu;
            bArr4[4] = 0;
            bArr4[5] = (byte) (dataLength >> 8);
            bArr4[6] = (byte) dataLength;
            this.dataOffset = 7;
            System.arraycopy(data, dataOffset, bArr4, 7, dataLength);
            if (ne != 65536) {
                byte[] bArr5 = this.apdu;
                int leOfs = bArr5.length - 2;
                bArr5[leOfs] = (byte) (ne >> 8);
                bArr5[leOfs + 1] = (byte) ne;
                return;
            }
            return;
        }
        this.apdu = new byte[dataLength + 6];
        setHeader(cla, ins, p1, p2);
        byte[] bArr6 = this.apdu;
        bArr6[4] = (byte) dataLength;
        this.dataOffset = 5;
        System.arraycopy(data, dataOffset, bArr6, 5, dataLength);
        this.apdu[r5.length - 1] = ne != 256 ? (byte) ne : (byte) 0;
    }

    private void setHeader(int cla, int ins, int p1, int p2) {
        byte[] bArr = this.apdu;
        bArr[0] = (byte) cla;
        bArr[1] = (byte) ins;
        bArr[2] = (byte) p1;
        bArr[3] = (byte) p2;
    }

    public int getCLA() {
        return this.apdu[0] & UByte.MAX_VALUE;
    }

    public int getINS() {
        return this.apdu[1] & UByte.MAX_VALUE;
    }

    public int getP1() {
        return this.apdu[2] & UByte.MAX_VALUE;
    }

    public int getP2() {
        return this.apdu[3] & UByte.MAX_VALUE;
    }

    public int getNc() {
        return this.f838nc;
    }

    public byte[] getData() {
        int i = this.f838nc;
        byte[] data = new byte[i];
        System.arraycopy(this.apdu, this.dataOffset, data, 0, i);
        return data;
    }

    public int getNe() {
        return this.f839ne;
    }

    public byte[] getBytes() {
        return (byte[]) this.apdu.clone();
    }

    public String toString() {
        return "CommmandAPDU: " + this.apdu.length + " bytes, nc=" + this.f838nc + ", ne=" + this.f839ne;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandAPDU)) {
            return false;
        }
        CommandAPDU other = (CommandAPDU) obj;
        return Arrays.equals(this.apdu, other.apdu);
    }

    public int hashCode() {
        return Arrays.hashCode(this.apdu);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.apdu = (byte[]) in.readUnshared();
        parse();
    }
}
