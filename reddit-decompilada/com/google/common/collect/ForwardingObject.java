package com.google.common.collect;

public abstract class ForwardingObject {
    public abstract Object delegate();

    protected ForwardingObject() {
    }

    public String toString() {
        return delegate().toString();
    }
}
