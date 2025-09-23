package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.Predicate;

/* loaded from: classes.dex */
public class ComparatorPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -1863209236504077399L;
    private final Comparator<T> comparator;
    private final Criterion criterion;
    private final T object;

    public enum Criterion {
        EQUAL,
        GREATER,
        LESS,
        GREATER_OR_EQUAL,
        LESS_OR_EQUAL
    }

    public static <T> Predicate<T> comparatorPredicate(T object, Comparator<T> comparator) {
        return comparatorPredicate(object, comparator, Criterion.EQUAL);
    }

    public static <T> Predicate<T> comparatorPredicate(T object, Comparator<T> comparator, Criterion criterion) {
        if (comparator == null) {
            throw new NullPointerException("Comparator must not be null.");
        }
        if (criterion == null) {
            throw new NullPointerException("Criterion must not be null.");
        }
        return new ComparatorPredicate(object, comparator, criterion);
    }

    public ComparatorPredicate(T object, Comparator<T> comparator, Criterion criterion) {
        this.object = object;
        this.comparator = comparator;
        this.criterion = criterion;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T target) {
        int comparison = this.comparator.compare(this.object, target);
        int i = C05901.f856xaf4caad[this.criterion.ordinal()];
        if (i == 1) {
            boolean result = comparison == 0;
            return result;
        }
        if (i == 2) {
            boolean result2 = comparison > 0;
            return result2;
        }
        if (i == 3) {
            boolean result3 = comparison < 0;
            return result3;
        }
        if (i == 4) {
            boolean result4 = comparison >= 0;
            return result4;
        }
        if (i == 5) {
            boolean result5 = comparison <= 0;
            return result5;
        }
        throw new IllegalStateException("The current criterion '" + this.criterion + "' is invalid.");
    }

    /* renamed from: org.apache.commons.collections4.functors.ComparatorPredicate$1 */
    static /* synthetic */ class C05901 {

        /* renamed from: $SwitchMap$org$apache$commons$collections4$functors$ComparatorPredicate$Criterion */
        static final /* synthetic */ int[] f856xaf4caad;

        static {
            int[] iArr = new int[Criterion.values().length];
            f856xaf4caad = iArr;
            try {
                iArr[Criterion.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f856xaf4caad[Criterion.GREATER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f856xaf4caad[Criterion.LESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f856xaf4caad[Criterion.GREATER_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f856xaf4caad[Criterion.LESS_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }
}
