package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.cachedQueue.CachedJobQueue;
import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.inMemoryQueue.SimpleInMemoryPriorityQueue;
import com.birbit.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue;
import com.birbit.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.JavaSerializer;
import com.birbit.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue.JobSerializer;

public class DefaultQueueFactory implements QueueFactory {
    JobSerializer f12142a = new JavaSerializer();

    public final JobQueue mo803a(Configuration configuration, long j) {
        return new CachedJobQueue(new SqliteJobQueue(configuration, j, this.f12142a));
    }

    public final JobQueue mo802a(long j) {
        return new CachedJobQueue(new SimpleInMemoryPriorityQueue(j));
    }
}
