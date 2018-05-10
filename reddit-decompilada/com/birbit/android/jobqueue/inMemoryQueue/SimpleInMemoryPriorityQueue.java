package com.birbit.android.jobqueue.inMemoryQueue;

import com.birbit.android.jobqueue.Constraint;
import com.birbit.android.jobqueue.JobHolder;
import com.birbit.android.jobqueue.JobQueue;
import com.birbit.android.jobqueue.TagConstraint;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

public class SimpleInMemoryPriorityQueue implements JobQueue {
    private final TreeSet<JobHolder> f12165a = new TreeSet(new C02511(this));
    private final Map<String, JobHolder> f12166b = new HashMap();
    private final AtomicLong f12167c = new AtomicLong(0);
    private final List<String> f12168d = new ArrayList();
    private final long f12169e;

    class C02511 implements Comparator<JobHolder> {
        final /* synthetic */ SimpleInMemoryPriorityQueue f2981a;

        private static int m2552a(long j, long j2) {
            return j > j2 ? -1 : j2 > j ? 1 : 0;
        }

        C02511(SimpleInMemoryPriorityQueue simpleInMemoryPriorityQueue) {
            this.f2981a = simpleInMemoryPriorityQueue;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            JobHolder jobHolder = (JobHolder) obj;
            JobHolder jobHolder2 = (JobHolder) obj2;
            int i = 0;
            if (jobHolder.f2921m.f2880a.equals(jobHolder2.f2921m.f2880a)) {
                return 0;
            }
            int i2 = jobHolder.f2912d;
            int i3 = jobHolder2.f2912d;
            if (i2 > i3) {
                i = -1;
            } else if (i3 > i2) {
                i = 1;
            }
            if (i != 0) {
                return i;
            }
            i2 = -C02511.m2552a(jobHolder.f2916h, jobHolder2.f2916h);
            if (i2 != 0) {
                return i2;
            }
            return -C02511.m2552a(jobHolder.f2909a.longValue(), jobHolder2.f2909a.longValue());
        }
    }

    public SimpleInMemoryPriorityQueue(long j) {
        this.f12169e = j;
    }

    public final boolean mo809a(JobHolder jobHolder) {
        jobHolder.m2516a(this.f12167c.incrementAndGet());
        if (((JobHolder) this.f12166b.get(jobHolder.f2910b)) != null) {
            throw new IllegalArgumentException("cannot add a job with the same id twice");
        }
        this.f12166b.put(jobHolder.f2910b, jobHolder);
        this.f12165a.add(jobHolder);
        return true;
    }

    public final void mo808a(JobHolder jobHolder, JobHolder jobHolder2) {
        mo814c(jobHolder2);
        mo809a(jobHolder);
    }

    public final void mo814c(JobHolder jobHolder) {
        this.f12166b.remove(jobHolder.f2910b);
        this.f12165a.remove(jobHolder);
    }

    public final int mo805a() {
        return this.f12165a.size();
    }

    public final int mo806a(Constraint constraint) {
        this.f12168d.clear();
        Iterator it = this.f12165a.iterator();
        int i = 0;
        while (it.hasNext()) {
            JobHolder jobHolder = (JobHolder) it.next();
            String str = jobHolder.f2913e;
            if ((str == null || !this.f12168d.contains(str)) && m11038a(jobHolder, constraint, false)) {
                i++;
                if (str != null) {
                    this.f12168d.add(str);
                }
            }
        }
        this.f12168d.clear();
        return i;
    }

    public final JobHolder mo810b(Constraint constraint) {
        Iterator it = this.f12165a.iterator();
        while (it.hasNext()) {
            JobHolder jobHolder = (JobHolder) it.next();
            if (m11038a(jobHolder, constraint, false)) {
                mo814c(jobHolder);
                jobHolder.f2914f++;
                jobHolder.f2917i = this.f12169e;
                return jobHolder;
            }
        }
        return null;
    }

    public final Long mo813c(Constraint constraint) {
        Iterator it = this.f12165a.iterator();
        Long l = null;
        while (it.hasNext()) {
            JobHolder jobHolder = (JobHolder) it.next();
            boolean z = true;
            if (m11038a(jobHolder, constraint, true)) {
                long min;
                if (!(jobHolder.f2915g != Long.MIN_VALUE) || !m11038a(jobHolder, constraint, false)) {
                    z = false;
                }
                boolean d = jobHolder.m2520d();
                if (d == z) {
                    min = Math.min(jobHolder.f2919k, jobHolder.f2915g);
                } else if (d) {
                    min = jobHolder.f2919k;
                } else {
                    min = jobHolder.f2915g;
                }
                if (l == null || min < l.longValue()) {
                    l = Long.valueOf(min);
                }
            }
        }
        return l;
    }

    public final void mo811b() {
        this.f12165a.clear();
        this.f12166b.clear();
    }

    public final JobHolder mo807a(String str) {
        return (JobHolder) this.f12166b.get(str);
    }

    public final Set<JobHolder> mo815d(Constraint constraint) {
        Set<JobHolder> hashSet = new HashSet();
        Iterator it = this.f12165a.iterator();
        while (it.hasNext()) {
            JobHolder jobHolder = (JobHolder) it.next();
            if (m11038a(jobHolder, constraint, false)) {
                hashSet.add(jobHolder);
            }
        }
        return hashSet;
    }

    public final void mo816d(JobHolder jobHolder) {
        mo814c(jobHolder);
    }

    public final boolean mo812b(JobHolder jobHolder) {
        if (jobHolder.f2909a == null) {
            return mo809a(jobHolder);
        }
        JobHolder jobHolder2 = (JobHolder) this.f12166b.get(jobHolder.f2910b);
        if (jobHolder2 != null) {
            mo814c(jobHolder2);
        }
        this.f12166b.put(jobHolder.f2910b, jobHolder);
        this.f12165a.add(jobHolder);
        return true;
    }

    private static boolean m11038a(JobHolder jobHolder, Constraint constraint, boolean z) {
        if (constraint.f2855h < jobHolder.f2919k) {
            if (!z || !jobHolder.m2520d()) {
                z = false;
                if (z && constraint.f2848a < jobHolder.f2918j) {
                    return false;
                }
                if (!constraint.f2854g && jobHolder.f2915g > constraint.f2854g.longValue()) {
                    return false;
                }
                if ((!jobHolder.f2913e && constraint.f2851d.contains(jobHolder.f2913e)) || constraint.f2852e.contains(jobHolder.f2910b)) {
                    return false;
                }
                if (constraint.f2849b) {
                    if (jobHolder.m2514a() && !constraint.f2850c.isEmpty()) {
                        z = constraint.f2849b;
                        Constraint<String> constraint2 = constraint.f2850c;
                        jobHolder = jobHolder.m2514a();
                        if (z != TagConstraint.ANY) {
                            for (String contains : constraint2) {
                                if (!jobHolder.contains(contains)) {
                                    jobHolder = 1;
                                    break;
                                }
                            }
                        } else {
                            for (String contains2 : constraint2) {
                                if (!jobHolder.contains(contains2)) {
                                }
                            }
                            jobHolder = 1;
                            if (jobHolder != null) {
                            }
                        }
                        jobHolder = null;
                        if (jobHolder != null) {
                        }
                    }
                }
            }
        }
        z = true;
        if (z) {
        }
        if (!constraint.f2854g) {
        }
        if (!jobHolder.f2913e) {
        }
        if (constraint.f2849b) {
            z = constraint.f2849b;
            Constraint<String> constraint22 = constraint.f2850c;
            jobHolder = jobHolder.m2514a();
            if (z != TagConstraint.ANY) {
                while (constraint.hasNext()) {
                    if (jobHolder.contains(contains2)) {
                    }
                }
                jobHolder = 1;
                if (jobHolder != null) {
                }
            }
            while (constraint.hasNext()) {
                if (!jobHolder.contains(contains2)) {
                    jobHolder = 1;
                    break;
                }
            }
            jobHolder = null;
            return jobHolder != null;
        }
    }
}
