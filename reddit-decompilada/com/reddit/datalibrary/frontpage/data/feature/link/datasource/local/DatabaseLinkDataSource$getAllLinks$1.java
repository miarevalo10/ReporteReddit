package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Maybe;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "listing", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseLinkDataSource.kt */
final class DatabaseLinkDataSource$getAllLinks$1<T, R> implements Function<T, MaybeSource<? extends R>> {
    final /* synthetic */ DatabaseLinkDataSource f16018a;
    final /* synthetic */ SortType f16019b;
    final /* synthetic */ SortTimeFrame f16020c;
    final /* synthetic */ ListingType f16021d;
    final /* synthetic */ String f16022e;

    DatabaseLinkDataSource$getAllLinks$1(DatabaseLinkDataSource databaseLinkDataSource, SortType sortType, SortTimeFrame sortTimeFrame, ListingType listingType, String str) {
        this.f16018a = databaseLinkDataSource;
        this.f16019b = sortType;
        this.f16020c = sortTimeFrame;
        this.f16021d = listingType;
        this.f16022e = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final Listing listing = (Listing) obj;
        Intrinsics.b(listing, "listing");
        if (listing.getAfter() == null) {
            return Maybe.just(listing);
        }
        return this.f16018a.m15957a(this.f16019b, this.f16020c, this.f16021d, listing.getAfter(), this.f16022e).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                Listing listing = (Listing) obj;
                Intrinsics.b(listing, "it");
                return new Listing(CollectionsKt.b(listing.getChildren(), listing.getChildren()), listing.getAfter(), listing.getBefore(), listing.getAdDistance());
            }
        }).switchIfEmpty(Maybe.just(listing));
    }
}
