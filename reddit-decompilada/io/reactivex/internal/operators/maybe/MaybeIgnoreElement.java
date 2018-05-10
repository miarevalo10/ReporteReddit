package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeIgnoreElement<T> extends AbstractMaybeWithUpstream<T, T> {

    static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31481a;
        Disposable f31482b;

        IgnoreMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31481a = maybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31482b, disposable)) {
                this.f31482b = disposable;
                this.f31481a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31482b = DisposableHelper.f31095a;
            this.f31481a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f31482b = DisposableHelper.f31095a;
            this.f31481a.onError(th);
        }

        public final void onComplete() {
            this.f31482b = DisposableHelper.f31095a;
            this.f31481a.onComplete();
        }

        public final boolean mo5627b() {
            return this.f31482b.mo5627b();
        }

        public final void mo5626a() {
            this.f31482b.mo5626a();
            this.f31482b = DisposableHelper.f31095a;
        }
    }

    public MaybeIgnoreElement(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new IgnoreMaybeObserver(maybeObserver));
    }
}
