package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements FuseToMaybe<Boolean> {
    final MaybeSource<T> f35594a;

    static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final SingleObserver<? super Boolean> f31487a;
        Disposable f31488b;

        IsEmptyMaybeObserver(SingleObserver<? super Boolean> singleObserver) {
            this.f31487a = singleObserver;
        }

        public final void mo5626a() {
            this.f31488b.mo5626a();
            this.f31488b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31488b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31488b, disposable)) {
                this.f31488b = disposable;
                this.f31487a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31488b = DisposableHelper.f31095a;
            this.f31487a.onSuccess(Boolean.valueOf(false));
        }

        public final void onError(Throwable th) {
            this.f31488b = DisposableHelper.f31095a;
            this.f31487a.onError(th);
        }

        public final void onComplete() {
            this.f31488b = DisposableHelper.f31095a;
            this.f31487a.onSuccess(Boolean.valueOf(true));
        }
    }

    public MaybeIsEmptySingle(MaybeSource<T> maybeSource) {
        this.f35594a = maybeSource;
    }

    public final Maybe<Boolean> mo6633a() {
        return RxJavaPlugins.m26740a(new MaybeIsEmpty(this.f35594a));
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f35594a.subscribe(new IsEmptyMaybeObserver(singleObserver));
    }
}
