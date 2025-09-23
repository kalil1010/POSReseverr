package fr.devnied.bitlib;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import kotlin.UByte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public final class BitUtils {
    public static final int BYTE_SIZE = 8;
    public static final float BYTE_SIZE_F = 8.0f;
    public static final String DATE_FORMAT = "yyyyMMdd";
    private static final int DEFAULT_VALUE = 255;
    private final byte[] byteTab;
    private int currentBitIndex;
    private final int size;
    private static final Logger LOGGER = LoggerFactory.getLogger(BitUtils.class.getName());
    private static final Charset DEFAULT_CHARSET = Charset.forName("ASCII");

    public BitUtils(byte[] pByte) {
        byte[] bArr = new byte[pByte.length];
        this.byteTab = bArr;
        System.arraycopy(pByte, 0, bArr, 0, pByte.length);
        this.size = pByte.length * 8;
    }

    public BitUtils(int pSize) {
        this.byteTab = new byte[(int) Math.ceil(pSize / 8.0f)];
        this.size = pSize;
    }

    public void addCurrentBitIndex(int pIndex) {
        int i = this.currentBitIndex + pIndex;
        this.currentBitIndex = i;
        if (i < 0) {
            this.currentBitIndex = 0;
        }
    }

    public int getCurrentBitIndex() {
        return this.currentBitIndex;
    }

    public byte[] getData() {
        byte[] bArr = this.byteTab;
        byte[] ret = new byte[bArr.length];
        System.arraycopy(bArr, 0, ret, 0, bArr.length);
        return ret;
    }

    public byte getMask(int pIndex, int pLength) {
        byte ret = (byte) ((((byte) ((-1) << pIndex)) & UByte.MAX_VALUE) >> pIndex);
        int dec = 8 - (pLength + pIndex);
        if (dec > 0) {
            return (byte) (((byte) (ret >> dec)) << dec);
        }
        return ret;
    }

    public boolean getNextBoolean() {
        if (getNextInteger(1) != 1) {
            return false;
        }
        return true;
    }

    public byte[] getNextByte(int pSize) {
        return getNextByte(pSize, true);
    }

    public byte[] getNextByte(int pSize, boolean pShift) {
        byte[] tab = new byte[(int) Math.ceil(pSize / 8.0f)];
        int i = this.currentBitIndex;
        if (i % 8 != 0) {
            int index = 0;
            int max = i + pSize;
            while (true) {
                int i2 = this.currentBitIndex;
                if (i2 >= max) {
                    break;
                }
                int mod = i2 % 8;
                int modTab = index % 8;
                int length = Math.min(max - i2, Math.min(8 - mod, 8 - modTab));
                byte val = (byte) (this.byteTab[this.currentBitIndex / 8] & getMask(mod, length));
                if (pShift || pSize % 8 == 0) {
                    if (mod != 0) {
                        val = (byte) (val << Math.min(mod, 8 - length));
                    } else {
                        val = (byte) ((val & UByte.MAX_VALUE) >> modTab);
                    }
                }
                int i3 = index / 8;
                tab[i3] = (byte) (tab[i3] | val);
                this.currentBitIndex += length;
                index += length;
            }
            if (!pShift && pSize % 8 != 0) {
                tab[tab.length - 1] = (byte) (getMask(((max - pSize) - 1) % 8, 8) & tab[tab.length - 1]);
            }
        } else {
            System.arraycopy(this.byteTab, i / 8, tab, 0, tab.length);
            int val2 = pSize % 8;
            if (val2 == 0) {
                val2 = 8;
            }
            tab[tab.length - 1] = (byte) (getMask(this.currentBitIndex % 8, val2) & tab[tab.length - 1]);
            this.currentBitIndex += pSize;
        }
        return tab;
    }

    public Date getNextDate(int pSize, String pPattern) {
        return getNextDate(pSize, pPattern, false);
    }

    public Date getNextDate(int pSize, String pPattern, boolean pUseBcd) {
        String dateTxt;
        SimpleDateFormat sdf = new SimpleDateFormat(pPattern);
        if (pUseBcd) {
            dateTxt = getNextHexaString(pSize);
        } else {
            dateTxt = getNextString(pSize);
        }
        try {
            Date date = sdf.parse(dateTxt);
            return date;
        } catch (ParseException e) {
            LOGGER.error("Parsing date error. date:" + dateTxt + " pattern:" + pPattern, (Throwable) e);
            return null;
        }
    }

    public String getNextHexaString(int pSize) {
        return BytesUtils.bytesToStringNoSpace(getNextByte(pSize, true));
    }

    public long getNextLongSigned(int pLength) {
        if (pLength > 64) {
            throw new IllegalArgumentException("Long overflow with length > 64");
        }
        long decimal = getNextLong(pLength);
        long signMask = 1 << (pLength - 1);
        if ((decimal & signMask) != 0) {
            return -(signMask - (signMask ^ decimal));
        }
        return decimal;
    }

    public int getNextIntegerSigned(int pLength) {
        if (pLength > 32) {
            throw new IllegalArgumentException("Integer overflow with length > 32");
        }
        return (int) getNextLongSigned(pLength);
    }

    public long getNextLong(int pLength) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        long finalValue = 0;
        int readSize = pLength;
        int max = this.currentBitIndex + pLength;
        while (true) {
            int i = this.currentBitIndex;
            if (i < max) {
                int mod = i % 8;
                long currentValue = this.byteTab[i / 8] & getMask(mod, readSize) & 255;
                int dec = Math.max(8 - (mod + readSize), 0);
                finalValue = (finalValue << Math.min(readSize, 8)) | (((currentValue & 255) >>> dec) & 255);
                int val = 8 - mod;
                readSize -= val;
                this.currentBitIndex = Math.min(this.currentBitIndex + val, max);
            } else {
                buffer.putLong(finalValue);
                buffer.rewind();
                return buffer.getLong();
            }
        }
    }

    public int getNextInteger(int pLength) {
        return (int) getNextLong(pLength);
    }

    public String getNextString(int pSize) {
        return getNextString(pSize, DEFAULT_CHARSET);
    }

    public String getNextString(int pSize, Charset pCharset) {
        return new String(getNextByte(pSize, true), pCharset);
    }

    public int getSize() {
        return this.size;
    }

    public void reset() {
        setCurrentBitIndex(0);
    }

    public void clear() {
        Arrays.fill(this.byteTab, (byte) 0);
        reset();
    }

    public void resetNextBits(int pLength) {
        int max = this.currentBitIndex + pLength;
        while (true) {
            int i = this.currentBitIndex;
            if (i < max) {
                int mod = i % 8;
                int length = Math.min(max - i, 8 - mod);
                byte[] bArr = this.byteTab;
                int i2 = this.currentBitIndex / 8;
                bArr[i2] = (byte) (bArr[i2] & (~getMask(mod, length)));
                this.currentBitIndex += length;
            } else {
                return;
            }
        }
    }

    public void setCurrentBitIndex(int pCurrentBitIndex) {
        this.currentBitIndex = pCurrentBitIndex;
    }

    public void setNextBoolean(boolean pBoolean) {
        if (!pBoolean) {
            setNextInteger(0, 1);
        } else {
            setNextInteger(1, 1);
        }
    }

    public void setNextByte(byte[] pValue, int pLength) {
        setNextByte(pValue, pLength, true);
    }

    public void setNextByte(byte[] pValue, int pLength, boolean pPadBefore) {
        int iMin;
        int totalSize = (int) Math.ceil(pLength / 8.0f);
        ByteBuffer buffer = ByteBuffer.allocate(totalSize);
        int size = Math.max(totalSize - pValue.length, 0);
        if (pPadBefore) {
            for (int i = 0; i < size; i++) {
                buffer.put((byte) 0);
            }
        }
        int i2 = pValue.length;
        buffer.put(pValue, 0, Math.min(totalSize, i2));
        if (!pPadBefore) {
            for (int i3 = 0; i3 < size; i3++) {
                buffer.put((byte) 0);
            }
        }
        byte[] tab = buffer.array();
        int i4 = this.currentBitIndex;
        if (i4 % 8 != 0) {
            int index = 0;
            int max = i4 + pLength;
            while (true) {
                int i5 = this.currentBitIndex;
                if (i5 < max) {
                    int mod = i5 % 8;
                    int modTab = index % 8;
                    int length = Math.min(max - i5, Math.min(8 - mod, 8 - modTab));
                    byte val = (byte) (tab[index / 8] & getMask(modTab, length));
                    if (mod == 0) {
                        iMin = val << Math.min(modTab, 8 - length);
                    } else {
                        iMin = (val & UByte.MAX_VALUE) >> mod;
                    }
                    byte val2 = (byte) iMin;
                    byte[] bArr = this.byteTab;
                    int i6 = this.currentBitIndex;
                    int i7 = i6 / 8;
                    bArr[i7] = (byte) (bArr[i7] | val2);
                    this.currentBitIndex = i6 + length;
                    index += length;
                } else {
                    return;
                }
            }
        } else {
            System.arraycopy(tab, 0, this.byteTab, i4 / 8, tab.length);
            this.currentBitIndex += pLength;
        }
    }

    public void setNextDate(Date pValue, String pPattern) {
        setNextDate(pValue, pPattern, false);
    }

    public void setNextDate(Date pValue, String pPattern, boolean pUseBcd) {
        SimpleDateFormat sdf = new SimpleDateFormat(pPattern);
        String value = sdf.format(pValue);
        if (pUseBcd) {
            setNextHexaString(value, value.length() * 4);
        } else {
            setNextString(value, value.length() * 8);
        }
    }

    public void setNextHexaString(String pValue, int pLength) {
        setNextByte(BytesUtils.fromString(pValue), pLength);
    }

    public void setNextLong(long pValue, int pLength) {
        if (pLength > 64) {
            throw new IllegalArgumentException("Long overflow with length > 64");
        }
        setNextValue(pValue, pLength, 63);
    }

    protected void setNextValue(long pValue, int pLength, int pMaxSize) {
        byte ret;
        long value = pValue;
        long bitMax = (long) Math.pow(2.0d, Math.min(pLength, pMaxSize));
        if (pValue > bitMax) {
            value = bitMax - 1;
        }
        int writeSize = pLength;
        while (writeSize > 0) {
            int mod = this.currentBitIndex % 8;
            if ((mod == 0 && writeSize <= 8) || pLength < 8 - mod) {
                ret = (byte) (value << (8 - (writeSize + mod)));
            } else {
                long length = Long.toBinaryString(value).length();
                ret = (byte) (value >> ((int) ((writeSize - length) - ((8 - length) - mod))));
            }
            byte[] bArr = this.byteTab;
            int i = this.currentBitIndex / 8;
            bArr[i] = (byte) (bArr[i] | ret);
            long val = Math.min(writeSize, 8 - mod);
            writeSize = (int) (writeSize - val);
            this.currentBitIndex = (int) (this.currentBitIndex + val);
        }
    }

    public void setNextInteger(int pValue, int pLength) {
        if (pLength > 32) {
            throw new IllegalArgumentException("Integer overflow with length > 32");
        }
        setNextValue(pValue, pLength, 31);
    }

    public void setNextString(String pValue, int pLength) {
        setNextString(pValue, pLength, true);
    }

    public void setNextString(String pValue, int pLength, boolean pPaddedBefore) {
        setNextByte(pValue.getBytes(Charset.defaultCharset()), pLength, pPaddedBefore);
    }
}
