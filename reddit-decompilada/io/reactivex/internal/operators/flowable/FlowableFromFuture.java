package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableFromFuture<T> extends Flowable<T> {
    final Future<? extends T> f35070a;
    final long f35071b;
    final TimeUnit f35072c;

    public FlowableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f35070a = future;
        this.f35071b = j;
        this.f35072c = timeUnit;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.mo5623a(deferredScalarSubscription);
        try {
            Object obj = this.f35072c != null ? this.f35070a.get(this.f35071b, this.f35072c) : this.f35070a.get();
            if (obj == null) {
                subscriber.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.m39789a(obj);
            }
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            if (!deferredScalarSubscription.m39790b()) {
                subscriber.onError(th);
            }
        }
    }
}
