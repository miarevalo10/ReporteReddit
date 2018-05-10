package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> f38081a;

    static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        final Observer<? super T> f32145a;
        final ObservableSource<? extends T> f32146b;
        final SequentialDisposable f32147c = new SequentialDisposable();
        boolean f32148d = true;

        SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.f32145a = observer;
            this.f32146b = observableSource;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32091a(this.f32147c, disposable);
        }

        public final void onNext(T t) {
            if (this.f32148d) {
                this.f32148d = false;
            }
            this.f32145a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f32145a.onError(th);
        }

        public final void onComplete() {
            if (this.f32148d) {
                this.f32148d = false;
                this.f32146b.subscribe(this);
                return;
            }
            this.f32145a.onComplete();
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.f38081a = observableSource2;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Observer switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.f38081a);
        observer.onSubscribe(switchIfEmptyObserver.f32147c);
        this.source.subscribe(switchIfEmptyObserver);
    }
}
