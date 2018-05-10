package com.birbit.android.jobqueue;

import android.content.Context;
import com.birbit.android.jobqueue.scheduling.Scheduler;
import com.birbit.android.jobqueue.scheduling.Scheduler.Callback;
import com.birbit.android.jobqueue.scheduling.SchedulerConstraint;
import com.birbit.android.jobqueue.timer.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BatchingScheduler extends Scheduler {
    public static final long f12133a = TimeUnit.SECONDS.toMillis(900);
    final long f12134b;
    final long f12135c;
    private final Scheduler f12136d;
    private final List<ConstraintWrapper> f12137e;
    private final Timer f12138f;

    private static class ConstraintWrapper {
        final long f2830a;
        final Long f2831b;
        final SchedulerConstraint f2832c;

        public ConstraintWrapper(long j, Long l, SchedulerConstraint schedulerConstraint) {
            this.f2830a = j;
            this.f2831b = l;
            this.f2832c = schedulerConstraint;
        }
    }

    class C10401 implements Callback {
        final /* synthetic */ BatchingScheduler f12132a;

        C10401(BatchingScheduler batchingScheduler) {
            this.f12132a = batchingScheduler;
        }
    }

    public BatchingScheduler(Scheduler scheduler, Timer timer) {
        this(scheduler, timer, f12133a);
    }

    private BatchingScheduler(Scheduler scheduler, Timer timer, long j) {
        this.f12137e = new ArrayList();
        this.f12136d = scheduler;
        this.f12138f = timer;
        this.f12134b = j;
        this.f12135c = TimeUnit.MILLISECONDS.toNanos(j);
    }

    public final void mo796a(Context context, Callback callback) {
        super.mo796a(context, callback);
        this.f12136d.mo796a(context, new C10401(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m10990b(com.birbit.android.jobqueue.scheduling.SchedulerConstraint r24) {
        /*
        r23 = this;
        r1 = r23;
        r2 = r24;
        r3 = r1.f12138f;
        r3 = r3.mo829a();
        r5 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r6 = r2.f3078b;
        r5 = r5.toNanos(r6);
        r5 = r5 + r3;
        r7 = r2.f3080d;
        if (r7 != 0) goto L_0x0019;
    L_0x0017:
        r7 = 0;
        goto L_0x002a;
    L_0x0019:
        r7 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r9 = r2.f3080d;
        r9 = r9.longValue();
        r9 = r7.toNanos(r9);
        r9 = r9 + r3;
        r7 = java.lang.Long.valueOf(r9);
    L_0x002a:
        r9 = r1.f12137e;
        monitor-enter(r9);
        r10 = r1.f12137e;	 Catch:{ all -> 0x00d4 }
        r10 = r10.iterator();	 Catch:{ all -> 0x00d4 }
    L_0x0033:
        r11 = r10.hasNext();	 Catch:{ all -> 0x00d4 }
        r12 = 1;
        r13 = 1;
        if (r11 == 0) goto L_0x008a;
    L_0x003c:
        r11 = r10.next();	 Catch:{ all -> 0x00d4 }
        r11 = (com.birbit.android.jobqueue.BatchingScheduler.ConstraintWrapper) r11;	 Catch:{ all -> 0x00d4 }
        r15 = r11.f2832c;	 Catch:{ all -> 0x00d4 }
        r15 = r15.f3079c;	 Catch:{ all -> 0x00d4 }
        r8 = r2.f3079c;	 Catch:{ all -> 0x00d4 }
        r16 = 0;
        if (r15 != r8) goto L_0x0068;
    L_0x004c:
        if (r7 == 0) goto L_0x006b;
    L_0x004e:
        r8 = r11.f2831b;	 Catch:{ all -> 0x00d4 }
        if (r8 == 0) goto L_0x0068;
    L_0x0052:
        r8 = r11.f2831b;	 Catch:{ all -> 0x00d4 }
        r17 = r8.longValue();	 Catch:{ all -> 0x00d4 }
        r19 = r7.longValue();	 Catch:{ all -> 0x00d4 }
        r17 = r17 - r19;
        r8 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1));
        if (r8 < 0) goto L_0x0068;
    L_0x0062:
        r13 = r1.f12135c;	 Catch:{ all -> 0x00d4 }
        r8 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1));
        if (r8 <= 0) goto L_0x006f;
    L_0x0068:
        r21 = r5;
        goto L_0x0081;
    L_0x006b:
        r8 = r11.f2831b;	 Catch:{ all -> 0x00d4 }
        if (r8 != 0) goto L_0x0068;
    L_0x006f:
        r13 = r11.f2830a;	 Catch:{ all -> 0x00d4 }
        r13 = r13 - r5;
        r17 = 0;
        r8 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1));
        if (r8 <= 0) goto L_0x0068;
    L_0x0078:
        r21 = r5;
        r5 = r1.f12135c;	 Catch:{ all -> 0x00d4 }
        r5 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1));
        if (r5 > 0) goto L_0x0081;
    L_0x0080:
        goto L_0x0083;
    L_0x0081:
        r12 = r16;
    L_0x0083:
        if (r12 == 0) goto L_0x0087;
    L_0x0085:
        monitor-exit(r9);	 Catch:{ all -> 0x00d4 }
        return r16;
    L_0x0087:
        r5 = r21;
        goto L_0x0033;
    L_0x008a:
        r5 = r2.f3078b;	 Catch:{ all -> 0x00d4 }
        r7 = r1.f12134b;	 Catch:{ all -> 0x00d4 }
        r5 = r5 / r7;
        r5 = r5 + r13;
        r7 = r1.f12134b;	 Catch:{ all -> 0x00d4 }
        r5 = r5 * r7;
        r2.f3078b = r5;	 Catch:{ all -> 0x00d4 }
        r7 = r2.f3080d;	 Catch:{ all -> 0x00d4 }
        if (r7 == 0) goto L_0x00ad;
    L_0x0099:
        r7 = r2.f3080d;	 Catch:{ all -> 0x00d4 }
        r7 = r7.longValue();	 Catch:{ all -> 0x00d4 }
        r10 = r1.f12134b;	 Catch:{ all -> 0x00d4 }
        r7 = r7 / r10;
        r7 = r7 + r13;
        r10 = r1.f12134b;	 Catch:{ all -> 0x00d4 }
        r7 = r7 * r10;
        r8 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x00d4 }
        r2.f3080d = r8;	 Catch:{ all -> 0x00d4 }
        goto L_0x00ae;
    L_0x00ad:
        r8 = 0;
    L_0x00ae:
        r7 = r1.f12137e;	 Catch:{ all -> 0x00d4 }
        r10 = new com.birbit.android.jobqueue.BatchingScheduler$ConstraintWrapper;	 Catch:{ all -> 0x00d4 }
        r11 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00d4 }
        r5 = r11.toNanos(r5);	 Catch:{ all -> 0x00d4 }
        r5 = r5 + r3;
        if (r8 != 0) goto L_0x00bd;
    L_0x00bb:
        r8 = 0;
        goto L_0x00cc;
    L_0x00bd:
        r11 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00d4 }
        r13 = r8.longValue();	 Catch:{ all -> 0x00d4 }
        r13 = r11.toNanos(r13);	 Catch:{ all -> 0x00d4 }
        r3 = r3 + r13;
        r8 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x00d4 }
    L_0x00cc:
        r10.<init>(r5, r8, r2);	 Catch:{ all -> 0x00d4 }
        r7.add(r10);	 Catch:{ all -> 0x00d4 }
        monitor-exit(r9);	 Catch:{ all -> 0x00d4 }
        return r12;
    L_0x00d4:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r9);	 Catch:{ all -> 0x00d4 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.BatchingScheduler.b(com.birbit.android.jobqueue.scheduling.SchedulerConstraint):boolean");
    }

    public final void mo797a(SchedulerConstraint schedulerConstraint) {
        if (m10990b(schedulerConstraint)) {
            this.f12136d.mo797a(schedulerConstraint);
        }
    }

    public final void mo795a() {
        synchronized (this.f12137e) {
            this.f12137e.clear();
        }
        this.f12136d.mo795a();
    }

    public final void mo798a(SchedulerConstraint schedulerConstraint, boolean z) {
        synchronized (this.f12137e) {
            for (int size = this.f12137e.size() - 1; size >= 0; size--) {
                if (((ConstraintWrapper) this.f12137e.get(size)).f2832c.f3077a.equals(schedulerConstraint.f3077a)) {
                    this.f12137e.remove(size);
                }
            }
        }
        this.f12136d.mo798a(schedulerConstraint, false);
        if (z) {
            mo797a(schedulerConstraint);
        }
    }
}
