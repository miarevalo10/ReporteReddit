package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* compiled from: PlatformDependentDeclarationFilter.kt */
public interface PlatformDependentDeclarationFilter {

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class All implements PlatformDependentDeclarationFilter {
        public static final All f33039a = null;

        public final boolean mo5826a(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
            Intrinsics.m26847b(simpleFunctionDescriptor, "functionDescriptor");
            return true;
        }

        static {
            All all = new All();
        }

        private All() {
            f33039a = this;
        }
    }

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class NoPlatformDependent implements PlatformDependentDeclarationFilter {
        public static final NoPlatformDependent f33040a = null;

        static {
            NoPlatformDependent noPlatformDependent = new NoPlatformDependent();
        }

        private NoPlatformDependent() {
            f33040a = this;
        }

        public final boolean mo5826a(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
            Intrinsics.m26847b(simpleFunctionDescriptor, "functionDescriptor");
            return simpleFunctionDescriptor.mo5718q().mo6682b(PlatformDependentDeclarationFilterKt.m27864a()) == null ? true : null;
        }
    }

    boolean mo5826a(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor);
}
