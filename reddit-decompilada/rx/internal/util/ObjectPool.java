package rx.internal.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.schedulers.GenericScheduledExecutorService;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.unsafe.MpmcArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

public abstract class ObjectPool<T> implements SchedulerLifecycle {
    Queue<T> f41774a;
    final int f41775b;
    final int f41776c;
    private final long f41777d;
    private final AtomicReference<Future<?>> f41778e;

    class C30721 implements Runnable {
        final /* synthetic */ ObjectPool f41360a;

        C30721(ObjectPool objectPool) {
            this.f41360a = objectPool;
        }

        public void run() {
            int size = this.f41360a.f41774a.size();
            int i = 0;
            if (size < this.f41360a.f41775b) {
                int i2 = this.f41360a.f41776c - size;
                while (i < i2) {
                    this.f41360a.f41774a.add(this.f41360a.mo7931b());
                    i++;
                }
                return;
            }
            if (size > this.f41360a.f41776c) {
                size -= this.f41360a.f41776c;
                while (i < size) {
                    this.f41360a.f41774a.poll();
                    i++;
                }
            }
        }
    }

    protected abstract T mo7931b();

    public ObjectPool() {
        this((byte) 0);
    }

    private ObjectPool(byte b) {
        this.f41775b = 0;
        this.f41776c = 0;
        this.f41777d = 67;
        this.f41778e = new AtomicReference();
        if (UnsafeAccess.m43484a() != (byte) 0) {
            this.f41774a = new MpmcArrayQueue(Math.max(this.f41776c, 1024));
        } else {
            this.f41774a = new ConcurrentLinkedQueue();
        }
        m43887d();
    }

    public final T m43888a() {
        T poll = this.f41774a.poll();
        return poll == null ? mo7931b() : poll;
    }

    public final void mo7903c() {
        Future future = (Future) this.f41778e.getAndSet(null);
        if (future != null) {
            future.cancel(false);
        }
    }

    private void m43887d() {
        while (this.f41778e.get() == null) {
            try {
                Future scheduleAtFixedRate = GenericScheduledExecutorService.m43857a().scheduleAtFixedRate(new C30721(this), this.f41777d, this.f41777d, TimeUnit.SECONDS);
                if (!this.f41778e.compareAndSet(null, scheduleAtFixedRate)) {
                    scheduleAtFixedRate.cancel(false);
                } else {
                    return;
                }
            } catch (Throwable e) {
                RxJavaHooks.m43500a(e);
                return;
            }
        }
    }
}
