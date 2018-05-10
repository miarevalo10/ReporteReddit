package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    final SubscriptionList f41759a;
    final Action0 f41760b;

    final class FutureCompleter implements Subscription {
        final /* synthetic */ ScheduledAction f41753a;
        private final Future<?> f41754b;

        FutureCompleter(ScheduledAction scheduledAction, Future<?> future) {
            this.f41753a = scheduledAction;
            this.f41754b = future;
        }

        public final void mo7893c() {
            if (this.f41753a.get() != Thread.currentThread()) {
                this.f41754b.cancel(true);
            } else {
                this.f41754b.cancel(false);
            }
        }

        public final boolean mo7894d() {
            return this.f41754b.isCancelled();
        }
    }

    static final class Remover2 extends AtomicBoolean implements Subscription {
        final ScheduledAction f41755a;
        final SubscriptionList f41756b;

        public Remover2(ScheduledAction scheduledAction, SubscriptionList subscriptionList) {
            this.f41755a = scheduledAction;
            this.f41756b = subscriptionList;
        }

        public final boolean mo7894d() {
            return this.f41755a.mo7894d();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo7893c() {
            /*
            r4 = this;
            r0 = 0;
            r1 = 1;
            r0 = r4.compareAndSet(r0, r1);
            if (r0 == 0) goto L_0x002a;
        L_0x0008:
            r0 = r4.f41756b;
            r1 = r4.f41755a;
            r2 = r0.f41803b;
            if (r2 != 0) goto L_0x002a;
        L_0x0010:
            monitor-enter(r0);
            r2 = r0.f41802a;	 Catch:{ all -> 0x0027 }
            r3 = r0.f41803b;	 Catch:{ all -> 0x0027 }
            if (r3 != 0) goto L_0x0025;
        L_0x0017:
            if (r2 != 0) goto L_0x001a;
        L_0x0019:
            goto L_0x0025;
        L_0x001a:
            r2 = r2.remove(r1);	 Catch:{ all -> 0x0027 }
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x002a;
        L_0x0021:
            r1.mo7893c();
            goto L_0x002a;
        L_0x0025:
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            return;
        L_0x0027:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            throw r1;
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.schedulers.ScheduledAction.Remover2.c():void");
        }
    }

    static final class Remover extends AtomicBoolean implements Subscription {
        final ScheduledAction f41757a;
        final CompositeSubscription f41758b;

        public Remover(ScheduledAction scheduledAction, CompositeSubscription compositeSubscription) {
            this.f41757a = scheduledAction;
            this.f41758b = compositeSubscription;
        }

        public final boolean mo7894d() {
            return this.f41757a.mo7894d();
        }

        public final void mo7893c() {
            if (compareAndSet(false, true)) {
                this.f41758b.m43949b(this.f41757a);
            }
        }
    }

    public ScheduledAction(Action0 action0) {
        this.f41760b = action0;
        this.f41759a = new SubscriptionList();
    }

    public ScheduledAction(Action0 action0, CompositeSubscription compositeSubscription) {
        this.f41760b = action0;
        this.f41759a = new SubscriptionList(new Remover(this, compositeSubscription));
    }

    public ScheduledAction(Action0 action0, SubscriptionList subscriptionList) {
        this.f41760b = action0;
        this.f41759a = new SubscriptionList(new Remover2(this, subscriptionList));
    }

    public final void run() {
        try {
            lazySet(Thread.currentThread());
            this.f41760b.mo7898a();
        } catch (Throwable e) {
            m43868a(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
        } catch (Throwable e2) {
            m43868a(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", e2));
        } finally {
            mo7893c();
        }
    }

    private static void m43868a(Throwable th) {
        RxJavaHooks.m43500a(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public final boolean mo7894d() {
        return this.f41759a.f41803b;
    }

    public final void mo7893c() {
        if (!this.f41759a.f41803b) {
            this.f41759a.mo7893c();
        }
    }

    public final void m43869a(Future<?> future) {
        this.f41759a.m43910a(new FutureCompleter(this, future));
    }
}
