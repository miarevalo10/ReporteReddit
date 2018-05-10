package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.JobHolder;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class RunJobMessage extends Message {
    public JobHolder f12202d;

    public RunJobMessage() {
        super(Type.RUN_JOB);
    }

    protected final void mo823a() {
        this.f12202d = null;
    }
}
