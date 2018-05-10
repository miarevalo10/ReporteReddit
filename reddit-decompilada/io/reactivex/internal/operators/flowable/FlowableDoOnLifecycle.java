package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
    private final Consumer<? super Subscription> f37714a;
    private final LongConsumer f37715b;
    private final Action f37716c;

    static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f34979a;
        final Consumer<? super Subscription> f34980b;
        final LongConsumer f34981c;
        final Action f34982d;
        Subscription f34983e;

        SubscriptionLambdaSubscriber(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
            this.f34979a = subscriber;
            this.f34980b = consumer;
            this.f34982d = action;
            this.f34981c = longConsumer;
        }

        public final void mo5623a(Subscription subscription) {
            try {
                this.f34980b.accept(subscription);
                if (SubscriptionHelper.m32781a(this.f34983e, subscription)) {
                    this.f34983e = subscription;
                    this.f34979a.mo5623a(this);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                subscription.cancel();
                this.f34983e = SubscriptionHelper.f32454a;
                EmptySubscription.m38160a(th, this.f34979a);
            }
        }

        public final void onNext(T t) {
            this.f34979a.onNext(t);
        }

        public final void onError(Throwable th) {
            if (this.f34983e != SubscriptionHelper.f32454a) {
                this.f34979a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            if (this.f34983e != SubscriptionHelper.f32454a) {
                this.f34979a.onComplete();
            }
        }

        public final void request(long j) {
            this.f34983e.request(j);
        }

        public final void cancel() {
            try {
                this.f34982d.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
            this.f34983e.cancel();
        }
    }

    public FlowableDoOnLifecycle(Flowable<T> flowable, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        super(flowable);
        this.f37714a = consumer;
        this.f37715b = longConsumer;
        this.f37716c = action;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SubscriptionLambdaSubscriber(subscriber, this.f37714a, this.f37715b, this.f37716c));
    }
}
