package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

public class ReflectProperties {

    public static abstract class Val<T> {
        private static final Object f25338a = new C21381();

        static class C21381 {
            C21381() {
            }
        }

        public abstract T mo5694a();

        protected static Object m26914a(T t) {
            return t == null ? f25338a : t;
        }

        protected static T m26915b(Object obj) {
            return obj == f25338a ? null : obj;
        }
    }

    public static class LazySoftVal<T> extends Val<T> {
        private final Function0<T> f32607a;
        private SoftReference<Object> f32608b;

        public LazySoftVal(T t, Function0<T> function0) {
            if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"}));
            }
            this.f32608b = null;
            this.f32607a = function0;
            if (t != null) {
                this.f32608b = new SoftReference(Val.m26914a(t));
            }
        }

        public final T mo5694a() {
            SoftReference softReference = this.f32608b;
            if (softReference != null) {
                Object obj = softReference.get();
                if (obj != null) {
                    return Val.m26915b(obj);
                }
            }
            T invoke = this.f32607a.invoke();
            this.f32608b = new SoftReference(Val.m26914a(invoke));
            return invoke;
        }
    }

    public static class LazyVal<T> extends Val<T> {
        private final Function0<T> f32609a;
        private Object f32610b;

        public LazyVal(Function0<T> function0) {
            if (function0 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"}));
            }
            this.f32610b = null;
            this.f32609a = function0;
        }

        public final T mo5694a() {
            Object obj = this.f32610b;
            if (obj != null) {
                return Val.m26915b(obj);
            }
            T invoke = this.f32609a.invoke();
            this.f32610b = Val.m26914a(invoke);
            return invoke;
        }
    }

    public static <T> LazyVal<T> m26918a(Function0<T> function0) {
        return new LazyVal(function0);
    }

    public static <T> LazySoftVal<T> m26917a(T t, Function0<T> function0) {
        if (function0 != null) {
            return new LazySoftVal(t, function0);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"}));
    }

    public static <T> LazySoftVal<T> m26919b(Function0<T> function0) {
        if (function0 != null) {
            return m26917a(null, function0);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"}));
    }
}
