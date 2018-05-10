package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeIsEmpty<T> extends AbstractMaybeWithUpstream<T, Boolean> {

    static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super Boolean> f31485a;
        Disposable f31486b;

        IsEmptyMaybeObserver(MaybeObserver<? super Boolean> maybeObserver) {
            this.f31485a = maybeObserver;
        }

        public final void mo5626a() {
            this.f31486b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31486b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31486b, disposable)) {
                this.f31486b = disposable;
                this.f31485a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31485a.onSuccess(Boolean.valueOf(false));
        }

        public final void onError(Throwable th) {
            this.f31485a.onError(th);
        }

        public final void onComplete() {
            this.f31485a.onSuccess(Boolean.valueOf(true));
        }
    }

    public MaybeIsEmpty(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    protected final void subscribeActual(MaybeObserver<? super Boolean> maybeObserver) {
        this.a.subscribe(new IsEmptyMaybeObserver(maybeObserver));
    }
}
