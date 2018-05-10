package com.reddit.frontpage.presentation.listing.history;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.presentation.listing.history.HistoryListingPresenter.HistoryLoadResult.Success;
import com.reddit.frontpage.presentation.listing.model.LinkMapper;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult;", "listing", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryListingPresenter.kt */
final class HistoryListingPresenter$loadListingAndSetOnView$2<T, R> implements Function<T, R> {
    public static final HistoryListingPresenter$loadListingAndSetOnView$2 f28400a = new HistoryListingPresenter$loadListingAndSetOnView$2();

    HistoryListingPresenter$loadListingAndSetOnView$2() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        Listing listing = (Listing) obj;
        Intrinsics.m26847b(listing, "listing");
        LinkMapper linkMapper = LinkMapper.f20611a;
        return new Success(listing, LinkMapper.m22970a(listing.getChildren()));
    }
}
