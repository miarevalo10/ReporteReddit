package rx.schedulers;

import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.schedulers.TrampolineScheduler;
import rx.plugins.RxJavaHooks;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;

public final class Schedulers {
    private static final AtomicReference<Schedulers> f41416d = new AtomicReference();
    private final Scheduler f41417a = RxJavaSchedulersHook.m43517a();
    private final Scheduler f41418b;
    private final Scheduler f41419c;

    private static Schedulers m43534e() {
        while (true) {
            Schedulers schedulers = (Schedulers) f41416d.get();
            if (schedulers != null) {
                return schedulers;
            }
            schedulers = new Schedulers();
            if (f41416d.compareAndSet(null, schedulers)) {
                return schedulers;
            }
            schedulers.m43535f();
        }
    }

    private Schedulers() {
        RxJavaPlugins.m43511a().m43516f();
        RxJavaSchedulersHook.m43521d();
        RxJavaSchedulersHook.m43522e();
        this.f41418b = RxJavaSchedulersHook.m43519b();
        RxJavaSchedulersHook.m43523f();
        this.f41419c = RxJavaSchedulersHook.m43520c();
    }

    public static Scheduler m43530a() {
        return TrampolineScheduler.f41766b;
    }

    public static Scheduler m43531b() {
        return RxJavaHooks.m43503c(m43534e().f41419c);
    }

    public static Scheduler m43532c() {
        return RxJavaHooks.m43496a(m43534e().f41417a);
    }

    public static Scheduler m43533d() {
        return RxJavaHooks.m43502b(m43534e().f41418b);
    }

    private synchronized void m43535f() {
        if (this.f41417a instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) this.f41417a).mo7903c();
        }
        if (this.f41418b instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) this.f41418b).mo7903c();
        }
        if (this.f41419c instanceof SchedulerLifecycle) {
            ((SchedulerLifecycle) this.f41419c).mo7903c();
        }
    }
}
