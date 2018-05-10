package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableTimeout extends Completable {
    final CompletableSource f34778a;
    final long f34779b;
    final TimeUnit f34780c;
    final Scheduler f34781d;
    final CompletableSource f34782e;

    final class DisposeTask implements Runnable {
        final CompositeDisposable f25028a;
        final CompletableObserver f25029b;
        final /* synthetic */ CompletableTimeout f25030c;
        private final AtomicBoolean f25031d;

        final class DisposeObserver implements CompletableObserver {
            final /* synthetic */ DisposeTask f31230a;

            DisposeObserver(DisposeTask disposeTask) {
                this.f31230a = disposeTask;
            }

            public final void onSubscribe(Disposable disposable) {
                this.f31230a.f25028a.mo5631a(disposable);
            }

            public final void onError(Throwable th) {
                this.f31230a.f25028a.mo5626a();
                this.f31230a.f25029b.onError(th);
            }

            public final void onComplete() {
                this.f31230a.f25028a.mo5626a();
                this.f31230a.f25029b.onComplete();
            }
        }

        DisposeTask(CompletableTimeout completableTimeout, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f25030c = completableTimeout;
            this.f25031d = atomicBoolean;
            this.f25028a = compositeDisposable;
            this.f25029b = completableObserver;
        }

        public final void run() {
            if (this.f25031d.compareAndSet(false, true)) {
                this.f25028a.m32077c();
                if (this.f25030c.f34782e == null) {
                    this.f25029b.onError(new TimeoutException());
                    return;
                }
                this.f25030c.f34782e.subscribe(new DisposeObserver(this));
            }
        }
    }

    static final class TimeOutObserver implements CompletableObserver {
        private final CompositeDisposable f31231a;
        private final AtomicBoolean f31232b;
        private final CompletableObserver f31233c;

        TimeOutObserver(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.f31231a = compositeDisposable;
            this.f31232b = atomicBoolean;
            this.f31233c = completableObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31231a.mo5631a(disposable);
        }

        public final void onError(Throwable th) {
            if (this.f31232b.compareAndSet(false, true)) {
                this.f31231a.mo5626a();
                this.f31233c.onError(th);
                return;
            }
            RxJavaPlugins.m26757a(th);
        }

        public final void onComplete() {
            if (this.f31232b.compareAndSet(false, true)) {
                this.f31231a.mo5626a();
                this.f31233c.onComplete();
            }
        }
    }

    public CompletableTimeout(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.f34778a = completableSource;
        this.f34779b = j;
        this.f34780c = timeUnit;
        this.f34781d = scheduler;
        this.f34782e = completableSource2;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.mo5631a(this.f34781d.mo5630a(new DisposeTask(this, atomicBoolean, compositeDisposable, completableObserver), this.f34779b, this.f34780c));
        this.f34778a.subscribe(new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }
}
