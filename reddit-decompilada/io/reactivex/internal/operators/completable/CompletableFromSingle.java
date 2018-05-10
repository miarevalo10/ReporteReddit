package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> f34744a;

    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        final CompletableObserver f31201a;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f31201a = completableObserver;
        }

        public final void onError(Throwable th) {
            this.f31201a.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31201a.onSubscribe(disposable);
        }

        public final void onSuccess(T t) {
            this.f31201a.onComplete();
        }
    }

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.f34744a = singleSource;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34744a.subscribe(new CompletableFromSingleObserver(completableObserver));
    }
}
