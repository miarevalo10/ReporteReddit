package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {

    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        final Observer<? super T> f31879a;
        Disposable f31880b;

        public final void onNext(T t) {
        }

        IgnoreObservable(Observer<? super T> observer) {
            this.f31879a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31880b = disposable;
            this.f31879a.onSubscribe(this);
        }

        public final void onError(Throwable th) {
            this.f31879a.onError(th);
        }

        public final void onComplete() {
            this.f31879a.onComplete();
        }

        public final void mo5626a() {
            this.f31880b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31880b.mo5627b();
        }
    }

    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new IgnoreObservable(observer));
    }
}
