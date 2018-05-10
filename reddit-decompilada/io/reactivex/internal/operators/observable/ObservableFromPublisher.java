package io.reactivex.internal.operators.observable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class ObservableFromPublisher<T> extends Observable<T> {
    final Publisher<? extends T> f35680a;

    static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final Observer<? super T> f35678a;
        Subscription f35679b;

        PublisherSubscriber(Observer<? super T> observer) {
            this.f35678a = observer;
        }

        public final void onComplete() {
            this.f35678a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f35678a.onError(th);
        }

        public final void onNext(T t) {
            this.f35678a.onNext(t);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35679b, subscription)) {
                this.f35679b = subscription;
                this.f35678a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void mo5626a() {
            this.f35679b.cancel();
            this.f35679b = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f35679b == SubscriptionHelper.f32454a;
        }
    }

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.f35680a = publisher;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.f35680a.subscribe(new PublisherSubscriber(observer));
    }
}
