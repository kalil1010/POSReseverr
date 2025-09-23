package org.apache.commons.collections4.set;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class MapBackedSet<E, V> implements Set<E>, Serializable {
    private static final long serialVersionUID = 6723912213766056587L;
    private final V dummyValue;
    private final Map<E, ? super V> map;

    public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> map) {
        return mapBackedSet(map, null);
    }

    public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> map, V dummyValue) {
        return new MapBackedSet<>(map, dummyValue);
    }

    private MapBackedSet(Map<E, ? super V> map, V dummyValue) {
        if (map == null) {
            throw new NullPointerException("The map must not be null");
        }
        this.map = map;
        this.dummyValue = dummyValue;
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> coll) {
        return this.map.keySet().containsAll(coll);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E e) {
        int size = this.map.size();
        this.map.put(e, this.dummyValue);
        return this.map.size() != size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = this.map.size();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            this.map.put(it.next(), this.dummyValue);
        }
        return this.map.size() != size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int size = this.map.size();
        this.map.remove(obj);
        return this.map.size() != size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> coll) {
        return this.map.keySet().removeAll(coll);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> coll) {
        return this.map.keySet().retainAll(coll);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.map.keySet().toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.map.keySet().toArray(tArr);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return this.map.keySet().equals(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.map.keySet().hashCode();
    }
}
