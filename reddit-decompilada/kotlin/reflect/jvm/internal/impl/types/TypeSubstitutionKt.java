package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: TypeSubstitution.kt */
public final class TypeSubstitutionKt {
    public static final KotlinType m27989a(KotlinType kotlinType, List<? extends TypeProjection> list, Annotations annotations) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        Intrinsics.m26847b(list, "newArguments");
        Intrinsics.m26847b(annotations, "newAnnotations");
        if (list.isEmpty() && annotations == kotlinType.mo5718q()) {
            return kotlinType;
        }
        kotlinType = kotlinType.mo6738h();
        if (kotlinType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) kotlinType;
            return KotlinTypeFactory.m27953a(m27992a(flexibleType.f38926a, (List) list, annotations), m27992a(flexibleType.f38927b, (List) list, annotations));
        } else if (kotlinType instanceof SimpleType) {
            return m27992a((SimpleType) kotlinType, (List) list, annotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static SimpleType m27992a(SimpleType simpleType, List<? extends TypeProjection> list, Annotations annotations) {
        Intrinsics.m26847b(simpleType, "$receiver");
        Intrinsics.m26847b(list, "newArguments");
        Intrinsics.m26847b(annotations, "newAnnotations");
        if (list.isEmpty() && annotations == simpleType.mo5718q()) {
            return simpleType;
        }
        if (list.isEmpty()) {
            return KotlinTypeFactory.m27952a(annotations, simpleType.mo6743g(), simpleType.mo6739a(), simpleType.mo6741c(), simpleType.mo6740b());
        }
        return KotlinTypeFactory.m27951a(annotations, simpleType.mo6743g(), list, simpleType.mo6741c());
    }

    public static final SimpleType m27990a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        UnwrappedType h = kotlinType.mo6738h();
        if (!(h instanceof SimpleType)) {
            h = null;
        }
        SimpleType simpleType = (SimpleType) h;
        if (simpleType != null) {
            return simpleType;
        }
        StringBuilder stringBuilder = new StringBuilder("This is should be simple type: ");
        stringBuilder.append(kotlinType);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }
}
