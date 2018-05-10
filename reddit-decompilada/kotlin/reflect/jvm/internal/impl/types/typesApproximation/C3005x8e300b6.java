package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.FULLY_QUALIFIED;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;

/* compiled from: CapturedTypeApproximation.kt */
final class C3005x8e300b6 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final C3005x8e300b6 f38948a = new C3005x8e300b6();

    C3005x8e300b6() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
        Intrinsics.m26847b(descriptorRendererOptions, "$receiver");
        descriptorRendererOptions.mo5899a((ClassifierNamePolicy) FULLY_QUALIFIED.f32883a);
        return Unit.f25273a;
    }
}
