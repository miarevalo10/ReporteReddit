package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {
    final Flowable<T> f34941a;

    static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {
        final SingleObserver<? super Long> f34938a;
        Subscription f34939b;
        long f34940c;

        CountSubscriber(SingleObserver<? super Long> singleObserver) {
            this.f34938a = singleObserver;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34939b, subscription)) {
                this.f34939b = subscription;
                this.f34938a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            this.f34940c++;
        }

        public final void onError(Throwable th) {
            this.f34939b = SubscriptionHelper.f32454a;
            this.f34938a.onError(th);
        }

        public final void onComplete() {
            this.f34939b = SubscriptionHelper.f32454a;
            this.f34938a.onSuccess(Long.valueOf(this.f34940c));
        }

        public final void mo5626a() {
            this.f34939b.cancel();
            this.f34939b = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f34939b == SubscriptionHelper.f32454a;
        }
    }

    public FlowableCountSingle(Flowable<T> flowable) {
        this.f34941a = flowable;
    }

    protected final void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f34941a.subscribe(new CountSubscriber(singleObserver));
    }

    public final Flowable<Long> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableCount(this.f34941a));
    }
}
