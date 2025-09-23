package com.github.devnied.emvnfccard.utils;

import com.github.devnied.emvnfccard.model.enums.IKeyEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes.dex */
public final class EnumUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) EnumUtils.class);

    public static <T extends IKeyEnum> T getValue(int pKey, Class<T> pClass) {
        for (T t : pClass.getEnumConstants()) {
            if (t.getKey() == pKey) {
                return t;
            }
        }
        LOGGER.error("Unknow value:" + pKey + " for Enum:" + pClass.getName());
        return null;
    }

    private EnumUtils() {
    }
}
