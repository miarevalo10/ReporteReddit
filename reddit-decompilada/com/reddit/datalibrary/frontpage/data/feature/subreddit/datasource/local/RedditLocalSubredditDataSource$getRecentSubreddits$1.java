package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.RecentSubredditDataModel;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012(\u0010\u0003\u001a$\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00010\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "result", "", "Lcom/reddit/datalibrary/frontpage/data/model/RecentSubredditDataModel;", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLocalSubredditDataSource.kt */
final class RedditLocalSubredditDataSource$getRecentSubreddits$1<T, R> implements Function<T, R> {
    final /* synthetic */ RecentSubredditConverter f16156a;

    RedditLocalSubredditDataSource$getRecentSubreddits$1(RecentSubredditConverter recentSubredditConverter) {
        this.f16156a = recentSubredditConverter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "result");
        if (list.size() > 1) {
            CollectionsKt.a(list, new C0934xce287de7());
        }
        Iterable<RecentSubredditDataModel> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (RecentSubredditDataModel c : iterable) {
            Object c2 = this.f16156a.mo3582a().m14544c(c);
            if (c2 == null) {
                Intrinsics.a();
            }
            arrayList.add((Subreddit) c2);
        }
        return (List) arrayList;
    }
}
