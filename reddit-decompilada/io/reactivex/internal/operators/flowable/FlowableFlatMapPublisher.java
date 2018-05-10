package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {
    final Publisher<T> f35052a;
    final Function<? super T, ? extends Publisher<? extends U>> f35053b;
    final boolean f35054c;
    final int f35055d;
    final int f35056e;

    public FlowableFlatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        this.f35052a = publisher;
        this.f35053b = function;
        this.f35054c = z;
        this.f35055d = i;
        this.f35056e = i2;
    }

    protected final void subscribeActual(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.m26613a(this.f35052a, subscriber, this.f35053b)) {
            this.f35052a.subscribe(FlowableFlatMap.m38101a(subscriber, this.f35053b, this.f35054c, this.f35055d, this.f35056e));
        }
    }
}
