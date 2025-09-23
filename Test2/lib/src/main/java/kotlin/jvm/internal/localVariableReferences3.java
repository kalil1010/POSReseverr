package kotlin.jvm.internal;

import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: localVariableReferences.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\n"}, m17d2 = {"Lkotlin/jvm/internal/MutableLocalVariableReference;", "Lkotlin/jvm/internal/MutablePropertyReference0;", "()V", "get", "", "getOwner", "Lkotlin/reflect/KDeclarationContainer;", "set", "", "value", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.jvm.internal.MutableLocalVariableReference, reason: use source file name */
/* loaded from: classes.dex */
public class localVariableReferences3 extends MutablePropertyReference0 {
    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        localVariableReferences2.notSupportedError();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KProperty6
    public Object get() {
        localVariableReferences2.notSupportedError();
        throw new ExceptionsH();
    }

    @Override // kotlin.reflect.KProperty3
    public void set(Object value) {
        localVariableReferences2.notSupportedError();
        throw new ExceptionsH();
    }
}
