package com.reddit.datalibrary.frontpage.data.feature.category.repo;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "after", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditCategoryRepository.kt */
final class RedditCategoryRepository$remoteGetSubredditsInCategory$1 extends Lambda implements Function1<String, Single<Listing<? extends Subreddit>>> {
    final /* synthetic */ RedditCategoryRepository f19352a;
    final /* synthetic */ String f19353b;

    RedditCategoryRepository$remoteGetSubredditsInCategory$1(RedditCategoryRepository redditCategoryRepository, String str) {
        this.f19352a = redditCategoryRepository;
        this.f19353b = str;
        super(1);
    }

    public final /* synthetic */ Object m20622a(Object obj) {
        return this.f19352a.f15805f.subredditsInCategory(this.f19353b, (String) obj);
    }
}
