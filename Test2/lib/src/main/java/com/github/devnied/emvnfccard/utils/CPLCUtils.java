package com.github.devnied.emvnfccard.utils;

import com.github.devnied.emvnfccard.enums.TagValueTypeEnum;
import com.github.devnied.emvnfccard.iso7816emv.ITag;
import com.github.devnied.emvnfccard.iso7816emv.impl.TagImpl;
import com.github.devnied.emvnfccard.model.CPLC;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public final class CPLCUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CPLCUtils.class);
    private static final ITag CPLC_TAG = new TagImpl("9f7f", TagValueTypeEnum.BINARY, "Card Production Life Cycle Data", "");

    public static CPLC parse(byte[] raw) throws IOException {
        byte[] cplc;
        if (raw == null) {
            return null;
        }
        if (raw.length == 44) {
            cplc = raw;
        } else if (raw.length == 47) {
            cplc = TlvUtil.getValue(raw, CPLC_TAG);
        } else {
            LOGGER.error("CPLC data not valid");
            return null;
        }
        CPLC ret = new CPLC();
        ret.parse(cplc, null);
        return ret;
    }

    private CPLCUtils() {
    }
}
