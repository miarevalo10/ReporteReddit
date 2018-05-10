package com.reddit.frontpage.ui.listing.newcard.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class VideoLifecycleDelegate$$Lambda$0 implements OnClickListener {
    private final VideoLifecycleDelegate f21411a;
    private final Link f21412b;

    VideoLifecycleDelegate$$Lambda$0(VideoLifecycleDelegate videoLifecycleDelegate, Link link) {
        this.f21411a = videoLifecycleDelegate;
        this.f21412b = link;
    }

    public final void onClick(View view) {
        view = this.f21411a;
        Link link = this.f21412b;
        view.f21422c.ad_();
        if (view.f21427h) {
            view.m23516a();
            return;
        }
        if (!view.f21430k) {
            view.f21430k = true;
            if (view.f21426g == null) {
                view.m23531i();
            }
            view.f21426g.m24361a(view.f21429j, Util.m24038j(link), view.f21427h);
            view.f21426g.m24359a(link, view.f21422c.mo6971y(), view.f21422c.mo6970x());
            view.f21423d.setPlayer(view.f21426g.f22221c);
            view.f21431l = true;
            view.f21426g.m24366c();
            ScreenUtil.m23890b(view.f21421b);
            if (view.f21426g.f22223e == null) {
                FrontpageApplication.m28873i().mo5025a().m23652a();
            }
            VideoLifecycleDelegate.f21419a.onNext(link.getId());
        }
    }
}
