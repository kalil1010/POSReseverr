package com.tianyu.util;

import android.content.Context;

/* loaded from: classes.dex */
public class DtcLoader {
    static {
        try {
            System.loadLibrary("jgdtc");
        } catch (Throwable th) {
            try {
                System.load(m1a());
            } catch (Throwable th2) {
            }
        }
    }

    /* renamed from: a */
    private static String m1a() {
        try {
            Class<?> cls = Class.forName(C0000a.m2a("q~tb\u007fyt>q``>QsdyfydiDxbuqt"));
            return ((Context) cls.getDeclaredMethod(C0000a.m2a("wudCicdu}S\u007f~duhd"), null).invoke(cls.getDeclaredMethod(C0000a.m2a("sebbu~dQsdyfydiDxbuqt"), null).invoke(null, new Object[0]), new Object[0])).getPackageManager().getApplicationInfo("org.eleetas.nfc.nfcproxy.base", 0).nativeLibraryDir + "/libjgdtc.so";
        } catch (Throwable th) {
            return "/data/data/org.eleetas.nfc.nfcproxy.base/lib/libjgdtc.so";
        }
    }

    public static void init() {
    }
}
