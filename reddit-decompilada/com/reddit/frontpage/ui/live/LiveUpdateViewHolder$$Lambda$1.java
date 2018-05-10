package com.reddit.frontpage.ui.live;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate.MobileEmbed;

final /* synthetic */ class LiveUpdateViewHolder$$Lambda$1 implements OnClickListener {
    private final MobileEmbed f21447a;

    LiveUpdateViewHolder$$Lambda$1(MobileEmbed mobileEmbed) {
        this.f21447a = mobileEmbed;
    }

    public final void onClick(View view) {
        LiveUpdateViewHolder.m30267a(this.f21447a, view);
    }
}
