package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFromPublisher<T> extends Flowable<T> {
    final Publisher<? extends T> f35075a;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.f35075a = publisher;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f35075a.subscribe(subscriber);
    }
}
