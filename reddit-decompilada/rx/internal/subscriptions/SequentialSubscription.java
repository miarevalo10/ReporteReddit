package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class SequentialSubscription extends AtomicReference<Subscription> implements Subscription {
    public final boolean m43876a(Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = (Subscription) get();
            if (subscription2 == Unsubscribed.f41767a) {
                if (subscription != null) {
                    subscription.mo7893c();
                }
                return null;
            }
        } while (!compareAndSet(subscription2, subscription));
        if (subscription2 != null) {
            subscription2.mo7893c();
        }
        return true;
    }

    public final void mo7893c() {
        if (((Subscription) get()) != Unsubscribed.f41767a) {
            Subscription subscription = (Subscription) getAndSet(Unsubscribed.f41767a);
            if (subscription != null && subscription != Unsubscribed.f41767a) {
                subscription.mo7893c();
            }
        }
    }

    public final boolean mo7894d() {
        return get() == Unsubscribed.f41767a;
    }
}
