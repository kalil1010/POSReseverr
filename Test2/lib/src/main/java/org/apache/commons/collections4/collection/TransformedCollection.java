package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.Transformer;

/* loaded from: classes.dex */
public class TransformedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = 8692300188161871514L;
    protected final Transformer<? super E, ? extends E> transformer;

    public static <E> TransformedCollection<E> transformingCollection(Collection<E> coll, Transformer<? super E, ? extends E> transformer) {
        return new TransformedCollection<>(coll, transformer);
    }

    public static <E> TransformedCollection<E> transformedCollection(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        TransformedCollection<E> decorated = new TransformedCollection<>(collection, transformer);
        if (collection.size() > 0) {
            Object[] array = collection.toArray();
            collection.clear();
            for (Object obj : array) {
                decorated.decorated().add(transformer.transform(obj));
            }
        }
        return decorated;
    }

    protected TransformedCollection(Collection<E> coll, Transformer<? super E, ? extends E> transformer) {
        super(coll);
        if (transformer == null) {
            throw new NullPointerException("Transformer must not be null");
        }
        this.transformer = transformer;
    }

    protected E transform(E object) {
        return this.transformer.transform(object);
    }

    protected Collection<E> transform(Collection<? extends E> coll) {
        List<E> list = new ArrayList<>(coll.size());
        for (E item : coll) {
            list.add(transform((TransformedCollection<E>) item));
        }
        return list;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E object) {
        return decorated().add(transform((TransformedCollection<E>) object));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> coll) {
        return decorated().addAll(transform((Collection) coll));
    }
}
