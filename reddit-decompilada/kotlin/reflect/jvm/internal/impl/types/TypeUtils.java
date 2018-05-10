package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

public class TypeUtils {
    public static final SimpleType f26330a = ErrorUtils.m27944d("DONT_CARE");
    public static final SimpleType f26331b = ErrorUtils.m27943c("Cannot be inferred");
    public static final SimpleType f26332c = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType f26333d = new SpecialType("UNIT_EXPECTED_TYPE");
    static final /* synthetic */ boolean f26334e = true;

    public static class SpecialType extends DelegatingSimpleType {
        private final String f40541a;

        public final boolean mo6742d() {
            return false;
        }

        public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
            return mo7296b(annotations);
        }

        public final /* synthetic */ UnwrappedType mo7272a(boolean z) {
            return mo7297b(z);
        }

        public SpecialType(String str) {
            this.f40541a = str;
        }

        protected final SimpleType mo7611e() {
            throw new IllegalStateException(this.f40541a);
        }

        public final SimpleType mo7296b(Annotations annotations) {
            if (annotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newAnnotations", "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType", "replaceAnnotations"}));
            }
            throw new IllegalStateException(this.f40541a);
        }

        public final SimpleType mo7297b(boolean z) {
            throw new IllegalStateException(this.f40541a);
        }

        public String toString() {
            return this.f40541a;
        }
    }

    public static boolean m28010a(KotlinType kotlinType) {
        return (kotlinType == null || kotlinType.mo6743g() != f26330a.mo6743g()) ? null : true;
    }

    public static KotlinType m28012b(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullable"}));
        }
        kotlinType = m28007a(kotlinType, true);
        if (kotlinType != null) {
            return kotlinType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullable"}));
    }

    public static KotlinType m28014c(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNotNullable"}));
        }
        kotlinType = m28007a(kotlinType, false);
        if (kotlinType != null) {
            return kotlinType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNotNullable"}));
    }

    public static KotlinType m28007a(KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableAsSpecified"}));
        }
        kotlinType = kotlinType.mo6738h().mo7272a(z);
        if (kotlinType != null) {
            return kotlinType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableAsSpecified"}));
    }

    public static KotlinType m28013b(KotlinType kotlinType, boolean z) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"}));
        } else if (z) {
            kotlinType = m28012b(kotlinType);
            if (kotlinType != null) {
                return kotlinType;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"}));
        } else if (kotlinType != null) {
            return kotlinType;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"}));
        }
    }

    public static SimpleType m28008a(ClassifierDescriptor classifierDescriptor, MemberScope memberScope) {
        if (ErrorUtils.m27938a((DeclarationDescriptor) classifierDescriptor)) {
            memberScope = new StringBuilder("Unsubstituted type for ");
            memberScope.append(classifierDescriptor);
            classifierDescriptor = ErrorUtils.m27943c(memberScope.toString());
            if (classifierDescriptor != null) {
                return classifierDescriptor;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeUnsubstitutedType"}));
        }
        classifierDescriptor = classifierDescriptor.mo7610c();
        List a = m28006a(classifierDescriptor.mo5723b());
        Companion companion = Annotations.f32643a;
        return KotlinTypeFactory.m27952a(Companion.m27115a(), classifierDescriptor, a, false, memberScope);
    }

    public static List<TypeProjection> m28006a(List<TypeParameterDescriptor> list) {
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"parameters", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getDefaultTypeProjections"}));
        }
        Collection arrayList = new ArrayList(list.size());
        for (TypeParameterDescriptor h : list) {
            arrayList.add(new TypeProjectionImpl(h.mo7714h()));
        }
        list = CollectionsKt.m28089a(arrayList);
        if (list != null) {
            return list;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getDefaultTypeProjections"}));
    }

    private static List<KotlinType> m28019h(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getImmediateSupertypes"}));
        }
        TypeSubstitutor a = TypeSubstitutor.m27996a(kotlinType);
        Collection<KotlinType> aL_ = kotlinType.mo6743g().aL_();
        List<KotlinType> arrayList = new ArrayList(aL_.size());
        for (KotlinType kotlinType2 : aL_) {
            if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subType", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "createSubstitutedSupertype"}));
            } else if (kotlinType2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superType", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "createSubstitutedSupertype"}));
            } else if (a == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "createSubstitutedSupertype"}));
            } else {
                kotlinType2 = a.m28005b(kotlinType2, Variance.f26337a);
                Object b = kotlinType2 != null ? m28013b(kotlinType2, kotlinType.mo6741c()) : null;
                if (b != null) {
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }

    public static boolean m28015d(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "isNullableType"}));
        } else if (kotlinType.mo6741c()) {
            return true;
        } else {
            if (FlexibleTypesKt.m27946a(kotlinType) && m28015d(FlexibleTypesKt.m27947b(kotlinType).f38927b)) {
                return true;
            }
            if (m28018g(kotlinType)) {
                return m28020i(kotlinType);
            }
            return false;
        }
    }

    public static boolean m28016e(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "acceptsNullable"}));
        } else if (kotlinType.mo6741c()) {
            return true;
        } else {
            return FlexibleTypesKt.m27946a(kotlinType) && m28016e(FlexibleTypesKt.m27947b(kotlinType).f38927b) != null;
        }
    }

    private static boolean m28020i(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "hasNullableSuperType"}));
        } else if (kotlinType.mo6743g().mo5724c() instanceof ClassDescriptor) {
            return false;
        } else {
            for (KotlinType d : m28019h(kotlinType)) {
                if (m28015d(d)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static ClassDescriptor m28017f(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getClassDescriptor"}));
        }
        kotlinType = kotlinType.mo6743g().mo5724c();
        return kotlinType instanceof ClassDescriptor ? (ClassDescriptor) kotlinType : null;
    }

    public static boolean m28011a(KotlinType kotlinType, Function1<UnwrappedType, Boolean> function1) {
        if (function1 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"isSpecialType", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "contains"}));
        } else if (kotlinType == null) {
            return false;
        } else {
            UnwrappedType h = kotlinType.mo6738h();
            if (((Boolean) function1.mo6492a(h)).booleanValue()) {
                return true;
            }
            FlexibleType flexibleType = h instanceof FlexibleType ? (FlexibleType) h : null;
            if (flexibleType != null && (m28011a(flexibleType.f38926a, (Function1) function1) || m28011a(flexibleType.f38927b, (Function1) function1))) {
                return true;
            }
            for (TypeProjection typeProjection : kotlinType.mo6739a()) {
                if (!typeProjection.mo6734a() && m28011a(typeProjection.mo6736c(), (Function1) function1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static TypeProjection m28009a(TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor != null) {
            return new StarProjectionImpl(typeParameterDescriptor);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"parameterDescriptor", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeStarProjection"}));
    }

    public static boolean m28018g(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "isTypeParameter"}));
        } else if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getTypeParameterDescriptorOrNull"}));
        } else {
            return (kotlinType.mo6743g().mo5724c() instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) kotlinType.mo6743g().mo5724c() : null) != null;
        }
    }
}
