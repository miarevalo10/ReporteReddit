package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;

/* compiled from: DescriptorRendererImpl.kt */
final class DescriptorRendererImpl$functionTypeAnnotationsRenderer$2 extends Lambda implements Function0<DescriptorRendererImpl> {
    final /* synthetic */ DescriptorRendererImpl f38798a;

    /* compiled from: DescriptorRendererImpl.kt */
    static final class C29811 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
        public static final C29811 f38797a = new C29811();

        C29811() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
            Intrinsics.m26847b(descriptorRendererOptions, "$receiver");
            descriptorRendererOptions.mo5897a(SetsKt___SetsKt.m32819a(descriptorRendererOptions.mo5906c(), (Iterable) CollectionsKt__CollectionsKt.m26791a((Object) KotlinBuiltIns.f25420j.f25405z)));
            descriptorRendererOptions.mo5898a(AnnotationArgumentsRenderingPolicy.f26003c);
            return Unit.f25273a;
        }
    }

    DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(DescriptorRendererImpl descriptorRendererImpl) {
        this.f38798a = descriptorRendererImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return (DescriptorRendererImpl) this.f38798a.m27597a((Function1) C29811.f38797a);
    }
}
