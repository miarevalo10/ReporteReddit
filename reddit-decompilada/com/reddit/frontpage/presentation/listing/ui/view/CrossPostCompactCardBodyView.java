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
import com.reddit.frontpage.ui.listing.newcard.RightIndentTextView;
import com.reddit.frontpage.util.CountUtil;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J\u000e\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0007J\u0010\u00100\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u00101\u001a\u00020(2\u0006\u0010$\u001a\u00020%R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0015\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001e\u0010\u0010¨\u00063"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostCompactCardBodyView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "headerMetadata", "", "headerMetadataView", "Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "getHeaderMetadataView", "()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "headerMetadataView$delegate", "Lkotlin/Lazy;", "metadata", "metadataView", "getMetadataView", "metadataView$delegate", "thumbnailView", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "getThumbnailView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "thumbnailView$delegate", "title", "titleView", "getTitleView", "titleView$delegate", "bottomMargin", "view", "Landroid/view/View;", "generateMetadata", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "heightMargins", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setThumbnailOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setTitleAlpha", "alpha", "topMargin", "update", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CrossPostCompactCardBodyView.kt */
public final class CrossPostCompactCardBodyView extends RelativeLayout {
    static final /* synthetic */ KProperty[] f20654a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostCompactCardBodyView.class), "thumbnailView", "getThumbnailView()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostCompactCardBodyView.class), "titleView", "getTitleView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostCompactCardBodyView.class), "headerMetadataView", "getHeaderMetadataView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostCompactCardBodyView.class), "metadataView", "getMetadataView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;"))};
    public static final Companion f20655e = new Companion();
    private static final String f20656j = Util.m24027f((int) C1761R.string.unicode_delimiter);
    String f20657b;
    String f20658c;
    String f20659d;
    private final Lazy f20660f;
    private final Lazy f20661g;
    private final Lazy f20662h;
    private final Lazy f20663i;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostCompactCardBodyView$Companion;", "", "()V", "DELIMITER", "", "getDELIMITER", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CrossPostCompactCardBodyView.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public CrossPostCompactCardBodyView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CrossPostCompactCardBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final RightIndentTextView getHeaderMetadataView() {
        return (RightIndentTextView) this.f20662h.mo5678b();
    }

    private final RightIndentTextView getMetadataView() {
        return (RightIndentTextView) this.f20663i.mo5678b();
    }

    private final RightIndentTextView getTitleView() {
        return (RightIndentTextView) this.f20661g.mo5678b();
    }

    final LinkThumbnailView getThumbnailView() {
        return (LinkThumbnailView) this.f20660f.mo5678b();
    }

    public /* synthetic */ CrossPostCompactCardBodyView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public CrossPostCompactCardBodyView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20660f = LazyKt.m26777a((Function0) new CrossPostCompactCardBodyView$thumbnailView$2(this));
        this.f20661g = LazyKt.m26777a((Function0) new CrossPostCompactCardBodyView$titleView$2(this));
        this.f20662h = LazyKt.m26777a((Function0) new CrossPostCompactCardBodyView$headerMetadataView$2(this));
        this.f20663i = LazyKt.m26777a((Function0) new CrossPostCompactCardBodyView$metadataView$2(this));
    }

    @TargetApi(21)
    public CrossPostCompactCardBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f20660f = LazyKt.m26777a((Function0) new CrossPostCompactCardBodyView$thumbnailView$2(this));
        this.f20661g = LazyKt.m26777a((Function0) new CrossPostCompactCardBodyView$titleView$2(this));
        this.f20662h = LazyKt.m26777a((Function0) new CrossPostCompactCardBodyView$headerMetadataView$2(this));
        this.f20663i = LazyKt.m26777a((Function0) new CrossPostCompactCardBodyView$metadataView$2(this));
    }

    protected final void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        int paddingLeft = (defaultSize - getPaddingLeft()) - getPaddingRight();
        if (getThumbnailView().getVisibility() != 8) {
            LayoutParams layoutParams = getThumbnailView().getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            i3 = ((RelativeLayout.LayoutParams) layoutParams).leftMargin;
            int paddingRight = (int) (((((double) defaultSize) * 0.25d) - ((double) getPaddingRight())) - ((double) i3));
            LayoutParams layoutParams2 = getThumbnailView().getLayoutParams();
            layoutParams2.width = paddingRight;
            layoutParams2.height = paddingRight;
            int i4 = (defaultSize - paddingRight) - i3;
            layoutParams = getThumbnailView().getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            i3 = paddingRight + (marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            defaultSize -= i4;
        } else {
            defaultSize = 0;
            i3 = defaultSize;
        }
        LayoutParams layoutParams3 = getTitleView().getLayoutParams();
        if (layoutParams3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        i3 -= ((MarginLayoutParams) layoutParams3).topMargin;
        RightIndentTextView titleView = getTitleView();
        titleView.setIndentHeight(i3);
        titleView.setIndentMargin(defaultSize);
        String str = this.f20657b;
        if (str == null) {
            Intrinsics.m26844a("title");
        }
        titleView.setText(str);
        getTitleView().measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        i3 -= getTitleView().getMeasuredHeight();
        LayoutParams layoutParams4 = getTitleView().getLayoutParams();
        if (layoutParams4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        i3 -= ((MarginLayoutParams) layoutParams4).bottomMargin;
        String str2 = this.f20659d;
        if (str2 != null) {
            if ((((CharSequence) str2).length() > 0 ? 1 : 0) == 0) {
                RightIndentTextView metadataView = getMetadataView();
                metadataView.setIndentHeight(Math.abs(i3));
                metadataView.setIndentMargin(defaultSize);
                metadataView.setText(this.f20659d);
                metadataView.setVisibility(0);
                getHeaderMetadataView().setText(this.f20658c);
                super.onMeasure(i, i2);
            }
        }
        getMetadataView().setVisibility(8);
        super.onMeasure(i, i2);
    }

    static String m22978a(LinkPresentationModel linkPresentationModel) {
        int score = linkPresentationModel.getScore();
        long j = linkPresentationModel.f33966S;
        linkPresentationModel = CountUtil.m23674a(j);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Util.m23959a((int) C1761R.plurals.fmt_num_points, score, Integer.valueOf(score)));
        stringBuilder.append(f20656j);
        stringBuilder.append(Util.m23959a((int) C1761R.plurals.fmt_num_comments, (int) j, linkPresentationModel));
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder()\n        …unt))\n        .toString()");
        return stringBuilder2;
    }

    public final void setTitleAlpha(int i) {
        getTitleView().setTextColor(getTitleView().getTextColors().withAlpha(i));
    }

    public final void setThumbnailOnClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        getThumbnailView().setOnClickListener(onClickListener);
    }
}
