package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinksLoadData.kt */
final class LinksLoadData$build$1<T, R> implements Function<T, R> {
    final /* synthetic */ LinksLoadData f28014a;
    final /* synthetic */ LinksLoadDataParams f28015b;

    LinksLoadData$build$1(LinksLoadData linksLoadData, LinksLoadDataParams linksLoadDataParams) {
        this.f28014a = linksLoadData;
        this.f28015b = linksLoadDataParams;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Listing listing = (Listing) obj;
        Intrinsics.m26847b(listing, "it");
        return new Listing(LinksLoadData.m29330a(listing.getChildren(), this.f28015b.f28017a), listing.getAfter(), listing.getBefore(), listing.getAdDistance());
    }
}
