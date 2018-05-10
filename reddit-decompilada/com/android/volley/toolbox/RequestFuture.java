package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T> implements ErrorListener, Listener<T>, Future<T> {
    private Request<?> f12128a;
    private boolean f12129b = false;
    private T f12130c;
    private VolleyError f12131d;

    public static <E> RequestFuture<E> m10986a() {
        return new RequestFuture();
    }

    private RequestFuture() {
    }

    public synchronized boolean cancel(boolean z) {
        if (!this.f12128a) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f12128a.cancel();
        return true;
    }

    public T get() throws InterruptedException, ExecutionException {
        try {
            return m10987a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m10987a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized T m10987a(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.f12131d != null) {
            throw new ExecutionException(this.f12131d);
        } else if (this.f12129b) {
            return this.f12130c;
        } else {
            if (l == null) {
                wait(0);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.f12131d != null) {
                throw new ExecutionException(this.f12131d);
            } else if (this.f12129b == null) {
                throw new TimeoutException();
            } else {
                return this.f12130c;
            }
        }
    }

    public boolean isCancelled() {
        if (this.f12128a == null) {
            return false;
        }
        return this.f12128a.isCanceled();
    }

    public synchronized boolean isDone() {
        boolean z;
        if (!this.f12129b && this.f12131d == null) {
            if (!isCancelled()) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void mo794a(T t) {
        this.f12129b = true;
        this.f12130c = t;
        notifyAll();
    }

    public final synchronized void mo793a(VolleyError volleyError) {
        this.f12131d = volleyError;
        notifyAll();
    }
}
