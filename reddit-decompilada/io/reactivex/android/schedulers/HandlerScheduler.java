package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {
    private final Handler f31090b;

    private static final class ScheduledRunnable implements Disposable, Runnable {
        private final Handler f31087a;
        private final Runnable f31088b;
        private volatile boolean f31089c;

        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.f31087a = handler;
            this.f31088b = runnable;
        }

        public final void run() {
            try {
                this.f31088b.run();
            } catch (Throwable th) {
                Throwable illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                RxJavaPlugins.m26757a(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        public final void mo5626a() {
            this.f31089c = true;
            this.f31087a.removeCallbacks(this);
        }

        public final boolean mo5627b() {
            return this.f31089c;
        }
    }

    private static final class HandlerWorker extends Worker {
        private final Handler f34700a;
        private volatile boolean f34701b;

        HandlerWorker(Handler handler) {
            this.f34700a = handler;
        }

        public final Disposable mo6607a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f34701b) {
                return Disposables.m26514b();
            } else {
                Object scheduledRunnable = new ScheduledRunnable(this.f34700a, RxJavaPlugins.m26754a(runnable));
                runnable = Message.obtain(this.f34700a, scheduledRunnable);
                runnable.obj = this;
                this.f34700a.sendMessageDelayed(runnable, Math.max(0, timeUnit.toMillis(j)));
                if (this.f34701b == null) {
                    return scheduledRunnable;
                }
                this.f34700a.removeCallbacks(scheduledRunnable);
                return Disposables.m26514b();
            }
        }

        public final void mo5626a() {
            this.f34701b = true;
            this.f34700a.removeCallbacksAndMessages(this);
        }

        public final boolean mo5627b() {
            return this.f34701b;
        }
    }

    HandlerScheduler(Handler handler) {
        this.f31090b = handler;
    }

    public final Disposable mo5630a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        } else {
            Object scheduledRunnable = new ScheduledRunnable(this.f31090b, RxJavaPlugins.m26754a(runnable));
            this.f31090b.postDelayed(scheduledRunnable, Math.max(0, timeUnit.toMillis(j)));
            return scheduledRunnable;
        }
    }

    public final Worker mo5629a() {
        return new HandlerWorker(this.f31090b);
    }
}
