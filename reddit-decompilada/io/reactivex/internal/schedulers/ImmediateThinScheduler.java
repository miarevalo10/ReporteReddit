package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler extends Scheduler {
    public static final Scheduler f32418b = new ImmediateThinScheduler();
    static final Worker f32419c = new ImmediateThinWorker();
    static final Disposable f32420d;

    static final class ImmediateThinWorker extends Worker {
        public final void mo5626a() {
        }

        public final boolean mo5627b() {
            return false;
        }

        ImmediateThinWorker() {
        }

        public final Disposable mo6651a(Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.f32420d;
        }

        public final Disposable mo6607a(Runnable runnable, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        public final Disposable mo6652a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }

    static {
        Disposable a = Disposables.m26512a();
        f32420d = a;
        a.mo5626a();
    }

    private ImmediateThinScheduler() {
    }

    public final Disposable mo5677a(Runnable runnable) {
        runnable.run();
        return f32420d;
    }

    public final Disposable mo5630a(Runnable runnable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    public final Disposable mo5675a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    public final Worker mo5629a() {
        return f32419c;
    }
}
