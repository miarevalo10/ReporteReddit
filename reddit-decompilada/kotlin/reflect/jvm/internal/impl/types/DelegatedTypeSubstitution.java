package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: TypeSubstitution.kt */
public class DelegatedTypeSubstitution extends TypeSubstitution {
    private final TypeSubstitution f33060a;

    public DelegatedTypeSubstitution(TypeSubstitution typeSubstitution) {
        Intrinsics.m26847b(typeSubstitution, "substitution");
        this.f33060a = typeSubstitution;
    }

    public TypeProjection mo5795a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "key");
        return this.f33060a.mo5795a(kotlinType);
    }

    public final KotlinType mo5848a(KotlinType kotlinType, Variance variance) {
        Intrinsics.m26847b(kotlinType, "topLevelType");
        Intrinsics.m26847b(variance, "position");
        return this.f33060a.mo5848a(kotlinType, variance);
    }

    public final boolean mo5796a() {
        return this.f33060a.mo5796a();
    }

    public final boolean mo5934c() {
        return this.f33060a.mo5934c();
    }

    public boolean mo5933b() {
        return this.f33060a.mo5933b();
    }

    public final Annotations mo5932a(Annotations annotations) {
        Intrinsics.m26847b(annotations, "annotations");
        return this.f33060a.mo5932a(annotations);
    }
}
