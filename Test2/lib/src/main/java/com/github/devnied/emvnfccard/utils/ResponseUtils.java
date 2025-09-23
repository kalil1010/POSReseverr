package com.github.devnied.emvnfccard.utils;

import com.github.devnied.emvnfccard.enums.SwEnum;
import fr.devnied.bitlib.BytesUtils;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public final class ResponseUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ResponseUtils.class);

    public static boolean isSucceed(byte[] pByte) {
        return contains(pByte, SwEnum.SW_9000);
    }

    public static boolean isEquals(byte[] pByte, SwEnum pEnum) {
        return contains(pByte, pEnum);
    }

    public static boolean contains(byte[] pByte, SwEnum... pEnum) {
        SwEnum val = SwEnum.getSW(pByte);
        if (LOGGER.isDebugEnabled() && pByte != null) {
            Logger logger = LOGGER;
            StringBuilder sb = new StringBuilder();
            sb.append("Response Status <");
            sb.append(BytesUtils.bytesToStringNoSpace(Arrays.copyOfRange(pByte, Math.max(pByte.length - 2, 0), pByte.length)));
            sb.append("> : ");
            sb.append(val != null ? val.getDetail() : "Unknow");
            logger.debug(sb.toString());
        }
        return val != null && ArrayUtils.contains(pEnum, val);
    }

    private ResponseUtils() {
    }
}
