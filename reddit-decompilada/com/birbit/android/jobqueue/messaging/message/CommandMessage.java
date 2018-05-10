package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class CommandMessage extends Message {
    public int f12194d;
    public Runnable f12195e;

    public CommandMessage() {
        super(Type.COMMAND);
    }

    protected final void mo823a() {
        this.f12194d = -1;
        this.f12195e = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Command[");
        stringBuilder.append(this.f12194d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
