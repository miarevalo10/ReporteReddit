package com.reddit.frontpage.presentation.listing.history;

import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryListingPresenter.kt */
final class HistoryListingPresenter$clearRecentsHistory$1 implements Action {
    final /* synthetic */ HistoryListingPresenter f28399a;

    HistoryListingPresenter$clearRecentsHistory$1(HistoryListingPresenter historyListingPresenter) {
        this.f28399a = historyListingPresenter;
    }

    public final void run() {
        this.f28399a.m37087a(this.f28399a.f36667e, null, true, (Function0) HistoryListingPresenter$loadListingAndSetOnView$1.f36657a);
    }
}
