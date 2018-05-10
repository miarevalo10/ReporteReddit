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

public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final Flowable<T> f34989a;
    final long f34990b;

    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> f34984a;
        final long f34985b;
        Subscription f34986c;
        long f34987d;
        boolean f34988e;

        ElementAtSubscriber(MaybeObserver<? super T> maybeObserver, long j) {
            this.f34984a = maybeObserver;
            this.f34985b = j;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34986c, subscription)) {
                this.f34986c = subscription;
                this.f34984a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            if (!this.f34988e) {
                long j = this.f34987d;
                if (j == this.f34985b) {
                    this.f34988e = true;
                    this.f34986c.cancel();
                    this.f34986c = SubscriptionHelper.f32454a;
                    this.f34984a.onSuccess(t);
                    return;
                }
                this.f34987d = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f34988e) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34988e = true;
            this.f34986c = SubscriptionHelper.f32454a;
            this.f34984a.onError(th);
        }

        public final void onComplete() {
            this.f34986c = SubscriptionHelper.f32454a;
            if (!this.f34988e) {
                this.f34988e = true;
                this.f34984a.onComplete();
            }
        }

        public final void mo5626a() {
            this.f34986c.cancel();
            this.f34986c = SubscriptionHelper.f32454a;
        }

        public final boolean mo5627b() {
            return this.f34986c == SubscriptionHelper.f32454a;
        }
    }

    public FlowableElementAtMaybe(Flowable<T> flowable, long j) {
        this.f34989a = flowable;
        this.f34990b = j;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f34989a.subscribe(new ElementAtSubscriber(maybeObserver, this.f34990b));
    }

    public final Flowable<T> mo6616a() {
        return RxJavaPlugins.m26739a(new FlowableElementAt(this.f34989a, this.f34990b, null, false));
    }
}
