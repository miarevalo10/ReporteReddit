package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {
    final long f38046a;

    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        final Observer<? super T> f31998a;
        final SequentialDisposable f31999b;
        final ObservableSource<? extends T> f32000c;
        long f32001d;

        RepeatObserver(Observer<? super T> observer, long j, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f31998a = observer;
            this.f31999b = sequentialDisposable;
            this.f32000c = observableSource;
            this.f32001d = j;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31999b, disposable);
        }

        public final void onNext(T t) {
            this.f31998a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f31998a.onError(th);
        }

        public final void onComplete() {
            long j = this.f32001d;
            if (j != Long.MAX_VALUE) {
                this.f32001d = j - 1;
            }
            if (j != 0) {
                m32545a();
            } else {
                this.f31998a.onComplete();
            }
        }

        final void m32545a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f31999b.mo5627b()) {
                    this.f32000c.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                    }
                }
            }
        }
    }

    public ObservableRepeat(Observable<T> observable, long j) {
        super(observable);
        this.f38046a = j;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        Object sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j = Long.MAX_VALUE;
        if (this.f38046a != Long.MAX_VALUE) {
            j = this.f38046a - 1;
        }
        new RepeatObserver(observer, j, sequentialDisposable, this.source).m32545a();
    }
}
