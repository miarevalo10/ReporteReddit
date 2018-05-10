package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {
    final BooleanSupplier f38047a;

    static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        final Observer<? super T> f32002a;
        final SequentialDisposable f32003b;
        final ObservableSource<? extends T> f32004c;
        final BooleanSupplier f32005d;

        RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f32002a = observer;
            this.f32003b = sequentialDisposable;
            this.f32004c = observableSource;
            this.f32005d = booleanSupplier;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f32003b, disposable);
        }

        public final void onNext(T t) {
            this.f32002a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f32002a.onError(th);
        }

        public final void onComplete() {
            try {
                if (this.f32005d.mo6617a()) {
                    this.f32002a.onComplete();
                } else {
                    m32546a();
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.f32002a.onError(th);
            }
        }

        final void m32546a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    this.f32004c.subscribe(this);
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    public ObservableRepeatUntil(Observable<T> observable, BooleanSupplier booleanSupplier) {
        super(observable);
        this.f38047a = booleanSupplier;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Object sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(observer, this.f38047a, sequentialDisposable, this.source).m32546a();
    }
}
