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
import com.reddit.frontpage.ui.listing.newcard.RightIndentTextView;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0014J\u0018\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0007J\u000e\u00100\u001a\u00020'2\u0006\u0010$\u001a\u00020%R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0015\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001e\u0010\u0010¨\u00062"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostSmallCardBodyView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "headerMetadata", "", "headerMetadataView", "Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "getHeaderMetadataView", "()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "headerMetadataView$delegate", "Lkotlin/Lazy;", "metadata", "metadataView", "getMetadataView", "metadataView$delegate", "thumbnailView", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "getThumbnailView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "thumbnailView$delegate", "title", "titleView", "getTitleView", "titleView$delegate", "bottomMargin", "view", "Landroid/view/View;", "generateMetadata", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "onFinishInflate", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setPreviewOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setTitleAlpha", "alpha", "update", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CrossPostSmallCardBodyView.kt */
public final class CrossPostSmallCardBodyView extends RelativeLayout {
    static final /* synthetic */ KProperty[] f20681a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostSmallCardBodyView.class), "thumbnailView", "getThumbnailView()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostSmallCardBodyView.class), "titleView", "getTitleView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostSmallCardBodyView.class), "headerMetadataView", "getHeaderMetadataView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostSmallCardBodyView.class), "metadataView", "getMetadataView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;"))};
    public static final Companion f20682e = new Companion();
    private static final String f20683j = Util.m24027f((int) C1761R.string.unicode_delimiter);
    String f20684b;
    String f20685c;
    String f20686d;
    private final Lazy f20687f;
    private final Lazy f20688g;
    private final Lazy f20689h;
    private final Lazy f20690i;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostSmallCardBodyView$Companion;", "", "()V", "DELIMITER", "", "getDELIMITER", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CrossPostSmallCardBodyView.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public CrossPostSmallCardBodyView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CrossPostSmallCardBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final RightIndentTextView getHeaderMetadataView() {
        return (RightIndentTextView) this.f20689h.mo5678b();
    }

    private final RightIndentTextView getMetadataView() {
        return (RightIndentTextView) this.f20690i.mo5678b();
    }

    private final RightIndentTextView getTitleView() {
        return (RightIndentTextView) this.f20688g.mo5678b();
    }

    final LinkThumbnailView getThumbnailView() {
        return (LinkThumbnailView) this.f20687f.mo5678b();
    }

    public /* synthetic */ CrossPostSmallCardBodyView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public CrossPostSmallCardBodyView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20687f = LazyKt.m26777a((Function0) new CrossPostSmallCardBodyView$thumbnailView$2(this));
        this.f20688g = LazyKt.m26777a((Function0) new CrossPostSmallCardBodyView$titleView$2(this));
        this.f20689h = LazyKt.m26777a((Function0) new CrossPostSmallCardBodyView$headerMetadataView$2(this));
        this.f20690i = LazyKt.m26777a((Function0) new CrossPostSmallCardBodyView$metadataView$2(this));
    }

    @TargetApi(21)
    public CrossPostSmallCardBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f20687f = LazyKt.m26777a((Function0) new CrossPostSmallCardBodyView$thumbnailView$2(this));
        this.f20688g = LazyKt.m26777a((Function0) new CrossPostSmallCardBodyView$titleView$2(this));
        this.f20689h = LazyKt.m26777a((Function0) new CrossPostSmallCardBodyView$headerMetadataView$2(this));
        this.f20690i = LazyKt.m26777a((Function0) new CrossPostSmallCardBodyView$metadataView$2(this));
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
    }

    protected final void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        int paddingLeft = (defaultSize - getPaddingLeft()) - getPaddingRight();
        int i4 = 0;
        if (getThumbnailView().getVisibility() != 8) {
            LayoutParams layoutParams = getThumbnailView().getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            int i5 = ((RelativeLayout.LayoutParams) layoutParams).leftMargin;
            defaultSize = (int) (((((double) defaultSize) * 0.333d) - ((double) getPaddingRight())) - ((double) i5));
            LinkThumbnailView thumbnailView = getThumbnailView();
            thumbnailView.getLayoutParams().width = defaultSize;
            thumbnailView.getLayoutParams().height = defaultSize;
            LayoutParams layoutParams2 = getThumbnailView().getLayoutParams();
            if (layoutParams2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            i3 = ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin + defaultSize;
            defaultSize += i5;
        } else {
            defaultSize = 0;
            i3 = defaultSize;
        }
        RightIndentTextView titleView = getTitleView();
        titleView.setIndentHeight(i3);
        titleView.setIndentMargin(defaultSize);
        String str = this.f20684b;
        if (str == null) {
            Intrinsics.m26844a("title");
        }
        titleView.setText(str);
        getTitleView().measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        i3 -= getTitleView().getMeasuredHeight();
        LayoutParams layoutParams3 = getTitleView().getLayoutParams();
        if (layoutParams3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        i3 -= ((MarginLayoutParams) layoutParams3).bottomMargin;
        String str2 = this.f20686d;
        if (str2 != null) {
            if (str2.length() > 0) {
                i4 = 1;
            }
            if (i4 == 1) {
                RightIndentTextView metadataView = getMetadataView();
                metadataView.setIndentHeight(Math.abs(i3));
                metadataView.setIndentMargin(defaultSize);
                metadataView.setText(this.f20686d);
                ViewsKt.m24107c(metadataView);
                RightIndentTextView headerMetadataView = getHeaderMetadataView();
                str2 = this.f20685c;
                if (str2 == null) {
                    Intrinsics.m26844a("headerMetadata");
                }
                headerMetadataView.setText(str2);
                super.onMeasure(i, i2);
            }
        }
        ViewsKt.m24109d(getMetadataView());
        super.onMeasure(i, i2);
    }

    public final void setTitleAlpha(int i) {
        getTitleView().setTextColor(getTitleView().getTextColors().withAlpha(i));
    }

    public final void setPreviewOnClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        getThumbnailView().setOnClickListener(onClickListener);
    }
}
