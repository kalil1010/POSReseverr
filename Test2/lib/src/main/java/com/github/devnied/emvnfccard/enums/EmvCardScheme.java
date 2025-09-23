package com.github.devnied.emvnfccard.enums;

import fr.devnied.bitlib.BytesUtils;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public enum EmvCardScheme {
    VISA("VISA", "^4[0-9]{6,}$", "A0 00 00 00 03", "A0 00 00 00 03 10 10", "A0 00 00 00 98 08 48"),
    MASTER_CARD("Master card", "^5[1-5][0-9]{5,}$", "A0 00 00 00 04", "A0 00 00 00 05"),
    AMERICAN_EXPRESS("American express", "^3[47][0-9]{5,}$", "A0 00 00 00 25"),
    CB("CB", null, "A0 00 00 00 42"),
    LINK("LINK", null, "A0 00 00 00 29"),
    JCB("JCB", "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$", "A0 00 00 00 65"),
    DANKORT("Dankort", null, "A0 00 00 01 21 10 10"),
    COGEBAN("CoGeBan", null, "A0 00 00 01 41 00 01"),
    DISCOVER("Discover", "(6011|65|64[4-9]|622)[0-9]*", "A0 00 00 01 52 30 10"),
    BANRISUL("Banrisul", null, "A0 00 00 01 54"),
    SPAN("Saudi Payments Network", null, "A0 00 00 02 28"),
    INTERAC("Interac", null, "A0 00 00 02 77"),
    ZIP("Discover Card", null, "A0 00 00 03 24"),
    UNIONPAY("UnionPay", "^62[0-9]{14,17}", "A0 00 00 03 33"),
    EAPS("Euro Alliance of Payment Schemes", null, "A0 00 00 03 59"),
    VERVE("Verve", null, "A0 00 00 03 71"),
    TENN("The Exchange Network ATM Network", null, "A0 00 00 04 39"),
    RUPAY("Rupay", null, "A0 00 00 05 24 10 10"),
    f879100("ПРО100", null, "A0 00 00 04 32 00 01"),
    GELDKARTE("GeldKarte/ZKA", null, "D2 76 00 00 25 45 50 02 00", "D2 76 00 00 25 45 50 01 00", "D2 76 00 00 25"),
    BANKAXEPT("Bankaxept", null, "D5 78 00 00 02 10 10"),
    BRADESCO("BRADESCO", null, "F0 00 00 00 03 00 01"),
    MIDLAND("Midland", null, "A0 00 00 00 24 01"),
    PBS("PBS", null, "A0 00 00 01 21 10 10"),
    ETRANZACT("eTranzact", null, "A0 00 00 04 54"),
    GOOGLE("Google", null, "A0 00 00 04 76 6C"),
    INTER_SWITCH("InterSwitch", null, "A0 00 00 03 71 00 01");

    private final String[] aids;
    private final byte[][] aidsByte;
    private final String name;
    private final Pattern pattern;

    EmvCardScheme(String pScheme, String pRegex, String... pAids) {
        this.aids = pAids;
        this.aidsByte = new byte[pAids.length][];
        for (int i = 0; i < this.aids.length; i++) {
            this.aidsByte[i] = BytesUtils.fromString(pAids[i]);
        }
        this.name = pScheme;
        if (StringUtils.isNotBlank(pRegex)) {
            this.pattern = Pattern.compile(pRegex);
        } else {
            this.pattern = null;
        }
    }

    public String[] getAid() {
        return this.aids;
    }

    public String getName() {
        return this.name;
    }

    public static EmvCardScheme getCardTypeByAid(String pAid) {
        EmvCardScheme ret = null;
        if (pAid != null) {
            String aid = StringUtils.deleteWhitespace(pAid);
            for (EmvCardScheme val : values()) {
                String[] aid2 = val.getAid();
                int length = aid2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        String schemeAid = aid2[i];
                        if (!aid.startsWith(StringUtils.deleteWhitespace(schemeAid))) {
                            i++;
                        } else {
                            ret = val;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static EmvCardScheme getCardTypeByCardNumber(String pCardNumber) {
        if (pCardNumber == null) {
            return null;
        }
        for (EmvCardScheme val : values()) {
            Pattern pattern = val.pattern;
            if (pattern != null && pattern.matcher(StringUtils.deleteWhitespace(pCardNumber)).matches()) {
                return val;
            }
        }
        return null;
    }

    public byte[][] getAidByte() {
        return this.aidsByte;
    }
}
