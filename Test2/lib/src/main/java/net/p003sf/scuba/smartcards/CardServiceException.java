package net.p003sf.scuba.smartcards;

/* loaded from: classes.dex */
public class CardServiceException extends Exception {
    public static final int SW_NONE = -1;
    private static final long serialVersionUID = 4489156194716970879L;

    /* renamed from: sw */
    private final int f837sw;

    public CardServiceException(String msg) {
        this(msg, -1);
    }

    public CardServiceException(String msg, int sw) {
        super(msg);
        this.f837sw = sw;
    }

    public CardServiceException(String msg, Throwable cause) {
        this(msg, cause, getSW(cause));
    }

    public CardServiceException(String msg, Throwable cause, int sw) {
        super(msg, cause);
        this.f837sw = sw;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.f837sw == -1) {
            return super.getMessage();
        }
        return super.getMessage() + " (SW = 0x" + Integer.toHexString(this.f837sw).toUpperCase() + ": " + statusWordToString((short) this.f837sw) + ")";
    }

    public int getSW() {
        return this.f837sw;
    }

    private static int getSW(Throwable cause) {
        if (cause instanceof CardServiceException) {
            return ((CardServiceException) cause).getSW();
        }
        return -1;
    }

    private static String statusWordToString(short sw) {
        switch (sw) {
            case -28672:
                return "NO ERROR";
            case 25218:
                return "END OF FILE";
            case 25223:
                return "LESS DATA RESPONDED THAN REQUESTED";
            case 26368:
                return "WRONG LENGTH";
            case 27033:
                return "APPLET SELECT FAILED";
            case 27073:
                return "KEY USAGE ERROR";
            case 27270:
                return "INCORRECT P1P2";
            case 27272:
                return "KEY NOT FOUND";
            case 27392:
                return "WRONG P1P2";
            case 27904:
                return "INS NOT SUPPORTED";
            case 28160:
                return "CLA NOT SUPPORTED";
            case 28416:
                return "UNKNOWN";
            case 28671:
                return "CARD TERMINATED";
            default:
                switch (sw) {
                    case 26753:
                        return "LOGICAL CHANNEL NOT SUPPORTED";
                    case 26754:
                        return "SECURE MESSAGING NOT SUPPORTED";
                    case 26755:
                        return "LAST COMMAND EXPECTED";
                    default:
                        switch (sw) {
                            case 27010:
                                return "SECURITY STATUS NOT SATISFIED";
                            case 27011:
                                return "FILE INVALID";
                            case 27012:
                                return "DATA INVALID";
                            case 27013:
                                return "CONDITIONS NOT SATISFIED";
                            case 27014:
                                return "COMMAND NOT ALLOWED";
                            case 27015:
                                return "EXPECTED SM DATA OBJECTS MISSING";
                            case 27016:
                                return "SM DATA OBJECTS INCORRECT";
                            default:
                                switch (sw) {
                                    case 27264:
                                        return "WRONG DATA or FILEHEADER INCONSISTENT";
                                    case 27265:
                                        return "FUNC NOT SUPPORTED";
                                    case 27266:
                                        return "FILE NOT FOUND";
                                    case 27267:
                                        return "RECORD NOT FOUND";
                                    case 27268:
                                        return "OUT OF MEMORY or FILE FULL";
                                    default:
                                        if ((sw & 65280) == 24832) {
                                            return "BYTES REMAINING " + Integer.toString(sw & 255);
                                        }
                                        if ((65280 & sw) == 27648) {
                                            return "CORRECT LENGTH " + Integer.toString(sw & 255);
                                        }
                                        if ((65520 & sw) == 25536) {
                                            return "NON VOLATILE MEMORY CHANGED COUNT " + Integer.toString(sw & 15);
                                        }
                                        return "Unknown";
                                }
                        }
                }
        }
    }
}
