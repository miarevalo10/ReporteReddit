package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.CancelResult.AsyncCancelCallback;
import com.birbit.android.jobqueue.TagConstraint;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class CancelMessage extends Message {
    public TagConstraint f12189d;
    public String[] f12190e;
    public AsyncCancelCallback f12191f;

    protected final void mo823a() {
    }

    public CancelMessage() {
        super(Type.CANCEL);
    }
}
