package org.apache.commons.lang3.builder;

/* loaded from: classes.dex */
final class IDKey {

    /* renamed from: id */
    private final int f868id;
    private final Object value;

    IDKey(Object _value) {
        this.f868id = System.identityHashCode(_value);
        this.value = _value;
    }

    public int hashCode() {
        return this.f868id;
    }

    public boolean equals(Object other) {
        if (!(other instanceof IDKey)) {
            return false;
        }
        IDKey idKey = (IDKey) other;
        return this.f868id == idKey.f868id && this.value == idKey.value;
    }
}
