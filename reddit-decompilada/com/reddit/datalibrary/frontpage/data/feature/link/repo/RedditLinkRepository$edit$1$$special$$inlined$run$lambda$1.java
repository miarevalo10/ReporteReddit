package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Result.Success;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/Result$Success;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "localLink", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$edit$1$$special$$inlined$run$lambda$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ Link f16068a;
    final /* synthetic */ RedditLinkRepository$edit$1 f16069b;

    RedditLinkRepository$edit$1$$special$$inlined$run$lambda$1(Link link, RedditLinkRepository$edit$1 redditLinkRepository$edit$1) {
        this.f16068a = link;
        this.f16069b = redditLinkRepository$edit$1;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Link link = (Link) obj;
        Intrinsics.b(link, "localLink");
        link = Link.copy$default(this.f16068a, null, null, 0, null, null, null, 0, null, 0, 0, 0, null, null, null, null, null, null, null, null, null, false, 0, false, false, null, null, null, null, null, null, null, null, false, null, null, null, false, false, false, false, false, false, false, false, false, null, null, false, false, false, null, false, false, null, null, null, null, link.getSubredditDetail(), false, false, null, null, null, false, -1, -33554433, null);
        return this.f16069b.f16070a.f16099j.mo2953a(link).onErrorComplete().andThen(Single.just(new Success(link)));
    }
}
