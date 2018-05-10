package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.FULLY_QUALIFIED;

/* compiled from: DescriptorRenderer.kt */
final class DescriptorRenderer$Companion$DEBUG_TEXT$1 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final DescriptorRenderer$Companion$DEBUG_TEXT$1 f38792a = new DescriptorRenderer$Companion$DEBUG_TEXT$1();

    DescriptorRenderer$Companion$DEBUG_TEXT$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
        Intrinsics.m26847b(descriptorRendererOptions, "$receiver");
        descriptorRendererOptions.mo5902a(true);
        descriptorRendererOptions.mo5899a((ClassifierNamePolicy) FULLY_QUALIFIED.f32883a);
        descriptorRendererOptions.mo5903b(DescriptorRendererModifier.f26032k);
        return Unit.f25273a;
    }
}
