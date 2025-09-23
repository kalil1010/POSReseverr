package net.p003sf.scuba.smartcards;

import java.math.BigInteger;
import net.p003sf.scuba.util.Hex;

/* loaded from: classes.dex */
public class ISOFileInfo extends FileInfo {

    /* renamed from: A0 */
    public static final byte f840A0 = -96;

    /* renamed from: A1 */
    public static final byte f841A1 = -95;

    /* renamed from: A2 */
    public static final byte f842A2 = -94;

    /* renamed from: A5 */
    public static final byte f843A5 = -91;

    /* renamed from: AB */
    public static final byte f844AB = -85;

    /* renamed from: AC */
    public static final byte f845AC = -84;
    public static final byte CHANNEL_SECURITY = -114;
    public static final byte DATA_BYTES1 = -128;
    public static final byte DATA_BYTES2 = -127;
    public static final byte DF_NAME = -124;
    public static final byte ENV_TEMP_EF = -115;
    public static final byte FCI_BYTE = 111;
    public static final byte FCI_EXT = -121;
    public static final byte FCP_BYTE = 98;
    public static final byte FILE_DESCRIPTOR = -126;
    public static final byte FILE_IDENTIFIER = -125;
    public static final byte FMD_BYTE = 100;
    public static final byte LCS_BYTE = -118;
    public static final byte PROP_INFO = -123;
    public static final byte SECURITY_ATTR_COMPACT = -116;
    public static final byte SECURITY_ATTR_EXP = -117;
    public static final byte SECURITY_ATTR_PROP = -122;
    public static final byte SHORT_EF = -120;

    /* renamed from: a0 */
    byte[] f846a0;

    /* renamed from: a1 */
    byte[] f847a1;

    /* renamed from: a2 */
    byte[] f848a2;

    /* renamed from: a5 */
    byte[] f849a5;

    /* renamed from: ab */
    byte[] f850ab;

    /* renamed from: ac */
    byte[] f851ac;
    byte channelSecurity;
    byte dataCodingByte;
    byte descriptorByte;
    byte[] dfName;
    short envTempEF;
    short fciExt;
    short fid;
    int fileLength;
    int fileLengthFCI;
    byte lcsByte;
    byte mainTag;
    short maxRecordSize;
    short maxRecordsCount;
    byte[] propInfo;
    byte[] secAttrCompact;
    byte[] secAttrExp;
    byte[] secAttrProp;
    byte shortEF;

    public ISOFileInfo(byte[] bArr) throws CardServiceException {
        char c;
        int offset;
        int i;
        byte[] contents;
        int off;
        this.mainTag = (byte) -1;
        this.fileLength = -1;
        this.fileLengthFCI = -1;
        this.descriptorByte = (byte) -1;
        this.dataCodingByte = (byte) -1;
        this.maxRecordSize = (short) -1;
        this.maxRecordsCount = (short) -1;
        this.fid = (short) -1;
        this.dfName = null;
        this.propInfo = null;
        this.secAttrProp = null;
        this.secAttrExp = null;
        this.secAttrCompact = null;
        this.fciExt = (short) -1;
        this.envTempEF = (short) -1;
        this.shortEF = (byte) -1;
        this.lcsByte = (byte) -1;
        this.channelSecurity = (byte) -1;
        this.f846a0 = null;
        this.f847a1 = null;
        this.f848a2 = null;
        this.f849a5 = null;
        this.f850ab = null;
        this.f851ac = null;
        if (bArr.length == 0) {
            return;
        }
        if (bArr[0] != 'o' && bArr[0] != 'b' && bArr[0] != 'd') {
            throw new CardServiceException("Malformed FCI data");
        }
        this.mainTag = bArr[0];
        byte[] bArr2 = new byte[bArr[1]];
        System.arraycopy(bArr, 2, bArr2, 0, bArr[1]);
        int offset2 = 0;
        while (offset2 < bArr2.length) {
            try {
                int offset3 = offset2 + 1;
                try {
                    c = bArr2[offset2];
                    offset = offset3 + 1;
                    try {
                        i = bArr2[offset3];
                        contents = new byte[i];
                        System.arraycopy(bArr2, offset, contents, 0, i);
                        offset += i;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                } catch (ArrayIndexOutOfBoundsException e2) {
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
            }
            if (c == 65445) {
                byte[] bArr3 = new byte[contents.length];
                this.f849a5 = bArr3;
                System.arraycopy(contents, 0, bArr3, 0, contents.length);
            } else if (c == 65451) {
                byte[] bArr4 = new byte[contents.length];
                this.f850ab = bArr4;
                System.arraycopy(contents, 0, bArr4, 0, contents.length);
            } else if (c != 65452) {
                switch (c) {
                    case 65408:
                        BigInteger integer = new BigInteger(contents);
                        this.fileLength = integer.abs().intValue();
                        break;
                    case 65409:
                        checkLen(i, 2);
                        BigInteger integer2 = new BigInteger(contents);
                        this.fileLengthFCI = integer2.intValue();
                        break;
                    case 65410:
                        checkLen(i, 1, 6);
                        int off2 = 0 + 1;
                        try {
                            this.descriptorByte = contents[0];
                            if (off2 != contents.length) {
                                int off3 = off2 + 1;
                                this.dataCodingByte = contents[off2];
                                if (off3 == contents.length) {
                                    break;
                                } else {
                                    if (contents.length != 3) {
                                        byte[] bArr5 = new byte[2];
                                        int off4 = off3 + 1;
                                        bArr5[0] = contents[off3];
                                        off = off4 + 1;
                                        bArr5[1] = contents[off4];
                                        BigInteger integer3 = new BigInteger(bArr5);
                                        this.maxRecordSize = integer3.shortValue();
                                    } else {
                                        int off5 = off3 + 1;
                                        this.maxRecordSize = contents[off3];
                                        off = off5;
                                    }
                                    if (off == contents.length) {
                                        break;
                                    } else if (contents.length != 5) {
                                        byte[] bArr6 = new byte[2];
                                        int off6 = off + 1;
                                        try {
                                            bArr6[0] = contents[off];
                                            int i2 = off6 + 1;
                                            bArr6[1] = contents[off6];
                                            BigInteger integer4 = new BigInteger(bArr6);
                                            this.maxRecordsCount = integer4.shortValue();
                                            break;
                                        } catch (ArrayIndexOutOfBoundsException e4) {
                                            break;
                                        }
                                    } else {
                                        int i3 = off + 1;
                                        this.maxRecordsCount = contents[off];
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException e5) {
                            break;
                        }
                    case 65411:
                        checkLen(i, 2);
                        BigInteger integer5 = new BigInteger(contents);
                        this.fid = integer5.shortValue();
                        break;
                    case 65412:
                        checkLen(i, 0, 16);
                        byte[] bArr7 = new byte[contents.length];
                        this.dfName = bArr7;
                        System.arraycopy(contents, 0, bArr7, 0, contents.length);
                        break;
                    case 65413:
                        byte[] bArr8 = new byte[contents.length];
                        this.propInfo = bArr8;
                        System.arraycopy(contents, 0, bArr8, 0, contents.length);
                        break;
                    case 65414:
                        byte[] bArr9 = new byte[contents.length];
                        this.secAttrProp = bArr9;
                        System.arraycopy(contents, 0, bArr9, 0, contents.length);
                        break;
                    case 65415:
                        checkLen(i, 2);
                        BigInteger integer6 = new BigInteger(contents);
                        this.fciExt = integer6.shortValue();
                        break;
                    case 65416:
                        checkLen(i, 0, 1);
                        if (i == 0) {
                            this.shortEF = (byte) 0;
                            break;
                        } else {
                            this.shortEF = contents[0];
                            break;
                        }
                    default:
                        switch (c) {
                            case 65418:
                                checkLen(i, 1);
                                this.lcsByte = contents[0];
                                continue;
                            case 65419:
                                byte[] bArr10 = new byte[contents.length];
                                this.secAttrExp = bArr10;
                                System.arraycopy(contents, 0, bArr10, 0, contents.length);
                                continue;
                            case 65420:
                                byte[] bArr11 = new byte[contents.length];
                                this.secAttrCompact = bArr11;
                                System.arraycopy(contents, 0, bArr11, 0, contents.length);
                                continue;
                            case 65421:
                                checkLen(i, 2);
                                BigInteger integer7 = new BigInteger(contents);
                                this.envTempEF = integer7.shortValue();
                                continue;
                            case 65422:
                                checkLen(i, 1);
                                this.channelSecurity = contents[0];
                                continue;
                            default:
                                switch (c) {
                                    case 65440:
                                        byte[] bArr12 = new byte[contents.length];
                                        this.f846a0 = bArr12;
                                        System.arraycopy(contents, 0, bArr12, 0, contents.length);
                                        continue;
                                    case 65441:
                                        byte[] bArr13 = new byte[contents.length];
                                        this.f847a1 = bArr13;
                                        System.arraycopy(contents, 0, bArr13, 0, contents.length);
                                        continue;
                                    case 65442:
                                        byte[] bArr14 = new byte[contents.length];
                                        this.f848a2 = bArr14;
                                        System.arraycopy(contents, 0, bArr14, 0, contents.length);
                                        continue;
                                        continue;
                                    default:
                                        throw new CardServiceException("Malformed FCI: unrecognized tag.");
                                }
                        }
                        throw new CardServiceException("Malformed FCI.");
                }
            } else {
                byte[] bArr15 = new byte[contents.length];
                this.f851ac = bArr15;
                System.arraycopy(contents, 0, bArr15, 0, contents.length);
            }
            offset2 = offset;
        }
    }

    private static void checkLen(int len, int value) throws CardServiceException {
        if (len != value) {
            throw new CardServiceException("Malformed FCI.");
        }
    }

    private static void checkLen(int len, int minValue, int maxValue) throws CardServiceException {
        if (len < minValue || len > maxValue) {
            throw new CardServiceException("Malformed FCI.");
        }
    }

    public byte[] getFormatted() throws NumberFormatException {
        String x;
        String x2;
        byte[] result = new byte[0];
        if (this.mainTag == -1) {
            return result;
        }
        int i = this.fileLength;
        if (i != -1) {
            byte[] piece = getArray((byte) -128, Hex.hexStringToBytes(Hex.shortToHexString((short) i)));
            result = catArray(result, piece);
        }
        int i2 = this.fileLengthFCI;
        if (i2 != -1) {
            byte[] piece2 = getArray(DATA_BYTES2, Hex.hexStringToBytes(Hex.shortToHexString((short) i2)));
            result = catArray(result, piece2);
        }
        byte b = this.descriptorByte;
        if (b != -1) {
            byte[] ar1 = {b};
            byte[] ar2 = new byte[0];
            byte b2 = this.dataCodingByte;
            if (b2 != -1) {
                ar2 = new byte[]{b2};
            }
            byte[] ar3 = new byte[0];
            short s = this.maxRecordSize;
            if (s != -1) {
                if (s <= 256 && this.maxRecordsCount == -1) {
                    x2 = Hex.byteToHexString((byte) s);
                } else {
                    x2 = Hex.shortToHexString(s);
                }
                ar3 = Hex.hexStringToBytes(x2);
            }
            byte[] ar4 = new byte[0];
            short s2 = this.maxRecordsCount;
            if (s2 != -1) {
                if (s2 <= 256) {
                    x = Hex.byteToHexString((byte) s2);
                } else {
                    x = Hex.shortToHexString(s2);
                }
                ar4 = Hex.hexStringToBytes(x);
            }
            byte[] piece3 = getArray((byte) -126, catArray(catArray(catArray(ar1, ar2), ar3), ar4));
            result = catArray(result, piece3);
        }
        short s3 = this.fid;
        if (s3 != -1) {
            byte[] piece4 = getArray(FILE_IDENTIFIER, Hex.hexStringToBytes(Hex.shortToHexString(s3)));
            result = catArray(result, piece4);
        }
        byte[] bArr = this.dfName;
        if (bArr != null) {
            byte[] piece5 = getArray((byte) -124, bArr);
            result = catArray(result, piece5);
        }
        byte[] bArr2 = this.propInfo;
        if (bArr2 != null) {
            byte[] piece6 = getArray(PROP_INFO, bArr2);
            result = catArray(result, piece6);
        }
        byte[] bArr3 = this.secAttrProp;
        if (bArr3 != null) {
            byte[] piece7 = getArray((byte) -122, bArr3);
            result = catArray(result, piece7);
        }
        short s4 = this.fciExt;
        if (s4 != -1) {
            byte[] piece8 = getArray(FCI_EXT, Hex.hexStringToBytes(Hex.shortToHexString(s4)));
            result = catArray(result, piece8);
        }
        byte b3 = this.shortEF;
        if (b3 != -1) {
            byte[] piece9 = getArray((byte) -120, b3 == 0 ? new byte[0] : new byte[]{b3});
            result = catArray(result, piece9);
        }
        byte b4 = this.lcsByte;
        if (b4 != -1) {
            byte[] piece10 = getArray(LCS_BYTE, new byte[]{b4});
            result = catArray(result, piece10);
        }
        byte[] bArr4 = this.secAttrExp;
        if (bArr4 != null) {
            byte[] piece11 = getArray(SECURITY_ATTR_EXP, bArr4);
            result = catArray(result, piece11);
        }
        byte[] bArr5 = this.secAttrCompact;
        if (bArr5 != null) {
            byte[] piece12 = getArray(SECURITY_ATTR_COMPACT, bArr5);
            result = catArray(result, piece12);
        }
        short s5 = this.envTempEF;
        if (s5 != -1) {
            byte[] piece13 = getArray(ENV_TEMP_EF, Hex.hexStringToBytes(Hex.shortToHexString(s5)));
            result = catArray(result, piece13);
        }
        byte b5 = this.channelSecurity;
        if (b5 != -1) {
            byte[] piece14 = getArray(CHANNEL_SECURITY, new byte[]{b5});
            result = catArray(result, piece14);
        }
        byte[] bArr6 = this.f846a0;
        if (bArr6 != null) {
            byte[] piece15 = getArray(f840A0, bArr6);
            result = catArray(result, piece15);
        }
        byte[] bArr7 = this.f847a1;
        if (bArr7 != null) {
            byte[] piece16 = getArray(f841A1, bArr7);
            result = catArray(result, piece16);
        }
        byte[] bArr8 = this.f848a2;
        if (bArr8 != null) {
            byte[] piece17 = getArray((byte) -94, bArr8);
            result = catArray(result, piece17);
        }
        byte[] bArr9 = this.f849a5;
        if (bArr9 != null) {
            byte[] piece18 = getArray(f843A5, bArr9);
            result = catArray(result, piece18);
        }
        byte[] bArr10 = this.f850ab;
        if (bArr10 != null) {
            byte[] piece19 = getArray(f844AB, bArr10);
            result = catArray(result, piece19);
        }
        byte[] bArr11 = this.f851ac;
        if (bArr11 != null) {
            byte[] piece20 = getArray((byte) -84, bArr11);
            result = catArray(result, piece20);
        }
        return getArray(this.mainTag, result);
    }

    private static byte[] getArray(byte tag, byte[] contents) {
        byte[] result = new byte[contents.length + 2];
        result[0] = tag;
        result[1] = (byte) contents.length;
        System.arraycopy(contents, 0, result, 2, contents.length);
        return result;
    }

    private static byte[] catArray(byte[] a1, byte[] a2) {
        byte[] result = new byte[a1.length + a2.length];
        System.arraycopy(a1, 0, result, 0, a1.length);
        System.arraycopy(a2, 0, result, a1.length, a2.length);
        return result;
    }

    public String toString() {
        return "Length: " + this.fileLength + "\nLength FCI: " + this.fileLengthFCI + "\nDesc byte: " + ((int) this.descriptorByte) + "\nData byte: " + ((int) this.dataCodingByte) + "\nRecord size: " + ((int) this.maxRecordSize) + "\nRecord count: " + ((int) this.maxRecordsCount) + "\nFID: " + Hex.shortToHexString(this.fid) + "\nDF name: " + Hex.bytesToHexString(this.dfName) + "\npropInfo: " + Hex.bytesToHexString(this.propInfo) + "\nsecAttrProp: " + Hex.bytesToHexString(this.secAttrProp) + "\nsecAttrExp: " + Hex.bytesToHexString(this.secAttrExp) + "\nsecAttrComp: " + Hex.bytesToHexString(this.secAttrCompact) + "\nFCI ext: " + Hex.shortToHexString(this.fciExt) + "\nEF env temp: " + Hex.shortToHexString(this.envTempEF) + "\nShort EF: " + Hex.byteToHexString(this.shortEF) + "\nLCS byte: " + Hex.byteToHexString(this.lcsByte) + "\nChannel sec: " + Hex.byteToHexString(this.channelSecurity) + "\na0: " + Hex.bytesToHexString(this.f846a0) + "\na1: " + Hex.bytesToHexString(this.f847a1) + "\na2: " + Hex.bytesToHexString(this.f848a2) + "\na5: " + Hex.bytesToHexString(this.f849a5) + "\nab: " + Hex.bytesToHexString(this.f850ab) + "\nac: " + Hex.bytesToHexString(this.f851ac) + "\n";
    }

    @Override // net.p003sf.scuba.smartcards.FileInfo
    public short getFID() {
        return this.fid;
    }

    @Override // net.p003sf.scuba.smartcards.FileInfo
    public int getFileLength() {
        return this.fileLength;
    }
}
