package net.p003sf.scuba.tlv;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.p003sf.scuba.smartcards.ISO7816;

/* loaded from: classes.dex */
public class TLVUtil implements ASN1Constants {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");

    private TLVUtil() {
    }

    public static boolean isPrimitive(int tag) {
        int i = 3;
        while (i >= 0) {
            int mask = 255 << (i * 8);
            if ((tag & mask) != 0) {
                break;
            }
            i--;
        }
        int msByte = 255 & (((255 << (i * 8)) & tag) >> (i * 8));
        return (msByte & 32) == 0;
    }

    public static int getTagLength(int tag) {
        return getTagAsBytes(tag).length;
    }

    public static int getLengthLength(int length) {
        return getLengthAsBytes(length).length;
    }

    public static byte[] getTagAsBytes(int tag) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int byteCount = ((int) (Math.log(tag) / Math.log(256.0d))) + 1;
        for (int i = 0; i < byteCount; i++) {
            int pos = ((byteCount - i) - 1) * 8;
            out.write(((255 << pos) & tag) >> pos);
        }
        byte[] tagBytes = out.toByteArray();
        int tagClass = getTagClass(tag);
        if (tagClass == 1) {
            tagBytes[0] = (byte) (tagBytes[0] | 64);
        } else if (tagClass == 2) {
            tagBytes[0] = (byte) (tagBytes[0] | 128);
        } else if (tagClass == 3) {
            tagBytes[0] = (byte) (tagBytes[0] | ISO7816.INS_GET_RESPONSE);
        }
        if (!isPrimitive(tag)) {
            tagBytes[0] = (byte) (tagBytes[0] | ISO7816.INS_VERIFY);
        }
        return tagBytes;
    }

    public static byte[] getLengthAsBytes(int length) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        if (length < 128) {
            out.write(length);
        } else {
            int byteCount = log(length, 256);
            out.write(byteCount | 128);
            for (int i = 0; i < byteCount; i++) {
                int pos = ((byteCount - i) - 1) * 8;
                out.write(((255 << pos) & length) >> pos);
            }
        }
        return out.toByteArray();
    }

    public static byte[] wrapDO(int tag, byte[] data) throws IOException {
        if (data == null) {
            throw new IllegalArgumentException("Data to wrap is null");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                TLVOutputStream tlvOutputStream = new TLVOutputStream(byteArrayOutputStream);
                tlvOutputStream.writeTag(tag);
                tlvOutputStream.writeValue(data);
                tlvOutputStream.flush();
                tlvOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException ioe) {
                throw new IllegalStateException("Error writing stream", ioe);
            }
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException ioe2) {
                LOGGER.log(Level.FINE, "Error closing stream", (Throwable) ioe2);
            }
        }
    }

    public static byte[] unwrapDO(int expectedTag, byte[] wrappedData) {
        if (wrappedData == null || wrappedData.length < 2) {
            throw new IllegalArgumentException("Wrapped data is null or length < 2");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(wrappedData);
        TLVInputStream tlvInputStream = new TLVInputStream(byteArrayInputStream);
        try {
            try {
                int actualTag = tlvInputStream.readTag();
                if (actualTag != expectedTag) {
                    throw new IllegalArgumentException("Expected tag " + Integer.toHexString(expectedTag) + ", found tag " + Integer.toHexString(actualTag));
                }
                int length = tlvInputStream.readLength();
                byte[] value = tlvInputStream.readValue();
                byte[] result = new byte[length];
                System.arraycopy(value, 0, result, 0, length);
                return result;
            } catch (IOException ioe) {
                throw new IllegalStateException("Error reading from stream", ioe);
            }
        } finally {
            try {
                tlvInputStream.close();
            } catch (IOException ioe2) {
                LOGGER.log(Level.FINE, "Error closing stream", (Throwable) ioe2);
            }
        }
    }

    static int getTagClass(int tag) {
        int i = 3;
        while (i >= 0) {
            int mask = 255 << (i * 8);
            if ((tag & mask) != 0) {
                break;
            }
            i--;
        }
        int msByte = 255 & (((255 << (i * 8)) & tag) >> (i * 8));
        int i2 = msByte & 192;
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 64) {
            return 1;
        }
        if (i2 == 128) {
            return 2;
        }
        return 3;
    }

    private static int log(int n, int base) {
        int result = 0;
        while (n > 0) {
            n /= base;
            result++;
        }
        return result;
    }
}
