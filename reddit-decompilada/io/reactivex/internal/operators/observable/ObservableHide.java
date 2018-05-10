package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {

    static final class HideDisposable<T> implements Observer<T>, Disposable {
        final Observer<? super T> f31877a;
        Disposable f31878b;

        HideDisposable(Observer<? super T> observer) {
            this.f31877a = observer;
        }

        public final void mo5626a() {
            this.f31878b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31878b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31878b, disposable)) {
                this.f31878b = disposable;
                this.f31877a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f31877a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f31877a.onError(th);
        }

        public final void onComplete() {
            this.f31877a.onComplete();
        }
    }

    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new HideDisposable(observer));
    }
}
