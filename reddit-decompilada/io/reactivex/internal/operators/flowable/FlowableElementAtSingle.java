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

public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {
    final Flowable<T> f34997a;
    final long f34998b;
    final T f34999c;

    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super T> f34991a;
        final long f34992b;
        final T f34993c;
        Subscription f34994d;
        long f34995e;
        boolean f34996f;

        ElementAtSubscriber(SingleObserver<? super T> singleObserver, long j, T t) {
            this.f34991a = singleObserver;
            this.f34992b = j;
            this.f34993c = t;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34994d, subscription)) {
                this.f34994d = subscription;
                this.f34991a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f34996f) {
                long j = this.f34995e;
                if (j == this.f34992b) {
                    this.f34996f = true;
                    this.f34994d.cancel();
                    this.f34994d = SubscriptionHelper.f32454a;
                    this.f34991a.onSuccess(t);
                    return;
                }
                this.f34995e = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f34996f) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34996f = true;
            this.f34994d = SubscriptionHelper.f32454a;
            this.f34991a.onError(th);
        }

        public final void onComplete() {
            this.f34994d = SubscriptionHelper.f32454a;
            if (!this.f34996f) {
                this.f34996f = true;
                Object obj = this.f34993c;
                if (obj != null) {
                    this.f34991a.onSuccess(obj);
                    return;
                }
                this.f34991a.onError(new NoSuchElementException());
            }
        }

        public final void mo5626a() {
            this.f34994d.cancel();
            this.f34994d = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f34994d == SubscriptionHelper.f32454a;
        }
    }

    public FlowableElementAtSingle(Flowable<T> flowable, long j, T t) {
        this.f34997a = flowable;
        this.f34998b = j;
        this.f34999c = t;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f34997a.subscribe(new ElementAtSubscriber(singleObserver, this.f34998b, this.f34999c));
    }

    public final Flowable<T> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableElementAt(this.f34997a, this.f34998b, this.f34999c, true));
    }
}
