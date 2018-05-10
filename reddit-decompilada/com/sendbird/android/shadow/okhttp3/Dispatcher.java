package com.sendbird.android.shadow.okhttp3;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Dispatcher {
    private int f23183a = 64;
    private int f23184b = 5;
    private Runnable f23185c;
    private ExecutorService f23186d;
    private final Deque<AsyncCall> f23187e = new ArrayDeque();
    private final Deque<AsyncCall> f23188f = new ArrayDeque();
    private final Deque<RealCall> f23189g = new ArrayDeque();

    public final synchronized ExecutorService m25230a() {
        if (this.f23186d == null) {
            this.f23186d = new ThreadPoolExecutor(0, RedditJobManager.f10810d, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.m25364a("OkHttp Dispatcher", false));
        }
        return this.f23186d;
    }

    final synchronized void m25231a(AsyncCall asyncCall) {
        if (this.f23188f.size() >= this.f23183a || m25227c(asyncCall) >= this.f23184b) {
            this.f23187e.add(asyncCall);
            return;
        }
        this.f23188f.add(asyncCall);
        m25230a().execute(asyncCall);
    }

    public final synchronized void m25232b() {
        for (AsyncCall asyncCall : this.f23187e) {
            asyncCall.f30365a.mo5320b();
        }
        for (AsyncCall asyncCall2 : this.f23188f) {
            asyncCall2.f30365a.mo5320b();
        }
        for (RealCall b : this.f23189g) {
            b.mo5320b();
        }
    }

    private void m25228c() {
        if (this.f23188f.size() < this.f23183a && !this.f23187e.isEmpty()) {
            Iterator it = this.f23187e.iterator();
            while (it.hasNext()) {
                AsyncCall asyncCall = (AsyncCall) it.next();
                if (m25227c(asyncCall) < this.f23184b) {
                    it.remove();
                    this.f23188f.add(asyncCall);
                    m25230a().execute(asyncCall);
                }
                if (this.f23188f.size() >= this.f23183a) {
                    return;
                }
            }
        }
    }

    private int m25227c(AsyncCall asyncCall) {
        int i = 0;
        for (AsyncCall a : this.f23188f) {
            if (a.m31335a().equals(asyncCall.m31335a())) {
                i++;
            }
        }
        return i;
    }

    final void m25233b(AsyncCall asyncCall) {
        Deque deque = this.f23188f;
        synchronized (this) {
            if (deque.remove(asyncCall) == null) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            m25228c();
            asyncCall = m25229d();
            Runnable runnable = this.f23185c;
        }
        if (asyncCall == null && runnable != null) {
            runnable.run();
        }
    }

    private synchronized int m25229d() {
        return this.f23188f.size() + this.f23189g.size();
    }
}
