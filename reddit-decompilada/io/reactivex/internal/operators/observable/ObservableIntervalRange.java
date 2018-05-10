package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableIntervalRange extends Observable<Long> {
    final Scheduler f35690a;
    final long f35691b;
    final long f35692c;
    final long f35693d;
    final long f35694e;
    final TimeUnit f35695f;

    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        final Observer<? super Long> f31900a;
        final long f31901b;
        long f31902c;

        IntervalRangeObserver(Observer<? super Long> observer, long j, long j2) {
            this.f31900a = observer;
            this.f31902c = j;
            this.f31901b = j2;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return get() == DisposableHelper.f31095a;
        }

        public final void run() {
            if (!mo5627b()) {
                long j = this.f31902c;
                this.f31900a.onNext(Long.valueOf(j));
                if (j == this.f31901b) {
                    DisposableHelper.m32090a((AtomicReference) this);
                    this.f31900a.onComplete();
                    return;
                }
                this.f31902c = j + 1;
            }
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.f35693d = j3;
        this.f35694e = j4;
        this.f35695f = timeUnit;
        this.f35690a = scheduler;
        this.f35691b = j;
        this.f35692c = j2;
    }

    public final void subscribeActual(Observer<? super Long> observer) {
        AtomicReference intervalRangeObserver = new IntervalRangeObserver(observer, this.f35691b, this.f35692c);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.f35690a;
        if ((scheduler instanceof TrampolineScheduler) != null) {
            Object a = scheduler.mo5629a();
            DisposableHelper.m32092b(intervalRangeObserver, a);
            a.mo6652a(intervalRangeObserver, this.f35693d, this.f35694e, this.f35695f);
            return;
        }
        DisposableHelper.m32092b(intervalRangeObserver, scheduler.mo5675a(intervalRangeObserver, this.f35693d, this.f35694e, this.f35695f));
    }
}
