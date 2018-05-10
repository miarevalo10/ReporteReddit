package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.modtools.PopupModReports;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.RichTextUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.IconStatusView;
import com.reddit.frontpage.widgets.ShapedIconView;
import com.reddit.frontpage.widgets.SubscribeToggleIcon;
import java.util.HashMap;
import java.util.Set;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001^B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MJ\u0010\u0010N\u001a\u00020O2\u0006\u0010L\u001a\u00020MH$J\u0010\u0010P\u001a\u00020Q2\u0006\u0010L\u001a\u00020MH$J\b\u0010R\u001a\u00020KH\u0002J\u0010\u0010S\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010T\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010U\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010V\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u0015\u0010W\u001a\u00020K2\b\u0010X\u001a\u0004\u0018\u00010Y¢\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u000e\u0010\\\u001a\u00020K2\u0006\u0010]\u001a\u00020YR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8FX\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b,\u0010\u000eR\u001b\u0010.\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b/\u0010)R\u001b\u00101\u001a\u0002028FX\u0002¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078FX\u0002¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b8\u00109R\u001b\u0010;\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b<\u0010\u000eR\u001b\u0010>\u001a\u00020\u00018FX\u0002¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\b?\u0010@R\u001b\u0010B\u001a\u00020C8FX\u0002¢\u0006\f\n\u0004\bF\u0010\u0010\u001a\u0004\bD\u0010ER\u001b\u0010G\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\bI\u0010\u0010\u001a\u0004\bH\u0010\u000e¨\u0006_"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/HeaderMetadataView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "authorFlairView", "Landroid/widget/TextView;", "getAuthorFlairView", "()Landroid/widget/TextView;", "authorFlairView$delegate", "Lkotlin/Lazy;", "bottomMetadataAfterIndicators", "getBottomMetadataAfterIndicators", "bottomMetadataAfterIndicators$delegate", "bottomMetadataBeforeIndicators", "getBottomMetadataBeforeIndicators", "bottomMetadataBeforeIndicators$delegate", "bottomMetadataIndicators", "Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;", "getBottomMetadataIndicators", "()Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;", "bottomMetadataIndicators$delegate", "iconStatusView", "Lcom/reddit/frontpage/widgets/IconStatusView;", "getIconStatusView", "()Lcom/reddit/frontpage/widgets/IconStatusView;", "iconStatusView$delegate", "locationContainer", "Landroid/view/View;", "getLocationContainer", "()Landroid/view/View;", "locationContainer$delegate", "locationIcon", "Landroid/widget/ImageView;", "getLocationIcon", "()Landroid/widget/ImageView;", "locationIcon$delegate", "locationView", "getLocationView", "locationView$delegate", "overflowIcon", "getOverflowIcon", "overflowIcon$delegate", "overflowLayout", "Landroid/widget/FrameLayout;", "getOverflowLayout", "()Landroid/widget/FrameLayout;", "overflowLayout$delegate", "subredditIconView", "Lcom/reddit/frontpage/widgets/ShapedIconView;", "getSubredditIconView", "()Lcom/reddit/frontpage/widgets/ShapedIconView;", "subredditIconView$delegate", "subredditName", "getSubredditName", "subredditName$delegate", "subscribeContainer", "getSubscribeContainer", "()Landroid/widget/RelativeLayout;", "subscribeContainer$delegate", "subscribeToggle", "Lcom/reddit/frontpage/widgets/SubscribeToggleIcon;", "getSubscribeToggle", "()Lcom/reddit/frontpage/widgets/SubscribeToggleIcon;", "subscribeToggle$delegate", "topMetadata", "getTopMetadata", "topMetadata$delegate", "bind", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "generateBottomMetadata", "Lcom/reddit/frontpage/presentation/listing/ui/view/HeaderMetadataView$StringWithIndicators;", "generateTopMetadata", "", "init", "initBottomMetaDataUi", "initLocationUi", "initSubredditUi", "initTopMetaDataUi", "setSubscribeIcon", "isSubscribed", "", "(Ljava/lang/Boolean;)V", "showReportsPopup", "showSubscribeToggle", "showToggle", "StringWithIndicators", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HeaderMetadataView.kt */
public abstract class HeaderMetadataView extends RelativeLayout {
    static final /* synthetic */ KProperty[] f20715a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "subredditIconView", "getSubredditIconView()Lcom/reddit/frontpage/widgets/ShapedIconView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "subredditName", "getSubredditName()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "topMetadata", "getTopMetadata()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "bottomMetadataBeforeIndicators", "getBottomMetadataBeforeIndicators()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "bottomMetadataIndicators", "getBottomMetadataIndicators()Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "authorFlairView", "getAuthorFlairView()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "bottomMetadataAfterIndicators", "getBottomMetadataAfterIndicators()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "iconStatusView", "getIconStatusView()Lcom/reddit/frontpage/widgets/IconStatusView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "subscribeContainer", "getSubscribeContainer()Landroid/widget/RelativeLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "subscribeToggle", "getSubscribeToggle()Lcom/reddit/frontpage/widgets/SubscribeToggleIcon;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "locationContainer", "getLocationContainer()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "locationIcon", "getLocationIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "locationView", "getLocationView()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "overflowLayout", "getOverflowLayout()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(HeaderMetadataView.class), "overflowIcon", "getOverflowIcon()Landroid/widget/ImageView;"))};
    private final Lazy f20716b;
    private final Lazy f20717c;
    private final Lazy f20718d;
    private final Lazy f20719e;
    private final Lazy f20720f;
    private final Lazy f20721g;
    private final Lazy f20722h;
    private final Lazy f20723i;
    private final Lazy f20724j;
    private final Lazy f20725k;
    private final Lazy f20726l;
    private final Lazy f20727m;
    private final Lazy f20728n;
    private final Lazy f20729o;
    private final Lazy f20730p;
    private HashMap f20731q;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/HeaderMetadataView$StringWithIndicators;", "", "beforeIndicators", "", "indicators", "", "Lcom/reddit/frontpage/presentation/listing/ui/view/Indicator;", "authorFlair", "afterIndicators", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;)V", "getAfterIndicators", "()Ljava/lang/String;", "getAuthorFlair", "getBeforeIndicators", "getIndicators", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: HeaderMetadataView.kt */
    public static final class StringWithIndicators {
        public final String f20710a;
        public final Set<Indicator> f20711b;
        public final String f20712c;
        public final String f20713d;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof StringWithIndicators) {
                    StringWithIndicators stringWithIndicators = (StringWithIndicators) obj;
                    if (Intrinsics.m26845a(this.f20710a, stringWithIndicators.f20710a) && Intrinsics.m26845a(this.f20711b, stringWithIndicators.f20711b) && Intrinsics.m26845a(this.f20712c, stringWithIndicators.f20712c) && Intrinsics.m26845a(this.f20713d, stringWithIndicators.f20713d)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f20710a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Set set = this.f20711b;
            hashCode = (hashCode + (set != null ? set.hashCode() : 0)) * 31;
            String str2 = this.f20712c;
            hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            str2 = this.f20713d;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("StringWithIndicators(beforeIndicators=");
            stringBuilder.append(this.f20710a);
            stringBuilder.append(", indicators=");
            stringBuilder.append(this.f20711b);
            stringBuilder.append(", authorFlair=");
            stringBuilder.append(this.f20712c);
            stringBuilder.append(", afterIndicators=");
            stringBuilder.append(this.f20713d);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public StringWithIndicators(String str, Set<? extends Indicator> set, String str2, String str3) {
            Intrinsics.m26847b(str, "beforeIndicators");
            Intrinsics.m26847b(set, "indicators");
            Intrinsics.m26847b(str2, "authorFlair");
            Intrinsics.m26847b(str3, "afterIndicators");
            this.f20710a = str;
            this.f20711b = set;
            this.f20712c = str2;
            this.f20713d = str3;
        }
    }

    public HeaderMetadataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public View mo4901a(int i) {
        if (this.f20731q == null) {
            this.f20731q = new HashMap();
        }
        View view = (View) this.f20731q.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f20731q.put(Integer.valueOf(i), view);
        return view;
    }

    protected abstract String mo4902a(LinkPresentationModel linkPresentationModel);

    protected abstract StringWithIndicators mo4903b(LinkPresentationModel linkPresentationModel);

    public final TextView getAuthorFlairView() {
        return (TextView) this.f20721g.mo5678b();
    }

    public final TextView getBottomMetadataAfterIndicators() {
        return (TextView) this.f20722h.mo5678b();
    }

    public final TextView getBottomMetadataBeforeIndicators() {
        return (TextView) this.f20719e.mo5678b();
    }

    public final UserIndicatorsView getBottomMetadataIndicators() {
        return (UserIndicatorsView) this.f20720f.mo5678b();
    }

    public final IconStatusView getIconStatusView() {
        return (IconStatusView) this.f20723i.mo5678b();
    }

    public final View getLocationContainer() {
        return (View) this.f20726l.mo5678b();
    }

    public final ImageView getLocationIcon() {
        return (ImageView) this.f20727m.mo5678b();
    }

    public final TextView getLocationView() {
        return (TextView) this.f20728n.mo5678b();
    }

    public final ImageView getOverflowIcon() {
        return (ImageView) this.f20730p.mo5678b();
    }

    public final FrameLayout getOverflowLayout() {
        return (FrameLayout) this.f20729o.mo5678b();
    }

    public final ShapedIconView getSubredditIconView() {
        return (ShapedIconView) this.f20716b.mo5678b();
    }

    public final TextView getSubredditName() {
        return (TextView) this.f20717c.mo5678b();
    }

    public final RelativeLayout getSubscribeContainer() {
        return (RelativeLayout) this.f20724j.mo5678b();
    }

    public final SubscribeToggleIcon getSubscribeToggle() {
        return (SubscribeToggleIcon) this.f20725k.mo5678b();
    }

    public final TextView getTopMetadata() {
        return (TextView) this.f20718d.mo5678b();
    }

    public HeaderMetadataView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        this.f20716b = LazyKt.m26777a((Function0) new HeaderMetadataView$subredditIconView$2(this));
        this.f20717c = LazyKt.m26777a((Function0) new HeaderMetadataView$subredditName$2(this));
        this.f20718d = LazyKt.m26777a((Function0) new HeaderMetadataView$topMetadata$2(this));
        this.f20719e = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataBeforeIndicators$2(this));
        this.f20720f = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataIndicators$2(this));
        this.f20721g = LazyKt.m26777a((Function0) new HeaderMetadataView$authorFlairView$2(this));
        this.f20722h = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataAfterIndicators$2(this));
        this.f20723i = LazyKt.m26777a((Function0) new HeaderMetadataView$iconStatusView$2(this));
        this.f20724j = LazyKt.m26777a((Function0) new HeaderMetadataView$subscribeContainer$2(this));
        this.f20725k = LazyKt.m26777a((Function0) new HeaderMetadataView$subscribeToggle$2(this));
        this.f20726l = LazyKt.m26777a((Function0) new HeaderMetadataView$locationContainer$2(this));
        this.f20727m = LazyKt.m26777a((Function0) new HeaderMetadataView$locationIcon$2(this));
        this.f20728n = LazyKt.m26777a((Function0) new HeaderMetadataView$locationView$2(this));
        this.f20729o = LazyKt.m26777a((Function0) new HeaderMetadataView$overflowLayout$2(this));
        this.f20730p = LazyKt.m26777a((Function0) new HeaderMetadataView$overflowIcon$2(this));
        m22993a();
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
        this.f20716b = LazyKt.m26777a((Function0) new HeaderMetadataView$subredditIconView$2(this));
        this.f20717c = LazyKt.m26777a((Function0) new HeaderMetadataView$subredditName$2(this));
        this.f20718d = LazyKt.m26777a((Function0) new HeaderMetadataView$topMetadata$2(this));
        this.f20719e = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataBeforeIndicators$2(this));
        this.f20720f = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataIndicators$2(this));
        this.f20721g = LazyKt.m26777a((Function0) new HeaderMetadataView$authorFlairView$2(this));
        this.f20722h = LazyKt.m26777a((Function0) new HeaderMetadataView$bottomMetadataAfterIndicators$2(this));
        this.f20723i = LazyKt.m26777a((Function0) new HeaderMetadataView$iconStatusView$2(this));
        this.f20724j = LazyKt.m26777a((Function0) new HeaderMetadataView$subscribeContainer$2(this));
        this.f20725k = LazyKt.m26777a((Function0) new HeaderMetadataView$subscribeToggle$2(this));
        this.f20726l = LazyKt.m26777a((Function0) new HeaderMetadataView$locationContainer$2(this));
        this.f20727m = LazyKt.m26777a((Function0) new HeaderMetadataView$locationIcon$2(this));
        this.f20728n = LazyKt.m26777a((Function0) new HeaderMetadataView$locationView$2(this));
        this.f20729o = LazyKt.m26777a((Function0) new HeaderMetadataView$overflowLayout$2(this));
        this.f20730p = LazyKt.m26777a((Function0) new HeaderMetadataView$overflowIcon$2(this));
        m22993a();
    }

    private final void m22993a() {
        View.inflate(getContext(), C1761R.layout.merge_link_header_metadata, this);
        ImageView overflowIcon = getOverflowIcon();
        Context context = getContext();
        Intrinsics.m26843a((Object) context, "context");
        Drawable drawable = getOverflowIcon().getDrawable();
        Intrinsics.m26843a((Object) drawable, "overflowIcon.drawable");
        overflowIcon.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
    }

    public final void setSubscribeIcon(Boolean bool) {
        getSubscribeToggle().setSubscribe(bool);
    }

    public final void m22998c(LinkPresentationModel linkPresentationModel) {
        boolean z;
        IconStatusView iconStatusView;
        CharSequence charSequence;
        Intrinsics.m26847b(linkPresentationModel, "link");
        boolean a = SubredditUtil.m23920a((CharSequence) linkPresentationModel.f33979f);
        Util.m23986a(getSubredditIconView(), linkPresentationModel.f33979f, linkPresentationModel.ai, linkPresentationModel.ah, AccountPrefsUtil.m23630a(linkPresentationModel.f33985l, Boolean.valueOf(linkPresentationModel.aj)));
        setSubscribeIcon(Boolean.valueOf(SubredditUtil.m23933d(linkPresentationModel.af)));
        boolean z2 = true;
        if (linkPresentationModel.f33962O) {
            TextView subredditName = getSubredditName();
            subredditName.setText(subredditName.getContext().getString(C1761R.string.label_promoted));
            Sdk21PropertiesKt.m28412a(subredditName, ContextCompat.c(subredditName.getContext(), C1761R.color.rdt_blue));
            subredditName.setAllCaps(true);
            Function1 function1 = HeaderMetadataView$initSubredditUi$1$1.f36838a;
            subredditName.setOnClickListener(function1 == null ? null : new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(function1));
        } else {
            TextView subredditName2 = getSubredditName();
            subredditName2.setText(linkPresentationModel.f33979f);
            Object context = subredditName2.getContext();
            Intrinsics.m26843a(context, "context");
            Sdk21PropertiesKt.m28412a(subredditName2, ResourcesUtil.m22740i(context, C1761R.attr.rdt_body_small_text_color));
            subredditName2.setAllCaps(false);
            subredditName2.setOnClickListener(new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(new HeaderMetadataView$initSubredditUi$$inlined$apply$lambda$1(subredditName2, linkPresentationModel, a)));
        }
        CharSequence a2 = mo4902a(linkPresentationModel);
        if (a2.length() > 0) {
            getTopMetadata().setText(a2);
        }
        StringWithIndicators b = mo4903b(linkPresentationModel);
        if (((CharSequence) b.f20710a).length() > 0) {
            subredditName2 = getBottomMetadataBeforeIndicators();
            subredditName2.setText(b.f20710a);
            subredditName2.setOnClickListener(new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(new HeaderMetadataView$initBottomMetaDataUi$$inlined$apply$lambda$1(subredditName2, b, linkPresentationModel)));
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
                iconStatusView.m24156a(linkPresentationModel);
                iconStatusView.setOnClickListener(new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(new HeaderMetadataView$bind$$inlined$apply$lambda$1(this, linkPresentationModel)));
                linkPresentationModel = linkPresentationModel.f33988o;
                if (linkPresentationModel == null) {
                    linkPresentationModel = "";
                }
                charSequence = (CharSequence) linkPresentationModel;
                if (charSequence.length() > 0) {
                    z2 = false;
                }
                if (z2) {
                    ViewsKt.m24109d(getLocationContainer());
                    return;
                }
                ViewsKt.m24107c(getLocationContainer());
                getLocationView().setText(charSequence);
                Object context2 = getContext();
                Intrinsics.m26843a(context2, "context");
                getLocationIcon().setImageDrawable(ResourcesUtil.m22724b(context2, C1761R.drawable.ind_location, C1761R.attr.rdt_default_key_color));
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
        iconStatusView.m24156a(linkPresentationModel);
        iconStatusView.setOnClickListener(new HeaderMetadataView$inlined$sam$OnClickListener$i$7f478c20(new HeaderMetadataView$bind$$inlined$apply$lambda$1(this, linkPresentationModel)));
        linkPresentationModel = linkPresentationModel.f33988o;
        if (linkPresentationModel == null) {
            linkPresentationModel = "";
        }
        charSequence = (CharSequence) linkPresentationModel;
        if (charSequence.length() > 0) {
            z2 = false;
        }
        if (z2) {
            ViewsKt.m24109d(getLocationContainer());
            return;
        }
        ViewsKt.m24107c(getLocationContainer());
        getLocationView().setText(charSequence);
        Object context22 = getContext();
        Intrinsics.m26843a(context22, "context");
        getLocationIcon().setImageDrawable(ResourcesUtil.m22724b(context22, C1761R.drawable.ind_location, C1761R.attr.rdt_default_key_color));
    }

    public static final /* synthetic */ void m22994a(HeaderMetadataView headerMetadataView, LinkPresentationModel linkPresentationModel) {
        if (linkPresentationModel.f33969V > 0) {
            new PopupModReports(headerMetadataView.getContext(), linkPresentationModel, AppAnalytics.m21849a((View) headerMetadataView), new HeaderMetadataView$showReportsPopup$1(headerMetadataView, linkPresentationModel)).m23562b();
        }
    }
}
