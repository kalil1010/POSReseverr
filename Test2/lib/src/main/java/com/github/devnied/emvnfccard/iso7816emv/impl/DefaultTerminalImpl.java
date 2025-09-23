package com.github.devnied.emvnfccard.iso7816emv.impl;

import com.github.devnied.emvnfccard.iso7816emv.EmvTags;
import com.github.devnied.emvnfccard.iso7816emv.ITerminal;
import com.github.devnied.emvnfccard.iso7816emv.TagAndLength;
import com.github.devnied.emvnfccard.iso7816emv.TerminalTransactionQualifiers;
import com.github.devnied.emvnfccard.model.enums.CountryCodeEnum;
import com.github.devnied.emvnfccard.model.enums.CurrencyEnum;
import com.github.devnied.emvnfccard.model.enums.TransactionTypeEnum;
import fr.devnied.bitlib.BytesUtils;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.p003sf.scuba.smartcards.ISO7816;
import net.p003sf.scuba.smartcards.ISOFileInfo;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public final class DefaultTerminalImpl implements ITerminal {
    private static final SecureRandom random = new SecureRandom();
    private CountryCodeEnum countryCode = CountryCodeEnum.FR;

    @Override // com.github.devnied.emvnfccard.iso7816emv.ITerminal
    public byte[] constructValue(TagAndLength pTagAndLength) {
        byte[] ret = new byte[pTagAndLength.getLength()];
        byte[] val = null;
        if (pTagAndLength.getTag() == EmvTags.TERMINAL_TRANSACTION_QUALIFIERS) {
            TerminalTransactionQualifiers terminalQual = new TerminalTransactionQualifiers();
            terminalQual.setContactlessVSDCsupported(true);
            terminalQual.setContactEMVsupported(true);
            terminalQual.setMagneticStripeSupported(true);
            terminalQual.setContactlessEMVmodeSupported(true);
            terminalQual.setOnlinePINsupported(true);
            terminalQual.setReaderIsOfflineOnly(false);
            terminalQual.setSignatureSupported(true);
            terminalQual.setContactChipOfflinePINsupported(true);
            terminalQual.setIssuerUpdateProcessingSupported(true);
            terminalQual.setConsumerDeviceCVMsupported(true);
            val = terminalQual.getBytes();
        } else if (pTagAndLength.getTag() == EmvTags.TERMINAL_COUNTRY_CODE) {
            val = BytesUtils.fromString(StringUtils.leftPad(String.valueOf(this.countryCode.getNumeric()), pTagAndLength.getLength() * 2, "0"));
        } else if (pTagAndLength.getTag() == EmvTags.TRANSACTION_CURRENCY_CODE) {
            val = BytesUtils.fromString(StringUtils.leftPad(String.valueOf(CurrencyEnum.find(this.countryCode, CurrencyEnum.EUR).getISOCodeNumeric()), pTagAndLength.getLength() * 2, "0"));
        } else if (pTagAndLength.getTag() == EmvTags.TRANSACTION_DATE) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            val = BytesUtils.fromString(sdf.format(new Date()));
        } else if (pTagAndLength.getTag() == EmvTags.TRANSACTION_TYPE || pTagAndLength.getTag() == EmvTags.TERMINAL_TRANSACTION_TYPE) {
            val = new byte[]{(byte) TransactionTypeEnum.PURCHASE.getKey()};
        } else if (pTagAndLength.getTag() == EmvTags.AMOUNT_AUTHORISED_NUMERIC) {
            val = BytesUtils.fromString("01");
        } else if (pTagAndLength.getTag() == EmvTags.TERMINAL_TYPE) {
            val = new byte[]{ISO7816.INS_MSE};
        } else if (pTagAndLength.getTag() == EmvTags.TERMINAL_CAPABILITIES) {
            val = new byte[]{ISO7816.INS_CREATE_FILE, ISOFileInfo.f840A0, 0};
        } else if (pTagAndLength.getTag() == EmvTags.ADDITIONAL_TERMINAL_CAPABILITIES) {
            val = new byte[]{ISOFileInfo.CHANNEL_SECURITY, 0, ISO7816.INS_READ_BINARY, 80, 5};
        } else if (pTagAndLength.getTag() == EmvTags.DS_REQUESTED_OPERATOR_ID) {
            val = BytesUtils.fromString("7A45123EE59C7F40");
        } else if (pTagAndLength.getTag() == EmvTags.UNPREDICTABLE_NUMBER) {
            random.nextBytes(ret);
        } else if (pTagAndLength.getTag() == EmvTags.MERCHANT_TYPE_INDICATOR) {
            val = new byte[]{1};
        } else if (pTagAndLength.getTag() == EmvTags.TERMINAL_TRANSACTION_INFORMATION) {
            val = new byte[]{ISO7816.INS_GET_RESPONSE, -128, 0};
        }
        if (val != null) {
            System.arraycopy(val, 0, ret, Math.max(ret.length - val.length, 0), Math.min(val.length, ret.length));
        }
        return ret;
    }

    public void setCountryCode(CountryCodeEnum countryCode) {
        if (countryCode != null) {
            this.countryCode = countryCode;
        }
    }
}
