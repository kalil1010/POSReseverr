package com.bobby.nfccardscanner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bobby.nfccardscanner.OkHttpHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import okhttp3.FormBody;

/* loaded from: classes2.dex */
public class LoginActivity extends AppCompatActivity {
    private Button buttonLogin;
    private LoadingPopup popup = null;
    private RadioButton radioButtonOption1;
    private RadioButton radioButtonOption2;
    private RadioGroup radioGroup;

    /* renamed from: com.bobby.nfccardscanner.LoginActivity$1 */
    class RunnableC03001 implements Runnable {
        final /* synthetic */ String val$message;

        RunnableC03001(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(LoginActivity.this.getApplicationContext(), str, 0).show();
        }
    }

    public void showToast(String message) {
        runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.LoginActivity.1
            final /* synthetic */ String val$message;

            RunnableC03001(String message2) {
                str = message2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(LoginActivity.this.getApplicationContext(), str, 0).show();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.nfc.cardscanner.R.layout.activity_login);
        this.popup = new LoadingPopup(this);
        this.radioGroup = (RadioGroup) findViewById(com.nfc.cardscanner.R.id.radioGroup);
        this.radioButtonOption1 = (RadioButton) findViewById(com.nfc.cardscanner.R.id.radioButtonOption1);
        this.radioButtonOption2 = (RadioButton) findViewById(com.nfc.cardscanner.R.id.radioButtonOption2);
        this.buttonLogin = (Button) findViewById(com.nfc.cardscanner.R.id.buttonLogin);
        String token = SharedPreferencesHelper.getInstance(getApplicationContext()).getString("token", "");
        if (!TextUtils.isEmpty(token)) {
            FormBody.Builder formBodyBuilder = new FormBody.Builder().add("token", token);
            Context mcontext = getApplicationContext();
            OkHttpHelper.sendPostRequest(Util.SERVER_PATH + "/login/getInfo", formBodyBuilder, new OkHttpHelper.OkHttpCallback() { // from class: com.bobby.nfccardscanner.LoginActivity.2
                final /* synthetic */ Context val$mcontext;

                C03012(Context mcontext2) {
                    context = mcontext2;
                }

                @Override // com.bobby.nfccardscanner.OkHttpHelper.OkHttpCallback
                public void onSuccess(String response) {
                    if (!TextUtils.isEmpty(response)) {
                        Map<String, String> result = (Map) new Gson().fromJson(response, Map.class);
                        String code = result.get("code");
                        if (!"1".equals(code)) {
                            LoginActivity.this.popup.dismiss();
                            return;
                        }
                        String type = result.get("type");
                        if ("scan".equals(type)) {
                            Intent intent = new Intent(context, (Class<?>) CardLoadingActivity.class);
                            LoginActivity.this.startActivity(intent);
                        }
                        if ("read".equals(type)) {
                            Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
                            LoginActivity.this.startActivity(intent2);
                        }
                    }
                }

                @Override // com.bobby.nfccardscanner.OkHttpHelper.OkHttpCallback
                public void onFailure(IOException e) {
                    LoginActivity.this.showToast("network error :" + e.getMessage());
                }
            });
        }
        this.buttonLogin.setOnClickListener(new ViewOnClickListenerC03023());
    }

    /* renamed from: com.bobby.nfccardscanner.LoginActivity$2 */
    class C03012 implements OkHttpHelper.OkHttpCallback {
        final /* synthetic */ Context val$mcontext;

        C03012(Context mcontext2) {
            context = mcontext2;
        }

        @Override // com.bobby.nfccardscanner.OkHttpHelper.OkHttpCallback
        public void onSuccess(String response) {
            if (!TextUtils.isEmpty(response)) {
                Map<String, String> result = (Map) new Gson().fromJson(response, Map.class);
                String code = result.get("code");
                if (!"1".equals(code)) {
                    LoginActivity.this.popup.dismiss();
                    return;
                }
                String type = result.get("type");
                if ("scan".equals(type)) {
                    Intent intent = new Intent(context, (Class<?>) CardLoadingActivity.class);
                    LoginActivity.this.startActivity(intent);
                }
                if ("read".equals(type)) {
                    Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
                    LoginActivity.this.startActivity(intent2);
                }
            }
        }

        @Override // com.bobby.nfccardscanner.OkHttpHelper.OkHttpCallback
        public void onFailure(IOException e) {
            LoginActivity.this.showToast("network error :" + e.getMessage());
        }
    }

    /* renamed from: com.bobby.nfccardscanner.LoginActivity$3 */
    class ViewOnClickListenerC03023 implements View.OnClickListener {
        ViewOnClickListenerC03023() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int selectedId = LoginActivity.this.radioGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = (RadioButton) LoginActivity.this.findViewById(selectedId);
            if (selectedRadioButton != null) {
                String username = ((EditText) LoginActivity.this.findViewById(com.nfc.cardscanner.R.id.editTextUsername)).getText().toString();
                String password = ((EditText) LoginActivity.this.findViewById(com.nfc.cardscanner.R.id.editTextPassword)).getText().toString();
                LoginActivity.this.popup.show(LoginActivity.this.getWindow().getDecorView().getRootView());
                String selectedValue = selectedRadioButton.getText().toString();
                FormBody.Builder formBodyBuilder = new FormBody.Builder().add("username", username).add("pwd", Util.md5(password)).add("type", selectedValue);
                Context context = LoginActivity.this.getApplicationContext();
                OkHttpHelper.sendPostRequest(Util.SERVER_PATH + "/login/doLogin", formBodyBuilder, new OkHttpHelper.OkHttpCallback() { // from class: com.bobby.nfccardscanner.LoginActivity.3.1
                    final /* synthetic */ Context val$context;
                    final /* synthetic */ String val$selectedValue;

                    AnonymousClass1(Context context2, String selectedValue2) {
                        context = context2;
                        str = selectedValue2;
                    }

                    @Override // com.bobby.nfccardscanner.OkHttpHelper.OkHttpCallback
                    public void onSuccess(String response) {
                        System.out.println("成功了");
                        if (!TextUtils.isEmpty(response)) {
                            LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.LoginActivity.3.1.1
                                RunnableC06561() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    LoginActivity.this.popup.dismiss();
                                }
                            });
                            Map<String, String> resultMap = (Map) new Gson().fromJson(response, Map.class);
                            String code = resultMap.get("code");
                            if (!"0".equals(code)) {
                                LoginActivity.this.showToast("登录成功");
                                String token = resultMap.get("token");
                                SharedPreferencesHelper.getInstance(context).saveString("token", token);
                                SharedPreferencesHelper.getInstance(context).saveString("type", str);
                                if (str.equals("scan")) {
                                    Intent intent = new Intent(context, (Class<?>) CardLoadingActivity.class);
                                    LoginActivity.this.startActivity(intent);
                                }
                                if (str.equals("read")) {
                                    Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
                                    LoginActivity.this.startActivity(intent2);
                                    return;
                                }
                                return;
                            }
                            String message = resultMap.get("message");
                            LoginActivity.this.showToast(message);
                        }
                    }

                    /* renamed from: com.bobby.nfccardscanner.LoginActivity$3$1$1 */
                    class RunnableC06561 implements Runnable {
                        RunnableC06561() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            LoginActivity.this.popup.dismiss();
                        }
                    }

                    @Override // com.bobby.nfccardscanner.OkHttpHelper.OkHttpCallback
                    public void onFailure(IOException e) {
                        System.out.println(e.getMessage());
                    }
                });
                return;
            }
            Toast.makeText(LoginActivity.this, "Please select an option", 0).show();
        }

        /* renamed from: com.bobby.nfccardscanner.LoginActivity$3$1 */
        class AnonymousClass1 implements OkHttpHelper.OkHttpCallback {
            final /* synthetic */ Context val$context;
            final /* synthetic */ String val$selectedValue;

            AnonymousClass1(Context context2, String selectedValue2) {
                context = context2;
                str = selectedValue2;
            }

            @Override // com.bobby.nfccardscanner.OkHttpHelper.OkHttpCallback
            public void onSuccess(String response) {
                System.out.println("成功了");
                if (!TextUtils.isEmpty(response)) {
                    LoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bobby.nfccardscanner.LoginActivity.3.1.1
                        RunnableC06561() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            LoginActivity.this.popup.dismiss();
                        }
                    });
                    Map<String, String> resultMap = (Map) new Gson().fromJson(response, Map.class);
                    String code = resultMap.get("code");
                    if (!"0".equals(code)) {
                        LoginActivity.this.showToast("登录成功");
                        String token = resultMap.get("token");
                        SharedPreferencesHelper.getInstance(context).saveString("token", token);
                        SharedPreferencesHelper.getInstance(context).saveString("type", str);
                        if (str.equals("scan")) {
                            Intent intent = new Intent(context, (Class<?>) CardLoadingActivity.class);
                            LoginActivity.this.startActivity(intent);
                        }
                        if (str.equals("read")) {
                            Intent intent2 = new Intent(context, (Class<?>) MainActivity.class);
                            LoginActivity.this.startActivity(intent2);
                            return;
                        }
                        return;
                    }
                    String message = resultMap.get("message");
                    LoginActivity.this.showToast(message);
                }
            }

            /* renamed from: com.bobby.nfccardscanner.LoginActivity$3$1$1 */
            class RunnableC06561 implements Runnable {
                RunnableC06561() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    LoginActivity.this.popup.dismiss();
                }
            }

            @Override // com.bobby.nfccardscanner.OkHttpHelper.OkHttpCallback
            public void onFailure(IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
