package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeFromCompletable<T> extends Maybe<T> {
    final CompletableSource f35587a;

    static final class FromCompletableObserver<T> implements CompletableObserver, Disposable {
        final MaybeObserver<? super T> f31475a;
        Disposable f31476b;

        FromCompletableObserver(MaybeObserver<? super T> maybeObserver) {
            this.f31475a = maybeObserver;
        }

        public final void mo5626a() {
            this.f31476b.mo5626a();
            this.f31476b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31476b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31476b, disposable)) {
                this.f31476b = disposable;
                this.f31475a.onSubscribe(this);
            }
        }

        public final void onComplete() {
            this.f31476b = DisposableHelper.f31095a;
            this.f31475a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f31476b = DisposableHelper.f31095a;
            this.f31475a.onError(th);
        }
    }

    public MaybeFromCompletable(CompletableSource completableSource) {
        this.f35587a = completableSource;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f35587a.subscribe(new FromCompletableObserver(maybeObserver));
    }
}
