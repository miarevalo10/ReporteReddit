package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastMaybe<T> extends Maybe<T> {
    final Publisher<T> f35103a;

    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> f35100a;
        Subscription f35101b;
        T f35102c;

        LastSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f35100a = maybeObserver;
        }

        public final void mo5626a() {
            this.f35101b.cancel();
            this.f35101b = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f35101b == SubscriptionHelper.f32454a;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35101b, subscription)) {
                this.f35101b = subscription;
                this.f35100a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.f35102c = t;
        }

        public final void onError(Throwable th) {
            this.f35101b = SubscriptionHelper.f32454a;
            this.f35102c = null;
            this.f35100a.onError(th);
        }

        public final void onComplete() {
            this.f35101b = SubscriptionHelper.f32454a;
            Object obj = this.f35102c;
            if (obj != null) {
                this.f35102c = null;
                this.f35100a.onSuccess(obj);
                return;
            }
            this.f35100a.onComplete();
        }
    }

    public FlowableLastMaybe(Publisher<T> publisher) {
        this.f35103a = publisher;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35103a.subscribe(new LastSubscriber(maybeObserver));
    }
}
