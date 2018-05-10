package com.reddit.frontpage.presentation.listing.history;

import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "listingSort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryListingPresenter.kt */
final class HistoryListingPresenter$attach$1<T> implements Consumer<SortSelection<HistorySortType>> {
    final /* synthetic */ HistoryListingPresenter f28398a;

    HistoryListingPresenter$attach$1(HistoryListingPresenter historyListingPresenter) {
        this.f28398a = historyListingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        SortSelection sortSelection = (SortSelection) obj;
        this.f28398a.f36663a.mo7661a((HistorySortType) sortSelection.a.f20414c);
        HistoryListingPresenter historyListingPresenter = this.f28398a;
        HistorySortType historySortType = (HistorySortType) sortSelection.a.f20414c;
        Intrinsics.m26847b(historySortType, "sort");
        historyListingPresenter.f36663a.mo7660a();
        historyListingPresenter.m37087a(historySortType, null, true, (Function0) HistoryListingPresenter$loadListingAndSetOnView$1.f36657a);
    }
}
