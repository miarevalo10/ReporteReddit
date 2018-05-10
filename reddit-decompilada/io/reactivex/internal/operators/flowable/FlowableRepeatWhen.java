package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Object>, ? extends Publisher<?>> f37793a;

    static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        final Publisher<T> f35243a;
        final AtomicReference<Subscription> f35244b = new AtomicReference();
        final AtomicLong f35245c = new AtomicLong();
        WhenSourceSubscriber<T, U> f35246d;

        WhenReceiver(Publisher<T> publisher) {
            this.f35243a = publisher;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a(this.f35244b, this.f35245c, subscription);
        }

        public final void onNext(Object obj) {
            if (getAndIncrement() == null) {
                while (SubscriptionHelper.m32780a((Subscription) this.f35244b.get()) == null) {
                    this.f35243a.subscribe(this.f35246d);
                    if (decrementAndGet() == null) {
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            this.f35246d.cancel();
            this.f35246d.f35247a.onError(th);
        }

        public final void onComplete() {
            this.f35246d.cancel();
            this.f35246d.f35247a.onComplete();
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a(this.f35244b, this.f35245c, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f35244b);
        }
    }

    static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        protected final Subscriber<? super T> f35247a;
        protected final FlowableProcessor<U> f35248b;
        protected final Subscription f35249c;
        private long f35250d;

        WhenSourceSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<U> flowableProcessor, Subscription subscription) {
            this.f35247a = subscriber;
            this.f35248b = flowableProcessor;
            this.f35249c = subscription;
        }

        public final void mo5623a(Subscription subscription) {
            m32772b(subscription);
        }

        public final void onNext(T t) {
            this.f35250d++;
            this.f35247a.onNext(t);
        }

        protected final void m35798a(U u) {
            long j = this.f35250d;
            if (j != 0) {
                this.f35250d = 0;
                m32773c(j);
            }
            this.f35249c.request(1);
            this.f35248b.onNext(u);
        }

        public final void cancel() {
            super.cancel();
            this.f35249c.cancel();
        }
    }

    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        RepeatWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Object> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        public final void onError(Throwable th) {
            this.c.cancel();
            this.a.onError(th);
        }

        public final void onComplete() {
            m35798a((Object) Integer.valueOf(0));
        }
    }

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f37793a = function;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Subscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor a = UnicastProcessor.m38166a(8).m36022a();
        try {
            Publisher publisher = (Publisher) ObjectHelper.m26573a(this.f37793a.apply(a), "handler returned a null Publisher");
            Object whenReceiver = new WhenReceiver(this.source);
            Subscription repeatWhenSubscriber = new RepeatWhenSubscriber(serializedSubscriber, a, whenReceiver);
            whenReceiver.f35246d = repeatWhenSubscriber;
            subscriber.mo5623a(repeatWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(Integer.valueOf(null));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptySubscription.m38160a(th, subscriber);
        }
    }
}
