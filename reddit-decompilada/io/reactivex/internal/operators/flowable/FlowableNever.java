package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

public final class FlowableNever extends Flowable<Object> {
    public static final Flowable<Object> f35150a = new FlowableNever();

    private FlowableNever() {
    }

    public final void subscribeActual(Subscriber<? super Object> subscriber) {
        subscriber.mo5623a(EmptySubscription.f38145a);
    }
}
