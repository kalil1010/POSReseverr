package com.bobby.nfccardscanner;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class CardLoadingActivity extends AppCompatActivity {
    private static final List<String> AIDS;
    public static byte[] cardTokenByte;
    private TimerTask dataCheckTask;
    private Timer dataChecktime;
    private TimerTask deviceCheckTask;
    private Timer deviceTimer;
    private CardEmulation mCardEmulation;
    private NfcAdapter mNfcAdapter;
    private ComponentName mService;
    private ProgressBar progressBar;
    private MyReceiver reveiver;
    private Timer socketCheck;
    private TimerTask socketCheckTask;
    public static WebSocketUtil websocket = null;
    public static String cardToken = null;
    public static String cardToken2 = null;
    public static boolean refreshPage = false;
    public static BlockingQueue<String> cmdQueue = new ArrayBlockingQueue(20);
    public static BlockingQueue<String> receveQueue = new ArrayBlockingQueue(20);

    static {
        ArrayList arrayList = new ArrayList();
        AIDS = arrayList;
        arrayList.add("325041592E5359532E4444463031");
    }

    private void startCheckSocket() {
        this.socketCheck = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (CardLoadingActivity.websocket.isconnected) {
                    CardLoadingActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TextView textView = (TextView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.myTextView);
                            textView.setText("正在配对...");
                        }
                    });
                    CardLoadingActivity.this.socketCheckTask.cancel();
                    CardLoadingActivity.this.socketCheck.cancel();
                    CardLoadingActivity.this.startConnectDevice();
                    CardLoadingActivity.this.checkConnect();
                    return;
                }
                CardLoadingActivity.websocket.sendMessage("init", "");
            }
        };
        this.socketCheckTask = timerTask;
        this.socketCheck.scheduleAtFixedRate(timerTask, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkConnect() {
        Timer timeChecker = new Timer();
        TimerTask checkTask = new TimerTask() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (CardLoadingActivity.websocket.retry == "1") {
                    CardLoadingActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TextView textView = (TextView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.myTextView);
                            textView.setText("Connection failure ");
                        }
                    });
                    if (!CardLoadingActivity.websocket.isconnected) {
                        String token = SharedPreferencesHelper.getInstance(CardLoadingActivity.this.getApplicationContext()).getString("token", "");
                        String type = SharedPreferencesHelper.getInstance(CardLoadingActivity.this.getApplicationContext()).getString("type", "");
                        CardLoadingActivity.websocket = new WebSocketUtil(token, type, CardLoadingActivity.this.getApplicationContext());
                        CardLoadingActivity.websocket.init();
                        CardLoadingActivity.websocket.sendMessage("init", "");
                    }
                }
            }
        };
        timeChecker.scheduleAtFixedRate(checkTask, 0L, 1000L);
    }

    public void showExitDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferencesHelper.getInstance(CardLoadingActivity.this.getApplicationContext()).saveString("token", "");
                SharedPreferencesHelper.getInstance(CardLoadingActivity.this.getApplicationContext()).saveString("type", "");
                CardLoadingActivity.websocket.closeWebSocket();
                CardLoadingActivity.this.finish();
                CardLoadingActivity.this.exitAppAndRestart();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void startCheckLogin() {
        Timer loginTimer = new Timer();
        TimerTask loginTask = new TimerTask() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(CardLoadingActivity.websocket.login_status) && "expire".equals(CardLoadingActivity.websocket.login_status)) {
                    Intent intent = new Intent(CardLoadingActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class);
                    CardLoadingActivity.this.startActivity(intent);
                    CardLoadingActivity.websocket.login_status = null;
                }
            }
        };
        loginTimer.scheduleAtFixedRate(loginTask, 0L, 1000L);
    }

    public void exitAppAndRestart() {
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            ActivityCompat.finishAffinity(this);
        }
    }

    public void startCheckData() {
        this.dataChecktime = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (CardLoadingActivity.refreshPage) {
                    System.out.println("remote_nfc_status:" + CardLoadingActivity.websocket.remote_nfc_status);
                    if (CardLoadingActivity.websocket.remote_nfc_status) {
                        if (CardLoadingActivity.websocket.cardInfo != null) {
                            final String cardNum = CardLoadingActivity.websocket.cardInfo.get("cardNum");
                            final String type = CardLoadingActivity.websocket.cardInfo.get("type");
                            String aids = CardLoadingActivity.websocket.cardInfo.get("aids");
                            CardLoadingActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    TextView textView = (TextView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.title_text_view);
                                    textView.setText(type);
                                    TextView contentView = (TextView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.content_text_view);
                                    contentView.setText(cardNum);
                                    Util.getCurTime();
                                    CardView cv = (CardView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.top_card_view);
                                    cv.setVisibility(0);
                                }
                            });
                            if (aids.indexOf(",") > 0) {
                                aids = aids.substring(0, aids.length() - 1);
                            }
                            String[] aidArr = aids.split(",");
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("325041592E5359532E4444463031");
                            System.out.println("aid size" + aidArr.length);
                            Collections.addAll(arrayList, aidArr);
                            System.out.println("aid size" + arrayList.size());
                            System.out.println("aids:" + String.join(",", arrayList));
                            CardLoadingActivity.this.mCardEmulation.registerAidsForService(CardLoadingActivity.this.mService, "payment", arrayList);
                            CardLoadingActivity.refreshPage = false;
                        }
                    } else {
                        CardLoadingActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.6.2
                            @Override // java.lang.Runnable
                            public void run() {
                                CardView cv = (CardView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.top_card_view);
                                cv.setVisibility(4);
                            }
                        });
                    }
                }
                if (!TextUtils.isEmpty(CardLoadingActivity.websocket.login_status)) {
                    CardLoadingActivity.websocket.login_status = null;
                    SharedPreferencesHelper.getInstance(CardLoadingActivity.this.getApplicationContext()).saveString("token", "");
                    SharedPreferencesHelper.getInstance(CardLoadingActivity.this.getApplicationContext()).saveString("type", "");
                    Intent intent = new Intent(CardLoadingActivity.this.getApplicationContext(), (Class<?>) LoginActivity.class);
                    CardLoadingActivity.this.startActivity(intent);
                }
            }
        };
        this.dataCheckTask = timerTask;
        this.dataChecktime.scheduleAtFixedRate(timerTask, 0L, 1000L);
    }

    public void showCardInfo() {
        if (websocket.cardInfo != null) {
            final String cardNum = websocket.cardInfo.get("cardNum");
            final String type = websocket.cardInfo.get("type");
            String aids = websocket.cardInfo.get("aids");
            runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    TextView textView = (TextView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.title_text_view);
                    textView.setText(type);
                    TextView contentView = (TextView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.content_text_view);
                    contentView.setText(cardNum);
                    Util.getCurTime();
                    CardView cv = (CardView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.top_card_view);
                    cv.setVisibility(0);
                }
            });
            String[] aidArr = aids.substring(0, aids.length() - 1).split(",");
            ArrayList arrayList = new ArrayList();
            arrayList.add("325041592E5359532E4444463031");
            Collections.addAll(arrayList, aidArr);
            this.mCardEmulation.registerAidsForService(this.mService, "payment", arrayList);
            refreshPage = false;
        }
    }

    public void startListCmdQueue() {
        Timer queueTimer = new Timer();
        TimerTask queueTask = new TimerTask() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.8
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws InterruptedException {
                while (true) {
                    if (!CardLoadingActivity.cmdQueue.isEmpty()) {
                        try {
                            String cmd = CardLoadingActivity.cmdQueue.take();
                            System.out.println("实际发送指令" + cmd);
                            CardLoadingActivity.websocket.sendMessage("execute", cmd);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
        queueTimer.schedule(queueTask, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConnectDevice() {
        this.deviceTimer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.9
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                CardLoadingActivity.websocket.sendMessage("checkDevice", "");
                if (CardLoadingActivity.websocket.connect_device) {
                    CardLoadingActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TextView textView = (TextView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.myTextView);
                            textView.setText("配对成功,等待扫码");
                            textView.setTextColor(-1);
                        }
                    });
                } else if (!CardLoadingActivity.websocket.connect_device) {
                    CardLoadingActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.9.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TextView textView = (TextView) CardLoadingActivity.this.findViewById(com.nfc.cardscanner.R.id.myTextView);
                            textView.setText("正在配对....");
                            textView.setTextColor(SupportMenu.CATEGORY_MASK);
                        }
                    });
                }
            }
        };
        this.deviceCheckTask = timerTask;
        this.deviceTimer.scheduleAtFixedRate(timerTask, 0L, 2000L);
    }

    public void log(String message) {
        runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.10
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.nfc.cardscanner.R.layout.activity_card_loading);
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        this.mNfcAdapter = defaultAdapter;
        if (defaultAdapter == null) {
            showToast("NFC Hardware not available on Device");
            return;
        }
        if (!Util.isNFCEnabled(this)) {
            showToast("NFC is NOT Enabled, Please Enable NFC");
            return;
        }
        TextView textView = (TextView) findViewById(com.nfc.cardscanner.R.id.title_text_view);
        TextView contentView = (TextView) findViewById(com.nfc.cardscanner.R.id.content_text_view);
        CardView cv = (CardView) findViewById(com.nfc.cardscanner.R.id.top_card_view);
        ImageView bgview = (ImageView) findViewById(com.nfc.cardscanner.R.id.card_view_bg);
        String token = SharedPreferencesHelper.getInstance(getApplicationContext()).getString("token", "");
        String type = SharedPreferencesHelper.getInstance(getApplicationContext()).getString("type", "");
        if (websocket == null) {
            WebSocketUtil webSocketUtil = new WebSocketUtil(token, type, getApplicationContext());
            websocket = webSocketUtil;
            webSocketUtil.init();
        }
        log("检查链接");
        startCheckSocket();
        this.mCardEmulation = CardEmulation.getInstance(this.mNfcAdapter);
        this.mService = new ComponentName(this, (Class<?>) CardEmulationService.class);
        this.reveiver = new MyReceiver(cv, textView, contentView, this.mCardEmulation, this.mService, bgview);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.bobby.nfccardscanner.MYRECEIVER");
        registerReceiver(this.reveiver, intentFilter);
        setDefaultPayment();
        startListCmdQueue();
        startCheckLogin();
        ImageButton exitbtn = (ImageButton) findViewById(com.nfc.cardscanner.R.id.btn_exit);
        exitbtn.setOnClickListener(new View.OnClickListener() { // from class: com.bobby.nfccardscanner.CardLoadingActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CardLoadingActivity.this.showExitDialog(view);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, 1).show();
    }

    private void setDefaultPayment() {
        boolean isDefaultServiceForCategory = this.mCardEmulation.isDefaultServiceForCategory(this.mService, "payment");
        if (!isDefaultServiceForCategory) {
            Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
            intent.putExtra("category", "payment");
            intent.putExtra("component", this.mService);
            startActivityForResult(intent, 5);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        System.out.println("onResume");
        super.onResume();
        if (this.mNfcAdapter == null || !Util.isNFCEnabled(this)) {
            return;
        }
        String token = SharedPreferencesHelper.getInstance(getApplicationContext()).getString("token", "");
        String type = SharedPreferencesHelper.getInstance(getApplicationContext()).getString("type", "");
        WebSocketUtil webSocketUtil = websocket;
        if (webSocketUtil != null && webSocketUtil.websocket_status.equals("1")) {
            websocket.setToken(token);
            websocket.setType(type);
        } else {
            WebSocketUtil webSocketUtil2 = new WebSocketUtil(token, type, getApplicationContext());
            websocket = webSocketUtil2;
            webSocketUtil2.init();
        }
        boolean isDefaultServiceForCategory = this.mCardEmulation.isDefaultServiceForCategory(this.mService, "payment");
        if (!isDefaultServiceForCategory) {
            Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
            intent.putExtra("category", "payment");
            intent.putExtra("component", this.mService);
            startActivityForResult(intent, 5);
        }
        this.mCardEmulation.registerAidsForService(this.mService, "payment", AIDS);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        System.out.println("onPause");
        super.onPause();
        this.mCardEmulation.removeAidsForService(this.mService, "payment");
        this.mCardEmulation.unsetPreferredService(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.reveiver);
    }
}
