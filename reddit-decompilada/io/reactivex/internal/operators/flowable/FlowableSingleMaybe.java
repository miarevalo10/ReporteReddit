package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final Flowable<T> f35331a;

    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> f35327a;
        Subscription f35328b;
        boolean f35329c;
        T f35330d;

        SingleElementSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f35327a = maybeObserver;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35328b, subscription)) {
                this.f35328b = subscription;
                this.f35327a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f35329c) {
                if (this.f35330d != null) {
                    this.f35329c = true;
                    this.f35328b.cancel();
                    this.f35328b = SubscriptionHelper.f32454a;
                    this.f35327a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f35330d = t;
            }
        }

        public final void onError(Throwable th) {
            if (this.f35329c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35329c = true;
            this.f35328b = SubscriptionHelper.f32454a;
            this.f35327a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35329c) {
                this.f35329c = true;
                this.f35328b = SubscriptionHelper.f32454a;
                Object obj = this.f35330d;
                this.f35330d = null;
                if (obj == null) {
                    this.f35327a.onComplete();
                } else {
                    this.f35327a.onSuccess(obj);
                }
            }
        }

        public final void mo5626a() {
            this.f35328b.cancel();
            this.f35328b = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f35328b == SubscriptionHelper.f32454a;
        }
    }

    public FlowableSingleMaybe(Flowable<T> flowable) {
        this.f35331a = flowable;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35331a.subscribe(new SingleElementSubscriber(maybeObserver));
    }

    public final Flowable<T> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableSingle(this.f35331a, null));
    }
}
