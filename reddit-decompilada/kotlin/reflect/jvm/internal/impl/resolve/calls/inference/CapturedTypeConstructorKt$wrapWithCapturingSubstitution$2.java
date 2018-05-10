package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2 extends DelegatedTypeSubstitution {
    final /* synthetic */ TypeSubstitution f36141a;
    final /* synthetic */ boolean f36142b = true;

    CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        this.f36141a = typeSubstitution;
        super(typeSubstitution2);
    }

    public final boolean mo5933b() {
        return this.f36142b;
    }

    public final TypeProjection mo5795a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "key");
        TypeProjection a = super.mo5795a(kotlinType);
        if (a == null) {
            return null;
        }
        kotlinType = kotlinType.mo6743g().mo5724c();
        if (!(kotlinType instanceof TypeParameterDescriptor)) {
            kotlinType = null;
        }
        return CapturedTypeConstructorKt.m27713b(a, (TypeParameterDescriptor) kotlinType);
    }
}
