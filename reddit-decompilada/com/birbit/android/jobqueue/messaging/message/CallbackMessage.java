package com.birbit.android.jobqueue.messaging.message;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.messaging.Message;
import com.birbit.android.jobqueue.messaging.Type;

public class CallbackMessage extends Message {
    public int f12184d;
    public int f12185e;
    public boolean f12186f;
    public Job f12187g;
    public Throwable f12188h;

    public CallbackMessage() {
        super(Type.CALLBACK);
    }

    protected final void mo823a() {
        this.f12187g = null;
        this.f12188h = null;
    }

    public final void m11068a(Job job, int i) {
        this.f12184d = i;
        this.f12187g = job;
    }

    public final void m11069a(Job job, int i, int i2) {
        this.f12184d = i;
        this.f12185e = i2;
        this.f12187g = job;
    }
}
