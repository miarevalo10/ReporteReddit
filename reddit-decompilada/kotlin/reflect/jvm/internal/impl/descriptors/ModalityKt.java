package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Modality.kt */
public final class ModalityKt {
    public static final boolean m27079a(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "$receiver");
        return (!Intrinsics.m26845a(classDescriptor.aG_(), Modality.f25488a) || (Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.ENUM_CLASS) ^ 1) == null) ? null : true;
    }
}
