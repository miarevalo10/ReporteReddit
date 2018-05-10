package rx.internal.util;

import rx.functions.Func1;

public final class UtilityFunctions {

    static class C31271 implements Func1<T, T> {
        public final T call(T t) {
            return t;
        }

        C31271() {
        }
    }

    enum AlwaysTrue implements Func1<Object, Boolean> {
        ;

        private AlwaysTrue(String str) {
        }
    }

    public static <T> Func1<? super T, Boolean> m43473a() {
        return AlwaysTrue.f41804a;
    }

    public static <T> Func1<T, T> m43474b() {
        return new C31271();
    }
}
