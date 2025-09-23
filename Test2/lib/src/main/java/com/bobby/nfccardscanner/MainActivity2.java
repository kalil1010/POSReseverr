package com.bobby.nfccardscanner;

import android.nfc.tech.IsoDep;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: MainActivity.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m17d2 = {"com/bobby/nfccardscanner/MainActivity$nfcConnectListen$nfcCheckTask$1", "Ljava/util/TimerTask;", "run", "", "app_debug"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: com.bobby.nfccardscanner.MainActivity$nfcConnectListen$nfcCheckTask$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MainActivity2 extends TimerTask {
    final /* synthetic */ Ref.ObjectRef $nfcCheckTimer;
    final /* synthetic */ MainActivity this$0;

    MainActivity2(MainActivity this$0, Ref.ObjectRef $captured_local_variable$1) {
        this.this$0 = this$0;
        this.$nfcCheckTimer = $captured_local_variable$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (MainActivity.access$getCisodep$p(this.this$0) != null) {
            IsoDep misoDep = MainActivity.access$getCisodep$p(this.this$0);
            if (misoDep == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.nfc.tech.IsoDep");
            }
            try {
                if (misoDep.isConnected()) {
                    this.this$0.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$nfcConnectListen$nfcCheckTask$1$run$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TextView textView = (TextView) this.this$0.this$0.findViewById(com.nfc.cardscanner.R.id.processView);
                            Intrinsics.checkNotNullExpressionValue(textView, "textView");
                            textView.setText("已连接nfc设备");
                            textView.setTextColor(-1);
                        }
                    });
                    return;
                }
                this.this$0.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$nfcConnectListen$nfcCheckTask$1$run$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextView textView = (TextView) this.this$0.this$0.findViewById(com.nfc.cardscanner.R.id.processView);
                        Intrinsics.checkNotNullExpressionValue(textView, "textView");
                        textView.setText("连接nfc失败");
                        textView.setTextColor(SupportMenu.CATEGORY_MASK);
                    }
                });
                System.out.println(MainActivity.access$getWebsocket$p(this.this$0).isconnected);
                if (MainActivity.access$getWebsocket$p(this.this$0).isconnected) {
                    this.this$0.hiddenCard();
                    MainActivity.access$getWebsocket$p(this.this$0).sendMessage("nfc_closed", "");
                }
                ((Timer) this.$nfcCheckTimer.element).cancel();
                ((Timer) this.$nfcCheckTimer.element).cancel();
            } catch (SecurityException e) {
                System.out.println("出异常了.....");
                this.this$0.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.MainActivity$nfcConnectListen$nfcCheckTask$1$run$3
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextView textView = (TextView) this.this$0.this$0.findViewById(com.nfc.cardscanner.R.id.processView);
                        Intrinsics.checkNotNullExpressionValue(textView, "textView");
                        textView.setText("连接nfc失败");
                        textView.setTextColor(SupportMenu.CATEGORY_MASK);
                        this.this$0.this$0.hiddenCard();
                    }
                });
                System.out.println(MainActivity.access$getWebsocket$p(this.this$0).isconnected);
                if (MainActivity.access$getWebsocket$p(this.this$0).isconnected) {
                    MainActivity.access$getWebsocket$p(this.this$0).sendMessage("nfc_closed", "");
                }
                ((Timer) this.$nfcCheckTimer.element).cancel();
                ((Timer) this.$nfcCheckTimer.element).cancel();
            }
        }
    }
}
