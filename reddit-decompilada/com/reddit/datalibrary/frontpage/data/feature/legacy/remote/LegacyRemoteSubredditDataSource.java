package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditNameInfo;
import java.util.Collection;
import java.util.List;

@Deprecated
public interface LegacyRemoteSubredditDataSource {
    Listing<Subreddit> mo2946a() throws Exception;

    Listing<Subreddit> mo2947a(String str) throws Exception;

    Multireddit mo2948a(String str, String str2) throws Exception;

    void mo2949a(Collection<String> collection) throws Exception;

    Listing<Subreddit> mo2950b() throws Exception;

    List<SubredditNameInfo> mo2951b(String str) throws Exception;

    List<Multireddit> mo2952c() throws Exception;
}
