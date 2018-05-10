package com.reddit.frontpage.ui.detail.xpost;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.LightboxActivity;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.listing.newcard.XpostImageCardBodyView;
import com.reddit.frontpage.ui.listing.newcard.video.VideoLifecycleDelegate;
import com.reddit.frontpage.ui.listing.newcard.video.VideoView;
import com.reddit.frontpage.util.CrosspostUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;
import org.parceler.Parcels;

public class XPostVideoDetailScreen extends XPostDetailScreen implements VideoView {
    Link aa;
    private int ab;
    private int ac = null;
    private VideoLifecycleDelegate ad;

    public final boolean mo6956B() {
        return false;
    }

    public final void ad_() {
    }

    public final void mo6966b(LinkPresentationModel linkPresentationModel) {
    }

    public final String mo7684x() {
        return null;
    }

    public final String mo6971y() {
        return "comments";
    }

    public final String mo6972z() {
        return "DETAILS_";
    }

    public static XPostVideoDetailScreen m42487a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new XPostVideoDetailScreen(bundle2);
    }

    public XPostVideoDetailScreen(Bundle bundle) {
        super(bundle);
    }

    public final void mo7209b(Activity activity) {
        super.mo7209b(activity);
        if (this.aa != null && this.ad.f21426g == null && FrontpageApplication.m28865a(MainActivity.class.getSimpleName()) != null && FrontpageApplication.m28867b(LightboxActivity.class.getSimpleName()) == null) {
            mo7690f(true);
        }
    }

    protected final void mo6993c(View view) {
        if (this.ad != null) {
            this.ad.m23529g();
        }
        super.mo6993c(view);
    }

    public final int ag() {
        return this.ac;
    }

    public final void mo7690f(boolean z) {
        if (this.ad != null) {
            this.ad.m23521a(z);
        }
    }

    protected final void mo7691P() {
        super.mo7691P();
        if (this.ad.f21426g != null) {
            VideoLifecycleDelegate videoLifecycleDelegate;
            if (m39095Q()) {
                videoLifecycleDelegate = this.ad;
                if (!(videoLifecycleDelegate.f21426g == null || !videoLifecycleDelegate.f21425f || videoLifecycleDelegate.f21426g.m24371g())) {
                    videoLifecycleDelegate.f21426g.m24366c();
                    ScreenUtil.m23890b(videoLifecycleDelegate.f21421b);
                }
                return;
            }
            videoLifecycleDelegate = this.ad;
            if (videoLifecycleDelegate.f21426g != null && videoLifecycleDelegate.f21426g.m24371g()) {
                videoLifecycleDelegate.f21426g.m24368d();
                ScreenUtil.m23891c(videoLifecycleDelegate.f21421b);
            }
        }
    }

    public final boolean mo6957C() {
        return am_() != null && ((MainActivity) am_()).f40815d;
    }

    public final void a_(Link link) {
        IntentUtil.m23757a(am_(), this.aa, m39101W() != null ? "onboarding_post_detail" : "post_detail");
    }

    public final boolean mo6958D() {
        if (am_() != null) {
            if (am_().isChangingConfigurations()) {
                return false;
            }
        }
        return true;
    }

    public final int mo6959E() {
        return this.ab;
    }

    public final View mo7682T() {
        XpostImageCardBodyView xpostImageCardBodyView = (XpostImageCardBodyView) LayoutInflater.from(this.f39167y.getContext()).inflate(C1761R.layout.xpost_video_bordered, this.f39167y, false);
        this.aa = Util.m23994b(this.f39153F);
        if (this.aa == null) {
            return xpostImageCardBodyView;
        }
        this.videoContainer = (FrameLayout) xpostImageCardBodyView.findViewById(C1761R.id.video_container);
        this.simpleExoPlayerView = (SimpleExoPlayerView) xpostImageCardBodyView.findViewById(C1761R.id.video_player);
        xpostImageCardBodyView.m23495a(this.aa);
        View decorView = am_().getWindow().getDecorView();
        int a = CrosspostUtil.m23675a();
        this.ab = a;
        this.ad = new VideoLifecycleDelegate(decorView.getWidth(), decorView.getHeight(), this, this.videoContainer, this.simpleExoPlayerView);
        this.ad.m23518a(this.aa);
        xpostImageCardBodyView.setOnClickListener(new XPostVideoDetailScreen$$Lambda$0(this));
        this.ac = XPostDetailScreen.m42217a(xpostImageCardBodyView, a);
        return xpostImageCardBodyView;
    }
}
