package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableHide<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class HideSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35084a;
        Subscription f35085b;

        HideSubscriber(Subscriber<? super T> subscriber) {
            this.f35084a = subscriber;
        }

        public final void request(long j) {
            this.f35085b.request(j);
        }

        public final void cancel() {
            this.f35085b.cancel();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35085b, subscription)) {
                this.f35085b = subscription;
                this.f35084a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            this.f35084a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f35084a.onError(th);
        }

        public final void onComplete() {
            this.f35084a.onComplete();
        }
    }

    public FlowableHide(Flowable<T> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new HideSubscriber(subscriber));
    }
}
