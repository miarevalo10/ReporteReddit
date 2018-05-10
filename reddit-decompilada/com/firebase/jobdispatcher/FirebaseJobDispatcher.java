package com.firebase.jobdispatcher;

import com.firebase.jobdispatcher.Job.Builder;

public final class FirebaseJobDispatcher {
    private final Driver f3848a;
    private final ValidationEnforcer f3849b;
    private final Builder f3850c = new Builder(this.f3849b);

    public static final class ScheduleFailedException extends RuntimeException {
    }

    public FirebaseJobDispatcher(Driver driver) {
        this.f3848a = driver;
        this.f3849b = new ValidationEnforcer(driver.mo1242a());
    }

    public final int m3459a(Job job) {
        return this.f3848a.mo1241a(job);
    }

    public final void m3461b(Job job) {
        if (m3459a(job) != null) {
            throw new ScheduleFailedException();
        }
    }

    public final Builder m3460a() {
        return new Builder(this.f3849b);
    }
}
