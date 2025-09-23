package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.Annotations12;
import kotlin.annotation.Annotations13;
import kotlin.annotation.Annotations14;
import kotlin.annotation.Annotations16;
import kotlin.annotation.Annotations17;

/* compiled from: JvmPlatformAnnotations.kt */
@Target({ElementType.TYPE, ElementType.METHOD})
@Annotations17(allowedTargets = {Annotations13.CLASS, Annotations13.FUNCTION, Annotations13.PROPERTY, Annotations13.TYPE})
@Retention(RetentionPolicy.CLASS)
@Annotations16(Annotations12.BINARY)
@Annotations14
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, m17d2 = {"Lkotlin/jvm/JvmSuppressWildcards;", "", "suppress", "", "()Z", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
@Documented
/* renamed from: kotlin.jvm.JvmSuppressWildcards, reason: use source file name */
/* loaded from: classes.dex */
public @interface JvmPlatformAnnotations7 {
    boolean suppress() default true;
}
