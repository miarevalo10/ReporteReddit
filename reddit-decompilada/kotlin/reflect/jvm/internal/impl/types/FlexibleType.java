package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: KotlinType.kt */
public abstract class FlexibleType extends UnwrappedType implements SubtypingRepresentatives {
    public final SimpleType f38926a;
    public final SimpleType f38927b;

    public abstract String mo7270a(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions);

    public final boolean mo7114a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        return false;
    }

    public abstract SimpleType aP_();

    public FlexibleType(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.m26847b(simpleType, "lowerBound");
        Intrinsics.m26847b(simpleType2, "upperBound");
        super();
        this.f38926a = simpleType;
        this.f38927b = simpleType2;
    }

    public final KotlinType mo7115e() {
        return this.f38926a;
    }

    public final KotlinType mo7116f() {
        return this.f38927b;
    }

    public Annotations mo5718q() {
        return aP_().mo5718q();
    }

    public final TypeConstructor mo6743g() {
        return aP_().mo6743g();
    }

    public final List<TypeProjection> mo6739a() {
        return aP_().mo6739a();
    }

    public boolean mo6741c() {
        return aP_().mo6741c();
    }

    public MemberScope mo6740b() {
        return aP_().mo6740b();
    }

    public final boolean mo6742d() {
        return aP_().mo6742d();
    }

    public String toString() {
        return DescriptorRenderer.f26014g.mo5894a((KotlinType) this);
    }
}
