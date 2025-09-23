package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypesJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0001¢\u0006\u0002\b\u0004"}, m17d2 = {"<anonymous>", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "p1", "invoke"}, m18k = 3, m19mv = {1, 4, 0})
/* renamed from: kotlin.reflect.TypesJVMKt$typeToString$unwrap$1, reason: use source file name */
/* loaded from: classes.dex */
final /* synthetic */ class TypesJVM7 extends FunctionReferenceImpl implements Functions2<Class<? extends Object>, Class<?>> {
    public static final TypesJVM7 INSTANCE = new TypesJVM7();

    TypesJVM7() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override // kotlin.jvm.functions.Functions2
    public /* bridge */ /* synthetic */ Class<?> invoke(Class<? extends Object> cls) {
        return invoke2((Class<?>) cls);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Class<?> invoke2(Class<?> p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return p1.getComponentType();
    }
}
