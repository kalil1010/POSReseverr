package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypesJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, m17d2 = {"<anonymous>", "", "p1", "Ljava/lang/reflect/Type;", "invoke"}, m18k = 3, m19mv = {1, 4, 0})
/* renamed from: kotlin.reflect.ParameterizedTypeImpl$getTypeName$1$1, reason: use source file name */
/* loaded from: classes.dex */
final /* synthetic */ class TypesJVM3 extends FunctionReferenceImpl implements Functions2<Type, String> {
    public static final TypesJVM3 INSTANCE = new TypesJVM3();

    TypesJVM3() {
        super(1, TypesJVM6.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Functions2
    public final String invoke(Type p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return TypesJVM6.typeToString(p1);
    }
}
