package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    private Subscription f35957a;

    public final void mo5623a(Subscription subscription) {
        if (EndConsumerHelper.m26681a(this.f35957a, subscription, getClass())) {
            this.f35957a = subscription;
            subscription = this.f35957a;
            if (subscription != null) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }
}
