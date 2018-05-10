package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzzv
public class zzalf<T> implements zzakv<T> {
    private final Object f14136a = new Object();
    private T f14137b;
    private Throwable f14138c;
    private boolean f14139d;
    private boolean f14140e;
    private final zzakw f14141f = new zzakw();

    private final boolean m13327a() {
        if (this.f14138c == null) {
            if (!this.f14139d) {
                return false;
            }
        }
        return true;
    }

    public final void mo1732a(Runnable runnable, Executor executor) {
        this.f14141f.m5391a(runnable, executor);
    }

    public final void m13329a(Throwable th) {
        synchronized (this.f14136a) {
            if (this.f14140e) {
            } else if (m13327a()) {
                zzbs.m4490i().m13246a(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
            } else {
                this.f14138c = th;
                this.f14136a.notifyAll();
                this.f14141f.m5390a();
            }
        }
    }

    public final void m13330b(T t) {
        synchronized (this.f14136a) {
            if (this.f14140e) {
            } else if (m13327a()) {
                zzbs.m4490i().m13246a(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
            } else {
                this.f14139d = true;
                this.f14137b = t;
                this.f14136a.notifyAll();
                this.f14141f.m5390a();
            }
        }
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f14136a) {
            if (m13327a()) {
                return false;
            }
            this.f14140e = true;
            this.f14139d = true;
            this.f14136a.notifyAll();
            this.f14141f.m5390a();
            return true;
        }
    }

    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.f14136a) {
            if (!m13327a()) {
                try {
                    this.f14136a.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f14138c != null) {
                throw new ExecutionException(this.f14138c);
            } else if (this.f14140e) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else {
                t = this.f14137b;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.f14136a) {
            if (!m13327a()) {
                try {
                    j = timeUnit.toMillis(j);
                    if (j != 0) {
                        this.f14136a.wait(j);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f14138c != null) {
                throw new ExecutionException(this.f14138c);
            } else if (!this.f14139d) {
                throw new TimeoutException("SettableFuture timed out.");
            } else if (this.f14140e) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else {
                t = this.f14137b;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f14136a) {
            z = this.f14140e;
        }
        return z;
    }

    public boolean isDone() {
        boolean a;
        synchronized (this.f14136a) {
            a = m13327a();
        }
        return a;
    }
}
