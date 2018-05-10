package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.Params;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import com.reddit.frontpage.util.Util;
import io.reactivex.Completable;

public class ApproveJob extends AbstractApiJob {
    protected final String f19443n;

    public ApproveJob(Session session, String str) {
        Params params = new Params(500);
        params.f2940b = ModQueueOptionsPresenter.ACTION_APPROVE;
        StringBuilder stringBuilder = new StringBuilder(ModQueueOptionsPresenter.ACTION_APPROVE);
        stringBuilder.append(str);
        params.f2941c = stringBuilder.toString();
        params = params.m2535a();
        super(session, params);
        this.f19443n = str;
    }

    protected final String mo4209g() {
        return Util.f(C1761R.string.error_approve_failure);
    }

    protected final Completable mo4208f() {
        RemoteRedditApiDataSource remoteRedditApiDataSource = new RemoteRedditApiDataSource();
        return RemoteRedditApiDataSource.m8940q(this.f19443n);
    }
}
