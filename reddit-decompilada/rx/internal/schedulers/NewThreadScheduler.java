package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.Scheduler;
import rx.Scheduler.Worker;

public final class NewThreadScheduler extends Scheduler {
    private final ThreadFactory f41752b;

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f41752b = threadFactory;
    }

    public final Worker mo7895a() {
        return new NewThreadWorker(this.f41752b);
    }
}
