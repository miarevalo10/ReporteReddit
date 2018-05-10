package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public final class CompletableDelay extends Completable {
    final CompletableSource f34722a;
    final long f34723b;
    final TimeUnit f34724c;
    final Scheduler f34725d;
    final boolean f34726e;

    final class Delay implements CompletableObserver {
        final CompletableObserver f31186a;
        final /* synthetic */ CompletableDelay f31187b;
        private final CompositeDisposable f31188c;

        final class OnComplete implements Runnable {
            final /* synthetic */ Delay f25025a;

            OnComplete(Delay delay) {
                this.f25025a = delay;
            }

            public final void run() {
                this.f25025a.f31186a.onComplete();
            }
        }

        final class OnError implements Runnable {
            final /* synthetic */ Delay f25026a;
            private final Throwable f25027b;

            OnError(Delay delay, Throwable th) {
                this.f25026a = delay;
                this.f25027b = th;
            }

            public final void run() {
                this.f25026a.f31186a.onError(this.f25027b);
            }
        }

        Delay(CompletableDelay completableDelay, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f31187b = completableDelay;
            this.f31188c = compositeDisposable;
            this.f31186a = completableObserver;
        }

        public final void onComplete() {
            this.f31188c.mo5631a(this.f31187b.f34725d.mo5630a(new OnComplete(this), this.f31187b.f34723b, this.f31187b.f34724c));
        }

        public final void onError(Throwable th) {
            this.f31188c.mo5631a(this.f31187b.f34725d.mo5630a(new OnError(this, th), this.f31187b.f34726e != null ? this.f31187b.f34723b : 0, this.f31187b.f34724c));
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31188c.mo5631a(disposable);
            this.f31186a.onSubscribe(this.f31188c);
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f34722a = completableSource;
        this.f34723b = j;
        this.f34724c = timeUnit;
        this.f34725d = scheduler;
        this.f34726e = z;
    }

    protected final void subscribeActual(CompletableObserver completableObserver) {
        this.f34722a.subscribe(new Delay(this, new CompositeDisposable(), completableObserver));
    }
}
