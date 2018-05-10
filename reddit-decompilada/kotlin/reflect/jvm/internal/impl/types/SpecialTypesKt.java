package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpecialTypes.kt */
public final class SpecialTypesKt {
    public static final SimpleType m27954a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo6738h();
        if (!(kotlinType instanceof AbbreviatedType)) {
            kotlinType = null;
        }
        AbbreviatedType abbreviatedType = (AbbreviatedType) kotlinType;
        return abbreviatedType != null ? abbreviatedType.f40540b : null;
    }

    public static final SimpleType m27955a(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.m26847b(simpleType, "$receiver");
        Intrinsics.m26847b(simpleType2, "abbreviatedType");
        if (simpleType.mo6742d()) {
            return simpleType;
        }
        return new AbbreviatedType(simpleType, simpleType2);
    }
}
