package com.reddit.datalibrary.frontpage.data.common;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/domain/model/Subreddit;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditLoaderUtils.kt */
final class SubredditLoaderUtils$getAllFromFetcher$1<T, R> implements Function<T, R> {
    public static final SubredditLoaderUtils$getAllFromFetcher$1 f15723a = new SubredditLoaderUtils$getAllFromFetcher$1();

    SubredditLoaderUtils$getAllFromFetcher$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Listing listing = (Listing) obj;
        Intrinsics.b(listing, "it");
        return listing.getChildren();
    }
}
