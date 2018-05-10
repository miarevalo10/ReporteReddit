package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.nytimes.android.external.store3.base.impl.Store;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"fetchFunction", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$getPopular$1 extends Lambda implements Function0<Single<Listing<? extends Link>>> {
    final /* synthetic */ RedditLinkRepository f19410a;
    final /* synthetic */ boolean f19411b;
    final /* synthetic */ RequestKey f19412c;

    RedditLinkRepository$getPopular$1(RedditLinkRepository redditLinkRepository, boolean z, RequestKey requestKey) {
        this.f19410a = redditLinkRepository;
        this.f19411b = z;
        this.f19412c = requestKey;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return m20630a();
    }

    public final Single<Listing<Link>> m20630a() {
        if (this.f19411b) {
            return ((Store) this.f19410a.f16093d.b()).mo2714b(this.f19412c);
        }
        return ((Store) this.f19410a.f16093d.b()).mo2713a(this.f19412c);
    }
}
