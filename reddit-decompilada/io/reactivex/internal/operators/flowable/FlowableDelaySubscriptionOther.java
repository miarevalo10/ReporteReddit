package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {
    final Publisher<? extends T> f34972a;
    final Publisher<U> f34973b;

    final class DelaySubscriber implements FlowableSubscriber<U> {
        final SubscriptionArbiter f34968a;
        final Subscriber<? super T> f34969b;
        boolean f34970c;
        final /* synthetic */ FlowableDelaySubscriptionOther f34971d;

        final class DelaySubscription implements Subscription {
            final /* synthetic */ DelaySubscriber f31259a;
            private final Subscription f31260b;

            public final void request(long j) {
            }

            DelaySubscription(DelaySubscriber delaySubscriber, Subscription subscription) {
                this.f31259a = delaySubscriber;
                this.f31260b = subscription;
            }

            public final void cancel() {
                this.f31260b.cancel();
            }
        }

        final class OnCompleteSubscriber implements FlowableSubscriber<T> {
            final /* synthetic */ DelaySubscriber f34967a;

            OnCompleteSubscriber(DelaySubscriber delaySubscriber) {
                this.f34967a = delaySubscriber;
            }

            public final void mo5623a(Subscription subscription) {
                this.f34967a.f34968a.m32772b(subscription);
            }

            public final void onNext(T t) {
                this.f34967a.f34969b.onNext(t);
            }

            public final void onError(Throwable th) {
                this.f34967a.f34969b.onError(th);
            }

            public final void onComplete() {
                this.f34967a.f34969b.onComplete();
            }
        }

        DelaySubscriber(FlowableDelaySubscriptionOther flowableDelaySubscriptionOther, SubscriptionArbiter subscriptionArbiter, Subscriber<? super T> subscriber) {
            this.f34971d = flowableDelaySubscriptionOther;
            this.f34968a = subscriptionArbiter;
            this.f34969b = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            this.f34968a.m32772b(new DelaySubscription(this, subscription));
            subscription.request(Long.MAX_VALUE);
        }

        public final void onNext(U u) {
            onComplete();
        }

        public final void onError(Throwable th) {
            if (this.f34970c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34970c = true;
            this.f34969b.onError(th);
        }

        public final void onComplete() {
            if (!this.f34970c) {
                this.f34970c = true;
                this.f34971d.f34972a.subscribe(new OnCompleteSubscriber(this));
            }
        }
    }

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        this.f34972a = publisher;
        this.f34973b = publisher2;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Object subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo5623a(subscriptionArbiter);
        this.f34973b.subscribe(new DelaySubscriber(this, subscriptionArbiter, subscriber));
    }
}
