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
import com.reddit.frontpage.util.CrosspostUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;

public class XPostVideoCardLinkViewHolder extends LinkViewHolder implements VisibilityDependent, VideoView {
    @BindView
    XpostImageCardBodyView borderedView;
    @BindView
    SmallCardBodyView cardBodyView;
    @BindView
    SimpleExoPlayerView simpleExoPlayerView;
    private final VideoLifecycleDelegate f37320v;
    @BindView
    View videoContainer;
    private final int f37321w;
    private MainActivity f37322x;

    public final void mo6966b(LinkPresentationModel linkPresentationModel) {
    }

    public final String mo6971y() {
        return "listing";
    }

    public final String mo6972z() {
        return "FEED_";
    }

    public static XPostVideoCardLinkViewHolder m37701a(ViewGroup viewGroup, Consumer<Integer> consumer, Consumer<Integer> consumer2) {
        return new XPostVideoCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_xpost_video_card_legacy, viewGroup, false), consumer, consumer2);
    }

    private XPostVideoCardLinkViewHolder(View view, Consumer<Integer> consumer, Consumer<Integer> consumer2) {
        super(view);
        view = Util.m24014d(view.getContext());
        if (view instanceof MainActivity) {
            this.f37322x = (MainActivity) view;
        }
        view = view.getWindow().getDecorView();
        this.f37321w = view.getWidth();
        this.f37320v = new VideoLifecycleDelegate(this.f37321w, view.getHeight(), this, this.videoContainer, this.simpleExoPlayerView);
        this.f37320v.f21434o = consumer;
        this.f37320v.f21435p = consumer2;
        this.cardBodyView.setXpostPreviewOnClickListener(new XPostVideoCardLinkViewHolder$$Lambda$0(this));
        this.cardBodyView.setXpostEmbedOnClickListener(new XPostVideoCardLinkViewHolder$$Lambda$1(this));
    }

    final /* synthetic */ void m37708J() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.p.mo4993a(b);
        }
    }

    final /* synthetic */ void m37707I() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.f37320v.m23522b();
            this.p.mo4995c(b);
        }
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.cardBodyView.m23486a(link);
        link = Util.m23994b(link);
        if (link != null) {
            this.f37320v.f21433n = d();
            this.f37320v.m23518a(link);
            this.c.requestLayout();
        }
    }

    protected final void mo7003b(boolean z) {
        this.cardBodyView.setShowLinkFlair(z);
    }

    protected final void mo7001a(int i) {
        this.cardBodyView.setTitleAlpha(i);
    }

    public final void mo7006w() {
        this.f37320v.m23522b();
    }

    public final void ap() {
        this.f37320v.m23526d();
    }

    public final void aq() {
        this.f37320v.m23527e();
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
        this.f37320v.m23517a(d());
    }

    public final boolean mo6957C() {
        return this.f37322x != null && this.f37322x.f40815d;
    }

    public final void a_(Link link) {
        this.p.mo4993a(link);
    }

    public final boolean mo6958D() {
        if (this.f37322x != null) {
            if (this.f37322x.isChangingConfigurations()) {
                return false;
            }
        }
        return true;
    }

    public final int mo6959E() {
        return CrosspostUtil.m23675a();
    }

    public final void mo6493F() {
        super.mo6493F();
        this.f37320v.m23528f();
    }

    public final boolean mo6956B() {
        return this.f != d();
    }
}
