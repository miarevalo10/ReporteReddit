package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeCount<T> extends Single<Long> {
    final MaybeSource<T> f35556a;

    static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {
        final SingleObserver<? super Long> f31410a;
        Disposable f31411b;

        CountMaybeObserver(SingleObserver<? super Long> singleObserver) {
            this.f31410a = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31411b, disposable)) {
                this.f31411b = disposable;
                this.f31410a.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.f31411b = DisposableHelper.f31095a;
            this.f31410a.onSuccess(Long.valueOf(1));
        }

        public final void onError(Throwable th) {
            this.f31411b = DisposableHelper.f31095a;
            this.f31410a.onError(th);
        }

        public final void onComplete() {
            this.f31411b = DisposableHelper.f31095a;
            this.f31410a.onSuccess(Long.valueOf(0));
        }

        public final boolean mo5627b() {
            return this.f31411b.mo5627b();
        }

        public final void mo5626a() {
            this.f31411b.mo5626a();
            this.f31411b = DisposableHelper.f31095a;
        }
    }

    public MaybeCount(MaybeSource<T> maybeSource) {
        this.f35556a = maybeSource;
    }

    protected final void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f35556a.subscribe(new CountMaybeObserver(singleObserver));
    }
}
