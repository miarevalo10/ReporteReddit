package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.listing.MultiredditCommunitiesScreen.MultiredditCommunityViewHolder;

final /* synthetic */ class C1897xb4e8fcbe implements OnClickListener {
    private final MultiredditCommunityViewHolder f21314a;

    C1897xb4e8fcbe(MultiredditCommunityViewHolder multiredditCommunityViewHolder) {
        this.f21314a = multiredditCommunityViewHolder;
    }

    public final void onClick(View view) {
        Routing.m22623a((Screen) this.f21314a.f29064a, Nav.m22566b((String) view.getTag()));
    }
}
