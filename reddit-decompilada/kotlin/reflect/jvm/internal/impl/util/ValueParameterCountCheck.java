package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check.DefaultImpls;

/* compiled from: modifierChecks.kt */
public abstract class ValueParameterCountCheck implements Check {
    private final String f33098a;

    /* compiled from: modifierChecks.kt */
    public static final class AtLeast extends ValueParameterCountCheck {
        private final int f36185a;

        public AtLeast(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder("must have at least ");
            stringBuilder2.append(i);
            stringBuilder2.append(" value parameter");
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(i > 1 ? "s" : "");
            super(stringBuilder.toString());
            this.f36185a = i;
        }

        public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
            Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
            return functionDescriptor.mo7757k().size() >= this.f36185a ? true : null;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class Equals extends ValueParameterCountCheck {
        private final int f36186a = 2;

        public Equals() {
            super("must have exactly 2 value parameters");
        }

        public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
            Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
            return functionDescriptor.mo7757k().size() == this.f36186a ? true : null;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class NoValueParameters extends ValueParameterCountCheck {
        public static final NoValueParameters f36187a = null;

        static {
            NoValueParameters noValueParameters = new NoValueParameters();
        }

        private NoValueParameters() {
            super("must have no value parameters");
            f36187a = this;
        }

        public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
            Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
            return functionDescriptor.mo7757k().isEmpty();
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class SingleValueParameter extends ValueParameterCountCheck {
        public static final SingleValueParameter f36188a = null;

        static {
            SingleValueParameter singleValueParameter = new SingleValueParameter();
        }

        private SingleValueParameter() {
            super("must have a single value parameter");
            f36188a = this;
        }

        public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
            Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
            return functionDescriptor.mo7757k().size() == 1 ? true : null;
        }
    }

    private ValueParameterCountCheck(String str) {
        this.f33098a = str;
    }

    public final String mo5943a() {
        return this.f33098a;
    }

    public final String mo5945b(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        return DefaultImpls.m28076a(this, functionDescriptor);
    }
}
