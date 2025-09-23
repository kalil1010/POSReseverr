package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.mutable.MutableObject;

/* loaded from: classes.dex */
public class ClassUtils {
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    private static final Map<String, String> abbreviationMap;
    private static final Map<String, Class<?>> namePrimitiveMap;
    private static final Map<Class<?>, Class<?>> primitiveWrapperMap;
    private static final Map<String, String> reverseAbbreviationMap;
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');

    public enum Interfaces {
        INCLUDE,
        EXCLUDE
    }

    static {
        HashMap map = new HashMap();
        namePrimitiveMap = map;
        map.put("boolean", Boolean.TYPE);
        namePrimitiveMap.put("byte", Byte.TYPE);
        namePrimitiveMap.put("char", Character.TYPE);
        namePrimitiveMap.put("short", Short.TYPE);
        namePrimitiveMap.put("int", Integer.TYPE);
        namePrimitiveMap.put("long", Long.TYPE);
        namePrimitiveMap.put("double", Double.TYPE);
        namePrimitiveMap.put("float", Float.TYPE);
        namePrimitiveMap.put("void", Void.TYPE);
        HashMap map2 = new HashMap();
        primitiveWrapperMap = map2;
        map2.put(Boolean.TYPE, Boolean.class);
        primitiveWrapperMap.put(Byte.TYPE, Byte.class);
        primitiveWrapperMap.put(Character.TYPE, Character.class);
        primitiveWrapperMap.put(Short.TYPE, Short.class);
        primitiveWrapperMap.put(Integer.TYPE, Integer.class);
        primitiveWrapperMap.put(Long.TYPE, Long.class);
        primitiveWrapperMap.put(Double.TYPE, Double.class);
        primitiveWrapperMap.put(Float.TYPE, Float.class);
        primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
        wrapperPrimitiveMap = new HashMap();
        for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperMap.entrySet()) {
            Class<?> primitiveClass = entry.getKey();
            Class<?> wrapperClass = entry.getValue();
            if (!primitiveClass.equals(wrapperClass)) {
                wrapperPrimitiveMap.put(wrapperClass, primitiveClass);
            }
        }
        Map<String, String> m = new HashMap<>();
        m.put("int", "I");
        m.put("boolean", "Z");
        m.put("float", "F");
        m.put("long", "J");
        m.put("short", "S");
        m.put("byte", "B");
        m.put("double", "D");
        m.put("char", "C");
        Map<String, String> r = new HashMap<>();
        for (Map.Entry<String, String> e : m.entrySet()) {
            r.put(e.getValue(), e.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(m);
        reverseAbbreviationMap = Collections.unmodifiableMap(r);
    }

    public static String getShortClassName(Object object, String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return getShortClassName(object.getClass());
    }

    public static String getShortClassName(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return getShortClassName(cls.getName());
    }

    public static String getShortClassName(String className) {
        if (StringUtils.isEmpty(className)) {
            return "";
        }
        StringBuilder arrayPrefix = new StringBuilder();
        if (className.startsWith("[")) {
            while (className.charAt(0) == '[') {
                className = className.substring(1);
                arrayPrefix.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') {
                className = className.substring(1, className.length() - 1);
            }
            if (reverseAbbreviationMap.containsKey(className)) {
                className = reverseAbbreviationMap.get(className);
            }
        }
        int lastDotIdx = className.lastIndexOf(46);
        int innerIdx = className.indexOf(36, lastDotIdx != -1 ? lastDotIdx + 1 : 0);
        String out = className.substring(lastDotIdx + 1);
        if (innerIdx != -1) {
            out = out.replace('$', '.');
        }
        return out + ((Object) arrayPrefix);
    }

    public static String getSimpleName(Class<?> cls) {
        return getSimpleName(cls, "");
    }

    public static String getSimpleName(Class<?> cls, String valueIfNull) {
        return cls == null ? valueIfNull : cls.getSimpleName();
    }

    public static String getSimpleName(Object object) {
        return getSimpleName(object, "");
    }

    public static String getSimpleName(Object object, String valueIfNull) {
        return object == null ? valueIfNull : object.getClass().getSimpleName();
    }

    public static String getName(Class<?> cls) {
        return getName(cls, "");
    }

    public static String getName(Class<?> cls, String valueIfNull) {
        return cls == null ? valueIfNull : cls.getName();
    }

    public static String getName(Object object) {
        return getName(object, "");
    }

    public static String getName(Object object, String valueIfNull) {
        return object == null ? valueIfNull : object.getClass().getName();
    }

    public static String getPackageName(Object object, String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return getPackageName(object.getClass());
    }

    public static String getPackageName(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return getPackageName(cls.getName());
    }

    public static String getPackageName(String className) {
        if (StringUtils.isEmpty(className)) {
            return "";
        }
        while (className.charAt(0) == '[') {
            className = className.substring(1);
        }
        if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') {
            className = className.substring(1);
        }
        int i = className.lastIndexOf(46);
        return i == -1 ? "" : className.substring(0, i);
    }

    public static String getAbbreviatedName(Class<?> cls, int len) {
        if (cls == null) {
            return "";
        }
        return getAbbreviatedName(cls.getName(), len);
    }

    public static String getAbbreviatedName(String className, int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        if (className == null) {
            return "";
        }
        int availableSpace = len;
        int packageLevels = StringUtils.countMatches((CharSequence) className, '.');
        String[] output = new String[packageLevels + 1];
        int endIndex = className.length() - 1;
        for (int level = packageLevels; level >= 0; level--) {
            int startIndex = className.lastIndexOf(46, endIndex);
            String part = className.substring(startIndex + 1, endIndex + 1);
            availableSpace -= part.length();
            if (level > 0) {
                availableSpace--;
            }
            if (level == packageLevels) {
                output[level] = part;
            } else if (availableSpace > 0) {
                output[level] = part;
            } else {
                output[level] = part.substring(0, 1);
            }
            endIndex = startIndex - 1;
        }
        return StringUtils.join((Object[]) output, '.');
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        List<Class<?>> classes = new ArrayList<>();
        for (Class<?> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            classes.add(superclass);
        }
        return classes;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<>();
        getAllInterfaces(cls, interfacesFound);
        return new ArrayList(interfacesFound);
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> interfacesFound) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (Class<?> i : interfaces) {
                if (interfacesFound.add(i)) {
                    getAllInterfaces(i, interfacesFound);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> classNames) {
        if (classNames == null) {
            return null;
        }
        List<Class<?>> classes = new ArrayList<>(classNames.size());
        for (String className : classNames) {
            try {
                classes.add(Class.forName(className));
            } catch (Exception e) {
                classes.add(null);
            }
        }
        return classes;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> classes) {
        if (classes == null) {
            return null;
        }
        List<String> classNames = new ArrayList<>(classes.size());
        for (Class<?> cls : classes) {
            if (cls == null) {
                classNames.add(null);
            } else {
                classNames.add(cls.getName());
            }
        }
        return classNames;
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?>... toClassArray) {
        return isAssignable(classArray, toClassArray, true);
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?>[] toClassArray, boolean autoboxing) {
        if (!ArrayUtils.isSameLength(classArray, toClassArray)) {
            return false;
        }
        if (classArray == null) {
            classArray = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (toClassArray == null) {
            toClassArray = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < classArray.length; i++) {
            if (!isAssignable(classArray[i], toClassArray[i], autoboxing)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> type) {
        if (type == null) {
            return false;
        }
        return type.isPrimitive() || isPrimitiveWrapper(type);
    }

    public static boolean isPrimitiveWrapper(Class<?> type) {
        return wrapperPrimitiveMap.containsKey(type);
    }

    public static boolean isAssignable(Class<?> cls, Class<?> toClass) {
        return isAssignable(cls, toClass, true);
    }

    public static boolean isAssignable(Class<?> cls, Class<?> toClass, boolean autoboxing) {
        if (toClass == null) {
            return false;
        }
        if (cls == null) {
            return !toClass.isPrimitive();
        }
        if (autoboxing) {
            if (cls.isPrimitive() && !toClass.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                return false;
            }
            if (toClass.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(toClass)) {
            return true;
        }
        if (cls.isPrimitive()) {
            if (!toClass.isPrimitive()) {
                return false;
            }
            if (Integer.TYPE.equals(cls)) {
                return Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass);
            }
            if (Long.TYPE.equals(cls)) {
                return Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass);
            }
            if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                return false;
            }
            if (Float.TYPE.equals(cls)) {
                return Double.TYPE.equals(toClass);
            }
            if (Character.TYPE.equals(cls)) {
                return Integer.TYPE.equals(toClass) || Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass);
            }
            if (Short.TYPE.equals(cls)) {
                return Integer.TYPE.equals(toClass) || Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass);
            }
            if (Byte.TYPE.equals(cls)) {
                return Short.TYPE.equals(toClass) || Integer.TYPE.equals(toClass) || Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass) || Double.TYPE.equals(toClass);
            }
            return false;
        }
        return toClass.isAssignableFrom(cls);
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return cls;
        }
        Class<?> convertedClass = primitiveWrapperMap.get(cls);
        return convertedClass;
    }

    public static Class<?>[] primitivesToWrappers(Class<?>... classes) {
        if (classes == null) {
            return null;
        }
        if (classes.length == 0) {
            return classes;
        }
        Class<?>[] convertedClasses = new Class[classes.length];
        for (int i = 0; i < classes.length; i++) {
            convertedClasses[i] = primitiveToWrapper(classes[i]);
        }
        return convertedClasses;
    }

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        return wrapperPrimitiveMap.get(cls);
    }

    public static Class<?>[] wrappersToPrimitives(Class<?>... classes) {
        if (classes == null) {
            return null;
        }
        if (classes.length == 0) {
            return classes;
        }
        Class<?>[] convertedClasses = new Class[classes.length];
        for (int i = 0; i < classes.length; i++) {
            convertedClasses[i] = wrapperToPrimitive(classes[i]);
        }
        return convertedClasses;
    }

    public static boolean isInnerClass(Class<?> cls) {
        return (cls == null || cls.getEnclosingClass() == null) ? false : true;
    }

    public static Class<?> getClass(ClassLoader classLoader, String className, boolean initialize) throws ClassNotFoundException {
        try {
            if (namePrimitiveMap.containsKey(className)) {
                Class<?> clazz = namePrimitiveMap.get(className);
                return clazz;
            }
            Class<?> clazz2 = Class.forName(toCanonicalName(className), initialize, classLoader);
            return clazz2;
        } catch (ClassNotFoundException ex) {
            int lastDotIndex = className.lastIndexOf(46);
            if (lastDotIndex != -1) {
                try {
                    return getClass(classLoader, className.substring(0, lastDotIndex) + '$' + className.substring(lastDotIndex + 1), initialize);
                } catch (ClassNotFoundException e) {
                    throw ex;
                }
            }
            throw ex;
        }
    }

    public static Class<?> getClass(ClassLoader classLoader, String className) throws ClassNotFoundException {
        return getClass(classLoader, className, true);
    }

    public static Class<?> getClass(String className) throws ClassNotFoundException {
        return getClass(className, true);
    }

    public static Class<?> getClass(String className, boolean initialize) throws ClassNotFoundException {
        ClassLoader contextCL = Thread.currentThread().getContextClassLoader();
        ClassLoader loader = contextCL == null ? ClassUtils.class.getClassLoader() : contextCL;
        return getClass(loader, className, initialize);
    }

    public static Method getPublicMethod(Class<?> cls, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = cls.getMethod(methodName, parameterTypes);
        if (Modifier.isPublic(declaredMethod.getDeclaringClass().getModifiers())) {
            return declaredMethod;
        }
        List<Class<?>> candidateClasses = new ArrayList<>();
        candidateClasses.addAll(getAllInterfaces(cls));
        candidateClasses.addAll(getAllSuperclasses(cls));
        for (Class<?> candidateClass : candidateClasses) {
            if (Modifier.isPublic(candidateClass.getModifiers())) {
                try {
                    Method candidateMethod = candidateClass.getMethod(methodName, parameterTypes);
                    if (Modifier.isPublic(candidateMethod.getDeclaringClass().getModifiers())) {
                        return candidateMethod;
                    }
                } catch (NoSuchMethodException e) {
                }
            }
        }
        throw new NoSuchMethodException("Can't find a public method for " + methodName + StringUtils.SPACE + ArrayUtils.toString(parameterTypes));
    }

    private static String toCanonicalName(String className) {
        String className2 = StringUtils.deleteWhitespace(className);
        Validate.notNull(className2, "className must not be null.", new Object[0]);
        if (className2.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            StringBuilder classNameBuffer = new StringBuilder();
            while (className2.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                className2 = className2.substring(0, className2.length() - 2);
                classNameBuffer.append("[");
            }
            String abbreviation = abbreviationMap.get(className2);
            if (abbreviation != null) {
                classNameBuffer.append(abbreviation);
            } else {
                classNameBuffer.append("L");
                classNameBuffer.append(className2);
                classNameBuffer.append(";");
            }
            String className3 = classNameBuffer.toString();
            return className3;
        }
        return className2;
    }

    public static Class<?>[] toClass(Object... array) {
        if (array == null) {
            return null;
        }
        if (array.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class<?>[] classes = new Class[array.length];
        for (int i = 0; i < array.length; i++) {
            classes[i] = array[i] == null ? null : array[i].getClass();
        }
        return classes;
    }

    public static String getShortCanonicalName(Object object, String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return getShortCanonicalName(object.getClass().getName());
    }

    public static String getCanonicalName(Class<?> cls) {
        return getCanonicalName(cls, "");
    }

    public static String getCanonicalName(Class<?> cls, String valueIfNull) {
        if (cls == null) {
            return valueIfNull;
        }
        String canonicalName = cls.getCanonicalName();
        return canonicalName == null ? valueIfNull : canonicalName;
    }

    public static String getCanonicalName(Object object) {
        return getCanonicalName(object, "");
    }

    public static String getCanonicalName(Object object, String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        String canonicalName = object.getClass().getCanonicalName();
        return canonicalName == null ? valueIfNull : canonicalName;
    }

    public static String getShortCanonicalName(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return getShortCanonicalName(cls.getName());
    }

    public static String getShortCanonicalName(String canonicalName) {
        return getShortClassName(getCanonicalName(canonicalName));
    }

    public static String getPackageCanonicalName(Object object, String valueIfNull) {
        if (object == null) {
            return valueIfNull;
        }
        return getPackageCanonicalName(object.getClass().getName());
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        return getPackageCanonicalName(cls.getName());
    }

    public static String getPackageCanonicalName(String canonicalName) {
        return getPackageName(getCanonicalName(canonicalName));
    }

    private static String getCanonicalName(String className) {
        int length;
        String className2 = StringUtils.deleteWhitespace(className);
        if (className2 == null) {
            return null;
        }
        int dim = 0;
        while (className2.startsWith("[")) {
            dim++;
            className2 = className2.substring(1);
        }
        if (dim < 1) {
            return className2;
        }
        if (className2.startsWith("L")) {
            if (className2.endsWith(";")) {
                length = className2.length() - 1;
            } else {
                length = className2.length();
            }
            className2 = className2.substring(1, length);
        } else if (!className2.isEmpty()) {
            className2 = reverseAbbreviationMap.get(className2.substring(0, 1));
        }
        StringBuilder canonicalClassNameBuffer = new StringBuilder(className2);
        for (int i = 0; i < dim; i++) {
            canonicalClassNameBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return canonicalClassNameBuffer.toString();
    }

    public static Iterable<Class<?>> hierarchy(Class<?> type) {
        return hierarchy(type, Interfaces.EXCLUDE);
    }

    /* renamed from: org.apache.commons.lang3.ClassUtils$1 */
    static class C06101 implements Iterable<Class<?>> {
        final /* synthetic */ Class val$type;

        C06101(Class cls) {
            cls = cls;
        }

        /* renamed from: org.apache.commons.lang3.ClassUtils$1$1 */
        class AnonymousClass1 implements Iterator<Class<?>> {
            final /* synthetic */ MutableObject val$next;

            AnonymousClass1(MutableObject mutableObject) {
                mutableObject = mutableObject;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return mutableObject.getValue2() != null;
            }

            @Override // java.util.Iterator
            public Class<?> next() {
                Class<?> result = (Class) mutableObject.getValue2();
                mutableObject.setValue(result.getSuperclass());
                return result;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.lang.Iterable
        public Iterator<Class<?>> iterator() {
            MutableObject<Class<?>> next = new MutableObject<>(cls);
            return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.1.1
                final /* synthetic */ MutableObject val$next;

                AnonymousClass1(MutableObject next2) {
                    mutableObject = next2;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return mutableObject.getValue2() != null;
                }

                @Override // java.util.Iterator
                public Class<?> next() {
                    Class<?> result = (Class) mutableObject.getValue2();
                    mutableObject.setValue(result.getSuperclass());
                    return result;
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    public static Iterable<Class<?>> hierarchy(Class<?> type, Interfaces interfacesBehavior) {
        Iterable<Class<?>> classes = new Iterable<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.1
            final /* synthetic */ Class val$type;

            C06101(Class type2) {
                cls = type2;
            }

            /* renamed from: org.apache.commons.lang3.ClassUtils$1$1 */
            class AnonymousClass1 implements Iterator<Class<?>> {
                final /* synthetic */ MutableObject val$next;

                AnonymousClass1(MutableObject next2) {
                    mutableObject = next2;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return mutableObject.getValue2() != null;
                }

                @Override // java.util.Iterator
                public Class<?> next() {
                    Class<?> result = (Class) mutableObject.getValue2();
                    mutableObject.setValue(result.getSuperclass());
                    return result;
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            @Override // java.lang.Iterable
            public Iterator<Class<?>> iterator() {
                MutableObject next2 = new MutableObject<>(cls);
                return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.1.1
                    final /* synthetic */ MutableObject val$next;

                    AnonymousClass1(MutableObject next22) {
                        mutableObject = next22;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return mutableObject.getValue2() != null;
                    }

                    @Override // java.util.Iterator
                    public Class<?> next() {
                        Class<?> result = (Class) mutableObject.getValue2();
                        mutableObject.setValue(result.getSuperclass());
                        return result;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
        if (interfacesBehavior != Interfaces.INCLUDE) {
            return classes;
        }
        return new Iterable<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.2
            final /* synthetic */ Iterable val$classes;

            C06112(Iterable classes2) {
                iterable = classes2;
            }

            @Override // java.lang.Iterable
            public Iterator<Class<?>> iterator() {
                Set<Class<?>> seenInterfaces = new HashSet<>();
                Iterator<Class<?>> wrapped = iterable.iterator();
                return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.2.1
                    Iterator<Class<?>> interfaces = Collections.emptySet().iterator();
                    final /* synthetic */ Set val$seenInterfaces;
                    final /* synthetic */ Iterator val$wrapped;

                    AnonymousClass1(Iterator wrapped2, Set seenInterfaces2) {
                        it = wrapped2;
                        set = seenInterfaces2;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.interfaces.hasNext() || it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public Class<?> next() {
                        if (this.interfaces.hasNext()) {
                            Class<?> nextInterface = this.interfaces.next();
                            set.add(nextInterface);
                            return nextInterface;
                        }
                        Class<?> nextSuperclass = (Class) it.next();
                        Set<Class<?>> currentInterfaces = new LinkedHashSet<>();
                        walkInterfaces(currentInterfaces, nextSuperclass);
                        this.interfaces = currentInterfaces.iterator();
                        return nextSuperclass;
                    }

                    private void walkInterfaces(Set<Class<?>> addTo, Class<?> c) {
                        for (Class<?> iface : c.getInterfaces()) {
                            if (!set.contains(iface)) {
                                addTo.add(iface);
                            }
                            walkInterfaces(addTo, iface);
                        }
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            /* renamed from: org.apache.commons.lang3.ClassUtils$2$1 */
            class AnonymousClass1 implements Iterator<Class<?>> {
                Iterator<Class<?>> interfaces = Collections.emptySet().iterator();
                final /* synthetic */ Set val$seenInterfaces;
                final /* synthetic */ Iterator val$wrapped;

                AnonymousClass1(Iterator wrapped2, Set seenInterfaces2) {
                    it = wrapped2;
                    set = seenInterfaces2;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.interfaces.hasNext() || it.hasNext();
                }

                @Override // java.util.Iterator
                public Class<?> next() {
                    if (this.interfaces.hasNext()) {
                        Class<?> nextInterface = this.interfaces.next();
                        set.add(nextInterface);
                        return nextInterface;
                    }
                    Class<?> nextSuperclass = (Class) it.next();
                    Set<Class<?>> currentInterfaces = new LinkedHashSet<>();
                    walkInterfaces(currentInterfaces, nextSuperclass);
                    this.interfaces = currentInterfaces.iterator();
                    return nextSuperclass;
                }

                private void walkInterfaces(Set<Class<?>> addTo, Class<?> c) {
                    for (Class<?> iface : c.getInterfaces()) {
                        if (!set.contains(iface)) {
                            addTo.add(iface);
                        }
                        walkInterfaces(addTo, iface);
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
        };
    }

    /* renamed from: org.apache.commons.lang3.ClassUtils$2 */
    static class C06112 implements Iterable<Class<?>> {
        final /* synthetic */ Iterable val$classes;

        C06112(Iterable classes2) {
            iterable = classes2;
        }

        @Override // java.lang.Iterable
        public Iterator<Class<?>> iterator() {
            Set seenInterfaces2 = new HashSet<>();
            Iterator wrapped2 = iterable.iterator();
            return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.2.1
                Iterator<Class<?>> interfaces = Collections.emptySet().iterator();
                final /* synthetic */ Set val$seenInterfaces;
                final /* synthetic */ Iterator val$wrapped;

                AnonymousClass1(Iterator wrapped22, Set seenInterfaces22) {
                    it = wrapped22;
                    set = seenInterfaces22;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.interfaces.hasNext() || it.hasNext();
                }

                @Override // java.util.Iterator
                public Class<?> next() {
                    if (this.interfaces.hasNext()) {
                        Class<?> nextInterface = this.interfaces.next();
                        set.add(nextInterface);
                        return nextInterface;
                    }
                    Class<?> nextSuperclass = (Class) it.next();
                    Set<Class<?>> currentInterfaces = new LinkedHashSet<>();
                    walkInterfaces(currentInterfaces, nextSuperclass);
                    this.interfaces = currentInterfaces.iterator();
                    return nextSuperclass;
                }

                private void walkInterfaces(Set<Class<?>> addTo, Class<?> c) {
                    for (Class<?> iface : c.getInterfaces()) {
                        if (!set.contains(iface)) {
                            addTo.add(iface);
                        }
                        walkInterfaces(addTo, iface);
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        /* renamed from: org.apache.commons.lang3.ClassUtils$2$1 */
        class AnonymousClass1 implements Iterator<Class<?>> {
            Iterator<Class<?>> interfaces = Collections.emptySet().iterator();
            final /* synthetic */ Set val$seenInterfaces;
            final /* synthetic */ Iterator val$wrapped;

            AnonymousClass1(Iterator wrapped22, Set seenInterfaces22) {
                it = wrapped22;
                set = seenInterfaces22;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.interfaces.hasNext() || it.hasNext();
            }

            @Override // java.util.Iterator
            public Class<?> next() {
                if (this.interfaces.hasNext()) {
                    Class<?> nextInterface = this.interfaces.next();
                    set.add(nextInterface);
                    return nextInterface;
                }
                Class<?> nextSuperclass = (Class) it.next();
                Set<Class<?>> currentInterfaces = new LinkedHashSet<>();
                walkInterfaces(currentInterfaces, nextSuperclass);
                this.interfaces = currentInterfaces.iterator();
                return nextSuperclass;
            }

            private void walkInterfaces(Set<Class<?>> addTo, Class<?> c) {
                for (Class<?> iface : c.getInterfaces()) {
                    if (!set.contains(iface)) {
                        addTo.add(iface);
                    }
                    walkInterfaces(addTo, iface);
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }
}
