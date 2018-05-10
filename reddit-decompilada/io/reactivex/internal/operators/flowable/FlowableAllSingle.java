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

public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Flowable<T> f34807a;
    final Predicate<? super T> f34808b;

    static final class AllSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super Boolean> f34803a;
        final Predicate<? super T> f34804b;
        Subscription f34805c;
        boolean f34806d;

        AllSubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f34803a = singleObserver;
            this.f34804b = predicate;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34805c, subscription)) {
                this.f34805c = subscription;
                this.f34803a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f34806d) {
                try {
                    if (this.f34804b.test(t) == null) {
                        this.f34806d = true;
                        this.f34805c.cancel();
                        this.f34805c = SubscriptionHelper.f32454a;
                        this.f34803a.onSuccess(Boolean.valueOf(false));
                    }
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f34805c.cancel();
                    this.f34805c = SubscriptionHelper.f32454a;
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f34806d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34806d = true;
            this.f34805c = SubscriptionHelper.f32454a;
            this.f34803a.onError(th);
        }

        public final void onComplete() {
            if (!this.f34806d) {
                this.f34806d = true;
                this.f34805c = SubscriptionHelper.f32454a;
                this.f34803a.onSuccess(Boolean.valueOf(true));
            }
        }

        public final void mo5626a() {
            this.f34805c.cancel();
            this.f34805c = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f34805c == SubscriptionHelper.f32454a;
        }
    }

    public FlowableAllSingle(Flowable<T> flowable, Predicate<? super T> predicate) {
        this.f34807a = flowable;
        this.f34808b = predicate;
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f34807a.subscribe(new AllSubscriber(singleObserver, this.f34808b));
    }

    public final Flowable<Boolean> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableAll(this.f34807a, this.f34808b));
    }
}
