package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final AtomicReference<Subscription> f35958f = new AtomicReference();

    public final void mo5623a(Subscription subscription) {
        if (EndConsumerHelper.m26680a(this.f35958f, subscription, getClass()) != null) {
            ((Subscription) this.f35958f.get()).request(Long.MAX_VALUE);
        }
    }

    protected final void m36032d() {
        mo5626a();
    }

    public final boolean mo5627b() {
        return this.f35958f.get() == SubscriptionHelper.f32454a;
    }

    public final void mo5626a() {
        SubscriptionHelper.m32777a(this.f35958f);
    }
}
