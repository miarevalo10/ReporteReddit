package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    final long f38071a;

    static final class SkipObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f32113a;
        long f32114b;
        Disposable f32115c;

        SkipObserver(Observer<? super T> observer, long j) {
            this.f32113a = observer;
            this.f32114b = j;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32115c = disposable;
            this.f32113a.onSubscribe(this);
        }

        public final void onNext(T t) {
            if (this.f32114b != 0) {
                this.f32114b--;
            } else {
                this.f32113a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            this.f32113a.onError(th);
        }

        public final void onComplete() {
            this.f32113a.onComplete();
        }

        public final void mo5626a() {
            this.f32115c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32115c.mo5627b();
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.f38071a = j;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipObserver(observer, this.f38071a));
    }
}
