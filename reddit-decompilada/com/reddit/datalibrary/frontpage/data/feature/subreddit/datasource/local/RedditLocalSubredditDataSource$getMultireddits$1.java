package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.MultiredditDataModel;
import com.reddit.frontpage.domain.model.Multireddit;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012(\u0010\u0003\u001a$\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00010\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Multireddit;", "it", "", "Lcom/reddit/datalibrary/frontpage/data/model/MultiredditDataModel;", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLocalSubredditDataSource.kt */
final class RedditLocalSubredditDataSource$getMultireddits$1<T, R> implements Function<T, R> {
    public static final RedditLocalSubredditDataSource$getMultireddits$1 f16155a = new RedditLocalSubredditDataSource$getMultireddits$1();

    RedditLocalSubredditDataSource$getMultireddits$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "it");
        Iterable<MultiredditDataModel> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (MultiredditDataModel c : iterable) {
            Object c2 = MultiredditConverter.f18708a.mo3582a().m14544c(c);
            if (c2 == null) {
                Intrinsics.a();
            }
            arrayList.add((Multireddit) c2);
        }
        return (List) arrayList;
    }
}
