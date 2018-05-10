package rx.observers;

import rx.Observer;
import rx.exceptions.OnErrorNotImplementedException;

public final class Observers {
    private static final Observer<Object> f41385a = new C31281();

    static class C31281 implements Observer<Object> {
        public final void a_(Object obj) {
        }

        public final void mo7906b() {
        }

        C31281() {
        }

        public final void mo7904a(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    public static <T> Observer<T> m43485a() {
        return f41385a;
    }
}
