package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler extends Scheduler {
    private static final TrampolineScheduler f32445b = new TrampolineScheduler();

    static final class SleepingRunnable implements Runnable {
        private final Runnable f25170a;
        private final TrampolineWorker f25171b;
        private final long f25172c;

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j) {
            this.f25170a = runnable;
            this.f25171b = trampolineWorker;
            this.f25172c = j;
        }

        public final void run() {
            if (!this.f25171b.f35899c) {
                long a = Worker.m32062a(TimeUnit.MILLISECONDS);
                if (this.f25172c > a) {
                    long j = this.f25172c - a;
                    if (j > 0) {
                        try {
                            Thread.sleep(j);
                        } catch (Throwable e) {
                            Thread.currentThread().interrupt();
                            RxJavaPlugins.m26757a(e);
                            return;
                        }
                    }
                }
                if (!this.f25171b.f35899c) {
                    this.f25170a.run();
                }
            }
        }
    }

    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final Runnable f25173a;
        final long f25174b;
        final int f25175c;
        volatile boolean f25176d;

        public final /* synthetic */ int compareTo(Object obj) {
            TimedRunnable timedRunnable = (TimedRunnable) obj;
            int a = ObjectHelper.m26570a(this.f25174b, timedRunnable.f25174b);
            return a == 0 ? ObjectHelper.m26568a(this.f25175c, timedRunnable.f25175c) : a;
        }

        TimedRunnable(Runnable runnable, Long l, int i) {
            this.f25173a = runnable;
            this.f25174b = l.longValue();
            this.f25175c = i;
        }
    }

    static final class TrampolineWorker extends Worker implements Disposable {
        final PriorityBlockingQueue<TimedRunnable> f35897a = new PriorityBlockingQueue();
        final AtomicInteger f35898b = new AtomicInteger();
        volatile boolean f35899c;
        private final AtomicInteger f35900d = new AtomicInteger();

        final class AppendToQueueTask implements Runnable {
            final TimedRunnable f25177a;
            final /* synthetic */ TrampolineWorker f25178b;

            AppendToQueueTask(TrampolineWorker trampolineWorker, TimedRunnable timedRunnable) {
                this.f25178b = trampolineWorker;
                this.f25177a = timedRunnable;
            }

            public final void run() {
                this.f25177a.f25176d = true;
                this.f25178b.f35897a.remove(this.f25177a);
            }
        }

        TrampolineWorker() {
        }

        public final Disposable mo6651a(Runnable runnable) {
            return m35989a(runnable, Worker.m32062a(TimeUnit.MILLISECONDS));
        }

        public final Disposable mo6607a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a = Worker.m32062a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return m35989a(new SleepingRunnable(runnable, this, a), a);
        }

        private Disposable m35989a(Runnable runnable, long j) {
            if (this.f35899c) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j), this.f35898b.incrementAndGet());
            this.f35897a.add(timedRunnable);
            if (this.f35900d.getAndIncrement() != null) {
                return Disposables.m26513a(new AppendToQueueTask(this, timedRunnable));
            }
            runnable = true;
            while (this.f35899c == null) {
                TimedRunnable timedRunnable2 = (TimedRunnable) this.f35897a.poll();
                if (timedRunnable2 == null) {
                    runnable = this.f35900d.addAndGet(-runnable);
                    if (runnable == null) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!timedRunnable2.f25176d) {
                    timedRunnable2.f25173a.run();
                }
            }
            this.f35897a.clear();
            return EmptyDisposable.INSTANCE;
        }

        public final void mo5626a() {
            this.f35899c = true;
        }

        public final boolean mo5627b() {
            return this.f35899c;
        }
    }

    public static TrampolineScheduler m32765c() {
        return f32445b;
    }

    public final Worker mo5629a() {
        return new TrampolineWorker();
    }

    TrampolineScheduler() {
    }

    public final Disposable mo5677a(Runnable runnable) {
        RxJavaPlugins.m26754a(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public final Disposable mo5630a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            RxJavaPlugins.m26754a(runnable).run();
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.m26757a(e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
