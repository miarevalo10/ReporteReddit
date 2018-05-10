package com.birbit.android.jobqueue.scheduling;

import android.content.Context;

public abstract class Scheduler {
    private Callback f3075a;
    private Context f3076b;

    public interface Callback {
    }

    public abstract void mo795a();

    public abstract void mo797a(SchedulerConstraint schedulerConstraint);

    public abstract void mo798a(SchedulerConstraint schedulerConstraint, boolean z);

    protected Scheduler() {
    }

    public void mo796a(Context context, Callback callback) {
        this.f3076b = context.getApplicationContext();
        this.f3075a = callback;
    }
}
