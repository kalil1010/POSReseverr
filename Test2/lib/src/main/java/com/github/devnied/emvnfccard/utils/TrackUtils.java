package com.github.devnied.emvnfccard.utils;

import com.github.devnied.emvnfccard.model.EmvTrack1;
import com.github.devnied.emvnfccard.model.EmvTrack2;
import com.github.devnied.emvnfccard.model.Service;
import fr.devnied.bitlib.BytesUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public final class TrackUtils {
    public static final String CARD_HOLDER_NAME_SEPARATOR = "/";
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) TrackUtils.class);
    private static final Pattern TRACK2_EQUIVALENT_PATTERN = Pattern.compile("([0-9]{1,19})D([0-9]{4})([0-9]{3})?(.*)");
    private static final Pattern TRACK1_PATTERN = Pattern.compile("%?([A-Z])([0-9]{1,19})(\\?[0-9])?\\^([^\\^]{2,26})\\^([0-9]{4}|\\^)([0-9]{3}|\\^)([^\\?]+)\\??");

    public static EmvTrack2 extractTrack2EquivalentData(byte[] pRawTrack2) {
        if (pRawTrack2 == null) {
            return null;
        }
        EmvTrack2 track2 = new EmvTrack2();
        track2.setRaw(pRawTrack2);
        String data = BytesUtils.bytesToStringNoSpace(pRawTrack2);
        Matcher m = TRACK2_EQUIVALENT_PATTERN.matcher(data);
        if (!m.find()) {
            return null;
        }
        track2.setCardNumber(m.group(1));
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM", Locale.getDefault());
        try {
            track2.setExpireDate(DateUtils.truncate(sdf.parse(m.group(2)), 2));
            track2.setService(new Service(m.group(3)));
            return track2;
        } catch (ParseException e) {
            LOGGER.error("Unparsable expire card date : {}", e.getMessage());
            return null;
        }
    }

    public static EmvTrack1 extractTrack1Data(byte[] pRawTrack1) {
        if (pRawTrack1 == null) {
            return null;
        }
        EmvTrack1 track1 = new EmvTrack1();
        track1.setRaw(pRawTrack1);
        Matcher m = TRACK1_PATTERN.matcher(new String(pRawTrack1));
        if (!m.find()) {
            return null;
        }
        track1.setFormatCode(m.group(1));
        track1.setCardNumber(m.group(2));
        String[] name = StringUtils.split(m.group(4).trim(), CARD_HOLDER_NAME_SEPARATOR);
        if (name != null && name.length == 2) {
            track1.setHolderLastname(StringUtils.trimToNull(name[0]));
            track1.setHolderFirstname(StringUtils.trimToNull(name[1]));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM", Locale.getDefault());
        try {
            track1.setExpireDate(DateUtils.truncate(sdf.parse(m.group(5)), 2));
            track1.setService(new Service(m.group(6)));
            return track1;
        } catch (ParseException e) {
            LOGGER.error("Unparsable expire card date : {}", e.getMessage());
            return null;
        }
    }

    private TrackUtils() {
    }
}
