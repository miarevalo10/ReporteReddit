package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

public class TypeSubstitutor {
    public static final TypeSubstitutor f26327a = m27997a(TypeSubstitution.f26320d);
    static final /* synthetic */ boolean f26328c = true;
    public final TypeSubstitution f26329b;

    private static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    private enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    static class C28001 implements Function1<FqName, Boolean> {
        C28001() {
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            FqName fqName = (FqName) obj;
            if (fqName != null) {
                return Boolean.valueOf(fqName.equals(KotlinBuiltIns.f25420j.f25362I) ^ 1);
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"}));
        }
    }

    public static TypeSubstitutor m27997a(TypeSubstitution typeSubstitution) {
        if (typeSubstitution != null) {
            return new TypeSubstitutor(typeSubstitution);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitution", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "create"}));
    }

    public static TypeSubstitutor m27998a(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        if (typeSubstitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"first", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "createChainedSubstitutor"}));
        } else if (typeSubstitution2 != null) {
            return m27997a(DisjointKeysUnionTypeSubstitution.m33584a(typeSubstitution, typeSubstitution2));
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"second", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "createChainedSubstitutor"}));
        }
    }

    public static TypeSubstitutor m27996a(KotlinType kotlinType) {
        if (kotlinType != null) {
            return m27997a(TypeConstructorSubstitution.m33614a(kotlinType.mo6743g(), kotlinType.mo6739a()));
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"context", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "create"}));
    }

    private TypeSubstitutor(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitution", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "<init>"}));
        } else {
            this.f26329b = typeSubstitution;
        }
    }

    public final TypeSubstitution m28004a() {
        TypeSubstitution typeSubstitution = this.f26329b;
        if (typeSubstitution != null) {
            return typeSubstitution;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "getSubstitution"}));
    }

    public final KotlinType m28005b(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "substitute"}));
        } else if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"howThisTypeIsUsed", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "substitute"}));
        } else {
            kotlinType = m28003a(new TypeProjectionImpl(variance, m28004a().mo5848a(kotlinType, variance)));
            if (this.f26329b.mo5934c() != null || this.f26329b.mo5933b() != null) {
                kotlinType = CapturedTypeApproximationKt.m28071a((TypeProjection) kotlinType, this.f26329b.mo5933b());
            }
            return kotlinType == null ? null : kotlinType.mo6736c();
        }
    }

    private TypeProjection m27995a(TypeProjection typeProjection, int i) throws SubstitutionException {
        if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"originalProjection", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"}));
        }
        Object obj = this.f26329b;
        StringBuilder stringBuilder;
        if (i > 100) {
            stringBuilder = new StringBuilder("Recursion too deep. Most likely infinite loop while substituting ");
            stringBuilder.append(m27993a((Object) typeProjection));
            stringBuilder.append("; substitution: ");
            stringBuilder.append(m27993a(obj));
            throw new IllegalStateException(stringBuilder.toString());
        } else if (!typeProjection.mo6734a()) {
            KotlinType c = typeProjection.mo6736c();
            if (!DynamicTypesKt.m27930a(c)) {
                if (!(c.mo6738h() instanceof RawType)) {
                    TypeProjection a = this.f26329b.mo5795a(c);
                    Variance b = typeProjection.mo6735b();
                    if (a == null && FlexibleTypesKt.m27946a(c) && !TypeCapabilitiesKt.m27960a(c)) {
                        typeProjection = FlexibleTypesKt.m27947b(c);
                        i++;
                        TypeProjection a2 = m27995a(new TypeProjectionImpl(b, typeProjection.f38926a), i);
                        typeProjection = m27995a(new TypeProjectionImpl(b, typeProjection.f38927b), i);
                        i = a2.mo6735b();
                        if (f26328c || ((i == typeProjection.mo6735b() && b == Variance.f26337a) || b == i)) {
                            return new TypeProjectionImpl(i, KotlinTypeFactory.m27953a(TypeSubstitutionKt.m27990a(a2.mo6736c()), TypeSubstitutionKt.m27990a(typeProjection.mo6736c())));
                        }
                        stringBuilder = new StringBuilder("Unexpected substituted projection kind: ");
                        stringBuilder.append(i);
                        stringBuilder.append("; original: ");
                        stringBuilder.append(b);
                        throw new AssertionError(stringBuilder.toString());
                    }
                    if (!KotlinBuiltIns.m26989e(c)) {
                        if (!c.mo6742d()) {
                            if (a != null) {
                                typeProjection = m28001b(b, a.mo6735b());
                                if (CapturedTypeConstructorKt.m27712a(c) == 0) {
                                    switch (typeProjection) {
                                        case OUT_IN_IN_POSITION:
                                            throw new SubstitutionException("Out-projection in in-position");
                                        case IN_IN_OUT_POSITION:
                                            return new TypeProjectionImpl(Variance.f26339c, c.mo6743g().mo5726e().m27016n());
                                        default:
                                            break;
                                    }
                                }
                                i = TypeCapabilitiesKt.m27962b(c);
                                if (!a.mo6734a()) {
                                    if (i != 0) {
                                        i = i.a_(a.mo6736c());
                                    } else {
                                        i = TypeUtils.m28013b(a.mo6736c(), c.mo6741c());
                                    }
                                    if (!c.mo5718q().mo6680a()) {
                                        Annotations a3 = this.f26329b.mo5932a(c.mo5718q());
                                        if (a3 == null) {
                                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "filterOutUnsafeVariance"}));
                                        }
                                        FilteredAnnotations filteredAnnotations;
                                        if (a3.mo6682b(KotlinBuiltIns.f25420j.f25362I)) {
                                            filteredAnnotations = new FilteredAnnotations(a3, new C28001());
                                        } else if (a3 == null) {
                                            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "filterOutUnsafeVariance"}));
                                        } else {
                                            filteredAnnotations = a3;
                                        }
                                        i = TypeUtilsKt.m28061a((KotlinType) i, new CompositeAnnotations(i.mo5718q(), filteredAnnotations));
                                    }
                                    if (typeProjection == VarianceConflictType.NO_CONFLICT) {
                                        b = m28000a(b, a.mo6735b());
                                    }
                                    return new TypeProjectionImpl(b, i);
                                } else if (a != null) {
                                    return a;
                                } else {
                                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"}));
                                }
                            }
                            KotlinType c2 = typeProjection.mo6736c();
                            Variance b2 = typeProjection.mo6735b();
                            if (!(c2.mo6743g().mo5724c() instanceof TypeParameterDescriptor)) {
                                typeProjection = null;
                                KotlinType a4 = SpecialTypesKt.m27954a(c2);
                                if (a4 != null) {
                                    typeProjection = m28005b(a4, Variance.f26337a);
                                }
                                i = TypeSubstitutionKt.m27989a(c2, m27994a(c2.mo6743g().mo5723b(), c2.mo6739a(), i), this.f26329b.mo5932a(c2.mo5718q()));
                                if ((i instanceof SimpleType) && (typeProjection instanceof SimpleType)) {
                                    i = SpecialTypesKt.m27955a((SimpleType) i, (SimpleType) typeProjection);
                                }
                                typeProjection = new TypeProjectionImpl(b2, i);
                            }
                            if (typeProjection != null) {
                                return typeProjection;
                            }
                            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"}));
                        }
                    }
                    if (typeProjection != null) {
                        return typeProjection;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"}));
                }
            }
            if (typeProjection != null) {
                return typeProjection;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"}));
        } else if (typeProjection != null) {
            return typeProjection;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"}));
        }
    }

    private List<TypeProjection> m27994a(List<TypeParameterDescriptor> list, List<TypeProjection> list2, int i) throws SubstitutionException {
        List<TypeProjection> arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) list.get(i2);
            Object a = m27995a((TypeProjection) list2.get(i2), i + 1);
            switch (m28001b(typeParameterDescriptor.mo7716k(), a.mo6735b())) {
                case OUT_IN_IN_POSITION:
                case IN_IN_OUT_POSITION:
                    a = TypeUtils.m28009a(typeParameterDescriptor);
                    break;
                case NO_CONFLICT:
                    if (!(typeParameterDescriptor.mo7716k() == Variance.f26337a || a.mo6734a())) {
                        a = new TypeProjectionImpl(Variance.f26337a, a.mo6736c());
                        break;
                    }
                default:
                    break;
            }
            arrayList.add(a);
        }
        return arrayList;
    }

    public static Variance m27999a(Variance variance, TypeProjection typeProjection) {
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameterVariance", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        } else if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeProjection", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        } else if (typeProjection.mo6734a()) {
            variance = Variance.f26339c;
            if (variance != null) {
                return variance;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        } else {
            variance = m28000a(variance, typeProjection.mo6735b());
            if (variance != null) {
                return variance;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        }
    }

    private static Variance m28000a(Variance variance, Variance variance2) {
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameterVariance", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        } else if (variance2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"projectionKind", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        } else if (variance == Variance.f26337a) {
            if (variance2 != null) {
                return variance2;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        } else if (variance2 == Variance.f26337a) {
            if (variance != null) {
                return variance;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        } else if (variance != variance2) {
            StringBuilder stringBuilder = new StringBuilder("Variance conflict: type parameter variance '");
            stringBuilder.append(variance);
            stringBuilder.append("' and projection kind '");
            stringBuilder.append(variance2);
            stringBuilder.append("' cannot be combined");
            throw new AssertionError(stringBuilder.toString());
        } else if (variance2 != null) {
            return variance2;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"}));
        }
    }

    private static VarianceConflictType m28001b(Variance variance, Variance variance2) {
        if (variance == Variance.f26338b && variance2 == Variance.f26339c) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.f26339c && variance2 == Variance.f26338b) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    private static String m27993a(Object obj) {
        try {
            return obj.toString();
        } catch (Object obj2) {
            if (obj2.getClass().getName().equals("com.intellij.openapi.progress.ProcessCanceledException")) {
                RuntimeException runtimeException = (RuntimeException) obj2;
            } else {
                StringBuilder stringBuilder = new StringBuilder("[Exception while computing toString(): ");
                stringBuilder.append(obj2);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        }
    }

    public final KotlinType m28002a(KotlinType kotlinType, Variance variance) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"}));
        } else if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"howThisTypeIsUsed", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"}));
        } else if (!this.f26329b.mo5796a()) {
            try {
                kotlinType = m27995a(new TypeProjectionImpl(variance, kotlinType), 0).mo6736c();
                if (kotlinType != null) {
                    return kotlinType;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"}));
            } catch (KotlinType kotlinType2) {
                kotlinType2 = ErrorUtils.m27943c(kotlinType2.getMessage());
                if (kotlinType2 != null) {
                    return kotlinType2;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"}));
            }
        } else if (kotlinType2 != null) {
            return kotlinType2;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"}));
        }
    }

    public final kotlin.reflect.jvm.internal.impl.types.TypeProjection m28003a(kotlin.reflect.jvm.internal.impl.types.TypeProjection r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0021;
    L_0x0003:
        r5 = new java.lang.IllegalArgumentException;
        r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r3 = "typeProjection";
        r2[r0] = r3;
        r0 = 1;
        r3 = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
        r2[r0] = r3;
        r0 = 2;
        r3 = "substituteWithoutApproximation";
        r2[r0] = r3;
        r0 = java.lang.String.format(r1, r2);
        r5.<init>(r0);
        throw r5;
    L_0x0021:
        r1 = r4.f26329b;
        r1 = r1.mo5796a();
        if (r1 == 0) goto L_0x002a;
    L_0x0029:
        return r5;
    L_0x002a:
        r5 = r4.m27995a(r5, r0);	 Catch:{ SubstitutionException -> 0x002f }
        return r5;
    L_0x002f:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.a(kotlin.reflect.jvm.internal.impl.types.TypeProjection):kotlin.reflect.jvm.internal.impl.types.TypeProjection");
    }
}
