package rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.Subscriptions;

class LooperScheduler extends Scheduler {
    private final Handler f41666b;

    static final class ScheduledAction implements Runnable, Subscription {
        private final Action0 f41663a;
        private final Handler f41664b;
        private volatile boolean f41665c;

        ScheduledAction(Action0 action0, Handler handler) {
            this.f41663a = action0;
            this.f41664b = handler;
        }

        public final void run() {
            try {
                this.f41663a.mo7898a();
            } catch (Throwable th) {
                Throwable illegalStateException;
                if (th instanceof OnErrorNotImplementedException) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                }
                RxJavaPlugins.m43511a().m43512b();
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        public final void mo7893c() {
            this.f41665c = true;
            this.f41664b.removeCallbacks(this);
        }

        public final boolean mo7894d() {
            return this.f41665c;
        }
    }

    static class HandlerWorker extends Worker {
        private final Handler f41862a;
        private final RxAndroidSchedulersHook f41863b = RxAndroidPlugins.m43418a().m43419b();
        private volatile boolean f41864c;

        HandlerWorker(Handler handler) {
            this.f41862a = handler;
        }

        public final void mo7893c() {
            this.f41864c = true;
            this.f41862a.removeCallbacksAndMessages(this);
        }

        public final boolean mo7894d() {
            return this.f41864c;
        }

        public final Subscription mo7928a(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f41864c) {
                return Subscriptions.m43536a();
            }
            Object scheduledAction = new ScheduledAction(RxAndroidSchedulersHook.m43421a(action0), this.f41862a);
            action0 = Message.obtain(this.f41862a, scheduledAction);
            action0.obj = this;
            this.f41862a.sendMessageDelayed(action0, timeUnit.toMillis(j));
            if (this.f41864c == null) {
                return scheduledAction;
            }
            this.f41862a.removeCallbacks(scheduledAction);
            return Subscriptions.m43536a();
        }

        public final Subscription mo7927a(Action0 action0) {
            return mo7928a(action0, 0, TimeUnit.MILLISECONDS);
        }
    }

    LooperScheduler(Looper looper) {
        this.f41666b = new Handler(looper);
    }

    public final Worker mo7895a() {
        return new HandlerWorker(this.f41666b);
    }
}
