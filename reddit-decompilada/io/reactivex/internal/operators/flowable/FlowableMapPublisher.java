package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableMapPublisher<T, U> extends Flowable<U> {
    final Publisher<T> f35113a;
    final Function<? super T, ? extends U> f35114b;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.f35113a = publisher;
        this.f35114b = function;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        this.f35113a.subscribe(new MapSubscriber(subscriber, this.f35114b));
    }
}
