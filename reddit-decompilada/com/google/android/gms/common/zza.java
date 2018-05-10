package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class zza implements ServiceConnection {
    public boolean f5972a = false;
    public final BlockingQueue<IBinder> f5973b = new LinkedBlockingQueue();

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f5973b.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
