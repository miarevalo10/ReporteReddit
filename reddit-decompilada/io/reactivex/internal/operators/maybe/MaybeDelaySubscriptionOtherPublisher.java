package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> f37912b;

    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        final MaybeObserver<? super T> f31422a;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31422a = maybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            this.f31422a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31422a.onError(th);
        }

        public final void onComplete() {
            this.f31422a.onComplete();
        }
    }

    static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {
        final DelayMaybeObserver<T> f35562a;
        MaybeSource<T> f35563b;
        Subscription f35564c;

        OtherSubscriber(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f35562a = new DelayMaybeObserver(maybeObserver);
            this.f35563b = maybeSource;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35564c, subscription)) {
                this.f35564c = subscription;
                this.f35562a.f31422a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            if (this.f35564c != SubscriptionHelper.f32454a) {
                this.f35564c.cancel();
                this.f35564c = SubscriptionHelper.f32454a;
                m35900c();
            }
        }

        public final void onError(Throwable th) {
            if (this.f35564c != SubscriptionHelper.f32454a) {
                this.f35564c = SubscriptionHelper.f32454a;
                this.f35562a.f31422a.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (this.f35564c != SubscriptionHelper.f32454a) {
                this.f35564c = SubscriptionHelper.f32454a;
                m35900c();
            }
        }

        private void m35900c() {
            MaybeSource maybeSource = this.f35563b;
            this.f35563b = null;
            maybeSource.subscribe(this.f35562a);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) this.f35562a.get());
        }

        public final void mo5626a() {
            this.f35564c.cancel();
            this.f35564c = SubscriptionHelper.f32454a;
            DisposableHelper.m32090a(this.f35562a);
        }
    }

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f37912b = publisher;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f37912b.subscribe(new OtherSubscriber(maybeObserver, this.a));
    }
}
