package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import rx.functions.Func0;
import rx.internal.util.RxThreadFactory;
import rx.plugins.RxJavaHooks;

enum GenericScheduledExecutorServiceFactory {
    ;
    
    static final RxThreadFactory f41344a = null;

    static {
        f41344a = new RxThreadFactory("RxScheduledExecutorPool-");
    }

    public static ScheduledExecutorService m43463a() {
        Func0 a = RxJavaHooks.m43499a();
        if (a == null) {
            return Executors.newScheduledThreadPool(1, f41344a);
        }
        return (ScheduledExecutorService) a.call();
    }
}
