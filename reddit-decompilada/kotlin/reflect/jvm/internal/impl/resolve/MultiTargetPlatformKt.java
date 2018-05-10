package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: MultiTargetPlatform.kt */
public final class MultiTargetPlatformKt {
    public static final MultiTargetPlatform m27671a(ModuleDescriptor moduleDescriptor) {
        Intrinsics.m26847b(moduleDescriptor, "$receiver");
        return (MultiTargetPlatform) DescriptorUtilsKt.m27744c((DeclarationDescriptor) moduleDescriptor).mo7085a(MultiTargetPlatform.f26072a);
    }
}
