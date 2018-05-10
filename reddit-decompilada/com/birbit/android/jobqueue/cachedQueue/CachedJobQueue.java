package com.birbit.android.jobqueue.cachedQueue;

import com.birbit.android.jobqueue.Constraint;
import com.birbit.android.jobqueue.JobHolder;
import com.birbit.android.jobqueue.JobQueue;
import java.util.Set;

public class CachedJobQueue implements JobQueue {
    private JobQueue f12163a;
    private Integer f12164b;

    public CachedJobQueue(JobQueue jobQueue) {
        this.f12163a = jobQueue;
    }

    public final int mo805a() {
        if (this.f12164b == null) {
            this.f12164b = Integer.valueOf(this.f12163a.mo805a());
        }
        return this.f12164b.intValue();
    }

    private boolean m11025c() {
        return this.f12164b != null && this.f12164b.intValue() == 0;
    }

    public final int mo806a(Constraint constraint) {
        if (m11025c()) {
            return null;
        }
        return this.f12163a.mo806a(constraint);
    }

    public final JobHolder mo810b(Constraint constraint) {
        if (m11025c()) {
            return null;
        }
        constraint = this.f12163a.mo810b(constraint);
        if (!(constraint == null || this.f12164b == null)) {
            this.f12164b = Integer.valueOf(this.f12164b.intValue() - 1);
        }
        return constraint;
    }

    public final Long mo813c(Constraint constraint) {
        return this.f12163a.mo813c(constraint);
    }

    public final Set<JobHolder> mo815d(Constraint constraint) {
        return this.f12163a.mo815d(constraint);
    }

    public final JobHolder mo807a(String str) {
        return this.f12163a.mo807a(str);
    }

    public final boolean mo809a(JobHolder jobHolder) {
        this.f12164b = null;
        return this.f12163a.mo809a(jobHolder);
    }

    public final boolean mo812b(JobHolder jobHolder) {
        this.f12164b = null;
        return this.f12163a.mo812b(jobHolder);
    }

    public final void mo808a(JobHolder jobHolder, JobHolder jobHolder2) {
        this.f12164b = null;
        this.f12163a.mo808a(jobHolder, jobHolder2);
    }

    public final void mo814c(JobHolder jobHolder) {
        this.f12164b = null;
        this.f12163a.mo814c(jobHolder);
    }

    public final void mo811b() {
        this.f12164b = null;
        this.f12163a.mo811b();
    }

    public final void mo816d(JobHolder jobHolder) {
        this.f12164b = null;
        this.f12163a.mo816d(jobHolder);
    }
}
