package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
public final class NotNullTypeParameter extends DelegatingSimpleType implements CustomTypeVariable {
    private final SimpleType f40293a;

    public final boolean aT_() {
        return true;
    }

    public final boolean mo6741c() {
        return false;
    }

    public final boolean mo6742d() {
        return false;
    }

    public NotNullTypeParameter(SimpleType simpleType) {
        Intrinsics.m26847b(simpleType, "delegate");
        this.f40293a = simpleType;
    }

    public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
        return m41513c(annotations);
    }

    public final /* synthetic */ UnwrappedType mo7272a(boolean z) {
        return mo7297b(z);
    }

    public final /* synthetic */ SimpleType mo7296b(Annotations annotations) {
        return m41513c(annotations);
    }

    protected final SimpleType mo7611e() {
        return this.f40293a;
    }

    public final KotlinType a_(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "replacement");
        kotlinType = kotlinType.mo6738h();
        KotlinType kotlinType2 = kotlinType;
        if (!TypeUtils.m28015d(kotlinType2) && !TypeUtilsKt.m28067d(kotlinType2)) {
            return kotlinType2;
        }
        if (kotlinType instanceof SimpleType) {
            return m41512a((SimpleType) kotlinType);
        }
        if (kotlinType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) kotlinType;
            return KotlinTypeFactory.m27953a(m41512a(flexibleType.f38926a), m41512a(flexibleType.f38927b));
        }
        StringBuilder stringBuilder = new StringBuilder("Incorrect type: ");
        stringBuilder.append(kotlinType);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private static SimpleType m41512a(SimpleType simpleType) {
        SimpleType b = simpleType.mo7297b(false);
        if (TypeUtilsKt.m28067d(simpleType) == null) {
            return b;
        }
        return new NotNullTypeParameter(b);
    }

    private NotNullTypeParameter m41513c(Annotations annotations) {
        Intrinsics.m26847b(annotations, "newAnnotations");
        return new NotNullTypeParameter(this.f40293a.mo7296b(annotations));
    }

    public final SimpleType mo7297b(boolean z) {
        return z ? this.f40293a.mo7297b(true) : this;
    }
}
