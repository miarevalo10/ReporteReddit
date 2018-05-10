package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final T f37815a;

    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        final T f40264a;
        Subscription f40265b;
        boolean f40266c;

        SingleElementSubscriber(Subscriber<? super T> subscriber, T t) {
            super(subscriber);
            this.f40264a = t;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40265b, subscription)) {
                this.f40265b = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f40266c) {
                if (this.i != null) {
                    this.f40266c = true;
                    this.f40265b.cancel();
                    this.h.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.i = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f40266c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f40266c = true;
            this.h.onError(th);
        }

        public final void onComplete() {
            if (!this.f40266c) {
                this.f40266c = true;
                Object obj = this.i;
                this.i = null;
                if (obj == null) {
                    obj = this.f40264a;
                }
                if (obj == null) {
                    this.h.onComplete();
                } else {
                    m39789a(obj);
                }
            }
        }

        public final void cancel() {
            super.cancel();
            this.f40265b.cancel();
        }
    }

    public FlowableSingle(Flowable<T> flowable, T t) {
        super(flowable);
        this.f37815a = t;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SingleElementSubscriber(subscriber, this.f37815a));
    }
}
