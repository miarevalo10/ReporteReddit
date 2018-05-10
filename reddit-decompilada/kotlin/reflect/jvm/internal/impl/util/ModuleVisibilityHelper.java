package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: ModuleVisibilityHelper.kt */
public interface ModuleVisibilityHelper {

    /* compiled from: ModuleVisibilityHelper.kt */
    public static final class EMPTY implements ModuleVisibilityHelper {
        public static final EMPTY f33090a = null;

        public final boolean mo5946a(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            Intrinsics.m26847b(declarationDescriptor, "what");
            Intrinsics.m26847b(declarationDescriptor2, "from");
            return true;
        }

        static {
            EMPTY empty = new EMPTY();
        }

        private EMPTY() {
            f33090a = this;
        }
    }

    boolean mo5946a(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2);
}
