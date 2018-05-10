package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37837a;

    static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        boolean f35389a;
        Subscription f35390b;
        final Subscriber<? super T> f35391c;
        final long f35392d;
        long f35393e;

        TakeSubscriber(Subscriber<? super T> subscriber, long j) {
            this.f35391c = subscriber;
            this.f35392d = j;
            this.f35393e = j;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35390b, subscription)) {
                this.f35390b = subscription;
                if (this.f35392d == 0) {
                    subscription.cancel();
                    this.f35389a = true;
                    EmptySubscription.m38161a(this.f35391c);
                    return;
                }
                this.f35391c.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f35389a) {
                long j = this.f35393e;
                this.f35393e = j - 1;
                if (j > 0) {
                    Object obj = this.f35393e == 0 ? 1 : null;
                    this.f35391c.onNext(t);
                    if (obj != null) {
                        this.f35390b.cancel();
                        onComplete();
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.f35389a) {
                this.f35389a = true;
                this.f35390b.cancel();
                this.f35391c.onError(th);
            }
        }

        public final void onComplete() {
            if (!this.f35389a) {
                this.f35389a = true;
                this.f35391c.onComplete();
            }
        }

        public final void request(long j) {
            if (!SubscriptionHelper.m32776a(j)) {
                return;
            }
            if (get() || !compareAndSet(false, true) || j < this.f35392d) {
                this.f35390b.request(j);
            } else {
                this.f35390b.request(Long.MAX_VALUE);
            }
        }

        public final void cancel() {
            this.f35390b.cancel();
        }
    }

    public FlowableTake(Flowable<T> flowable, long j) {
        super(flowable);
        this.f37837a = j;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new TakeSubscriber(subscriber, this.f37837a));
    }
}
