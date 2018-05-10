package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: dynamicTypes.kt */
public final class DynamicTypesKt {
    public static final boolean m27930a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return kotlinType.mo6738h() instanceof DynamicType;
    }
}
