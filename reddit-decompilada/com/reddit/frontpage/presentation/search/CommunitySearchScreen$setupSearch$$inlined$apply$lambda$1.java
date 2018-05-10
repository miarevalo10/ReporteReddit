package com.reddit.frontpage.presentation.search;

import android.app.Activity;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/reddit/frontpage/presentation/search/CommunitySearchScreen$setupSearch$1$1", "Landroid/support/v7/widget/SearchView$OnQueryTextListener;", "(Lcom/reddit/frontpage/presentation/search/CommunitySearchScreen$setupSearch$1;)V", "onQueryTextChange", "", "newText", "", "onQueryTextSubmit", "query", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchScreen.kt */
public final class CommunitySearchScreen$setupSearch$$inlined$apply$lambda$1 implements OnQueryTextListener {
    final /* synthetic */ CommunitySearchScreen f28762a;
    final /* synthetic */ Activity f28763b;

    CommunitySearchScreen$setupSearch$$inlined$apply$lambda$1(CommunitySearchScreen communitySearchScreen, Activity activity) {
        this.f28762a = communitySearchScreen;
        this.f28763b = activity;
    }

    public final boolean m29867a(String str) {
        if (str == null) {
            return null;
        }
        this.f28762a.m40916w().m37463a(str);
        return true;
    }

    public final boolean m29868b(String str) {
        if (str == null) {
            return null;
        }
        this.f28762a.f40138v.onNext(str);
        return true;
    }
}
