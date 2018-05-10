package de.greenrobot.event;

import android.util.Log;

final class BackgroundPoster implements Runnable {
    final PendingPostQueue f24325a = new PendingPostQueue();
    final EventBus f24326b;
    volatile boolean f24327c;

    BackgroundPoster(EventBus eventBus) {
        this.f24326b = eventBus;
    }

    public final void run() {
        while (true) {
            try {
                PendingPost b = this.f24325a.m26018b();
                if (b == null) {
                    synchronized (this) {
                        b = this.f24325a.m26016a();
                        if (b == null) {
                            this.f24327c = false;
                            this.f24327c = false;
                            return;
                        }
                    }
                }
                this.f24326b.invokeSubscriber(b);
            } catch (Throwable e) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Thread.currentThread().getName());
                    stringBuilder.append(" was interruppted");
                    Log.w("Event", stringBuilder.toString(), e);
                    return;
                } finally {
                    this.f24327c = false;
                }
            }
        }
    }
}
