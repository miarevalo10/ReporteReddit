package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

public class DeadEvent {
    private final Object f8481a;
    private final Object f8482b;

    public DeadEvent(Object obj, Object obj2) {
        this.f8481a = Preconditions.m6908a(obj);
        this.f8482b = Preconditions.m6908a(obj2);
    }

    public String toString() {
        return MoreObjects.m6894a(this).m6893a("source", this.f8481a).m6893a("event", this.f8482b).toString();
    }
}
