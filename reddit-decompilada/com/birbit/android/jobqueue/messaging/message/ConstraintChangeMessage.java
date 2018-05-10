package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class ConstraintChangeMessage extends Message {
    public boolean f12196d;

    public ConstraintChangeMessage() {
        super(Type.CONSTRAINT_CHANGE);
    }

    protected final void mo823a() {
        this.f12196d = false;
    }
}
