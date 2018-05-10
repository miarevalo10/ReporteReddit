package com.reddit.frontpage.presentation.listing.popular;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.presentation.listing.model.LinkMapper;
import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter.PopularLoadResult.Success;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012L\u0010\u0002\u001aH\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u00128\u00126\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \b*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0007 \b*\u001a\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \b*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0007\u0018\u00010\t0\u00060\u0003H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/popular/PopularListingPresenter$PopularLoadResult;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "kotlin.jvm.PlatformType", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: PopularListingPresenter.kt */
final class PopularListingPresenter$loadListingAndSetOnView$3<T, R> implements Function<T, R> {
    public static final PopularListingPresenter$loadListingAndSetOnView$3 f28443a = new PopularListingPresenter$loadListingAndSetOnView$3();

    PopularListingPresenter$loadListingAndSetOnView$3() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "<name for destructuring parameter 0>");
        Listing listing = (Listing) pair.f25267a;
        obj = (List) pair.f25268b;
        LinkMapper linkMapper = LinkMapper.f20611a;
        List a = LinkMapper.m22970a(listing.getChildren());
        Intrinsics.m26843a(obj, "adsList");
        return new Success(listing, a, obj);
    }
}
