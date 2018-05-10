package rx.subscriptions;

import rx.Subscription;
import rx.internal.subscriptions.SequentialSubscription;

public final class SerialSubscription implements Subscription {
    public final SequentialSubscription f41839a = new SequentialSubscription();

    public final boolean mo7894d() {
        return this.f41839a.mo7894d();
    }

    public final void mo7893c() {
        this.f41839a.mo7893c();
    }

    public final void m43952a(Subscription subscription) {
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.f41839a.m43876a(subscription);
    }
}
