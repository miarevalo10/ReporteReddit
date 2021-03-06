package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.SubredditDataModel;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012(\u0010\u0003\u001a$\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00010\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "it", "", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditDataModel;", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLocalSubredditDataSource.kt */
final class RedditLocalSubredditDataSource$getFollowingSubreddits$1<T, R> implements Function<T, R> {
    public static final RedditLocalSubredditDataSource$getFollowingSubreddits$1 f16153a = new RedditLocalSubredditDataSource$getFollowingSubreddits$1();

    RedditLocalSubredditDataSource$getFollowingSubreddits$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "it");
        Iterable<SubredditDataModel> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (SubredditDataModel c : iterable) {
            Object c2 = SubredditConverter.f18710a.mo3582a().m14544c(c);
            if (c2 == null) {
                Intrinsics.a();
            }
            arrayList.add((Subreddit) c2);
        }
        return (List) arrayList;
    }
}
