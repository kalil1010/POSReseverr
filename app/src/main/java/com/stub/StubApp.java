package com.stub;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.util.TypedValue;
import com.tianyu.util.C0000a;
import com.tianyu.util.DtcLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class StubApp extends Application {

    /* renamed from: c */
    private static Context f2c;

    /* renamed from: a */
    private static Application f0a = null;

    /* renamed from: b */
    private static String f1b = "libjiagu";
    private static boolean loadFromLib = false;
    private static boolean needX86Bridge = false;
    private static boolean returnIntern = true;

    /* renamed from: d */
    private static String f3d = null;

    /* renamed from: e */
    private static String f4e = null;

    /* renamed from: f */
    private static String f5f = null;

    /* renamed from: g */
    private static String f6g = null;

    /* renamed from: h */
    private static String f7h = null;

    /* renamed from: i */
    private static Map<Integer, String> f8i = new ConcurrentHashMap();
    private static Map<String, Set<String>> perm = new ConcurrentHashMap();

    public static native void fcmark();

    public static native void interface11(int i);

    public static native Enumeration<String> interface12(DexFile dexFile);

    public static native long interface13(int i, long j, long j2, long j3, int i2, int i3, long j4);

    public static native String interface14(int i);

    public static native AssetFileDescriptor interface17(AssetManager assetManager, String str);

    public static native InputStream interface18(Class cls, String str);

    public static native InputStream interface19(ClassLoader classLoader, String str);

    public static native InputStream interface199(AssetManager assetManager, String str);

    public static native void interface20();

    public static native void interface21(Application application);

    public static native void interface22(int i, String[] strArr, int[] iArr);

    public static native void interface24(Activity activity, String[] strArr, int i);

    public static native ZipEntry interface30(ZipFile zipFile, String str);

    public static native void interface5(Application application);

    public static native InputStream interface51(Resources resources, int i);

    public static native InputStream interface52(Resources resources, int i, TypedValue typedValue);

    public static native AssetFileDescriptor interface53(Resources resources, int i);

    public static native MediaPlayer interface54(Context context, int i);

    public static native MediaPlayer interface55(Context context, int i, AudioAttributes audioAttributes, int i2);

    public static native int interface56(SoundPool soundPool, Context context, int i, int i2);

    public static native String interface6(String str);

    public static native boolean interface7(Application application, Context context);

    public static native boolean interface8(Application application, Context context);

    public static native Location mark(LocationManager locationManager, String str);

    public static native void mark();

    public static native void mark(Location location);

    public static native synchronized Object n010333(Object obj, Object obj2);

    public static native void n0110();

    public static native boolean n0111();

    public static native void n01110(boolean z);

    public static native int n01111(int i);

    public static native void n011110(int i, int i2);

    public static native int n011111(int i, boolean z);

    public static native void n0111110(int i, boolean z, int i2);

    public static native int n0111111(int i, boolean z, boolean z2);

    public static native int n011111311131112111(int i, int i2, boolean z, Object obj, int i3, int i4, boolean z2, Object obj2, int i5, int i6, int i7, long j, int i8, int i9);

    public static native int n0111121131111(int i, boolean z, long j, int i2, int i3, Object obj, int i4, int i5, int i6);

    public static native int n011112131111(int i, boolean z, long j, int i2, Object obj, int i3, int i4, int i5);

    public static native int n0111131(int i, boolean z, Object obj);

    public static native void n011113110(int i, boolean z, Object obj, int i2, int i3);

    public static native int n011113111(int i, boolean z, Object obj, int i2, int i3);

    public static native int n0111131131111(int i, boolean z, Object obj, int i2, int i3, Object obj2, int i4, int i5, int i6);

    public static native void n011113130(int i, boolean z, Object obj, int i2, Object obj2);

    public static native void n0111133110(int i, boolean z, Object obj, Object obj2, int i2, int i3);

    public static native void n01111331130(int i, boolean z, Object obj, Object obj2, int i2, int i3, Object obj3);

    public static native void n011120(int i, long j);

    public static native int n0111211(int i, long j, int i2);

    public static native int n01112111(int i, long j, int i2, int i3);

    public static native int n0111211111(int i, long j, int i2, int i3, int i4, int i5);

    public static native Object n01112113(int i, long j, int i2, int i3);

    public static native int n011121131(int i, long j, int i2, int i3, Object obj);

    public static native long n0111212(int i, long j, int i2);

    public static native int n01112121111(int i, long j, int i2, long j2, int i3, int i4, int i5);

    public static native int n011121221(int i, long j, int i2, long j2, long j3);

    public static native int n01112131(int i, long j, int i2, Object obj);

    public static native Object n01113(int i);

    public static native void n011130(int i, Object obj);

    public static native int n011131(int i, Object obj);

    public static native int n01113111(int i, Object obj, int i2, int i3);

    public static native long n011131122(int i, Object obj, int i2, int i3, long j);

    public static native Object n01113113(int i, Object obj, int i2, int i3);

    public static native int n011131131(int i, Object obj, int i2, int i3, Object obj2);

    public static native long n011132222(int i, Object obj, long j, long j2, long j3);

    public static native void n0111330(int i, Object obj, Object obj2);

    public static native long n0112();

    public static native void n011211110(long j, int i, short s, short s2, int i2);

    public static native Object n0113();

    public static native void n01130(Object obj);

    public static native int n01131(Object obj);

    public static native void n0113130(Object obj, int i, Object obj2);

    public static native Object n0113133(Object obj, int i, Object obj2);

    public static native long n01132(Object obj);

    public static native Object n01133(Object obj);

    public static native void n011330(Object obj, Object obj2);

    public static native boolean n011331(Object obj, Object obj2);

    public static native Object n011333(Object obj, Object obj2);

    public static native Object n0113333(Object obj, Object obj2, Object obj3);

    public static native void pmark(Context context);

    public static native void rmark();

    public native synchronized void n11030(Object obj);

    public native synchronized boolean n110331(Object obj, Object obj2);

    public native void n1110();

    public native boolean n1111();

    public native void n11110(int i);

    public native boolean n11111(boolean z);

    public native long n111112(int i, int i2);

    public native void n111130(int i, Object obj);

    public native boolean n11113311(int i, Object obj, Object obj2, int i2);

    public native void n11120(long j);

    public native void n1112310(long j, Object obj, int i);

    public native void n11123310(long j, Object obj, Object obj2, int i);

    public native Object n1113();

    public native void n11130(Object obj);

    public native boolean n11131(Object obj);

    public native void n111310(Object obj, int i);

    public native void n1113130(Object obj, boolean z, Object obj2);

    public native Object n11133(Object obj);

    public native void n111330(Object obj, Object obj2);

    public native void n1113310(Object obj, Object obj2, boolean z);

    public native void n11133110(Object obj, Object obj2, boolean z, int i);

    public native void n11133310(Object obj, Object obj2, Object obj3, int i);

    public native Object n1113333(Object obj, Object obj2, Object obj3);

    public static String getDir() {
        return f6g;
    }

    public static String getSoPath1() {
        return f4e;
    }

    public static String getSoPath2() {
        return f5f;
    }

    public static Context getAppContext() {
        return f2c;
    }

    public static Context getOrigApplicationContext(Context context) {
        return context;
    }

    @Override // android.content.ContextWrapper
    protected final void attachBaseContext(Context context) throws Throwable {
        boolean zM6a;
        super.attachBaseContext(context);
        if (Build.VERSION.SDK_INT == 28) {
            try {
                Class.forName(C0000a.m2a("q~tb\u007fyt>s\u007f~du~d>`}>@qs{qwu@qbcub4@qs{qwu")).getDeclaredConstructor(String.class).setAccessible(true);
            } catch (Throwable th) {
            }
            try {
                Class<?> cls = Class.forName(C0000a.m2a("q~tb\u007fyt>q``>QsdyfydiDxbuqt"));
                Method declaredMethod = cls.getDeclaredMethod(C0000a.m2a("sebbu~dQsdyfydiDxbuqt"), new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField(C0000a.m2a("}Xyttu~Q`yGqb~y~wCx\u007fg~"));
                declaredField.setAccessible(true);
                declaredField.setBoolean(objInvoke, true);
            } catch (Throwable th2) {
            }
        }
        f2c = context;
        if (f0a == null) {
            f0a = this;
        }
        Boolean boolValueOf = Boolean.valueOf(C0000a.m4a());
        Boolean bool = false;
        Boolean bool2 = false;
        if (Build.CPU_ABI.contains("64") || Build.CPU_ABI2.contains("64")) {
            bool = true;
        }
        if (Build.CPU_ABI.contains("mips") || Build.CPU_ABI2.contains("mips")) {
            bool2 = true;
        }
        if (boolValueOf.booleanValue() && needX86Bridge) {
            System.loadLibrary("X86Bridge");
        }
        if (loadFromLib) {
            if (boolValueOf.booleanValue() && !needX86Bridge) {
                System.loadLibrary("jiagu_x86");
            } else {
                System.loadLibrary("jiagu");
            }
        } else {
            String absolutePath = context.getFilesDir().getParentFile().getAbsolutePath();
            try {
                absolutePath = context.getFilesDir().getParentFile().getCanonicalPath();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = absolutePath + "/.jiagu";
            f7h = m0a(str, bool.booleanValue(), bool2.booleanValue());
            f3d = m0a(str, false, false);
            f4e = str + File.separator + f3d;
            f5f = str + File.separator + f7h;
            f6g = str;
            if (bool2.booleanValue()) {
                C0000a.m6a(context, f1b + "_mips.so", str, f3d);
            } else if (boolValueOf.booleanValue() && !needX86Bridge) {
                C0000a.m6a(context, f1b + "_x86.so", str, f3d);
            } else {
                C0000a.m6a(context, f1b + ".so", str, f3d);
            }
            if (bool.booleanValue() && !bool2.booleanValue()) {
                if (boolValueOf.booleanValue() && !needX86Bridge) {
                    zM6a = C0000a.m6a(context, f1b + "_x64.so", str, f7h);
                } else {
                    zM6a = C0000a.m6a(context, f1b + "_a64.so", str, f7h);
                }
                if (zM6a) {
                    System.load(str + "/" + f7h);
                } else {
                    System.load(str + "/" + f3d);
                }
            } else {
                System.load(str + "/" + f3d);
            }
        }
        DtcLoader.init();
        interface5(this);
    }

    /* renamed from: a */
    private static String m0a(String str, boolean z, boolean z2) {
        String str2 = f1b;
        if (Build.VERSION.SDK_INT < 23) {
            str2 = str2 + str.hashCode();
        }
        if (z && !z2) {
            return str2 + "_64.so";
        }
        return str2 + ".so";
    }

    @Override // android.app.Application
    public final void onCreate() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onCreate();
        interface21(this);
        Context context = f2c;
        if (this != null && context != null && C0000a.m5a(context)) {
            try {
                Method declaredMethod = Class.forName(C0000a.m2a("s\u007f}>zw>rx>Bu`\u007fbdcDy}u")).getDeclaredMethod(C0000a.m2a("BuwycdubQsdyfydiSq||Rqs{c"), Application.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, this);
            } catch (Exception e) {
            }
        }
    }

    public static String getString2(int i) {
        String strInterface14 = f8i.get(Integer.valueOf(i));
        if (strInterface14 == null) {
            strInterface14 = interface14(i);
            f8i.put(Integer.valueOf(i), strInterface14);
        }
        if (strInterface14 != null && returnIntern) {
            return strInterface14.intern();
        }
        return strInterface14;
    }

    public static String getString2(String str) {
        try {
            return getString2(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isX86Arch() {
        return C0000a.m4a();
    }

    public static void put(Object obj, String[] strArr) {
        String canonicalName = obj.getClass().getCanonicalName();
        Set<String> set = perm.get(canonicalName);
        if (set != null) {
            set.addAll(Arrays.asList(strArr));
            return;
        }
        Set<String> setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Collections.addAll(setNewSetFromMap, strArr);
        Set<String> setPut = perm.put(canonicalName, setNewSetFromMap);
        if (setPut != null) {
            setPut.addAll(Arrays.asList(strArr));
        }
    }
}
