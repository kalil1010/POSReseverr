package org.apache.commons.collections4;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.collections4.set.PredicatedNavigableSet;
import org.apache.commons.collections4.set.PredicatedSet;
import org.apache.commons.collections4.set.PredicatedSortedSet;
import org.apache.commons.collections4.set.TransformedNavigableSet;
import org.apache.commons.collections4.set.TransformedSet;
import org.apache.commons.collections4.set.TransformedSortedSet;
import org.apache.commons.collections4.set.UnmodifiableNavigableSet;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.apache.commons.collections4.set.UnmodifiableSortedSet;

/* loaded from: classes.dex */
public class SetUtils {
    public static final SortedSet EMPTY_SORTED_SET = UnmodifiableSortedSet.unmodifiableSortedSet(new TreeSet());

    public static <E> Set<E> emptySet() {
        return Collections.emptySet();
    }

    public static <E> SortedSet<E> emptySortedSet() {
        return EMPTY_SORTED_SET;
    }

    private SetUtils() {
    }

    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set == null ? Collections.emptySet() : set;
    }

    public static boolean isEqualSet(Collection<?> set1, Collection<?> set2) {
        if (set1 == set2) {
            return true;
        }
        if (set1 == null || set2 == null || set1.size() != set2.size()) {
            return false;
        }
        return set1.containsAll(set2);
    }

    public static <T> int hashCodeForSet(Collection<T> set) {
        if (set == null) {
            return 0;
        }
        int hashCode = 0;
        for (T obj : set) {
            if (obj != null) {
                hashCode += obj.hashCode();
            }
        }
        return hashCode;
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> synchronizedSet(Set<E> set) {
        return Collections.synchronizedSet(set);
    }

    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        return UnmodifiableSet.unmodifiableSet(set);
    }

    public static <E> Set<E> predicatedSet(Set<E> set, Predicate<? super E> predicate) {
        return PredicatedSet.predicatedSet(set, predicate);
    }

    public static <E> Set<E> transformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        return TransformedSet.transformingSet(set, transformer);
    }

    public static <E> Set<E> orderedSet(Set<E> set) {
        return ListOrderedSet.listOrderedSet(set);
    }

    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> set) {
        return Collections.synchronizedSortedSet(set);
    }

    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> set) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(set);
    }

    public static <E> SortedSet<E> predicatedSortedSet(SortedSet<E> set, Predicate<? super E> predicate) {
        return PredicatedSortedSet.predicatedSortedSet(set, predicate);
    }

    public static <E> SortedSet<E> transformedSortedSet(SortedSet<E> set, Transformer<? super E, ? extends E> transformer) {
        return TransformedSortedSet.transformingSortedSet(set, transformer);
    }

    public static <E> SortedSet<E> unmodifiableNavigableSet(NavigableSet<E> set) {
        return UnmodifiableNavigableSet.unmodifiableNavigableSet(set);
    }

    public static <E> SortedSet<E> predicatedNavigableSet(NavigableSet<E> set, Predicate<? super E> predicate) {
        return PredicatedNavigableSet.predicatedNavigableSet(set, predicate);
    }

    public static <E> SortedSet<E> transformedNavigableSet(NavigableSet<E> set, Transformer<? super E, ? extends E> transformer) {
        return TransformedNavigableSet.transformingNavigableSet(set, transformer);
    }

    public static <E> SetView<E> union(Set<? extends E> a, Set<? extends E> b) {
        if (a == null || b == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        SetView<E> bMinusA = difference(b, a);
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.1
            final /* synthetic */ Set val$a;
            final /* synthetic */ Set val$b;
            final /* synthetic */ SetView val$bMinusA;

            C05811(Set a2, Set b2, SetView bMinusA2) {
                set = a2;
                set = b2;
                setView = bMinusA2;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o) {
                return set.contains(o) || set.contains(o);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.chainedIterator(set.iterator(), setView.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return set.isEmpty() && set.isEmpty();
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return set.size() + setView.size();
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.SetUtils$1 */
    static class C05811<E> extends SetView<E> {
        final /* synthetic */ Set val$a;
        final /* synthetic */ Set val$b;
        final /* synthetic */ SetView val$bMinusA;

        C05811(Set a2, Set b2, SetView bMinusA2) {
            set = a2;
            set = b2;
            setView = bMinusA2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return set.contains(o) || set.contains(o);
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView
        public Iterator<E> createIterator() {
            return IteratorUtils.chainedIterator(set.iterator(), setView.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return set.isEmpty() && set.isEmpty();
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return set.size() + setView.size();
        }
    }

    public static <E> SetView<E> difference(Set<? extends E> a, Set<? extends E> b) {
        if (a == null || b == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        Predicate<E> notContainedInB = new Predicate<E>() { // from class: org.apache.commons.collections4.SetUtils.2
            final /* synthetic */ Set val$b;

            C05822(Set b2) {
                set = b2;
            }

            @Override // org.apache.commons.collections4.Predicate
            public boolean evaluate(E object) {
                return !set.contains(object);
            }
        };
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.3
            final /* synthetic */ Set val$a;
            final /* synthetic */ Set val$b;
            final /* synthetic */ Predicate val$notContainedInB;

            C05833(Set a2, Set b2, Predicate notContainedInB2) {
                set = a2;
                set = b2;
                predicate = notContainedInB2;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o) {
                return set.contains(o) && !set.contains(o);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.filteredIterator(set.iterator(), predicate);
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.SetUtils$2 */
    static class C05822<E> implements Predicate<E> {
        final /* synthetic */ Set val$b;

        C05822(Set b2) {
            set = b2;
        }

        @Override // org.apache.commons.collections4.Predicate
        public boolean evaluate(E object) {
            return !set.contains(object);
        }
    }

    /* renamed from: org.apache.commons.collections4.SetUtils$3 */
    static class C05833<E> extends SetView<E> {
        final /* synthetic */ Set val$a;
        final /* synthetic */ Set val$b;
        final /* synthetic */ Predicate val$notContainedInB;

        C05833(Set a2, Set b2, Predicate notContainedInB2) {
            set = a2;
            set = b2;
            predicate = notContainedInB2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return set.contains(o) && !set.contains(o);
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView
        public Iterator<E> createIterator() {
            return IteratorUtils.filteredIterator(set.iterator(), predicate);
        }
    }

    public static <E> SetView<E> intersection(Set<? extends E> a, Set<? extends E> b) {
        if (a == null || b == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        Predicate<E> containedInB = new Predicate<E>() { // from class: org.apache.commons.collections4.SetUtils.4
            final /* synthetic */ Set val$b;

            C05844(Set b2) {
                set = b2;
            }

            @Override // org.apache.commons.collections4.Predicate
            public boolean evaluate(E object) {
                return set.contains(object);
            }
        };
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.5
            final /* synthetic */ Set val$a;
            final /* synthetic */ Set val$b;
            final /* synthetic */ Predicate val$containedInB;

            C05855(Set a2, Set b2, Predicate containedInB2) {
                set = a2;
                set = b2;
                predicate = containedInB2;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o) {
                return set.contains(o) && set.contains(o);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.filteredIterator(set.iterator(), predicate);
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.SetUtils$4 */
    static class C05844<E> implements Predicate<E> {
        final /* synthetic */ Set val$b;

        C05844(Set b2) {
            set = b2;
        }

        @Override // org.apache.commons.collections4.Predicate
        public boolean evaluate(E object) {
            return set.contains(object);
        }
    }

    /* renamed from: org.apache.commons.collections4.SetUtils$5 */
    static class C05855<E> extends SetView<E> {
        final /* synthetic */ Set val$a;
        final /* synthetic */ Set val$b;
        final /* synthetic */ Predicate val$containedInB;

        C05855(Set a2, Set b2, Predicate containedInB2) {
            set = a2;
            set = b2;
            predicate = containedInB2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return set.contains(o) && set.contains(o);
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView
        public Iterator<E> createIterator() {
            return IteratorUtils.filteredIterator(set.iterator(), predicate);
        }
    }

    public static <E> SetView<E> disjunction(Set<? extends E> a, Set<? extends E> b) {
        if (a == null || b == null) {
            throw new NullPointerException("Sets must not be null.");
        }
        SetView<E> aMinusB = difference(a, b);
        SetView<E> bMinusA = difference(b, a);
        return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.6
            final /* synthetic */ Set val$a;
            final /* synthetic */ SetView val$aMinusB;
            final /* synthetic */ Set val$b;
            final /* synthetic */ SetView val$bMinusA;

            C05866(Set a2, Set b2, SetView aMinusB2, SetView bMinusA2) {
                set = a2;
                set = b2;
                setView = aMinusB2;
                setView = bMinusA2;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o) {
                return set.contains(o) ^ set.contains(o);
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView
            public Iterator<E> createIterator() {
                return IteratorUtils.chainedIterator(setView.iterator(), setView.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return setView.isEmpty() && setView.isEmpty();
            }

            @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return setView.size() + setView.size();
            }
        };
    }

    /* renamed from: org.apache.commons.collections4.SetUtils$6 */
    static class C05866<E> extends SetView<E> {
        final /* synthetic */ Set val$a;
        final /* synthetic */ SetView val$aMinusB;
        final /* synthetic */ Set val$b;
        final /* synthetic */ SetView val$bMinusA;

        C05866(Set a2, Set b2, SetView aMinusB2, SetView bMinusA2) {
            set = a2;
            set = b2;
            setView = aMinusB2;
            setView = bMinusA2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return set.contains(o) ^ set.contains(o);
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView
        public Iterator<E> createIterator() {
            return IteratorUtils.chainedIterator(setView.iterator(), setView.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return setView.isEmpty() && setView.isEmpty();
        }

        @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return setView.size() + setView.size();
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        protected abstract Iterator<E> createIterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return IteratorUtils.unmodifiableIterator(createIterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IteratorUtils.size(iterator());
        }

        public <S extends Set<E>> void copyInto(S set) {
            CollectionUtils.addAll(set, this);
        }

        public Set<E> toSet() {
            HashSet hashSet = new HashSet(size());
            copyInto(hashSet);
            return hashSet;
        }
    }
}
