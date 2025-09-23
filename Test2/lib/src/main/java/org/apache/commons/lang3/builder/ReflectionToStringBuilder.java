package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes.dex */
public class ReflectionToStringBuilder extends ToStringBuilder {
    private boolean appendStatics;
    private boolean appendTransients;
    protected String[] excludeFieldNames;
    private boolean excludeNullValues;
    private Class<?> upToClass;

    public static String toString(Object object) {
        return toString(object, null, false, false, null);
    }

    public static String toString(Object object, ToStringStyle style) {
        return toString(object, style, false, false, null);
    }

    public static String toString(Object object, ToStringStyle style, boolean outputTransients) {
        return toString(object, style, outputTransients, false, null);
    }

    public static String toString(Object object, ToStringStyle style, boolean outputTransients, boolean outputStatics) {
        return toString(object, style, outputTransients, outputStatics, null);
    }

    public static <T> String toString(T object, ToStringStyle style, boolean outputTransients, boolean outputStatics, Class<? super T> reflectUpToClass) {
        return new ReflectionToStringBuilder(object, style, null, reflectUpToClass, outputTransients, outputStatics).toString();
    }

    public static <T> String toString(T object, ToStringStyle style, boolean outputTransients, boolean outputStatics, boolean excludeNullValues, Class<? super T> reflectUpToClass) {
        return new ReflectionToStringBuilder(object, style, null, reflectUpToClass, outputTransients, outputStatics, excludeNullValues).toString();
    }

    public static String toStringExclude(Object object, Collection<String> excludeFieldNames) {
        return toStringExclude(object, toNoNullStringArray(excludeFieldNames));
    }

    static String[] toNoNullStringArray(Collection<String> collection) {
        if (collection == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return toNoNullStringArray(collection.toArray());
    }

    static String[] toNoNullStringArray(Object[] array) {
        List<String> list = new ArrayList<>(array.length);
        for (Object e : array) {
            if (e != null) {
                list.add(e.toString());
            }
        }
        return (String[]) list.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String toStringExclude(Object object, String... excludeFieldNames) {
        return new ReflectionToStringBuilder(object).setExcludeFieldNames(excludeFieldNames).toString();
    }

    private static Object checkNotNull(Object obj) {
        Validate.isTrue(obj != null, "The Object passed in should not be null.", new Object[0]);
        return obj;
    }

    public ReflectionToStringBuilder(Object object) {
        super(checkNotNull(object));
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    public ReflectionToStringBuilder(Object object, ToStringStyle style) {
        super(checkNotNull(object), style);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    public ReflectionToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer) {
        super(checkNotNull(object), style, buffer);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    public <T> ReflectionToStringBuilder(T object, ToStringStyle style, StringBuffer buffer, Class<? super T> reflectUpToClass, boolean outputTransients, boolean outputStatics) {
        super(checkNotNull(object), style, buffer);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
        setUpToClass(reflectUpToClass);
        setAppendTransients(outputTransients);
        setAppendStatics(outputStatics);
    }

    public <T> ReflectionToStringBuilder(T object, ToStringStyle style, StringBuffer buffer, Class<? super T> reflectUpToClass, boolean outputTransients, boolean outputStatics, boolean excludeNullValues) {
        super(checkNotNull(object), style, buffer);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
        setUpToClass(reflectUpToClass);
        setAppendTransients(outputTransients);
        setAppendStatics(outputStatics);
        setExcludeNullValues(excludeNullValues);
    }

    protected boolean accept(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !isAppendTransients()) {
            return false;
        }
        if (Modifier.isStatic(field.getModifiers()) && !isAppendStatics()) {
            return false;
        }
        String[] strArr = this.excludeFieldNames;
        if (strArr == null || Arrays.binarySearch(strArr, field.getName()) < 0) {
            return !field.isAnnotationPresent(ToStringExclude.class);
        }
        return false;
    }

    protected void appendFieldsIn(Class<?> clazz) throws SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (clazz.isArray()) {
            reflectionAppendArray(getObject());
            return;
        }
        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field field : fields) {
            String fieldName = field.getName();
            if (accept(field)) {
                try {
                    Object fieldValue = getValue(field);
                    if (!this.excludeNullValues || fieldValue != null) {
                        append(fieldName, fieldValue, !field.isAnnotationPresent(ToStringSummary.class));
                    }
                } catch (IllegalAccessException ex) {
                    throw new InternalError("Unexpected IllegalAccessException: " + ex.getMessage());
                }
            }
        }
    }

    public String[] getExcludeFieldNames() {
        return (String[]) this.excludeFieldNames.clone();
    }

    public Class<?> getUpToClass() {
        return this.upToClass;
    }

    protected Object getValue(Field field) throws IllegalAccessException {
        return field.get(getObject());
    }

    public boolean isAppendStatics() {
        return this.appendStatics;
    }

    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    public boolean isExcludeNullValues() {
        return this.excludeNullValues;
    }

    public ReflectionToStringBuilder reflectionAppendArray(Object array) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, array);
        return this;
    }

    public void setAppendStatics(boolean appendStatics) {
        this.appendStatics = appendStatics;
    }

    public void setAppendTransients(boolean appendTransients) {
        this.appendTransients = appendTransients;
    }

    public void setExcludeNullValues(boolean excludeNullValues) {
        this.excludeNullValues = excludeNullValues;
    }

    public ReflectionToStringBuilder setExcludeFieldNames(String... excludeFieldNamesParam) {
        if (excludeFieldNamesParam == null) {
            this.excludeFieldNames = null;
        } else {
            String[] noNullStringArray = toNoNullStringArray(excludeFieldNamesParam);
            this.excludeFieldNames = noNullStringArray;
            Arrays.sort(noNullStringArray);
        }
        return this;
    }

    public void setUpToClass(Class<?> clazz) {
        Object object;
        if (clazz != null && (object = getObject()) != null && !clazz.isInstance(object)) {
            throw new IllegalArgumentException("Specified class is not a superclass of the object");
        }
        this.upToClass = clazz;
    }

    @Override // org.apache.commons.lang3.builder.ToStringBuilder
    public String toString() throws SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (getObject() == null) {
            return getStyle().getNullText();
        }
        Class<?> clazz = getObject().getClass();
        appendFieldsIn(clazz);
        while (clazz.getSuperclass() != null && clazz != getUpToClass()) {
            clazz = clazz.getSuperclass();
            appendFieldsIn(clazz);
        }
        return super.toString();
    }
}
