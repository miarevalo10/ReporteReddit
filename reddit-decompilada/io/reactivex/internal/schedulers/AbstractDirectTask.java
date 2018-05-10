package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable {
    protected static final FutureTask<Void> f32408c = new FutureTask(Functions.f25013b, null);
    protected static final FutureTask<Void> f32409d = new FutureTask(Functions.f25013b, null);
    protected final Runnable f32410a;
    protected Thread f32411b;

    AbstractDirectTask(Runnable runnable) {
        this.f32410a = runnable;
    }

    public final void mo5626a() {
        Future future = (Future) get();
        if (future != f32408c && future != f32409d && compareAndSet(future, f32409d) && future != null) {
            future.cancel(this.f32411b != Thread.currentThread());
        }
    }

    public final boolean mo5627b() {
        Future future = (Future) get();
        if (future != f32408c) {
            if (future != f32409d) {
                return false;
            }
        }
        return true;
    }

    public final void m32741a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 == f32408c) {
                break;
            } else if (future2 == f32409d) {
                future.cancel(this.f32411b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
