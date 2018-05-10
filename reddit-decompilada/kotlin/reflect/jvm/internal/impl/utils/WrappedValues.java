package kotlin.reflect.jvm.internal.impl.utils;

public class WrappedValues {
    public static volatile boolean f26434a = false;
    private static final Object f26435b = new C21481();

    static class C21481 {
        public final String toString() {
            return "NULL_VALUE";
        }

        C21481() {
        }
    }

    private static final class ThrowableWrapper {
        final Throwable f26433a;

        private ThrowableWrapper(Throwable th) {
            if (th == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"throwable", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper", "<init>"}));
            } else {
                this.f26433a = th;
            }
        }

        public final String toString() {
            return this.f26433a.toString();
        }
    }

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    public static <V> Object m28122a(V v) {
        if (v == null) {
            v = f26435b;
            if (v != null) {
                return v;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "escapeNull"}));
        } else if (v != null) {
            return v;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "escapeNull"}));
        }
    }

    public static Object m28123a(Throwable th) {
        return new ThrowableWrapper(th);
    }

    public static <V> V m28124b(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"value", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "unescapeExceptionOrNull"}));
        }
        obj = m28125c(obj);
        if (obj != null) {
            return obj == f26435b ? null : obj;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"value", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "unescapeNull"}));
        }
    }

    public static <V> V m28125c(Object obj) {
        if (!(obj instanceof ThrowableWrapper)) {
            return obj;
        }
        obj = ((ThrowableWrapper) obj).f26433a;
        if (obj == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper", "getThrowable"}));
        } else if (f26434a && obj.getClass().getName().equals("com.intellij.openapi.progress.ProcessCanceledException")) {
            throw new WrappedProcessCanceledException(obj);
        } else {
            throw ExceptionUtilsKt.m28104a(obj);
        }
    }
}
