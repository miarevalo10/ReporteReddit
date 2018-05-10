package com.firebase.jobdispatcher;

import android.os.Bundle;

public final class Job implements JobParameters {
    final String f12722a;
    final String f12723b;
    final JobTrigger f12724c;
    private final RetryStrategy f12725d;
    private final int f12726e;
    private final boolean f12727f;
    private final int[] f12728g;
    private final boolean f12729h;
    private final Bundle f12730i;

    public static final class Builder implements JobParameters {
        public String f12712a;
        public JobTrigger f12713b = Trigger.f3883a;
        public int f12714c = 1;
        public int[] f12715d;
        public boolean f12716e = false;
        public boolean f12717f = false;
        private final ValidationEnforcer f12718g;
        private String f12719h;
        private Bundle f12720i;
        private RetryStrategy f12721j = RetryStrategy.f3878a;

        Builder(ValidationEnforcer validationEnforcer) {
            this.f12718g = validationEnforcer;
        }

        Builder(ValidationEnforcer validationEnforcer, JobParameters jobParameters) {
            this.f12718g = validationEnforcer;
            this.f12712a = jobParameters.mo1249e();
            this.f12719h = jobParameters.mo1253i();
            this.f12713b = jobParameters.mo1250f();
            this.f12717f = jobParameters.mo1252h();
            this.f12714c = jobParameters.mo1251g();
            this.f12715d = jobParameters.mo1245a();
            this.f12720i = jobParameters.mo1246b();
            this.f12721j = jobParameters.mo1247c();
        }

        public final Builder m11826j() {
            this.f12716e = true;
            return this;
        }

        public final Job m11827k() {
            ValidationEnforcer.m11848a(this.f12718g.mo1240a((JobParameters) this));
            return new Job();
        }

        public final String mo1253i() {
            return this.f12719h;
        }

        public final Builder m11814a(Class<? extends JobService> cls) {
            this.f12719h = cls.getName();
            return this;
        }

        public final String mo1249e() {
            return this.f12712a;
        }

        public final Builder m11815a(String str) {
            this.f12712a = str;
            return this;
        }

        public final JobTrigger mo1250f() {
            return this.f12713b;
        }

        public final Builder m11812a(JobTrigger jobTrigger) {
            this.f12713b = jobTrigger;
            return this;
        }

        public final int mo1251g() {
            return this.f12714c;
        }

        public final Builder m11828l() {
            this.f12714c = 2;
            return this;
        }

        public final boolean mo1252h() {
            return this.f12717f;
        }

        public final Builder m11829m() {
            this.f12717f = true;
            return this;
        }

        public final int[] mo1245a() {
            return this.f12715d == null ? new int[0] : this.f12715d;
        }

        public final Builder m11816a(int... iArr) {
            this.f12715d = iArr;
            return this;
        }

        public final Bundle mo1246b() {
            return this.f12720i;
        }

        public final Builder m11811a(Bundle bundle) {
            this.f12720i = bundle;
            return this;
        }

        public final RetryStrategy mo1247c() {
            return this.f12721j;
        }

        public final Builder m11813a(RetryStrategy retryStrategy) {
            this.f12721j = retryStrategy;
            return this;
        }

        public final boolean mo1248d() {
            return this.f12716e;
        }
    }

    private Job(Builder builder) {
        this.f12722a = builder.f12719h;
        this.f12730i = builder.f12720i;
        this.f12723b = builder.f12712a;
        this.f12724c = builder.f12713b;
        this.f12725d = builder.f12721j;
        this.f12726e = builder.f12714c;
        this.f12727f = builder.f12717f;
        this.f12728g = builder.f12715d != null ? builder.f12715d : new int[0];
        this.f12729h = builder.f12716e;
    }

    public final int[] mo1245a() {
        return this.f12728g;
    }

    public final Bundle mo1246b() {
        return this.f12730i;
    }

    public final RetryStrategy mo1247c() {
        return this.f12725d;
    }

    public final boolean mo1248d() {
        return this.f12729h;
    }

    public final String mo1249e() {
        return this.f12723b;
    }

    public final JobTrigger mo1250f() {
        return this.f12724c;
    }

    public final int mo1251g() {
        return this.f12726e;
    }

    public final boolean mo1252h() {
        return this.f12727f;
    }

    public final String mo1253i() {
        return this.f12722a;
    }
}
