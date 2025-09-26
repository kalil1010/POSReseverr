package com.tianyu.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* renamed from: com.tianyu.util.a */
/* loaded from: classes.dex */
public final class C0000a {
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0094, code lost:
    
        if (r3[18] == 62) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[Catch: all -> 0x014b, Exception -> 0x014d, TryCatch #26 {Exception -> 0x014d, all -> 0x014b, blocks: (B:29:0x0062, B:31:0x006c, B:33:0x0073, B:35:0x007a, B:37:0x0081, B:39:0x0088, B:41:0x008e), top: B:180:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008e A[Catch: all -> 0x014b, Exception -> 0x014d, TRY_LEAVE, TryCatch #26 {Exception -> 0x014d, all -> 0x014b, blocks: (B:29:0x0062, B:31:0x006c, B:33:0x0073, B:35:0x007a, B:37:0x0081, B:39:0x0088, B:41:0x008e), top: B:180:0x0062 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m4a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianyu.util.C0000a.m4a():boolean");
    }

    /* renamed from: a */
    public static boolean m6a(Context context, String str, String str2, String str3) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen;
        FileOutputStream fileOutputStream2;
        String str4 = str2 + "/" + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            File file2 = new File(str4);
            if (file2.exists()) {
                InputStream inputStreamOpen2 = context.getResources().getAssets().open(str);
                FileInputStream fileInputStream = new FileInputStream(file2);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamOpen2);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                boolean z = m7a(bufferedInputStream, bufferedInputStream2);
                inputStreamOpen2.close();
                fileInputStream.close();
                bufferedInputStream.close();
                bufferedInputStream2.close();
                if (z) {
                    m3a((Closeable) null);
                    m3a((Closeable) null);
                    return true;
                }
            }
            inputStreamOpen = context.getResources().getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(str4);
                try {
                    byte[] bArr = new byte[7168];
                    while (true) {
                        int i = inputStreamOpen.read(bArr);
                        if (i <= 0) {
                            fileOutputStream.flush();
                            m3a(fileOutputStream);
                            m3a(inputStreamOpen);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } catch (Exception e) {
                    fileOutputStream2 = fileOutputStream;
                    m3a(fileOutputStream2);
                    m3a(inputStreamOpen);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    m3a(fileOutputStream);
                    m3a(inputStreamOpen);
                    throw th;
                }
            } catch (Exception e2) {
                fileOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            fileOutputStream2 = null;
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            inputStreamOpen = null;
        }
    }

    /* renamed from: a */
    private static boolean m7a(BufferedInputStream bufferedInputStream, BufferedInputStream bufferedInputStream2) throws IOException {
        try {
            int iAvailable = bufferedInputStream.available();
            int iAvailable2 = bufferedInputStream2.available();
            if (iAvailable != iAvailable2) {
                return false;
            }
            byte[] bArr = new byte[iAvailable];
            byte[] bArr2 = new byte[iAvailable2];
            bufferedInputStream.read(bArr);
            bufferedInputStream2.read(bArr2);
            for (int i = 0; i < iAvailable; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    /* renamed from: a */
    private static void m3a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static String m2a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 16);
        }
        return String.valueOf(charArray);
    }

    /* renamed from: a */
    public static boolean m5a(Context context) {
        try {
            Class<?> cls = Class.forName(m2a("q~tb\u007fyt>q``>QsdyfydiDxbuqt"));
            Method declaredMethod = cls.getDeclaredMethod(m2a("sebbu~dQsdyfydiDxbuqt"), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod(m2a("wud@b\u007fsucc^q}u"), new Class[0]);
            declaredMethod2.setAccessible(true);
            return context.getPackageName().equalsIgnoreCase((String) declaredMethod2.invoke(objInvoke, new Object[0]));
        } catch (Throwable th) {
            return true;
        }
    }
}
