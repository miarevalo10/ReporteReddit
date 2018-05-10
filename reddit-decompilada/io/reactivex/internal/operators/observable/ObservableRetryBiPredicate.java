package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    final BiPredicate<? super Integer, ? super Throwable> f38056a;

    static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
        final Observer<? super T> f32036a;
        final SequentialDisposable f32037b;
        final ObservableSource<? extends T> f32038c;
        final BiPredicate<? super Integer, ? super Throwable> f32039d;
        int f32040e;

        RetryBiObserver(Observer<? super T> observer, BiPredicate<? super Integer, ? super Throwable> biPredicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f32036a = observer;
            this.f32037b = sequentialDisposable;
            this.f32038c = observableSource;
            this.f32039d = biPredicate;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32091a(this.f32037b, disposable);
        }

        public final void onNext(T t) {
            this.f32036a.onNext(t);
        }

        public final void onError(Throwable th) {
            try {
                BiPredicate biPredicate = this.f32039d;
                int i = this.f32040e + 1;
                this.f32040e = i;
                if (biPredicate.mo4928a(Integer.valueOf(i), th)) {
                    m32574a();
                } else {
                    this.f32036a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f32036a.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            this.f32036a.onComplete();
        }

        final void m32574a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f32037b.mo5627b()) {
                    this.f32038c.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                    }
                }
            }
        }
    }

    public ObservableRetryBiPredicate(Observable<T> observable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(observable);
        this.f38056a = biPredicate;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Object sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RetryBiObserver(observer, this.f38056a, sequentialDisposable, this.source).m32574a();
    }
}
