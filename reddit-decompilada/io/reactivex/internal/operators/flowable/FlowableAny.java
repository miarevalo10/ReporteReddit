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

public final class FlowableAny<T> extends AbstractFlowableWithUpstream<T, Boolean> {
    final Predicate<? super T> f37641a;

    static final class AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        final Predicate<? super T> f40229a;
        Subscription f40230b;
        boolean f40231c;

        AnySubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f40229a = predicate;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f40230b, subscription)) {
                this.f40230b = subscription;
                this.h.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f40231c) {
                try {
                    if (this.f40229a.test(t) != null) {
                        this.f40231c = true;
                        this.f40230b.cancel();
                        m39789a((Object) Boolean.valueOf(true));
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f40230b.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f40231c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f40231c = true;
            this.h.onError(th);
        }

        public final void onComplete() {
            if (!this.f40231c) {
                this.f40231c = true;
                m39789a((Object) Boolean.valueOf(false));
            }
        }

        public final void cancel() {
            super.cancel();
            this.f40230b.cancel();
        }
    }

    public FlowableAny(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f37641a = predicate;
    }

    protected final void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.source.subscribe(new AnySubscriber(subscriber, this.f37641a));
    }
}
