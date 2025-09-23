package net.p003sf.scuba.util;

import kotlin.UByte;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public final class Hex {
    private static final String HEXCHARS = "0123456789abcdefABCDEF";
    private static final boolean LEFT = true;
    private static final String PRINTABLE = " .,:;'`\"<>()[]{}?/\\!@#$%^&*_-=+|~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final boolean RIGHT = false;

    private Hex() {
    }

    public static String byteToHexString(byte b) {
        int n = b & UByte.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        sb.append(n < 16 ? "0" : "");
        sb.append(Integer.toHexString(n));
        String result = sb.toString();
        return result.toUpperCase();
    }

    public static String shortToHexString(short s) {
        int n = 65535 & s;
        StringBuilder sb = new StringBuilder();
        sb.append(n < 4096 ? "0" : "");
        sb.append(n < 256 ? "0" : "");
        sb.append(n >= 16 ? "" : "0");
        sb.append(Integer.toHexString(s));
        String result = sb.toString();
        if (result.length() > 4) {
            result = result.substring(result.length() - 4, result.length());
        }
        return result.toUpperCase();
    }

    public static String intToHexString(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n < 268435456 ? "0" : "");
        sb.append(n < 16777216 ? "0" : "");
        sb.append(n < 1048576 ? "0" : "");
        sb.append(n < 65536 ? "0" : "");
        sb.append(n < 4096 ? "0" : "");
        sb.append(n < 256 ? "0" : "");
        sb.append(n >= 16 ? "" : "0");
        sb.append(Integer.toHexString(n));
        return sb.toString().toUpperCase();
    }

    public static String bytesToHexString(byte[] text) {
        return bytesToHexString(text, 1000);
    }

    public static String bytesToHexString(byte[] text, int numRow) {
        if (text == null) {
            return "NULL";
        }
        return bytesToHexString(text, 0, text.length, numRow);
    }

    public static String toHexString(byte[] text) {
        return bytesToHexString(text, 0, text.length, 1000);
    }

    public static String toHexString(byte[] text, int numRow) {
        return bytesToHexString(text, 0, text.length, numRow);
    }

    public static String bytesToHexString(byte[] text, int offset, int length, int numRow) {
        if (text == null) {
            return "NULL";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i != 0 && i % numRow == 0) {
                result.append("\n");
            }
            result.append(byteToHexString(text[offset + i]));
        }
        return result.toString();
    }

    public static String bytesToHexString(byte[] text, int offset, int length) {
        return bytesToHexString(text, offset, length, 1000);
    }

    public static byte hexStringToByte(String text) throws NumberFormatException {
        byte[] bytes = hexStringToBytes(text);
        if (bytes == null || bytes.length != 1) {
            throw new NumberFormatException();
        }
        return bytes[0];
    }

    public static short hexStringToShort(String text) throws NumberFormatException {
        byte[] bytes = hexStringToBytes(text);
        if (bytes == null || bytes.length != 2) {
            throw new NumberFormatException();
        }
        return (short) (((bytes[0] & UByte.MAX_VALUE) << 8) | (bytes[1] & UByte.MAX_VALUE));
    }

    public static int hexStringToInt(String text) throws NumberFormatException {
        byte[] bytes = hexStringToBytes(text);
        if (bytes == null || bytes.length != 4) {
            throw new NumberFormatException();
        }
        return ((bytes[0] & UByte.MAX_VALUE) << 24) | ((bytes[1] & UByte.MAX_VALUE) << 16) | ((bytes[2] & UByte.MAX_VALUE) << 8) | (bytes[3] & UByte.MAX_VALUE);
    }

    public static byte[] hexStringToBytes(String text) throws NumberFormatException {
        if (text == null) {
            return null;
        }
        StringBuilder hexText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!Character.isWhitespace(c)) {
                if (HEXCHARS.indexOf(c) < 0) {
                    throw new NumberFormatException();
                }
                hexText.append(c);
            }
        }
        int i2 = hexText.length();
        if (i2 % 2 != 0) {
            hexText.insert(0, "0");
        }
        byte[] result = new byte[hexText.length() / 2];
        for (int i3 = 0; i3 < hexText.length(); i3 += 2) {
            int hi = hexDigitToInt(hexText.charAt(i3));
            int lo = hexDigitToInt(hexText.charAt(i3 + 1));
            result[i3 / 2] = (byte) (((hi & 255) << 4) | (lo & 255));
        }
        return result;
    }

    static int hexDigitToInt(char c) throws NumberFormatException {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                switch (c) {
                    case 'A':
                        return 10;
                    case 'B':
                        return 11;
                    case 'C':
                        return 12;
                    case 'D':
                        return 13;
                    case 'E':
                        return 14;
                    case 'F':
                        return 15;
                    default:
                        switch (c) {
                            case 'a':
                                return 10;
                            case 'b':
                                return 11;
                            case 'c':
                                return 12;
                            case 'd':
                                return 13;
                            case 'e':
                                return 14;
                            case 'f':
                                return 15;
                            default:
                                throw new NumberFormatException();
                        }
                }
        }
    }

    private static String pad(String txt, int width, char padChar, boolean left) {
        StringBuilder result = new StringBuilder();
        int txtLength = txt.length();
        if (txtLength >= width) {
            return txt;
        }
        int padLength = width - txtLength;
        for (int i = 0; i < padLength; i++) {
            result.append(padChar);
        }
        if (left) {
            result.append(txt);
            return result.toString();
        }
        return txt + result.toString();
    }

    public static String bytesToSpacedHexString(byte[] data) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < data.length) {
            result.append(byteToHexString(data[i]));
            result.append(i < data.length + (-1) ? StringUtils.SPACE : "");
            i++;
        }
        return result.toString().toUpperCase();
    }

    private static String[] bytesToSpacedHexStrings(byte[] data, int columns, int padWidth) {
        byte[][] src = split(data, columns);
        String[] result = new String[src.length];
        for (int j = 0; j < src.length; j++) {
            result[j] = pad(bytesToSpacedHexString(src[j]), padWidth, ' ', false);
        }
        return result;
    }

    public static String bytesToASCIIString(byte[] data) {
        StringBuilder result = new StringBuilder();
        for (byte element : data) {
            char c = (char) element;
            result.append(Character.toString(PRINTABLE.indexOf(c) >= 0 ? c : '.'));
        }
        return result.toString();
    }

    static String[] bytesToASCIIStrings(byte[] data, int columns) {
        byte[][] src = split(data, columns);
        String[] result = new String[src.length];
        for (int j = 0; j < src.length; j++) {
            result[j] = bytesToASCIIString(src[j]);
        }
        return result;
    }

    public static byte[][] split(byte[] src, int width) {
        int rows = src.length / width;
        int rest = src.length % width;
        byte[][] dest = new byte[(rest > 0 ? 1 : 0) + rows][];
        int k = 0;
        for (int j = 0; j < rows; j++) {
            dest[j] = new byte[width];
            System.arraycopy(src, k, dest[j], 0, width);
            k += width;
        }
        if (rest > 0) {
            dest[rows] = new byte[rest];
            System.arraycopy(src, k, dest[rows], 0, rest);
        }
        return dest;
    }

    public static String bytesToPrettyString(byte[] data) {
        return bytesToPrettyString(data, 16, LEFT, 4, null, LEFT);
    }

    public static String bytesToPrettyString(byte[] data, int columns, boolean useIndex, int indexPadWidth, String altIndex, boolean useASCII) {
        StringBuilder result = new StringBuilder();
        String[] hexStrings = bytesToSpacedHexStrings(data, columns, columns * 3);
        String[] asciiStrings = bytesToASCIIStrings(data, columns);
        int j = 0;
        while (j < hexStrings.length) {
            if (useIndex) {
                String prefix = Integer.toHexString(j * columns).toUpperCase();
                result.append(pad(prefix, indexPadWidth, '0', LEFT) + ": ");
            } else {
                String prefix2 = j == 0 ? altIndex : "";
                result.append(pad(prefix2, indexPadWidth, ' ', LEFT) + StringUtils.SPACE);
            }
            result.append(hexStrings[j]);
            if (useASCII) {
                result.append(StringUtils.SPACE + asciiStrings[j]);
            }
            result.append("\n");
            j++;
        }
        return result.toString();
    }
}
