package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTimeoutPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> f37942b;
    final MaybeSource<? extends T> f37943c;

    static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        final MaybeObserver<? super T> f31531a;

        TimeoutFallbackMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31531a = maybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            this.f31531a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31531a.onError(th);
        }

        public final void onComplete() {
            this.f31531a.onComplete();
        }
    }

    static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31532a;
        final TimeoutOtherMaybeObserver<T, U> f31533b = new TimeoutOtherMaybeObserver(this);
        final MaybeSource<? extends T> f31534c;
        final TimeoutFallbackMaybeObserver<T> f31535d;

        TimeoutMainMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            this.f31532a = maybeObserver;
            this.f31534c = maybeSource;
            this.f31535d = maybeSource != null ? new TimeoutFallbackMaybeObserver(maybeObserver) : null;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            SubscriptionHelper.m32777a(this.f31533b);
            AtomicReference atomicReference = this.f31535d;
            if (atomicReference != null) {
                DisposableHelper.m32090a(atomicReference);
            }
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            SubscriptionHelper.m32777a(this.f31533b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31532a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.m32777a(this.f31533b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31532a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            SubscriptionHelper.m32777a(this.f31533b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31532a.onComplete();
            }
        }

        public final void m32332c() {
            if (DisposableHelper.m32090a((AtomicReference) this)) {
                if (this.f31534c == null) {
                    this.f31532a.onError(new TimeoutException());
                    return;
                }
                this.f31534c.subscribe(this.f31535d);
            }
        }
    }

    static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        final TimeoutMainMaybeObserver<T, U> f35605a;

        TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.f35605a = timeoutMainMaybeObserver;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(Object obj) {
            ((Subscription) get()).cancel();
            this.f35605a.m32332c();
        }

        public final void onError(Throwable th) {
            AtomicReference atomicReference = this.f35605a;
            if (DisposableHelper.m32090a(atomicReference)) {
                atomicReference.f31532a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            this.f35605a.m32332c();
        }
    }

    public MaybeTimeoutPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.f37942b = publisher;
        this.f37943c = maybeSource2;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.f37943c);
        maybeObserver.onSubscribe(timeoutMainMaybeObserver);
        this.f37942b.subscribe(timeoutMainMaybeObserver.f31533b);
        this.a.subscribe(timeoutMainMaybeObserver);
    }
}
