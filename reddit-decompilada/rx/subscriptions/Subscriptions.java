package rx.subscriptions;

import rx.Subscription;
import rx.functions.Action0;

public final class Subscriptions {
    private static final Unsubscribed f41420a = new Unsubscribed();

    static final class Unsubscribed implements Subscription {
        public final void mo7893c() {
        }

        public final boolean mo7894d() {
            return true;
        }

        Unsubscribed() {
        }
    }

    public static Subscription m43536a() {
        return f41420a;
    }

    public static Subscription m43537a(Action0 action0) {
        return BooleanSubscription.m43944a(action0);
    }
}
