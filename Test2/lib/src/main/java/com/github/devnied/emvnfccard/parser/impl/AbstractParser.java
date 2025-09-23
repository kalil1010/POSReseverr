package com.github.devnied.emvnfccard.parser.impl;

import com.github.devnied.emvnfccard.enums.CommandEnum;
import com.github.devnied.emvnfccard.exception.CommunicationException;
import com.github.devnied.emvnfccard.iso7816emv.EmvTags;
import com.github.devnied.emvnfccard.iso7816emv.TagAndLength;
import com.github.devnied.emvnfccard.parser.EmvTemplate;
import com.github.devnied.emvnfccard.parser.IParser;
import com.github.devnied.emvnfccard.utils.CommandApdu;
import com.github.devnied.emvnfccard.utils.ResponseUtils;
import com.github.devnied.emvnfccard.utils.TlvUtil;
import com.github.devnied.emvnfccard.utils.TrackUtils;
import fr.devnied.bitlib.BytesUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public abstract class AbstractParser implements IParser {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) AbstractParser.class);
    public static final int UNKNOW = -1;
    protected final WeakReference<EmvTemplate> template;

    protected AbstractParser(EmvTemplate pTemplate) {
        this.template = new WeakReference<>(pTemplate);
    }

    protected byte[] selectAID(byte[] pAid) throws CommunicationException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Select AID: " + BytesUtils.bytesToString(pAid));
        }
        return this.template.get().getProvider().transceive(new CommandApdu(CommandEnum.SELECT, pAid, 0).toBytes());
    }

    protected String extractApplicationLabel(byte[] pData) throws IOException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Extract Application label");
        }
        byte[] labelByte = TlvUtil.getValue(pData, EmvTags.APPLICATION_PREFERRED_NAME);
        if (labelByte == null) {
            labelByte = TlvUtil.getValue(pData, EmvTags.APPLICATION_LABEL);
        }
        if (labelByte == null) {
            return null;
        }
        String label = new String(labelByte);
        return label;
    }

    protected void extractBankData(byte[] pData) throws IOException {
        byte[] bic = TlvUtil.getValue(pData, EmvTags.BANK_IDENTIFIER_CODE);
        if (bic != null) {
            this.template.get().getCard().setBic(new String(bic));
        }
        byte[] iban = TlvUtil.getValue(pData, EmvTags.IBAN);
        if (iban != null) {
            this.template.get().getCard().setIban(new String(iban));
        }
    }

    protected void extractCardHolderName(byte[] pData) throws IOException {
        String[] name;
        byte[] cardHolderByte = TlvUtil.getValue(pData, EmvTags.CARDHOLDER_NAME);
        if (cardHolderByte != null && (name = StringUtils.split(new String(cardHolderByte).trim(), TrackUtils.CARD_HOLDER_NAME_SEPARATOR)) != null && name.length > 0) {
            this.template.get().getCard().setHolderLastname(StringUtils.trimToNull(name[0]));
            if (name.length == 2) {
                this.template.get().getCard().setHolderFirstname(StringUtils.trimToNull(name[1]));
            }
        }
    }

    protected byte[] getLogEntry(byte[] pSelectResponse) {
        return TlvUtil.getValue(pSelectResponse, EmvTags.LOG_ENTRY, EmvTags.VISA_LOG_ENTRY);
    }

    protected int getTransactionCounter() throws CommunicationException {
        byte[] val;
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get Transaction Counter ATC");
        }
        byte[] data = this.template.get().getProvider().transceive(new CommandApdu(CommandEnum.GET_DATA, 159, 54, 0).toBytes());
        if (!ResponseUtils.isSucceed(data) || (val = TlvUtil.getValue(data, EmvTags.APP_TRANSACTION_COUNTER)) == null) {
            return -1;
        }
        int ret = BytesUtils.byteArrayToInt(val);
        return ret;
    }

    protected int getLeftPinTry() throws CommunicationException {
        byte[] val;
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get Left PIN try");
        }
        byte[] data = this.template.get().getProvider().transceive(new CommandApdu(CommandEnum.GET_DATA, 159, 23, 0).toBytes());
        if (!ResponseUtils.isSucceed(data) || (val = TlvUtil.getValue(data, EmvTags.PIN_TRY_COUNTER)) == null) {
            return -1;
        }
        int ret = BytesUtils.byteArrayToInt(val);
        return ret;
    }

    protected List<TagAndLength> getLogFormat() throws IOException {
        List<TagAndLength> ret = new ArrayList<>();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("GET log format");
        }
        byte[] data = this.template.get().getProvider().transceive(new CommandApdu(CommandEnum.GET_DATA, 159, 79, 0).toBytes());
        if (!ResponseUtils.isSucceed(data)) {
            LOGGER.warn("No Log format found");
            return ret;
        }
        List<TagAndLength> ret2 = TlvUtil.parseTagAndLength(TlvUtil.getValue(data, EmvTags.LOG_FORMAT));
        return ret2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093 A[Catch: Exception -> 0x00a3, TryCatch #0 {Exception -> 0x00a3, blocks: (B:14:0x0051, B:16:0x005f, B:18:0x006e, B:19:0x007e, B:21:0x0084, B:24:0x0093, B:26:0x009a, B:27:0x009f), top: B:33:0x0051 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.util.List<com.github.devnied.emvnfccard.model.EmvTransactionRecord> extractLogEntry(byte[] r9) throws com.github.devnied.emvnfccard.exception.CommunicationException {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.ref.WeakReference<com.github.devnied.emvnfccard.parser.EmvTemplate> r1 = r8.template
            java.lang.Object r1 = r1.get()
            com.github.devnied.emvnfccard.parser.EmvTemplate r1 = (com.github.devnied.emvnfccard.parser.EmvTemplate) r1
            com.github.devnied.emvnfccard.parser.EmvTemplate$Config r1 = r1.getConfig()
            boolean r1 = r1.readTransactions
            if (r1 == 0) goto Lc2
            if (r9 == 0) goto Lc2
            java.util.List r1 = r8.getLogFormat()
            if (r1 == 0) goto Lc2
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto Lc2
            r2 = 1
        L24:
            r3 = 1
            r3 = r9[r3]
            if (r2 > r3) goto Lc2
            java.lang.ref.WeakReference<com.github.devnied.emvnfccard.parser.EmvTemplate> r3 = r8.template
            java.lang.Object r3 = r3.get()
            com.github.devnied.emvnfccard.parser.EmvTemplate r3 = (com.github.devnied.emvnfccard.parser.EmvTemplate) r3
            com.github.devnied.emvnfccard.parser.IProvider r3 = r3.getProvider()
            com.github.devnied.emvnfccard.utils.CommandApdu r4 = new com.github.devnied.emvnfccard.utils.CommandApdu
            com.github.devnied.emvnfccard.enums.CommandEnum r5 = com.github.devnied.emvnfccard.enums.CommandEnum.READ_RECORD
            r6 = 0
            r7 = r9[r6]
            int r7 = r7 << 3
            r7 = r7 | 4
            r4.<init>(r5, r2, r7, r6)
            byte[] r4 = r4.toBytes()
            byte[] r3 = r3.transceive(r4)
            boolean r4 = com.github.devnied.emvnfccard.utils.ResponseUtils.isSucceed(r3)
            if (r4 == 0) goto Lc2
            com.github.devnied.emvnfccard.model.EmvTransactionRecord r4 = new com.github.devnied.emvnfccard.model.EmvTransactionRecord     // Catch: java.lang.Exception -> La3
            r4.<init>()     // Catch: java.lang.Exception -> La3
            r4.parse(r3, r1)     // Catch: java.lang.Exception -> La3
            java.lang.Float r5 = r4.getAmount()     // Catch: java.lang.Exception -> La3
            if (r5 == 0) goto L93
            java.lang.Float r5 = r4.getAmount()     // Catch: java.lang.Exception -> La3
            float r5 = r5.floatValue()     // Catch: java.lang.Exception -> La3
            r6 = 1320341598(0x4eb2d05e, float:1.5E9)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L7e
            java.lang.Float r5 = r4.getAmount()     // Catch: java.lang.Exception -> La3
            float r5 = r5.floatValue()     // Catch: java.lang.Exception -> La3
            float r5 = r5 - r6
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch: java.lang.Exception -> La3
            r4.setAmount(r5)     // Catch: java.lang.Exception -> La3
        L7e:
            java.lang.Float r5 = r4.getAmount()     // Catch: java.lang.Exception -> La3
            if (r5 == 0) goto L92
            java.lang.Float r5 = r4.getAmount()     // Catch: java.lang.Exception -> La3
            float r5 = r5.floatValue()     // Catch: java.lang.Exception -> La3
            r6 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L93
        L92:
            goto Lbe
        L93:
            com.github.devnied.emvnfccard.model.enums.CurrencyEnum r5 = r4.getCurrency()     // Catch: java.lang.Exception -> La3
            if (r5 != 0) goto L9f
            com.github.devnied.emvnfccard.model.enums.CurrencyEnum r5 = com.github.devnied.emvnfccard.model.enums.CurrencyEnum.XXX     // Catch: java.lang.Exception -> La3
            r4.setCurrency(r5)     // Catch: java.lang.Exception -> La3
        L9f:
            r0.add(r4)     // Catch: java.lang.Exception -> La3
            goto Lbe
        La3:
            r4 = move-exception
            org.slf4j.Logger r5 = com.github.devnied.emvnfccard.parser.impl.AbstractParser.LOGGER
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Error in transaction format: "
            r6.append(r7)
            java.lang.String r7 = r4.getMessage()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.error(r6, r4)
        Lbe:
            int r2 = r2 + 1
            goto L24
        Lc2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.devnied.emvnfccard.parser.impl.AbstractParser.extractLogEntry(byte[]):java.util.List");
    }
}
