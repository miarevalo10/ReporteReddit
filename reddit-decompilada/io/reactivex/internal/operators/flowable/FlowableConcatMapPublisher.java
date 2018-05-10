package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {
    final Publisher<T> f34930a;
    final Function<? super T, ? extends Publisher<? extends R>> f34931b;
    final int f34932c;
    final ErrorMode f34933d;

    public FlowableConcatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.f34930a = publisher;
        this.f34931b = function;
        this.f34932c = i;
        this.f34933d = errorMode;
    }

    protected final void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.m26613a(this.f34930a, subscriber, this.f34931b)) {
            this.f34930a.subscribe(FlowableConcatMap.m38086a(subscriber, this.f34931b, this.f34932c, this.f34933d));
        }
    }
}
