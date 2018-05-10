package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimer extends Maybe<Long> {
    final long f35606a;
    final TimeUnit f35607b;
    final Scheduler f35608c;

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        final MaybeObserver<? super Long> f31536a;

        TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
            this.f31536a = maybeObserver;
        }

        public final void run() {
            this.f31536a.onSuccess(Long.valueOf(0));
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public MaybeTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f35606a = j;
        this.f35607b = timeUnit;
        this.f35608c = scheduler;
    }

    protected final void subscribeActual(MaybeObserver<? super Long> maybeObserver) {
        AtomicReference timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.onSubscribe(timerDisposable);
        DisposableHelper.m32094c(timerDisposable, this.f35608c.mo5630a(timerDisposable, this.f35606a, this.f35607b));
    }
}
