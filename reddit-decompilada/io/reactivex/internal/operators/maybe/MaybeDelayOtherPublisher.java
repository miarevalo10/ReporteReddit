package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeDelayOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> f37911b;

    static final class DelayMaybeObserver<T, U> implements MaybeObserver<T>, Disposable {
        final OtherSubscriber<T> f31419a;
        final Publisher<U> f31420b;
        Disposable f31421c;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, Publisher<U> publisher) {
            this.f31419a = new OtherSubscriber(maybeObserver);
            this.f31420b = publisher;
        }

        public final void mo5626a() {
            this.f31421c.mo5626a();
            this.f31421c = DisposableHelper.f31095a;
            SubscriptionHelper.m32777a(this.f31419a);
        }

        public final boolean mo5627b() {
            return SubscriptionHelper.m32780a((Subscription) this.f31419a.get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31421c, disposable)) {
                this.f31421c = disposable;
                this.f31419a.f35559a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31421c = DisposableHelper.f31095a;
            this.f31419a.f35560b = t;
            m32251c();
        }

        public final void onError(Throwable th) {
            this.f31421c = DisposableHelper.f31095a;
            this.f31419a.f35561c = th;
            m32251c();
        }

        public final void onComplete() {
            this.f31421c = DisposableHelper.f31095a;
            m32251c();
        }

        private void m32251c() {
            this.f31420b.subscribe(this.f31419a);
        }
    }

    static final class OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        final MaybeObserver<? super T> f35559a;
        T f35560b;
        Throwable f35561c;

        OtherSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f35559a = maybeObserver;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            if (subscription != SubscriptionHelper.f32454a) {
                lazySet(SubscriptionHelper.f32454a);
                subscription.cancel();
                onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.f35561c == null) {
                this.f35559a.onError(th);
                return;
            }
            this.f35559a.onError(new CompositeException(r0, th));
        }

        public final void onComplete() {
            Throwable th = this.f35561c;
            if (th != null) {
                this.f35559a.onError(th);
                return;
            }
            Object obj = this.f35560b;
            if (obj != null) {
                this.f35559a.onSuccess(obj);
            } else {
                this.f35559a.onComplete();
            }
        }
    }

    public MaybeDelayOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f37911b = publisher;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new DelayMaybeObserver(maybeObserver, this.f37911b));
    }
}
