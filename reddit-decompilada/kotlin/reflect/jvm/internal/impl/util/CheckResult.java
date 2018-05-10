package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: modifierChecks.kt */
public abstract class CheckResult {
    public final boolean f26375a;

    /* compiled from: modifierChecks.kt */
    public static final class IllegalFunctionName extends CheckResult {
        public static final IllegalFunctionName f33084b = null;

        static {
            IllegalFunctionName illegalFunctionName = new IllegalFunctionName();
        }

        private IllegalFunctionName() {
            super(false);
            f33084b = this;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class IllegalSignature extends CheckResult {
        private final String f33085b;

        public IllegalSignature(String str) {
            Intrinsics.m26847b(str, "error");
            super(false);
            this.f33085b = str;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class SuccessCheck extends CheckResult {
        public static final SuccessCheck f33086b = null;

        static {
            SuccessCheck successCheck = new SuccessCheck();
        }

        private SuccessCheck() {
            super(true);
            f33086b = this;
        }
    }

    private CheckResult(boolean z) {
        this.f26375a = z;
    }
}
