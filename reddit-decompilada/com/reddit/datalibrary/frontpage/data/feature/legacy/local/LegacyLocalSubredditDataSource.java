package com.reddit.datalibrary.frontpage.data.feature.legacy.local;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.provider.DBFlowLoader;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditDisplayName;
import java.util.List;

@Deprecated
public interface LegacyLocalSubredditDataSource {
    DBFlowLoader<Subreddit> mo2933a(Context context);

    void mo2934a(Session session, Listing<Subreddit> listing);

    void mo2935a(Session session, List<Multireddit> list);

    void mo2936a(Listing<Subreddit> listing);

    List<SubredditDisplayName> mo2937b();

    void mo2938b(Session session, Listing<Subreddit> listing);

    List<SubredditDisplayName> mo2939c();
}
