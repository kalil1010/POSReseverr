package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.Annotations13;
import kotlin.annotation.Annotations14;
import kotlin.annotation.Annotations17;

/* compiled from: Annotations.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Annotations14
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001c\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007R\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\tR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\n¨\u0006\u000b"}, m17d2 = {"Lkotlin/Deprecated;", "", "message", "", "replaceWith", "Lkotlin/ReplaceWith;", "level", "Lkotlin/DeprecationLevel;", "()Lkotlin/DeprecationLevel;", "()Ljava/lang/String;", "()Lkotlin/ReplaceWith;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
@Annotations17(allowedTargets = {Annotations13.CLASS, Annotations13.FUNCTION, Annotations13.PROPERTY, Annotations13.ANNOTATION_CLASS, Annotations13.CONSTRUCTOR, Annotations13.PROPERTY_SETTER, Annotations13.PROPERTY_GETTER, Annotations13.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: kotlin.Deprecated */
/* loaded from: classes.dex */
public @interface Annotations {
    Annotations3 level() default Annotations3.WARNING;

    String message();

    Annotations8 replaceWith() default @Annotations8(expression = "", imports = {});
}
