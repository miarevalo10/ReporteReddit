package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.Log;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class GlideExecutor implements ExecutorService {
    private static final long f3479a = TimeUnit.SECONDS.toMillis(10);
    private static volatile int f3480b;
    private final ExecutorService f3481c;

    private static final class DefaultThreadFactory implements ThreadFactory {
        final UncaughtThrowableStrategy f3471a;
        final boolean f3472b;
        private final String f3473c;
        private int f3474d;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.f3473c = str;
            this.f3471a = uncaughtThrowableStrategy;
            this.f3472b = z;
        }

        public final synchronized Thread newThread(Runnable runnable) {
            Thread c02751;
            StringBuilder stringBuilder = new StringBuilder("glide-");
            stringBuilder.append(this.f3473c);
            stringBuilder.append("-thread-");
            stringBuilder.append(this.f3474d);
            c02751 = new Thread(this, runnable, stringBuilder.toString()) {
                final /* synthetic */ DefaultThreadFactory f3470a;

                public void run() {
                    Process.setThreadPriority(9);
                    if (this.f3470a.f3472b) {
                        StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        this.f3470a.f3471a.mo965a(th);
                    }
                }
            };
            this.f3474d++;
            return c02751;
        }
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy f3475a = new C10681();
        public static final UncaughtThrowableStrategy f3476b = new C10692();
        public static final UncaughtThrowableStrategy f3477c = new C10703();
        public static final UncaughtThrowableStrategy f3478d = f3476b;

        class C10681 implements UncaughtThrowableStrategy {
            public final void mo965a(Throwable th) {
            }

            C10681() {
            }
        }

        class C10692 implements UncaughtThrowableStrategy {
            C10692() {
            }

            public final void mo965a(Throwable th) {
                if (Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        class C10703 implements UncaughtThrowableStrategy {
            C10703() {
            }

            public final void mo965a(Throwable th) {
                throw new RuntimeException("Request threw uncaught throwable", th);
            }
        }

        void mo965a(Throwable th);
    }

    public static GlideExecutor m2979a() {
        return new GlideExecutor(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory("disk-cache", UncaughtThrowableStrategy.f3478d, true)));
    }

    public static GlideExecutor m2980b() {
        int e = m2983e();
        UncaughtThrowableStrategy uncaughtThrowableStrategy = UncaughtThrowableStrategy.f3478d;
        return new GlideExecutor(new ThreadPoolExecutor(e, e, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory("source", uncaughtThrowableStrategy, false)));
    }

    public static GlideExecutor m2981c() {
        return new GlideExecutor(new ThreadPoolExecutor(0, RedditJobManager.f10810d, f3479a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("source-unlimited", UncaughtThrowableStrategy.f3478d, false)));
    }

    public static GlideExecutor m2982d() {
        return new GlideExecutor(new ThreadPoolExecutor(0, m2983e() >= 4 ? 2 : 1, f3479a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory("animation", UncaughtThrowableStrategy.f3478d, true)));
    }

    private GlideExecutor(ExecutorService executorService) {
        this.f3481c = executorService;
    }

    public final void execute(Runnable runnable) {
        this.f3481c.execute(runnable);
    }

    public final Future<?> submit(Runnable runnable) {
        return this.f3481c.submit(runnable);
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f3481c.invokeAll(collection);
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f3481c.invokeAll(collection, j, timeUnit);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f3481c.invokeAny(collection);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f3481c.invokeAny(collection, j, timeUnit);
    }

    public final <T> Future<T> submit(Runnable runnable, T t) {
        return this.f3481c.submit(runnable, t);
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        return this.f3481c.submit(callable);
    }

    public final void shutdown() {
        this.f3481c.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.f3481c.shutdownNow();
    }

    public final boolean isShutdown() {
        return this.f3481c.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f3481c.isTerminated();
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f3481c.awaitTermination(j, timeUnit);
    }

    public final String toString() {
        return this.f3481c.toString();
    }

    private static int m2983e() {
        if (f3480b == 0) {
            f3480b = Math.min(4, RuntimeCompat.m2984a());
        }
        return f3480b;
    }
}
