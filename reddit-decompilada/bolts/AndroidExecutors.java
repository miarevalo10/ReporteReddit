package bolts;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AndroidExecutors {
    static final int f2687a;
    static final int f2688b = ((f2690e * 2) + 1);
    private static final AndroidExecutors f2689c = new AndroidExecutors();
    private static final int f2690e;
    private final Executor f2691d = new UIThreadExecutor();

    private static class UIThreadExecutor implements Executor {
        private UIThreadExecutor() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f2690e = availableProcessors;
        f2687a = availableProcessors + 1;
    }

    private AndroidExecutors() {
    }

    public static ExecutorService m2397a() {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(f2687a, f2688b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return threadPoolExecutor;
    }

    public static Executor m2398b() {
        return f2689c.f2691d;
    }
}
