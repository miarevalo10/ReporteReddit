package com.reddit.frontpage.presentation.listing.history;

import com.reddit.frontpage.presentation.listing.history.HistoryListingPresenter.HistoryLoadResult.Error;
import com.reddit.frontpage.presentation.listing.history.HistoryListingPresenter.HistoryLoadResult.Success;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "loadResult", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingPresenter$HistoryLoadResult;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryListingPresenter.kt */
final class HistoryListingPresenter$loadListingAndSetOnView$4<T> implements Consumer<HistoryLoadResult> {
    final /* synthetic */ HistoryListingPresenter f28402a;
    final /* synthetic */ HistorySortType f28403b;
    final /* synthetic */ boolean f28404c;
    final /* synthetic */ Function0 f28405d;
    final /* synthetic */ boolean f28406e;

    HistoryListingPresenter$loadListingAndSetOnView$4(HistoryListingPresenter historyListingPresenter, HistorySortType historySortType, boolean z, Function0 function0, boolean z2) {
        this.f28402a = historyListingPresenter;
        this.f28403b = historySortType;
        this.f28404c = z;
        this.f28405d = function0;
        this.f28406e = z2;
    }

    public final /* synthetic */ void accept(Object obj) {
        HistoryLoadResult historyLoadResult = (HistoryLoadResult) obj;
        if (historyLoadResult instanceof Error) {
            HistoryListingPresenter.m37086a(this.f28402a, this.f28403b, this.f28404c);
            return;
        }
        if (historyLoadResult instanceof Success) {
            this.f28405d.invoke();
            HistoryListingPresenter.m37084a(this.f28402a, (Success) historyLoadResult, this.f28403b, this.f28406e);
        }
    }
}
