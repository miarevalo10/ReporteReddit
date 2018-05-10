package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37717a;
    final T f37718b;
    final boolean f37719c;

    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        final long f40238a;
        final T f40239b;
        final boolean f40240c;
        Subscription f40241d;
        long f40242e;
        boolean f40243f;

        ElementAtSubscriber(Subscriber<? super T> subscriber, long j, T t, boolean z) {
            super(subscriber);
            this.f40238a = j;
            this.f40239b = t;
            this.f40240c = z;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40241d, subscription)) {
                this.f40241d = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f40243f) {
                long j = this.f40242e;
                if (j == this.f40238a) {
                    this.f40243f = true;
                    this.f40241d.cancel();
                    m39789a((Object) t);
                    return;
                }
                this.f40242e = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f40243f) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f40243f = true;
            this.h.onError(th);
        }

        public final void onComplete() {
            if (!this.f40243f) {
                this.f40243f = true;
                Object obj = this.f40239b;
                if (obj != null) {
                    m39789a(obj);
                } else if (this.f40240c) {
                    this.h.onError(new NoSuchElementException());
                } else {
                    this.h.onComplete();
                }
            }
        }

        public final void cancel() {
            super.cancel();
            this.f40241d.cancel();
        }
    }

    public FlowableElementAt(Flowable<T> flowable, long j, T t, boolean z) {
        super(flowable);
        this.f37717a = j;
        this.f37718b = t;
        this.f37719c = z;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ElementAtSubscriber(subscriber, this.f37717a, this.f37718b, this.f37719c));
    }
}
