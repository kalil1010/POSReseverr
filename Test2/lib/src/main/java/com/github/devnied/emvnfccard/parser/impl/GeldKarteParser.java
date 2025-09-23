package com.github.devnied.emvnfccard.parser.impl;

import com.github.devnied.emvnfccard.enums.CommandEnum;
import com.github.devnied.emvnfccard.enums.EmvCardScheme;
import com.github.devnied.emvnfccard.exception.CommunicationException;
import com.github.devnied.emvnfccard.iso7816emv.EmvTags;
import com.github.devnied.emvnfccard.model.Application;
import com.github.devnied.emvnfccard.model.EmvTrack2;
import com.github.devnied.emvnfccard.model.EmvTransactionRecord;
import com.github.devnied.emvnfccard.model.enums.ApplicationStepEnum;
import com.github.devnied.emvnfccard.model.enums.CardStateEnum;
import com.github.devnied.emvnfccard.model.enums.CurrencyEnum;
import com.github.devnied.emvnfccard.model.enums.TransactionTypeEnum;
import com.github.devnied.emvnfccard.parser.EmvTemplate;
import com.github.devnied.emvnfccard.utils.CommandApdu;
import com.github.devnied.emvnfccard.utils.ResponseUtils;
import com.github.devnied.emvnfccard.utils.TlvUtil;
import fr.devnied.bitlib.BytesUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public class GeldKarteParser extends AbstractParser {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) GeldKarteParser.class);
    private static final Pattern PATTERN = Pattern.compile(StringUtils.deleteWhitespace(EmvCardScheme.GELDKARTE.getAid()[2]) + ".*");

    public GeldKarteParser(EmvTemplate pTemplate) {
        super(pTemplate);
    }

    @Override // com.github.devnied.emvnfccard.parser.IParser
    public Pattern getId() {
        return PATTERN;
    }

    @Override // com.github.devnied.emvnfccard.parser.IParser
    public boolean parse(Application pApplication) throws CommunicationException {
        byte[] data = selectAID(pApplication.getAid());
        if (!ResponseUtils.isSucceed(data)) {
            return false;
        }
        pApplication.setReadingStep(ApplicationStepEnum.SELECTED);
        byte[] logEntry = getLogEntry(data);
        pApplication.setAid(TlvUtil.getValue(data, EmvTags.DEDICATED_FILE_NAME));
        pApplication.setApplicationLabel(extractApplicationLabel(data));
        this.template.get().getCard().setType(EmvCardScheme.getCardTypeByAid(BytesUtils.bytesToStringNoSpace(pApplication.getAid())));
        extractBankData(data);
        extractEF_ID(pApplication);
        readEfBetrag(pApplication);
        readEF_BLOG(pApplication);
        pApplication.setLeftPinTry(getLeftPinTry());
        pApplication.setTransactionCounter(getTransactionCounter());
        pApplication.getListTransactions().addAll(extractLogEntry(logEntry));
        this.template.get().getCard().setState(CardStateEnum.ACTIVE);
        return true;
    }

    protected void readEF_BLOG(Application pApplication) throws CommunicationException {
        List<EmvTransactionRecord> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        for (int i = 1; i < 16; i++) {
            byte[] data = this.template.get().getProvider().transceive(new CommandApdu(CommandEnum.READ_RECORD, i, 236, 0).toBytes());
            if (!ResponseUtils.isSucceed(data)) {
                break;
            }
            if (data.length >= 35) {
                EmvTransactionRecord record = new EmvTransactionRecord();
                record.setCurrency(CurrencyEnum.EUR);
                record.setTransactionType(getType(data[0]));
                record.setAmount(Float.valueOf(Float.parseFloat(BytesUtils.bytesToStringNoSpace(Arrays.copyOfRange(data, 21, 24))) / 100.0f));
                try {
                    record.setDate(dateFormat.parse(String.format("%02x.%02x.%02x%02x", Byte.valueOf(data[32]), Byte.valueOf(data[31]), Byte.valueOf(data[29]), Byte.valueOf(data[30]))));
                    record.setTime(timeFormat.parse(String.format("%02x:%02x:%02x", Byte.valueOf(data[33]), Byte.valueOf(data[34]), Byte.valueOf(data[35]))));
                } catch (ParseException e) {
                    LOGGER.error(e.getMessage(), (Throwable) e);
                }
                list.add(record);
            }
        }
        pApplication.setListTransactions(list);
    }

    protected TransactionTypeEnum getType(byte logstate) {
        int i = (logstate & 96) >> 5;
        if (i == 0) {
            return TransactionTypeEnum.LOADED;
        }
        if (i == 1) {
            return TransactionTypeEnum.UNLOADED;
        }
        if (i == 2) {
            return TransactionTypeEnum.PURCHASE;
        }
        if (i == 3) {
            return TransactionTypeEnum.REFUND;
        }
        return null;
    }

    protected void readEfBetrag(Application pApplication) throws CommunicationException {
        byte[] data = this.template.get().getProvider().transceive(new CommandApdu(CommandEnum.READ_RECORD, 1, 196, 0).toBytes());
        if (ResponseUtils.isSucceed(data)) {
            pApplication.setAmount(Float.parseFloat(String.format("%02x%02x%02x", Byte.valueOf(data[0]), Byte.valueOf(data[1]), Byte.valueOf(data[2]))) / 100.0f);
        }
    }

    protected void extractEF_ID(Application pApplication) throws CommunicationException {
        byte[] data = this.template.get().getProvider().transceive(new CommandApdu(CommandEnum.READ_RECORD, 1, 188, 0).toBytes());
        if (ResponseUtils.isSucceed(data)) {
            pApplication.setReadingStep(ApplicationStepEnum.READ);
            SimpleDateFormat format = new SimpleDateFormat("MM/yy", Locale.getDefault());
            EmvTrack2 track2 = new EmvTrack2();
            track2.setCardNumber(BytesUtils.bytesToStringNoSpace(Arrays.copyOfRange(data, 4, 9)));
            try {
                track2.setExpireDate(format.parse(String.format("%02x/%02x", Byte.valueOf(data[11]), Byte.valueOf(data[10]))));
            } catch (ParseException e) {
                LOGGER.error(e.getMessage(), (Throwable) e);
            }
            this.template.get().getCard().setTrack2(track2);
        }
    }
}
