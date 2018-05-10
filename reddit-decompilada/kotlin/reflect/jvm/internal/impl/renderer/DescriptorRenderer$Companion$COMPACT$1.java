package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DescriptorRenderer.kt */
final class DescriptorRenderer$Companion$COMPACT$1 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final DescriptorRenderer$Companion$COMPACT$1 f38789a = new DescriptorRenderer$Companion$COMPACT$1();

    DescriptorRenderer$Companion$COMPACT$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
        Intrinsics.m26847b(descriptorRendererOptions, "$receiver");
        descriptorRendererOptions.mo5910f(false);
        descriptorRendererOptions.mo5903b(SetsKt__SetsKt.m26799a());
        return Unit.f25273a;
    }
}
