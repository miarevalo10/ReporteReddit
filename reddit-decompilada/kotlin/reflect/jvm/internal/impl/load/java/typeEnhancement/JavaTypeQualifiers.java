package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* compiled from: typeQualifiers.kt */
public final class JavaTypeQualifiers {
    public static final Companion f25739d = new Companion();
    private static final JavaTypeQualifiers f25740e = new JavaTypeQualifiers(null, null, false);
    final NullabilityQualifier f25741a;
    final MutabilityQualifier f25742b;
    final boolean f25743c;

    /* compiled from: typeQualifiers.kt */
    public static final class Companion {
        private Companion() {
        }

        public static JavaTypeQualifiers m27257a() {
            return JavaTypeQualifiers.f25740e;
        }
    }

    public JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z) {
        this.f25741a = nullabilityQualifier;
        this.f25742b = mutabilityQualifier;
        this.f25743c = z;
    }
}
