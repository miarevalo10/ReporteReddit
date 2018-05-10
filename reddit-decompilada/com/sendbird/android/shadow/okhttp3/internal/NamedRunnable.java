package com.sendbird.android.shadow.okhttp3.internal;

public abstract class NamedRunnable implements Runnable {
    protected final String f23331b;

    public abstract void mo5317b();

    public NamedRunnable(String str, Object... objArr) {
        this.f23331b = Util.m25360a(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f23331b);
        try {
            mo5317b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
