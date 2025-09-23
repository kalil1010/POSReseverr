package org.apache.commons.collections4;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.functors.DefaultEquator;
import org.apache.commons.collections4.list.FixedSizeList;
import org.apache.commons.collections4.list.LazyList;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.list.TransformedList;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.collections4.sequence.CommandVisitor;
import org.apache.commons.collections4.sequence.EditScript;
import org.apache.commons.collections4.sequence.SequencesComparator;

/* loaded from: classes.dex */
public class ListUtils {
    private ListUtils() {
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static <T> List<T> defaultIfNull(List<T> list, List<T> defaultList) {
        return list == null ? defaultList : list;
    }

    public static <E> List<E> intersection(List<? extends E> list1, List<? extends E> list2) {
        List<E> result = new ArrayList<>();
        List<? extends E> smaller = list1;
        List<? extends E> larger = list2;
        if (list1.size() > list2.size()) {
            smaller = list2;
            larger = list1;
        }
        HashSet<E> hashSet = new HashSet<>(smaller);
        for (E e : larger) {
            if (hashSet.contains(e)) {
                result.add(e);
                hashSet.remove(e);
            }
        }
        return result;
    }

    public static <E> List<E> subtract(List<E> list1, List<? extends E> list2) {
        ArrayList<E> result = new ArrayList<>();
        HashBag<E> bag = new HashBag<>(list2);
        for (E e : list1) {
            if (!bag.remove(e, 1)) {
                result.add(e);
            }
        }
        return result;
    }

    public static <E> List<E> sum(List<? extends E> list1, List<? extends E> list2) {
        return subtract(union(list1, list2), intersection(list1, list2));
    }

    public static <E> List<E> union(List<? extends E> list1, List<? extends E> list2) {
        ArrayList<E> result = new ArrayList<>(list1.size() + list2.size());
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    public static <E> List<E> select(Collection<? extends E> inputCollection, Predicate<? super E> predicate) {
        return (List) CollectionUtils.select(inputCollection, predicate, new ArrayList(inputCollection.size()));
    }

    public static <E> List<E> selectRejected(Collection<? extends E> inputCollection, Predicate<? super E> predicate) {
        return (List) CollectionUtils.selectRejected(inputCollection, predicate, new ArrayList(inputCollection.size()));
    }

    public static boolean isEqualList(Collection<?> list1, Collection<?> list2) {
        if (list1 == list2) {
            return true;
        }
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }
        Iterator<?> it1 = list1.iterator();
        Iterator<?> it2 = list2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            Object obj1 = it1.next();
            Object obj2 = it2.next();
            if (obj1 == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (!obj1.equals(obj2)) {
                return false;
            }
        }
        return (it1.hasNext() || it2.hasNext()) ? false : true;
    }

    public static int hashCodeForList(Collection<?> list) {
        if (list == null) {
            return 0;
        }
        int hashCode = 1;
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            hashCode = (hashCode * 31) + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    public static <E> List<E> retainAll(Collection<E> collection, Collection<?> retain) {
        List<E> list = new ArrayList<>(Math.min(collection.size(), retain.size()));
        for (E obj : collection) {
            if (retain.contains(obj)) {
                list.add(obj);
            }
        }
        return list;
    }

    public static <E> List<E> removeAll(Collection<E> collection, Collection<?> remove) {
        List<E> list = new ArrayList<>();
        for (E obj : collection) {
            if (!remove.contains(obj)) {
                list.add(obj);
            }
        }
        return list;
    }

    public static <E> List<E> synchronizedList(List<E> list) {
        return Collections.synchronizedList(list);
    }

    public static <E> List<E> unmodifiableList(List<? extends E> list) {
        return UnmodifiableList.unmodifiableList(list);
    }

    public static <E> List<E> predicatedList(List<E> list, Predicate<E> predicate) {
        return PredicatedList.predicatedList(list, predicate);
    }

    public static <E> List<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return TransformedList.transformingList(list, transformer);
    }

    public static <E> List<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return LazyList.lazyList(list, factory);
    }

    public static <E> List<E> fixedSizeList(List<E> list) {
        return FixedSizeList.fixedSizeList(list);
    }

    public static <E> int indexOf(List<E> list, Predicate<E> predicate) {
        if (list != null && predicate != null) {
            for (int i = 0; i < list.size(); i++) {
                E item = list.get(i);
                if (predicate.evaluate(item)) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    public static <E> List<E> longestCommonSubsequence(List<E> a, List<E> b) {
        return longestCommonSubsequence(a, b, DefaultEquator.defaultEquator());
    }

    public static <E> List<E> longestCommonSubsequence(List<E> a, List<E> b, Equator<? super E> equator) {
        if (a == null || b == null) {
            throw new NullPointerException("List must not be null");
        }
        if (equator == null) {
            throw new NullPointerException("Equator must not be null");
        }
        SequencesComparator<E> comparator = new SequencesComparator<>(a, b, equator);
        EditScript<E> script = comparator.getScript();
        LcsVisitor<E> visitor = new LcsVisitor<>();
        script.visit(visitor);
        return visitor.getSubSequence();
    }

    public static String longestCommonSubsequence(CharSequence a, CharSequence b) {
        if (a == null || b == null) {
            throw new NullPointerException("CharSequence must not be null");
        }
        List<Character> lcs = longestCommonSubsequence(new CharSequenceAsList(a), new CharSequenceAsList(b));
        StringBuilder sb = new StringBuilder();
        for (Character ch : lcs) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private static final class LcsVisitor<E> implements CommandVisitor<E> {
        private final ArrayList<E> sequence = new ArrayList<>();

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitInsertCommand(E object) {
        }

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitDeleteCommand(E object) {
        }

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitKeepCommand(E object) {
            this.sequence.add(object);
        }

        public List<E> getSubSequence() {
            return this.sequence;
        }
    }

    private static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        public CharSequenceAsList(CharSequence sequence) {
            this.sequence = sequence;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int index) {
            return Character.valueOf(this.sequence.charAt(index));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.sequence.length();
        }
    }

    public static <T> List<List<T>> partition(List<T> list, int size) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        return new Partition(list, size);
    }

    private static class Partition<T> extends AbstractList<List<T>> {
        private final List<T> list;
        private final int size;

        /* synthetic */ Partition(List x0, int x1, C05781 x2) {
            this(x0, x1);
        }

        private Partition(List<T> list, int size) {
            this.list = list;
            this.size = size;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> get(int index) {
            int listSize = size();
            if (index < 0) {
                throw new IndexOutOfBoundsException("Index " + index + " must not be negative");
            }
            if (index >= listSize) {
                throw new IndexOutOfBoundsException("Index " + index + " must be less than size " + listSize);
            }
            int i = this.size;
            int start = index * i;
            int end = Math.min(i + start, this.list.size());
            return this.list.subList(start, end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return (int) Math.ceil(this.list.size() / this.size);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }
    }
}
