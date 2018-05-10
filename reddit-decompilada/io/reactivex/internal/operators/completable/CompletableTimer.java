package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer extends Completable {
    final long f34783a;
    final TimeUnit f34784b;
    final Scheduler f34785c;

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        final CompletableObserver f31234a;

        TimerDisposable(CompletableObserver completableObserver) {
            this.f31234a = completableObserver;
        }

        public final void run() {
            this.f31234a.onComplete();
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public CompletableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f34783a = j;
        this.f34784b = timeUnit;
        this.f34785c = scheduler;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        AtomicReference timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        DisposableHelper.m32094c(timerDisposable, this.f34785c.mo5630a(timerDisposable, this.f34783a, this.f34784b));
    }
}
