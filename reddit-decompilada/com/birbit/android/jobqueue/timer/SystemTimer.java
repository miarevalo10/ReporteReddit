package com.birbit.android.jobqueue.timer;

import com.birbit.android.jobqueue.log.JqLog;
import java.util.concurrent.TimeUnit;

public class SystemTimer implements Timer {
    final long f12218a = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    final long f12219b = System.nanoTime();

    public SystemTimer() {
        JqLog.m2558a("creating system timer", new Object[0]);
    }

    public final long mo829a() {
        return (System.nanoTime() - this.f12219b) + this.f12218a;
    }

    public final void mo831a(Object obj, long j) throws InterruptedException {
        long a = mo829a();
        if (a > j) {
            obj.wait(1);
        } else {
            TimeUnit.NANOSECONDS.timedWait(obj, j - a);
        }
    }

    public final void mo830a(Object obj) throws InterruptedException {
        obj.wait();
    }

    public final void mo832b(Object obj) {
        obj.notifyAll();
    }
}
