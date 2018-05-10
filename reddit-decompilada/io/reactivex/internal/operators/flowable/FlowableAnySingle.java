package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableAnySingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Flowable<T> f34820a;
    final Predicate<? super T> f34821b;

    static final class AnySubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super Boolean> f34816a;
        final Predicate<? super T> f34817b;
        Subscription f34818c;
        boolean f34819d;

        AnySubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f34816a = singleObserver;
            this.f34817b = predicate;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34818c, subscription)) {
                this.f34818c = subscription;
                this.f34816a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f34819d) {
                try {
                    if (this.f34817b.test(t) != null) {
                        this.f34819d = true;
                        this.f34818c.cancel();
                        this.f34818c = SubscriptionHelper.f32454a;
                        this.f34816a.onSuccess(Boolean.valueOf(true));
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f34818c.cancel();
                    this.f34818c = SubscriptionHelper.f32454a;
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f34819d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34819d = true;
            this.f34818c = SubscriptionHelper.f32454a;
            this.f34816a.onError(th);
        }

        public final void onComplete() {
            if (!this.f34819d) {
                this.f34819d = true;
                this.f34818c = SubscriptionHelper.f32454a;
                this.f34816a.onSuccess(Boolean.valueOf(false));
            }
        }

        public final void mo5626a() {
            this.f34818c.cancel();
            this.f34818c = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f34818c == SubscriptionHelper.f32454a;
        }
    }

    public FlowableAnySingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f34820a = flowable;
        this.f34821b = predicate;
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f34820a.subscribe(new AnySubscriber(singleObserver, this.f34821b));
    }

    public final Flowable<Boolean> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableAny(this.f34820a, this.f34821b));
    }
}
