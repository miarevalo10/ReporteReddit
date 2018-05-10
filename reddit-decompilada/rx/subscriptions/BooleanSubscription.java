package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;

public final class BooleanSubscription implements Subscription {
    static final Action0 f41835b = new C31421();
    final AtomicReference<Action0> f41836a;

    static class C31421 implements Action0 {
        public final void mo7898a() {
        }

        C31421() {
        }
    }

    public BooleanSubscription() {
        this.f41836a = new AtomicReference();
    }

    private BooleanSubscription(Action0 action0) {
        this.f41836a = new AtomicReference(action0);
    }

    public static BooleanSubscription m43944a(Action0 action0) {
        return new BooleanSubscription(action0);
    }

    public final boolean mo7894d() {
        return this.f41836a.get() == f41835b;
    }

    public final void mo7893c() {
        if (((Action0) this.f41836a.get()) != f41835b) {
            Action0 action0 = (Action0) this.f41836a.getAndSet(f41835b);
            if (action0 != null && action0 != f41835b) {
                action0.mo7898a();
            }
        }
    }
}
