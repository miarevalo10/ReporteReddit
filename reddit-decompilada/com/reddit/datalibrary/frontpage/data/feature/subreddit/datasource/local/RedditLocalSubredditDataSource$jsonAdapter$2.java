package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import com.reddit.frontpage.domain.model.Subreddit;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLocalSubredditDataSource.kt */
final class RedditLocalSubredditDataSource$jsonAdapter$2 extends Lambda implements Function0<JsonAdapter<List<? extends Subreddit>>> {
    final /* synthetic */ RedditLocalSubredditDataSource f19420a;

    RedditLocalSubredditDataSource$jsonAdapter$2(RedditLocalSubredditDataSource redditLocalSubredditDataSource) {
        this.f19420a = redditLocalSubredditDataSource;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f19420a.f16167e.a(Types.a(List.class, new Type[]{Subreddit.class}));
    }
}
