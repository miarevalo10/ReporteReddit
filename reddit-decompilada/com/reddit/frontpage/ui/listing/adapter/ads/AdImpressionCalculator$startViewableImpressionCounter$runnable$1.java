package com.reddit.frontpage.ui.listing.adapter.ads;

import com.reddit.datalibrary.frontpage.requests.models.v2.Identifiable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002 \u0000*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Identifiable;", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdImpressionCalculator.kt */
final class AdImpressionCalculator$startViewableImpressionCounter$runnable$1 implements Runnable {
    final /* synthetic */ AdImpressionCalculator f21329a;
    final /* synthetic */ Identifiable f21330b;

    AdImpressionCalculator$startViewableImpressionCounter$runnable$1(AdImpressionCalculator adImpressionCalculator, Identifiable identifiable) {
        this.f21329a = adImpressionCalculator;
        this.f21330b = identifiable;
    }

    public final void run() {
        this.f21329a.f21332b.put(Long.valueOf(this.f21330b.getUniqueID()), null);
        this.f21329a.f21334d.mo6492a(this.f21330b);
    }
}
