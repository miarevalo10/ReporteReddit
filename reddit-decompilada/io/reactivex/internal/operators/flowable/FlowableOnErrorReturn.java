package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableOnErrorReturn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> f37778a;

    static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        final Function<? super Throwable, ? extends T> f37777a;

        OnErrorReturnSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends T> function) {
            super(subscriber);
            this.f37777a = function;
        }

        public final void onNext(T t) {
            this.g++;
            this.d.onNext(t);
        }

        public final void onError(Throwable th) {
            try {
                m36008b(ObjectHelper.m26573a(this.f37777a.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.d.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            this.d.onComplete();
        }
    }

    public FlowableOnErrorReturn(Flowable<T> flowable, Function<? super Throwable, ? extends T> function) {
        super(flowable);
        this.f37778a = function;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new OnErrorReturnSubscriber(subscriber, this.f37778a));
    }
}
