package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.BlockingQueue;

final class zzcil extends Thread {
    private final Object f6955a = new Object();
    private final BlockingQueue<zzcik<?>> f6956b;
    private /* synthetic */ zzcih f6957c;

    public zzcil(zzcih com_google_android_gms_internal_zzcih, String str, BlockingQueue<zzcik<?>> blockingQueue) {
        this.f6957c = com_google_android_gms_internal_zzcih;
        zzbq.m4808a((Object) str);
        zzbq.m4808a((Object) blockingQueue);
        this.f6956b = blockingQueue;
        setName(str);
    }

    public final void m5712a() {
        synchronized (this.f6955a) {
            this.f6955a.notifyAll();
        }
    }

    public final void run() {
        Object obj = null;
        while (obj == null) {
            try {
                this.f6957c.f17867i.acquire();
                obj = 1;
            } catch (InterruptedException e) {
                m5711a(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzcik com_google_android_gms_internal_zzcik = (zzcik) this.f6956b.poll();
                if (com_google_android_gms_internal_zzcik != null) {
                    Process.setThreadPriority(com_google_android_gms_internal_zzcik.f6951a ? threadPriority : 10);
                    com_google_android_gms_internal_zzcik.run();
                } else {
                    synchronized (this.f6955a) {
                        if (this.f6956b.peek() == null && !this.f6957c.f17868j) {
                            try {
                                this.f6955a.wait(30000);
                            } catch (InterruptedException e2) {
                                m5711a(e2);
                            }
                        }
                    }
                    synchronized (this.f6957c.f17866h) {
                        if (this.f6956b.peek() == null) {
                            break;
                        }
                    }
                }
            }
            synchronized (this.f6957c.f17866h) {
                this.f6957c.f17867i.release();
                this.f6957c.f17866h.notifyAll();
                if (this == this.f6957c.f17860b) {
                    this.f6957c.f17860b = null;
                } else if (this == this.f6957c.f17861c) {
                    this.f6957c.f17861c = null;
                } else {
                    this.f6957c.mo1828t().f17816a.m5693a("Current scheduler thread is neither worker nor network");
                }
            }
        } catch (Throwable th) {
            synchronized (this.f6957c.f17866h) {
                this.f6957c.f17867i.release();
                this.f6957c.f17866h.notifyAll();
                if (this == this.f6957c.f17860b) {
                    this.f6957c.f17860b = null;
                } else if (this == this.f6957c.f17861c) {
                    this.f6957c.f17861c = null;
                } else {
                    this.f6957c.mo1828t().f17816a.m5693a("Current scheduler thread is neither worker nor network");
                }
            }
        }
    }

    private final void m5711a(InterruptedException interruptedException) {
        this.f6957c.mo1828t().f17818c.m5694a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
