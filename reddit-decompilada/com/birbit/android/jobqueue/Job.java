package com.birbit.android.jobqueue;

import android.content.Context;
import com.birbit.android.jobqueue.log.JqLog;
import com.birbit.android.jobqueue.timer.Timer;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class Job implements Serializable {
    public transient String f2880a = UUID.randomUUID().toString();
    transient int f2881b;
    transient String f2882c;
    transient boolean f2883d;
    transient Set<String> f2884e;
    transient int f2885f;
    transient long f2886g;
    transient long f2887h;
    transient boolean f2888i;
    protected volatile transient boolean f2889j;
    protected transient Context f2890k;
    volatile transient boolean f2891l;
    private transient int f2892m;
    private volatile transient boolean f2893n;

    public abstract void mo3017a();

    public abstract void mo3018a(int i, Throwable th);

    public abstract void mo3019b() throws Throwable;

    public abstract RetryConstraint mo3020c();

    public int mo3021e() {
        return 20;
    }

    protected Job(Params params) {
        this.f2881b = params.f2939a;
        this.f2883d = params.f2942d;
        this.f2882c = params.f2940b;
        this.f2885f = params.f2943e;
        this.f2886g = Math.max(0, params.f2944f);
        this.f2887h = Math.max(0, params.f2946h);
        this.f2888i = Boolean.TRUE.equals(params.f2947i);
        String str = params.f2941c;
        if (!(params.f2945g == null && str == null)) {
            if (params.f2945g != null) {
                params = params.f2945g;
            } else {
                params = new HashSet();
            }
            if (str != null) {
                StringBuilder stringBuilder = new StringBuilder("job-single-id:");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                params.add(str);
                if (this.f2882c == null) {
                    this.f2882c = str;
                }
            }
            this.f2884e = Collections.unmodifiableSet(params);
        }
        if (this.f2887h > 0 && this.f2887h < this.f2886g) {
            StringBuilder stringBuilder2 = new StringBuilder("deadline cannot be less than the delay. It does not make sense. deadline:");
            stringBuilder2.append(this.f2887h);
            stringBuilder2.append(",delay:");
            stringBuilder2.append(this.f2886g);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    final void m2497a(JobHolder jobHolder) {
        if (this.f2893n) {
            throw new IllegalStateException("Cannot set a Job from JobHolder after it is sealed.");
        }
        this.f2880a = jobHolder.f2910b;
        this.f2882c = jobHolder.f2913e;
        this.f2885f = jobHolder.f2912d;
        this.f2883d = jobHolder.f2911c;
        this.f2884e = jobHolder.f2922n;
        this.f2881b = jobHolder.f2918j;
        this.f2893n = true;
    }

    final int m2494a(JobHolder jobHolder, int i, Timer timer) {
        Throwable th;
        boolean z;
        this.f2892m = i;
        JqLog.m2560a();
        try {
            mo3019b();
            JqLog.m2560a();
            th = null;
            timer = null;
            Timer timer2 = timer;
            z = timer2;
        } catch (Throwable th2) {
            JqLog.m2559a(th2, "shouldReRunOnThrowable did throw an exception", new Object[0]);
        }
        JqLog.m2558a("safeRunResult for %s : %s. re run:%s. cancelled: %s", this, Boolean.valueOf(timer ^ 1), Boolean.valueOf(z), Boolean.valueOf(this.f2889j));
        if (timer == null) {
            return 1;
        }
        if (jobHolder.f2924p != null) {
            return 6;
        }
        if (jobHolder.f2923o != null) {
            return 3;
        }
        if (z) {
            return 4;
        }
        if (timer2 != null) {
            return 7;
        }
        if (i >= mo3021e()) {
            jobHolder.f2926r = th2;
            return 5;
        }
        jobHolder.f2926r = th2;
        return 2;
        th2 = th;
        timer2 = timer;
        timer = 1;
        JqLog.m2558a("safeRunResult for %s : %s. re run:%s. cancelled: %s", this, Boolean.valueOf(timer ^ 1), Boolean.valueOf(z), Boolean.valueOf(this.f2889j));
        if (timer == null) {
            return 1;
        }
        if (jobHolder.f2924p != null) {
            return 6;
        }
        if (jobHolder.f2923o != null) {
            return 3;
        }
        if (z) {
            return 4;
        }
        if (timer2 != null) {
            return 7;
        }
        if (i >= mo3021e()) {
            jobHolder.f2926r = th2;
            return 2;
        }
        jobHolder.f2926r = th2;
        return 5;
    }

    public final String m2500d() {
        if (this.f2884e != null) {
            for (String str : this.f2884e) {
                if (str.startsWith("job-single-id:")) {
                    return str;
                }
            }
        }
        return null;
    }
}
