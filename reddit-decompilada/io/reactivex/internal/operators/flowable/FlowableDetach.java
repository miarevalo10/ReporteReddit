package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscriber<? super T> f34977a;
        Subscription f34978b;

        DetachSubscriber(Subscriber<? super T> subscriber) {
            this.f34977a = subscriber;
        }

        public final void request(long j) {
            this.f34978b.request(j);
        }

        public final void cancel() {
            Subscription subscription = this.f34978b;
            this.f34978b = EmptyComponent.f35937a;
            this.f34977a = EmptyComponent.m36013c();
            subscription.cancel();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34978b, subscription)) {
                this.f34978b = subscription;
                this.f34977a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            this.f34977a.onNext(t);
        }

        public final void onError(Throwable th) {
            Subscriber subscriber = this.f34977a;
            this.f34978b = EmptyComponent.f35937a;
            this.f34977a = EmptyComponent.m36013c();
            subscriber.onError(th);
        }

        public final void onComplete() {
            Subscriber subscriber = this.f34977a;
            this.f34978b = EmptyComponent.f35937a;
            this.f34977a = EmptyComponent.m36013c();
            subscriber.onComplete();
        }
    }

    public FlowableDetach(Flowable<T> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DetachSubscriber(subscriber));
    }
}
