package kotlin.jvm.internal;

import kotlin.reflect.KProperty2;

/* loaded from: classes.dex */
public abstract class MutablePropertyReference extends PropertyReference implements KProperty2 {
    public MutablePropertyReference() {
    }

    public MutablePropertyReference(Object receiver) {
        super(receiver);
    }

    public MutablePropertyReference(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }
}
