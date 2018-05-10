package com.reddit.datalibrary.frontpage.data.feature.subreddit.repo;

import com.nytimes.android.external.store3.base.impl.Store;
import com.reddit.datalibrary.frontpage.data.model.PathKey;
import com.reddit.frontpage.domain.model.Subreddit;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"retrieve", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSubredditRepository.kt */
final class RedditSubredditRepository$getSubredditListing$1 extends Lambda implements Function0<Single<List<? extends Subreddit>>> {
    final /* synthetic */ RedditSubredditRepository f19424a;
    final /* synthetic */ boolean f19425b = true;
    final /* synthetic */ PathKey f19426c;

    RedditSubredditRepository$getSubredditListing$1(RedditSubredditRepository redditSubredditRepository, PathKey pathKey) {
        this.f19424a = redditSubredditRepository;
        this.f19426c = pathKey;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return m20655a();
    }

    public final Single<List<Subreddit>> m20655a() {
        if (this.f19425b) {
            return ((Store) this.f19424a.f16212b.b()).mo2714b(this.f19426c);
        }
        return ((Store) this.f19424a.f16212b.b()).mo2713a(this.f19426c);
    }
}
