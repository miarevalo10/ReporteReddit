package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.IntCallback;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class PublicQueryMessage extends Message {
    public IntCallback f12199d;
    public int f12200e = -1;
    public String f12201f;

    public PublicQueryMessage() {
        super(Type.PUBLIC_QUERY);
    }

    protected final void mo823a() {
        this.f12199d = null;
        this.f12200e = -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PublicQuery[");
        stringBuilder.append(this.f12200e);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
