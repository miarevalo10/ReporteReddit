package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {
    final BooleanSupplier f37792a;

    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        final Subscriber<? super T> f35238a;
        final SubscriptionArbiter f35239b;
        final Publisher<? extends T> f35240c;
        final BooleanSupplier f35241d;
        long f35242e;

        RepeatSubscriber(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f35238a = subscriber;
            this.f35239b = subscriptionArbiter;
            this.f35240c = publisher;
            this.f35241d = booleanSupplier;
        }

        public final void mo5623a(Subscription subscription) {
            this.f35239b.m32772b(subscription);
        }

        public final void onNext(T t) {
            this.f35242e++;
            this.f35238a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f35238a.onError(th);
        }

        public final void onComplete() {
            try {
                if (this.f35241d.mo6617a()) {
                    this.f35238a.onComplete();
                } else {
                    m35795a();
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.f35238a.onError(th);
            }
        }

        final void m35795a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f35239b.f32452o) {
                    long j = this.f35242e;
                    if (j != 0) {
                        this.f35242e = 0;
                        this.f35239b.m32773c(j);
                    }
                    this.f35240c.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                    }
                }
            }
        }
    }

    public FlowableRepeatUntil(Flowable<T> flowable, BooleanSupplier booleanSupplier) {
        super(flowable);
        this.f37792a = booleanSupplier;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Object subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo5623a(subscriptionArbiter);
        new RepeatSubscriber(subscriber, this.f37792a, subscriptionArbiter, this.source).m35795a();
    }
}
