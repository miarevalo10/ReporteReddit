package rx.plugins;

import rx.Scheduler;
import rx.functions.Action0;
import rx.internal.schedulers.CachedThreadScheduler;
import rx.internal.schedulers.EventLoopsScheduler;
import rx.internal.schedulers.NewThreadScheduler;
import rx.internal.util.RxThreadFactory;

public class RxJavaSchedulersHook {
    private static final RxJavaSchedulersHook f41415a = new RxJavaSchedulersHook();

    @Deprecated
    public static Action0 m43518a(Action0 action0) {
        return action0;
    }

    public static Scheduler m43521d() {
        return null;
    }

    public static Scheduler m43522e() {
        return null;
    }

    public static Scheduler m43523f() {
        return null;
    }

    public static Scheduler m43517a() {
        return new EventLoopsScheduler(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static Scheduler m43519b() {
        return new CachedThreadScheduler(new RxThreadFactory("RxIoScheduler-"));
    }

    public static Scheduler m43520c() {
        return new NewThreadScheduler(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static RxJavaSchedulersHook m43524g() {
        return f41415a;
    }
}
