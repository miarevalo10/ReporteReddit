package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local;

import com.reddit.datalibrary.frontpage.data.model.SubredditDataModel;
import com.reddit.frontpage.presentation.common.DateUtil;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Maybe;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "subredditDataModel", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditDataModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLocalSubredditDataSource.kt */
final class RedditLocalSubredditDataSource$getSubreddit$1<T, R> implements Function<T, MaybeSource<? extends R>> {
    public static final RedditLocalSubredditDataSource$getSubreddit$1 f16157a = new RedditLocalSubredditDataSource$getSubreddit$1();

    RedditLocalSubredditDataSource$getSubreddit$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        SubredditDataModel subredditDataModel = (SubredditDataModel) obj;
        Intrinsics.b(subredditDataModel, "subredditDataModel");
        DateUtil dateUtil = DateUtil.a;
        if (DateUtil.i(subredditDataModel.getUpdatedTimestampUtc())) {
            return Maybe.empty();
        }
        obj = SubredditConverter.f18710a.mo3582a().m14544c(subredditDataModel);
        if (obj == null) {
            Intrinsics.a();
        }
        return Maybe.just(obj);
    }
}
