package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class Schedulers {
    static final Scheduler f25237a = RxJavaPlugins.m26764d(new SingleTask());
    static final Scheduler f25238b = RxJavaPlugins.m26746a(new ComputationTask());
    static final Scheduler f25239c = RxJavaPlugins.m26760b(new IOTask());
    static final Scheduler f25240d = TrampolineScheduler.m32765c();
    static final Scheduler f25241e = RxJavaPlugins.m26763c(new NewThreadTask());

    static final class ComputationHolder {
        static final Scheduler f25233a = new ComputationScheduler();
    }

    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        public final /* bridge */ /* synthetic */ Object call() throws Exception {
            return ComputationHolder.f25233a;
        }
    }

    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        public final /* bridge */ /* synthetic */ Object call() throws Exception {
            return IoHolder.f25234a;
        }
    }

    static final class IoHolder {
        static final Scheduler f25234a = new IoScheduler();
    }

    static final class NewThreadHolder {
        static final Scheduler f25235a = new NewThreadScheduler();
    }

    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        public final /* bridge */ /* synthetic */ Object call() throws Exception {
            return NewThreadHolder.f25235a;
        }
    }

    static final class SingleHolder {
        static final Scheduler f25236a = new SingleScheduler();
    }

    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        public final /* bridge */ /* synthetic */ Object call() throws Exception {
            return SingleHolder.f25236a;
        }
    }

    public static Scheduler m26770a() {
        return RxJavaPlugins.m26744a(f25238b);
    }

    public static Scheduler m26771b() {
        return RxJavaPlugins.m26759b(f25239c);
    }

    public static Scheduler m26772c() {
        return f25240d;
    }
}
