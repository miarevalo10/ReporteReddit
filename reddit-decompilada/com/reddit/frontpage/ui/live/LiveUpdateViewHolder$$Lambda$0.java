package com.reddit.frontpage.ui.live;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate.MobileEmbed;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class LiveUpdateViewHolder$$Lambda$0 implements OnClickListener {
    private final MobileEmbed f21446a;

    LiveUpdateViewHolder$$Lambda$0(MobileEmbed mobileEmbed) {
        this.f21446a = mobileEmbed;
    }

    public final void onClick(View view) {
        Util.m23968a(Util.m24014d(view.getContext()), Uri.parse(this.f21446a.getUrl()), "live_thread");
    }
}
