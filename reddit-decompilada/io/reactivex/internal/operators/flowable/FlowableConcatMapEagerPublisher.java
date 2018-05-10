package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {
    final Publisher<T> f34925a;
    final Function<? super T, ? extends Publisher<? extends R>> f34926b;
    final int f34927c;
    final int f34928d;
    final ErrorMode f34929e;

    public FlowableConcatMapEagerPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        this.f34925a = publisher;
        this.f34926b = function;
        this.f34927c = i;
        this.f34928d = i2;
        this.f34929e = errorMode;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        this.f34925a.subscribe(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.f34926b, this.f34927c, this.f34928d, this.f34929e));
    }
}
