package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class BoltsExecutors {
    private static final BoltsExecutors f2693a = new BoltsExecutors();
    private final ExecutorService f2694b;
    private final ScheduledExecutorService f2695c;
    private final Executor f2696d;

    private static class ImmediateExecutor implements Executor {
        private ThreadLocal<Integer> f2692a;

        private ImmediateExecutor() {
            this.f2692a = new ThreadLocal();
        }

        private int m2399a() {
            Integer num = (Integer) this.f2692a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f2692a.remove();
            } else {
                this.f2692a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            Integer num = (Integer) this.f2692a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() + 1;
            this.f2692a.set(Integer.valueOf(intValue));
            if (intValue <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    m2399a();
                }
            } else {
                BoltsExecutors.m2400a().execute(runnable);
            }
            m2399a();
        }
    }

    private BoltsExecutors() {
        boolean z;
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            z = false;
        } else {
            z = property.toLowerCase(Locale.US).contains("android");
        }
        this.f2694b = !z ? Executors.newCachedThreadPool() : AndroidExecutors.m2397a();
        this.f2695c = Executors.newSingleThreadScheduledExecutor();
        this.f2696d = new ImmediateExecutor();
    }

    public static ExecutorService m2400a() {
        return f2693a.f2694b;
    }

    static Executor m2401b() {
        return f2693a.f2696d;
    }
}
