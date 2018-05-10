package rx.internal.schedulers;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.util.PlatformDependent;
import rx.internal.util.RxThreadFactory;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.Subscriptions;

public class NewThreadWorker extends Worker implements Subscription {
    private static final boolean f42008a;
    public static final int f42009d = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f42010e = new ConcurrentHashMap();
    private static final AtomicReference<ScheduledExecutorService> f42011f = new AtomicReference();
    private static volatile Object f42012g;
    private static final Object f42013h = new Object();
    final ScheduledExecutorService f42014b;
    volatile boolean f42015c;

    static class C30711 implements Runnable {
        C30711() {
        }

        public final void run() {
            NewThreadWorker.m44106a();
        }
    }

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int b = PlatformDependent.m43471b();
        z = !z && (b == 0 || b >= 21);
        f42008a = z;
    }

    public static void m44108a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (((ScheduledExecutorService) f42011f.get()) == null) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (f42011f.compareAndSet(null, newScheduledThreadPool)) {
                newScheduledThreadPool.scheduleAtFixedRate(new C30711(), (long) f42009d, (long) f42009d, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f42010e.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static void m44107a(ScheduledExecutorService scheduledExecutorService) {
        f42010e.remove(scheduledExecutorService);
    }

    static void m44106a() {
        try {
            Iterator it = f42010e.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    it.remove();
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        } catch (Throwable th) {
            Exceptions.m43435b(th);
            RxJavaHooks.m43500a(th);
        }
    }

    public static boolean m44109b(ScheduledExecutorService scheduledExecutorService) {
        if (f42008a) {
            Method c;
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f42012g;
                if (obj == f42013h) {
                    return false;
                }
                if (obj == null) {
                    Object obj2;
                    c = m44110c(scheduledExecutorService);
                    if (c != null) {
                        obj2 = c;
                    } else {
                        obj2 = f42013h;
                    }
                    f42012g = obj2;
                } else {
                    c = (Method) obj;
                }
            } else {
                c = m44110c(scheduledExecutorService);
            }
            if (c != null) {
                try {
                    c.invoke(scheduledExecutorService, new Object[]{Boolean.valueOf(true)});
                    return true;
                } catch (Throwable e) {
                    RxJavaHooks.m43500a(e);
                } catch (Throwable e2) {
                    RxJavaHooks.m43500a(e2);
                } catch (Throwable e22) {
                    RxJavaHooks.m43500a(e22);
                }
            }
        }
        return false;
    }

    private static Method m44110c(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public NewThreadWorker(ThreadFactory threadFactory) {
        threadFactory = Executors.newScheduledThreadPool(1, threadFactory);
        if (!m44109b(threadFactory) && (threadFactory instanceof ScheduledThreadPoolExecutor)) {
            m44108a((ScheduledThreadPoolExecutor) threadFactory);
        }
        this.f42014b = threadFactory;
    }

    public final Subscription mo7927a(Action0 action0) {
        return mo7928a(action0, 0, null);
    }

    public final Subscription mo7928a(Action0 action0, long j, TimeUnit timeUnit) {
        if (this.f42015c) {
            return Subscriptions.m43536a();
        }
        return m44113b(action0, j, timeUnit);
    }

    public final ScheduledAction m44113b(Action0 action0, long j, TimeUnit timeUnit) {
        Future submit;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.m43498a(action0));
        if (j <= 0) {
            submit = this.f42014b.submit(scheduledAction);
        } else {
            submit = this.f42014b.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.m43869a(submit);
        return scheduledAction;
    }

    public final void mo7893c() {
        this.f42015c = true;
        this.f42014b.shutdownNow();
        m44107a(this.f42014b);
    }

    public final boolean mo7894d() {
        return this.f42015c;
    }
}
