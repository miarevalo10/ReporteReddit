package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SHORT;

/* compiled from: DescriptorRenderer.kt */
final class DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1 f38791a = new DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1();

    DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
        Intrinsics.m26847b(descriptorRendererOptions, "$receiver");
        descriptorRendererOptions.mo5903b(SetsKt__SetsKt.m26799a());
        descriptorRendererOptions.mo5899a((ClassifierNamePolicy) SHORT.f32884a);
        descriptorRendererOptions.mo5900a(ParameterNameRenderingPolicy.f26045b);
        return Unit.f25273a;
    }
}
