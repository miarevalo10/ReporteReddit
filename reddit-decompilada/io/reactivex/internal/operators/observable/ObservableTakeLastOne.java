package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32172a;
        Disposable f32173b;
        T f32174c;

        TakeLastOneObserver(Observer<? super T> observer) {
            this.f32172a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32173b, disposable)) {
                this.f32173b = disposable;
                this.f32172a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f32174c = t;
        }

        public final void onError(Throwable th) {
            this.f32174c = null;
            this.f32172a.onError(th);
        }

        public final void mo5626a() {
            this.f32174c = null;
            this.f32173b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32173b.mo5627b();
        }

        public final void onComplete() {
            Object obj = this.f32174c;
            if (obj != null) {
                this.f32174c = null;
                this.f32172a.onNext(obj);
            }
            this.f32172a.onComplete();
        }
    }

    public ObservableTakeLastOne(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastOneObserver(observer));
    }
}
