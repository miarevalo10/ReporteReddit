package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicReference;

public abstract class EnabledEventsStrategy<T> implements EventsStrategy<T> {
    protected final Context f34677a;
    protected final EventsFilesManager<T> f34678b;
    final ScheduledExecutorService f34679c;
    final AtomicReference<ScheduledFuture<?>> f34680d;
    protected volatile int f34681e = -1;

    public EnabledEventsStrategy(Context context, ScheduledExecutorService scheduledExecutorService, EventsFilesManager<T> eventsFilesManager) {
        this.f34677a = context;
        this.f34679c = scheduledExecutorService;
        this.f34678b = eventsFilesManager;
        this.f34680d = new AtomicReference();
    }

    public void cancelTimeBasedFileRollOver() {
        if (this.f34680d.get() != null) {
            CommonUtils.m26292a(this.f34677a, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f34680d.get()).cancel(false);
            this.f34680d.set(null);
        }
    }

    public final void mo6598a(T r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f34677a;
        r1 = r5.toString();
        io.fabric.sdk.android.services.common.CommonUtils.m26292a(r0, r1);
        r0 = r4.f34678b;	 Catch:{ IOException -> 0x000f }
        r0.writeEvent(r5);	 Catch:{ IOException -> 0x000f }
        goto L_0x0016;
    L_0x000f:
        r5 = r4.f34677a;
        r0 = "Failed to write event.";
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r5, r0);
    L_0x0016:
        r5 = r4.f34681e;
        r0 = -1;
        if (r5 == r0) goto L_0x001d;
    L_0x001b:
        r5 = 1;
        goto L_0x001e;
    L_0x001d:
        r5 = 0;
    L_0x001e:
        if (r5 == 0) goto L_0x0029;
    L_0x0020:
        r5 = r4.f34681e;
        r0 = (long) r5;
        r5 = r4.f34681e;
        r2 = (long) r5;
        r4.m35597a(r0, r2);
    L_0x0029:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.EnabledEventsStrategy.a(java.lang.Object):void");
    }

    public boolean rollFileOver() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f34678b;	 Catch:{ IOException -> 0x0007 }
        r0 = r0.rollFileOver();	 Catch:{ IOException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = r2.f34677a;
        r1 = "Failed to roll file over.";
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r0, r1);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.EnabledEventsStrategy.rollFileOver():boolean");
    }

    protected final void m35597a(long r9, long r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.f34680d;
        r0 = r0.get();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = 1;
        goto L_0x000b;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        if (r0 == 0) goto L_0x0043;
    L_0x000d:
        r2 = new io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
        r0 = r8.f34677a;
        r2.<init>(r0, r8);
        r0 = r8.f34677a;
        r1 = new java.lang.StringBuilder;
        r3 = "Scheduling time based file roll over every ";
        r1.<init>(r3);
        r1.append(r11);
        r3 = " seconds";
        r1.append(r3);
        r1 = r1.toString();
        io.fabric.sdk.android.services.common.CommonUtils.m26292a(r0, r1);
        r0 = r8.f34680d;	 Catch:{ RejectedExecutionException -> 0x003c }
        r1 = r8.f34679c;	 Catch:{ RejectedExecutionException -> 0x003c }
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ RejectedExecutionException -> 0x003c }
        r3 = r9;	 Catch:{ RejectedExecutionException -> 0x003c }
        r5 = r11;	 Catch:{ RejectedExecutionException -> 0x003c }
        r9 = r1.scheduleAtFixedRate(r2, r3, r5, r7);	 Catch:{ RejectedExecutionException -> 0x003c }
        r0.set(r9);	 Catch:{ RejectedExecutionException -> 0x003c }
        return;
    L_0x003c:
        r9 = r8.f34677a;
        r10 = "Failed to schedule time based file roll over";
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r9, r10);
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.EnabledEventsStrategy.a(long, long):void");
    }

    public final void mo6599b() {
        FilesSender a = mo6597a();
        if (a == null) {
            CommonUtils.m26292a(this.f34677a, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.m26292a(this.f34677a, "Sending all files");
        List batchOfFilesToSend = this.f34678b.getBatchOfFilesToSend();
        int i = 0;
        while (batchOfFilesToSend.size() > 0) {
            try {
                CommonUtils.m26292a(this.f34677a, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(batchOfFilesToSend.size())}));
                boolean send = a.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.f34678b.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                }
                batchOfFilesToSend = this.f34678b.getBatchOfFilesToSend();
            } catch (Exception e) {
                Context context = this.f34677a;
                StringBuilder stringBuilder = new StringBuilder("Failed to send batch of analytics files to server: ");
                stringBuilder.append(e.getMessage());
                CommonUtils.m26302b(context, stringBuilder.toString());
            }
        }
        if (i == 0) {
            this.f34678b.deleteOldestInRollOverIfOverMax();
        }
    }
}
