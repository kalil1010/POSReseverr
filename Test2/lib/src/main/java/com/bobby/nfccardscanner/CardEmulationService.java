package com.bobby.nfccardscanner;

import android.nfc.cardemulation.HostApduService;
import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes2.dex */
public class CardEmulationService extends HostApduService {
    private static final String GET_DATA_APDU_HEADER = "00CA0000";
    private static final String READ_DATA_APDU_HEADER = "00EA0000";
    private static final String SAMPLE_LOYALTY_CARD_AID = "F222222222";
    private static final String SELECT_APDU_HEADER = "00A40400";
    private static final String TAG = "CardEmulation";
    private static final String UPDATE_APDU_HEADER = "00B40400";
    private static final String WRITE_DATA_APDU_HEADER = "00DA0000";
    private static final byte[] SELECT_OK_SW = HexStringToByteArray("9000");
    private static final byte[] UNKNOWN_CMD_SW = HexStringToByteArray("0000");
    private static String dataStr = null;

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int reason) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x004c, code lost:
    
        r5 = r4.toLowerCase();
        java.lang.System.out.println("接收数据:" + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0067, code lost:
    
        r1 = r5;
     */
    @Override // android.nfc.cardemulation.HostApduService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] processCommandApdu(byte[] r10, android.os.Bundle r11) throws java.lang.InterruptedException {
        /*
            r9 = this;
            java.lang.String r0 = ByteArrayToHexString(r10)
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "发送指令:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
            java.util.concurrent.BlockingQueue<java.lang.String> r1 = com.bobby.nfccardscanner.CardLoadingActivity.cmdQueue
            r1.offer(r0)
            r1 = 0
            long r2 = java.lang.System.currentTimeMillis()
            java.util.concurrent.BlockingQueue<java.lang.String> r4 = com.bobby.nfccardscanner.CardLoadingActivity.receveQueue
            if (r4 == 0) goto L7c
        L28:
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r6 = 5000(0x1388, double:2.4703E-320)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L36
            java.lang.String r1 = "FFF2"
            goto L69
        L36:
            java.util.concurrent.BlockingQueue<java.lang.String> r4 = com.bobby.nfccardscanner.CardLoadingActivity.receveQueue
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L28
            java.util.concurrent.BlockingQueue<java.lang.String> r4 = com.bobby.nfccardscanner.CardLoadingActivity.receveQueue     // Catch: java.lang.InterruptedException -> L75
            java.lang.Object r4 = r4.take()     // Catch: java.lang.InterruptedException -> L75
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.InterruptedException -> L75
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.InterruptedException -> L75
            if (r5 != 0) goto L74
            java.lang.String r5 = r4.toLowerCase()     // Catch: java.lang.InterruptedException -> L75
            r4 = r5
            java.io.PrintStream r5 = java.lang.System.out     // Catch: java.lang.InterruptedException -> L75
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.InterruptedException -> L75
            r6.<init>()     // Catch: java.lang.InterruptedException -> L75
            java.lang.String r7 = "接收数据:"
            r6.append(r7)     // Catch: java.lang.InterruptedException -> L75
            r6.append(r4)     // Catch: java.lang.InterruptedException -> L75
            java.lang.String r6 = r6.toString()     // Catch: java.lang.InterruptedException -> L75
            r5.println(r6)     // Catch: java.lang.InterruptedException -> L75
            r1 = r4
        L69:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L7c
            byte[] r4 = HexStringToByteArray(r1)
            return r4
        L74:
            goto L28
        L75:
            r4 = move-exception
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            r5.<init>(r4)
            throw r5
        L7c:
            java.lang.String r4 = "FFF1"
            byte[] r4 = HexStringToByteArray(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bobby.nfccardscanner.CardEmulationService.processCommandApdu(byte[], android.os.Bundle):byte[]");
    }

    public static byte[] BuildSelectApdu(String aid) {
        return HexStringToByteArray(SELECT_APDU_HEADER + String.format("%02X", Integer.valueOf(aid.length() / 2)) + aid);
    }

    public static String ByteArrayToHexString(byte[] bytes) {
        char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & UByte.MAX_VALUE;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[(j * 2) + 1] = hexArray[v & 15];
        }
        return new String(hexChars);
    }

    public static byte[] HexStringToByteArray(String s) throws IllegalArgumentException {
        int len = s.length();
        if (len % 2 == 1) {
            throw new IllegalArgumentException("Hex string must have even number of characters");
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static byte[] ConcatArrays(byte[] first, byte[]... rest) {
        int totalLength = first.length;
        for (byte[] bArr : rest) {
            totalLength += bArr.length;
        }
        byte[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (byte[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
