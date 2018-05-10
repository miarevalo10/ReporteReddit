package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DescriptorRendererOptionsImpl.kt */
final class DescriptorRendererOptionsImpl$typeNormalizer$2 extends Lambda implements Function1<KotlinType, KotlinType> {
    public static final DescriptorRendererOptionsImpl$typeNormalizer$2 f38801a = new DescriptorRendererOptionsImpl$typeNormalizer$2();

    DescriptorRendererOptionsImpl$typeNormalizer$2() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        KotlinType kotlinType = (KotlinType) obj;
        Intrinsics.m26847b(kotlinType, "it");
        return kotlinType;
    }
}
