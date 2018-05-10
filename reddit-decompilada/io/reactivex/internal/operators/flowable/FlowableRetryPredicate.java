package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super Throwable> f37802a;
    final long f37803b;

    static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        final Subscriber<? super T> f35271a;
        final SubscriptionArbiter f35272b;
        final Publisher<? extends T> f35273c;
        final Predicate<? super Throwable> f35274d;
        long f35275e;
        long f35276f;

        RetrySubscriber(Subscriber<? super T> subscriber, long j, Predicate<? super Throwable> predicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f35271a = subscriber;
            this.f35272b = subscriptionArbiter;
            this.f35273c = publisher;
            this.f35274d = predicate;
            this.f35275e = j;
        }

        public final void mo5623a(Subscription subscription) {
            this.f35272b.m32772b(subscription);
        }

        public final void onNext(T t) {
            this.f35276f++;
            this.f35271a.onNext(t);
        }

        public final void onError(Throwable th) {
            long j = this.f35275e;
            if (j != Long.MAX_VALUE) {
                this.f35275e = j - 1;
            }
            if (j == 0) {
                this.f35271a.onError(th);
                return;
            }
            try {
                if (this.f35274d.test(th)) {
                    m35813a();
                } else {
                    this.f35271a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f35271a.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            this.f35271a.onComplete();
        }

        final void m35813a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f35272b.f32452o) {
                    long j = this.f35276f;
                    if (j != 0) {
                        this.f35276f = 0;
                        this.f35272b.m32773c(j);
                    }
                    this.f35273c.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                    }
                }
            }
        }
    }

    public FlowableRetryPredicate(Flowable<T> flowable, long j, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.f37802a = predicate;
        this.f37803b = j;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Object subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo5623a(subscriptionArbiter);
        new RetrySubscriber(subscriber, this.f37803b, this.f37802a, subscriptionArbiter, this.source).m35813a();
    }
}
