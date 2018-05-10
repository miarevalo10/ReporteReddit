package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/ILink;", "it", "Lcom/reddit/frontpage/domain/model/Link;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditLinkRepository.kt */
final class RedditLinkRepository$getFrontpage$local$1<T, R> implements Function<T, R> {
    public static final RedditLinkRepository$getFrontpage$local$1 f16072a = new RedditLinkRepository$getFrontpage$local$1();

    RedditLinkRepository$getFrontpage$local$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Listing listing = (Listing) obj;
        Intrinsics.b(listing, "it");
        return listing;
    }
}
