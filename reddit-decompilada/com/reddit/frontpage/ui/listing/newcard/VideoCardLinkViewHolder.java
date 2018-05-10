package com.reddit.frontpage.ui.listing.newcard;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.HomeScreen;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.ui.listing.BaseLinkListingScreen;
import com.reddit.frontpage.ui.listing.newcard.video.VideoLifecycleDelegate;
import com.reddit.frontpage.ui.listing.newcard.video.VideoView;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.BaseHeaderView;
import com.reddit.frontpage.widgets.LinkTitleView;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;

public class VideoCardLinkViewHolder extends LinkViewHolder implements VisibilityDependent, VideoView {
    @BindView
    LinkFlairView flairView;
    @BindView
    SimpleExoPlayerView simpleExoPlayerView;
    @BindView
    LinkTitleView titleView;
    public final VideoLifecycleDelegate f37304v;
    @BindView
    View videoContainer;
    private final int f37305w;
    private MainActivity f37306x;

    public final void mo6966b(LinkPresentationModel linkPresentationModel) {
    }

    public final String mo6971y() {
        return "listing";
    }

    public final String mo6972z() {
        return "FEED_";
    }

    public static VideoCardLinkViewHolder m37649a(ViewGroup viewGroup, Consumer<Integer> consumer, Consumer<Integer> consumer2) {
        return new VideoCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_video_card_link_legacy, viewGroup, false), consumer, consumer2);
    }

    private VideoCardLinkViewHolder(View view, Consumer<Integer> consumer, Consumer<Integer> consumer2) {
        super(view);
        view = Util.m24014d(view.getContext());
        if (view instanceof MainActivity) {
            this.f37306x = (MainActivity) view;
        }
        view = view.getWindow().getDecorView();
        this.f37305w = view.getWidth();
        this.f37304v = new VideoLifecycleDelegate(this.f37305w, view.getHeight(), this, this.videoContainer, this.simpleExoPlayerView);
        this.f37304v.f21434o = consumer;
        this.f37304v.f21435p = consumer2;
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.f37304v.f21433n = d();
        this.f37304v.m23518a(link);
        this.titleView.mo7025a(link);
        this.flairView.m23474a(link);
        this.c.requestLayout();
        if ((this.b instanceof BaseHeaderView) != null && this.f37304v.f21426g != null) {
            this.b.mo5063a(new VideoCardLinkViewHolder$$Lambda$0(this));
        }
    }

    protected final void mo7003b(boolean z) {
        this.flairView.setShowLinkFlair(z);
    }

    protected final void mo7001a(int i) {
        this.titleView.setTextColor(this.titleView.getTextColors().withAlpha(i));
    }

    public final void mo7006w() {
        this.f37304v.m23522b();
    }

    public final void ap() {
        this.f37304v.m23526d();
    }

    public final void aq() {
        this.f37304v.m23527e();
    }

    public final String mo6970x() {
        Activity d = Util.m24014d(this.c.getContext());
        if (d instanceof MainActivity) {
            Screen a = Routing.m22618a(((MainActivity) d).mo7779h());
            if (a instanceof HomeScreen) {
                return ((HomeScreen) a).f39134w != 1 ? "frontpage" : "popular";
            } else {
                if (a instanceof BaseLinkListingScreen) {
                    return ((BaseLinkListingScreen) a).mo7451T();
                }
            }
        }
        return null;
    }

    public final void ad_() {
        if (this.f37304v != null) {
            this.f37304v.m23517a(d());
        }
    }

    public final void m37655I() {
        this.f37304v.f21424e = true;
    }

    public final int mo6959E() {
        return this.f37305w;
    }

    public final boolean mo6957C() {
        return this.f37306x != null && this.f37306x.f40815d;
    }

    public final void a_(Link link) {
        this.p.mo4993a(link);
    }

    public final boolean mo6958D() {
        if (this.f37306x != null) {
            if (this.f37306x.isChangingConfigurations()) {
                return false;
            }
        }
        return true;
    }

    public final void mo6493F() {
        super.mo6493F();
        this.f37304v.m23528f();
    }

    public final boolean mo6956B() {
        return this.f != d();
    }
}
