package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.functions.Functions10;
import kotlin.jvm.functions.Functions11;
import kotlin.jvm.functions.Functions12;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.functions.Functions14;
import kotlin.jvm.functions.Functions15;
import kotlin.jvm.functions.Functions16;
import kotlin.jvm.functions.Functions17;
import kotlin.jvm.functions.Functions18;
import kotlin.jvm.functions.Functions19;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.functions.Functions20;
import kotlin.jvm.functions.Functions21;
import kotlin.jvm.functions.Functions22;
import kotlin.jvm.functions.Functions23;
import kotlin.jvm.functions.Functions3;
import kotlin.jvm.functions.Functions4;
import kotlin.jvm.functions.Functions5;
import kotlin.jvm.functions.Functions6;
import kotlin.jvm.functions.Functions7;
import kotlin.jvm.functions.Functions8;
import kotlin.jvm.functions.Functions9;
import kotlin.jvm.internal.markers.KMarkers;
import kotlin.jvm.internal.markers.KMarkers2;
import kotlin.jvm.internal.markers.KMarkers3;
import kotlin.jvm.internal.markers.KMarkers4;
import kotlin.jvm.internal.markers.KMarkers5;
import kotlin.jvm.internal.markers.KMarkers6;
import kotlin.jvm.internal.markers.KMarkers7;
import kotlin.jvm.internal.markers.KMarkers8;

/* loaded from: classes.dex */
public class TypeIntrinsics {
    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        return (T) Intrinsics.sanitizeStackTrace(t, TypeIntrinsics.class.getName());
    }

    public static void throwCce(Object argument, String requestedClassName) {
        String argumentClassName = argument == null ? "null" : argument.getClass().getName();
        throwCce(argumentClassName + " cannot be cast to " + requestedClassName);
    }

    public static void throwCce(String message) {
        throw throwCce(new ClassCastException(message));
    }

    public static ClassCastException throwCce(ClassCastException e) {
        throw ((ClassCastException) sanitizeStackTrace(e));
    }

    public static boolean isMutableIterator(Object obj) {
        return (obj instanceof Iterator) && (!(obj instanceof KMarkers) || (obj instanceof KMarkers4));
    }

    public static Iterator asMutableIterator(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers4)) {
            throwCce(obj, "kotlin.collections.MutableIterator");
        }
        return castToIterator(obj);
    }

    public static Iterator asMutableIterator(Object obj, String message) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers4)) {
            throwCce(message);
        }
        return castToIterator(obj);
    }

    public static Iterator castToIterator(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableListIterator(Object obj) {
        return (obj instanceof ListIterator) && (!(obj instanceof KMarkers) || (obj instanceof KMarkers6));
    }

    public static ListIterator asMutableListIterator(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers6)) {
            throwCce(obj, "kotlin.collections.MutableListIterator");
        }
        return castToListIterator(obj);
    }

    public static ListIterator asMutableListIterator(Object obj, String message) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers6)) {
            throwCce(message);
        }
        return castToListIterator(obj);
    }

    public static ListIterator castToListIterator(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableIterable(Object obj) {
        return (obj instanceof Iterable) && (!(obj instanceof KMarkers) || (obj instanceof KMarkers3));
    }

    public static Iterable asMutableIterable(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers3)) {
            throwCce(obj, "kotlin.collections.MutableIterable");
        }
        return castToIterable(obj);
    }

    public static Iterable asMutableIterable(Object obj, String message) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers3)) {
            throwCce(message);
        }
        return castToIterable(obj);
    }

    public static Iterable castToIterable(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableCollection(Object obj) {
        return (obj instanceof Collection) && (!(obj instanceof KMarkers) || (obj instanceof KMarkers2));
    }

    public static Collection asMutableCollection(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers2)) {
            throwCce(obj, "kotlin.collections.MutableCollection");
        }
        return castToCollection(obj);
    }

    public static Collection asMutableCollection(Object obj, String message) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers2)) {
            throwCce(message);
        }
        return castToCollection(obj);
    }

    public static Collection castToCollection(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableList(Object obj) {
        return (obj instanceof List) && (!(obj instanceof KMarkers) || (obj instanceof KMarkers5));
    }

    public static List asMutableList(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers5)) {
            throwCce(obj, "kotlin.collections.MutableList");
        }
        return castToList(obj);
    }

    public static List asMutableList(Object obj, String message) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers5)) {
            throwCce(message);
        }
        return castToList(obj);
    }

    public static List castToList(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableSet(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof KMarkers) || (obj instanceof KMarkers8));
    }

    public static Set asMutableSet(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers8)) {
            throwCce(obj, "kotlin.collections.MutableSet");
        }
        return castToSet(obj);
    }

    public static Set asMutableSet(Object obj, String message) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers8)) {
            throwCce(message);
        }
        return castToSet(obj);
    }

    public static Set castToSet(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableMap(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof KMarkers) || (obj instanceof KMarkers7));
    }

    public static Map asMutableMap(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers7)) {
            throwCce(obj, "kotlin.collections.MutableMap");
        }
        return castToMap(obj);
    }

    public static Map asMutableMap(Object obj, String message) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers7)) {
            throwCce(message);
        }
        return castToMap(obj);
    }

    public static Map castToMap(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static boolean isMutableMapEntry(Object obj) {
        return (obj instanceof Map.Entry) && (!(obj instanceof KMarkers) || (obj instanceof KMarkers7.Entry));
    }

    public static Map.Entry asMutableMapEntry(Object obj) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers7.Entry)) {
            throwCce(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return castToMapEntry(obj);
    }

    public static Map.Entry asMutableMapEntry(Object obj, String message) {
        if ((obj instanceof KMarkers) && !(obj instanceof KMarkers7.Entry)) {
            throwCce(message);
        }
        return castToMapEntry(obj);
    }

    public static Map.Entry castToMapEntry(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static int getFunctionArity(Object obj) {
        if (obj instanceof FunctionBase) {
            return ((FunctionBase) obj).getArity();
        }
        if (obj instanceof Functions) {
            return 0;
        }
        if (obj instanceof Functions2) {
            return 1;
        }
        if (obj instanceof Functions13) {
            return 2;
        }
        if (obj instanceof Functions17) {
            return 3;
        }
        if (obj instanceof Functions18) {
            return 4;
        }
        if (obj instanceof Functions19) {
            return 5;
        }
        if (obj instanceof Functions20) {
            return 6;
        }
        if (obj instanceof Functions21) {
            return 7;
        }
        if (obj instanceof Functions22) {
            return 8;
        }
        if (obj instanceof Functions23) {
            return 9;
        }
        if (obj instanceof Functions3) {
            return 10;
        }
        if (obj instanceof Functions4) {
            return 11;
        }
        if (obj instanceof Functions5) {
            return 12;
        }
        if (obj instanceof Functions6) {
            return 13;
        }
        if (obj instanceof Functions7) {
            return 14;
        }
        if (obj instanceof Functions8) {
            return 15;
        }
        if (obj instanceof Functions9) {
            return 16;
        }
        if (obj instanceof Functions10) {
            return 17;
        }
        if (obj instanceof Functions11) {
            return 18;
        }
        if (obj instanceof Functions12) {
            return 19;
        }
        if (obj instanceof Functions14) {
            return 20;
        }
        if (obj instanceof Functions15) {
            return 21;
        }
        if (obj instanceof Functions16) {
            return 22;
        }
        return -1;
    }

    public static boolean isFunctionOfArity(Object obj, int arity) {
        return (obj instanceof Function) && getFunctionArity(obj) == arity;
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int arity) {
        if (obj != null && !isFunctionOfArity(obj, arity)) {
            throwCce(obj, "kotlin.jvm.functions.Function" + arity);
        }
        return obj;
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int arity, String message) {
        if (obj != null && !isFunctionOfArity(obj, arity)) {
            throwCce(message);
        }
        return obj;
    }
}
