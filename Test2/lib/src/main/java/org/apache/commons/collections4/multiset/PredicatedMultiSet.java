package org.apache.commons.collections4.multiset;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

/* loaded from: classes.dex */
public class PredicatedMultiSet<E> extends PredicatedCollection<E> implements MultiSet<E> {
    private static final long serialVersionUID = 20150629;

    public static <E> PredicatedMultiSet<E> predicatedMultiSet(MultiSet<E> multiset, Predicate<? super E> predicate) {
        return new PredicatedMultiSet<>(multiset, predicate);
    }

    protected PredicatedMultiSet(MultiSet<E> multiset, Predicate<? super E> predicate) {
        super(multiset, predicate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public MultiSet<E> decorated() {
        return (MultiSet) super.decorated();
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean equals(Object object) {
        return object == this || decorated().equals(object);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int add(E object, int count) {
        validate(object);
        return decorated().add(object, count);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int remove(Object object, int count) {
        return decorated().remove(object, count);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int getCount(Object object) {
        return decorated().getCount(object);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E object, int count) {
        validate(object);
        return decorated().setCount(object, count);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        return decorated().entrySet();
    }
}
