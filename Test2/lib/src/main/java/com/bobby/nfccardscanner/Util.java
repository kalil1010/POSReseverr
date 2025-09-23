package com.bobby.nfccardscanner;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.text.TextUtils;
import com.github.devnied.emvnfccard.enums.TagValueTypeEnum;
import com.github.devnied.emvnfccard.iso7816emv.EmvTags;
import com.github.devnied.emvnfccard.iso7816emv.ITag;
import com.github.devnied.emvnfccard.iso7816emv.TLV;
import com.github.devnied.emvnfccard.iso7816emv.impl.TagImpl;
import com.github.devnied.emvnfccard.utils.TlvUtil;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;
import org.apache.commons.lang3.ArrayUtils;

/* loaded from: classes2.dex */
public class Util {
    public static final ITag AID_CARD = new TagImpl("4f", TagValueTypeEnum.BINARY, "Application Identifier (AID) - card", "Identifies the application as described in ISO/IEC 7816-5");
    public static String SERVER_PATH = "http://43.153.104.243:5555";
    public static String WSS_SERVER_PATH = "ws://43.153.104.243:8765/websocket";

    public static String getAids(byte[] pData) {
        List<byte[]> ret = new ArrayList<>();
        List<TLV> listTlv = TlvUtil.getlistTLV(pData, EmvTags.AID_CARD, EmvTags.KERNEL_IDENTIFIER);
        for (TLV tlv : listTlv) {
            if (tlv.getTag() == EmvTags.KERNEL_IDENTIFIER && ret.size() != 0) {
                ret.add(ArrayUtils.addAll(ret.get(ret.size() - 1), tlv.getValueBytes()));
            } else {
                ret.add(tlv.getValueBytes());
            }
        }
        List<String> aids = new ArrayList<>();
        for (byte[] b : ret) {
            System.out.println(byteToString(b));
            aids.add(byteToString(b));
        }
        return String.join(",", aids);
    }

    public static String byteToString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int i5 = bArr[i4] & UByte.MAX_VALUE;
            int i6 = i4 * 2;
            cArr2[i6] = cArr[i5 >>> 4];
            cArr2[i6 + 1] = cArr[i5 & 15];
        }
        return new String(cArr2);
    }

    public static byte[] toByteArr(String str) {
        int length = str.length();
        if (length % 2 != 1) {
            byte[] bArr = new byte[length / 2];
            for (int i4 = 0; i4 < length; i4 += 2) {
                bArr[i4 / 2] = (byte) ((Character.digit(str.charAt(i4), 16) << 4) + Character.digit(str.charAt(i4 + 1), 16));
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string must have even number of characters");
    }

    public static String md5(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] inputBytes = input.getBytes();
            byte[] hashBytes = digest.digest(inputBytes);
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCurTime() {
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String formattedTime = sdf.format(currentTime);
        return formattedTime;
    }

    public static boolean isNFCEnabled(Context context) {
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(context);
        return nfcAdapter != null && nfcAdapter.isEnabled();
    }

    public static boolean isconnected(IsoDep isodep) {
        return isodep != null && isodep.isConnected();
    }

    public static String cmd(IsoDep isodep, String cmd) throws IOException {
        if (!isconnected(isodep) || TextUtils.isEmpty(cmd)) {
            return "";
        }
        try {
            return byteToString(isodep.transceive(toByteArr(cmd)));
        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
