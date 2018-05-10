package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleFromPublisher<T> extends Single<T> {
    final Publisher<? extends T> f35824a;

    static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super T> f35819a;
        Subscription f35820b;
        T f35821c;
        boolean f35822d;
        volatile boolean f35823e;

        ToSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f35819a = singleObserver;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35820b, subscription)) {
                this.f35820b = subscription;
                this.f35819a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f35822d) {
                if (this.f35821c != null) {
                    this.f35820b.cancel();
                    this.f35822d = true;
                    this.f35821c = null;
                    this.f35819a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                    return;
                }
                this.f35821c = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f35822d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35822d = true;
            this.f35821c = null;
            this.f35819a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35822d) {
                this.f35822d = true;
                Object obj = this.f35821c;
                this.f35821c = null;
                if (obj == null) {
                    this.f35819a.onError(new NoSuchElementException("The source Publisher is empty"));
                } else {
                    this.f35819a.onSuccess(obj);
                }
            }
        }

        public final boolean mo5627b() {
            return this.f35823e;
        }

        public final void mo5626a() {
            this.f35823e = true;
            this.f35820b.cancel();
        }
    }

    public SingleFromPublisher(Publisher<? extends T> publisher) {
        this.f35824a = publisher;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35824a.subscribe(new ToSingleObserver(singleObserver));
    }
}
