package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.JobHolder;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class RunJobResultMessage extends Message {
    public JobHolder f12203d;
    public Object f12204e;
    public int f12205f;

    public RunJobResultMessage() {
        super(Type.RUN_JOB_RESULT);
    }

    protected final void mo823a() {
        this.f12203d = null;
    }
}
