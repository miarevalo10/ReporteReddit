package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureError<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class BackpressureErrorSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35165a;
        Subscription f35166b;
        boolean f35167c;

        BackpressureErrorSubscriber(Subscriber<? super T> subscriber) {
            this.f35165a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35166b, subscription)) {
                this.f35166b = subscription;
                this.f35165a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f35167c) {
                if (get() != 0) {
                    this.f35165a.onNext(t);
                    BackpressureHelper.m26673c(this, 1);
                    return;
                }
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        public final void onError(Throwable th) {
            if (this.f35167c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35167c = true;
            this.f35165a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35167c) {
                this.f35167c = true;
                this.f35165a.onComplete();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a((AtomicLong) this, j);
            }
        }

        public final void cancel() {
            this.f35166b.cancel();
        }
    }

    public FlowableOnBackpressureError(Flowable<T> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new BackpressureErrorSubscriber(subscriber));
    }
}
