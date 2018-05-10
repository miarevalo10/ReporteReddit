package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check.DefaultImpls;

/* compiled from: modifierChecks.kt */
public abstract class MemberKindCheck implements Check {
    private final String f33089a;

    /* compiled from: modifierChecks.kt */
    public static final class Member extends MemberKindCheck {
        public static final Member f36180a = null;

        static {
            Member member = new Member();
        }

        private Member() {
            super("must be a member function");
            f36180a = this;
        }

        public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
            Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
            return functionDescriptor.mo7756e() != null ? true : null;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class MemberOrExtension extends MemberKindCheck {
        public static final MemberOrExtension f36181a = null;

        static {
            MemberOrExtension memberOrExtension = new MemberOrExtension();
        }

        private MemberOrExtension() {
            super("must be a member or an extension function");
            f36181a = this;
        }

        public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
            Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
            if (functionDescriptor.mo7756e() == null) {
                if (functionDescriptor.mo7755d() == null) {
                    return null;
                }
            }
            return true;
        }
    }

    private MemberKindCheck(String str) {
        this.f33089a = str;
    }

    public final String mo5943a() {
        return this.f33089a;
    }

    public final String mo5945b(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        return DefaultImpls.m28076a(this, functionDescriptor);
    }
}
