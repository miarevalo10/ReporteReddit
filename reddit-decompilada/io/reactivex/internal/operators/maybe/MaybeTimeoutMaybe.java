package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimeoutMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<U> f37940b;
    final MaybeSource<? extends T> f37941c;

    static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        final MaybeObserver<? super T> f31525a;

        TimeoutFallbackMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31525a = maybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            this.f31525a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31525a.onError(th);
        }

        public final void onComplete() {
            this.f31525a.onComplete();
        }
    }

    static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31526a;
        final TimeoutOtherMaybeObserver<T, U> f31527b = new TimeoutOtherMaybeObserver(this);
        final MaybeSource<? extends T> f31528c;
        final TimeoutFallbackMaybeObserver<T> f31529d;

        TimeoutMainMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            this.f31526a = maybeObserver;
            this.f31528c = maybeSource;
            this.f31529d = maybeSource != null ? new TimeoutFallbackMaybeObserver(maybeObserver) : null;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            DisposableHelper.m32090a(this.f31527b);
            AtomicReference atomicReference = this.f31529d;
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
            DisposableHelper.m32090a(this.f31527b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31526a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a(this.f31527b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31526a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            DisposableHelper.m32090a(this.f31527b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31526a.onComplete();
            }
        }

        public final void m32329c() {
            if (DisposableHelper.m32090a((AtomicReference) this)) {
                if (this.f31528c == null) {
                    this.f31526a.onError(new TimeoutException());
                    return;
                }
                this.f31528c.subscribe(this.f31529d);
            }
        }
    }

    static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<Object> {
        final TimeoutMainMaybeObserver<T, U> f31530a;

        TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.f31530a = timeoutMainMaybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(Object obj) {
            this.f31530a.m32329c();
        }

        public final void onError(Throwable th) {
            AtomicReference atomicReference = this.f31530a;
            if (DisposableHelper.m32090a(atomicReference)) {
                atomicReference.f31526a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            this.f31530a.m32329c();
        }
    }

    public MaybeTimeoutMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        super(maybeSource);
        this.f37940b = maybeSource2;
        this.f37941c = maybeSource3;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.f37941c);
        maybeObserver.onSubscribe(timeoutMainMaybeObserver);
        this.f37940b.subscribe(timeoutMainMaybeObserver.f31527b);
        this.a.subscribe(timeoutMainMaybeObserver);
    }
}
