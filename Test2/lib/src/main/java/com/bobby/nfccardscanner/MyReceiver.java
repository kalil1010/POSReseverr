package com.bobby.nfccardscanner;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.nfc.cardemulation.CardEmulation;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class MyReceiver extends BroadcastReceiver {
    private ImageView bgview;
    private ComponentName compoent;
    private TextView contentView;
    private CardView cview;
    private CardEmulation mCardEmulation;
    private TextView textView;
    private TextView timeView;

    public MyReceiver(CardView cview, TextView textView, TextView contentView, CardEmulation mCardEmulation, ComponentName compoent, ImageView bgview) {
        this.cview = cview;
        this.textView = textView;
        this.contentView = contentView;
        this.mCardEmulation = mCardEmulation;
        this.compoent = compoent;
        this.bgview = bgview;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        System.out.println("接收到广播通知了....");
        if ("com.bobby.nfccardscanner.MYRECEIVER".equals(intent.getAction())) {
            try {
                String data = intent.getStringExtra("data");
                if (!TextUtils.isEmpty(data)) {
                    Map<String, String> info = (Map) new Gson().fromJson(data, Map.class);
                    String action = info.get("action");
                    System.out.println("获取到action 操作:" + action);
                    if (info.get("action") == null) {
                        CardLoadingActivity.websocket.cardInfo = (Map) new Gson().fromJson(data, Map.class);
                        showCard(context);
                    } else if ("nfc_closed".equals(action)) {
                        hiddenCard();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showCard(Context context) throws Resources.NotFoundException {
        if (CardLoadingActivity.websocket.cardInfo != null) {
            CardLoadingActivity.websocket.cardInfo.get("cardNum");
            String type = CardLoadingActivity.websocket.cardInfo.get("type");
            String aids = CardLoadingActivity.websocket.cardInfo.get("aids");
            this.cview.setVisibility(0);
            Drawable drawable = null;
            String mids = aids.replace(",", "\n");
            if (aids.contains("A0000000031010")) {
                drawable = context.getResources().getDrawable(com.nfc.cardscanner.R.drawable.visa);
            }
            if (aids.contains("A0000001524010") || aids.contains("A000000152401006") || aids.contains("A0000003241010") || aids.contains("A00000015230100100000001") || aids.contains("A0000001523010010000000106")) {
                drawable = context.getResources().getDrawable(com.nfc.cardscanner.R.drawable.discover);
            }
            if (aids.contains("A0000000041010") || aids.contains("A0000000042203")) {
                drawable = context.getResources().getDrawable(com.nfc.cardscanner.R.drawable.mastercard);
            }
            if (aids.contains("A000000025010901")) {
                drawable = context.getResources().getDrawable(com.nfc.cardscanner.R.drawable.american);
            }
            if (drawable != null) {
                this.bgview.setImageDrawable(drawable);
            } else {
                this.cview.setCardBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.textView.setText(mids);
            this.textView.setTextSize(13.0f);
            this.textView.setTextColor(-1);
            this.contentView.setText(type);
            if (aids.indexOf(",") > 0 && aids.indexOf(",") == aids.length() - 1) {
                aids = aids.substring(0, aids.length() - 1);
            }
            String[] aidArr = aids.split(",");
            ArrayList arrayList = new ArrayList();
            arrayList.add("325041592E5359532E4444463031");
            System.out.println("aid size" + aidArr.length);
            Collections.addAll(arrayList, aidArr);
            System.out.println("aid contents" + String.join(",", arrayList));
            this.mCardEmulation.registerAidsForService(this.compoent, "payment", arrayList);
        }
    }

    public void hiddenCard() {
        this.bgview.setImageDrawable(null);
    }
}
