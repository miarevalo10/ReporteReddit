package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility.Permissiveness;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: EffectiveVisibility.kt */
public final class EffectiveVisibilityKt {
    public static final Permissiveness m27059a(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        if (classDescriptor != null) {
            if (classDescriptor2 != null) {
                if (Intrinsics.m26845a((Object) classDescriptor, (Object) classDescriptor2)) {
                    return Permissiveness.f25480b;
                }
                if (DescriptorUtils.m27650b(classDescriptor, classDescriptor2)) {
                    return Permissiveness.f25479a;
                }
                if (DescriptorUtils.m27650b(classDescriptor2, classDescriptor) != null) {
                    return Permissiveness.f25481c;
                }
                return Permissiveness.f25482d;
            }
        }
        return Permissiveness.f25482d;
    }
}
