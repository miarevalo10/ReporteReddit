package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class CompletableToObservable<T> extends Observable<T> {
    final CompletableSource f34787a;

    static final class ObserverCompletableObserver implements CompletableObserver {
        private final Observer<?> f31235a;

        ObserverCompletableObserver(Observer<?> observer) {
            this.f31235a = observer;
        }

        public final void onComplete() {
            this.f31235a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f31235a.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31235a.onSubscribe(disposable);
        }
    }

    public CompletableToObservable(CompletableSource completableSource) {
        this.f34787a = completableSource;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.f34787a.subscribe(new ObserverCompletableObserver(observer));
    }
}
