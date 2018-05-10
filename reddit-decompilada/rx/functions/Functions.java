package rx.functions;

public final class Functions {
    public static <T0, T1, R> FuncN<R> m43443a(final Func2<? super T0, ? super T1, ? extends R> func2) {
        return new FuncN<R>() {
            public final R mo7900a(Object... objArr) {
                if (objArr.length == 2) {
                    return func2.mo7907a(objArr[0], objArr[1]);
                }
                throw new IllegalArgumentException("Func2 expecting 2 arguments.");
            }
        };
    }
}
