package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;

public final class FlowableJust<T> extends Flowable<T> implements ScalarCallable<T> {
    private final T f35099a;

    public FlowableJust(T t) {
        this.f35099a = t;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.mo5623a(new ScalarSubscription(subscriber, this.f35099a));
    }

    public final T call() {
        return this.f35099a;
    }
}
