package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> f37833a;

    static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> f35367a;
        final Publisher<? extends T> f35368b;
        final SubscriptionArbiter f35369c = new SubscriptionArbiter();
        boolean f35370d = true;

        SwitchIfEmptySubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.f35367a = subscriber;
            this.f35368b = publisher;
        }

        public final void mo5623a(Subscription subscription) {
            this.f35369c.m32772b(subscription);
        }

        public final void onNext(T t) {
            if (this.f35370d) {
                this.f35370d = false;
            }
            this.f35367a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f35367a.onError(th);
        }

        public final void onComplete() {
            if (this.f35370d) {
                this.f35370d = false;
                this.f35368b.subscribe(this);
                return;
            }
            this.f35367a.onComplete();
        }
    }

    public FlowableSwitchIfEmpty(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.f37833a = publisher;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableSubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(subscriber, this.f37833a);
        subscriber.mo5623a(switchIfEmptySubscriber.f35369c);
        this.source.subscribe(switchIfEmptySubscriber);
    }
}
