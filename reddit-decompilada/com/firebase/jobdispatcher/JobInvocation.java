package com.firebase.jobdispatcher;

import android.os.Bundle;

final class JobInvocation implements JobParameters {
    final String f12731a;
    final String f12732b;
    private final JobTrigger f12733c;
    private final boolean f12734d;
    private final int f12735e;
    private final int[] f12736f;
    private final Bundle f12737g;
    private final RetryStrategy f12738h;
    private final boolean f12739i;
    private final TriggerReason f12740j;

    static final class Builder {
        String f3856a;
        String f3857b;
        JobTrigger f3858c;
        boolean f3859d;
        int f3860e;
        int[] f3861f;
        final Bundle f3862g = new Bundle();
        RetryStrategy f3863h;
        boolean f3864i;
        TriggerReason f3865j;

        Builder() {
        }

        final JobInvocation m3484a() {
            if (!(this.f3856a == null || this.f3857b == null)) {
                if (this.f3858c != null) {
                    return new JobInvocation();
                }
            }
            throw new IllegalArgumentException("Required fields were not populated.");
        }
    }

    private JobInvocation(Builder builder) {
        this.f12731a = builder.f3856a;
        this.f12732b = builder.f3857b;
        this.f12733c = builder.f3858c;
        this.f12738h = builder.f3863h;
        this.f12734d = builder.f3859d;
        this.f12735e = builder.f3860e;
        this.f12736f = builder.f3861f;
        this.f12737g = builder.f3862g;
        this.f12739i = builder.f3864i;
        this.f12740j = builder.f3865j;
    }

    public final String mo1253i() {
        return this.f12732b;
    }

    public final String mo1249e() {
        return this.f12731a;
    }

    public final JobTrigger mo1250f() {
        return this.f12733c;
    }

    public final int mo1251g() {
        return this.f12735e;
    }

    public final boolean mo1252h() {
        return this.f12734d;
    }

    public final int[] mo1245a() {
        return this.f12736f;
    }

    public final Bundle mo1246b() {
        return this.f12737g;
    }

    public final RetryStrategy mo1247c() {
        return this.f12738h;
    }

    public final boolean mo1248d() {
        return this.f12739i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass().equals(obj.getClass())) {
                JobInvocation jobInvocation = (JobInvocation) obj;
                return this.f12731a.equals(jobInvocation.f12731a) && this.f12732b.equals(jobInvocation.f12732b) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * this.f12731a.hashCode()) + this.f12732b.hashCode();
    }
}
