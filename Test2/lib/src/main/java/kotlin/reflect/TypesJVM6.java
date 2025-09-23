package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* compiled from: TypesJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, m17d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.reflect.TypesJVMKt, reason: use source file name */
/* loaded from: classes.dex */
public final class TypesJVM6 {

    @Metadata(m15bv = {1, 0, 3}, m18k = 3, m19mv = {1, 4, 0})
    /* renamed from: kotlin.reflect.TypesJVMKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[KVariance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KVariance.IN.ordinal()] = 1;
            $EnumSwitchMapping$0[KVariance.INVARIANT.ordinal()] = 2;
            $EnumSwitchMapping$0[KVariance.OUT.ordinal()] = 3;
            int[] iArr2 = new int[KVariance.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[KVariance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$1[KVariance.IN.ordinal()] = 2;
            $EnumSwitchMapping$1[KVariance.OUT.ordinal()] = 3;
        }
    }

    public static /* synthetic */ void getJavaType$annotations(KType kType) {
    }

    private static /* synthetic */ void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    public static final Type getJavaType(KType javaType) {
        Type it;
        Intrinsics.checkNotNullParameter(javaType, "$this$javaType");
        if ((javaType instanceof KTypeBase) && (it = ((KTypeBase) javaType).getJavaType()) != null) {
            return it;
        }
        return computeJavaType$default(javaType, false, 1, null);
    }

    static /* synthetic */ Type computeJavaType$default(KType kType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return computeJavaType(kType, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type computeJavaType(KType $this$computeJavaType, boolean forceWrapper) {
        int i;
        KClassifier classifier = $this$computeJavaType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypesJVM5((KTypeParameter) classifier);
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            Class jClass = forceWrapper ? JvmClassMapping.getJavaObjectType(kClass) : JvmClassMapping.getJavaClass(kClass);
            List arguments = $this$computeJavaType.getArguments();
            if (arguments.isEmpty()) {
                return jClass;
            }
            if (jClass.isArray()) {
                if (jClass.getComponentType().isPrimitive()) {
                    return jClass;
                }
                KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.singleOrNull(arguments);
                if (kTypeProjection != null) {
                    KVariance variance = kTypeProjection.getVariance();
                    KType elementType = kTypeProjection.getType();
                    if (variance == null || (i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) == 1) {
                        return jClass;
                    }
                    if (i == 2 || i == 3) {
                        Intrinsics.checkNotNull(elementType);
                        Type javaElementType = computeJavaType$default(elementType, false, 1, null);
                        return javaElementType instanceof Class ? jClass : new TypesJVM(javaElementType);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + $this$computeJavaType);
            }
            return createPossiblyInnerType(jClass, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + $this$computeJavaType);
    }

    private static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class ownerClass = cls.getDeclaringClass();
        if (ownerClass != null) {
            if (Modifier.isStatic(cls.getModifiers())) {
                Class cls2 = ownerClass;
                List<KTypeProjection> $this$map$iv = list;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(getJavaType((KTypeProjection) item$iv$iv));
                }
                return new TypesJVM2(cls, cls2, (List) destination$iv$iv);
            }
            int n = cls.getTypeParameters().length;
            Type typeCreatePossiblyInnerType = createPossiblyInnerType(ownerClass, list.subList(n, list.size()));
            Iterable $this$map$iv2 = list.subList(0, n);
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                destination$iv$iv2.add(getJavaType((KTypeProjection) item$iv$iv2));
            }
            return new TypesJVM2(cls, typeCreatePossiblyInnerType, (List) destination$iv$iv2);
        }
        List<KTypeProjection> $this$map$iv3 = list;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            destination$iv$iv3.add(getJavaType((KTypeProjection) item$iv$iv3));
        }
        return new TypesJVM2(cls, null, (List) destination$iv$iv3);
    }

    private static final Type getJavaType(KTypeProjection $this$javaType) {
        KVariance variance = $this$javaType.getVariance();
        if (variance == null) {
            return TypesJVM8.INSTANCE.getSTAR();
        }
        KType type = $this$javaType.getType();
        Intrinsics.checkNotNull(type);
        int i = WhenMappings.$EnumSwitchMapping$1[variance.ordinal()];
        if (i == 1) {
            return computeJavaType(type, true);
        }
        if (i == 2) {
            return new TypesJVM8(null, computeJavaType(type, true));
        }
        if (i == 3) {
            return new TypesJVM8(computeJavaType(type, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String typeToString(Type type) {
        String name;
        if (type instanceof Class) {
            if (((Class) type).isArray()) {
                Sequence unwrap = SequencesKt.generateSequence(type, TypesJVM7.INSTANCE);
                name = ((Class) SequencesKt.last(unwrap)).getName() + StringsKt.repeat(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, SequencesKt.count(unwrap));
            } else {
                name = ((Class) type).getName();
            }
            Intrinsics.checkNotNullExpressionValue(name, "if (type.isArray) {\n    …\n        } else type.name");
            return name;
        }
        return type.toString();
    }
}
