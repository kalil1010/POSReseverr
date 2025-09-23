package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.iterators.SingletonIterator;

/* loaded from: classes.dex */
public class FluentIterable<E> implements Iterable<E> {
    private final Iterable<E> iterable;

    public static <T> FluentIterable<T> empty() {
        return IterableUtils.EMPTY_ITERABLE;
    }

    /* renamed from: of */
    public static <T> FluentIterable<T> m50of(T singleton) {
        return m49of(IteratorUtils.asIterable(new SingletonIterator(singleton, false)));
    }

    /* renamed from: of */
    public static <T> FluentIterable<T> m51of(T... elements) {
        return m49of((Iterable) Arrays.asList(elements));
    }

    /* renamed from: of */
    public static <T> FluentIterable<T> m49of(Iterable<T> iterable) {
        IterableUtils.checkNotNull((Iterable<?>) iterable);
        if (iterable instanceof FluentIterable) {
            return (FluentIterable) iterable;
        }
        return new FluentIterable<>(iterable);
    }

    FluentIterable() {
        this.iterable = this;
    }

    private FluentIterable(Iterable<E> iterable) {
        this.iterable = iterable;
    }

    public FluentIterable<E> append(E... elements) {
        return append(Arrays.asList(elements));
    }

    public FluentIterable<E> append(Iterable<? extends E> other) {
        return m49of(IterableUtils.chainedIterable(this.iterable, other));
    }

    public FluentIterable<E> collate(Iterable<? extends E> other) {
        return m49of(IterableUtils.collatedIterable(this.iterable, other));
    }

    public FluentIterable<E> collate(Iterable<? extends E> other, Comparator<? super E> comparator) {
        return m49of(IterableUtils.collatedIterable(comparator, this.iterable, other));
    }

    public FluentIterable<E> eval() {
        return m49of((Iterable) toList());
    }

    public FluentIterable<E> filter(Predicate<? super E> predicate) {
        return m49of(IterableUtils.filteredIterable(this.iterable, predicate));
    }

    public FluentIterable<E> limit(long maxSize) {
        return m49of(IterableUtils.boundedIterable(this.iterable, maxSize));
    }

    public FluentIterable<E> loop() {
        return m49of(IterableUtils.loopingIterable(this.iterable));
    }

    public FluentIterable<E> reverse() {
        return m49of(IterableUtils.reversedIterable(this.iterable));
    }

    public FluentIterable<E> skip(long elementsToSkip) {
        return m49of(IterableUtils.skippingIterable(this.iterable, elementsToSkip));
    }

    public <O> FluentIterable<O> transform(Transformer<? super E, ? extends O> transformer) {
        return m49of(IterableUtils.transformedIterable(this.iterable, transformer));
    }

    public FluentIterable<E> unique() {
        return m49of(IterableUtils.uniqueIterable(this.iterable));
    }

    public FluentIterable<E> unmodifiable() {
        return m49of(IterableUtils.unmodifiableIterable(this.iterable));
    }

    public FluentIterable<E> zip(Iterable<? extends E> other) {
        return m49of(IterableUtils.zippingIterable(this.iterable, other));
    }

    public FluentIterable<E> zip(Iterable<? extends E>... others) {
        return m49of(IterableUtils.zippingIterable(this.iterable, others));
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return this.iterable.iterator();
    }

    public Enumeration<E> asEnumeration() {
        return IteratorUtils.asEnumeration(iterator());
    }

    public boolean allMatch(Predicate<? super E> predicate) {
        return IterableUtils.matchesAll(this.iterable, predicate);
    }

    public boolean anyMatch(Predicate<? super E> predicate) {
        return IterableUtils.matchesAny(this.iterable, predicate);
    }

    public boolean isEmpty() {
        return IterableUtils.isEmpty(this.iterable);
    }

    public boolean contains(Object object) {
        return IterableUtils.contains(this.iterable, object);
    }

    public void forEach(Closure<? super E> closure) {
        IterableUtils.forEach(this.iterable, closure);
    }

    public E get(int i) {
        return (E) IterableUtils.get(this.iterable, i);
    }

    public int size() {
        return IterableUtils.size(this.iterable);
    }

    public void copyInto(Collection<? super E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null");
        }
        CollectionUtils.addAll(collection, this.iterable);
    }

    public E[] toArray(Class<E> cls) {
        return (E[]) IteratorUtils.toArray(iterator(), cls);
    }

    public List<E> toList() {
        return IterableUtils.toList(this.iterable);
    }

    public String toString() {
        return IterableUtils.toString(this.iterable);
    }
}
