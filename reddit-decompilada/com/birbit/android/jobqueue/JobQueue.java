package com.birbit.android.jobqueue;

import java.util.Set;

public interface JobQueue {
    int mo805a();

    int mo806a(Constraint constraint);

    JobHolder mo807a(String str);

    void mo808a(JobHolder jobHolder, JobHolder jobHolder2);

    boolean mo809a(JobHolder jobHolder);

    JobHolder mo810b(Constraint constraint);

    void mo811b();

    boolean mo812b(JobHolder jobHolder);

    Long mo813c(Constraint constraint);

    void mo814c(JobHolder jobHolder);

    Set<JobHolder> mo815d(Constraint constraint);

    void mo816d(JobHolder jobHolder);
}
