package com.google.android.exoplayer2.decoder;

public abstract class Buffer {
    public int f4220a;

    public void mo1321a() {
        this.f4220a = 0;
    }

    public final boolean c_() {
        return m3714b(Integer.MIN_VALUE);
    }

    public final boolean m3715c() {
        return m3714b(4);
    }

    public final boolean m3716d() {
        return m3714b(1);
    }

    public final void m3713a(int i) {
        this.f4220a = i | this.f4220a;
    }

    protected final boolean m3714b(int i) {
        return (this.f4220a & i) == i;
    }
}
