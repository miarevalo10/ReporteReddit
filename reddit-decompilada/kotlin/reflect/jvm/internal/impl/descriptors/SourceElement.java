package kotlin.reflect.jvm.internal.impl.descriptors;

public interface SourceElement {
    public static final SourceElement f25498a = new C25541();

    static class C25541 implements SourceElement {
        public final String toString() {
            return "NO_SOURCE";
        }

        C25541() {
        }

        public final SourceFile mo5713a() {
            SourceFile sourceFile = SourceFile.f25499a;
            if (sourceFile != null) {
                return sourceFile;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"}));
        }
    }

    SourceFile mo5713a();
}
