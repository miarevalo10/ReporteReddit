package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {
    final Flowable<T> f34877a;
    final Callable<? extends U> f34878b;
    final BiConsumer<? super U, ? super T> f34879c;

    static final class CollectSubscriber<T, U> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super U> f34872a;
        final BiConsumer<? super U, ? super T> f34873b;
        final U f34874c;
        Subscription f34875d;
        boolean f34876e;

        CollectSubscriber(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.f34872a = singleObserver;
            this.f34873b = biConsumer;
            this.f34874c = u;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34875d, subscription)) {
                this.f34875d = subscription;
                this.f34872a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f34876e) {
                try {
                    this.f34873b.mo4825a(this.f34874c, t);
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f34875d.cancel();
                    onError(t2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f34876e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34876e = true;
            this.f34875d = SubscriptionHelper.f32454a;
            this.f34872a.onError(th);
        }

        public final void onComplete() {
            if (!this.f34876e) {
                this.f34876e = true;
                this.f34875d = SubscriptionHelper.f32454a;
                this.f34872a.onSuccess(this.f34874c);
            }
        }

        public final void mo5626a() {
            this.f34875d.cancel();
            this.f34875d = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f34875d == SubscriptionHelper.f32454a;
        }
    }

    public FlowableCollectSingle(Flowable<T> flowable, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.f34877a = flowable;
        this.f34878b = callable;
        this.f34879c = biConsumer;
    }

    protected final void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f34877a.subscribe(new CollectSubscriber(singleObserver, ObjectHelper.m26573a(this.f34878b.call(), "The initialSupplier returned a null value"), this.f34879c));
        } catch (Throwable th) {
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }

    public final Flowable<U> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableCollect(this.f34877a, this.f34878b, this.f34879c));
    }
}
