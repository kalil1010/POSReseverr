package com.bobby.nfccardscanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/* loaded from: classes2.dex */
public class LoadingPopup {
    private PopupWindow popupWindow;

    public LoadingPopup(Context context) {
        View popupView = LayoutInflater.from(context).inflate(com.nfc.cardscanner.R.layout.loading_popup, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(popupView, -2, -2, true);
        this.popupWindow = popupWindow;
        popupWindow.setOutsideTouchable(false);
    }

    public void show(View anchorView) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && !popupWindow.isShowing()) {
            this.popupWindow.showAtLocation(anchorView, 17, 0, 0);
        }
    }

    public void dismiss() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }
}
