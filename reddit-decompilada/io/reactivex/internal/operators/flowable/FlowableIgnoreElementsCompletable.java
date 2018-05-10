package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {
    final Flowable<T> f35088a;

    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final CompletableObserver f35086a;
        Subscription f35087b;

        public final void onNext(T t) {
        }

        IgnoreElementsSubscriber(CompletableObserver completableObserver) {
            this.f35086a = completableObserver;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35087b, subscription)) {
                this.f35087b = subscription;
                this.f35086a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onError(Throwable th) {
            this.f35087b = SubscriptionHelper.f32454a;
            this.f35086a.onError(th);
        }

        public final void onComplete() {
            this.f35087b = SubscriptionHelper.f32454a;
            this.f35086a.onComplete();
        }

        public final void mo5626a() {
            this.f35087b.cancel();
            this.f35087b = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f35087b == SubscriptionHelper.f32454a;
        }
    }

    public FlowableIgnoreElementsCompletable(Flowable<T> flowable) {
        this.f35088a = flowable;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f35088a.subscribe(new IgnoreElementsSubscriber(completableObserver));
    }

    public final Flowable<T> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableIgnoreElements(this.f35088a));
    }
}
