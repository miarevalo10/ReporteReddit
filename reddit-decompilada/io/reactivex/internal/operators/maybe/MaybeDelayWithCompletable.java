package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelayWithCompletable<T> extends Maybe<T> {
    final MaybeSource<T> f35565a;
    final CompletableSource f35566b;

    static final class DelayWithMainObserver<T> implements MaybeObserver<T> {
        final AtomicReference<Disposable> f31423a;
        final MaybeObserver<? super T> f31424b;

        DelayWithMainObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super T> maybeObserver) {
            this.f31423a = atomicReference;
            this.f31424b = maybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31423a, disposable);
        }

        public final void onSuccess(T t) {
            this.f31424b.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f31424b.onError(th);
        }

        public final void onComplete() {
            this.f31424b.onComplete();
        }
    }

    static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        final MaybeObserver<? super T> f31425a;
        final MaybeSource<T> f31426b;

        OtherObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.f31425a = maybeObserver;
            this.f31426b = maybeSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31425a.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.f31425a.onError(th);
        }

        public final void onComplete() {
            this.f31426b.subscribe(new DelayWithMainObserver(this, this.f31425a));
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public MaybeDelayWithCompletable(MaybeSource<T> maybeSource, CompletableSource completableSource) {
        this.f35565a = maybeSource;
        this.f35566b = completableSource;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35566b.subscribe(new OtherObserver(maybeObserver, this.f35565a));
    }
}
