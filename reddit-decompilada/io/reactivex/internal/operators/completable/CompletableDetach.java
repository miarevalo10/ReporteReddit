package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class CompletableDetach extends Completable {
    final CompletableSource f34727a;

    static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        CompletableObserver f31189a;
        Disposable f31190b;

        DetachCompletableObserver(CompletableObserver completableObserver) {
            this.f31189a = completableObserver;
        }

        public final void mo5626a() {
            this.f31189a = null;
            this.f31190b.mo5626a();
            this.f31190b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31190b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31190b, disposable)) {
                this.f31190b = disposable;
                this.f31189a.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.f31190b = DisposableHelper.f31095a;
            CompletableObserver completableObserver = this.f31189a;
            if (completableObserver != null) {
                this.f31189a = null;
                completableObserver.onError(th);
            }
        }

        public final void onComplete() {
            this.f31190b = DisposableHelper.f31095a;
            CompletableObserver completableObserver = this.f31189a;
            if (completableObserver != null) {
                this.f31189a = null;
                completableObserver.onComplete();
            }
        }
    }

    public CompletableDetach(CompletableSource completableSource) {
        this.f34727a = completableSource;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34727a.subscribe(new DetachCompletableObserver(completableObserver));
    }
}
