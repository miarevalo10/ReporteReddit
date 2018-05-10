package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker extends Worker implements Disposable {
    public final ScheduledExecutorService f35892b;
    public volatile boolean f35893c;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f35892b = SchedulerPoolFactory.m26660a(threadFactory);
    }

    public final Disposable mo6651a(Runnable runnable) {
        return mo6607a(runnable, 0, null);
    }

    public final Disposable mo6607a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f35893c) {
            return EmptyDisposable.INSTANCE;
        }
        return m35980a(runnable, j, timeUnit, null);
    }

    public final Disposable m35983b(Runnable runnable, long j, TimeUnit timeUnit) {
        Disposable scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.m26754a(runnable));
        if (j <= 0) {
            try {
                runnable = this.f35892b.submit(scheduledDirectTask);
            } catch (Throwable e) {
                RxJavaPlugins.m26757a(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        runnable = this.f35892b.schedule(scheduledDirectTask, j, timeUnit);
        scheduledDirectTask.m32741a(runnable);
        return scheduledDirectTask;
    }

    public final Disposable m35982b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        runnable = RxJavaPlugins.m26754a(runnable);
        if (j2 <= 0) {
            j2 = new InstantPeriodicTask(runnable, this.f35892b);
            if (j <= 0) {
                try {
                    runnable = this.f35892b.submit(j2);
                } catch (Throwable e) {
                    RxJavaPlugins.m26757a(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            runnable = this.f35892b.schedule(j2, j, timeUnit);
            j2.m32753a(runnable);
            return j2;
        }
        Disposable scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable);
        try {
            scheduledDirectPeriodicTask.m32741a(this.f35892b.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (Throwable e2) {
            RxJavaPlugins.m26757a(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public final ScheduledRunnable m35980a(Runnable runnable, long j, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.m26754a(runnable), disposableContainer);
        if (disposableContainer != null && disposableContainer.mo5631a(scheduledRunnable) == null) {
            return scheduledRunnable;
        }
        if (j <= 0) {
            try {
                runnable = this.f35892b.submit(scheduledRunnable);
            } catch (Throwable e) {
                if (disposableContainer != null) {
                    disposableContainer.mo5632b(scheduledRunnable);
                }
                RxJavaPlugins.m26757a(e);
            }
        } else {
            runnable = this.f35892b.schedule(scheduledRunnable, j, timeUnit);
        }
        scheduledRunnable.m32759a(runnable);
        return scheduledRunnable;
    }

    public final void mo5626a() {
        if (!this.f35893c) {
            this.f35893c = true;
            this.f35892b.shutdownNow();
        }
    }

    public final boolean mo5627b() {
        return this.f35893c;
    }
}
