package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastSingle<T> extends Single<T> {
    final Publisher<T> f35108a;
    final T f35109b;

    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super T> f35104a;
        final T f35105b;
        Subscription f35106c;
        T f35107d;

        LastSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.f35104a = singleObserver;
            this.f35105b = t;
        }

        public final void mo5626a() {
            this.f35106c.cancel();
            this.f35106c = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f35106c == SubscriptionHelper.f32454a;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35106c, subscription)) {
                this.f35106c = subscription;
                this.f35104a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.f35107d = t;
        }

        public final void onError(Throwable th) {
            this.f35106c = SubscriptionHelper.f32454a;
            this.f35107d = null;
            this.f35104a.onError(th);
        }

        public final void onComplete() {
            this.f35106c = SubscriptionHelper.f32454a;
            Object obj = this.f35107d;
            if (obj != null) {
                this.f35107d = null;
                this.f35104a.onSuccess(obj);
                return;
            }
            obj = this.f35105b;
            if (obj != null) {
                this.f35104a.onSuccess(obj);
            } else {
                this.f35104a.onError(new NoSuchElementException());
            }
        }
    }

    public FlowableLastSingle(Publisher<T> publisher, T t) {
        this.f35108a = publisher;
        this.f35109b = t;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35108a.subscribe(new LastSubscriber(singleObserver, this.f35109b));
    }
}
