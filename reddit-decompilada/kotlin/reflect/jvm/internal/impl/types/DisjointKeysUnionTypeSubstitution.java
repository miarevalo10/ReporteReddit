package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: DisjointKeysUnionTypeSubstitution.kt */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {
    public static final Companion f33061a = new Companion();
    private final TypeSubstitution f33062b;
    private final TypeSubstitution f33063c;

    /* compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class Companion {
        private Companion() {
        }

        public static TypeSubstitution m27929a(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
            Intrinsics.m26847b(typeSubstitution, "first");
            Intrinsics.m26847b(typeSubstitution2, "second");
            if (typeSubstitution.mo5796a()) {
                return typeSubstitution2;
            }
            if (typeSubstitution2.mo5796a()) {
                return typeSubstitution;
            }
            return new DisjointKeysUnionTypeSubstitution(typeSubstitution, typeSubstitution2);
        }
    }

    public static final TypeSubstitution m33584a(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        Intrinsics.m26847b(typeSubstitution, "first");
        Intrinsics.m26847b(typeSubstitution2, "second");
        return Companion.m27929a(typeSubstitution, typeSubstitution2);
    }

    public final boolean mo5796a() {
        return false;
    }

    private DisjointKeysUnionTypeSubstitution(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        this.f33062b = typeSubstitution;
        this.f33063c = typeSubstitution2;
    }

    public final TypeProjection mo5795a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "key");
        TypeProjection a = this.f33062b.mo5795a(kotlinType);
        return a == null ? this.f33063c.mo5795a(kotlinType) : a;
    }

    public final KotlinType mo5848a(KotlinType kotlinType, Variance variance) {
        Intrinsics.m26847b(kotlinType, "topLevelType");
        Intrinsics.m26847b(variance, "position");
        return this.f33063c.mo5848a(this.f33062b.mo5848a(kotlinType, variance), variance);
    }

    public final boolean mo5934c() {
        if (!this.f33062b.mo5934c()) {
            if (!this.f33063c.mo5934c()) {
                return false;
            }
        }
        return true;
    }

    public final boolean mo5933b() {
        if (!this.f33062b.mo5933b()) {
            if (!this.f33063c.mo5933b()) {
                return false;
            }
        }
        return true;
    }

    public final Annotations mo5932a(Annotations annotations) {
        Intrinsics.m26847b(annotations, "annotations");
        return this.f33063c.mo5932a(this.f33062b.mo5932a(annotations));
    }
}
