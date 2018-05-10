package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final ThreadFactory f41363a = new C30741();
    final String f41364b;

    static class C30741 implements ThreadFactory {
        C30741() {
        }

        public final Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    }

    public RxThreadFactory(String str) {
        this.f41364b = str;
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f41364b);
        stringBuilder.append(incrementAndGet());
        Thread thread = new Thread(runnable, stringBuilder.toString());
        thread.setDaemon(true);
        return thread;
    }
}
