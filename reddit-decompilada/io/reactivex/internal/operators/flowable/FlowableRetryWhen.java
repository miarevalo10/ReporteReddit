package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Throwable>, ? extends Publisher<?>> f37804a;

    static final class RetryWhenSubscriber<T> extends WhenSourceSubscriber<T, Throwable> {
        RetryWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Throwable> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        public final void onError(Throwable th) {
            m35798a((Object) th);
        }

        public final void onComplete() {
            this.c.cancel();
            this.a.onComplete();
        }
    }

    public FlowableRetryWhen(Flowable<T> flowable, Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f37804a = function;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Subscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor a = UnicastProcessor.m38166a(8).m36022a();
        try {
            Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f37804a.apply(a), "handler returned a null Publisher");
            Object whenReceiver = new WhenReceiver(this.source);
            Subscription retryWhenSubscriber = new RetryWhenSubscriber(serializedSubscriber, a, whenReceiver);
            whenReceiver.f35246d = retryWhenSubscriber;
            subscriber.mo5623a(retryWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(Integer.valueOf(null));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
