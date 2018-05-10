package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> f37786a;

    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        final BiFunction<T, T, T> f40255a;
        Subscription f40256b;

        ReduceSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.f40255a = biFunction;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40256b, subscription)) {
                this.f40256b = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (this.f40256b != SubscriptionHelper.f32454a) {
                Object obj = this.i;
                if (obj == null) {
                    this.i = t;
                    return;
                }
                try {
                    this.i = ObjectHelper.m26573a(this.f40255a.apply(obj, t), "The reducer returned a null value");
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f40256b.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f40256b == SubscriptionHelper.f32454a) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f40256b = SubscriptionHelper.f32454a;
            this.h.onError(th);
        }

        public final void onComplete() {
            if (this.f40256b != SubscriptionHelper.f32454a) {
                this.f40256b = SubscriptionHelper.f32454a;
                Object obj = this.i;
                if (obj != null) {
                    m39789a(obj);
                } else {
                    this.h.onComplete();
                }
            }
        }

        public final void cancel() {
            super.cancel();
            this.f40256b.cancel();
            this.f40256b = SubscriptionHelper.f32454a;
        }
    }

    public FlowableReduce(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f37786a = biFunction;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ReduceSubscriber(subscriber, this.f37786a));
    }
}
