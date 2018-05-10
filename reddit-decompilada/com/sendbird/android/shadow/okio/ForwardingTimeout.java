package com.sendbird.android.shadow.okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ForwardingTimeout extends Timeout {
    public Timeout f30571a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f30571a = timeout;
    }

    public final Timeout mo5385a(long j, TimeUnit timeUnit) {
        return this.f30571a.mo5385a(j, timeUnit);
    }

    public final long av_() {
        return this.f30571a.av_();
    }

    public final boolean aw_() {
        return this.f30571a.aw_();
    }

    public final long mo5389c() {
        return this.f30571a.mo5389c();
    }

    public final Timeout mo5384a(long j) {
        return this.f30571a.mo5384a(j);
    }

    public final Timeout mo5390d() {
        return this.f30571a.mo5390d();
    }

    public final Timeout ax_() {
        return this.f30571a.ax_();
    }

    public final void mo5391f() throws IOException {
        this.f30571a.mo5391f();
    }
}
