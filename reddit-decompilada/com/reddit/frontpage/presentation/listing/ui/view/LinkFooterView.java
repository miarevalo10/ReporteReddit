package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.Votable;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo;
import com.reddit.datalibrary.frontpage.requests.models.Votable.AdAnalyticsInfo.Companion;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ShareEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v1.ShareEvent;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.listing.BaseLinkListingScreen;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.DrawableTextView;
import com.reddit.frontpage.widgets.vote.OnVoteChangeListener;
import com.reddit.frontpage.widgets.vote.VoteView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003TUVB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020:J\u000e\u0010B\u001a\u00020,2\u0006\u0010 \u001a\u00020!J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0002J\b\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020,H\u0002J\u000e\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020\u0007J\u000e\u0010K\u001a\u00020,2\u0006\u00101\u001a\u000202J\u000e\u0010L\u001a\u00020,2\u0006\u00103\u001a\u000204J\b\u0010M\u001a\u00020,H\u0002J\b\u0010N\u001a\u00020,H\u0002J\u0018\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0019\u0010\u0010R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b#\u0010\u0016R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b'\u0010(R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X.¢\u0006\u0002\n\u0000R\"\u00105\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010.\"\u0004\b7\u00100R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8BX\u0002¢\u0006\f\n\u0004\b?\u0010\u0012\u001a\u0004\b=\u0010>¨\u0006W"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "SHARE_CONTROL_NAME", "", "commentContainer", "Landroid/view/View;", "getCommentContainer", "()Landroid/view/View;", "commentContainer$delegate", "Lkotlin/Lazy;", "commentCountText", "Landroid/widget/TextView;", "getCommentCountText", "()Landroid/widget/TextView;", "commentCountText$delegate", "extraActionContainer", "getExtraActionContainer", "extraActionContainer$delegate", "extraActionText", "Lcom/reddit/frontpage/widgets/DrawableTextView;", "getExtraActionText", "()Lcom/reddit/frontpage/widgets/DrawableTextView;", "extraActionText$delegate", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "liveCommentCountText", "getLiveCommentCountText", "liveCommentCountText$delegate", "liveCommentIcon", "Landroid/widget/ImageView;", "getLiveCommentIcon", "()Landroid/widget/ImageView;", "liveCommentIcon$delegate", "onCommentClickAction", "Lkotlin/Function0;", "", "getOnCommentClickAction", "()Lkotlin/jvm/functions/Function0;", "setOnCommentClickAction", "(Lkotlin/jvm/functions/Function0;)V", "onModActionCompletedListener", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModActionCompletedListener;", "onModerateListener", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModerateListener;", "onShareClickAction", "getOnShareClickAction", "setOnShareClickAction", "voteChangeListeners", "", "Lcom/reddit/frontpage/widgets/vote/OnVoteChangeListener;", "voteView", "Lcom/reddit/frontpage/widgets/vote/VoteView;", "getVoteView", "()Lcom/reddit/frontpage/widgets/vote/VoteView;", "voteView$delegate", "addOnVoteChangeListener", "onVoteChangeListener", "bindLink", "getActionIconDrawable", "Landroid/graphics/drawable/Drawable;", "drawable", "getShareEventBuilder", "Lcom/reddit/frontpage/commons/analytics/AppAnalytics$ShareEventBuilder;", "saveShareEvent", "setLiveCommentCount", "liveCommentCount", "setOnModActionCompletedListener", "setOnModerateListener", "shimmerShareView", "showModeratorPopup", "updateCommentCount", "count", "", "locked", "", "OnModActionCompletedListener", "OnModerateListener", "OnShareListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkFooterView.kt */
public final class LinkFooterView extends LinearLayout {
    static final /* synthetic */ KProperty[] f20742a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkFooterView.class), "commentContainer", "getCommentContainer()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkFooterView.class), "commentCountText", "getCommentCountText()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkFooterView.class), "voteView", "getVoteView()Lcom/reddit/frontpage/widgets/vote/VoteView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkFooterView.class), "extraActionContainer", "getExtraActionContainer()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkFooterView.class), "liveCommentIcon", "getLiveCommentIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkFooterView.class), "liveCommentCountText", "getLiveCommentCountText()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkFooterView.class), "extraActionText", "getExtraActionText()Lcom/reddit/frontpage/widgets/DrawableTextView;"))};
    public final List<OnVoteChangeListener> f20743b;
    private final String f20744c;
    private LinkPresentationModel f20745d;
    private final Lazy f20746e;
    private final Lazy f20747f;
    private final Lazy f20748g;
    private final Lazy f20749h;
    private final Lazy f20750i;
    private final Lazy f20751j;
    private final Lazy f20752k;
    private Function0<Unit> f20753l;
    private Function0<Unit> f20754m;
    private OnModerateListener f20755n;
    private OnModActionCompletedListener f20756o;
    private HashMap f20757p;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModActionCompletedListener;", "", "onActionCompleted", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkFooterView.kt */
    public interface OnModActionCompletedListener {
        void mo4904a();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H&¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView$OnModerateListener;", "", "onApprove", "", "onDistinguishChanged", "setDistinguished", "", "onLockCommentsChanged", "setLockComments", "onMarkNsfwChanged", "setNsfw", "onMarkSpoilerChanged", "setSpoiler", "onRemove", "onRemoveAsSpam", "onStickyChanged", "setStickyPost", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkFooterView.kt */
    public interface OnModerateListener {
        void mo4831a();

        void mo4832b();

        void mo4833c();

        void mo4834d();

        void mo4835e();

        void mo4836f();

        void mo4837g();

        void mo4838h();
    }

    public LinkFooterView(Context context) {
        this(context, null, 0, 6, null);
    }

    public LinkFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final View getCommentContainer() {
        return (View) this.f20746e.mo5678b();
    }

    private final TextView getCommentCountText() {
        return (TextView) this.f20747f.mo5678b();
    }

    private final View getExtraActionContainer() {
        return (View) this.f20749h.mo5678b();
    }

    private final DrawableTextView getExtraActionText() {
        return (DrawableTextView) this.f20752k.mo5678b();
    }

    private final TextView getLiveCommentCountText() {
        return (TextView) this.f20751j.mo5678b();
    }

    private final ImageView getLiveCommentIcon() {
        return (ImageView) this.f20750i.mo5678b();
    }

    private final VoteView getVoteView() {
        return (VoteView) this.f20748g.mo5678b();
    }

    public final View m23015a(int i) {
        if (this.f20757p == null) {
            this.f20757p = new HashMap();
        }
        View view = (View) this.f20757p.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f20757p.put(Integer.valueOf(i), view);
        return view;
    }

    public final Function0<Unit> getOnShareClickAction() {
        return this.f20753l;
    }

    public final void setOnShareClickAction(Function0<Unit> function0) {
        this.f20753l = function0;
    }

    public final Function0<Unit> getOnCommentClickAction() {
        return this.f20754m;
    }

    public final void setOnCommentClickAction(Function0<Unit> function0) {
        this.f20754m = function0;
    }

    public /* synthetic */ LinkFooterView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = C1761R.attr.linkFooterViewStyle;
        }
        this(context, attributeSet, i);
    }

    public LinkFooterView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20744c = "post_share";
        this.f20746e = LazyKt.m26777a((Function0) new LinkFooterView$commentContainer$2(this));
        this.f20747f = LazyKt.m26777a((Function0) new LinkFooterView$commentCountText$2(this));
        this.f20748g = LazyKt.m26777a((Function0) new LinkFooterView$voteView$2(this));
        this.f20749h = LazyKt.m26777a((Function0) new LinkFooterView$extraActionContainer$2(this));
        this.f20750i = LazyKt.m26777a((Function0) new LinkFooterView$liveCommentIcon$2(this));
        this.f20751j = LazyKt.m26777a((Function0) new LinkFooterView$liveCommentCountText$2(this));
        this.f20752k = LazyKt.m26777a((Function0) new LinkFooterView$extraActionText$2(this));
        this.f20743b = (List) new ArrayList();
        View.inflate(getContext(), C1761R.layout.merge_link_footer, this);
    }

    @TargetApi(21)
    public LinkFooterView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i, i2);
        this.f20744c = "post_share";
        this.f20746e = LazyKt.m26777a((Function0) new LinkFooterView$commentContainer$2(this));
        this.f20747f = LazyKt.m26777a((Function0) new LinkFooterView$commentCountText$2(this));
        this.f20748g = LazyKt.m26777a((Function0) new LinkFooterView$voteView$2(this));
        this.f20749h = LazyKt.m26777a((Function0) new LinkFooterView$extraActionContainer$2(this));
        this.f20750i = LazyKt.m26777a((Function0) new LinkFooterView$liveCommentIcon$2(this));
        this.f20751j = LazyKt.m26777a((Function0) new LinkFooterView$liveCommentCountText$2(this));
        this.f20752k = LazyKt.m26777a((Function0) new LinkFooterView$extraActionText$2(this));
        this.f20743b = (List) new ArrayList();
        View.inflate(getContext(), C1761R.layout.merge_link_footer, this);
    }

    public final void m23016a(LinkPresentationModel linkPresentationModel) {
        String string;
        VoteView voteView;
        Votable votable;
        Companion companion;
        TextView commentCountText;
        Drawable drawable;
        DrawableTextView extraActionText;
        Intrinsics.m26847b(linkPresentationModel, "link");
        this.f20745d = linkPresentationModel;
        long j = linkPresentationModel.f33966S;
        boolean c = ModUtil.m23824a().m30457c(linkPresentationModel.getName(), linkPresentationModel.f33995v);
        if (j <= 0) {
            if (!c) {
                string = getResources().getString(C1761R.string.label_comment);
                getCommentCountText().setText(string);
                voteView = getVoteView();
                votable = linkPresentationModel;
                companion = AdAnalyticsInfo.Companion;
                voteView.m24414a(votable, Companion.a(linkPresentationModel));
                getVoteView().setEnabled(linkPresentationModel.f33989p ^ true);
                getVoteView().setOnVoteChangeListener(new LinkFooterView$bindLink$1(this, linkPresentationModel));
                getCommentContainer().setOnClickListener(new LinkFooterView$bindLink$2(this));
                commentCountText = getCommentCountText();
                drawable = getCommentCountText().getCompoundDrawablesRelative()[0];
                Intrinsics.m26843a((Object) drawable, "commentCountText.compoundDrawablesRelative[0]");
                commentCountText.setCompoundDrawablesRelative(m23009a(drawable), null, null, null);
                if (linkPresentationModel.f33968U) {
                    getExtraActionContainer().setOnClickListener(new LinkFooterView$inlined$sam$OnClickListener$i$7f478c20(new LinkFooterView$bindLink$4(this)));
                    extraActionText = getExtraActionText();
                    extraActionText.setText(C1761R.string.action_share);
                    drawable = Util.m24032h((int) C1761R.drawable.ic_icon_share);
                    Intrinsics.m26843a((Object) drawable, "Util.getDrawable(R.drawable.ic_icon_share)");
                    extraActionText.setCompoundDrawablesRelative(m23009a(drawable), null, null, null);
                    extraActionText.setEnabled(linkPresentationModel.f33989p ^ 1);
                    ViewsKt.m24106b(extraActionText, true);
                    return;
                }
                LinkFooterView linkFooterView = this;
                getExtraActionContainer().setOnClickListener(new LinkFooterView$inlined$sam$OnClickListener$i$7f478c20(new LinkFooterView$bindLink$3$1(linkFooterView)));
                ViewsKt.m24106b(getExtraActionText(), true);
                extraActionText = getExtraActionText();
                extraActionText.setText(C1761R.string.action_moderate);
                drawable = Util.m24032h((int) C1761R.drawable.ic_icon_moderate);
                Intrinsics.m26843a((Object) drawable, "Util.getDrawable(R.drawable.ic_icon_moderate)");
                extraActionText.setCompoundDrawablesRelative(m23009a(drawable), null, null, null);
            }
        }
        string = CountUtil.m23674a(j);
        getCommentCountText().setText(string);
        voteView = getVoteView();
        votable = linkPresentationModel;
        companion = AdAnalyticsInfo.Companion;
        voteView.m24414a(votable, Companion.a(linkPresentationModel));
        getVoteView().setEnabled(linkPresentationModel.f33989p ^ true);
        getVoteView().setOnVoteChangeListener(new LinkFooterView$bindLink$1(this, linkPresentationModel));
        getCommentContainer().setOnClickListener(new LinkFooterView$bindLink$2(this));
        commentCountText = getCommentCountText();
        drawable = getCommentCountText().getCompoundDrawablesRelative()[0];
        Intrinsics.m26843a((Object) drawable, "commentCountText.compoundDrawablesRelative[0]");
        commentCountText.setCompoundDrawablesRelative(m23009a(drawable), null, null, null);
        if (linkPresentationModel.f33968U) {
            getExtraActionContainer().setOnClickListener(new LinkFooterView$inlined$sam$OnClickListener$i$7f478c20(new LinkFooterView$bindLink$4(this)));
            extraActionText = getExtraActionText();
            extraActionText.setText(C1761R.string.action_share);
            drawable = Util.m24032h((int) C1761R.drawable.ic_icon_share);
            Intrinsics.m26843a((Object) drawable, "Util.getDrawable(R.drawable.ic_icon_share)");
            extraActionText.setCompoundDrawablesRelative(m23009a(drawable), null, null, null);
            extraActionText.setEnabled(linkPresentationModel.f33989p ^ 1);
            ViewsKt.m24106b(extraActionText, true);
            return;
        }
        LinkFooterView linkFooterView2 = this;
        getExtraActionContainer().setOnClickListener(new LinkFooterView$inlined$sam$OnClickListener$i$7f478c20(new LinkFooterView$bindLink$3$1(linkFooterView2)));
        ViewsKt.m24106b(getExtraActionText(), true);
        extraActionText = getExtraActionText();
        extraActionText.setText(C1761R.string.action_moderate);
        drawable = Util.m24032h((int) C1761R.drawable.ic_icon_moderate);
        Intrinsics.m26843a((Object) drawable, "Util.getDrawable(R.drawable.ic_icon_moderate)");
        extraActionText.setCompoundDrawablesRelative(m23009a(drawable), null, null, null);
    }

    public final void setOnModerateListener(OnModerateListener onModerateListener) {
        Intrinsics.m26847b(onModerateListener, "onModerateListener");
        this.f20755n = onModerateListener;
    }

    public final void setOnModActionCompletedListener(OnModActionCompletedListener onModActionCompletedListener) {
        Intrinsics.m26847b(onModActionCompletedListener, "onModActionCompletedListener");
        this.f20756o = onModActionCompletedListener;
    }

    private final ShareEventBuilder getShareEventBuilder() {
        boolean c = FrontpageSettings.a().c();
        boolean d = FrontpageSettings.a().d();
        Screen a = Routing.m22617a(getContext());
        String str = null;
        String str2 = a instanceof BaseDetailScreen ? ShareEvent.SOURCE_DETAILS_SCREEN : a instanceof BaseLinkListingScreen ? ShareEvent.SOURCE_LISTINGS_SCREEN : null;
        LinkPresentationModel linkPresentationModel = this.f20745d;
        if (linkPresentationModel == null) {
            Intrinsics.m26844a("link");
        }
        if ((((CharSequence) linkPresentationModel.ag).length() == 0 ? 1 : null) == null) {
            linkPresentationModel = this.f20745d;
            if (linkPresentationModel == null) {
                Intrinsics.m26844a("link");
            }
            str = linkPresentationModel.ag;
        }
        linkPresentationModel = this.f20745d;
        if (linkPresentationModel == null) {
            Intrinsics.m26844a("link");
        }
        String str3 = linkPresentationModel.ao ? "self" : "link";
        ShareEventBuilder b = AppAnalytics.m21868e().m21834a(getExtraActionContainer()).m21836a(c).m21839b(d);
        LinkPresentationModel linkPresentationModel2 = this.f20745d;
        if (linkPresentationModel2 == null) {
            Intrinsics.m26844a("link");
        }
        b = b.m21840c(linkPresentationModel2.getName());
        linkPresentationModel2 = this.f20745d;
        if (linkPresentationModel2 == null) {
            Intrinsics.m26844a("link");
        }
        b = b.m21838b(linkPresentationModel2.ad);
        linkPresentationModel2 = this.f20745d;
        if (linkPresentationModel2 == null) {
            Intrinsics.m26844a("link");
        }
        b = b.m21842e(linkPresentationModel2.getDomain()).m21841d(str3);
        linkPresentationModel2 = this.f20745d;
        if (linkPresentationModel2 == null) {
            Intrinsics.m26844a("link");
        }
        b = b.m21843f(linkPresentationModel2.f33999z).m21835a(str2);
        linkPresentationModel2 = this.f20745d;
        if (linkPresentationModel2 == null) {
            Intrinsics.m26844a("link");
        }
        Object h = b.m21844g(linkPresentationModel2.f33979f).m21845h(str);
        Intrinsics.m26843a(h, "AppAnalytics.newShare()\n….subredditId(subredditId)");
        return h;
    }

    public final void setLiveCommentCount(int i) {
        if (i > 0) {
            getLiveCommentIcon().setVisibility(0);
            getLiveCommentCountText().setVisibility(0);
            getCommentCountText().setVisibility(8);
            getCommentContainer().setBackgroundDrawable(Util.m24032h((int) C1761R.drawable.live_comment_update_counter));
            i = CountUtil.m23674a((long) i);
            getLiveCommentCountText().setText(Util.m23960a((int) C1761R.string.live_comment_count, i));
            return;
        }
        getLiveCommentIcon().setVisibility(8);
        getLiveCommentCountText().setVisibility(8);
        getCommentCountText().setVisibility(0);
        getCommentContainer().setBackgroundDrawable(null);
    }

    private final Drawable m23009a(Drawable drawable) {
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        return ResourcesUtil.m22733e(context, drawable);
    }

    public static final /* synthetic */ void m23014e(LinkFooterView linkFooterView) {
        View view = linkFooterView;
        LinkPresentationModel linkPresentationModel = linkFooterView.f20745d;
        if (linkPresentationModel == null) {
            Intrinsics.m26844a("link");
        }
        OnModerateListener onModerateListener = linkFooterView.f20755n;
        if (onModerateListener == null) {
            Intrinsics.m26844a("onModerateListener");
        }
        Object a = AppAnalytics.m21849a(view);
        Intrinsics.m26843a(a, "AppAnalytics.findScreenName(this)");
        PopupPostModOptions popupPostModOptions = new PopupPostModOptions(view, linkPresentationModel, onModerateListener, a);
        linkFooterView = linkFooterView.f20756o;
        if (linkFooterView == null) {
            Intrinsics.m26844a("onModActionCompletedListener");
        }
        Intrinsics.m26847b(linkFooterView, "actionCompletedListener");
        popupPostModOptions.f20791b = linkFooterView;
        popupPostModOptions.f20790a.m23284a();
    }
}
