package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.Annotations12;
import kotlin.annotation.Annotations13;
import kotlin.annotation.Annotations16;
import kotlin.annotation.Annotations17;

/* compiled from: Annotations.kt */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, m17d2 = {"Lkotlin/Suppress;", "", "names", "", "", "()[Ljava/lang/String;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
@Annotations17(allowedTargets = {Annotations13.CLASS, Annotations13.ANNOTATION_CLASS, Annotations13.TYPE_PARAMETER, Annotations13.PROPERTY, Annotations13.FIELD, Annotations13.LOCAL_VARIABLE, Annotations13.VALUE_PARAMETER, Annotations13.CONSTRUCTOR, Annotations13.FUNCTION, Annotations13.PROPERTY_GETTER, Annotations13.PROPERTY_SETTER, Annotations13.TYPE, Annotations13.EXPRESSION, Annotations13.FILE, Annotations13.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
@Annotations16(Annotations12.SOURCE)
/* renamed from: kotlin.Suppress, reason: use source file name */
/* loaded from: classes.dex */
public @interface Annotations10 {
    String[] names();
}
