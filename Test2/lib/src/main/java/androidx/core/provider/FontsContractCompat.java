package androidx.core.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.SelfDestructiveThread;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class FontsContractCompat {
    public static final String PARCEL_FONT_RESULTS = "font_results";
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
    static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
    private static final SelfDestructiveThread sBackgroundThread = new SelfDestructiveThread("fonts", 10, BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS);
    static final Object sLock = new Object();
    static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> sPendingReplies = new SimpleArrayMap<>();
    private static final Comparator<byte[]> sByteArrayComparator = new Comparator<byte[]>() { // from class: androidx.core.provider.FontsContractCompat.5
        C01565() {
        }

        @Override // java.util.Comparator
        public int compare(byte[] l, byte[] r) {
            if (l.length != r.length) {
                return l.length - r.length;
            }
            for (int i = 0; i < l.length; i++) {
                if (l[i] != r[i]) {
                    return l[i] - r[i];
                }
            }
            return 0;
        }
    };

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    private FontsContractCompat() {
    }

    static TypefaceResult getFontInternal(Context context, FontRequest request, int style) {
        try {
            FontFamilyResult result = fetchFonts(context, null, request);
            if (result.getStatusCode() == 0) {
                Typeface typeface = TypefaceCompat.createFromFontInfo(context, null, result.getFonts(), style);
                return new TypefaceResult(typeface, typeface != null ? 0 : -3);
            }
            int resultCode = result.getStatusCode() == 1 ? -2 : -3;
            return new TypefaceResult(null, resultCode);
        } catch (PackageManager.NameNotFoundException e) {
            return new TypefaceResult(null, -1);
        }
    }

    private static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(Typeface typeface, int result) {
            this.mTypeface = typeface;
            this.mResult = result;
        }
    }

    public static void resetCache() {
        sTypefaceCache.evictAll();
    }

    public static Typeface getFontSync(Context context, FontRequest request, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean isBlockingFetch, int timeout, int style) {
        SelfDestructiveThread.ReplyCallback<TypefaceResult> reply;
        String id = request.getIdentifier() + "-" + style;
        Typeface cached = sTypefaceCache.get(id);
        if (cached != null) {
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(cached);
            }
            return cached;
        }
        if (isBlockingFetch && timeout == -1) {
            TypefaceResult typefaceResult = getFontInternal(context, request, style);
            if (fontCallback != null) {
                if (typefaceResult.mResult == 0) {
                    fontCallback.callbackSuccessAsync(typefaceResult.mTypeface, handler);
                } else {
                    fontCallback.callbackFailAsync(typefaceResult.mResult, handler);
                }
            }
            return typefaceResult.mTypeface;
        }
        CallableC01521 callableC01521 = new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontsContractCompat.1
            final /* synthetic */ Context val$context;
            final /* synthetic */ String val$id;
            final /* synthetic */ FontRequest val$request;
            final /* synthetic */ int val$style;

            CallableC01521(Context context2, FontRequest request2, int style2, String id2) {
                context = context2;
                fontRequest = request2;
                i = style2;
                str = id2;
            }

            @Override // java.util.concurrent.Callable
            public TypefaceResult call() throws Exception {
                TypefaceResult typeface = FontsContractCompat.getFontInternal(context, fontRequest, i);
                if (typeface.mTypeface != null) {
                    FontsContractCompat.sTypefaceCache.put(str, typeface.mTypeface);
                }
                return typeface;
            }
        };
        if (isBlockingFetch) {
            try {
                return ((TypefaceResult) sBackgroundThread.postAndWait(callableC01521, timeout)).mTypeface;
            } catch (InterruptedException e) {
                return null;
            }
        }
        if (fontCallback == null) {
            reply = null;
        } else {
            reply = new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: androidx.core.provider.FontsContractCompat.2
                final /* synthetic */ Handler val$handler;

                C01532(Handler handler2) {
                    handler = handler2;
                }

                @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
                public void onReply(TypefaceResult typeface) {
                    if (typeface == null) {
                        fontCallback.callbackFailAsync(1, handler);
                    } else if (typeface.mResult == 0) {
                        fontCallback.callbackSuccessAsync(typeface.mTypeface, handler);
                    } else {
                        fontCallback.callbackFailAsync(typeface.mResult, handler);
                    }
                }
            };
        }
        synchronized (sLock) {
            ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> pendingReplies = sPendingReplies.get(id2);
            if (pendingReplies != null) {
                if (reply != null) {
                    pendingReplies.add(reply);
                }
                return null;
            }
            if (reply != null) {
                ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> pendingReplies2 = new ArrayList<>();
                pendingReplies2.add(reply);
                sPendingReplies.put(id2, pendingReplies2);
            }
            sBackgroundThread.postAndReply(callableC01521, new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: androidx.core.provider.FontsContractCompat.3
                final /* synthetic */ String val$id;

                C01543(String id2) {
                    str = id2;
                }

                @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
                public void onReply(TypefaceResult typeface) {
                    synchronized (FontsContractCompat.sLock) {
                        ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> replies = FontsContractCompat.sPendingReplies.get(str);
                        if (replies == null) {
                            return;
                        }
                        FontsContractCompat.sPendingReplies.remove(str);
                        for (int i = 0; i < replies.size(); i++) {
                            replies.get(i).onReply(typeface);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$1 */
    class CallableC01521 implements Callable<TypefaceResult> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$id;
        final /* synthetic */ FontRequest val$request;
        final /* synthetic */ int val$style;

        CallableC01521(Context context2, FontRequest request2, int style2, String id2) {
            context = context2;
            fontRequest = request2;
            i = style2;
            str = id2;
        }

        @Override // java.util.concurrent.Callable
        public TypefaceResult call() throws Exception {
            TypefaceResult typeface = FontsContractCompat.getFontInternal(context, fontRequest, i);
            if (typeface.mTypeface != null) {
                FontsContractCompat.sTypefaceCache.put(str, typeface.mTypeface);
            }
            return typeface;
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$2 */
    class C01532 implements SelfDestructiveThread.ReplyCallback<TypefaceResult> {
        final /* synthetic */ Handler val$handler;

        C01532(Handler handler2) {
            handler = handler2;
        }

        @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
        public void onReply(TypefaceResult typeface) {
            if (typeface == null) {
                fontCallback.callbackFailAsync(1, handler);
            } else if (typeface.mResult == 0) {
                fontCallback.callbackSuccessAsync(typeface.mTypeface, handler);
            } else {
                fontCallback.callbackFailAsync(typeface.mResult, handler);
            }
        }
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$3 */
    class C01543 implements SelfDestructiveThread.ReplyCallback<TypefaceResult> {
        final /* synthetic */ String val$id;

        C01543(String id2) {
            str = id2;
        }

        @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
        public void onReply(TypefaceResult typeface) {
            synchronized (FontsContractCompat.sLock) {
                ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> replies = FontsContractCompat.sPendingReplies.get(str);
                if (replies == null) {
                    return;
                }
                FontsContractCompat.sPendingReplies.remove(str);
                for (int i = 0; i < replies.size(); i++) {
                    replies.get(i).onReply(typeface);
                }
            }
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        public FontInfo(Uri uri, int ttcIndex, int weight, boolean italic, int resultCode) {
            this.mUri = (Uri) Preconditions.checkNotNull(uri);
            this.mTtcIndex = ttcIndex;
            this.mWeight = weight;
            this.mItalic = italic;
            this.mResultCode = resultCode;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }

        public int getResultCode() {
            return this.mResultCode;
        }
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final FontInfo[] mFonts;
        private final int mStatusCode;

        public FontFamilyResult(int statusCode, FontInfo[] fonts) {
            this.mStatusCode = statusCode;
            this.mFonts = fonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }

        public FontInfo[] getFonts() {
            return this.mFonts;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        public static final int RESULT_OK = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }

        public void onTypefaceRequestFailed(int reason) {
        }
    }

    public static void requestFont(Context context, FontRequest request, FontRequestCallback callback, Handler handler) {
        requestFontInternal(context.getApplicationContext(), request, callback, handler);
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$4 */
    class RunnableC01554 implements Runnable {
        final /* synthetic */ Context val$appContext;
        final /* synthetic */ FontRequestCallback val$callback;
        final /* synthetic */ Handler val$callerThreadHandler;
        final /* synthetic */ FontRequest val$request;

        RunnableC01554(Context context, FontRequest fontRequest, Handler handler, FontRequestCallback fontRequestCallback) {
            context = context;
            fontRequest = fontRequest;
            handler = handler;
            fontRequestCallback = fontRequestCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FontFamilyResult result = FontsContractCompat.fetchFonts(context, null, fontRequest);
                if (result.getStatusCode() != 0) {
                    int statusCode = result.getStatusCode();
                    if (statusCode == 1) {
                        handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.2
                            AnonymousClass2() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-2);
                            }
                        });
                        return;
                    } else if (statusCode == 2) {
                        handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.3
                            AnonymousClass3() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                        return;
                    } else {
                        handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.4
                            AnonymousClass4() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                        return;
                    }
                }
                FontInfo[] fonts = result.getFonts();
                if (fonts == null || fonts.length == 0) {
                    handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.5
                        AnonymousClass5() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(1);
                        }
                    });
                    return;
                }
                for (FontInfo font : fonts) {
                    if (font.getResultCode() != 0) {
                        int resultCode = font.getResultCode();
                        if (resultCode < 0) {
                            handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.6
                                AnonymousClass6() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        } else {
                            handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.7
                                final /* synthetic */ int val$resultCode;

                                AnonymousClass7(int resultCode2) {
                                    i = resultCode2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(i);
                                }
                            });
                            return;
                        }
                    }
                }
                Typeface typeface = FontsContractCompat.buildTypeface(context, null, fonts);
                if (typeface == null) {
                    handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.8
                        AnonymousClass8() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(-3);
                        }
                    });
                } else {
                    handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.9
                        final /* synthetic */ Typeface val$typeface;

                        AnonymousClass9(Typeface typeface2) {
                            typeface = typeface2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRetrieved(typeface);
                        }
                    });
                }
            } catch (PackageManager.NameNotFoundException e) {
                handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        fontRequestCallback.onTypefaceRequestFailed(-1);
                    }
                });
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-1);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$2 */
        class AnonymousClass2 implements Runnable {
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-2);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$3 */
        class AnonymousClass3 implements Runnable {
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$4 */
        class AnonymousClass4 implements Runnable {
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$5 */
        class AnonymousClass5 implements Runnable {
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(1);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$6 */
        class AnonymousClass6 implements Runnable {
            AnonymousClass6() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$7 */
        class AnonymousClass7 implements Runnable {
            final /* synthetic */ int val$resultCode;

            AnonymousClass7(int resultCode2) {
                i = resultCode2;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(i);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$8 */
        class AnonymousClass8 implements Runnable {
            AnonymousClass8() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: androidx.core.provider.FontsContractCompat$4$9 */
        class AnonymousClass9 implements Runnable {
            final /* synthetic */ Typeface val$typeface;

            AnonymousClass9(Typeface typeface2) {
                typeface = typeface2;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRetrieved(typeface);
            }
        }
    }

    private static void requestFontInternal(Context appContext, FontRequest request, FontRequestCallback callback, Handler handler) {
        Handler callerThreadHandler = new Handler();
        handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4
            final /* synthetic */ Context val$appContext;
            final /* synthetic */ FontRequestCallback val$callback;
            final /* synthetic */ Handler val$callerThreadHandler;
            final /* synthetic */ FontRequest val$request;

            RunnableC01554(Context appContext2, FontRequest request2, Handler callerThreadHandler2, FontRequestCallback callback2) {
                context = appContext2;
                fontRequest = request2;
                handler = callerThreadHandler2;
                fontRequestCallback = callback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    FontFamilyResult result = FontsContractCompat.fetchFonts(context, null, fontRequest);
                    if (result.getStatusCode() != 0) {
                        int statusCode = result.getStatusCode();
                        if (statusCode == 1) {
                            handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.2
                                AnonymousClass2() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-2);
                                }
                            });
                            return;
                        } else if (statusCode == 2) {
                            handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.3
                                AnonymousClass3() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        } else {
                            handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.4
                                AnonymousClass4() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        }
                    }
                    FontInfo[] fonts = result.getFonts();
                    if (fonts == null || fonts.length == 0) {
                        handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.5
                            AnonymousClass5() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(1);
                            }
                        });
                        return;
                    }
                    for (FontInfo font : fonts) {
                        if (font.getResultCode() != 0) {
                            int resultCode2 = font.getResultCode();
                            if (resultCode2 < 0) {
                                handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.6
                                    AnonymousClass6() {
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(-3);
                                    }
                                });
                                return;
                            } else {
                                handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.7
                                    final /* synthetic */ int val$resultCode;

                                    AnonymousClass7(int resultCode22) {
                                        i = resultCode22;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(i);
                                    }
                                });
                                return;
                            }
                        }
                    }
                    Typeface typeface2 = FontsContractCompat.buildTypeface(context, null, fonts);
                    if (typeface2 == null) {
                        handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.8
                            AnonymousClass8() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                    } else {
                        handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.9
                            final /* synthetic */ Typeface val$typeface;

                            AnonymousClass9(Typeface typeface22) {
                                typeface = typeface22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRetrieved(typeface);
                            }
                        });
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    handler.post(new Runnable() { // from class: androidx.core.provider.FontsContractCompat.4.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(-1);
                        }
                    });
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-1);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$2 */
            class AnonymousClass2 implements Runnable {
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-2);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$3 */
            class AnonymousClass3 implements Runnable {
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$4 */
            class AnonymousClass4 implements Runnable {
                AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$5 */
            class AnonymousClass5 implements Runnable {
                AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(1);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$6 */
            class AnonymousClass6 implements Runnable {
                AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$7 */
            class AnonymousClass7 implements Runnable {
                final /* synthetic */ int val$resultCode;

                AnonymousClass7(int resultCode22) {
                    i = resultCode22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(i);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$8 */
            class AnonymousClass8 implements Runnable {
                AnonymousClass8() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: androidx.core.provider.FontsContractCompat$4$9 */
            class AnonymousClass9 implements Runnable {
                final /* synthetic */ Typeface val$typeface;

                AnonymousClass9(Typeface typeface22) {
                    typeface = typeface22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRetrieved(typeface);
                }
            }
        });
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontInfo[] fonts) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fonts, 0);
    }

    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fonts, CancellationSignal cancellationSignal) throws IOException {
        HashMap<Uri, ByteBuffer> out = new HashMap<>();
        for (FontInfo font : fonts) {
            if (font.getResultCode() == 0) {
                Uri uri = font.getUri();
                if (!out.containsKey(uri)) {
                    ByteBuffer buffer = TypefaceCompatUtil.mmap(context, cancellationSignal, uri);
                    out.put(uri, buffer);
                }
            }
        }
        return Collections.unmodifiableMap(out);
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest request) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfo = getProvider(context.getPackageManager(), request, context.getResources());
        if (providerInfo == null) {
            return new FontFamilyResult(1, null);
        }
        FontInfo[] fonts = getFontFromProvider(context, request, providerInfo.authority, cancellationSignal);
        return new FontFamilyResult(0, fonts);
    }

    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest request, Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = request.getProviderAuthority();
        ProviderInfo info = packageManager.resolveContentProvider(providerAuthority, 0);
        if (info == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        if (!info.packageName.equals(request.getProviderPackage())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + request.getProviderPackage());
        }
        PackageInfo packageInfo = packageManager.getPackageInfo(info.packageName, 64);
        List<byte[]> signatures = convertToByteArrayList(packageInfo.signatures);
        Collections.sort(signatures, sByteArrayComparator);
        List<List<byte[]>> requestCertificatesList = getCertificates(request, resources);
        for (int i = 0; i < requestCertificatesList.size(); i++) {
            List<byte[]> requestSignatures = new ArrayList<>(requestCertificatesList.get(i));
            Collections.sort(requestSignatures, sByteArrayComparator);
            if (equalsByteArrayList(signatures, requestSignatures)) {
                return info;
            }
        }
        return null;
    }

    private static List<List<byte[]>> getCertificates(FontRequest request, Resources resources) {
        if (request.getCertificates() != null) {
            return request.getCertificates();
        }
        int resourceId = request.getCertificatesArrayResId();
        return FontResourcesParserCompat.readCerts(resources, resourceId);
    }

    /* renamed from: androidx.core.provider.FontsContractCompat$5 */
    class C01565 implements Comparator<byte[]> {
        C01565() {
        }

        @Override // java.util.Comparator
        public int compare(byte[] l, byte[] r) {
            if (l.length != r.length) {
                return l.length - r.length;
            }
            for (int i = 0; i < l.length; i++) {
                if (l[i] != r[i]) {
                    return l[i] - r[i];
                }
            }
            return 0;
        }
    }

    private static boolean equalsByteArrayList(List<byte[]> signatures, List<byte[]> requestSignatures) {
        if (signatures.size() != requestSignatures.size()) {
            return false;
        }
        for (int i = 0; i < signatures.size(); i++) {
            if (!Arrays.equals(signatures.get(i), requestSignatures.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatures) {
        List<byte[]> shas = new ArrayList<>();
        for (Signature signature : signatures) {
            shas.add(signature.toByteArray());
        }
        return shas;
    }

    static FontInfo[] getFontFromProvider(Context context, FontRequest request, String authority, CancellationSignal cancellationSignal) {
        Uri fileUri;
        ArrayList<FontInfo> result = new ArrayList<>();
        Uri uri = new Uri.Builder().scheme("content").authority(authority).build();
        Uri fileBaseUri = new Uri.Builder().scheme("content").authority(authority).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(uri, new String[]{"_id", Columns.FILE_ID, Columns.TTC_INDEX, Columns.VARIATION_SETTINGS, Columns.WEIGHT, Columns.ITALIC, Columns.RESULT_CODE}, "query = ?", new String[]{request.getQuery()}, null, cancellationSignal);
            } else {
                cursor = context.getContentResolver().query(uri, new String[]{"_id", Columns.FILE_ID, Columns.TTC_INDEX, Columns.VARIATION_SETTINGS, Columns.WEIGHT, Columns.ITALIC, Columns.RESULT_CODE}, "query = ?", new String[]{request.getQuery()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int resultCodeColumnIndex = cursor.getColumnIndex(Columns.RESULT_CODE);
                result = new ArrayList<>();
                int idColumnIndex = cursor.getColumnIndex("_id");
                int fileIdColumnIndex = cursor.getColumnIndex(Columns.FILE_ID);
                int ttcIndexColumnIndex = cursor.getColumnIndex(Columns.TTC_INDEX);
                int weightColumnIndex = cursor.getColumnIndex(Columns.WEIGHT);
                int italicColumnIndex = cursor.getColumnIndex(Columns.ITALIC);
                while (cursor.moveToNext()) {
                    int resultCode = resultCodeColumnIndex != -1 ? cursor.getInt(resultCodeColumnIndex) : 0;
                    int ttcIndex = ttcIndexColumnIndex != -1 ? cursor.getInt(ttcIndexColumnIndex) : 0;
                    if (fileIdColumnIndex == -1) {
                        long id = cursor.getLong(idColumnIndex);
                        fileUri = ContentUris.withAppendedId(uri, id);
                    } else {
                        long id2 = cursor.getLong(fileIdColumnIndex);
                        fileUri = ContentUris.withAppendedId(fileBaseUri, id2);
                    }
                    int weight = weightColumnIndex != -1 ? cursor.getInt(weightColumnIndex) : 400;
                    boolean italic = italicColumnIndex != -1 && cursor.getInt(italicColumnIndex) == 1;
                    result.add(new FontInfo(fileUri, ttcIndex, weight, italic, resultCode));
                }
            }
            return (FontInfo[]) result.toArray(new FontInfo[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
