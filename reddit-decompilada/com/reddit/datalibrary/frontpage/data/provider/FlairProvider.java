package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SchedulerProvider;
import io.reactivex.Flowable;
import java.util.List;
import javax.inject.Inject;

public class FlairProvider extends BaseOtherProvider {
    @Inject
    RemoteRedditApiDataSource f16237a;

    public FlairProvider() {
        FrontpageApplication.m().a(this);
    }

    public static Flowable<List<LinkFlair>> m16242a(String str) {
        return RemoteRedditApiDataSource.m8947x(str).toFlowable().onErrorReturn(FlairProvider$$Lambda$0.f16236a).subscribeOn(SchedulerProvider.b());
    }
}
