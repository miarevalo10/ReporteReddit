package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StarProjectionImpl.kt */
public final class TypeBasedStarProjectionImpl extends TypeProjectionBase {
    private final KotlinType f36174a;

    public final boolean mo6734a() {
        return true;
    }

    public TypeBasedStarProjectionImpl(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "_type");
        this.f36174a = kotlinType;
    }

    public final Variance mo6735b() {
        return Variance.f26339c;
    }

    public final KotlinType mo6736c() {
        return this.f36174a;
    }
}
