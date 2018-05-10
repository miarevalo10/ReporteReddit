package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.config.Configuration;

public interface QueueFactory {
    JobQueue mo802a(long j);

    JobQueue mo803a(Configuration configuration, long j);
}
