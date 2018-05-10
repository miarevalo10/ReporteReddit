package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DescriptorRenderer.kt */
final class DescriptorRenderer$Companion$HTML$1 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final DescriptorRenderer$Companion$HTML$1 f38794a = new DescriptorRenderer$Companion$HTML$1();

    DescriptorRenderer$Companion$HTML$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
        Intrinsics.m26847b(descriptorRendererOptions, "$receiver");
        descriptorRendererOptions.mo5901a(RenderingFormat.f26049b);
        descriptorRendererOptions.mo5903b(DescriptorRendererModifier.f26032k);
        return Unit.f25273a;
    }
}
