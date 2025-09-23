package com.bobby.nfccardscanner;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class OkHttpHelper {
    private static final OkHttpClient client = new OkHttpClient();

    public interface OkHttpCallback {
        void onFailure(IOException iOException);

        void onSuccess(String str);
    }

    public static void sendPostRequest(String url, FormBody.Builder formBodyBuilder, final OkHttpCallback callback) {
        RequestBody formBody = formBodyBuilder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        client.newCall(request).enqueue(new Callback() { // from class: com.bobby.nfccardscanner.OkHttpHelper.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    callback.onSuccess(responseData);
                    return;
                }
                callback.onFailure(new IOException("Unexpected response code: " + response.code()));
            }
        });
    }
}
