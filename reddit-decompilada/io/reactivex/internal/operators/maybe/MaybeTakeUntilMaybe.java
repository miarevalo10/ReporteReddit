package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTakeUntilMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<U> f37938b;

    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31521a;
        final TakeUntilOtherMaybeObserver<U> f31522b = new TakeUntilOtherMaybeObserver(this);

        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            final TakeUntilMainMaybeObserver<?, U> f31520a;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.f31520a = takeUntilMainMaybeObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onSuccess(Object obj) {
                this.f31520a.m32323c();
            }

            public final void onError(Throwable th) {
                AtomicReference atomicReference = this.f31520a;
                if (DisposableHelper.m32090a(atomicReference)) {
                    atomicReference.f31521a.onError(th);
                } else {
                    RxJavaPlugins.m26757a(th);
                }
            }

            public final void onComplete() {
                this.f31520a.m32323c();
            }
        }

        TakeUntilMainMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31521a = maybeObserver;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            DisposableHelper.m32090a(this.f31522b);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            DisposableHelper.m32090a(this.f31522b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31521a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.m32090a(this.f31522b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31521a.onError(th);
            } else {
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onComplete() {
            DisposableHelper.m32090a(this.f31522b);
            if (getAndSet(DisposableHelper.f31095a) != DisposableHelper.f31095a) {
                this.f31521a.onComplete();
            }
        }

        final void m32323c() {
            if (DisposableHelper.m32090a((AtomicReference) this)) {
                this.f31521a.onComplete();
            }
        }
    }

    public MaybeTakeUntilMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2) {
        super(maybeSource);
        this.f37938b = maybeSource2;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(takeUntilMainMaybeObserver);
        this.f37938b.subscribe(takeUntilMainMaybeObserver.f31522b);
        this.a.subscribe(takeUntilMainMaybeObserver);
    }
}
