package com.reddit.datalibrary.frontpage.data.common;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "listing", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubredditLoaderUtils.kt */
final class SubredditLoaderUtils$getSubreddits$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ Function1 f15725a;
    final /* synthetic */ List f15726b;

    SubredditLoaderUtils$getSubreddits$1(Function1 function1, List list) {
        this.f15725a = function1;
        this.f15726b = list;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final Listing listing = (Listing) obj;
        Intrinsics.b(listing, "listing");
        if (listing.getAfter() == null) {
            return Single.just(listing);
        }
        SubredditLoaderUtils subredditLoaderUtils = SubredditLoaderUtils.f10303a;
        return SubredditLoaderUtils.m8761b(this.f15725a, this.f15726b, listing.getAfter()).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                Listing listing = (Listing) obj;
                Intrinsics.b(listing, "it");
                List arrayList = new ArrayList();
                arrayList.addAll(listing.getChildren());
                arrayList.addAll(listing.getChildren());
                return new Listing(arrayList, listing.getAfter(), listing.getBefore(), null, 8, null);
            }
        });
    }
}
