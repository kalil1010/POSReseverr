package kotlin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* compiled from: Annotations.kt */
@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, m17d2 = {"Lkotlin/annotation/Retention;", "", "value", "Lkotlin/annotation/AnnotationRetention;", "()Lkotlin/annotation/AnnotationRetention;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
@Annotations17(allowedTargets = {Annotations13.ANNOTATION_CLASS})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* renamed from: kotlin.annotation.Retention, reason: use source file name */
/* loaded from: classes.dex */
public @interface Annotations16 {
    Annotations12 value() default Annotations12.RUNTIME;
}
