package io.reactivex.internal.schedulers;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public final void run() {
        this.b = Thread.currentThread();
        try {
            this.a.run();
        } catch (Throwable th) {
            this.b = null;
        }
        this.b = null;
    }
}
