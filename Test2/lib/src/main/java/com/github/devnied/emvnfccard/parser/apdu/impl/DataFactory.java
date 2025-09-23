package com.github.devnied.emvnfccard.parser.apdu.impl;

import com.github.devnied.emvnfccard.model.enums.IKeyEnum;
import com.github.devnied.emvnfccard.parser.apdu.annotation.AnnotationData;
import com.github.devnied.emvnfccard.utils.EnumUtils;
import fr.devnied.bitlib.BitUtils;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public final class DataFactory {
    public static final int BCD_DATE = 1;
    public static final String BCD_FORMAT = "BCD_Format";
    public static final int CPCL_DATE = 2;
    public static final int HALF_BYTE_SIZE = 4;
    public static final Logger LOGGER = LoggerFactory.getLogger(DataFactory.class.getName());

    private static Date getDate(AnnotationData pAnnotation, BitUtils pBit) throws IllegalArgumentException {
        if (pAnnotation.getDateStandard() == 1) {
            Date date = pBit.getNextDate(pAnnotation.getSize(), pAnnotation.getFormat(), true);
            return date;
        }
        if (pAnnotation.getDateStandard() == 2) {
            Date date2 = calculateCplcDate(pBit.getNextByte(pAnnotation.getSize()));
            return date2;
        }
        Date date3 = pBit.getNextDate(pAnnotation.getSize(), pAnnotation.getFormat());
        return date3;
    }

    public static Date calculateCplcDate(byte[] dateBytes) throws IllegalArgumentException {
        if (dateBytes == null || dateBytes.length != 2) {
            throw new IllegalArgumentException("Error! CLCP Date values consist always of exactly 2 bytes");
        }
        if (dateBytes[0] == 0 && dateBytes[1] == 0) {
            return null;
        }
        Calendar now = Calendar.getInstance();
        int currenctYear = now.get(1);
        int startYearOfCurrentDecade = currenctYear - (currenctYear % 10);
        int days = ((dateBytes[0] & 15) * 100) + (((dateBytes[1] >>> 4) & 15) * 10) + (dateBytes[1] & 15);
        if (days > 366) {
            throw new IllegalArgumentException("Invalid date (or are we parsing it wrong??)");
        }
        Calendar calculatedDate = Calendar.getInstance();
        calculatedDate.clear();
        int year = ((dateBytes[0] >>> 4) & 15) + startYearOfCurrentDecade;
        calculatedDate.set(1, year);
        calculatedDate.set(6, days);
        while (calculatedDate.after(now)) {
            year -= 10;
            calculatedDate.clear();
            calculatedDate.set(1, year);
            calculatedDate.set(6, days);
        }
        return calculatedDate.getTime();
    }

    private static int getInteger(AnnotationData pAnnotation, BitUtils pBit) {
        return pBit.getNextInteger(pAnnotation.getSize());
    }

    public static Object getObject(AnnotationData pAnnotation, BitUtils pBit) {
        Class<?> clazz = pAnnotation.getField().getType();
        if (clazz.equals(Integer.class)) {
            Object obj = Integer.valueOf(getInteger(pAnnotation, pBit));
            return obj;
        }
        if (clazz.equals(Float.class)) {
            Object obj2 = getFloat(pAnnotation, pBit);
            return obj2;
        }
        if (clazz.equals(String.class)) {
            Object obj3 = getString(pAnnotation, pBit);
            return obj3;
        }
        if (clazz.equals(Date.class)) {
            Object obj4 = getDate(pAnnotation, pBit);
            return obj4;
        }
        if (!clazz.isEnum()) {
            return null;
        }
        Object obj5 = getEnum(pAnnotation, pBit);
        return obj5;
    }

    private static Float getFloat(AnnotationData pAnnotation, BitUtils pBit) {
        if (BCD_FORMAT.equals(pAnnotation.getFormat())) {
            Float ret = Float.valueOf(Float.parseFloat(pBit.getNextHexaString(pAnnotation.getSize())));
            return ret;
        }
        Float ret2 = Float.valueOf(getInteger(pAnnotation, pBit));
        return ret2;
    }

    private static IKeyEnum getEnum(AnnotationData pAnnotation, BitUtils pBit) throws NumberFormatException {
        int val = 0;
        try {
            val = Integer.parseInt(pBit.getNextHexaString(pAnnotation.getSize()), pAnnotation.isReadHexa() ? 16 : 10);
        } catch (NumberFormatException e) {
        }
        return EnumUtils.getValue(val, pAnnotation.getField().getType());
    }

    private static String getString(AnnotationData pAnnotation, BitUtils pBit) {
        if (pAnnotation.isReadHexa()) {
            String obj = pBit.getNextHexaString(pAnnotation.getSize());
            return obj;
        }
        String obj2 = pBit.getNextString(pAnnotation.getSize()).trim();
        return obj2;
    }

    private DataFactory() {
    }
}
