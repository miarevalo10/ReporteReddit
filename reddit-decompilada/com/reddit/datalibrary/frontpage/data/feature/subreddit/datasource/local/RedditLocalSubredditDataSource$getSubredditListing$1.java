package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import com.nytimes.android.external.store3.base.Persister;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/nytimes/android/external/store3/base/Persister;", "Lokio/BufferedSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/local/RedditLocalSubredditDataSource$SubredditListingKey;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLocalSubredditDataSource.kt */
final class RedditLocalSubredditDataSource$getSubredditListing$1 extends Lambda implements Function0<Persister<BufferedSource, SubredditListingKey>> {
    final /* synthetic */ RedditLocalSubredditDataSource f19419a;

    RedditLocalSubredditDataSource$getSubredditListing$1(RedditLocalSubredditDataSource redditLocalSubredditDataSource) {
        this.f19419a = redditLocalSubredditDataSource;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return ((Persister) this.f19419a.f16166d.b());
    }
}
