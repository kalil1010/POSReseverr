package com.github.devnied.emvnfccard.utils;

import com.github.devnied.emvnfccard.enums.TagValueTypeEnum;
import com.github.devnied.emvnfccard.exception.TlvException;
import com.github.devnied.emvnfccard.iso7816emv.EmvTags;
import com.github.devnied.emvnfccard.iso7816emv.ITag;
import com.github.devnied.emvnfccard.iso7816emv.TLV;
import com.github.devnied.emvnfccard.iso7816emv.TagAndLength;
import fr.devnied.bitlib.BytesUtils;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import net.p003sf.scuba.tlv.TLVInputStream;
import net.p003sf.scuba.tlv.TLVUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p006io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public final class TlvUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) TlvUtil.class);

    private static ITag searchTagById(int tagId) {
        return EmvTags.getNotNull(TLVUtil.getTagAsBytes(tagId));
    }

    public static String getFormattedTagAndLength(byte[] data, int indentLength) throws IOException {
        StringBuilder buf = new StringBuilder();
        String indent = getSpaces(indentLength);
        TLVInputStream stream = new TLVInputStream(new ByteArrayInputStream(data));
        boolean firstLine = true;
        while (stream.available() > 0) {
            try {
                try {
                    if (firstLine) {
                        firstLine = false;
                    } else {
                        buf.append("\n");
                    }
                    buf.append(indent);
                    ITag tag = searchTagById(stream.readTag());
                    int length = stream.readLength();
                    buf.append(prettyPrintHex(tag.getTagBytes()));
                    buf.append(StringUtils.SPACE);
                    buf.append(String.format("%02x", Integer.valueOf(length)));
                    buf.append(" -- ");
                    buf.append(tag.getName());
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), (Throwable) e);
                }
            } finally {
                IOUtils.closeQuietly((InputStream) stream);
            }
        }
        return buf.toString();
    }

    public static TLV getNextTLV(TLVInputStream stream) throws IOException {
        int left;
        TLV tlv = null;
        try {
            try {
                try {
                    left = stream.available();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), (Throwable) e);
                }
            } catch (EOFException eof) {
                LOGGER.debug(eof.getMessage(), (Throwable) eof);
            }
            if (left <= 2) {
                return null;
            }
            ITag tag = searchTagById(stream.readTag());
            int length = stream.readLength();
            if (stream.available() >= length) {
                tlv = new TLV(tag, length, TLVUtil.getLengthAsBytes(length), stream.readValue());
            }
            return tlv;
        } finally {
            IOUtils.closeQuietly((InputStream) stream);
        }
    }

    private static String getTagValueAsString(ITag tag, byte[] value) {
        StringBuilder buf = new StringBuilder();
        int i = C03191.$SwitchMap$com$github$devnied$emvnfccard$enums$TagValueTypeEnum[tag.getTagValueType().ordinal()];
        if (i == 1) {
            buf.append("=");
            buf.append(new String(value));
        } else if (i == 2) {
            buf.append("NUMERIC");
        } else if (i == 3) {
            buf.append("BINARY");
        } else if (i == 4) {
            buf.append("=");
            buf.append(getSafePrintChars(value));
        } else if (i == 5) {
            buf.append("");
        }
        return buf.toString();
    }

    /* renamed from: com.github.devnied.emvnfccard.utils.TlvUtil$1 */
    static /* synthetic */ class C03191 {
        static final /* synthetic */ int[] $SwitchMap$com$github$devnied$emvnfccard$enums$TagValueTypeEnum;

        static {
            int[] iArr = new int[TagValueTypeEnum.values().length];
            $SwitchMap$com$github$devnied$emvnfccard$enums$TagValueTypeEnum = iArr;
            try {
                iArr[TagValueTypeEnum.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$github$devnied$emvnfccard$enums$TagValueTypeEnum[TagValueTypeEnum.NUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$github$devnied$emvnfccard$enums$TagValueTypeEnum[TagValueTypeEnum.BINARY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$github$devnied$emvnfccard$enums$TagValueTypeEnum[TagValueTypeEnum.MIXED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$github$devnied$emvnfccard$enums$TagValueTypeEnum[TagValueTypeEnum.DOL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static List<TagAndLength> parseTagAndLength(byte[] data) throws IOException {
        List<TagAndLength> tagAndLengthList = new ArrayList<>();
        if (data != null) {
            TLVInputStream stream = new TLVInputStream(new ByteArrayInputStream(data));
            while (stream.available() > 0) {
                try {
                    try {
                        if (stream.available() < 2) {
                            throw new TlvException("Data length < 2 : " + stream.available());
                        }
                        ITag tag = searchTagById(stream.readTag());
                        int tagValueLength = stream.readLength();
                        tagAndLengthList.add(new TagAndLength(tag, tagValueLength));
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), (Throwable) e);
                    }
                } finally {
                    IOUtils.closeQuietly((InputStream) stream);
                }
            }
        }
        return tagAndLengthList;
    }

    public static String prettyPrintAPDUResponse(byte[] data) {
        return prettyPrintAPDUResponse(data, 0);
    }

    public static List<TLV> getlistTLV(byte[] pData, ITag pTag, boolean pAdd) throws IOException {
        TLV tlv;
        List<TLV> list = new ArrayList<>();
        TLVInputStream stream = new TLVInputStream(new ByteArrayInputStream(pData));
        while (stream.available() > 0 && (tlv = getNextTLV(stream)) != null) {
            try {
                try {
                    if (pAdd) {
                        list.add(tlv);
                    } else if (tlv.getTag().isConstructed()) {
                        list.addAll(getlistTLV(tlv.getValueBytes(), pTag, tlv.getTag() == pTag));
                    }
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), (Throwable) e);
                }
            } finally {
                IOUtils.closeQuietly((InputStream) stream);
            }
        }
        return list;
    }

    public static List<TLV> getlistTLV(byte[] pData, ITag... pTag) {
        TLV tlv;
        List<TLV> list = new ArrayList<>();
        TLVInputStream stream = new TLVInputStream(new ByteArrayInputStream(pData));
        while (stream.available() > 0 && (tlv = getNextTLV(stream)) != null) {
            try {
                try {
                    if (ArrayUtils.contains(pTag, tlv.getTag())) {
                        list.add(tlv);
                    } else if (tlv.getTag().isConstructed()) {
                        list.addAll(getlistTLV(tlv.getValueBytes(), pTag));
                    }
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), (Throwable) e);
                }
            } finally {
                IOUtils.closeQuietly((InputStream) stream);
            }
        }
        return list;
    }

    public static byte[] getValue(byte[] pData, ITag... pTag) throws IOException {
        TLV tlv;
        byte[] ret = null;
        if (pData != null) {
            TLVInputStream stream = new TLVInputStream(new ByteArrayInputStream(pData));
            while (stream.available() > 0 && (tlv = getNextTLV(stream)) != null) {
                try {
                    try {
                        if (!ArrayUtils.contains(pTag, tlv.getTag())) {
                            if (tlv.getTag().isConstructed() && (ret = getValue(tlv.getValueBytes(), pTag)) != null) {
                                break;
                            }
                        } else {
                            return tlv.getValueBytes();
                        }
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), (Throwable) e);
                    }
                } finally {
                    IOUtils.closeQuietly((InputStream) stream);
                }
            }
        }
        return ret;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
    
        r1.setLength(0);
        com.github.devnied.emvnfccard.utils.TlvUtil.LOGGER.debug("TLV format error");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String prettyPrintAPDUResponse(byte[] r12, int r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.devnied.emvnfccard.utils.TlvUtil.prettyPrintAPDUResponse(byte[], int):java.lang.String");
    }

    public static String getSpaces(int length) {
        return StringUtils.leftPad("", length);
    }

    public static String prettyPrintHex(String in, int indent) {
        return prettyPrintHex(in, indent, true);
    }

    public static String prettyPrintHex(byte[] data) {
        return prettyPrintHex(BytesUtils.bytesToStringNoSpace(data), 0, true);
    }

    public static String prettyPrintHex(String in, int indent, boolean wrapLines) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            buf.append(c);
            int nextPos = i + 1;
            if (wrapLines && nextPos % 32 == 0 && nextPos != in.length()) {
                buf.append("\n");
                buf.append(getSpaces(indent));
            } else if (nextPos % 2 == 0 && nextPos != in.length()) {
                buf.append(StringUtils.SPACE);
            }
        }
        return buf.toString();
    }

    public static String getSafePrintChars(byte[] byteArray) {
        if (byteArray == null) {
            return "";
        }
        return getSafePrintChars(byteArray, 0, byteArray.length);
    }

    public static String getSafePrintChars(byte[] byteArray, int startPos, int length) {
        if (byteArray == null) {
            return "";
        }
        if (byteArray.length < startPos + length) {
            throw new IllegalArgumentException("startPos(" + startPos + ")+length(" + length + ") > byteArray.length(" + byteArray.length + ")");
        }
        StringBuilder buf = new StringBuilder();
        for (int i = startPos; i < startPos + length; i++) {
            if (byteArray[i] >= 32 && byteArray[i] < 127) {
                buf.append((char) byteArray[i]);
            } else {
                buf.append(".");
            }
        }
        return buf.toString();
    }

    public static int getLength(List<TagAndLength> pList) {
        int ret = 0;
        if (pList != null) {
            for (TagAndLength tl : pList) {
                ret += tl.getLength();
            }
        }
        return ret;
    }

    private TlvUtil() {
    }
}
