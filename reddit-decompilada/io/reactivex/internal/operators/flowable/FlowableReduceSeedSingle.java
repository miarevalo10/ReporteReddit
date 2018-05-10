package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceSeedSingle<T, R> extends Single<R> {
    final Publisher<T> f35222a;
    final R f35223b;
    final BiFunction<R, ? super T, R> f35224c;

    static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super R> f35218a;
        final BiFunction<R, ? super T, R> f35219b;
        R f35220c;
        Subscription f35221d;

        ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.f35218a = singleObserver;
            this.f35220c = r;
            this.f35219b = biFunction;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35221d, subscription)) {
                this.f35221d = subscription;
                this.f35218a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            try {
                this.f35220c = ObjectHelper.m26573a(this.f35219b.apply(this.f35220c, t), "The reducer returned a null value");
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f35221d.cancel();
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f35220c = null;
            this.f35221d = SubscriptionHelper.f32454a;
            this.f35218a.onError(th);
        }

        public final void onComplete() {
            Object obj = this.f35220c;
            this.f35220c = null;
            this.f35221d = SubscriptionHelper.f32454a;
            this.f35218a.onSuccess(obj);
        }

        public final void mo5626a() {
            this.f35221d.cancel();
            this.f35221d = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f35221d == SubscriptionHelper.f32454a;
        }
    }

    public FlowableReduceSeedSingle(Publisher<T> publisher, R r, BiFunction<R, ? super T, R> biFunction) {
        this.f35222a = publisher;
        this.f35223b = r;
        this.f35224c = biFunction;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f35222a.subscribe(new ReduceSeedObserver(singleObserver, this.f35224c, this.f35223b));
    }
}
