package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.log.JqLog;
import com.birbit.android.jobqueue.timer.Timer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class RunningJobSet {
    long f2954a = Long.MAX_VALUE;
    private ArrayList<String> f2955b;
    private final TreeSet<String> f2956c = new TreeSet();
    private final Map<String, Long> f2957d = new HashMap();
    private final Timer f2958e;

    public RunningJobSet(Timer timer) {
        this.f2958e = timer;
    }

    public final synchronized void m2543a(String str, long j) {
        JqLog.m2558a("add group delay to %s until %s", str, Long.valueOf(j));
        Long l = (Long) this.f2957d.get(str);
        if (l == null || l.longValue() <= j) {
            this.f2957d.put(str, Long.valueOf(j));
            this.f2954a = m2540b();
            this.f2955b = null;
        }
    }

    public final synchronized Collection<String> m2541a() {
        long a = this.f2958e.mo829a();
        if (this.f2955b == null || a > this.f2954a) {
            if (this.f2957d.isEmpty()) {
                this.f2955b = new ArrayList(this.f2956c);
                this.f2954a = Long.MAX_VALUE;
            } else {
                Collection treeSet = new TreeSet(this.f2956c);
                Iterator it = this.f2957d.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (((Long) entry.getValue()).longValue() <= a) {
                        it.remove();
                    } else if (!treeSet.contains(entry.getKey())) {
                        treeSet.add(entry.getKey());
                    }
                }
                this.f2955b = new ArrayList(treeSet);
                this.f2954a = m2540b();
            }
        }
        return this.f2955b;
    }

    private long m2540b() {
        long j = Long.MAX_VALUE;
        for (Long l : this.f2957d.values()) {
            if (l.longValue() < j) {
                j = l.longValue();
            }
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m2542a(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        if (r2 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r1);
        return;
    L_0x0005:
        r0 = r1.f2956c;	 Catch:{ all -> 0x0012 }
        r2 = r0.add(r2);	 Catch:{ all -> 0x0012 }
        if (r2 == 0) goto L_0x0010;
    L_0x000d:
        r2 = 0;
        r1.f2955b = r2;	 Catch:{ all -> 0x0012 }
    L_0x0010:
        monitor-exit(r1);
        return;
    L_0x0012:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.RunningJobSet.a(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m2544b(java.lang.String r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        if (r2 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r1);
        return;
    L_0x0005:
        r0 = r1.f2956c;	 Catch:{ all -> 0x0012 }
        r2 = r0.remove(r2);	 Catch:{ all -> 0x0012 }
        if (r2 == 0) goto L_0x0010;
    L_0x000d:
        r2 = 0;
        r1.f2955b = r2;	 Catch:{ all -> 0x0012 }
    L_0x0010:
        monitor-exit(r1);
        return;
    L_0x0012:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.birbit.android.jobqueue.RunningJobSet.b(java.lang.String):void");
    }
}
