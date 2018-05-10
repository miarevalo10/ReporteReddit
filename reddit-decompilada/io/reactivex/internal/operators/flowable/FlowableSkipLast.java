package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int f37817a;

    static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35342a;
        final int f35343b;
        Subscription f35344c;

        SkipLastSubscriber(Subscriber<? super T> subscriber, int i) {
            super(i);
            this.f35342a = subscriber;
            this.f35343b = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35344c, subscription)) {
                this.f35344c = subscription;
                this.f35342a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (this.f35343b == size()) {
                this.f35342a.onNext(poll());
            } else {
                this.f35344c.request(1);
            }
            offer(t);
        }

        public final void onError(Throwable th) {
            this.f35342a.onError(th);
        }

        public final void onComplete() {
            this.f35342a.onComplete();
        }

        public final void request(long j) {
            this.f35344c.request(j);
        }

        public final void cancel() {
            this.f35344c.cancel();
        }
    }

    public FlowableSkipLast(Flowable<T> flowable, int i) {
        super(flowable);
        this.f37817a = i;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipLastSubscriber(subscriber, this.f37817a));
    }
}
