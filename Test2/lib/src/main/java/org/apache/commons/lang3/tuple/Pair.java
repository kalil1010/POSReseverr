package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* loaded from: classes.dex */
public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    public abstract L getLeft();

    public abstract R getRight();

    /* renamed from: of */
    public static <L, R> Pair<L, R> m64of(L left, R right) {
        return new ImmutablePair(left, right);
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return getLeft();
    }

    @Override // java.util.Map.Entry
    public R getValue() {
        return getRight();
    }

    @Override // java.lang.Comparable
    public int compareTo(Pair<L, R> other) {
        return new CompareToBuilder().append(getLeft(), other.getLeft()).append(getRight(), other.getRight()).toComparison();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<?, ?> other = (Map.Entry) obj;
        return Objects.equals(getKey(), other.getKey()) && Objects.equals(getValue(), other.getValue());
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public String toString() {
        return "(" + getLeft() + ',' + getRight() + ')';
    }

    public String toString(String format) {
        return String.format(format, getLeft(), getRight());
    }
}
