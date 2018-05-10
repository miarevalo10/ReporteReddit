package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {
    static final RxThreadFactory f32441d = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    static final ScheduledExecutorService f32442e;
    final ThreadFactory f32443b;
    final AtomicReference<ScheduledExecutorService> f32444c;

    static final class ScheduledWorker extends Worker {
        final ScheduledExecutorService f35894a;
        final CompositeDisposable f35895b = new CompositeDisposable();
        volatile boolean f35896c;

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.f35894a = scheduledExecutorService;
        }

        public final Disposable mo6607a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f35896c) {
                return EmptyDisposable.INSTANCE;
            }
            Disposable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.m26754a(runnable), this.f35895b);
            this.f35895b.mo5631a(scheduledRunnable);
            if (j <= 0) {
                try {
                    runnable = this.f35894a.submit(scheduledRunnable);
                } catch (Throwable e) {
                    mo5626a();
                    RxJavaPlugins.m26757a(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            runnable = this.f35894a.schedule(scheduledRunnable, j, timeUnit);
            scheduledRunnable.m32759a(runnable);
            return scheduledRunnable;
        }

        public final void mo5626a() {
            if (!this.f35896c) {
                this.f35896c = true;
                this.f35895b.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return this.f35896c;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f32442e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(f32441d);
    }

    private SingleScheduler(ThreadFactory threadFactory) {
        this.f32444c = new AtomicReference();
        this.f32443b = threadFactory;
        this.f32444c.lazySet(SchedulerPoolFactory.m26660a(threadFactory));
    }

    public final void mo5676b() {
        ScheduledExecutorService scheduledExecutorService = null;
        ScheduledExecutorService scheduledExecutorService2;
        do {
            scheduledExecutorService2 = (ScheduledExecutorService) this.f32444c.get();
            if (scheduledExecutorService2 != f32442e) {
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
                return;
            } else if (scheduledExecutorService == null) {
                scheduledExecutorService = SchedulerPoolFactory.m26660a(this.f32443b);
            }
        } while (!this.f32444c.compareAndSet(scheduledExecutorService2, scheduledExecutorService));
    }

    public final Worker mo5629a() {
        return new ScheduledWorker((ScheduledExecutorService) this.f32444c.get());
    }

    public final Disposable mo5630a(Runnable runnable, long j, TimeUnit timeUnit) {
        Disposable scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.m26754a(runnable));
        if (j <= 0) {
            try {
                runnable = ((ScheduledExecutorService) this.f32444c.get()).submit(scheduledDirectTask);
            } catch (Throwable e) {
                RxJavaPlugins.m26757a(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        runnable = ((ScheduledExecutorService) this.f32444c.get()).schedule(scheduledDirectTask, j, timeUnit);
        scheduledDirectTask.m32741a(runnable);
        return scheduledDirectTask;
    }

    public final Disposable mo5675a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        runnable = RxJavaPlugins.m26754a(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f32444c.get();
            Disposable instantPeriodicTask = new InstantPeriodicTask(runnable, scheduledExecutorService);
            if (j <= 0) {
                try {
                    runnable = scheduledExecutorService.submit(instantPeriodicTask);
                } catch (Throwable e) {
                    RxJavaPlugins.m26757a(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            runnable = scheduledExecutorService.schedule(instantPeriodicTask, j, timeUnit);
            instantPeriodicTask.m32753a(runnable);
            return instantPeriodicTask;
        }
        Disposable scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnable);
        try {
            scheduledDirectPeriodicTask.m32741a(((ScheduledExecutorService) this.f32444c.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (Throwable e2) {
            RxJavaPlugins.m26757a(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
