package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* loaded from: classes.dex */
public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    private static final long serialVersionUID = 1;

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    /* renamed from: of */
    public static <L, M, R> Triple<L, M, R> m65of(L left, M middle, R right) {
        return new ImmutableTriple(left, middle, right);
    }

    @Override // java.lang.Comparable
    public int compareTo(Triple<L, M, R> other) {
        return new CompareToBuilder().append(getLeft(), other.getLeft()).append(getMiddle(), other.getMiddle()).append(getRight(), other.getRight()).toComparison();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple<?, ?, ?> other = (Triple) obj;
        return Objects.equals(getLeft(), other.getLeft()) && Objects.equals(getMiddle(), other.getMiddle()) && Objects.equals(getRight(), other.getRight());
    }

    public int hashCode() {
        return ((getLeft() == null ? 0 : getLeft().hashCode()) ^ (getMiddle() == null ? 0 : getMiddle().hashCode())) ^ (getRight() != null ? getRight().hashCode() : 0);
    }

    public String toString() {
        return "(" + getLeft() + "," + getMiddle() + "," + getRight() + ")";
    }

    public String toString(String format) {
        return String.format(format, getLeft(), getMiddle(), getRight());
    }
}
