package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {
    final Scheduler f38099a;
    final TimeUnit f38100b;

    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Timed<T>> f32206a;
        final TimeUnit f32207b;
        final Scheduler f32208c;
        long f32209d;
        Disposable f32210e;

        TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.f32206a = observer;
            this.f32208c = scheduler;
            this.f32207b = timeUnit;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32210e, disposable)) {
                this.f32210e = disposable;
                this.f32209d = Scheduler.m26494a(this.f32207b);
                this.f32206a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f32210e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32210e.mo5627b();
        }

        public final void onNext(T t) {
            long a = Scheduler.m26494a(this.f32207b);
            long j = this.f32209d;
            this.f32209d = a;
            this.f32206a.onNext(new Timed(t, a - j, this.f32207b));
        }

        public final void onError(Throwable th) {
            this.f32206a.onError(th);
        }

        public final void onComplete() {
            this.f32206a.onComplete();
        }
    }

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f38099a = scheduler;
        this.f38100b = timeUnit;
    }

    public final void subscribeActual(Observer<? super Timed<T>> observer) {
        this.source.subscribe(new TimeIntervalObserver(observer, this.f38100b, this.f38099a));
    }
}
