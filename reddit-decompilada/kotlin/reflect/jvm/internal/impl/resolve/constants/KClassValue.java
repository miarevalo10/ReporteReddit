package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: constantValues.kt */
public final class KClassValue extends ConstantValue<KotlinType> {
    private final KotlinType f32945a;

    public final KotlinType mo5917a() {
        return this.f32945a;
    }

    public final /* synthetic */ Object mo5919b() {
        return m33490c();
    }

    public KClassValue(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        super(kotlinType);
        this.f32945a = kotlinType;
    }

    public final KotlinType m33490c() {
        Object c = ((TypeProjection) CollectionsKt___CollectionsKt.m41441h(this.f32945a.mo6739a())).mo6736c();
        Intrinsics.m26843a(c, "type.arguments.single().type");
        return c;
    }
}
