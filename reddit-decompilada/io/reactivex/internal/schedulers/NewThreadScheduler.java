package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler extends Scheduler {
    private static final RxThreadFactory f32434c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory f32435b;

    public NewThreadScheduler() {
        this(f32434c);
    }

    private NewThreadScheduler(ThreadFactory threadFactory) {
        this.f32435b = threadFactory;
    }

    public final Worker mo5629a() {
        return new NewThreadWorker(this.f32435b);
    }
}
