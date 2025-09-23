package com.bobby.nfccardscanner;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

/* compiled from: MainActivity.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u00100\u001a\u000201J\b\u00102\u001a\u000201H\u0002J\u0006\u00103\u001a\u00020\u0018J\b\u00104\u001a\u000201H\u0002J\u0012\u00105\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0014J\u0010\u00108\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000201H\u0016J\b\u0010<\u001a\u000201H\u0016J\u0006\u0010=\u001a\u000201J\u0010\u0010>\u001a\u0002012\b\u0010?\u001a\u0004\u0018\u00010@J\u0010\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0006\u0010C\u001a\u000201J\u0006\u0010D\u001a\u000201J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\u0006\u0010G\u001a\u000201J\n\u0010H\u001a\u00020\u0005*\u00020IR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0011\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082.¢\u0006\u0004\n\u0002\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u0014X\u0082.¢\u0006\u0004\n\u0002\u0010+R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000¨\u0006J"}, m17d2 = {"Lcom/bobby/nfccardscanner/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "RESPONSEMAP", "Ljava/util/HashMap;", "", "cisodep", "Landroid/nfc/tech/IsoDep;", "cmdCheckPreTime", "", "Ljava/lang/Long;", "dataCheckPreTime", "dataCheckTask", "Ljava/util/TimerTask;", "dataChecktime", "Ljava/util/Timer;", "deviceCheckPreTime", "deviceCheckTask", "deviceTimer", "intentFiltersArray", "", "Landroid/content/IntentFilter;", "[Landroid/content/IntentFilter;", "listen_remote_status", "", "getListen_remote_status", "()Z", "setListen_remote_status", "(Z)V", "loginCheckPreTime", "mNFCAdapter", "Landroid/nfc/NfcAdapter;", "nfcCheckTask", "", "nfcCheckTimer", "pairCheckPreTime", "pendingIntent", "Landroid/app/PendingIntent;", "queueTask", "queueTimer", "socketCheck", "socketCheckTask", "techListsArray", "[[Ljava/lang/String;", "websocket", "Lcom/bobby/nfccardscanner/WebSocketUtil;", "cmd", "str", "hiddenCard", "", "initNFC", "isconnected", "nfcConnectListen", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "showCard", "showExitDialog", "view", "Landroid/view/View;", "showToast", "message", "startCheckData", "startCheckLogin", "startCheckSocket", "startConnectDevice", "startListCmdQueue", "toHexString", "", "app_debug"}, m18k = 1, m19mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class MainActivity extends AppCompatActivity {
    private final HashMap<String, String> RESPONSEMAP = new HashMap<>();
    private HashMap _$_findViewCache;
    private IsoDep cisodep;
    private Long cmdCheckPreTime;
    private Long dataCheckPreTime;
    private TimerTask dataCheckTask;
    private Timer dataChecktime;
    private Long deviceCheckPreTime;
    private TimerTask deviceCheckTask;
    private Timer deviceTimer;
    private IntentFilter[] intentFiltersArray;
    private boolean listen_remote_status;
    private Long loginCheckPreTime;
    private NfcAdapter mNFCAdapter;
    private Void nfcCheckTask;
    private Void nfcCheckTimer;
    private Long pairCheckPreTime;
    private PendingIntent pendingIntent;
    private TimerTask queueTask;
    private Timer queueTimer;
    private Timer socketCheck;
    private TimerTask socketCheckTask;
    private String[][] techListsArray;
    private WebSocketUtil websocket;

    public void _$_clearFindViewByIdCache() {
        HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public static final /* synthetic */ IsoDep access$getCisodep$p(MainActivity $this) {
        IsoDep isoDep = $this.cisodep;
        if (isoDep == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cisodep");
        }
        return isoDep;
    }

    public static final /* synthetic */ Timer access$getSocketCheck$p(MainActivity $this) {
        Timer timer = $this.socketCheck;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketCheck");
        }
        return timer;
    }

    public static final /* synthetic */ TimerTask access$getSocketCheckTask$p(MainActivity $this) {
        TimerTask timerTask = $this.socketCheckTask;
        if (timerTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketCheckTask");
        }
        return timerTask;
    }

    public static final /* synthetic */ WebSocketUtil access$getWebsocket$p(MainActivity $this) {
        WebSocketUtil webSocketUtil = $this.websocket;
        if (webSocketUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("websocket");
        }
        return webSocketUtil;
    }

    public final boolean getListen_remote_status() {
        return this.listen_remote_status;
    }

    public final void setListen_remote_status(boolean z) {
        this.listen_remote_status = z;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.nfc.cardscanner.R.layout.activity_main);
        final String token = SharedPreferencesHelper.getInstance(getApplicationContext()).getString("token", "");
        final String type = SharedPreferencesHelper.getInstance(getApplicationContext()).getString("type", "");
        if (TextUtils.isEmpty(token)) {
            Intent intent = new Intent(this, (Class<?>) LoginActivity.class);
            startActivity(intent);
        }
        new Thread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity.onCreate.1
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.websocket = new WebSocketUtil(token, type, MainActivity.this.getApplicationContext());
                MainActivity.access$getWebsocket$p(MainActivity.this).init();
                MainActivity.this.startCheckSocket();
                MainActivity.this.startCheckLogin();
            }
        }).start();
        ImageButton exitbtn1 = (ImageButton) findViewById(com.nfc.cardscanner.R.id.btn_exit1);
        exitbtn1.setOnClickListener(new View.OnClickListener() { // from class: com.bobby.nfccardscanner.MainActivity.onCreate.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.showExitDialog(view);
            }
        });
        initNFC();
    }

    private final void initNFC() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        this.mNFCAdapter = defaultAdapter;
        if (defaultAdapter == null) {
            showToast("NFC Hardware not available on Device");
        } else {
            Intrinsics.checkNotNull(defaultAdapter);
            if (!defaultAdapter.isEnabled()) {
                showToast("NFC is NOT Enabled, Please Enable NFC");
            }
        }
        Intent intent = new Intent(this, getClass());
        intent.addFlags(536870912);
        if (Build.VERSION.SDK_INT >= 31) {
            PendingIntent activity = PendingIntent.getActivity(this, 123, intent, 167772160);
            Intrinsics.checkNotNullExpressionValue(activity, "PendingIntent.getActivit…, 123, intent, 167772160)");
            this.pendingIntent = activity;
        } else {
            PendingIntent activity2 = PendingIntent.getActivity(this, 123, intent, 134217728);
            Intrinsics.checkNotNullExpressionValue(activity2, "PendingIntent.getActivit…s, 123, intent,134217728)");
            this.pendingIntent = activity2;
        }
        this.intentFiltersArray = new IntentFilter[]{new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
        String name = NfcA.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "NfcA::class.java.name");
        this.techListsArray = new String[][]{new String[]{name}};
    }

    /* compiled from: MainActivity.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m17d2 = {"com/bobby/nfccardscanner/MainActivity$startCheckSocket$1", "Ljava/util/TimerTask;", "run", "", "app_debug"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: com.bobby.nfccardscanner.MainActivity$startCheckSocket$1 */
    public static final class C03091 extends TimerTask {
        C03091() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MainActivity.this.deviceCheckPreTime = Long.valueOf(System.currentTimeMillis());
            System.out.println("websocket 链接检查线程....." + MainActivity.access$getWebsocket$p(MainActivity.this).isconnected + StringUtils.SPACE + MainActivity.this.deviceCheckPreTime);
            if (MainActivity.access$getWebsocket$p(MainActivity.this).isconnected) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$startCheckSocket$1$run$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextView textView = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.processView);
                        Intrinsics.checkNotNullExpressionValue(textView, "textView");
                        textView.setText("Connecting to device...");
                    }
                });
                MainActivity.access$getSocketCheckTask$p(MainActivity.this).cancel();
                MainActivity.access$getSocketCheck$p(MainActivity.this).cancel();
                MainActivity.this.startConnectDevice();
                return;
            }
            MainActivity.access$getWebsocket$p(MainActivity.this).sendMessage("init", "");
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$startCheckSocket$1$run$2
                @Override // java.lang.Runnable
                public final void run() {
                    TextView textView = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.processView);
                    Intrinsics.checkNotNullExpressionValue(textView, "textView");
                    textView.setText("正在连接,请稍等...");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startCheckSocket() {
        this.socketCheck = new Timer();
        this.socketCheckTask = new C03091();
        Timer timer = this.socketCheck;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketCheck");
        }
        TimerTask timerTask = this.socketCheckTask;
        if (timerTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socketCheckTask");
        }
        timer.scheduleAtFixedRate(timerTask, 0L, 1000L);
    }

    public final void startListCmdQueue() {
        this.queueTimer = new Timer();
        this.queueTask = new TimerTask() { // from class: com.bobby.nfccardscanner.MainActivity.startListCmdQueue.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws InterruptedException {
                String re;
                while (true) {
                    MainActivity.this.cmdCheckPreTime = Long.valueOf(System.currentTimeMillis());
                    if (MainActivity.access$getWebsocket$p(MainActivity.this) != null && !MainActivity.access$getWebsocket$p(MainActivity.this).ReceiveQue.isEmpty()) {
                        try {
                            String cmdStr = MainActivity.access$getWebsocket$p(MainActivity.this).ReceiveQue.take();
                            System.out.println("接收指令:" + cmdStr);
                            if (MainActivity.this.isconnected()) {
                                System.out.println("执行指令:" + cmdStr);
                                if (!"00A404000E325041592E5359532E444446303100".equals(cmdStr)) {
                                    re = MainActivity.this.cmd(cmdStr);
                                } else {
                                    System.out.println("走缓存");
                                    re = String.valueOf(MainActivity.this.RESPONSEMAP.get("res"));
                                }
                                System.out.println("执行结果:" + re);
                                MainActivity.access$getWebsocket$p(MainActivity.this).sendMessage("execute_result", re);
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        Timer timer = this.queueTimer;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queueTimer");
        }
        TimerTask timerTask = this.queueTask;
        if (timerTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queueTask");
        }
        timer.schedule(timerTask, 0L);
    }

    /* compiled from: MainActivity.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m17d2 = {"com/bobby/nfccardscanner/MainActivity$startCheckData$1", "Ljava/util/TimerTask;", "run", "", "app_debug"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: com.bobby.nfccardscanner.MainActivity$startCheckData$1 */
    public static final class C03081 extends TimerTask {
        C03081() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MainActivity.this.dataCheckPreTime = Long.valueOf(System.currentTimeMillis());
            if (MainActivity.access$getWebsocket$p(MainActivity.this).refresh && MainActivity.access$getWebsocket$p(MainActivity.this).cardInfo != null) {
                final String cardNum = MainActivity.access$getWebsocket$p(MainActivity.this).cardInfo.get("cardNum");
                final String type = MainActivity.access$getWebsocket$p(MainActivity.this).cardInfo.get("type");
                MainActivity.access$getWebsocket$p(MainActivity.this).cardInfo.get("aids");
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$startCheckData$1$run$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextView textView = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.main_title_text_view);
                        Intrinsics.checkNotNullExpressionValue(textView, "textView");
                        textView.setText(type);
                        TextView contentView = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.main_content_text_view);
                        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
                        contentView.setText(cardNum);
                        CardView cv = (CardView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.card_view);
                        Intrinsics.checkNotNullExpressionValue(cv, "cv");
                        cv.setVisibility(0);
                        TextView m1 = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.viewtip);
                        Intrinsics.checkNotNullExpressionValue(m1, "m1");
                        m1.setVisibility(8);
                        String mtime = Util.getCurTime();
                        TextView m2 = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.main_time_view);
                        Intrinsics.checkNotNullExpressionValue(m2, "m2");
                        m2.setText("读取时间:" + mtime);
                    }
                });
                MainActivity.access$getWebsocket$p(MainActivity.this).refresh = false;
            }
        }
    }

    public final void startCheckData() {
        this.dataChecktime = new Timer();
        this.dataCheckTask = new C03081();
        Timer timer = this.dataChecktime;
        Intrinsics.checkNotNull(timer);
        timer.scheduleAtFixedRate(this.dataCheckTask, 0L, 1000L);
    }

    public final void showCard() throws Resources.NotFoundException {
        System.out.println("显示卡片");
        WebSocketUtil webSocketUtil = this.websocket;
        if (webSocketUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("websocket");
        }
        String aids = webSocketUtil.cardInfo.get("aids");
        Drawable drawable = (Drawable) null;
        if (aids != null) {
            aids = StringsKt.replace$default(aids, ",", "\n", false, 4, (Object) null);
        }
        if (aids != null && StringsKt.contains$default((CharSequence) aids, (CharSequence) "A0000000031010", false, 2, (Object) null)) {
            TextView textView = (TextView) findViewById(com.nfc.cardscanner.R.id.main_title_text_view);
            Intrinsics.checkNotNullExpressionValue(textView, "textView");
            textView.setText(aids);
            drawable = getResources().getDrawable(com.nfc.cardscanner.R.drawable.visa);
        }
        if (aids != null && (StringsKt.contains$default((CharSequence) aids, (CharSequence) "A0000001524010", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) aids, (CharSequence) "A000000152401006", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) aids, (CharSequence) "A0000003241010", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) aids, (CharSequence) "A00000015230100100000001", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) aids, (CharSequence) "A0000001523010010000000106", false, 2, (Object) null))) {
            TextView textView2 = (TextView) findViewById(com.nfc.cardscanner.R.id.main_title_text_view);
            Intrinsics.checkNotNullExpressionValue(textView2, "textView");
            textView2.setText(aids);
            drawable = getResources().getDrawable(com.nfc.cardscanner.R.drawable.discover);
        }
        if (aids != null && (StringsKt.contains$default((CharSequence) aids, (CharSequence) "A0000000041010", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) aids, (CharSequence) "A0000000042203", false, 2, (Object) null))) {
            TextView textView3 = (TextView) findViewById(com.nfc.cardscanner.R.id.main_title_text_view);
            Intrinsics.checkNotNullExpressionValue(textView3, "textView");
            textView3.setText(aids);
            drawable = getResources().getDrawable(com.nfc.cardscanner.R.drawable.mastercard);
        }
        if (aids != null && StringsKt.contains$default((CharSequence) aids, (CharSequence) "A000000025010901", false, 2, (Object) null)) {
            TextView textView4 = (TextView) findViewById(com.nfc.cardscanner.R.id.main_title_text_view);
            Intrinsics.checkNotNullExpressionValue(textView4, "textView");
            textView4.setText(aids);
            drawable = getResources().getDrawable(com.nfc.cardscanner.R.drawable.american);
        }
        CardView cv = (CardView) findViewById(com.nfc.cardscanner.R.id.card_view);
        Intrinsics.checkNotNullExpressionValue(cv, "cv");
        cv.setVisibility(0);
        ImageView cardReadView = (ImageView) findViewById(com.nfc.cardscanner.R.id.card_view_bg_read);
        if (drawable != null) {
            cardReadView.setImageDrawable(drawable);
        } else {
            cv.setCardBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* compiled from: MainActivity.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m17d2 = {"com/bobby/nfccardscanner/MainActivity$startConnectDevice$1", "Ljava/util/TimerTask;", "run", "", "app_debug"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: com.bobby.nfccardscanner.MainActivity$startConnectDevice$1 */
    public static final class C03101 extends TimerTask {
        C03101() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MainActivity.this.pairCheckPreTime = Long.valueOf(System.currentTimeMillis());
            MainActivity.access$getWebsocket$p(MainActivity.this).sendMessage("checkDevice", "");
            if (WebSocketUtil.isExpired) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$startConnectDevice$1$run$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextView textView = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.processView);
                        Intrinsics.checkNotNullExpressionValue(textView, "textView");
                        textView.setText("Session lost, please log in again");
                        textView.setTextColor(SupportMenu.CATEGORY_MASK);
                    }
                });
            }
            if (MainActivity.access$getWebsocket$p(MainActivity.this).connect_device && !MainActivity.this.getListen_remote_status()) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$startConnectDevice$1$run$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextView textView = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.processView);
                        Intrinsics.checkNotNullExpressionValue(textView, "textView");
                        textView.setText("配对成功");
                        textView.setTextColor(-1);
                        MainActivity.this.setListen_remote_status(true);
                    }
                });
            }
            if (!MainActivity.access$getWebsocket$p(MainActivity.this).connect_device) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$startConnectDevice$1$run$3
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextView textView = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.processView);
                        Intrinsics.checkNotNullExpressionValue(textView, "textView");
                        textView.setText("正在配对...");
                        textView.setTextColor(SupportMenu.CATEGORY_MASK);
                        MainActivity.this.setListen_remote_status(false);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConnectDevice() {
        this.deviceTimer = new Timer();
        this.deviceCheckTask = new C03101();
        Timer timer = this.deviceTimer;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceTimer");
        }
        TimerTask timerTask = this.deviceCheckTask;
        if (timerTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceCheckTask");
        }
        timer.scheduleAtFixedRate(timerTask, 0L, 2000L);
    }

    public final void startCheckLogin() {
        Timer loginTimer = new Timer();
        TimerTask loginTask = new TimerTask() { // from class: com.bobby.nfccardscanner.MainActivity$startCheckLogin$loginTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.loginCheckPreTime = Long.valueOf(System.currentTimeMillis());
                if (!TextUtils.isEmpty(MainActivity.access$getWebsocket$p(this.this$0).login_status) && Intrinsics.areEqual("expire", MainActivity.access$getWebsocket$p(this.this$0).login_status)) {
                    Intent intent = new Intent(this.this$0.getApplicationContext(), (Class<?>) LoginActivity.class);
                    this.this$0.startActivity(intent);
                    MainActivity.access$getWebsocket$p(this.this$0).login_status = (String) null;
                }
            }
        };
        loginTimer.scheduleAtFixedRate(loginTask, 0L, 1000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Timer] */
    private final void nfcConnectListen() {
        Ref.ObjectRef nfcCheckTimer = new Ref.ObjectRef();
        nfcCheckTimer.element = new Timer();
        MainActivity2 nfcCheckTask = new MainActivity2(this, nfcCheckTimer);
        ((Timer) nfcCheckTimer.element).scheduleAtFixedRate(nfcCheckTask, 0L, 1000L);
    }

    public final void hiddenCard() {
        runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity.hiddenCard.1
            @Override // java.lang.Runnable
            public final void run() {
                ImageView cardReadView = (ImageView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.card_view_bg_read);
                cardReadView.setImageDrawable(null);
                TextView txtview = (TextView) MainActivity.this.findViewById(com.nfc.cardscanner.R.id.main_title_text_view);
                Intrinsics.checkNotNullExpressionValue(txtview, "txtview");
                txtview.setText("");
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        System.out.println("onPause");
        NfcAdapter nfcAdapter = this.mNFCAdapter;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bobby.nfccardscanner.MainActivity.onResume():void");
    }

    public final void showExitDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.bobby.nfccardscanner.MainActivity.showExitDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialog, int which) {
                SharedPreferencesHelper.getInstance(MainActivity.this.getApplicationContext()).saveString("token", "");
                SharedPreferencesHelper.getInstance(MainActivity.this.getApplicationContext()).saveString("type", "");
                MainActivity.access$getWebsocket$p(MainActivity.this).closeWebSocket();
                MainActivity.this.finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.bobby.nfccardscanner.MainActivity.showExitDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e A[Catch: IOException -> 0x0121, TryCatch #0 {IOException -> 0x0121, blocks: (B:12:0x004d, B:13:0x0050, B:15:0x005e, B:17:0x0064, B:20:0x007d, B:21:0x0080, B:23:0x0087, B:24:0x008a, B:26:0x00dc, B:27:0x00e8, B:29:0x00f5, B:30:0x00f8, B:32:0x00fc, B:33:0x00ff, B:35:0x0106, B:36:0x0109, B:38:0x0112, B:39:0x0115), top: B:46:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[Catch: IOException -> 0x0121, TRY_LEAVE, TryCatch #0 {IOException -> 0x0121, blocks: (B:12:0x004d, B:13:0x0050, B:15:0x005e, B:17:0x0064, B:20:0x007d, B:21:0x0080, B:23:0x0087, B:24:0x008a, B:26:0x00dc, B:27:0x00e8, B:29:0x00f5, B:30:0x00f8, B:32:0x00fc, B:33:0x00ff, B:35:0x0106, B:36:0x0109, B:38:0x0112, B:39:0x0115), top: B:46:0x004d }] */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onNewIntent(android.content.Intent r13) throws android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bobby.nfccardscanner.MainActivity.onNewIntent(android.content.Intent):void");
    }

    public final String toHexString(byte[] toHexString) {
        Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        return ArraysKt.joinToString$default(toHexString, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Functions2) new Functions2<Byte, CharSequence>() { // from class: com.bobby.nfccardscanner.MainActivity.toHexString.1
            @Override // kotlin.jvm.functions.Functions2
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }

            public final CharSequence invoke(byte it) {
                String str = String.format("%02x", Byte.valueOf(it));
                Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(\"%02x\", it)");
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String upperCase = str.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return upperCase;
            }
        }, 30, (Object) null);
    }

    private final void showToast(String message) {
        Toast.makeText(this, message, 1).show();
    }

    public final boolean isconnected() {
        IsoDep isoDep = this.cisodep;
        if (isoDep == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cisodep");
        }
        return isoDep != null && isoDep.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String cmd(String str) {
        if (isconnected() && str != null) {
            if (!(str.length() == 0)) {
                try {
                    IsoDep isoDep = this.cisodep;
                    if (isoDep == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cisodep");
                    }
                    String strByteToString = Util.byteToString(isoDep.transceive(Util.toByteArr(str)));
                    Intrinsics.checkNotNullExpressionValue(strByteToString, "Util.byteToString(cisode…ive(Util.toByteArr(str)))");
                    return strByteToString;
                } catch (IOException e) {
                    return "";
                }
            }
        }
        return "";
    }
}
