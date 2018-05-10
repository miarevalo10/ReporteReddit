package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends U> f38093a;

    final class TakeUntil implements Observer<U> {
        final /* synthetic */ ObservableTakeUntil f32185a;
        private final ArrayCompositeDisposable f32186b;
        private final SerializedObserver<T> f32187c;

        TakeUntil(ObservableTakeUntil observableTakeUntil, ArrayCompositeDisposable arrayCompositeDisposable, SerializedObserver<T> serializedObserver) {
            this.f32185a = observableTakeUntil;
            this.f32186b = arrayCompositeDisposable;
            this.f32187c = serializedObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32186b.m32086a(1, disposable);
        }

        public final void onNext(U u) {
            this.f32186b.mo5626a();
            this.f32187c.onComplete();
        }

        public final void onError(Throwable th) {
            this.f32186b.mo5626a();
            this.f32187c.onError(th);
        }

        public final void onComplete() {
            this.f32186b.mo5626a();
            this.f32187c.onComplete();
        }
    }

    static final class TakeUntilObserver<T> extends AtomicBoolean implements Observer<T> {
        final Observer<? super T> f32188a;
        final ArrayCompositeDisposable f32189b;
        Disposable f32190c;

        TakeUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f32188a = observer;
            this.f32189b = arrayCompositeDisposable;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32190c, disposable)) {
                this.f32190c = disposable;
                this.f32189b.m32086a(0, disposable);
            }
        }

        public final void onNext(T t) {
            this.f32188a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f32189b.mo5626a();
            this.f32188a.onError(th);
        }

        public final void onComplete() {
            this.f32189b.mo5626a();
            this.f32188a.onComplete();
        }
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f38093a = observableSource2;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Object serializedObserver = new SerializedObserver(observer);
        Object arrayCompositeDisposable = new ArrayCompositeDisposable();
        Observer takeUntilObserver = new TakeUntilObserver(serializedObserver, arrayCompositeDisposable);
        observer.onSubscribe(arrayCompositeDisposable);
        this.f38093a.subscribe(new TakeUntil(this, arrayCompositeDisposable, serializedObserver));
        this.source.subscribe(takeUntilObserver);
    }
}
