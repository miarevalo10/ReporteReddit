package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listing.adapter.ads.LegacyAdsNavigator;

final /* synthetic */ class DetailListHeader$$Lambda$0 implements OnClickListener {
    private final DetailListHeader f21166a;
    private final Link f21167b;

    DetailListHeader$$Lambda$0(DetailListHeader detailListHeader, Link link) {
        this.f21166a = detailListHeader;
        this.f21167b = link;
    }

    public final void onClick(View view) {
        view = this.f21166a;
        LegacyAdsNavigator.m23456a(view.getContext(), this.f21167b);
    }
}
