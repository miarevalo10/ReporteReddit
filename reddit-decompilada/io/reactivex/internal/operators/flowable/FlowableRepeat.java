package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37791a;

    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        final Subscriber<? super T> f35233a;
        final SubscriptionArbiter f35234b;
        final Publisher<? extends T> f35235c;
        long f35236d;
        long f35237e;

        RepeatSubscriber(Subscriber<? super T> subscriber, long j, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f35233a = subscriber;
            this.f35234b = subscriptionArbiter;
            this.f35235c = publisher;
            this.f35236d = j;
        }

        public final void mo5623a(Subscription subscription) {
            this.f35234b.m32772b(subscription);
        }

        public final void onNext(T t) {
            this.f35237e++;
            this.f35233a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f35233a.onError(th);
        }

        public final void onComplete() {
            long j = this.f35236d;
            if (j != Long.MAX_VALUE) {
                this.f35236d = j - 1;
            }
            if (j != 0) {
                m35793a();
            } else {
                this.f35233a.onComplete();
            }
        }

        final void m35793a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f35234b.f32452o) {
                    long j = this.f35237e;
                    if (j != 0) {
                        this.f35237e = 0;
                        this.f35234b.m32773c(j);
                    }
                    this.f35235c.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                    }
                }
            }
        }
    }

    public FlowableRepeat(Flowable<T> flowable, long j) {
        super(flowable);
        this.f37791a = j;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Object subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo5623a(subscriptionArbiter);
        long j = Long.MAX_VALUE;
        if (this.f37791a != Long.MAX_VALUE) {
            j = this.f37791a - 1;
        }
        new RepeatSubscriber(subscriber, j, subscriptionArbiter, this.source).m35793a();
    }
}
