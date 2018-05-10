package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, QueueSubscription<T> {
        final Subscriber<? super T> f37746a;
        Subscription f37747b;

        public final int mo7033a(int i) {
            return i & 2;
        }

        public final void clear() {
        }

        public final boolean isEmpty() {
            return true;
        }

        public final void onNext(T t) {
        }

        public final T poll() {
            return null;
        }

        public final void request(long j) {
        }

        IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
            this.f37746a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f37747b, subscription)) {
                this.f37747b = subscription;
                this.f37746a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onError(Throwable th) {
            this.f37746a.onError(th);
        }

        public final void onComplete() {
            this.f37746a.onComplete();
        }

        public final boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public final void cancel() {
            this.f37747b.cancel();
        }
    }

    public FlowableIgnoreElements(Flowable<T> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new IgnoreElementsSubscriber(subscriber));
    }
}
