package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;
import com.birbit.android.jobqueue.scheduling.SchedulerConstraint;

public class SchedulerMessage extends Message {
    public int f12206d;
    public SchedulerConstraint f12207e;

    public SchedulerMessage() {
        super(Type.SCHEDULER);
    }

    protected final void mo823a() {
        this.f12207e = null;
    }
}
