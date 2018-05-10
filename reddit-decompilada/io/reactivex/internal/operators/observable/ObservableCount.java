package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {

    static final class CountObserver implements Observer<Object>, Disposable {
        final Observer<? super Long> f31710a;
        Disposable f31711b;
        long f31712c;

        CountObserver(Observer<? super Long> observer) {
            this.f31710a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31711b, disposable)) {
                this.f31711b = disposable;
                this.f31710a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31711b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31711b.mo5627b();
        }

        public final void onNext(Object obj) {
            this.f31712c++;
        }

        public final void onError(Throwable th) {
            this.f31710a.onError(th);
        }

        public final void onComplete() {
            this.f31710a.onNext(Long.valueOf(this.f31712c));
            this.f31710a.onComplete();
        }
    }

    public ObservableCount(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public final void subscribeActual(Observer<? super Long> observer) {
        this.source.subscribe(new CountObserver(observer));
    }
}
