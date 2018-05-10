package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableFromPublisher<T> extends Completable {
    final Publisher<T> f34742a;

    static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final CompletableObserver f34740a;
        Subscription f34741b;

        public final void onNext(T t) {
        }

        FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.f34740a = completableObserver;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34741b, subscription)) {
                this.f34741b = subscription;
                this.f34740a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onError(Throwable th) {
            this.f34740a.onError(th);
        }

        public final void onComplete() {
            this.f34740a.onComplete();
        }

        public final void mo5626a() {
            this.f34741b.cancel();
            this.f34741b = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f34741b == SubscriptionHelper.f32454a;
        }
    }

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.f34742a = publisher;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34742a.subscribe(new FromPublisherSubscriber(completableObserver));
    }
}
