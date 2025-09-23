package net.p003sf.scuba.tlv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.p003sf.scuba.util.Hex;

/* loaded from: classes.dex */
class ASN1Util implements ASN1Constants {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    private static final String SDF = "yyMMddhhmmss'Z'";

    private ASN1Util() {
    }

    static Object interpretPrimitiveValue(int tag, byte[] valueBytes) {
        SimpleDateFormat sdf = new SimpleDateFormat(SDF);
        if (TLVUtil.getTagClass(tag) != 0) {
            return valueBytes;
        }
        if (tag != 12 && tag != 30 && tag != 19 && tag != 20 && tag != 22) {
            if (tag != 23) {
                switch (tag) {
                }
                return valueBytes;
            }
            try {
                return sdf.parse(new String(valueBytes));
            } catch (ParseException pe) {
                LOGGER.log(Level.WARNING, "Parse exception parsing UTC time", (Throwable) pe);
                return valueBytes;
            }
        }
        return new String(valueBytes);
    }

    static String tagToString(int tag) {
        if (TLVUtil.getTagClass(tag) != 0) {
            return "'0x" + Hex.intToHexString(tag) + "'";
        }
        if (TLVUtil.isPrimitive(tag)) {
            int i = tag & 31;
            if (i == 9) {
                return "REAL";
            }
            if (i == 12) {
                return "UTF_STRING";
            }
            if (i == 30) {
                return "BMP_STRING";
            }
            if (i == 19) {
                return "PRINTABLE_STRING";
            }
            if (i != 20) {
                switch (i) {
                    case 1:
                        return "BOOLEAN";
                    case 2:
                        return "INTEGER";
                    case 3:
                        return "BIT_STRING";
                    case 4:
                        return "OCTET_STRING";
                    case 5:
                        return "NULL";
                    case 6:
                        return "OBJECT_IDENTIFIER";
                    default:
                        switch (i) {
                            case 22:
                                return "IA5_STRING";
                            case 23:
                                return "UTC_TIME";
                            case 24:
                                return "GENERAL_TIME";
                            default:
                                switch (i) {
                                    case 26:
                                        return "VISIBLE_STRING";
                                    case 27:
                                        return "GENERAL_STRING";
                                    case 28:
                                        return "UNIVERSAL_STRING";
                                }
                        }
                }
            }
            return "T61_STRING";
        }
        int i2 = tag & 31;
        if (i2 == 10) {
            return "ENUMERATED";
        }
        if (i2 == 16) {
            return "SEQUENCE";
        }
        if (i2 == 17) {
            return "SET";
        }
        return "'0x" + Hex.intToHexString(tag) + "'";
    }
}
