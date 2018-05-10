package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "listing", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerLoadData.kt */
final class LinkPagerLoadData$getLinks$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ LinkPagerLoadData f28002a;
    final /* synthetic */ int f28003b;
    final /* synthetic */ boolean f28004c;
    final /* synthetic */ int f28005d;
    final /* synthetic */ Function3 f28006e;
    final /* synthetic */ String f28007f;
    final /* synthetic */ String f28008g;

    LinkPagerLoadData$getLinks$1(LinkPagerLoadData linkPagerLoadData, int i, boolean z, int i2, Function3 function3, String str, String str2) {
        this.f28002a = linkPagerLoadData;
        this.f28003b = i;
        this.f28004c = z;
        this.f28005d = i2;
        this.f28006e = function3;
        this.f28007f = str;
        this.f28008g = str2;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final Listing listing = (Listing) obj;
        Intrinsics.m26847b(listing, "listing");
        int size = listing.getChildren().size() + this.f28003b;
        if (!(this.f28004c || listing.getAfter() == null)) {
            if (this.f28005d == -1 || size - this.f28005d <= 5) {
                return LinkPagerLoadData.m29325a(this.f28002a, this.f28006e, this.f28005d, size, listing.getAfter(), this.f28007f, this.f28008g, false, 64).map(new Function<T, R>() {
                    public final /* synthetic */ Object apply(Object obj) {
                        Listing listing = (Listing) obj;
                        Intrinsics.m26847b(listing, "it");
                        return new Listing(CollectionsKt___CollectionsKt.m41423b((Collection) listing.getChildren(), (Iterable) listing.getChildren()), listing.getAfter(), listing.getBefore(), listing.getAdDistance());
                    }
                });
            }
        }
        return Single.just(listing);
    }
}
