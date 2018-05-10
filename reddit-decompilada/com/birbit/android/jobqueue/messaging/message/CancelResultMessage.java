package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.CancelResult;
import com.birbit.android.jobqueue.CancelResult.AsyncCancelCallback;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class CancelResultMessage extends Message {
    public AsyncCancelCallback f12192d;
    public CancelResult f12193e;

    public CancelResultMessage() {
        super(Type.CANCEL_RESULT_CALLBACK);
    }

    protected final void mo823a() {
        this.f12193e = null;
        this.f12192d = null;
    }
}
