package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class AddJobMessage extends Message {
    public Job f12183d;

    public AddJobMessage() {
        super(Type.ADD_JOB);
    }

    protected final void mo823a() {
        this.f12183d = null;
    }
}
