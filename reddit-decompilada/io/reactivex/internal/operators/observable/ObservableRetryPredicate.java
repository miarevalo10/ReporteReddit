package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super Throwable> f38057a;
    final long f38058b;

    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        final Observer<? super T> f32041a;
        final SequentialDisposable f32042b;
        final ObservableSource<? extends T> f32043c;
        final Predicate<? super Throwable> f32044d;
        long f32045e;

        RepeatObserver(Observer<? super T> observer, long j, Predicate<? super Throwable> predicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f32041a = observer;
            this.f32042b = sequentialDisposable;
            this.f32043c = observableSource;
            this.f32044d = predicate;
            this.f32045e = j;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32091a(this.f32042b, disposable);
        }

        public final void onNext(T t) {
            this.f32041a.onNext(t);
        }

        public final void onError(Throwable th) {
            long j = this.f32045e;
            if (j != Long.MAX_VALUE) {
                this.f32045e = j - 1;
            }
            if (j == 0) {
                this.f32041a.onError(th);
                return;
            }
            try {
                if (this.f32044d.test(th)) {
                    m32575a();
                } else {
                    this.f32041a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f32041a.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            this.f32041a.onComplete();
        }

        final void m32575a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f32042b.mo5627b()) {
                    this.f32043c.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                    }
                }
            }
        }
    }

    public ObservableRetryPredicate(Observable<T> observable, long j, Predicate<? super Throwable> predicate) {
        super(observable);
        this.f38057a = predicate;
        this.f38058b = j;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Object sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatObserver(observer, this.f38058b, this.f38057a, sequentialDisposable, this.source).m32575a();
    }
}
