package org.apache.commons.collections4.list;

import java.util.List;
import org.apache.commons.collections4.Factory;

/* loaded from: classes.dex */
public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -1708388017160694542L;
    private final Factory<? extends E> factory;

    public static <E> LazyList<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return new LazyList<>(list, factory);
    }

    protected LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        if (factory == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.factory = factory;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i) {
        int size = decorated().size();
        if (i < size) {
            E e = (E) decorated().get(i);
            if (e == null) {
                E eCreate = this.factory.create();
                decorated().set(i, eCreate);
                return eCreate;
            }
            return e;
        }
        for (int i2 = size; i2 < i; i2++) {
            decorated().add(null);
        }
        E eCreate2 = this.factory.create();
        decorated().add(eCreate2);
        return eCreate2;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> sub = decorated().subList(fromIndex, toIndex);
        return new LazyList(sub, this.factory);
    }
}
