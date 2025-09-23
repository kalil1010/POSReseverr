package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.Annotations12;
import kotlin.annotation.Annotations13;
import kotlin.annotation.Annotations16;
import kotlin.annotation.Annotations17;

/* compiled from: Experimental.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0002\u0018\u00002\u00020\u0001B$\u0012\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004R\u001f\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, m17d2 = {"Lkotlin/WasExperimental;", "", "markerClass", "", "Lkotlin/reflect/KClass;", "()[Ljava/lang/Class;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
@Annotations17(allowedTargets = {Annotations13.CLASS, Annotations13.PROPERTY, Annotations13.CONSTRUCTOR, Annotations13.FUNCTION, Annotations13.TYPEALIAS})
@Retention(RetentionPolicy.CLASS)
@Annotations16(Annotations12.BINARY)
/* renamed from: kotlin.WasExperimental, reason: use source file name */
/* loaded from: classes.dex */
public @interface Experimental3 {
    Class<? extends Annotation>[] markerClass();
}
