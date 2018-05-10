package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimer extends Observable<Long> {
    final Scheduler f35739a;
    final long f35740b;
    final TimeUnit f35741c;

    static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        final Observer<? super Long> f32240a;

        TimerObserver(Observer<? super Long> observer) {
            this.f32240a = observer;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return get() == DisposableHelper.f31095a;
        }

        public final void run() {
            if (!mo5627b()) {
                this.f32240a.onNext(Long.valueOf(0));
                lazySet(EmptyDisposable.INSTANCE);
                this.f32240a.onComplete();
            }
        }
    }

    public ObservableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f35740b = j;
        this.f35741c = timeUnit;
        this.f35739a = scheduler;
    }

    public final void subscribeActual(Observer<? super Long> observer) {
        AtomicReference timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        DisposableHelper.m32095d(timerObserver, this.f35739a.mo5630a(timerObserver, this.f35740b, this.f35741c));
    }
}
