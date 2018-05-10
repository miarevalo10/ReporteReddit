package com.reddit.frontpage.presentation.listing.frontpage;

import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "listingSort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingPresenter.kt */
final class FrontpageListingPresenter$attach$1<T> implements Consumer<SortSelection<SortType>> {
    final /* synthetic */ FrontpageListingPresenter f28380a;

    FrontpageListingPresenter$attach$1(FrontpageListingPresenter frontpageListingPresenter) {
        this.f28380a = frontpageListingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        SortSelection sortSelection = (SortSelection) obj;
        this.f28380a.f36634c.mo7632a((SortType) sortSelection.a.f20414c, sortSelection.b);
        FrontpageListingPresenter frontpageListingPresenter = this.f28380a;
        SortType sortType = (SortType) sortSelection.a.f20414c;
        SortTimeFrame sortTimeFrame = sortSelection.b;
        Intrinsics.m26847b(sortType, "sort");
        frontpageListingPresenter.f36634c.mo7627X();
        FrontpageListingPresenter.m37046a(frontpageListingPresenter, sortType, sortTimeFrame, true, null, null, false, null, 120);
    }
}
