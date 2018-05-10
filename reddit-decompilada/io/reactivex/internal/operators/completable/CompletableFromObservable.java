package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> f34739a;

    static final class CompletableFromObservableObserver<T> implements Observer<T> {
        final CompletableObserver f31200a;

        public final void onNext(T t) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f31200a = completableObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31200a.onSubscribe(disposable);
        }

        public final void onError(Throwable th) {
            this.f31200a.onError(th);
        }

        public final void onComplete() {
            this.f31200a.onComplete();
        }
    }

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.f34739a = observableSource;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34739a.subscribe(new CompletableFromObservableObserver(completableObserver));
    }
}
