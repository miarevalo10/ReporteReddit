package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCount<T> extends AbstractFlowableWithUpstream<T, Long> {

    static final class CountSubscriber extends DeferredScalarSubscription<Long> implements FlowableSubscriber<Object> {
        Subscription f40236a;
        long f40237b;

        CountSubscriber(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40236a, subscription)) {
                this.f40236a = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            this.f40237b++;
        }

        public final void onError(Throwable th) {
            this.h.onError(th);
        }

        public final void onComplete() {
            m39789a((Object) Long.valueOf(this.f40237b));
        }

        public final void cancel() {
            super.cancel();
            this.f40236a.cancel();
        }
    }

    public FlowableCount(Flowable<T> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super Long> subscriber) {
        this.source.subscribe(new CountSubscriber(subscriber));
    }
}
