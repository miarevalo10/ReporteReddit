package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R>, Runnable {
    private static final Waiter f18889a = new Waiter();
    private final Handler f18890b;
    private final int f18891c;
    private final int f18892d;
    private final boolean f18893e;
    private final Waiter f18894f;
    private R f18895g;
    private Request f18896h;
    private boolean f18897i;
    private boolean f18898j;
    private boolean f18899k;
    private GlideException f18900l;

    static class Waiter {
        Waiter() {
        }

        static void m3127a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        static void m3126a(Object obj) {
            obj.notifyAll();
        }
    }

    public final void mo871a() {
    }

    public final void mo3268a(Drawable drawable) {
    }

    public final void mo872b() {
    }

    public final void mo3270b(Drawable drawable) {
    }

    public final void mo3859b(SizeReadyCallback sizeReadyCallback) {
    }

    public final void mo873c() {
    }

    public RequestFutureTarget(Handler handler, int i, int i2) {
        this(handler, i, i2, f18889a);
    }

    private RequestFutureTarget(Handler handler, int i, int i2, Waiter waiter) {
        this.f18890b = handler;
        this.f18891c = i;
        this.f18892d = i2;
        this.f18893e = true;
        this.f18894f = waiter;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean cancel(boolean r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.isDone();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000a;
    L_0x0007:
        r2 = 0;
        monitor-exit(r1);
        return r2;
    L_0x000a:
        r0 = 1;
        r1.f18897i = r0;	 Catch:{ all -> 0x0019 }
        com.bumptech.glide.request.RequestFutureTarget.Waiter.m3126a(r1);	 Catch:{ all -> 0x0019 }
        if (r2 == 0) goto L_0x0017;
    L_0x0012:
        r2 = r1.f18890b;	 Catch:{ all -> 0x0019 }
        r2.post(r1);	 Catch:{ all -> 0x0019 }
    L_0x0017:
        monitor-exit(r1);
        return r0;
    L_0x0019:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.cancel(boolean):boolean");
    }

    public synchronized boolean isCancelled() {
        return this.f18897i;
    }

    public synchronized boolean isDone() {
        boolean z;
        if (!(this.f18897i || this.f18898j)) {
            if (!this.f18899k) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return m19986a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m19986a(Long.valueOf(timeUnit.toMillis(j)));
    }

    public final void mo3857a(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f18891c, this.f18892d);
    }

    public final void mo3269a(Request request) {
        this.f18896h = request;
    }

    public final Request mo3272d() {
        return this.f18896h;
    }

    public final synchronized void mo3271c(Drawable drawable) {
    }

    public final synchronized void mo3858a(R r, Transition<? super R> transition) {
    }

    private synchronized R m19986a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f18893e && !isDone()) {
            Util.m3235b();
        }
        if (this.f18897i) {
            throw new CancellationException();
        } else if (this.f18899k) {
            throw new ExecutionException(this.f18900l);
        } else if (this.f18898j) {
            return this.f18895g;
        } else {
            if (l == null) {
                Waiter.m3127a(this, 0);
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (isDone() == null && currentTimeMillis < longValue) {
                    Waiter.m3127a(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted() != null) {
                throw new InterruptedException();
            } else if (this.f18899k != null) {
                throw new ExecutionException(this.f18900l);
            } else if (this.f18897i != null) {
                throw new CancellationException();
            } else if (this.f18898j == null) {
                throw new TimeoutException();
            } else {
                return this.f18895g;
            }
        }
    }

    public void run() {
        if (this.f18896h != null) {
            this.f18896h.clear();
            this.f18896h = null;
        }
    }

    public final synchronized boolean mo3043a(GlideException glideException) {
        this.f18899k = true;
        this.f18900l = glideException;
        Waiter.m3126a(this);
        return null;
    }

    public final synchronized boolean mo3044a(R r) {
        this.f18898j = true;
        this.f18895g = r;
        Waiter.m3126a(this);
        return null;
    }
}
