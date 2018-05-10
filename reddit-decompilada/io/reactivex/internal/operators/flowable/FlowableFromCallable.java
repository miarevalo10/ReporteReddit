package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableFromCallable<T> extends Flowable<T> implements Callable<T> {
    final Callable<? extends T> f35069a;

    public FlowableFromCallable(Callable<? extends T> callable) {
        this.f35069a = callable;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Object deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.mo5623a(deferredScalarSubscription);
        try {
            deferredScalarSubscription.m39789a(ObjectHelper.m26573a(this.f35069a.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            subscriber.onError(th);
        }
    }

    public final T call() throws Exception {
        return ObjectHelper.m26573a(this.f35069a.call(), "The callable returned a null value");
    }
}
