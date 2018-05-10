package com.reddit.frontpage.presentation.listing.submitted;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onRefresh"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class UserSubmittedListingScreen$onCreateView$2 implements OnRefreshListener {
    final /* synthetic */ UserSubmittedListingScreen f28468a;

    UserSubmittedListingScreen$onCreateView$2(UserSubmittedListingScreen userSubmittedListingScreen) {
        this.f28468a = userSubmittedListingScreen;
    }

    public final void m29700a() {
        UserSubmittedListingPresenter w = this.f28468a.m40712w();
        w.f36739e.mo7371d();
        w.f36738d = null;
        w.m37195b();
    }
}
