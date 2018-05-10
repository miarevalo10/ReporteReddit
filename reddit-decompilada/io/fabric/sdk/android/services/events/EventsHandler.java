package io.fabric.sdk.android.services.events;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public abstract class EventsHandler<T> implements EventsStorageListener {
    protected final Context f31010a;
    protected final ScheduledExecutorService f31011b;
    protected EventsStrategy<T> f31012c;

    class C21211 implements Runnable {
        final /* synthetic */ Object f24834a;
        final /* synthetic */ boolean f24835b = null;
        final /* synthetic */ EventsHandler f24836c;

        public C21211(EventsHandler eventsHandler, Object obj) {
            this.f24836c = eventsHandler;
            this.f24834a = obj;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.f24836c;	 Catch:{ Exception -> 0x0015 }
            r0 = r0.f31012c;	 Catch:{ Exception -> 0x0015 }
            r1 = r2.f24834a;	 Catch:{ Exception -> 0x0015 }
            r0.mo6598a(r1);	 Catch:{ Exception -> 0x0015 }
            r0 = r2.f24835b;	 Catch:{ Exception -> 0x0015 }
            if (r0 == 0) goto L_0x0014;	 Catch:{ Exception -> 0x0015 }
        L_0x000d:
            r0 = r2.f24836c;	 Catch:{ Exception -> 0x0015 }
            r0 = r0.f31012c;	 Catch:{ Exception -> 0x0015 }
            r0.rollFileOver();	 Catch:{ Exception -> 0x0015 }
        L_0x0014:
            return;
        L_0x0015:
            r0 = r2.f24836c;
            r0 = r0.f31010a;
            r1 = "Failed to record event.";
            io.fabric.sdk.android.services.common.CommonUtils.m26302b(r0, r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.EventsHandler.1.run():void");
        }
    }

    class C21223 implements Runnable {
        final /* synthetic */ EventsHandler f24837a;

        C21223(EventsHandler eventsHandler) {
            this.f24837a = eventsHandler;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.f24837a;	 Catch:{ Exception -> 0x0008 }
            r0 = r0.f31012c;	 Catch:{ Exception -> 0x0008 }
            r0.mo6599b();	 Catch:{ Exception -> 0x0008 }
            return;
        L_0x0008:
            r0 = r2.f24837a;
            r0 = r0.f31010a;
            r1 = "Failed to send events files.";
            io.fabric.sdk.android.services.common.CommonUtils.m26302b(r0, r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.EventsHandler.3.run():void");
        }
    }

    public EventsHandler(Context context, EventsStrategy<T> eventsStrategy, EventsFilesManager eventsFilesManager, ScheduledExecutorService scheduledExecutorService) {
        this.f31010a = context.getApplicationContext();
        this.f31011b = scheduledExecutorService;
        this.f31012c = eventsStrategy;
        eventsFilesManager.registerRollOverListener(this);
    }

    public void onRollOver(String str) {
        m31966a(new C21223(this));
    }

    public final void m31966a(java.lang.Runnable r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.f31011b;	 Catch:{ Exception -> 0x0006 }
        r0.submit(r2);	 Catch:{ Exception -> 0x0006 }
        return;
    L_0x0006:
        r2 = r1.f31010a;
        r0 = "Failed to submit events task";
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r2, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.EventsHandler.a(java.lang.Runnable):void");
    }
}
