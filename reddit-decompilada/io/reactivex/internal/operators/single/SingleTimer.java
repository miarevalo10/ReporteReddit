package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimer extends Single<Long> {
    final long f35850a;
    final TimeUnit f35851b;
    final Scheduler f35852c;

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        final SingleObserver<? super Long> f32390a;

        TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.f32390a = singleObserver;
        }

        public final void run() {
            this.f32390a.onSuccess(Long.valueOf(0));
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f35850a = j;
        this.f35851b = timeUnit;
        this.f35852c = scheduler;
    }

    protected final void subscribeActual(SingleObserver<? super Long> singleObserver) {
        AtomicReference timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        DisposableHelper.m32094c(timerDisposable, this.f35852c.mo5630a(timerDisposable, this.f35850a, this.f35851b));
    }
}
