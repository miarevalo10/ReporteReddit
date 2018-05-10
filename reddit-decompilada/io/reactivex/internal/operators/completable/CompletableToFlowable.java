package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import org.reactivestreams.Subscriber;

public final class CompletableToFlowable<T> extends Flowable<T> {
    final CompletableSource f34786a;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.f34786a = completableSource;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f34786a.subscribe(new SubscriberCompletableObserver(subscriber));
    }
}
