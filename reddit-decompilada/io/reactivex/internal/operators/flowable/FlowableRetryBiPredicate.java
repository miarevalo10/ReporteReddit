package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryBiPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiPredicate<? super Integer, ? super Throwable> f37801a;

    static final class RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        final Subscriber<? super T> f35265a;
        final SubscriptionArbiter f35266b;
        final Publisher<? extends T> f35267c;
        final BiPredicate<? super Integer, ? super Throwable> f35268d;
        int f35269e;
        long f35270f;

        RetryBiSubscriber(Subscriber<? super T> subscriber, BiPredicate<? super Integer, ? super Throwable> biPredicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f35265a = subscriber;
            this.f35266b = subscriptionArbiter;
            this.f35267c = publisher;
            this.f35268d = biPredicate;
        }

        public final void mo5623a(Subscription subscription) {
            this.f35266b.m32772b(subscription);
        }

        public final void onNext(T t) {
            this.f35270f++;
            this.f35265a.onNext(t);
        }

        public final void onError(Throwable th) {
            try {
                BiPredicate biPredicate = this.f35268d;
                int i = this.f35269e + 1;
                this.f35269e = i;
                if (biPredicate.mo4928a(Integer.valueOf(i), th)) {
                    m35811a();
                } else {
                    this.f35265a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f35265a.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            this.f35265a.onComplete();
        }

        final void m35811a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f35266b.f32452o) {
                    long j = this.f35270f;
                    if (j != 0) {
                        this.f35270f = 0;
                        this.f35266b.m32773c(j);
                    }
                    this.f35267c.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                    }
                }
            }
        }
    }

    public FlowableRetryBiPredicate(Flowable<T> flowable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(flowable);
        this.f37801a = biPredicate;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Object subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo5623a(subscriptionArbiter);
        new RetryBiSubscriber(subscriber, this.f37801a, subscriptionArbiter, this.source).m35811a();
    }
}
