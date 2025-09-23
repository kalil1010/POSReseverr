package net.p003sf.scuba.data;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class Country implements Serializable {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    private static final Class<?>[] SUB_CLASSES = {UnicodeCountry.class, ISOCountry.class, TestCountry.class};
    private static final long serialVersionUID = 9117477643532355118L;

    public abstract String getName();

    public abstract String getNationality();

    public abstract String toAlpha2Code();

    public abstract String toAlpha3Code();

    public abstract int valueOf();

    public static Country getInstance(int code) throws NoSuchMethodException, SecurityException {
        for (Country country : values()) {
            if (country.valueOf() == code) {
                return country;
            }
        }
        throw new IllegalArgumentException("Illegal country code" + Integer.toHexString(code));
    }

    public static Country getInstance(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Illegal country code");
        }
        String code2 = code.trim();
        int length = code2.length();
        if (length == 2) {
            return fromAlpha2(code2);
        }
        if (length == 3) {
            return fromAlpha3(code2);
        }
        throw new IllegalArgumentException("Illegal country code " + code2);
    }

    public static Country[] values() throws NoSuchMethodException, SecurityException {
        List<Country> result = new ArrayList<>();
        for (Class<?> subClass : SUB_CLASSES) {
            if (Country.class.isAssignableFrom(subClass)) {
                try {
                    Method method = subClass.getMethod("values", new Class[0]);
                    Country[] subClassValues = (Country[]) method.invoke(null, new Object[0]);
                    result.addAll(Arrays.asList(subClassValues));
                } catch (Exception e) {
                    LOGGER.log(Level.WARNING, "Exception", (Throwable) e);
                }
            }
        }
        Country[] values = new Country[result.size()];
        result.toArray(values);
        return values;
    }

    private static Country fromAlpha2(String code) throws NoSuchMethodException, SecurityException {
        for (Country country : values()) {
            if (country.toAlpha2Code().equals(code)) {
                return country;
            }
        }
        throw new IllegalArgumentException("Unknown country code " + code);
    }

    private static Country fromAlpha3(String code) throws NoSuchMethodException, SecurityException {
        for (Country country : values()) {
            if (country.toAlpha3Code().equals(code)) {
                return country;
            }
        }
        throw new IllegalArgumentException("Unknown country code " + code);
    }
}
