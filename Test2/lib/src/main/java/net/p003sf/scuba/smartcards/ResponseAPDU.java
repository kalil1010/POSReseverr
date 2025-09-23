package net.p003sf.scuba.smartcards;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class ResponseAPDU implements Serializable {
    private static final long serialVersionUID = 6962744978375594225L;
    private byte[] apdu;

    public ResponseAPDU(byte[] apdu) {
        byte[] apdu2 = (byte[]) apdu.clone();
        check(apdu2);
        this.apdu = apdu2;
    }

    private static void check(byte[] apdu) {
        if (apdu.length < 2) {
            throw new IllegalArgumentException("apdu must be at least 2 bytes long");
        }
    }

    public int getNr() {
        return this.apdu.length - 2;
    }

    public byte[] getData() {
        byte[] data = new byte[r0.length - 2];
        System.arraycopy(this.apdu, 0, data, 0, data.length);
        return data;
    }

    public int getSW1() {
        return this.apdu[r0.length - 2] & UByte.MAX_VALUE;
    }

    public int getSW2() {
        return this.apdu[r0.length - 1] & UByte.MAX_VALUE;
    }

    public int getSW() {
        return (getSW1() << 8) | getSW2();
    }

    public byte[] getBytes() {
        return (byte[]) this.apdu.clone();
    }

    public String toString() {
        return "ResponseAPDU: " + this.apdu.length + " bytes, SW=" + Integer.toHexString(getSW());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseAPDU)) {
            return false;
        }
        ResponseAPDU other = (ResponseAPDU) obj;
        return Arrays.equals(this.apdu, other.apdu);
    }

    public int hashCode() {
        return Arrays.hashCode(this.apdu);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        byte[] bArr = (byte[]) in.readUnshared();
        this.apdu = bArr;
        check(bArr);
    }
}
