package com.birbit.android.jobqueue;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import java.util.Set;

public class JobHolder {
    public Long f2909a;
    public final String f2910b;
    public final boolean f2911c;
    public int f2912d;
    public final String f2913e;
    public int f2914f;
    public long f2915g;
    public long f2916h;
    public long f2917i;
    public int f2918j;
    public long f2919k;
    public boolean f2920l;
    public final transient Job f2921m;
    protected final Set<String> f2922n;
    public volatile boolean f2923o;
    volatile boolean f2924p;
    RetryConstraint f2925q;
    Throwable f2926r;

    public static class Builder {
        public int f2894a = 0;
        public Long f2895b;
        private int f2896c;
        private String f2897d;
        private boolean f2898e;
        private String f2899f;
        private Job f2900g;
        private long f2901h;
        private long f2902i = Long.MIN_VALUE;
        private long f2903j;
        private long f2904k = Long.MAX_VALUE;
        private boolean f2905l = false;
        private int f2906m = 0;
        private Set<String> f2907n;
        private int f2908o;

        public final Builder m2502a(int i) {
            this.f2896c = i;
            this.f2906m |= 1;
            return this;
        }

        public final Builder m2506a(String str) {
            this.f2899f = str;
            this.f2906m |= 8;
            return this;
        }

        public final Builder m2507a(Set<String> set) {
            this.f2907n = set;
            this.f2906m |= AdRequest.MAX_CONTENT_URL_LENGTH;
            return this;
        }

        public final Builder m2508a(boolean z) {
            this.f2898e = z;
            this.f2906m |= 2;
            return this;
        }

        public final Builder m2505a(Job job) {
            this.f2900g = job;
            this.f2906m |= 16;
            return this;
        }

        public final Builder m2512b(String str) {
            this.f2897d = str;
            this.f2906m |= 4;
            return this;
        }

        public final Builder m2510b(int i) {
            this.f2908o = i;
            this.f2906m |= 1024;
            return this;
        }

        public final Builder m2503a(long j) {
            this.f2901h = j;
            this.f2906m |= 32;
            return this;
        }

        public final Builder m2511b(long j) {
            this.f2902i = j;
            this.f2906m |= 64;
            return this;
        }

        public final Builder m2513c(long j) {
            this.f2903j = j;
            this.f2906m |= 256;
            return this;
        }

        public final Builder m2504a(long j, boolean z) {
            this.f2904k = j;
            this.f2905l = z;
            this.f2906m |= 128;
            return this;
        }

        public final JobHolder m2509a() {
            if (this.f2900g == null) {
                throw new IllegalArgumentException("must provide a job");
            }
            int i = r0.f2906m & 2047;
            if (i != 2047) {
                StringBuilder stringBuilder = new StringBuilder("must provide all required fields. your result:");
                stringBuilder.append(Long.toBinaryString((long) i));
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            String str = r0.f2897d;
            boolean z = r0.f2898e;
            int i2 = r0.f2896c;
            String str2 = r0.f2899f;
            int i3 = r0.f2894a;
            Job job = r0.f2900g;
            long j = r0.f2901h;
            long j2 = r0.f2902i;
            long j3 = r0.f2903j;
            Set set = r0.f2907n;
            int i4 = r0.f2908o;
            long j4 = j3;
            long j5 = r0.f2904k;
            JobHolder jobHolder = new JobHolder(str, z, i2, str2, i3, job, j, j2, j4, set, i4, j5, r0.f2905l);
            if (r0.f2895b != null) {
                jobHolder.m2516a(r0.f2895b.longValue());
            }
            r0.f2900g.m2497a(jobHolder);
            return jobHolder;
        }
    }

    private JobHolder(String str, boolean z, int i, String str2, int i2, Job job, long j, long j2, long j3, Set<String> set, int i3, long j4, boolean z2) {
        this.f2910b = str;
        this.f2911c = z;
        this.f2912d = i;
        this.f2913e = str2;
        this.f2914f = i2;
        this.f2916h = j;
        this.f2915g = j2;
        this.f2921m = job;
        this.f2917i = j3;
        this.f2918j = i3;
        this.f2922n = set;
        this.f2919k = j4;
        this.f2920l = z2;
    }

    public final void m2516a(long j) {
        this.f2909a = Long.valueOf(j);
    }

    public final Set<String> m2514a() {
        return this.f2922n;
    }

    public final void m2518b() {
        this.f2923o = true;
        this.f2921m.f2889j = true;
    }

    public int hashCode() {
        return this.f2910b.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JobHolder)) {
            return null;
        }
        return this.f2910b.equals(((JobHolder) obj).f2910b);
    }

    public final boolean m2519c() {
        return this.f2922n != null && this.f2922n.size() > 0;
    }

    public final void m2517a(Context context) {
        this.f2921m.f2890k = context;
    }

    public final boolean m2520d() {
        return this.f2919k != Long.MAX_VALUE;
    }

    public final void m2515a(int i) {
        this.f2921m.mo3018a(i, this.f2926r);
    }
}
