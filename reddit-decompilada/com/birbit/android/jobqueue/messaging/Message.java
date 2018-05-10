package com.birbit.android.jobqueue.messaging;

public abstract class Message {
    public final Type f2985a;
    public Message f2986b;
    public long f2987c = Long.MIN_VALUE;

    public abstract void mo823a();

    protected Message(Type type) {
        this.f2985a = type;
    }
}
