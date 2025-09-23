package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;

/* loaded from: classes.dex */
public class UnmodifiableTrie<K, V> implements Trie<K, V>, Serializable, Unmodifiable {
    private static final long serialVersionUID = -7156426030315945159L;
    private final Trie<K, V> delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Trie<K, V> unmodifiableTrie(Trie<K, ? extends V> trie) {
        if (trie instanceof Unmodifiable) {
            return trie;
        }
        return new UnmodifiableTrie(trie);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnmodifiableTrie(Trie<K, ? extends V> trie) {
        if (trie == 0) {
            throw new NullPointerException("Trie must not be null");
        }
        this.delegate = trie;
    }

    @Override // java.util.SortedMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.delegate.entrySet());
    }

    @Override // java.util.SortedMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return Collections.unmodifiableSet(this.delegate.keySet());
    }

    @Override // java.util.SortedMap, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return Collections.unmodifiableCollection(this.delegate.values());
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object value) {
        return this.delegate.containsValue(value);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object key) {
        return this.delegate.get(key);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return this.delegate.firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K toKey) {
        return Collections.unmodifiableSortedMap(this.delegate.headMap(toKey));
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return this.delegate.lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return Collections.unmodifiableSortedMap(this.delegate.subMap(fromKey, toKey));
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K fromKey) {
        return Collections.unmodifiableSortedMap(this.delegate.tailMap(fromKey));
    }

    @Override // org.apache.commons.collections4.Trie
    public SortedMap<K, V> prefixMap(K key) {
        return Collections.unmodifiableSortedMap(this.delegate.prefixMap(key));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.delegate.comparator();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        OrderedMapIterator<K, V> it = this.delegate.mapIterator();
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(it);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K key) {
        return this.delegate.nextKey(key);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K key) {
        return this.delegate.previousKey(key);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    public String toString() {
        return this.delegate.toString();
    }
}
