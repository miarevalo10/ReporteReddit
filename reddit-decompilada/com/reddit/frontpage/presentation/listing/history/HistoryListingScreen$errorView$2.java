package com.reddit.frontpage.presentation.listing.history;

import android.view.View;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: HistoryListingScreen.kt */
final class HistoryListingScreen$errorView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ HistoryListingScreen f36686a;

    HistoryListingScreen$errorView$2(HistoryListingScreen historyListingScreen) {
        this.f36686a = historyListingScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View c = this.f36686a.K;
        if (c == null) {
            Intrinsics.m26842a();
        }
        return c.findViewById(C1761R.id.error_view);
    }
}