package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask implements Disposable, Callable<Void> {
    static final FutureTask<Void> f32421f = new FutureTask(Functions.f25013b, null);
    final Runnable f32422a;
    final AtomicReference<Future<?>> f32423b = new AtomicReference();
    final AtomicReference<Future<?>> f32424c = new AtomicReference();
    final ExecutorService f32425d;
    Thread f32426e;

    public final /* synthetic */ Object call() throws Exception {
        return m32751c();
    }

    InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.f32422a = runnable;
        this.f32425d = executorService;
    }

    private Void m32751c() throws Exception {
        try {
            this.f32426e = Thread.currentThread();
            this.f32422a.run();
            Future submit = this.f32425d.submit(this);
            Future future;
            do {
                future = (Future) this.f32423b.get();
                if (future == f32421f) {
                    submit.cancel(this.f32426e != Thread.currentThread());
                }
            } while (!this.f32423b.compareAndSet(future, submit));
        } catch (Throwable th) {
            this.f32426e = null;
        }
        this.f32426e = null;
        return null;
    }

    public final void mo5626a() {
        Future future = (Future) this.f32424c.getAndSet(f32421f);
        boolean z = false;
        if (!(future == null || future == f32421f)) {
            future.cancel(this.f32426e != Thread.currentThread());
        }
        future = (Future) this.f32423b.getAndSet(f32421f);
        if (future != null && future != f32421f) {
            if (this.f32426e != Thread.currentThread()) {
                z = true;
            }
            future.cancel(z);
        }
    }

    public final boolean mo5627b() {
        return this.f32424c.get() == f32421f;
    }

    final void m32753a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) this.f32424c.get();
            if (future2 == f32421f) {
                future.cancel(this.f32426e != Thread.currentThread());
            }
        } while (!this.f32424c.compareAndSet(future2, future));
    }
}
