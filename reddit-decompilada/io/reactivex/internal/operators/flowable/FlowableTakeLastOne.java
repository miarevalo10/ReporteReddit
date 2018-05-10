package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastOne<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        Subscription f40267a;

        TakeLastOneSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40267a, subscription)) {
                this.f40267a = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.i = t;
        }

        public final void onError(Throwable th) {
            this.i = null;
            this.h.onError(th);
        }

        public final void onComplete() {
            Object obj = this.i;
            if (obj != null) {
                m39789a(obj);
            } else {
                this.h.onComplete();
            }
        }

        public final void cancel() {
            super.cancel();
            this.f40267a.cancel();
        }
    }

    public FlowableTakeLastOne(Flowable<T> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeLastOneSubscriber(subscriber));
    }
}
