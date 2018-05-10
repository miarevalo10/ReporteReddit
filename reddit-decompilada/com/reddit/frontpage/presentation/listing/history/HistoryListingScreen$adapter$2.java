package com.reddit.frontpage.presentation.listing.history;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen$HistoryLinkAdapter;", "Lcom/reddit/frontpage/presentation/listing/history/HistoryListingScreen;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryListingScreen.kt */
final class HistoryListingScreen$adapter$2 extends Lambda implements Function0<HistoryLinkAdapter> {
    final /* synthetic */ HistoryListingScreen f36683a;

    HistoryListingScreen$adapter$2(HistoryListingScreen historyListingScreen) {
        this.f36683a = historyListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        HistoryListingScreen historyListingScreen = this.f36683a;
        Object am_ = this.f36683a.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        HistoryLinkAdapter historyLinkAdapter = new HistoryLinkAdapter(historyListingScreen, (Context) am_);
        historyLinkAdapter.a(true);
        return historyLinkAdapter;
    }
}
