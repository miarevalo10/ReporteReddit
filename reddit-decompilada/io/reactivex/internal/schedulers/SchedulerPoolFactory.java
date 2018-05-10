package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory {
    public static final boolean f25166a;
    public static final int f25167b;
    static final AtomicReference<ScheduledExecutorService> f25168c = new AtomicReference();
    static final Map<ScheduledThreadPoolExecutor, Object> f25169d = new ConcurrentHashMap();

    static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        public final void run() {
            try {
                Iterator it = new ArrayList(SchedulerPoolFactory.f25169d.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        SchedulerPoolFactory.f25169d.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        int i = 1;
        boolean z = properties.containsKey("rx2.purge-enabled") ? Boolean.getBoolean("rx2.purge-enabled") : true;
        if (z && properties.containsKey("rx2.purge-period-seconds")) {
            i = Integer.getInteger("rx2.purge-period-seconds", 1).intValue();
        }
        f25166a = z;
        f25167b = i;
        m26661a();
    }

    private static void m26661a() {
        if (f25166a) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) f25168c.get();
                if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (f25168c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        newScheduledThreadPool.scheduleAtFixedRate(new ScheduledTask(), (long) f25167b, (long) f25167b, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    public static ScheduledExecutorService m26660a(ThreadFactory threadFactory) {
        threadFactory = Executors.newScheduledThreadPool(1, threadFactory);
        if (f25166a && (threadFactory instanceof ScheduledThreadPoolExecutor)) {
            f25169d.put((ScheduledThreadPoolExecutor) threadFactory, threadFactory);
        }
        return threadFactory;
    }
}
