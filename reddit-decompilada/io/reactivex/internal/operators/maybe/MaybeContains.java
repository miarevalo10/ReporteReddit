package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeContains<T> extends Single<Boolean> {
    final MaybeSource<T> f35554a;
    final Object f35555b;

    static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {
        final SingleObserver<? super Boolean> f31407a;
        final Object f31408b;
        Disposable f31409c;

        ContainsMaybeObserver(SingleObserver<? super Boolean> singleObserver, Object obj) {
            this.f31407a = singleObserver;
            this.f31408b = obj;
        }

        public final void mo5626a() {
            this.f31409c.mo5626a();
            this.f31409c = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31409c.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31409c, disposable)) {
                this.f31409c = disposable;
                this.f31407a.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.f31409c = DisposableHelper.f31095a;
            this.f31407a.onSuccess(Boolean.valueOf(ObjectHelper.m26574a(obj, this.f31408b)));
        }

        public final void onError(Throwable th) {
            this.f31409c = DisposableHelper.f31095a;
            this.f31407a.onError(th);
        }

        public final void onComplete() {
            this.f31409c = DisposableHelper.f31095a;
            this.f31407a.onSuccess(Boolean.valueOf(false));
        }
    }

    public MaybeContains(MaybeSource<T> maybeSource, Object obj) {
        this.f35554a = maybeSource;
        this.f35555b = obj;
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f35554a.subscribe(new ContainsMaybeObserver(singleObserver, this.f35555b));
    }
}
