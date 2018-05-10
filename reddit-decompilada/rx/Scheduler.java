package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;

public abstract class Scheduler {
    static final long f41303a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public static abstract class Worker implements Subscription {
        public abstract Subscription mo7927a(Action0 action0);

        public abstract Subscription mo7928a(Action0 action0, long j, TimeUnit timeUnit);

        public static long m43804b() {
            return System.currentTimeMillis();
        }
    }

    public abstract Worker mo7895a();

    public static long m43414b() {
        return System.currentTimeMillis();
    }
}
