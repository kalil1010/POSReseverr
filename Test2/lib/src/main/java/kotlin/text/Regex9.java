package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.Ranges6;
import kotlin.ranges.RangesKt;

/* compiled from: Regex.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, m17d2 = {"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.text.RegexKt */
/* loaded from: classes.dex */
public final class Regex9 {
    public static final int toInt(Iterable<? extends Regex2> iterable) {
        int accumulator$iv = 0;
        for (Object element$iv : iterable) {
            Regex2 option = (Regex2) element$iv;
            int value = accumulator$iv;
            accumulator$iv = value | option.getValue();
        }
        return accumulator$iv;
    }

    public static final /* synthetic */ <T extends Enum<T> & Regex2> Set<T> fromInt(final int value) {
        Intrinsics.reifiedOperationMarker(4, "T");
        EnumSet $this$apply = EnumSet.allOf(Enum.class);
        CollectionsKt.retainAll($this$apply, new Functions2<T, Boolean>() { // from class: kotlin.text.RegexKt$fromInt$$inlined$apply$lambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Functions2
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke((Enum) obj));
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            /* JADX WARN: Multi-variable type inference failed */
            public final boolean invoke(Enum r3) {
                return (value & ((Regex2) r3).getMask()) == ((Regex2) r3).getValue();
            }
        });
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet($this$apply);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return setUnmodifiableSet;
    }

    public static final MatchResult findNext(Matcher $this$findNext, int from, CharSequence input) {
        return !$this$findNext.find(from) ? null : new Regex4($this$findNext, input);
    }

    public static final MatchResult matchEntire(Matcher $this$matchEntire, CharSequence input) {
        return !$this$matchEntire.matches() ? null : new Regex4($this$matchEntire, input);
    }

    public static final Ranges6 range(java.util.regex.MatchResult $this$range) {
        return RangesKt.until($this$range.start(), $this$range.end());
    }

    public static final Ranges6 range(java.util.regex.MatchResult $this$range, int groupIndex) {
        return RangesKt.until($this$range.start(groupIndex), $this$range.end(groupIndex));
    }
}
