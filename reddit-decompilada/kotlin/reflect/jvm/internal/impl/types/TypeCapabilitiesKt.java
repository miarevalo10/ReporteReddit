package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeCapabilities.kt */
public final class TypeCapabilitiesKt {
    public static final boolean m27960a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo6738h();
        if (!(kotlinType instanceof CustomTypeVariable)) {
            kotlinType = null;
        }
        CustomTypeVariable customTypeVariable = (CustomTypeVariable) kotlinType;
        return customTypeVariable != null ? customTypeVariable.aT_() : null;
    }

    public static final CustomTypeVariable m27962b(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo6738h();
        if (!(kotlinType instanceof CustomTypeVariable)) {
            kotlinType = null;
        }
        CustomTypeVariable customTypeVariable = (CustomTypeVariable) kotlinType;
        if (customTypeVariable == null) {
            return null;
        }
        kotlinType = customTypeVariable;
        if (!kotlinType.aT_()) {
            kotlinType = null;
        }
        return (CustomTypeVariable) kotlinType;
    }

    public static final KotlinType m27963c(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        UnwrappedType h = kotlinType.mo6738h();
        if (!(h instanceof SubtypingRepresentatives)) {
            h = null;
        }
        SubtypingRepresentatives subtypingRepresentatives = (SubtypingRepresentatives) h;
        if (subtypingRepresentatives == null) {
            return kotlinType;
        }
        KotlinType e = subtypingRepresentatives.mo7115e();
        return e == null ? kotlinType : e;
    }

    public static final KotlinType m27964d(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        UnwrappedType h = kotlinType.mo6738h();
        if (!(h instanceof SubtypingRepresentatives)) {
            h = null;
        }
        SubtypingRepresentatives subtypingRepresentatives = (SubtypingRepresentatives) h;
        if (subtypingRepresentatives == null) {
            return kotlinType;
        }
        KotlinType f = subtypingRepresentatives.mo7116f();
        return f == null ? kotlinType : f;
    }

    public static final boolean m27961a(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.m26847b(kotlinType, "first");
        Intrinsics.m26847b(kotlinType2, "second");
        UnwrappedType h = kotlinType.mo6738h();
        if (!(h instanceof SubtypingRepresentatives)) {
            h = null;
        }
        SubtypingRepresentatives subtypingRepresentatives = (SubtypingRepresentatives) h;
        if (!(subtypingRepresentatives != null ? subtypingRepresentatives.mo7114a(kotlinType2) : false)) {
            kotlinType2 = kotlinType2.mo6738h();
            if (!(kotlinType2 instanceof SubtypingRepresentatives)) {
                kotlinType2 = null;
            }
            SubtypingRepresentatives subtypingRepresentatives2 = (SubtypingRepresentatives) kotlinType2;
            if ((subtypingRepresentatives2 != null ? subtypingRepresentatives2.mo7114a(kotlinType) : null) == null) {
                return false;
            }
        }
        return true;
    }
}
