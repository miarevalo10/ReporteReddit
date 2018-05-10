package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableTakePublisher<T> extends Flowable<T> {
    final Publisher<T> f35413a;
    final long f35414b = 1;

    public FlowableTakePublisher(Publisher<T> publisher) {
        this.f35413a = publisher;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f35413a.subscribe(new TakeSubscriber(subscriber, this.f35414b));
    }
}
