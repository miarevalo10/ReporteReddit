package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval extends Observable<Long> {
    final Scheduler f35686a;
    final long f35687b;
    final long f35688c;
    final TimeUnit f35689d;

    static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        final Observer<? super Long> f31898a;
        long f31899b;

        IntervalObserver(Observer<? super Long> observer) {
            this.f31898a = observer;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return get() == DisposableHelper.f31095a;
        }

        public final void run() {
            if (get() != DisposableHelper.f31095a) {
                Observer observer = this.f31898a;
                long j = this.f31899b;
                this.f31899b = 1 + j;
                observer.onNext(Long.valueOf(j));
            }
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f35687b = j;
        this.f35688c = j2;
        this.f35689d = timeUnit;
        this.f35686a = scheduler;
    }

    public final void subscribeActual(Observer<? super Long> observer) {
        AtomicReference intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        Scheduler scheduler = this.f35686a;
        if ((scheduler instanceof TrampolineScheduler) != null) {
            Object a = scheduler.mo5629a();
            DisposableHelper.m32092b(intervalObserver, a);
            a.mo6652a(intervalObserver, this.f35687b, this.f35688c, this.f35689d);
            return;
        }
        DisposableHelper.m32092b(intervalObserver, scheduler.mo5675a(intervalObserver, this.f35687b, this.f35688c, this.f35689d));
    }
}
