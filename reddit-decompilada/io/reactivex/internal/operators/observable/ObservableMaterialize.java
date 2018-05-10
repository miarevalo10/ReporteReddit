package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Notification<T>> f31932a;
        Disposable f31933b;

        MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.f31932a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31933b, disposable)) {
                this.f31933b = disposable;
                this.f31932a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31933b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31933b.mo5627b();
        }

        public final void onNext(T t) {
            this.f31932a.onNext(Notification.m26483a((Object) t));
        }

        public final void onError(Throwable th) {
            this.f31932a.onNext(Notification.m26484a(th));
            this.f31932a.onComplete();
        }

        public final void onComplete() {
            this.f31932a.onNext(Notification.m26485e());
            this.f31932a.onComplete();
        }
    }

    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public final void subscribeActual(Observer<? super Notification<T>> observer) {
        this.source.subscribe(new MaterializeObserver(observer));
    }
}
