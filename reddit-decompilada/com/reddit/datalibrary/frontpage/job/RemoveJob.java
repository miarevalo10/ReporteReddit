package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import com.reddit.frontpage.util.Util;
import io.reactivex.Completable;

public class RemoveJob extends AbstractApiJob {
    protected final String f19451n;
    protected boolean f19452o;

    public RemoveJob(Session session, String str, boolean z) {
        Params params = new Params(500);
        params.f2940b = ModQueueOptionsPresenter.ACTION_REMOVE;
        StringBuilder stringBuilder = new StringBuilder(ModQueueOptionsPresenter.ACTION_REMOVE);
        stringBuilder.append(str);
        params.f2941c = stringBuilder.toString();
        params = params.m2535a();
        super(session, params);
        this.f19451n = str;
        this.f19452o = z;
    }

    protected final String mo4209g() {
        return Util.f(C1761R.string.error_remove_failure);
    }

    protected final Completable mo4208f() {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        return RemoteRedditApiDataSource.m8910c(this.f19451n, this.f19452o);
    }
}
