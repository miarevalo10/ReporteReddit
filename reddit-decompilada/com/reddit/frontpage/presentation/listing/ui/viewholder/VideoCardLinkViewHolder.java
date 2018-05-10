package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.HomeScreen;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.ui.listing.BaseLinkListingScreen;
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.ui.listing.newcard.video.VideoLifecycleDelegate;
import com.reddit.frontpage.ui.listing.newcard.video.VideoView;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.BaseHeaderView;
import com.reddit.frontpage.widgets.LinkTitleView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001LB+\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\u000bJ\b\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u000208H\u0016J\b\u0010:\u001a\u00020\tH\u0016J\b\u0010;\u001a\u000208H\u0016J\b\u0010<\u001a\u000202H\u0016J\b\u0010=\u001a\u000202H\u0016J\b\u0010>\u001a\u000204H\u0016J\b\u0010?\u001a\u000204H\u0016J\b\u0010@\u001a\u000204H\u0016J\u0010\u0010A\u001a\u0002042\u0006\u00105\u001a\u00020BH\u0016J\u0010\u0010A\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\b\u0010C\u001a\u000204H\u0016J\b\u0010D\u001a\u000204H\u0016J\b\u0010E\u001a\u000204H\u0016J\b\u0010F\u001a\u000204H\u0016J\b\u0010G\u001a\u000204H\u0016J\u0010\u0010H\u001a\u0002042\u0006\u0010I\u001a\u000202H\u0014J\u0010\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020\tH\u0014R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0015\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u0010\u0015\u001a\u0004\b.\u0010/¨\u0006M"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoCardLinkViewHolder;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "Lcom/reddit/frontpage/ui/listing/newcard/video/VideoView;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoPlayable;", "itemView", "Landroid/view/View;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "lastPlayingPositionListener", "(Landroid/view/View;Lcom/reddit/frontpage/ui/listener/Consumer;Lcom/reddit/frontpage/ui/listener/Consumer;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "flairView", "Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "getFlairView", "()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "flairView$delegate", "Lkotlin/Lazy;", "mainActivity", "Lcom/reddit/frontpage/MainActivity;", "getMainActivity", "()Lcom/reddit/frontpage/MainActivity;", "screenWidth", "getScreenWidth", "()I", "screenWidth$delegate", "simpleExoPlayerView", "Lcom/reddit/frontpage/widgets/video/SimpleExoPlayerView;", "getSimpleExoPlayerView", "()Lcom/reddit/frontpage/widgets/video/SimpleExoPlayerView;", "simpleExoPlayerView$delegate", "titleView", "Lcom/reddit/frontpage/widgets/LinkTitleView;", "getTitleView", "()Lcom/reddit/frontpage/widgets/LinkTitleView;", "titleView$delegate", "videoContainer", "getVideoContainer", "()Landroid/view/View;", "videoContainer$delegate", "videoLifecycleDelegate", "Lcom/reddit/frontpage/ui/listing/newcard/video/VideoLifecycleDelegate;", "getVideoLifecycleDelegate", "()Lcom/reddit/frontpage/ui/listing/newcard/video/VideoLifecycleDelegate;", "videoLifecycleDelegate$delegate", "adapterPositionChanged", "", "bindLink", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "getListing", "", "getPageType", "getVideoContainerWidth", "getVideoPlayerOwnerIdTag", "isActivityPaused", "isNotChangingConfigurations", "notifyOffScreen", "notifyOnScreen", "onNavigateToPager", "onViewMedia", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "onViewRecycled", "propagateLastClickPosition", "retainPlayer", "startPlayer", "stopPlayer", "updateLinkFlairVisibility", "visible", "updateReadStatus", "alpha", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: VideoCardLinkViewHolder.kt */
public final class VideoCardLinkViewHolder extends LinkViewHolder implements VideoPlayable, VisibilityDependent, VideoView {
    private static final String f36928D = "listing";
    private static final String f36929E = "frontpage";
    private static final String f36930F = "popular";
    private static final String f36931G = "FEED_";
    static final /* synthetic */ KProperty[] f36932a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolder.class), "titleView", "getTitleView()Lcom/reddit/frontpage/widgets/LinkTitleView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolder.class), "flairView", "getFlairView()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolder.class), "videoContainer", "getVideoContainer()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolder.class), "simpleExoPlayerView", "getSimpleExoPlayerView()Lcom/reddit/frontpage/widgets/video/SimpleExoPlayerView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolder.class), "screenWidth", "getScreenWidth()I")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolder.class), "videoLifecycleDelegate", "getVideoLifecycleDelegate()Lcom/reddit/frontpage/ui/listing/newcard/video/VideoLifecycleDelegate;"))};
    public static final Companion f36933b = new Companion();
    private final Lazy f36934A;
    private final Lazy f36935B;
    private final Lazy f36936C;
    private final Lazy f36937x;
    private final Lazy f36938y;
    private final Lazy f36939z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoCardLinkViewHolder$Companion;", "", "()V", "LISTING_TYPE_FRONTPAGE", "", "getLISTING_TYPE_FRONTPAGE", "()Ljava/lang/String;", "LISTING_TYPE_POPULAR", "getLISTING_TYPE_POPULAR", "PAGE_TYPE_LISTING", "getPAGE_TYPE_LISTING", "VIDEO_PLAYER_OWNER_ID_TAG", "getVIDEO_PLAYER_OWNER_ID_TAG", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoCardLinkViewHolder;", "parent", "Landroid/view/ViewGroup;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "lastPlayingPositionListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: VideoCardLinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static VideoCardLinkViewHolder m23065a(ViewGroup viewGroup, Consumer<Integer> consumer, Consumer<Integer> consumer2) {
            Intrinsics.m26847b(viewGroup, "parent");
            Intrinsics.m26847b(consumer, "lastClickPositionListener");
            Intrinsics.m26847b(consumer2, "lastPlayingPositionListener");
            Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_video_card_link, viewGroup, false);
            Intrinsics.m26843a(inflate, "view");
            return new VideoCardLinkViewHolder(inflate, consumer, consumer2);
        }
    }

    private final LinkTitleView m37305Z() {
        return (LinkTitleView) this.f36937x.mo5678b();
    }

    public static final VideoCardLinkViewHolder m37306a(ViewGroup viewGroup, Consumer<Integer> consumer, Consumer<Integer> consumer2) {
        return Companion.m23065a(viewGroup, consumer, consumer2);
    }

    private final LinkFlairView aa() {
        return (LinkFlairView) this.f36938y.mo5678b();
    }

    private final int ab() {
        return ((Number) this.f36935B.mo5678b()).intValue();
    }

    public final void a_(Link link) {
        Intrinsics.m26847b(link, "link");
    }

    public final VideoLifecycleDelegate mo6968v() {
        return (VideoLifecycleDelegate) this.f36936C.mo5678b();
    }

    private VideoCardLinkViewHolder(View view, Consumer<Integer> consumer, Consumer<Integer> consumer2) {
        super(view);
        this.f36937x = LazyKt.m26777a(new VideoCardLinkViewHolder$titleView$2(view));
        this.f36938y = LazyKt.m26777a(new VideoCardLinkViewHolder$flairView$2(view));
        this.f36939z = LazyKt.m26777a(new VideoCardLinkViewHolder$videoContainer$2(view));
        this.f36934A = LazyKt.m26777a(new VideoCardLinkViewHolder$simpleExoPlayerView$2(view));
        this.f36935B = LazyKt.m26777a((Function0) new VideoCardLinkViewHolder$screenWidth$2(this));
        this.f36936C = LazyKt.m26777a((Function0) new VideoCardLinkViewHolder$videoLifecycleDelegate$2(this));
        mo6968v().m23520a((Consumer) consumer);
        mo6968v().m23524b((Consumer) consumer2);
    }

    private final Activity ac() {
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        obj = Util.m24014d(obj.getContext());
        Intrinsics.m26843a(obj, "Util.toActivity(itemView.context)");
        return obj;
    }

    private final MainActivity ad() {
        Activity ac = ac();
        if (!(ac instanceof MainActivity)) {
            ac = null;
        }
        return (MainActivity) ac;
    }

    public final void mo6963a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        super.mo6963a(linkPresentationModel);
        VideoLifecycleDelegate v = mo6968v();
        v.m23523b(d());
        v.m23519a(linkPresentationModel);
        m37305Z().m35294a(linkPresentationModel);
        aa().m23475a(linkPresentationModel);
        this.c.requestLayout();
        if ((m34771M() instanceof BaseHeaderView) != null && mo6968v().m23532j() != null) {
            linkPresentationModel = m34771M();
            if (linkPresentationModel == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.BaseHeaderView");
            }
            ((BaseHeaderView) linkPresentationModel).m24133a(new VideoCardLinkViewHolder$bindLink$2(this));
        }
    }

    protected final void mo6967b(boolean z) {
        aa().setShowLinkFlair(z);
    }

    protected final void mo6962a(int i) {
        m37305Z().setTextColor(m37305Z().getTextColors().withAlpha(i));
    }

    public final void mo6969w() {
        mo6968v().m23522b();
    }

    public final void ap() {
        mo6968v().m23526d();
    }

    public final void aq() {
        mo6968v().m23527e();
    }

    public final String mo6970x() {
        MainActivity ad = ad();
        if (ad == null) {
            return null;
        }
        Screen a = Routing.m22618a(ad.mo7779h());
        if (a instanceof HomeScreen) {
            switch (((HomeScreen) a).m39030x()) {
                case 0:
                case 1:
                    return f36930F;
                default:
                    return f36929E;
            }
        } else if (a instanceof BaseLinkListingScreen) {
            return ((BaseLinkListingScreen) a).mo7451T();
        } else {
            return null;
        }
    }

    public final String mo6971y() {
        return f36928D;
    }

    public final String mo6972z() {
        return f36931G;
    }

    public final void ad_() {
        mo6968v().m23517a(d());
    }

    public final boolean mo6956B() {
        return e() != d();
    }

    public final int mo6959E() {
        return ab();
    }

    public final boolean mo6957C() {
        if (ad() != null) {
            MainActivity ad = ad();
            if (ad == null) {
                Intrinsics.m26842a();
            }
            if (ad.m42713j()) {
                return true;
            }
        }
        return false;
    }

    public final boolean mo6958D() {
        if (ad() != null) {
            MainActivity ad = ad();
            if (ad == null) {
                Intrinsics.m26842a();
            }
            if (ad.isChangingConfigurations()) {
                return false;
            }
        }
        return true;
    }

    public final void mo6493F() {
        super.mo6493F();
        mo6968v().m23528f();
    }

    public final void mo6960G() {
        mo6968v().m23533k();
    }

    public final void mo6961H() {
        mo6968v().m23534l();
    }

    public final void mo6966b(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        OnViewMediaListener onViewMediaListener = this.f34045r;
        if (onViewMediaListener != null) {
            onViewMediaListener.mo4828a(linkPresentationModel);
        }
    }
}
