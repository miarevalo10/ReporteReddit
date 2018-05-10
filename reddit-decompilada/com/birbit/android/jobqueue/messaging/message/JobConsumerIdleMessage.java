package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class JobConsumerIdleMessage extends Message {
    public Object f12197d;
    public long f12198e;

    public JobConsumerIdleMessage() {
        super(Type.JOB_CONSUMER_IDLE);
    }

    protected final void mo823a() {
        this.f12197d = null;
    }
}
