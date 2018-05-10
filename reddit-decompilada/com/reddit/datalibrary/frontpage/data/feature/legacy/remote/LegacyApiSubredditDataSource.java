package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditNameInfo;
import com.reddit.frontpage.FrontpageApplication;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

@Deprecated
public class LegacyApiSubredditDataSource implements LegacyRemoteSubredditDataSource {
    @Inject
    RemoteRedditApiDataSource f15875a;

    public LegacyApiSubredditDataSource() {
        FrontpageApplication.m().a(this);
    }

    public final Listing<Subreddit> mo2946a() throws Exception {
        return (Listing) RemoteRedditApiDataSource.m8913c(null).blockingGet();
    }

    public final Listing<Subreddit> mo2947a(String str) throws Exception {
        return (Listing) RemoteRedditApiDataSource.m8890a(str, null).blockingGet();
    }

    public final Listing<Subreddit> mo2950b() throws Exception {
        return (Listing) RemoteRedditApiDataSource.m8903b(null).blockingGet();
    }

    public final List<Multireddit> mo2952c() throws Exception {
        return (List) RemoteRedditApiDataSource.m8882a().blockingGet();
    }

    public final Multireddit mo2948a(String str, String str2) throws Exception {
        return (Multireddit) RemoteRedditApiDataSource.m8904b(str, str2).blockingGet();
    }

    public final List<SubredditNameInfo> mo2951b(String str) throws Exception {
        return (List) RemoteRedditApiDataSource.m8933j(str).blockingGet();
    }

    public final void mo2949a(Collection<String> collection) throws Exception {
        RemoteRedditApiDataSource.m8879a(Boolean.valueOf(true), (Collection) collection).blockingGet();
    }
}
