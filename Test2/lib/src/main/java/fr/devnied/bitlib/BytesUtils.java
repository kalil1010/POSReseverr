package fr.devnied.bitlib;

import java.math.BigInteger;
import net.p003sf.scuba.smartcards.ISO7816;

/* loaded from: classes.dex */
public final class BytesUtils {
    private static final int CHAR_DIGIT_SEVEN = 55;
    private static final int CHAR_DIGIT_ZERO = 48;
    private static final char CHAR_SPACE = ' ';
    private static final int HEXA = 16;
    private static final int LEFT_MASK = 240;
    private static final int MAX_BIT_INTEGER = 31;
    private static final int RIGHT_MASK = 15;

    public static int byteArrayToInt(byte[] byteArray) {
        if (byteArray == null) {
            throw new IllegalArgumentException("Parameter 'byteArray' cannot be null");
        }
        return byteArrayToInt(byteArray, 0, byteArray.length);
    }

    public static int byteArrayToInt(byte[] byteArray, int startPos, int length) {
        if (byteArray == null) {
            throw new IllegalArgumentException("Parameter 'byteArray' cannot be null");
        }
        if (length <= 0 || length > 4) {
            throw new IllegalArgumentException("Length must be between 1 and 4. Length = " + length);
        }
        if (startPos < 0 || byteArray.length < startPos + length) {
            throw new IllegalArgumentException("Length or startPos not valid");
        }
        int value = 0;
        for (int i = 0; i < length; i++) {
            value += (byteArray[startPos + i] & 255) << (((length - i) - 1) * 8);
        }
        return value;
    }

    public static String bytesToString(byte[] pBytes) {
        return formatByte(pBytes, true, false);
    }

    public static String bytesToString(byte[] pBytes, boolean pTruncate) {
        return formatByte(pBytes, true, pTruncate);
    }

    public static String bytesToStringNoSpace(byte pByte) {
        return formatByte(new byte[]{pByte}, false, false);
    }

    public static String bytesToStringNoSpace(byte[] pBytes) {
        return formatByte(pBytes, false, false);
    }

    public static String bytesToStringNoSpace(byte[] pBytes, boolean pTruncate) {
        return formatByte(pBytes, false, pTruncate);
    }

    private static String formatByte(byte[] pByte, boolean pSpace, boolean pTruncate) {
        if (pByte == null) {
            return "";
        }
        int i = 0;
        if (pTruncate) {
            while (i < pByte.length && pByte[i] == 0) {
                i++;
            }
        }
        if (i < pByte.length) {
            int sizeMultiplier = pSpace ? 3 : 2;
            char[] c = new char[(pByte.length - i) * sizeMultiplier];
            int j = 0;
            while (i < pByte.length) {
                byte b = (byte) ((pByte[i] & 240) >> 4);
                c[j] = (char) (b > 9 ? b + 55 : b + ISO7816.INS_DECREASE);
                byte b2 = (byte) (pByte[i] & 15);
                int j2 = j + 1;
                c[j2] = (char) (b2 > 9 ? b2 + 55 : b2 + ISO7816.INS_DECREASE);
                if (pSpace) {
                    j2++;
                    c[j2] = CHAR_SPACE;
                }
                i++;
                j = j2 + 1;
            }
            String result = pSpace ? new String(c, 0, c.length - 1) : new String(c);
            return result;
        }
        return "";
    }

    public static byte[] fromString(String pData) {
        if (pData == null) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        StringBuilder sb = new StringBuilder(pData);
        int j = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (!Character.isWhitespace(sb.charAt(i))) {
                sb.setCharAt(j, sb.charAt(i));
                j++;
            }
        }
        int i2 = sb.length();
        sb.delete(j, i2);
        if (sb.length() % 2 != 0) {
            throw new IllegalArgumentException("Hex binary needs to be even-length :" + pData);
        }
        byte[] result = new byte[sb.length() / 2];
        int j2 = 0;
        int i3 = 0;
        while (i3 < sb.length()) {
            result[j2] = (byte) ((Character.digit(sb.charAt(i3), 16) << 4) + Character.digit(sb.charAt(i3 + 1), 16));
            i3 += 2;
            j2++;
        }
        return result;
    }

    public static boolean matchBitByBitIndex(int pVal, int pBitIndex) {
        if (pBitIndex >= 0 && pBitIndex <= 31) {
            return ((1 << pBitIndex) & pVal) != 0;
        }
        throw new IllegalArgumentException("parameter 'pBitIndex' must be between 0 and 31. pBitIndex=" + pBitIndex);
    }

    public static byte setBit(byte pData, int pBitIndex, boolean pOn) {
        if (pBitIndex < 0 || pBitIndex > 7) {
            throw new IllegalArgumentException("parameter 'pBitIndex' must be between 0 and 7. pBitIndex=" + pBitIndex);
        }
        if (pOn) {
            byte ret = (byte) ((1 << pBitIndex) | pData);
            return ret;
        }
        byte ret2 = (byte) ((~(1 << pBitIndex)) & pData);
        return ret2;
    }

    public static String toBinary(byte[] pBytes) {
        if (pBytes == null || pBytes.length <= 0) {
            return null;
        }
        BigInteger val = new BigInteger(bytesToStringNoSpace(pBytes), 16);
        StringBuilder build = new StringBuilder(val.toString(2));
        for (int i = build.length(); i < pBytes.length * 8; i++) {
            build.insert(0, 0);
        }
        String ret = build.toString();
        return ret;
    }

    public static byte[] toByteArray(int value) {
        return new byte[]{(byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value};
    }

    private BytesUtils() {
    }
}
