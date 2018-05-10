package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import de.greenrobot.event.EventBus;
import timber.log.Timber;

public abstract class BaseRedditJob extends Job {
    protected final int mo3021e() {
        return 0;
    }

    protected String mo4209g() {
        return null;
    }

    protected String mo3805h() {
        return null;
    }

    public BaseRedditJob(Params params) {
        super(params);
    }

    public final void mo3017a() {
        Timber.b("Job is being added.", new Object[0]);
    }

    public void mo3019b() throws Throwable {
        Timber.b("Job has finished running", new Object[0]);
        String h = mo3805h();
        if (h != null) {
            EventBus.getDefault().post(MessageEvent.m8764a(h));
        }
    }

    public void mo3018a(int i, Throwable th) {
        Timber.b("Job is being canceled: %d", new Object[]{Integer.valueOf(i)});
        if (i != 3) {
            i = mo4209g();
            if (i != 0) {
                EventBus.getDefault().post(MessageEvent.m8764a(i));
            }
        }
    }

    protected final RetryConstraint mo3020c() {
        return RetryConstraint.f2949b;
    }

    protected static RemoteRedditApiDataSource m16297i() {
        return new RemoteRedditApiDataSource();
    }
}
