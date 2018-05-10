package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {
    final MaybeSource<T> f35593a;

    static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final CompletableObserver f31483a;
        Disposable f31484b;

        IgnoreMaybeObserver(CompletableObserver completableObserver) {
            this.f31483a = completableObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31484b, disposable)) {
                this.f31484b = disposable;
                this.f31483a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31484b = DisposableHelper.f31095a;
            this.f31483a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f31484b = DisposableHelper.f31095a;
            this.f31483a.onError(th);
        }

        public final void onComplete() {
            this.f31484b = DisposableHelper.f31095a;
            this.f31483a.onComplete();
        }

        public final boolean mo5627b() {
            return this.f31484b.mo5627b();
        }

        public final void mo5626a() {
            this.f31484b.mo5626a();
            this.f31484b = DisposableHelper.f31095a;
        }
    }

    public MaybeIgnoreElementCompletable(MaybeSource<T> maybeSource) {
        this.f35593a = maybeSource;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f35593a.subscribe(new IgnoreMaybeObserver(completableObserver));
    }

    public final Maybe<T> mo6633a() {
        return RxJavaPlugins.m26740a(new MaybeIgnoreElement(this.f35593a));
    }
}
