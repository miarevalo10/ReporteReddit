package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class CompletableHide extends Completable {
    final CompletableSource f34746a;

    static final class HideCompletableObserver implements CompletableObserver, Disposable {
        final CompletableObserver f31202a;
        Disposable f31203b;

        HideCompletableObserver(CompletableObserver completableObserver) {
            this.f31202a = completableObserver;
        }

        public final void mo5626a() {
            this.f31203b.mo5626a();
            this.f31203b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f31203b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31203b, disposable)) {
                this.f31203b = disposable;
                this.f31202a.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.f31202a.onError(th);
        }

        public final void onComplete() {
            this.f31202a.onComplete();
        }
    }

    public CompletableHide(CompletableSource completableSource) {
        this.f34746a = completableSource;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34746a.subscribe(new HideCompletableObserver(completableObserver));
    }
}
