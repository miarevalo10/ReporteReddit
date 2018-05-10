package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: flexibleTypes.kt */
public final class FlexibleTypesKt {
    public static final boolean m27946a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return kotlinType.mo6738h() instanceof FlexibleType;
    }

    public static final FlexibleType m27947b(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo6738h();
        if (kotlinType != null) {
            return (FlexibleType) kotlinType;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
    }

    public static final SimpleType m27948c(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        UnwrappedType h = kotlinType.mo6738h();
        if (h instanceof FlexibleType) {
            kotlinType = ((FlexibleType) h).f38926a;
        } else if (h instanceof SimpleType) {
            kotlinType = (SimpleType) h;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return (SimpleType) kotlinType;
    }

    public static final SimpleType m27949d(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        UnwrappedType h = kotlinType.mo6738h();
        if (h instanceof FlexibleType) {
            kotlinType = ((FlexibleType) h).f38927b;
        } else if (h instanceof SimpleType) {
            kotlinType = (SimpleType) h;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return (SimpleType) kotlinType;
    }
}
