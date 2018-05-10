package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: TypeSubstitution.kt */
public abstract class TypeSubstitution {
    public static final TypeSubstitution f26320d = new TypeSubstitution$Companion$EMPTY$1();
    public static final Companion f26321e = new Companion();

    /* compiled from: TypeSubstitution.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public Annotations mo5932a(Annotations annotations) {
        Intrinsics.m26847b(annotations, "annotations");
        return annotations;
    }

    public KotlinType mo5848a(KotlinType kotlinType, Variance variance) {
        Intrinsics.m26847b(kotlinType, "topLevelType");
        Intrinsics.m26847b(variance, "position");
        return kotlinType;
    }

    public abstract TypeProjection mo5795a(KotlinType kotlinType);

    public boolean mo5796a() {
        return false;
    }

    public boolean mo5933b() {
        return false;
    }

    public boolean mo5934c() {
        return false;
    }

    public final TypeSubstitutor m27987d() {
        Object a = TypeSubstitutor.m27997a(this);
        Intrinsics.m26843a(a, "TypeSubstitutor.create(this)");
        return a;
    }
}
