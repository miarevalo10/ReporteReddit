package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.CrossPostCompactCardBodyView.Companion;
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import com.reddit.frontpage.ui.listing.newcard.RightIndentTextView;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.Util;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020,H\u0014J\u0018\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u0010\u00100\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102J\u000e\u00103\u001a\u00020,2\u0006\u00104\u001a\u000202J\u000e\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0007J\u0010\u0010:\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u000102J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020>R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b$\u0010%¨\u0006?"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/CompactLinkView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "crossPostCardBody", "Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostCompactCardBodyView;", "getCrossPostCardBody", "()Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostCompactCardBodyView;", "crossPostCardBody$delegate", "Lkotlin/Lazy;", "flairView", "Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "getFlairView", "()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "flairView$delegate", "linkHeaderView", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeaderView;", "getLinkHeaderView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeaderView;", "linkHeaderView$delegate", "thumbnailView", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "getThumbnailView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "thumbnailView$delegate", "title", "", "titleView", "Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "getTitleView", "()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "titleView$delegate", "bottomMargin", "view", "Landroid/view/View;", "heightMargins", "onFinishInflate", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCrossPostEmbedOnClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setCrossPostThumbnailOnClickListener", "listener", "setShowLinkFlair", "showLinkFlair", "", "setTitleAlpha", "alpha", "setViewMediaClickListener", "topMargin", "update", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CompactLinkView.kt */
public final class CompactLinkView extends RelativeLayout {
    static final /* synthetic */ KProperty[] f20647a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CompactLinkView.class), "linkHeaderView", "getLinkHeaderView()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeaderView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CompactLinkView.class), "titleView", "getTitleView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CompactLinkView.class), "flairView", "getFlairView()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CompactLinkView.class), "crossPostCardBody", "getCrossPostCardBody()Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostCompactCardBodyView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CompactLinkView.class), "thumbnailView", "getThumbnailView()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;"))};
    private final Lazy f20648b;
    private final Lazy f20649c;
    private final Lazy f20650d;
    private final Lazy f20651e;
    private final Lazy f20652f;
    private String f20653g;

    public CompactLinkView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CompactLinkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final CrossPostCompactCardBodyView getCrossPostCardBody() {
        return (CrossPostCompactCardBodyView) this.f20651e.mo5678b();
    }

    private final LinkFlairView getFlairView() {
        return (LinkFlairView) this.f20650d.mo5678b();
    }

    private final LinkThumbnailView getThumbnailView() {
        return (LinkThumbnailView) this.f20652f.mo5678b();
    }

    private final RightIndentTextView getTitleView() {
        return (RightIndentTextView) this.f20649c.mo5678b();
    }

    public final LinkHeaderView getLinkHeaderView() {
        return (LinkHeaderView) this.f20648b.mo5678b();
    }

    public /* synthetic */ CompactLinkView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public CompactLinkView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20648b = LazyKt.m26777a((Function0) new CompactLinkView$linkHeaderView$2(this));
        this.f20649c = LazyKt.m26777a((Function0) new CompactLinkView$titleView$2(this));
        this.f20650d = LazyKt.m26777a((Function0) new CompactLinkView$flairView$2(this));
        this.f20651e = LazyKt.m26777a((Function0) new CompactLinkView$crossPostCardBody$2(this));
        this.f20652f = LazyKt.m26777a((Function0) new CompactLinkView$thumbnailView$2(this));
    }

    @TargetApi(21)
    public CompactLinkView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f20648b = LazyKt.m26777a((Function0) new CompactLinkView$linkHeaderView$2(this));
        this.f20649c = LazyKt.m26777a((Function0) new CompactLinkView$titleView$2(this));
        this.f20650d = LazyKt.m26777a((Function0) new CompactLinkView$flairView$2(this));
        this.f20651e = LazyKt.m26777a((Function0) new CompactLinkView$crossPostCardBody$2(this));
        this.f20652f = LazyKt.m26777a((Function0) new CompactLinkView$thumbnailView$2(this));
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
    }

    protected final void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int a;
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        int paddingLeft = (defaultSize - getPaddingLeft()) - getPaddingRight();
        LinkThumbnailView thumbnailView = getThumbnailView();
        if (thumbnailView != null) {
            layoutParams = thumbnailView.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            int i3 = ((RelativeLayout.LayoutParams) layoutParams).leftMargin;
            int paddingRight = (int) (((((double) defaultSize) * 0.25d) - ((double) getPaddingRight())) - ((double) i3));
            LayoutParams layoutParams2 = thumbnailView.getLayoutParams();
            layoutParams2.width = paddingRight;
            layoutParams2.height = paddingRight;
            a = m22973a((View) thumbnailView) + paddingRight;
            defaultSize -= (defaultSize - paddingRight) - i3;
        } else {
            defaultSize = 0;
            a = defaultSize;
        }
        getLinkHeaderView().measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        a -= getLinkHeaderView().getMeasuredHeight();
        m22973a((View) getLinkHeaderView());
        m22974b(getTitleView());
        RightIndentTextView titleView = getTitleView();
        titleView.setIndentHeight(a);
        titleView.setIndentMargin(defaultSize);
        titleView.setText(this.f20653g);
        getTitleView().measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        layoutParams = getTitleView().getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        if ((a - getTitleView().getMeasuredHeight()) - (((MarginLayoutParams) layoutParams).bottomMargin - m22974b(getFlairView())) > 0) {
            paddingLeft -= defaultSize;
        }
        LayoutParams layoutParams3 = getFlairView().getLayoutParams();
        if (layoutParams3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        ((RelativeLayout.LayoutParams) layoutParams3).width = paddingLeft;
        getFlairView().measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        super.onMeasure(i, i2);
    }

    private static int m22973a(View view) {
        view = view.getLayoutParams();
        if (view == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view;
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static int m22974b(View view) {
        view = view.getLayoutParams();
        if (view != null) {
            return ((MarginLayoutParams) view).topMargin;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setViewMediaClickListener(OnClickListener onClickListener) {
        LinkThumbnailView thumbnailView = getThumbnailView();
        if (thumbnailView != null) {
            thumbnailView.setOnClickListener(onClickListener);
        }
    }

    public final void setShowLinkFlair(boolean z) {
        getFlairView().setShowLinkFlair(z);
    }

    public final void setCrossPostEmbedOnClickListener(OnClickListener onClickListener) {
        getCrossPostCardBody().setOnClickListener(onClickListener);
    }

    public final void setCrossPostThumbnailOnClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        getCrossPostCardBody().setThumbnailOnClickListener(onClickListener);
    }

    public final void setTitleAlpha(int i) {
        getTitleView().setTextColor(getTitleView().getTextColors().withAlpha(i));
    }

    public final void m22975a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        this.f20653g = linkPresentationModel.f33999z;
        getFlairView().m23475a(linkPresentationModel);
        LinkThumbnailView thumbnailView = getThumbnailView();
        if (thumbnailView != null) {
            thumbnailView.m23026a(linkPresentationModel, 0, 0);
        }
        linkPresentationModel = linkPresentationModel.am;
        if (linkPresentationModel != null) {
            String f;
            CrossPostCompactCardBodyView crossPostCardBody = getCrossPostCardBody();
            Intrinsics.m26847b(linkPresentationModel, "link");
            crossPostCardBody.f20657b = linkPresentationModel.f33999z;
            crossPostCardBody.f20659d = null;
            CharSequence b = DateUtil.m23684b(linkPresentationModel.f33982i);
            if (Util.m24041k(linkPresentationModel.f33985l)) {
                f = Util.m24027f((int) C1761R.string.deleted_author);
                Intrinsics.m26843a((Object) f, "Util.getString(R.string.deleted_author)");
            } else {
                f = Util.m23960a((int) C1761R.string.fmt_u_name, linkPresentationModel.f33985l);
                Intrinsics.m26843a((Object) f, "Util.getString(R.string.fmt_u_name, link.author)");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(linkPresentationModel.f33979f);
            Companion companion = CrossPostCompactCardBodyView.f20655e;
            stringBuilder.append(CrossPostCompactCardBodyView.f20656j);
            stringBuilder.append(b);
            Companion companion2 = CrossPostCompactCardBodyView.f20655e;
            stringBuilder.append(CrossPostCompactCardBodyView.f20656j);
            stringBuilder.append(f);
            crossPostCardBody.f20658c = stringBuilder.toString();
            crossPostCardBody.f20659d = CrossPostCompactCardBodyView.m22978a(linkPresentationModel);
            crossPostCardBody.getThumbnailView().m23026a(linkPresentationModel, 0, 0);
            crossPostCardBody.invalidate();
            crossPostCardBody.requestLayout();
        }
        invalidate();
        requestLayout();
    }
}
