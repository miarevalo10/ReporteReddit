package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    public final /* synthetic */ Object call() throws Exception {
        return m35985c();
    }

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    private Void m35985c() throws Exception {
        this.b = Thread.currentThread();
        try {
            this.a.run();
            return null;
        } finally {
            lazySet(c);
            this.b = null;
        }
    }
}
