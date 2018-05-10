package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$parentsWithSelf$1 extends Lambda implements Function1<DeclarationDescriptor, DeclarationDescriptor> {
    public static final DescriptorUtilsKt$parentsWithSelf$1 f38811a = new DescriptorUtilsKt$parentsWithSelf$1();

    DescriptorUtilsKt$parentsWithSelf$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
        Intrinsics.m26847b(declarationDescriptor, "it");
        return declarationDescriptor.aD_();
    }
}
