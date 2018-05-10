package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableError<T> extends Flowable<T> {
    final Callable<? extends Throwable> f35001a;

    public FlowableError(Callable<? extends Throwable> callable) {
        this.f35001a = callable;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable th;
        try {
            th = (Throwable) ObjectHelper.m26573a(this.f35001a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.m26521b(th);
        }
        EmptySubscription.m38160a(th, subscriber);
    }
}
