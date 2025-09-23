package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.Annotations12;
import kotlin.annotation.Annotations14;
import kotlin.annotation.Annotations16;
import kotlin.annotation.Annotations17;

/* compiled from: Annotations.kt */
@Target({})
@Annotations17(allowedTargets = {})
@Retention(RetentionPolicy.CLASS)
@Annotations16(Annotations12.BINARY)
@Annotations14
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001c\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005\"\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u0017\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, m17d2 = {"Lkotlin/ReplaceWith;", "", "expression", "", "imports", "", "()Ljava/lang/String;", "()[Ljava/lang/String;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
@Documented
/* renamed from: kotlin.ReplaceWith */
/* loaded from: classes.dex */
public @interface Annotations8 {
    String expression();

    String[] imports();
}
