package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

final class HandlerPoster extends Handler {
    final PendingPostQueue f24345a = new PendingPostQueue();
    boolean f24346b;
    private final int f24347c = 10;
    private final EventBus f24348d;

    HandlerPoster(EventBus eventBus, Looper looper) {
        super(looper);
        this.f24348d = eventBus;
    }

    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost a = this.f24345a.m26016a();
                if (a == null) {
                    synchronized (this) {
                        a = this.f24345a.m26016a();
                        if (a == null) {
                            this.f24346b = false;
                            this.f24346b = false;
                            return;
                        }
                    }
                }
                this.f24348d.invokeSubscriber(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f24347c));
            if (sendMessage(obtainMessage())) {
                this.f24346b = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.f24346b = false;
        }
    }
}
