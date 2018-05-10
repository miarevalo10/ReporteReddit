package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.ui.view.HeaderMetadataView.StringWithIndicators;
import com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView;
import com.reddit.frontpage.ui.modtools.PopupModReports;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.RichTextUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MJ\u0010\u0010N\u001a\u00020O2\u0006\u0010L\u001a\u00020MH$J\u0010\u0010P\u001a\u00020Q2\u0006\u0010L\u001a\u00020MH$J\b\u0010R\u001a\u00020KH\u0002J\u0010\u0010S\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010T\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010U\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010V\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u0015\u0010W\u001a\u00020K2\b\u0010X\u001a\u0004\u0018\u00010Y¢\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u000e\u0010\\\u001a\u00020K2\u0006\u0010]\u001a\u00020YR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8FX\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b,\u0010\u000eR\u001b\u0010.\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b/\u0010)R\u001b\u00101\u001a\u0002028FX\u0002¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b7\u0010\u000eR\u001b\u00109\u001a\u00020:8FX\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b;\u0010<R\u001b\u0010>\u001a\u00020\u00018FX\u0002¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020C8FX\u0002¢\u0006\f\n\u0004\bF\u0010\u0010\u001a\u0004\bD\u0010ER\u001b\u0010G\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\bI\u0010\u0010\u001a\u0004\bH\u0010\u000e¨\u0006^"}, d2 = {"Lcom/reddit/frontpage/widgets/HeaderMetadataView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "authorFlairView", "Landroid/widget/TextView;", "getAuthorFlairView", "()Landroid/widget/TextView;", "authorFlairView$delegate", "Lkotlin/Lazy;", "bottomMetadataAfterIndicators", "getBottomMetadataAfterIndicators", "bottomMetadataAfterIndicators$delegate", "bottomMetadataBeforeIndicators", "getBottomMetadataBeforeIndicators", "bottomMetadataBeforeIndicators$delegate", "bottomMetadataIndicators", "Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;", "getBottomMetadataIndicators", "()Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;", "bottomMetadataIndicators$delegate", "iconStatusView", "Lcom/reddit/frontpage/widgets/IconStatusView;", "getIconStatusView", "()Lcom/reddit/frontpage/widgets/IconStatusView;", "iconStatusView$delegate", "locationContainer", "Landroid/view/View;", "getLocationContainer", "()Landroid/view/View;", "locationContainer$delegate", "locationIcon", "Landroid/widget/ImageView;", "getLocationIcon", "()Landroid/widget/ImageView;", "locationIcon$delegate", "locationView", "getLocationView", "locationView$delegate", "overflowIcon", "getOverflowIcon", "overflowIcon$delegate", "overflowLayout", "Landroid/widget/FrameLayout;", "getOverflowLayout", "()Landroid/widget/FrameLayout;", "overflowLayout$delegate", "subreddit", "getSubreddit", "subreddit$delegate", "subredditIconView", "Lcom/reddit/frontpage/widgets/ShapedIconView;", "getSubredditIconView", "()Lcom/reddit/frontpage/widgets/ShapedIconView;", "subredditIconView$delegate", "subscribeContainer", "getSubscribeContainer", "()Landroid/widget/RelativeLayout;", "subscribeContainer$delegate", "subscribeToggle", "Lcom/reddit/frontpage/widgets/SubscribeToggleIcon;", "getSubscribeToggle", "()Lcom/reddit/frontpage/widgets/SubscribeToggleIcon;", "subscribeToggle$delegate", "topMetadata", "getTopMetadata", "topMetadata$delegate", "bind", "", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "generateBottomMetadata", "Lcom/reddit/frontpage/presentation/listing/ui/view/HeaderMetadataView$StringWithIndicators;", "generateTopMetadata", "", "init", "initBottomMetaDataUi", "initLocationUi", "initSubredditUi", "initTopMetaDataUi", "setSubscribeIcon", "isSubscribed", "", "(Ljava/lang/Boolean;)V", "showReportsPopup", "showSubscribeToggle", "shouldShowToggle", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HeaderMetadataView.kt */
public abstract class HeaderMetadataView extends RelativeLayout {
    static final /* synthetic */ KProperty[] f21877a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "subredditIconView", "getSubredditIconView()Lcom/reddit/frontpage/widgets/ShapedIconView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "subreddit", "getSubreddit()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "topMetadata", "getTopMetadata()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "bottomMetadataBeforeIndicators", "getBottomMetadataBeforeIndicators()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "bottomMetadataIndicators", "getBottomMetadataIndicators()Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "bottomMetadataAfterIndicators", "getBottomMetadataAfterIndicators()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "authorFlairView", "getAuthorFlairView()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "iconStatusView", "getIconStatusView()Lcom/reddit/frontpage/widgets/IconStatusView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "subscribeContainer", "getSubscribeContainer()Landroid/widget/RelativeLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "subscribeToggle", "getSubscribeToggle()Lcom/reddit/frontpage/widgets/SubscribeToggleIcon;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "locationContainer", "getLocationContainer()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "locationIcon", "getLocationIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "locationView", "getLocationView()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "overflowLayout", "getOverflowLayout()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "overflowIcon", "getOverflowIcon()Landroid/widget/ImageView;"))};
    private final Lazy f21878b;
    private final Lazy f21879c;
    private final Lazy f21880d;
    private final Lazy f21881e;
    private final Lazy f21882f;
    private final Lazy f21883g;
    private final Lazy f21884h;
    private final Lazy f21885i;
    private final Lazy f21886j;
    private final Lazy f21887k;
    private final Lazy f21888l;
    private final Lazy f21889m;
    private final Lazy f21890n;
    private final Lazy f21891o;
    private final Lazy f21892p;
    private HashMap f21893q;

    public HeaderMetadataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final View m24147a(int i) {
        if (this.f21893q == null) {
            this.f21893q = new HashMap();
        }
        View view = (View) this.f21893q.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f21893q.put(Integer.valueOf(i), view);
        return view;
    }

    protected abstract String mo5061a();

    protected abstract StringWithIndicators mo5062b(Link link);

    public final TextView getAuthorFlairView() {
        return (TextView) this.f21884h.mo5678b();
    }

    public final TextView getBottomMetadataAfterIndicators() {
        return (TextView) this.f21883g.mo5678b();
    }

    public final TextView getBottomMetadataBeforeIndicators() {
        return (TextView) this.f21881e.mo5678b();
    }

    public final UserIndicatorsView getBottomMetadataIndicators() {
        return (UserIndicatorsView) this.f21882f.mo5678b();
    }

    public final IconStatusView getIconStatusView() {
        return (IconStatusView) this.f21885i.mo5678b();
    }

    public final View getLocationContainer() {
        return (View) this.f21888l.mo5678b();
    }

    public final ImageView getLocationIcon() {
        return (ImageView) this.f21889m.mo5678b();
    }

    public final TextView getLocationView() {
        return (TextView) this.f21890n.mo5678b();
    }

    public final ImageView getOverflowIcon() {
        return (ImageView) this.f21892p.mo5678b();
    }

    public final FrameLayout getOverflowLayout() {
        return (FrameLayout) this.f21891o.mo5678b();
    }

    public final TextView getSubreddit() {
        return (TextView) this.f21879c.mo5678b();
    }

    public final ShapedIconView getSubredditIconView() {
        return (ShapedIconView) this.f21878b.mo5678b();
    }

    public final RelativeLayout getSubscribeContainer() {
        return (RelativeLayout) this.f21886j.mo5678b();
    }

    public final SubscribeToggleIcon getSubscribeToggle() {
        return (SubscribeToggleIcon) this.f21887k.mo5678b();
    }

    public final TextView getTopMetadata() {
        return (TextView) this.f21880d.mo5678b();
    }

    public HeaderMetadataView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        this.f21878b = LazyKt.m26777a((Function0) new HeaderMetadataView$subredditIconView$2(this));
        this.f21879c = LazyKt.m26777a((Function0) new HeaderMetadataView$subreddit$2(this));
        this.f21880d = LazyKt.m26777a((Function0) new HeaderMetadataView$topMetadata$2(this));
        this.f21881e = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataBeforeIndicators$2(this));
        this.f21882f = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataIndicators$2(this));
        this.f21883g = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataAfterIndicators$2(this));
        this.f21884h = LazyKt.m26777a((Function0) new HeaderMetadataView$authorFlairView$2(this));
        this.f21885i = LazyKt.m26777a((Function0) new HeaderMetadataView$iconStatusView$2(this));
        this.f21886j = LazyKt.m26777a((Function0) new HeaderMetadataView$subscribeContainer$2(this));
        this.f21887k = LazyKt.m26777a((Function0) new HeaderMetadataView$subscribeToggle$2(this));
        this.f21888l = LazyKt.m26777a((Function0) new HeaderMetadataView$locationContainer$2(this));
        this.f21889m = LazyKt.m26777a((Function0) new HeaderMetadataView$locationIcon$2(this));
        this.f21890n = LazyKt.m26777a((Function0) new HeaderMetadataView$locationView$2(this));
        this.f21891o = LazyKt.m26777a((Function0) new HeaderMetadataView$overflowLayout$2(this));
        this.f21892p = LazyKt.m26777a((Function0) new HeaderMetadataView$overflowIcon$2(this));
        mo5064b();
    }

    public /* synthetic */ HeaderMetadataView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    @TargetApi(21)
    public HeaderMetadataView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f21878b = LazyKt.m26777a((Function0) new HeaderMetadataView$subredditIconView$2(this));
        this.f21879c = LazyKt.m26777a((Function0) new HeaderMetadataView$subreddit$2(this));
        this.f21880d = LazyKt.m26777a((Function0) new HeaderMetadataView$topMetadata$2(this));
        this.f21881e = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataBeforeIndicators$2(this));
        this.f21882f = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataIndicators$2(this));
        this.f21883g = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataAfterIndicators$2(this));
        this.f21884h = LazyKt.m26777a((Function0) new HeaderMetadataView$authorFlairView$2(this));
        this.f21885i = LazyKt.m26777a((Function0) new HeaderMetadataView$iconStatusView$2(this));
        this.f21886j = LazyKt.m26777a((Function0) new HeaderMetadataView$subscribeContainer$2(this));
        this.f21887k = LazyKt.m26777a((Function0) new HeaderMetadataView$subscribeToggle$2(this));
        this.f21888l = LazyKt.m26777a((Function0) new HeaderMetadataView$locationContainer$2(this));
        this.f21889m = LazyKt.m26777a((Function0) new HeaderMetadataView$locationIcon$2(this));
        this.f21890n = LazyKt.m26777a((Function0) new HeaderMetadataView$locationView$2(this));
        this.f21891o = LazyKt.m26777a((Function0) new HeaderMetadataView$overflowLayout$2(this));
        this.f21892p = LazyKt.m26777a((Function0) new HeaderMetadataView$overflowIcon$2(this));
        mo5064b();
    }

    public final void setSubscribeIcon(Boolean bool) {
        getSubscribeToggle().setSubscribe(bool);
    }

    public final void m24150a(boolean z) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(C1761R.dimen.metadata_subreddit_icon_size);
        int dimensionPixelSize2 = z ? getResources().getDimensionPixelSize(C1761R.dimen.half_pad) : 0;
        ShapedIconView subredditIconView = getSubredditIconView();
        LayoutParams layoutParams = new LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMargins(dimensionPixelSize2, 0, 0, 0);
        subredditIconView.setLayoutParams(layoutParams);
        ViewsKt.m24103a((View) getSubscribeToggle(), z);
    }

    private final void mo5064b() {
        View.inflate(getContext(), C1761R.layout.merge_link_header_metadata_legacy, this);
        ImageView overflowIcon = getOverflowIcon();
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        Drawable drawable = getOverflowIcon().getDrawable();
        Intrinsics.m26843a((Object) drawable, "overflowIcon.drawable");
        overflowIcon.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
    }

    public final void m24149a(Link link) {
        IconStatusView iconStatusView;
        CharSequence charSequence;
        Intrinsics.m26847b(link, "link");
        boolean a = SubredditUtil.m23920a((CharSequence) link.getSubredditNamePrefixed());
        Subreddit subredditDetail = link.getSubredditDetail();
        boolean z = subredditDetail != null ? subredditDetail.over_18 : false;
        Object author = link.getAuthor();
        Intrinsics.m26843a(author, "link.author");
        Util.m23979a(getSubredditIconView(), link.getSubredditDetail(), AccountPrefsUtil.m23630a(author, Boolean.valueOf(z)));
        boolean z2 = true;
        if (link.isPromoted()) {
            TextView subreddit = getSubreddit();
            subreddit.setText(subreddit.getContext().getString(C1761R.string.label_promoted));
            Sdk21PropertiesKt.m28412a(subreddit, ContextCompat.c(subreddit.getContext(), C1761R.color.rdt_blue));
            subreddit.setAllCaps(true);
            Function1 function1 = HeaderMetadataView$initSubredditUi$1$1.f37411a;
            subreddit.setOnClickListener(function1 == null ? null : new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(function1));
        } else {
            TextView subreddit2 = getSubreddit();
            subreddit2.setText(link.getSubredditNamePrefixed());
            Object context = subreddit2.getContext();
            Intrinsics.m26843a(context, "context");
            Sdk21PropertiesKt.m28412a(subreddit2, ResourcesUtil.m22740i(context, C1761R.attr.rdt_body_small_text_color));
            subreddit2.setAllCaps(false);
            subreddit2.setOnClickListener(new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(new HeaderMetadataView$initSubredditUi$$inlined$apply$lambda$1(subreddit2, link, a)));
        }
        CharSequence a2 = mo5061a();
        if (a2.length() > 0) {
            getTopMetadata().setText(a2);
        }
        StringWithIndicators b = mo5062b(link);
        if (((CharSequence) b.f20710a).length() > 0) {
            subreddit2 = getBottomMetadataBeforeIndicators();
            subreddit2.setText(b.f20710a);
            subreddit2.setOnClickListener(new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(new HeaderMetadataView$initBottomMetaDataUi$$inlined$apply$lambda$1(subreddit2, b, link)));
        }
        getBottomMetadataIndicators().setActiveIndicators(b.f20711b);
        if (((CharSequence) b.f20713d).length() > 0) {
            getBottomMetadataAfterIndicators().setText(b.f20713d);
        }
        CharSequence charSequence2 = b.f20712c;
        if (charSequence2 != null) {
            if (charSequence2.length() != 0) {
                z = false;
                if (z) {
                    RichTextUtil.m23883a(b.f20712c, getAuthorFlairView());
                    getAuthorFlairView().setVisibility(0);
                } else {
                    getAuthorFlairView().setVisibility(8);
                }
                iconStatusView = getIconStatusView();
                iconStatusView.m24155a(link);
                iconStatusView.setOnClickListener(new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(new HeaderMetadataView$bind$$inlined$apply$lambda$1(this, link)));
                link = link.getLocationName();
                if (link == null) {
                    charSequence = (CharSequence) link;
                    if (charSequence.length() > 0) {
                        z2 = false;
                    }
                    if (z2) {
                        getLocationContainer().setVisibility(0);
                        getLocationView().setText(charSequence);
                        Object context2 = getContext();
                        Intrinsics.m26843a(context2, "context");
                        getLocationIcon().setImageDrawable(ResourcesUtil.m22724b(context2, C1761R.drawable.ind_location, C1761R.attr.rdt_default_key_color));
                    }
                }
            }
        }
        z = true;
        if (z) {
            getAuthorFlairView().setVisibility(8);
        } else {
            RichTextUtil.m23883a(b.f20712c, getAuthorFlairView());
            getAuthorFlairView().setVisibility(0);
        }
        iconStatusView = getIconStatusView();
        iconStatusView.m24155a(link);
        iconStatusView.setOnClickListener(new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(new HeaderMetadataView$bind$$inlined$apply$lambda$1(this, link)));
        link = link.getLocationName();
        if (link == null) {
            charSequence = (CharSequence) link;
            if (charSequence.length() > 0) {
                z2 = false;
            }
            if (z2) {
                getLocationContainer().setVisibility(0);
                getLocationView().setText(charSequence);
                Object context22 = getContext();
                Intrinsics.m26843a(context22, "context");
                getLocationIcon().setImageDrawable(ResourcesUtil.m22724b(context22, C1761R.drawable.ind_location, C1761R.attr.rdt_default_key_color));
            }
        }
    }

    public static final /* synthetic */ void m24145a(HeaderMetadataView headerMetadataView, Link link) {
        if (link.getNumReports() > 0) {
            new PopupModReports(headerMetadataView.getContext(), link, AppAnalytics.m21849a((View) headerMetadataView), new HeaderMetadataView$showReportsPopup$popup$1(headerMetadataView, link)).m23562b();
        }
    }
}
