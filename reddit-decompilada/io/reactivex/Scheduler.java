package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
    static final long f24998a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class DisposeTask implements Disposable, Runnable {
        final Runnable f31080a;
        final Worker f31081b;
        Thread f31082c;

        DisposeTask(Runnable runnable, Worker worker) {
            this.f31080a = runnable;
            this.f31081b = worker;
        }

        public final void run() {
            this.f31082c = Thread.currentThread();
            try {
                this.f31080a.run();
            } finally {
                mo5626a();
                this.f31082c = null;
            }
        }

        public final void mo5626a() {
            if (this.f31082c == Thread.currentThread() && (this.f31081b instanceof NewThreadWorker)) {
                NewThreadWorker newThreadWorker = (NewThreadWorker) this.f31081b;
                if (!newThreadWorker.f35893c) {
                    newThreadWorker.f35893c = true;
                    newThreadWorker.f35892b.shutdown();
                }
                return;
            }
            this.f31081b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31081b.mo5627b();
        }
    }

    static class PeriodicDirectTask implements Disposable, Runnable {
        final Runnable f31083a;
        final Worker f31084b;
        volatile boolean f31085c;

        PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.f31083a = runnable;
            this.f31084b = worker;
        }

        public void run() {
            if (!this.f31085c) {
                try {
                    this.f31083a.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.f31084b.mo5626a();
                    RuntimeException a = ExceptionHelper.m26682a(th);
                }
            }
        }

        public final void mo5626a() {
            this.f31085c = true;
            this.f31084b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31085c;
        }
    }

    public static abstract class Worker implements Disposable {

        final class PeriodicTask implements Runnable {
            final Runnable f24991a;
            final SequentialDisposable f24992b;
            final long f24993c;
            long f24994d;
            long f24995e;
            long f24996f;
            final /* synthetic */ Worker f24997g;

            PeriodicTask(Worker worker, long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.f24997g = worker;
                this.f24991a = runnable;
                this.f24992b = sequentialDisposable;
                this.f24993c = j3;
                this.f24995e = j2;
                this.f24996f = j;
            }

            public final void run() {
                this.f24991a.run();
                if (!this.f24992b.mo5627b()) {
                    long j;
                    long j2;
                    long a = Worker.m32062a(TimeUnit.NANOSECONDS);
                    if (Scheduler.f24998a + a >= this.f24995e) {
                        if (a < (this.f24995e + this.f24993c) + Scheduler.f24998a) {
                            j = this.f24996f;
                            j2 = this.f24994d + 1;
                            this.f24994d = j2;
                            j += j2 * this.f24993c;
                            this.f24995e = a;
                            DisposableHelper.m32094c(this.f24992b, this.f24997g.mo6607a(this, j - a, TimeUnit.NANOSECONDS));
                        }
                    }
                    j = this.f24993c + a;
                    j2 = this.f24993c;
                    long j3 = this.f24994d + 1;
                    this.f24994d = j3;
                    this.f24996f = j - (j2 * j3);
                    this.f24995e = a;
                    DisposableHelper.m32094c(this.f24992b, this.f24997g.mo6607a(this, j - a, TimeUnit.NANOSECONDS));
                }
            }
        }

        public abstract Disposable mo6607a(Runnable runnable, long j, TimeUnit timeUnit);

        public Disposable mo6651a(Runnable runnable) {
            return mo6607a(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public Disposable mo6652a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            long j3 = j;
            TimeUnit timeUnit2 = timeUnit;
            Object sequentialDisposable = new SequentialDisposable();
            Disposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable a = RxJavaPlugins.m26754a(runnable);
            long toNanos = timeUnit2.toNanos(j2);
            long a2 = m32062a(TimeUnit.NANOSECONDS);
            Disposable a3 = mo6607a(new PeriodicTask(this, a2 + timeUnit2.toNanos(j3), a, a2, sequentialDisposable2, toNanos), j3, timeUnit2);
            if (a3 == EmptyDisposable.INSTANCE) {
                return a3;
            }
            DisposableHelper.m32094c(sequentialDisposable, a3);
            return sequentialDisposable2;
        }

        public static long m32062a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public abstract Worker mo5629a();

    public void mo5676b() {
    }

    public static long m26494a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable mo5677a(Runnable runnable) {
        return mo5630a(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public Disposable mo5630a(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker a = mo5629a();
        Object disposeTask = new DisposeTask(RxJavaPlugins.m26754a(runnable), a);
        a.mo6607a(disposeTask, j, timeUnit);
        return disposeTask;
    }

    public Disposable mo5675a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Worker a = mo5629a();
        Disposable periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.m26754a(runnable), a);
        runnable = a.mo6652a(periodicDirectTask, j, j2, timeUnit);
        return runnable == EmptyDisposable.INSTANCE ? runnable : periodicDirectTask;
    }
}
