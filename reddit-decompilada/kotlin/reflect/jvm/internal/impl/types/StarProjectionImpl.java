package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImpl extends TypeProjectionBase {
    static final /* synthetic */ KProperty[] f36170a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(StarProjectionImpl.class), "_type", "get_type()Lorg/jetbrains/kotlin/types/KotlinType;"))};
    private final Lazy f36171b = LazyKt.m26776a(LazyThreadSafetyMode.f25264b, new StarProjectionImpl$_type$2(this));
    private final TypeParameterDescriptor f36172c;

    public final boolean mo6734a() {
        return true;
    }

    public StarProjectionImpl(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.m26847b(typeParameterDescriptor, "typeParameter");
        this.f36172c = typeParameterDescriptor;
    }

    public final Variance mo6735b() {
        return Variance.f26339c;
    }

    public final KotlinType mo6736c() {
        return (KotlinType) this.f36171b.mo5678b();
    }
}
