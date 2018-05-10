package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: dynamicTypes.kt */
public final class DynamicType extends FlexibleType {
    private final Annotations f39977c;

    public final String mo7270a(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.m26847b(descriptorRenderer, "renderer");
        Intrinsics.m26847b(descriptorRendererOptions, "options");
        return "dynamic";
    }

    public final boolean mo6741c() {
        return false;
    }

    private DynamicType(KotlinBuiltIns kotlinBuiltIns, Annotations annotations) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        Intrinsics.m26847b(annotations, "annotations");
        Object l = kotlinBuiltIns.m27014l();
        Intrinsics.m26843a(l, "builtIns.nothingType");
        Object n = kotlinBuiltIns.m27016n();
        Intrinsics.m26843a(n, "builtIns.nullableAnyType");
        super(l, n);
        this.f39977c = annotations;
    }

    public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
        Intrinsics.m26847b(annotations, "newAnnotations");
        return (UnwrappedType) new DynamicType(TypeUtilsKt.m28060a((KotlinType) this.f38927b), this.f39977c);
    }

    public final Annotations mo5718q() {
        return this.f39977c;
    }

    public final SimpleType aP_() {
        return this.f38927b;
    }
}
