package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.LinkFooterView;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeader;
import com.reddit.frontpage.presentation.listing.ui.view.LinkHeaderView;
import com.reddit.frontpage.presentation.listing.ui.view.OnboardingLinkHeaderView;
import com.reddit.frontpage.presentation.listing.ui.view.SubscribeLinkHeaderView;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 R2\u00020\u0001:\u0001RB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020(H\u0002J\u0010\u0010A\u001a\u00020(2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020\u0006H\u0016J\b\u0010E\u001a\u00020(H\u0016J\u000e\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020\u0006J\u000e\u0010H\u001a\u00020(2\u0006\u0010>\u001a\u00020IJ\u0010\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020\u0006H\u0016J\u0010\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020\u0006H\u0016J\u0010\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020\u0006H$J\u0010\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020CH$R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@DX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020 @BX.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R4\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R4\u00104\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R\u001c\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006S"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "displayLinkFlair", "", "getDisplayLinkFlair", "()Z", "setDisplayLinkFlair", "(Z)V", "displayReadStatus", "getDisplayReadStatus", "setDisplayReadStatus", "footerView", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView;", "getFooterView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView;", "footerView$delegate", "Lkotlin/Lazy;", "headerStub", "Landroid/view/ViewStub;", "getHeaderStub", "()Landroid/view/ViewStub;", "headerStub$delegate", "<set-?>", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeader;", "headerView", "getHeaderView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeader;", "setHeaderView", "(Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeader;)V", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "link", "getLink", "()Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "setLink", "(Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;)V", "value", "Lkotlin/Function0;", "", "onCommentClickAction", "getOnCommentClickAction", "()Lkotlin/jvm/functions/Function0;", "setOnCommentClickAction", "(Lkotlin/jvm/functions/Function0;)V", "onLinkHiddenListener", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnLinkHiddenListener;", "getOnLinkHiddenListener", "()Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnLinkHiddenListener;", "setOnLinkHiddenListener", "(Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnLinkHiddenListener;)V", "onShareClickAction", "getOnShareClickAction", "setOnShareClickAction", "onViewMediaListener", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnViewMediaListener;", "getOnViewMediaListener", "()Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnViewMediaListener;", "setOnViewMediaListener", "(Lcom/reddit/frontpage/presentation/listing/ui/viewholder/OnViewMediaListener;)V", "addOnVoteChangeListener", "listener", "Lcom/reddit/frontpage/widgets/vote/OnVoteChangeListener;", "attachMenuListener", "bindLink", "getCategory", "", "isSelfSustained", "onNavigateToPager", "setDisplaySubreddit", "displaySubreddit", "setOnModerateListener", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModerateListener;", "setOnboardingHeader", "show", "setSubscribeHeader", "showDisplaySubscribeHeader", "updateLinkFlairVisibility", "visible", "updateReadStatus", "alpha", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkViewHolder.kt */
public abstract class LinkViewHolder extends ListingViewHolder {
    private static final String f34033A = "post_save";
    private static final String f34034B = "post_unsave";
    private static final float f34035C = 0.5f;
    private static final float f34036D = 1.0f;
    private static final int f34037E = 128;
    private static final int f34038F = 255;
    static final /* synthetic */ KProperty[] f34039p = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkViewHolder.class), "headerStub", "getHeaderStub()Landroid/view/ViewStub;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkViewHolder.class), "footerView", "getFooterView()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView;"))};
    public static final Companion f34040w = new Companion();
    private static final String f34041z = "post_hide";
    private final Lazy f34042a;
    private final Lazy f34043b;
    protected LinkHeader f34044q;
    public OnViewMediaListener f34045r;
    public OnLinkHiddenListener f34046s;
    Function0<Unit> f34047t;
    public boolean f34048u;
    public boolean f34049v;
    private Function0<Unit> f34050x;
    private LinkPresentationModel f34051y;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder$Companion;", "", "()V", "ALPHA_FULLY_OPAQUE", "", "getALPHA_FULLY_OPAQUE", "()F", "ALPHA_OPAQUE", "", "getALPHA_OPAQUE", "()I", "ALPHA_TRANSLUCENT", "getALPHA_TRANSLUCENT", "ALPHA_TRANSLUCENT_FLOAT", "getALPHA_TRANSLUCENT_FLOAT", "POST_HIDE_CONTROL_NAME", "", "getPOST_HIDE_CONTROL_NAME", "()Ljava/lang/String;", "POST_SAVE_CONTROL_NAME", "getPOST_SAVE_CONTROL_NAME", "POST_UNSAVE_CONTROL_NAME", "getPOST_UNSAVE_CONTROL_NAME", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static boolean m34762P() {
        return false;
    }

    private final ViewStub mo6968v() {
        return (ViewStub) this.f34042a.mo5678b();
    }

    public final LinkFooterView m34772N() {
        return (LinkFooterView) this.f34043b.mo5678b();
    }

    public final int mo6480Q() {
        return 7;
    }

    protected abstract void mo6962a(int i);

    protected abstract void mo6967b(boolean z);

    public void mo6969w() {
    }

    public LinkViewHolder(View view) {
        Intrinsics.m26847b(view, "itemView");
        super(view);
        this.f34042a = LazyKt.m26777a(new LinkViewHolder$headerStub$2(view));
        this.f34043b = LazyKt.m26777a(new LinkViewHolder$footerView$2(view));
    }

    public final LinkHeader m34771M() {
        LinkHeader linkHeader = this.f34044q;
        if (linkHeader == null) {
            Intrinsics.m26844a("headerView");
        }
        return linkHeader;
    }

    protected final void m34778a(LinkHeader linkHeader) {
        Intrinsics.m26847b(linkHeader, "<set-?>");
        this.f34044q = linkHeader;
    }

    public final void m34780a(Function0<Unit> function0) {
        m34772N().setOnCommentClickAction(function0);
        this.f34050x = function0;
    }

    public final void m34781b(Function0<Unit> function0) {
        m34772N().setOnShareClickAction(function0);
        this.f34047t = function0;
    }

    public final LinkPresentationModel m34773O() {
        LinkPresentationModel linkPresentationModel = this.f34051y;
        if (linkPresentationModel == null) {
            Intrinsics.m26844a("link");
        }
        return linkPresentationModel;
    }

    public void mo6963a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        this.f34051y = linkPresentationModel;
        LinkHeader linkHeader = this.f34044q;
        if (linkHeader == null) {
            Intrinsics.m26844a("headerView");
        }
        linkHeader.a_(linkPresentationModel);
        m34772N().m23016a(linkPresentationModel);
        if (this.f34048u) {
            mo6962a(linkPresentationModel.f33972Y ? f34037E : f34038F);
        }
        mo6967b(this.f34049v);
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "sessionManager");
        Session c = b.c();
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        Context context = obj.getContext();
        LinkHeader linkHeader2 = this.f34044q;
        if (linkHeader2 == null) {
            Intrinsics.m26844a("headerView");
        }
        linkHeader2.setOnMenuItemClickListener(new LinkViewHolder$attachMenuListener$1(this, context, b, c));
        if (!ModUtil.m23824a().getRemovedState(linkPresentationModel.getName(), linkPresentationModel.ab)) {
            if (!ModUtil.m23824a().m30459d(linkPresentationModel.getName(), linkPresentationModel.ac)) {
                b = this.c;
                Intrinsics.m26843a(b, "itemView");
                b.setAlpha(f34036D);
                linkHeader = this.f34044q;
                if (linkHeader == null) {
                    Intrinsics.m26844a("headerView");
                }
                linkHeader.setDomainClickListener(new LinkViewHolder$bindLink$1(this, linkPresentationModel));
            }
        }
        b = this.c;
        Intrinsics.m26843a(b, "itemView");
        b.setAlpha(f34035C);
        linkHeader = this.f34044q;
        if (linkHeader == null) {
            Intrinsics.m26844a("headerView");
        }
        linkHeader.setDomainClickListener(new LinkViewHolder$bindLink$1(this, linkPresentationModel));
    }

    public final void m34779a(OnVoteChangeListener onVoteChangeListener) {
        Intrinsics.m26847b(onVoteChangeListener, "listener");
        LinkFooterView N = m34772N();
        Intrinsics.m26847b(onVoteChangeListener, "onVoteChangeListener");
        N.f20743b.add(onVoteChangeListener);
    }

    public void mo6973c(boolean z) {
        if (z) {
            z = mo6968v();
            if (z) {
                z.setLayoutResource(C1761R.layout.subscribe_link_header_view);
            }
            z = mo6968v();
            z = z ? z.inflate() : false;
            if (z) {
                this.f34044q = (SubscribeLinkHeaderView) z;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.ui.view.SubscribeLinkHeaderView");
        }
        z = mo6968v();
        if (z) {
            z.setLayoutResource(C1761R.layout.link_header_view);
            z.getLayoutParams().height = Util.m24012d((int) C1761R.dimen.linkheader_height);
            z = z.inflate();
            if (z) {
                this.f34044q = (LinkHeaderView) z;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.ui.view.LinkHeaderView");
        }
    }

    public final void m34775R() {
        ViewStub v = mo6968v();
        if (v != null) {
            v.setLayoutResource(C1761R.layout.onboarding_link_header_view);
        }
        v = mo6968v();
        View inflate = v != null ? v.inflate() : null;
        if (inflate == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.ui.view.OnboardingLinkHeaderView");
        }
        this.f34044q = (OnboardingLinkHeaderView) inflate;
    }

    public final void m34784d(boolean z) {
        LinkHeader linkHeader = this.f34044q;
        if (linkHeader == null) {
            Intrinsics.m26844a("headerView");
        }
        linkHeader.setDisplaySubredditName(z);
    }
}
