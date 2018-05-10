package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {
    final Flowable<T> f35337a;
    final T f35338b;

    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super T> f35332a;
        final T f35333b;
        Subscription f35334c;
        boolean f35335d;
        T f35336e;

        SingleElementSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.f35332a = singleObserver;
            this.f35333b = t;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35334c, subscription)) {
                this.f35334c = subscription;
                this.f35332a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f35335d) {
                if (this.f35336e != null) {
                    this.f35335d = true;
                    this.f35334c.cancel();
                    this.f35334c = SubscriptionHelper.f32454a;
                    this.f35332a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f35336e = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f35335d) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35335d = true;
            this.f35334c = SubscriptionHelper.f32454a;
            this.f35332a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35335d) {
                this.f35335d = true;
                this.f35334c = SubscriptionHelper.f32454a;
                Object obj = this.f35336e;
                this.f35336e = null;
                if (obj == null) {
                    obj = this.f35333b;
                }
                if (obj != null) {
                    this.f35332a.onSuccess(obj);
                } else {
                    this.f35332a.onError(new NoSuchElementException());
                }
            }
        }

        public final void mo5626a() {
            this.f35334c.cancel();
            this.f35334c = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f35334c == SubscriptionHelper.f32454a;
        }
    }

    public FlowableSingleSingle(Flowable<T> flowable, T t) {
        this.f35337a = flowable;
        this.f35338b = t;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35337a.subscribe(new SingleElementSubscriber(singleObserver, this.f35338b));
    }

    public final Flowable<T> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableSingle(this.f35337a, this.f35338b));
    }
}
