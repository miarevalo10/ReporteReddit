package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableLimit<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37753a;

    static final class LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35110a;
        long f35111b;
        Subscription f35112c;

        LimitSubscriber(Subscriber<? super T> subscriber, long j) {
            this.f35110a = subscriber;
            this.f35111b = j;
            lazySet(j);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35112c, subscription)) {
                if (this.f35111b == 0) {
                    subscription.cancel();
                    EmptySubscription.m38161a(this.f35110a);
                    return;
                }
                this.f35112c = subscription;
                this.f35110a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            long j = this.f35111b;
            if (j > 0) {
                j--;
                this.f35111b = j;
                this.f35110a.onNext(t);
                if (j == 0) {
                    this.f35112c.cancel();
                    this.f35110a.onComplete();
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35111b > 0) {
                this.f35111b = 0;
                this.f35110a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (this.f35111b > 0) {
                this.f35111b = 0;
                this.f35110a.onComplete();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                long j2;
                long j3;
                do {
                    j3 = get();
                    if (j3 != 0) {
                        j2 = j3 <= j ? j3 : j;
                    }
                } while (!compareAndSet(j3, j3 - j2));
                this.f35112c.request(j2);
            }
        }

        public final void cancel() {
            this.f35112c.cancel();
        }
    }

    public FlowableLimit(Flowable<T> flowable, long j) {
        super(flowable);
        this.f37753a = j;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new LimitSubscriber(subscriber, this.f37753a));
    }
}
