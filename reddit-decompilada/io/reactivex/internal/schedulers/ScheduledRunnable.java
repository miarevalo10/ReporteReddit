package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Disposable, Runnable, Callable<Object> {
    static final Object f32436b = new Object();
    static final Object f32437c = new Object();
    static final Object f32438d = new Object();
    static final Object f32439e = new Object();
    final Runnable f32440a;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.f32440a = runnable;
        lazySet(null, disposableContainer);
    }

    public final Object call() {
        run();
        return null;
    }

    public final void run() {
        Object obj;
        lazySet(2, Thread.currentThread());
        try {
            this.f32440a.run();
        } catch (Throwable th) {
            lazySet(2, null);
            obj = get(0);
            if (!(obj == f32436b || !compareAndSet(0, obj, f32439e) || obj == null)) {
                ((DisposableContainer) obj).mo5633c(this);
            }
            do {
                obj = get(1);
                if (obj == f32437c || obj == f32438d) {
                }
            } while (!compareAndSet(1, obj, f32439e));
        }
        lazySet(2, null);
        obj = get(0);
        if (!(obj == f32436b || !compareAndSet(0, obj, f32439e) || obj == null)) {
            ((DisposableContainer) obj).mo5633c(this);
        }
        do {
            obj = get(1);
            if (obj == f32437c || obj == f32438d) {
                return;
            }
        } while (!compareAndSet(1, obj, f32439e));
    }

    public final void m32759a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f32439e) {
                if (obj == f32437c) {
                    future.cancel(false);
                    return;
                } else if (obj == f32438d) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public final void mo5626a() {
        Object obj;
        Object obj2;
        boolean z;
        do {
            obj2 = get(1);
            if (obj2 == f32439e || obj2 == f32437c || obj2 == f32438d) {
                break;
            }
            z = get(2) != Thread.currentThread();
        } while (!compareAndSet(1, obj2, z ? f32438d : f32437c));
        if (obj2 != null) {
            ((Future) obj2).cancel(z);
        }
        do {
            obj = get(0);
            if (!(obj == f32439e || obj == f32436b)) {
                if (obj == null) {
                }
            }
            return;
        } while (!compareAndSet(0, obj, f32436b));
        ((DisposableContainer) obj).mo5633c(this);
    }

    public final boolean mo5627b() {
        Object obj = get(0);
        if (obj != f32436b) {
            if (obj != f32439e) {
                return false;
            }
        }
        return true;
    }
}
