package com.bobby.nfccardscanner;

import android.content.Context;
import android.content.Intent;
import android.nfc.tech.IsoDep;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class WebSocketUtil {
    public static Map<String, String> RESPONSEMAP = new HashMap();
    public static boolean isExpired = false;
    public boolean connect_device;
    private Context context;
    private Timer heartBeatTimer;
    public boolean isconnected;
    private IsoDep isodep;
    private String token;
    private String type;
    public WebSocket webSocket = null;
    public boolean refresh = false;
    public boolean remote_nfc_status = false;
    public Map<String, String> cardInfo = null;
    public String retry = "0";
    public String websocket_status = "1";
    public String login_status = "";
    public BlockingQueue<String> ReceiveQue = new ArrayBlockingQueue(20);

    public IsoDep getIsodep() {
        return this.isodep;
    }

    public void setIsodep(IsoDep isodep) {
        this.isodep = isodep;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WebSocketUtil(String token, String type, Context context) {
        this.token = token;
        this.type = type;
        this.context = context;
    }

    public void init() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Util.WSS_SERVER_PATH).build();
        WebSocketListener listener = new WebSocketListener() { // from class: com.bobby.nfccardscanner.WebSocketUtil.1
            C03151() {
            }

            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                System.out.println("WebSocket opened");
                Map<String, String> command = new HashMap<>();
                command.put("cmd", "init");
                command.put("token", WebSocketUtil.this.token);
                command.put("type", WebSocketUtil.this.type);
                String json = new Gson().toJson(command);
                webSocket.send(json);
                WebSocketUtil.this.startHeartbeat();
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String text) {
                WebSocketUtil.this.isconnected = true;
                super.onMessage(webSocket, text);
                WebSocketUtil.this.handleMessage(text);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                WebSocketUtil.this.isconnected = true;
                super.onMessage(webSocket, bytes);
                System.out.println("Received bytes: " + bytes.hex());
            }

            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int code, String reason) {
                System.out.println("websocket close");
                super.onClosed(webSocket, code, reason);
                WebSocketUtil.this.isconnected = false;
                WebSocketUtil.this.websocket_status = "0";
                WebSocketUtil.this.stopHeartbeat();
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                System.out.println("websocket onFailure");
                WebSocketUtil.this.isconnected = false;
                WebSocketUtil.this.websocket_status = "0";
                super.onFailure(webSocket, t, response);
                System.err.println("WebSocket failure: " + t.getMessage());
                WebSocketUtil.this.retry = "1";
                WebSocketUtil.this.stopHeartbeat();
            }
        };
        this.webSocket = client.newWebSocket(request, listener);
    }

    /* renamed from: com.bobby.nfccardscanner.WebSocketUtil$1 */
    class C03151 extends WebSocketListener {
        C03151() {
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            System.out.println("WebSocket opened");
            Map<String, String> command = new HashMap<>();
            command.put("cmd", "init");
            command.put("token", WebSocketUtil.this.token);
            command.put("type", WebSocketUtil.this.type);
            String json = new Gson().toJson(command);
            webSocket.send(json);
            WebSocketUtil.this.startHeartbeat();
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, String text) {
            WebSocketUtil.this.isconnected = true;
            super.onMessage(webSocket, text);
            WebSocketUtil.this.handleMessage(text);
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            WebSocketUtil.this.isconnected = true;
            super.onMessage(webSocket, bytes);
            System.out.println("Received bytes: " + bytes.hex());
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket webSocket, int code, String reason) {
            System.out.println("websocket close");
            super.onClosed(webSocket, code, reason);
            WebSocketUtil.this.isconnected = false;
            WebSocketUtil.this.websocket_status = "0";
            WebSocketUtil.this.stopHeartbeat();
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            System.out.println("websocket onFailure");
            WebSocketUtil.this.isconnected = false;
            WebSocketUtil.this.websocket_status = "0";
            super.onFailure(webSocket, t, response);
            System.err.println("WebSocket failure: " + t.getMessage());
            WebSocketUtil.this.retry = "1";
            WebSocketUtil.this.stopHeartbeat();
        }
    }

    public void sendMessage(String cmd, String data) {
        Map<String, String> command = new HashMap<>();
        command.put("cmd", cmd);
        command.put("token", this.token);
        command.put("type", this.type);
        if (!TextUtils.isEmpty(data)) {
            command.put("data", data);
        }
        String json = new Gson().toJson(command);
        this.webSocket.send(json);
    }

    public void handleMessage(String message) {
        String re;
        try {
            if (!TextUtils.isEmpty(message)) {
                Map<String, String> result = (Map) new Gson().fromJson(message, Map.class);
                String cmd = result.get("cmd");
                if ("checkDevice".equals(cmd)) {
                    String code = result.get("code");
                    if ("1".equals(code)) {
                        this.connect_device = true;
                    } else {
                        this.connect_device = false;
                    }
                    String sessionId = result.get("sessionId");
                    if (!TextUtils.isEmpty(sessionId) && !TextUtils.isEmpty(this.token)) {
                        if (!sessionId.equals(this.token)) {
                            isExpired = true;
                        } else {
                            isExpired = false;
                        }
                    }
                }
                if ("scan_result".equals(cmd)) {
                    String data = result.get("data");
                    CardLoadingActivity.cardToken = data;
                    CardLoadingActivity.refreshPage = true;
                    System.out.println("接收数据：" + data);
                }
                if ("scan_result2".equals(cmd)) {
                    String data2 = result.get("data");
                    CardLoadingActivity.cardToken2 = data2;
                    CardLoadingActivity.refreshPage = true;
                    System.out.println("接收数据：" + data2);
                }
                if ("scan_info".equals(cmd)) {
                    String data3 = result.get("data");
                    this.cardInfo = (Map) new Gson().fromJson(data3, Map.class);
                    CardLoadingActivity.refreshPage = true;
                    this.remote_nfc_status = true;
                    System.out.println("接收数据：" + data3);
                    Intent intent = new Intent("com.bobby.nfccardscanner.MYRECEIVER");
                    intent.putExtra("data", data3);
                    this.context.sendBroadcast(intent);
                }
                if ("execute".equals(cmd)) {
                    String cmddata = result.get("data");
                    System.out.println("接收指令数据：" + cmddata);
                    if (!TextUtils.isEmpty(cmddata)) {
                        if ("00A404000E325041592E5359532E444446303100".equals(cmddata)) {
                            re = RESPONSEMAP.get("res");
                        } else {
                            re = Util.cmd(this.isodep, cmddata);
                        }
                        if (!TextUtils.isEmpty(re)) {
                            re = re.toLowerCase();
                        }
                        System.out.println("获取指令数据结果：" + re);
                        sendMessage("execute_result", re);
                    }
                }
                if ("execute_result".equals(cmd)) {
                    String data4 = result.get("data");
                    if (!StringUtils.isEmpty(data4)) {
                        CardLoadingActivity.receveQueue.offer(data4);
                    }
                }
                if ("Heartbeat".equals(cmd)) {
                    String code2 = result.get("code");
                    if ("0".equals(code2)) {
                        this.login_status = "expire";
                    }
                }
                if ("nfc_closed".equals(cmd)) {
                    this.remote_nfc_status = false;
                    CardLoadingActivity.refreshPage = true;
                    System.out.println("接收指令：" + cmd);
                    Intent intent2 = new Intent("com.bobby.nfccardscanner.MYRECEIVER");
                    Map<String, String> actions = new HashMap<>();
                    actions.put("action", "nfc_closed");
                    intent2.putExtra("data", new Gson().toJson(actions));
                    this.context.sendBroadcast(intent2);
                }
            }
        } catch (Exception e) {
            System.out.println("接受出错了");
            e.printStackTrace();
        }
    }

    /* renamed from: com.bobby.nfccardscanner.WebSocketUtil$2 */
    class C03162 extends TimerTask {
        C03162() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (WebSocketUtil.this.webSocket != null) {
                Map<String, String> result = new HashMap<>();
                result.put("cmd", "Heartbeat");
                result.put("token", WebSocketUtil.this.token);
                result.put("type", WebSocketUtil.this.type);
                String json = new Gson().toJson(result);
                WebSocketUtil.this.webSocket.send(json);
            }
        }
    }

    public void startHeartbeat() {
        Timer timer = new Timer();
        this.heartBeatTimer = timer;
        timer.scheduleAtFixedRate(new TimerTask() { // from class: com.bobby.nfccardscanner.WebSocketUtil.2
            C03162() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (WebSocketUtil.this.webSocket != null) {
                    Map<String, String> result = new HashMap<>();
                    result.put("cmd", "Heartbeat");
                    result.put("token", WebSocketUtil.this.token);
                    result.put("type", WebSocketUtil.this.type);
                    String json = new Gson().toJson(result);
                    WebSocketUtil.this.webSocket.send(json);
                }
            }
        }, 0L, 10000L);
    }

    public void closeWebSocket() {
        stopHeartbeat();
        this.websocket_status = "0";
        this.webSocket.close(1000, "User-initiated close");
    }

    public void stopHeartbeat() {
        Timer timer = this.heartBeatTimer;
        if (timer != null) {
            timer.cancel();
            this.heartBeatTimer = null;
        }
    }
}
