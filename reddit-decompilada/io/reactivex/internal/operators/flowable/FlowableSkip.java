package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37816a;

    static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35339a;
        long f35340b;
        Subscription f35341c;

        SkipSubscriber(Subscriber<? super T> subscriber, long j) {
            this.f35339a = subscriber;
            this.f35340b = j;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35341c, subscription)) {
                long j = this.f35340b;
                this.f35341c = subscription;
                this.f35339a.mo5623a(this);
                subscription.request(j);
            }
        }

        public final void onNext(T t) {
            if (this.f35340b != 0) {
                this.f35340b--;
            } else {
                this.f35339a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            this.f35339a.onError(th);
        }

        public final void onComplete() {
            this.f35339a.onComplete();
        }

        public final void request(long j) {
            this.f35341c.request(j);
        }

        public final void cancel() {
            this.f35341c.cancel();
        }
    }

    public FlowableSkip(Flowable<T> flowable, long j) {
        super(flowable);
        this.f37816a = j;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipSubscriber(subscriber, this.f37816a));
    }
}
