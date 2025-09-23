package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

/* loaded from: classes.dex */
public class IterableUtils {
    static final FluentIterable EMPTY_ITERABLE = new FluentIterable<Object>() { // from class: org.apache.commons.collections4.IterableUtils.1
        C05651() {
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<Object> iterator() {
            return IteratorUtils.emptyIterator();
        }
    };

    /* renamed from: org.apache.commons.collections4.IterableUtils$1 */
    static class C05651 extends FluentIterable<Object> {
        C05651() {
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<Object> iterator() {
            return IteratorUtils.emptyIterator();
        }
    }

    public static <E> Iterable<E> emptyIterable() {
        return EMPTY_ITERABLE;
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> a, Iterable<? extends E> b) {
        return chainedIterable(a, b);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> a, Iterable<? extends E> b, Iterable<? extends E> c) {
        return chainedIterable(a, b, c);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> a, Iterable<? extends E> b, Iterable<? extends E> c, Iterable<? extends E> d) {
        return chainedIterable(a, b, c, d);
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$2 */
    static class C05702<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable[] val$iterables;

        C05702(Iterable[] iterableArr) {
            iterableArr = iterableArr;
        }

        /* renamed from: org.apache.commons.collections4.IterableUtils$2$1 */
        class AnonymousClass1 extends LazyIteratorChain<E> {
            AnonymousClass1() {
            }

            @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
            protected Iterator<? extends E> nextIterator(int count) {
                if (count > iterableArr.length) {
                    return null;
                }
                return iterableArr[count - 1].iterator();
            }
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.2.1
                AnonymousClass1() {
                }

                @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                protected Iterator<? extends E> nextIterator(int count) {
                    if (count > iterableArr.length) {
                        return null;
                    }
                    return iterableArr[count - 1].iterator();
                }
            };
        }
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E>... iterables) {
        checkNotNull(iterables);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.2
            final /* synthetic */ Iterable[] val$iterables;

            C05702(Iterable[] iterables2) {
                iterableArr = iterables2;
            }

            /* renamed from: org.apache.commons.collections4.IterableUtils$2$1 */
            class AnonymousClass1 extends LazyIteratorChain<E> {
                AnonymousClass1() {
                }

                @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                protected Iterator<? extends E> nextIterator(int count) {
                    if (count > iterableArr.length) {
                        return null;
                    }
                    return iterableArr[count - 1].iterator();
                }
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.2.1
                    AnonymousClass1() {
                    }

                    @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                    protected Iterator<? extends E> nextIterator(int count) {
                        if (count > iterableArr.length) {
                            return null;
                        }
                        return iterableArr[count - 1].iterator();
                    }
                };
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$3 */
    static class C05713<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$a;
        final /* synthetic */ Iterable val$b;

        C05713(Iterable iterable, Iterable iterable2) {
            iterable = iterable;
            iterable = iterable2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.collatedIterator(null, iterable.iterator(), iterable.iterator());
        }
    }

    public static <E> Iterable<E> collatedIterable(Iterable<? extends E> a, Iterable<? extends E> b) {
        checkNotNull((Iterable<?>[]) new Iterable[]{a, b});
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.3
            final /* synthetic */ Iterable val$a;
            final /* synthetic */ Iterable val$b;

            C05713(Iterable a2, Iterable b2) {
                iterable = a2;
                iterable = b2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.collatedIterator(null, iterable.iterator(), iterable.iterator());
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$4 */
    static class C05724<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$a;
        final /* synthetic */ Iterable val$b;
        final /* synthetic */ Comparator val$comparator;

        C05724(Comparator comparator, Iterable iterable, Iterable iterable2) {
            comparator = comparator;
            iterable = iterable;
            iterable = iterable2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.collatedIterator(comparator, iterable.iterator(), iterable.iterator());
        }
    }

    public static <E> Iterable<E> collatedIterable(Comparator<? super E> comparator, Iterable<? extends E> a, Iterable<? extends E> b) {
        checkNotNull((Iterable<?>[]) new Iterable[]{a, b});
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.4
            final /* synthetic */ Iterable val$a;
            final /* synthetic */ Iterable val$b;
            final /* synthetic */ Comparator val$comparator;

            C05724(Comparator comparator2, Iterable a2, Iterable b2) {
                comparator = comparator2;
                iterable = a2;
                iterable = b2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.collatedIterator(comparator, iterable.iterator(), iterable.iterator());
            }
        };
    }

    public static <E> Iterable<E> filteredIterable(Iterable<E> iterable, Predicate<? super E> predicate) {
        checkNotNull((Iterable<?>) iterable);
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.5
            final /* synthetic */ Iterable val$iterable;
            final /* synthetic */ Predicate val$predicate;

            C05735(Iterable iterable2, Predicate predicate2) {
                iterable = iterable2;
                predicate = predicate2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.filteredIterator(IterableUtils.emptyIteratorIfNull(iterable), predicate);
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$5 */
    static class C05735<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ Predicate val$predicate;

        C05735(Iterable iterable2, Predicate predicate2) {
            iterable = iterable2;
            predicate = predicate2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.filteredIterator(IterableUtils.emptyIteratorIfNull(iterable), predicate);
        }
    }

    public static <E> Iterable<E> boundedIterable(Iterable<E> iterable, long maxSize) {
        checkNotNull((Iterable<?>) iterable);
        if (maxSize < 0) {
            throw new IllegalArgumentException("MaxSize parameter must not be negative.");
        }
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.6
            final /* synthetic */ Iterable val$iterable;
            final /* synthetic */ long val$maxSize;

            C05746(Iterable iterable2, long maxSize2) {
                iterable = iterable2;
                j = maxSize2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.boundedIterator(iterable.iterator(), j);
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$6 */
    static class C05746<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ long val$maxSize;

        C05746(Iterable iterable2, long maxSize2) {
            iterable = iterable2;
            j = maxSize2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.boundedIterator(iterable.iterator(), j);
        }
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$7 */
    static class C05757<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;

        C05757(Iterable iterable) {
            iterable = iterable;
        }

        /* renamed from: org.apache.commons.collections4.IterableUtils$7$1 */
        class AnonymousClass1 extends LazyIteratorChain<E> {
            AnonymousClass1() {
            }

            @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
            protected Iterator<? extends E> nextIterator(int count) {
                if (IterableUtils.isEmpty(iterable)) {
                    return null;
                }
                return iterable.iterator();
            }
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.7.1
                AnonymousClass1() {
                }

                @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                protected Iterator<? extends E> nextIterator(int count) {
                    if (IterableUtils.isEmpty(iterable)) {
                        return null;
                    }
                    return iterable.iterator();
                }
            };
        }
    }

    public static <E> Iterable<E> loopingIterable(Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.7
            final /* synthetic */ Iterable val$iterable;

            C05757(Iterable iterable2) {
                iterable = iterable2;
            }

            /* renamed from: org.apache.commons.collections4.IterableUtils$7$1 */
            class AnonymousClass1 extends LazyIteratorChain<E> {
                AnonymousClass1() {
                }

                @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                protected Iterator<? extends E> nextIterator(int count) {
                    if (IterableUtils.isEmpty(iterable)) {
                        return null;
                    }
                    return iterable.iterator();
                }
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.7.1
                    AnonymousClass1() {
                    }

                    @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                    protected Iterator<? extends E> nextIterator(int count) {
                        if (IterableUtils.isEmpty(iterable)) {
                            return null;
                        }
                        return iterable.iterator();
                    }
                };
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$8 */
    static class C05768<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;

        C05768(Iterable iterable) {
            iterable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            Iterable iterable = iterable;
            List<E> list = iterable instanceof List ? (List) iterable : IteratorUtils.toList(iterable.iterator());
            return new ReverseListIterator(list);
        }
    }

    public static <E> Iterable<E> reversedIterable(Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.8
            final /* synthetic */ Iterable val$iterable;

            C05768(Iterable iterable2) {
                iterable = iterable2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                Iterable iterable2 = iterable;
                List<E> list = iterable2 instanceof List ? (List) iterable2 : IteratorUtils.toList(iterable2.iterator());
                return new ReverseListIterator(list);
            }
        };
    }

    public static <E> Iterable<E> skippingIterable(Iterable<E> iterable, long elementsToSkip) {
        checkNotNull((Iterable<?>) iterable);
        if (elementsToSkip < 0) {
            throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
        }
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.9
            final /* synthetic */ long val$elementsToSkip;
            final /* synthetic */ Iterable val$iterable;

            C05779(Iterable iterable2, long elementsToSkip2) {
                iterable = iterable2;
                j = elementsToSkip2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.skippingIterator(iterable.iterator(), j);
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$9 */
    static class C05779<E> extends FluentIterable<E> {
        final /* synthetic */ long val$elementsToSkip;
        final /* synthetic */ Iterable val$iterable;

        C05779(Iterable iterable2, long elementsToSkip2) {
            iterable = iterable2;
            j = elementsToSkip2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.skippingIterator(iterable.iterator(), j);
        }
    }

    public static <I, O> Iterable<O> transformedIterable(Iterable<I> iterable, Transformer<? super I, ? extends O> transformer) {
        checkNotNull((Iterable<?>) iterable);
        if (transformer == null) {
            throw new NullPointerException("Transformer must not be null.");
        }
        return new FluentIterable<O>() { // from class: org.apache.commons.collections4.IterableUtils.10
            final /* synthetic */ Iterable val$iterable;
            final /* synthetic */ Transformer val$transformer;

            C056610(Iterable iterable2, Transformer transformer2) {
                iterable = iterable2;
                transformer = transformer2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<O> iterator() {
                return IteratorUtils.transformedIterator(iterable.iterator(), transformer);
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$10 */
    static class C056610<O> extends FluentIterable<O> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ Transformer val$transformer;

        C056610(Iterable iterable2, Transformer transformer2) {
            iterable = iterable2;
            transformer = transformer2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<O> iterator() {
            return IteratorUtils.transformedIterator(iterable.iterator(), transformer);
        }
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$11 */
    static class C056711<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$iterable;

        C056711(Iterable iterable) {
            iterable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return new UniqueFilterIterator(iterable.iterator());
        }
    }

    public static <E> Iterable<E> uniqueIterable(Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.11
            final /* synthetic */ Iterable val$iterable;

            C056711(Iterable iterable2) {
                iterable = iterable2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return new UniqueFilterIterator(iterable.iterator());
            }
        };
    }

    public static <E> Iterable<E> unmodifiableIterable(Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        if (iterable instanceof UnmodifiableIterable) {
            return iterable;
        }
        return new UnmodifiableIterable(iterable);
    }

    private static final class UnmodifiableIterable<E> extends FluentIterable<E> {
        private final Iterable<E> unmodifiable;

        public UnmodifiableIterable(Iterable<E> iterable) {
            this.unmodifiable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.unmodifiableIterator(this.unmodifiable.iterator());
        }
    }

    public static <E> Iterable<E> zippingIterable(Iterable<? extends E> a, Iterable<? extends E> b) {
        checkNotNull(a);
        checkNotNull(b);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.12
            final /* synthetic */ Iterable val$a;
            final /* synthetic */ Iterable val$b;

            C056812(Iterable a2, Iterable b2) {
                iterable = a2;
                iterable = b2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                return IteratorUtils.zippingIterator(iterable.iterator(), iterable.iterator());
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$12 */
    static class C056812<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$a;
        final /* synthetic */ Iterable val$b;

        C056812(Iterable a2, Iterable b2) {
            iterable = a2;
            iterable = b2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            return IteratorUtils.zippingIterator(iterable.iterator(), iterable.iterator());
        }
    }

    public static <E> Iterable<E> zippingIterable(Iterable<? extends E> first, Iterable<? extends E>... others) {
        checkNotNull(first);
        checkNotNull(others);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.13
            final /* synthetic */ Iterable val$first;
            final /* synthetic */ Iterable[] val$others;

            C056913(Iterable[] others2, Iterable first2) {
                iterableArr = others2;
                iterable = first2;
            }

            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            public Iterator<E> iterator() {
                Iterator<? extends E>[] iterators = new Iterator[iterableArr.length + 1];
                iterators[0] = iterable.iterator();
                int i = 0;
                while (true) {
                    Iterable[] iterableArr = iterableArr;
                    if (i < iterableArr.length) {
                        iterators[i + 1] = iterableArr[i].iterator();
                        i++;
                    } else {
                        return IteratorUtils.zippingIterator(iterators);
                    }
                }
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.IterableUtils$13 */
    static class C056913<E> extends FluentIterable<E> {
        final /* synthetic */ Iterable val$first;
        final /* synthetic */ Iterable[] val$others;

        C056913(Iterable[] others2, Iterable first2) {
            iterableArr = others2;
            iterable = first2;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        public Iterator<E> iterator() {
            Iterator<? extends E>[] iterators = new Iterator[iterableArr.length + 1];
            iterators[0] = iterable.iterator();
            int i = 0;
            while (true) {
                Iterable[] iterableArr = iterableArr;
                if (i < iterableArr.length) {
                    iterators[i + 1] = iterableArr[i].iterator();
                    i++;
                } else {
                    return IteratorUtils.zippingIterator(iterators);
                }
            }
        }
    }

    public static <E> Iterable<E> emptyIfNull(Iterable<E> iterable) {
        return iterable == null ? emptyIterable() : iterable;
    }

    public static <E> void forEach(Iterable<E> iterable, Closure<? super E> closure) {
        IteratorUtils.forEach(emptyIteratorIfNull(iterable), closure);
    }

    public static <E> E forEachButLast(Iterable<E> iterable, Closure<? super E> closure) {
        return (E) IteratorUtils.forEachButLast(emptyIteratorIfNull(iterable), closure);
    }

    public static <E> E find(Iterable<E> iterable, Predicate<? super E> predicate) {
        return (E) IteratorUtils.find(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> int indexOf(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.indexOf(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> boolean matchesAll(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAll(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> boolean matchesAny(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAny(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> long countMatches(Iterable<E> input, Predicate<? super E> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        return size(filteredIterable(emptyIfNull(input), predicate));
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return IteratorUtils.isEmpty(emptyIteratorIfNull(iterable));
    }

    public static <E> boolean contains(Iterable<E> iterable, Object object) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(object);
        }
        return IteratorUtils.contains(emptyIteratorIfNull(iterable), object);
    }

    public static <E> boolean contains(Iterable<? extends E> iterable, E object, Equator<? super E> equator) {
        if (equator == null) {
            throw new NullPointerException("Equator must not be null.");
        }
        return matchesAny(iterable, EqualPredicate.equalPredicate(object, equator));
    }

    public static <E, T extends E> int frequency(Iterable<E> iterable, T t) {
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(t) ? 1 : 0;
        }
        if (iterable instanceof Bag) {
            return ((Bag) iterable).getCount(t);
        }
        return size(filteredIterable(emptyIfNull(iterable), EqualPredicate.equalPredicate(t)));
    }

    public static <T> T get(Iterable<T> iterable, int i) {
        CollectionUtils.checkIndexBounds(i);
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) IteratorUtils.get(emptyIteratorIfNull(iterable), i);
    }

    public static <T> T first(Iterable<T> iterable) {
        return (T) get(iterable, 0);
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return IteratorUtils.size(emptyIteratorIfNull(iterable));
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null.");
        }
        Factory<List<O>> factory = FactoryUtils.instantiateFactory(ArrayList.class);
        Predicate<? super O>[] predicates = {predicate};
        return partition(iterable, factory, predicates);
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O>... predicates) {
        Factory<List<O>> factory = FactoryUtils.instantiateFactory(ArrayList.class);
        return partition(iterable, factory, predicates);
    }

    public static <O, R extends Collection<O>> List<R> partition(Iterable<? extends O> iterable, Factory<R> factory, Predicate<? super O>... predicateArr) {
        if (iterable == null) {
            return partition(emptyIterable(), factory, predicateArr);
        }
        if (predicateArr == null) {
            throw new NullPointerException("Predicates must not be null.");
        }
        for (Predicate<? super O> predicate : predicateArr) {
            if (predicate == null) {
                throw new NullPointerException("Predicate must not be null.");
            }
        }
        if (predicateArr.length < 1) {
            R rCreate = factory.create();
            CollectionUtils.addAll(rCreate, iterable);
            return Collections.singletonList(rCreate);
        }
        int length = predicateArr.length;
        int i = length + 1;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(factory.create());
        }
        for (O o : iterable) {
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (!predicateArr[i3].evaluate(o)) {
                    i3++;
                } else {
                    ((Collection) arrayList.get(i3)).add(o);
                    z = true;
                    break;
                }
            }
            if (!z) {
                ((Collection) arrayList.get(length)).add(o);
            }
        }
        return arrayList;
    }

    public static <E> List<E> toList(Iterable<E> iterable) {
        return IteratorUtils.toList(emptyIteratorIfNull(iterable));
    }

    public static <E> String toString(Iterable<E> iterable) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable));
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer) {
        if (transformer == null) {
            throw new NullPointerException("Transformer must not be null.");
        }
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer);
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer, String delimiter, String prefix, String suffix) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer, delimiter, prefix, suffix);
    }

    static void checkNotNull(Iterable<?> iterable) {
        if (iterable == null) {
            throw new NullPointerException("Iterable must not be null.");
        }
    }

    static void checkNotNull(Iterable<?>... iterables) {
        if (iterables == null) {
            throw new NullPointerException("Iterables must not be null.");
        }
        for (Iterable<?> iterable : iterables) {
            checkNotNull(iterable);
        }
    }

    public static <E> Iterator<E> emptyIteratorIfNull(Iterable<E> iterable) {
        return iterable != null ? iterable.iterator() : IteratorUtils.emptyIterator();
    }
}
