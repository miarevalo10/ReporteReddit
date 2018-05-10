package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty<T> extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<? extends T> f37937b;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31514a;
        final MaybeSource<? extends T> f31515b;

        static final class OtherMaybeObserver<T> implements MaybeObserver<T> {
            final MaybeObserver<? super T> f31512a;
            final AtomicReference<Disposable> f31513b;

            OtherMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.f31512a = maybeObserver;
                this.f31513b = atomicReference;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this.f31513b, disposable);
            }

            public final void onSuccess(T t) {
                this.f31512a.onSuccess(t);
            }

            public final void onError(Throwable th) {
                this.f31512a.onError(th);
            }

            public final void onComplete() {
                this.f31512a.onComplete();
            }
        }

        SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            this.f31514a = maybeObserver;
            this.f31515b = maybeSource;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31514a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31514a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31514a.onError(th);
        }

        public final void onComplete() {
            Disposable disposable = (Disposable) get();
            if (disposable != DisposableHelper.f31095a && compareAndSet(disposable, null)) {
                this.f31515b.subscribe(new OtherMaybeObserver(this.f31514a, this));
            }
        }
    }

    public MaybeSwitchIfEmpty(MaybeSource<T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.f37937b = maybeSource2;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new SwitchIfEmptyMaybeObserver(maybeObserver, this.f37937b));
    }
}
