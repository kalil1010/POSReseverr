package okhttp3.internal.p005ws;

import kotlin.Metadata;
import okio.ByteString;

/* compiled from: MessageDeflater.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, m17d2 = {"EMPTY_DEFLATE_BLOCK", "Lokio/ByteString;", "LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION", "", "okhttp"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: okhttp3.internal.ws.MessageDeflaterKt, reason: use source file name */
/* loaded from: classes.dex */
public final class MessageDeflater2 {
    private static final ByteString EMPTY_DEFLATE_BLOCK = ByteString.INSTANCE.decodeHex("000000ffff");
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;
}
