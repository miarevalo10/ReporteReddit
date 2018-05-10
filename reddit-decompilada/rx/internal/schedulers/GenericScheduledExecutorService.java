package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

public final class GenericScheduledExecutorService implements SchedulerLifecycle {
    public static final GenericScheduledExecutorService f41746a = new GenericScheduledExecutorService();
    private static final ScheduledExecutorService[] f41747b = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService f41748c;
    private static int f41749e;
    private final AtomicReference<ScheduledExecutorService[]> f41750d = new AtomicReference(f41747b);

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f41748c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    private GenericScheduledExecutorService() {
        m43858b();
    }

    private void m43858b() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        Object obj = new ScheduledExecutorService[availableProcessors];
        int i = 0;
        for (int i2 = 0; i2 < availableProcessors; i2++) {
            obj[i2] = GenericScheduledExecutorServiceFactory.m43463a();
        }
        if (this.f41750d.compareAndSet(f41747b, obj)) {
            availableProcessors = obj.length;
            while (i < availableProcessors) {
                ScheduledExecutorService scheduledExecutorService = obj[i];
                if (!NewThreadWorker.m44109b(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    NewThreadWorker.m44108a((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i++;
            }
            return;
        }
        availableProcessors = obj.length;
        while (i < availableProcessors) {
            obj[i].shutdownNow();
            i++;
        }
    }

    public final void mo7903c() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        do {
            scheduledExecutorServiceArr = (ScheduledExecutorService[]) this.f41750d.get();
            if (scheduledExecutorServiceArr == f41747b) {
                return;
            }
        } while (!this.f41750d.compareAndSet(scheduledExecutorServiceArr, f41747b));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            NewThreadWorker.m44107a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    public static ScheduledExecutorService m43857a() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = (ScheduledExecutorService[]) f41746a.f41750d.get();
        if (scheduledExecutorServiceArr == f41747b) {
            return f41748c;
        }
        int i = f41749e + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        f41749e = i;
        return scheduledExecutorServiceArr[i];
    }
}
