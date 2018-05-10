package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SHORT;

/* compiled from: DescriptorRenderer.kt */
final class DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1 f38795a = new DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1();

    DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
        Intrinsics.m26847b(descriptorRendererOptions, "$receiver");
        descriptorRendererOptions.mo5910f(false);
        descriptorRendererOptions.mo5903b(SetsKt__SetsKt.m26799a());
        descriptorRendererOptions.mo5899a((ClassifierNamePolicy) SHORT.f32884a);
        descriptorRendererOptions.mo5912h(true);
        descriptorRendererOptions.mo5900a(ParameterNameRenderingPolicy.f26046c);
        descriptorRendererOptions.mo5904b(true);
        descriptorRendererOptions.mo5907c(true);
        descriptorRendererOptions.mo5911g(true);
        descriptorRendererOptions.mo5908d(true);
        return Unit.f25273a;
    }
}
