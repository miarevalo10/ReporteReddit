package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* compiled from: TypeUtils.kt */
public final class TypeUtilsKt {
    public static final KotlinBuiltIns m28060a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        Object e = kotlinType.mo6743g().mo5726e();
        Intrinsics.m26843a(e, "constructor.builtIns");
        return e;
    }

    public static final KotlinType m28065b(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return TypeUtils.m28012b(kotlinType);
    }

    public static final KotlinType m28066c(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return TypeUtils.m28014c(kotlinType);
    }

    public static final boolean m28067d(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return TypeUtils.m28018g(kotlinType);
    }

    public static final boolean m28064a(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        Intrinsics.m26847b(kotlinType2, "superType");
        return KotlinTypeChecker.f26349a.mo5935a(kotlinType, kotlinType2);
    }

    public static final KotlinType m28061a(KotlinType kotlinType, Annotations annotations) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        Intrinsics.m26847b(annotations, "newAnnotations");
        if (kotlinType.mo5718q().mo6680a() && annotations.mo6680a()) {
            return kotlinType;
        }
        return kotlinType.mo6738h().mo7271a(annotations);
    }

    public static final TypeProjection m28063a(KotlinType kotlinType, Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.m26847b(kotlinType, "type");
        Intrinsics.m26847b(variance, "projectionKind");
        if (Intrinsics.m26845a(typeParameterDescriptor != null ? typeParameterDescriptor.mo7716k() : null, (Object) variance) != null) {
            variance = Variance.f26337a;
        }
        return new TypeProjectionImpl(variance, kotlinType);
    }

    public static final TypeProjection m28068e(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return new TypeProjectionImpl(kotlinType);
    }

    public static final KotlinType m28069f(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo6738h();
        if (kotlinType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) kotlinType;
            return KotlinTypeFactory.m27953a(m28062a(flexibleType.f38926a), m28062a(flexibleType.f38927b));
        } else if (kotlinType instanceof SimpleType) {
            return m28062a((SimpleType) kotlinType);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final SimpleType m28062a(SimpleType simpleType) {
        if (!simpleType.mo6743g().mo5723b().isEmpty()) {
            if (simpleType.mo6743g().mo5724c() != null) {
                Iterable<TypeParameterDescriptor> b = simpleType.mo6743g().mo5723b();
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
                for (TypeParameterDescriptor starProjectionImpl : b) {
                    arrayList.add(new StarProjectionImpl(starProjectionImpl));
                }
                return TypeSubstitutionKt.m27992a(simpleType, (List) arrayList, simpleType.mo5718q());
            }
        }
        return simpleType;
    }
}
