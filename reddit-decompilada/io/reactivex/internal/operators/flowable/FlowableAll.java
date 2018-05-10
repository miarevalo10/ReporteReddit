package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAll<T> extends AbstractFlowableWithUpstream<T, Boolean> {
    final Predicate<? super T> f37640a;

    static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        final Predicate<? super T> f40226a;
        Subscription f40227b;
        boolean f40228c;

        AllSubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f40226a = predicate;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40227b, subscription)) {
                this.f40227b = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f40228c) {
                try {
                    if (this.f40226a.test(t) == null) {
                        this.f40228c = true;
                        this.f40227b.cancel();
                        m39789a((Object) Boolean.valueOf(null));
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f40227b.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f40228c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f40228c = true;
            this.h.onError(th);
        }

        public final void onComplete() {
            if (!this.f40228c) {
                this.f40228c = true;
                m39789a((Object) Boolean.valueOf(true));
            }
        }

        public final void cancel() {
            super.cancel();
            this.f40227b.cancel();
        }
    }

    public FlowableAll(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f37640a = predicate;
    }

    protected final void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.source.subscribe(new AllSubscriber(subscriber, this.f37640a));
    }
}
