package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.Annotations12;
import kotlin.annotation.Annotations13;
import kotlin.annotation.Annotations16;
import kotlin.annotation.Annotations17;

/* compiled from: OptIn.kt */
@Target({ElementType.ANNOTATION_TYPE})
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u0099F0\u0001¨\u0006\t"}, m17d2 = {"Lkotlin/RequiresOptIn;", "", "message", "", "level", "Lkotlin/RequiresOptIn$Level;", "()Lkotlin/RequiresOptIn$Level;", "()Ljava/lang/String;", "Level", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
@Annotations17(allowedTargets = {Annotations13.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@Annotations16(Annotations12.BINARY)
/* renamed from: kotlin.RequiresOptIn, reason: use source file name */
/* loaded from: classes.dex */
public @interface OptIn2 {

    /* compiled from: OptIn.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m17d2 = {"Lkotlin/RequiresOptIn$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: kotlin.RequiresOptIn$Level */
    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;

    String message() default "";
}
