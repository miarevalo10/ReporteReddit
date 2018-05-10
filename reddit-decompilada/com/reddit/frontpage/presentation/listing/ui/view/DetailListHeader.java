package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u000e\u0010J\u001a\u00020G2\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020-J\u0006\u0010N\u001a\u00020&J\u0006\u0010O\u001a\u00020GJ\u001c\u0010P\u001a\u00020G2\u0014\u0010Q\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010I\u0012\u0004\u0012\u00020G0RJ\u001c\u0010S\u001a\u00020G2\u0014\u0010Q\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010I\u0012\u0004\u0012\u00020G0RJ\u000e\u0010T\u001a\u00020G2\u0006\u0010.\u001a\u00020/J\u0014\u0010U\u001a\u00020G2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WJ\u0006\u0010Y\u001a\u00020GJ\u000e\u0010Z\u001a\u00020G2\u0006\u0010[\u001a\u00020/R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b)\u0010*R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068BX\u0002¢\u0006\f\n\u0004\b9\u0010\u0010\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b<\u0010\u0010\u001a\u0004\b;\u0010*R\u001b\u0010=\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b?\u0010\u0010\u001a\u0004\b>\u0010\u0019R\u001b\u0010@\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\bB\u0010\u0010\u001a\u0004\bA\u0010*R\u001b\u0010C\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bD\u0010*¨\u0006\\"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/DetailListHeader;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "commentBar", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView;", "getCommentBar", "()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView;", "commentBar$delegate", "Lkotlin/Lazy;", "commentStackContatiner", "Landroid/view/ViewGroup;", "getCommentStackContatiner", "()Landroid/view/ViewGroup;", "commentStackContatiner$delegate", "contentPreviewContainer", "Landroid/widget/FrameLayout;", "getContentPreviewContainer", "()Landroid/widget/FrameLayout;", "contentPreviewContainer$delegate", "flairView", "Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "getFlairView", "()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "flairView$delegate", "headerMetadataStub", "Landroid/view/ViewStub;", "getHeaderMetadataStub", "()Landroid/view/ViewStub;", "headerMetadataStub$delegate", "headerMetadataView", "Lcom/reddit/frontpage/presentation/listing/ui/view/SubscribeDetailHeaderView;", "linkTitle", "Landroid/widget/TextView;", "getLinkTitle", "()Landroid/widget/TextView;", "linkTitle$delegate", "onboardingLinkHeaderView", "Lcom/reddit/frontpage/presentation/listing/ui/view/OnboardingLinkHeaderView;", "onboardingMode", "", "selfTextView", "Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "getSelfTextView", "()Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "selfTextView$delegate", "singleCommentThreadContainer", "Landroid/widget/RelativeLayout;", "getSingleCommentThreadContainer", "()Landroid/widget/RelativeLayout;", "singleCommentThreadContainer$delegate", "sortBar", "getSortBar", "sortBar$delegate", "sortBarContainer", "getSortBarContainer", "sortBarContainer$delegate", "viewAll", "getViewAll", "viewAll$delegate", "viewCount", "getViewCount", "viewCount$delegate", "addToContentPreviewContainer", "", "previewView", "Landroid/view/View;", "bindLink", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "getOnboardingLinkHeaderView", "getSubscribeDetailHeaderView", "hideSingleCommentThread", "onSortBarClick", "action", "Lkotlin/Function1;", "onViewAllClick", "setOnboardingMode", "setSort", "sortOption", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "showSingleCommentThread", "showSubscribeToggle", "shouldShowToggle", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DetailListHeader.kt */
public final class DetailListHeader extends LinearLayout {
    static final /* synthetic */ KProperty[] f20693a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "contentPreviewContainer", "getContentPreviewContainer()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "commentStackContatiner", "getCommentStackContatiner()Landroid/view/ViewGroup;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "commentBar", "getCommentBar()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkFooterView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "headerMetadataStub", "getHeaderMetadataStub()Landroid/view/ViewStub;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "linkTitle", "getLinkTitle()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "flairView", "getFlairView()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "selfTextView", "getSelfTextView()Lcom/reddit/frontpage/widgets/BaseHtmlTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "viewCount", "getViewCount()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "sortBar", "getSortBar()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "sortBarContainer", "getSortBarContainer()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "singleCommentThreadContainer", "getSingleCommentThreadContainer()Landroid/widget/RelativeLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DetailListHeader.class), "viewAll", "getViewAll()Landroid/widget/TextView;"))};
    private final Lazy f20694b;
    private final Lazy f20695c;
    private final Lazy f20696d;
    private final Lazy f20697e;
    private final Lazy f20698f;
    private final Lazy f20699g;
    private final Lazy f20700h;
    private final Lazy f20701i;
    private final Lazy f20702j;
    private final Lazy f20703k;
    private final Lazy f20704l;
    private final Lazy f20705m;
    private SubscribeDetailHeaderView f20706n;
    private OnboardingLinkHeaderView f20707o;
    private boolean f20708p;
    private HashMap f20709q;

    public DetailListHeader(Context context) {
        this(context, null, 0, 6, null);
    }

    public DetailListHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final LinkFlairView getFlairView() {
        return (LinkFlairView) this.f20699g.mo5678b();
    }

    private final ViewStub getHeaderMetadataStub() {
        return (ViewStub) this.f20697e.mo5678b();
    }

    private final TextView getLinkTitle() {
        return (TextView) this.f20698f.mo5678b();
    }

    private final BaseHtmlTextView getSelfTextView() {
        return (BaseHtmlTextView) this.f20700h.mo5678b();
    }

    private final RelativeLayout getSingleCommentThreadContainer() {
        return (RelativeLayout) this.f20704l.mo5678b();
    }

    private final TextView getSortBar() {
        return (TextView) this.f20702j.mo5678b();
    }

    private final FrameLayout getSortBarContainer() {
        return (FrameLayout) this.f20703k.mo5678b();
    }

    private final TextView getViewAll() {
        return (TextView) this.f20705m.mo5678b();
    }

    private final TextView getViewCount() {
        return (TextView) this.f20701i.mo5678b();
    }

    public final View m22992a(int i) {
        if (this.f20709q == null) {
            this.f20709q = new HashMap();
        }
        View view = (View) this.f20709q.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f20709q.put(Integer.valueOf(i), view);
        return view;
    }

    public final LinkFooterView getCommentBar() {
        return (LinkFooterView) this.f20696d.mo5678b();
    }

    public final ViewGroup getCommentStackContatiner() {
        return (ViewGroup) this.f20695c.mo5678b();
    }

    public final FrameLayout getContentPreviewContainer() {
        return (FrameLayout) this.f20694b.mo5678b();
    }

    public /* synthetic */ DetailListHeader(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public DetailListHeader(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        if (attributeSet == null) {
            Intrinsics.m26842a();
        }
        super(context, attributeSet, i);
        this.f20694b = LazyKt.m26777a((Function0) new DetailListHeader$contentPreviewContainer$2(this));
        this.f20695c = LazyKt.m26777a((Function0) new DetailListHeader$commentStackContatiner$2(this));
        this.f20696d = LazyKt.m26777a((Function0) new DetailListHeader$commentBar$2(this));
        this.f20697e = LazyKt.m26777a((Function0) new DetailListHeader$headerMetadataStub$2(this));
        this.f20698f = LazyKt.m26777a((Function0) new DetailListHeader$linkTitle$2(this));
        this.f20699g = LazyKt.m26777a((Function0) new DetailListHeader$flairView$2(this));
        this.f20700h = LazyKt.m26777a((Function0) new DetailListHeader$selfTextView$2(this));
        this.f20701i = LazyKt.m26777a((Function0) new DetailListHeader$viewCount$2(this));
        this.f20702j = LazyKt.m26777a((Function0) new DetailListHeader$sortBar$2(this));
        this.f20703k = LazyKt.m26777a((Function0) new DetailListHeader$sortBarContainer$2(this));
        this.f20704l = LazyKt.m26777a((Function0) new DetailListHeader$singleCommentThreadContainer$2(this));
        this.f20705m = LazyKt.m26777a((Function0) new DetailListHeader$viewAll$2(this));
        setOrientation(1);
        LinearLayout.inflate(getContext(), C1761R.layout.merge_listheader_link_detail, this);
    }

    @TargetApi(21)
    public DetailListHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f20694b = LazyKt.m26777a((Function0) new DetailListHeader$contentPreviewContainer$2(this));
        this.f20695c = LazyKt.m26777a((Function0) new DetailListHeader$commentStackContatiner$2(this));
        this.f20696d = LazyKt.m26777a((Function0) new DetailListHeader$commentBar$2(this));
        this.f20697e = LazyKt.m26777a((Function0) new DetailListHeader$headerMetadataStub$2(this));
        this.f20698f = LazyKt.m26777a((Function0) new DetailListHeader$linkTitle$2(this));
        this.f20699g = LazyKt.m26777a((Function0) new DetailListHeader$flairView$2(this));
        this.f20700h = LazyKt.m26777a((Function0) new DetailListHeader$selfTextView$2(this));
        this.f20701i = LazyKt.m26777a((Function0) new DetailListHeader$viewCount$2(this));
        this.f20702j = LazyKt.m26777a((Function0) new DetailListHeader$sortBar$2(this));
        this.f20703k = LazyKt.m26777a((Function0) new DetailListHeader$sortBarContainer$2(this));
        this.f20704l = LazyKt.m26777a((Function0) new DetailListHeader$singleCommentThreadContainer$2(this));
        this.f20705m = LazyKt.m26777a((Function0) new DetailListHeader$viewAll$2(this));
        setOrientation(1);
        LinearLayout.inflate(getContext(), C1761R.layout.merge_listheader_link_detail, this);
    }

    public final SubscribeDetailHeaderView getSubscribeDetailHeaderView() {
        if (this.f20708p) {
            throw new IllegalStateException("Tried to access subscribe header in onboarding flow");
        }
        if (this.f20706n == null) {
            getHeaderMetadataStub().setLayoutResource(C1761R.layout.listheader_subscribe_detail);
            View inflate = getHeaderMetadataStub().inflate();
            if (inflate == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.ui.view.SubscribeDetailHeaderView");
            }
            this.f20706n = (SubscribeDetailHeaderView) inflate;
        }
        SubscribeDetailHeaderView subscribeDetailHeaderView = this.f20706n;
        if (subscribeDetailHeaderView == null) {
            Intrinsics.m26842a();
        }
        return subscribeDetailHeaderView;
    }

    public final OnboardingLinkHeaderView getOnboardingLinkHeaderView() {
        if (this.f20708p) {
            if (this.f20707o == null) {
                getHeaderMetadataStub().setLayoutResource(C1761R.layout.onboarding_link_header_view);
                View inflate = getHeaderMetadataStub().inflate();
                if (inflate == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.listing.ui.view.OnboardingLinkHeaderView");
                }
                this.f20707o = (OnboardingLinkHeaderView) inflate;
            }
            OnboardingLinkHeaderView onboardingLinkHeaderView = this.f20707o;
            if (onboardingLinkHeaderView == null) {
                Intrinsics.m26842a();
            }
            return onboardingLinkHeaderView;
        }
        throw new IllegalStateException("Tried to access onboarding header in regular mode");
    }

    public final void setSort(SortOption<CommentSortType> sortOption) {
        Intrinsics.m26847b(sortOption, "sortOption");
        getSortBar().setText(getResources().getString(C1761R.string.fmt_sort_label_comments, new Object[]{getResources().getString(sortOption.f20413b)}));
        int i = sortOption.f20412a;
        TextView sortBar = getSortBar();
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        sortOption = ResourcesUtil.m22726c(context, i);
        context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        Context context2 = getContext();
        Intrinsics.m26843a((Object) context2, "context");
        sortBar.setCompoundDrawablesRelative(sortOption, null, ResourcesUtil.m22725b(context, ResourcesUtil.m22732e(context2, (int) C1761R.drawable.ind_dropdown)), null);
    }

    public final void setOnboardingMode(boolean z) {
        this.f20708p = z;
    }
}
