package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
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
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import com.reddit.frontpage.ui.listing.newcard.RightIndentTextView;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.DateUtil;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 >2\u00020\u0001:\u0001>B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\b\u0010+\u001a\u00020,H\u0014J\u0018\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u000e\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020,2\u0006\u00104\u001a\u000202J\u0010\u00105\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102J\u000e\u00106\u001a\u00020,2\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b$\u0010\u0016R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)¨\u0006?"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "flairView", "Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "getFlairView", "()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "flairView$delegate", "Lkotlin/Lazy;", "selfText", "", "selfTextView", "Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "getSelfTextView", "()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "selfTextView$delegate", "smallCrossPostCardBody", "Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostSmallCardBodyView;", "getSmallCrossPostCardBody", "()Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostSmallCardBodyView;", "smallCrossPostCardBody$delegate", "thumbnailView", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "getThumbnailView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "thumbnailView$delegate", "title", "titleView", "getTitleView", "titleView$delegate", "videoCrossPostCardBody", "Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostImageCardBodyView;", "getVideoCrossPostCardBody", "()Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostImageCardBodyView;", "videoCrossPostCardBody$delegate", "onFinishInflate", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCrossPostEmbedOnClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setCrossPostPreviewOnClickListener", "listener", "setPreviewOnClickListener", "setShowLinkFlair", "showLinkFlair", "", "setTitleAlpha", "alpha", "update", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SmallCardBodyView.kt */
public final class SmallCardBodyView extends RelativeLayout {
    static final /* synthetic */ KProperty[] f20807a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SmallCardBodyView.class), "titleView", "getTitleView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SmallCardBodyView.class), "thumbnailView", "getThumbnailView()Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SmallCardBodyView.class), "selfTextView", "getSelfTextView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SmallCardBodyView.class), "flairView", "getFlairView()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SmallCardBodyView.class), "smallCrossPostCardBody", "getSmallCrossPostCardBody()Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostSmallCardBodyView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SmallCardBodyView.class), "videoCrossPostCardBody", "getVideoCrossPostCardBody()Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostImageCardBodyView;"))};
    public static final Companion f20808b = new Companion();
    private static final int f20809k = 150;
    private static final int f20810l = 140;
    private final Lazy f20811c;
    private final Lazy f20812d;
    private final Lazy f20813e;
    private final Lazy f20814f;
    private final Lazy f20815g;
    private final Lazy f20816h;
    private String f20817i;
    private String f20818j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView$Companion;", "", "()V", "MIN_SELF_TEXT_LENGTH", "", "getMIN_SELF_TEXT_LENGTH", "()I", "SHORT_TITLE_LENGTH", "getSHORT_TITLE_LENGTH", "bottomMargin", "view", "Landroid/view/View;", "topMargin", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SmallCardBodyView.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ int m23040a(View view) {
            view = view.getLayoutParams();
            if (view != null) {
                return ((MarginLayoutParams) view).bottomMargin;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        public static final /* synthetic */ int m23041b(View view) {
            if (view == null) {
                return null;
            }
            view = view.getLayoutParams();
            if (view != null) {
                return ((MarginLayoutParams) view).topMargin;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    public SmallCardBodyView(Context context) {
        this(context, null, 0, 6, null);
    }

    public SmallCardBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final LinkFlairView getFlairView() {
        return (LinkFlairView) this.f20814f.mo5678b();
    }

    private final RightIndentTextView getSelfTextView() {
        return (RightIndentTextView) this.f20813e.mo5678b();
    }

    private final CrossPostSmallCardBodyView getSmallCrossPostCardBody() {
        return (CrossPostSmallCardBodyView) this.f20815g.mo5678b();
    }

    private final LinkThumbnailView getThumbnailView() {
        return (LinkThumbnailView) this.f20812d.mo5678b();
    }

    private final RightIndentTextView getTitleView() {
        return (RightIndentTextView) this.f20811c.mo5678b();
    }

    private final CrossPostImageCardBodyView getVideoCrossPostCardBody() {
        return (CrossPostImageCardBodyView) this.f20816h.mo5678b();
    }

    public /* synthetic */ SmallCardBodyView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public SmallCardBodyView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20811c = LazyKt.m26777a((Function0) new SmallCardBodyView$titleView$2(this));
        this.f20812d = LazyKt.m26777a((Function0) new SmallCardBodyView$thumbnailView$2(this));
        this.f20813e = LazyKt.m26777a((Function0) new SmallCardBodyView$selfTextView$2(this));
        this.f20814f = LazyKt.m26777a((Function0) new SmallCardBodyView$flairView$2(this));
        this.f20815g = LazyKt.m26777a((Function0) new SmallCardBodyView$smallCrossPostCardBody$2(this));
        this.f20816h = LazyKt.m26777a((Function0) new SmallCardBodyView$videoCrossPostCardBody$2(this));
    }

    @TargetApi(21)
    public SmallCardBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f20811c = LazyKt.m26777a((Function0) new SmallCardBodyView$titleView$2(this));
        this.f20812d = LazyKt.m26777a((Function0) new SmallCardBodyView$thumbnailView$2(this));
        this.f20813e = LazyKt.m26777a((Function0) new SmallCardBodyView$selfTextView$2(this));
        this.f20814f = LazyKt.m26777a((Function0) new SmallCardBodyView$flairView$2(this));
        this.f20815g = LazyKt.m26777a((Function0) new SmallCardBodyView$smallCrossPostCardBody$2(this));
        this.f20816h = LazyKt.m26777a((Function0) new SmallCardBodyView$videoCrossPostCardBody$2(this));
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
    }

    protected final void onMeasure(int i, int i2) {
        int i3;
        LayoutParams layoutParams;
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        int paddingLeft = (defaultSize - getPaddingLeft()) - getPaddingRight();
        LinkThumbnailView thumbnailView = getThumbnailView();
        if (thumbnailView == null || thumbnailView.getVisibility() == 8) {
            defaultSize = 0;
            i3 = defaultSize;
        } else {
            layoutParams = thumbnailView.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            int i4 = ((RelativeLayout.LayoutParams) layoutParams).leftMargin;
            defaultSize = (int) (((((double) defaultSize) * 0.333d) - ((double) getPaddingRight())) - ((double) i4));
            thumbnailView.getLayoutParams().width = defaultSize;
            thumbnailView.getLayoutParams().height = defaultSize;
            LayoutParams layoutParams2 = thumbnailView.getLayoutParams();
            if (layoutParams2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            i3 = ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin + defaultSize;
            defaultSize += i4;
        }
        RightIndentTextView titleView = getTitleView();
        titleView.setIndentHeight(i3);
        titleView.setIndentMargin(defaultSize);
        titleView.setText(this.f20817i);
        getTitleView().measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        i3 = ((i3 - getTitleView().getMeasuredHeight()) - Companion.m23040a(getTitleView())) - Companion.m23041b(getFlairView());
        if (i3 > 0) {
            paddingLeft -= defaultSize;
        }
        layoutParams = getFlairView().getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        ((RelativeLayout.LayoutParams) layoutParams).width = paddingLeft;
        getFlairView().measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        if (TextUtils.isEmpty(this.f20818j)) {
            RightIndentTextView selfTextView = getSelfTextView();
            if (selfTextView != null) {
                ViewsKt.m24109d(selfTextView);
            }
        } else {
            i3 = ((i3 - getFlairView().getMeasuredHeight()) - Companion.m23040a(getFlairView())) - Companion.m23041b(getSelfTextView());
            RightIndentTextView selfTextView2 = getSelfTextView();
            if (selfTextView2 != null) {
                selfTextView2.setIndentHeight(Math.abs(i3));
                selfTextView2.setIndentMargin(defaultSize);
                selfTextView2.setText(this.f20818j);
                ViewsKt.m24107c(selfTextView2);
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setShowLinkFlair(boolean z) {
        getFlairView().setShowLinkFlair(z);
    }

    public final void setTitleAlpha(int i) {
        getTitleView().setTextColor(getTitleView().getTextColors().withAlpha(i));
    }

    public final void setPreviewOnClickListener(OnClickListener onClickListener) {
        LinkThumbnailView thumbnailView = getThumbnailView();
        if (thumbnailView != null) {
            thumbnailView.setOnClickListener(onClickListener);
        }
    }

    public final void setCrossPostEmbedOnClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "onClickListener");
        CrossPostSmallCardBodyView smallCrossPostCardBody = getSmallCrossPostCardBody();
        if (smallCrossPostCardBody != null) {
            smallCrossPostCardBody.setOnClickListener(onClickListener);
        }
        CrossPostImageCardBodyView videoCrossPostCardBody = getVideoCrossPostCardBody();
        if (videoCrossPostCardBody != null) {
            videoCrossPostCardBody.setOnClickListener(onClickListener);
        }
    }

    public final void setCrossPostPreviewOnClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        CrossPostSmallCardBodyView smallCrossPostCardBody = getSmallCrossPostCardBody();
        if (smallCrossPostCardBody != null) {
            smallCrossPostCardBody.setPreviewOnClickListener(onClickListener);
        }
        CrossPostImageCardBodyView videoCrossPostCardBody = getVideoCrossPostCardBody();
        if (videoCrossPostCardBody != null) {
            videoCrossPostCardBody.setPreviewOnClickListener(onClickListener);
        }
    }

    public final void m23043a(LinkPresentationModel linkPresentationModel) {
        LinkPresentationModel linkPresentationModel2 = linkPresentationModel;
        Intrinsics.m26847b(linkPresentationModel2, "link");
        this.f20817i = linkPresentationModel2.f33999z;
        this.f20818j = null;
        if (!linkPresentationModel2.f33953F) {
            String str;
            if (linkPresentationModel2.ao) {
                str = linkPresentationModel2.f33959L;
                if (str != null) {
                    if ((((CharSequence) str).length() > 0 ? 1 : 0) == 1) {
                        str = linkPresentationModel2.f33959L;
                        int min = Math.min(linkPresentationModel2.f33959L.length(), 400);
                        if (str == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        str = str.substring(0, min);
                        Intrinsics.m26843a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        str = Util.m24030g(str);
                        if (str != null && str.length() >= f20810l) {
                            r0.f20818j = str;
                        }
                    }
                }
            }
            str = null;
            str = Util.m24030g(str);
            r0.f20818j = str;
        }
        LinkThumbnailView thumbnailView = getThumbnailView();
        if (thumbnailView != null) {
            thumbnailView.m23026a(linkPresentationModel2, 0, 0);
        }
        getFlairView().m23475a(linkPresentationModel2);
        linkPresentationModel2 = linkPresentationModel2.am;
        if (linkPresentationModel2 != null) {
            CrossPostSmallCardBodyView smallCrossPostCardBody = getSmallCrossPostCardBody();
            if (smallCrossPostCardBody != null) {
                String f;
                Intrinsics.m26847b(linkPresentationModel2, "link");
                smallCrossPostCardBody.f20684b = linkPresentationModel2.f33999z;
                smallCrossPostCardBody.f20686d = null;
                CharSequence b = DateUtil.m23684b(linkPresentationModel2.f33982i);
                if (Util.m24041k(linkPresentationModel2.f33985l)) {
                    f = Util.m24027f((int) C1761R.string.deleted_author);
                    Intrinsics.m26843a((Object) f, "Util.getString(R.string.deleted_author)");
                } else {
                    f = Util.m23960a((int) C1761R.string.fmt_u_name, linkPresentationModel2.f33985l);
                    Intrinsics.m26843a((Object) f, "Util.getString(R.string.fmt_u_name, link.author)");
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(linkPresentationModel2.f33979f);
                com.reddit.frontpage.presentation.listing.ui.view.CrossPostSmallCardBodyView.Companion companion = CrossPostSmallCardBodyView.f20682e;
                stringBuilder.append(CrossPostSmallCardBodyView.f20683j);
                stringBuilder.append(b);
                com.reddit.frontpage.presentation.listing.ui.view.CrossPostSmallCardBodyView.Companion companion2 = CrossPostSmallCardBodyView.f20682e;
                stringBuilder.append(CrossPostSmallCardBodyView.f20683j);
                stringBuilder.append(f);
                Object stringBuilder2 = stringBuilder.toString();
                Intrinsics.m26843a(stringBuilder2, "headerBuilder.toString()");
                smallCrossPostCardBody.f20685c = stringBuilder2;
                int score = linkPresentationModel2.getScore();
                long j = linkPresentationModel2.f33966S;
                String a = CountUtil.m23674a(j);
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(Util.m23959a((int) C1761R.plurals.fmt_num_points, score, Integer.valueOf(score)));
                companion2 = CrossPostSmallCardBodyView.f20682e;
                stringBuilder3.append(CrossPostSmallCardBodyView.f20683j);
                stringBuilder3.append(Util.m23959a((int) C1761R.plurals.fmt_num_comments, (int) j, a));
                stringBuilder2 = stringBuilder3.toString();
                Intrinsics.m26843a(stringBuilder2, "StringBuilder()\n        …    )\n        .toString()");
                smallCrossPostCardBody.f20686d = stringBuilder2;
                smallCrossPostCardBody.getThumbnailView().m23026a(linkPresentationModel2, 0, 0);
                smallCrossPostCardBody.invalidate();
                smallCrossPostCardBody.requestLayout();
            }
            CrossPostImageCardBodyView videoCrossPostCardBody = getVideoCrossPostCardBody();
            if (videoCrossPostCardBody != null) {
                String f2;
                Intrinsics.m26847b(linkPresentationModel2, "link");
                videoCrossPostCardBody.f20671e = linkPresentationModel2;
                videoCrossPostCardBody.f20668b = linkPresentationModel2.f33999z;
                videoCrossPostCardBody.f20670d = null;
                CharSequence b2 = DateUtil.m23684b(linkPresentationModel2.f33982i);
                if (Util.m24041k(linkPresentationModel2.f33985l)) {
                    f2 = Util.m24027f((int) C1761R.string.deleted_author);
                    Intrinsics.m26843a((Object) f2, "Util.getString(R.string.deleted_author)");
                } else {
                    f2 = Util.m23960a((int) C1761R.string.fmt_u_name, linkPresentationModel2.f33985l);
                    Intrinsics.m26843a((Object) f2, "Util.getString(R.string.fmt_u_name, link.author)");
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(linkPresentationModel2.f33979f);
                com.reddit.frontpage.presentation.listing.ui.view.CrossPostImageCardBodyView.Companion companion3 = CrossPostImageCardBodyView.f20665f;
                stringBuilder4.append(CrossPostImageCardBodyView.f20666p);
                stringBuilder4.append(b2);
                com.reddit.frontpage.presentation.listing.ui.view.CrossPostImageCardBodyView.Companion companion4 = CrossPostImageCardBodyView.f20665f;
                stringBuilder4.append(CrossPostImageCardBodyView.f20666p);
                stringBuilder4.append(f2);
                videoCrossPostCardBody.f20669c = stringBuilder4.toString();
                int score2 = linkPresentationModel2.getScore();
                long j2 = linkPresentationModel2.f33966S;
                String a2 = CountUtil.m23674a(j2);
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(Util.m23959a((int) C1761R.plurals.fmt_num_points, score2, Integer.valueOf(score2)));
                companion4 = CrossPostImageCardBodyView.f20665f;
                stringBuilder5.append(CrossPostImageCardBodyView.f20666p);
                stringBuilder5.append(Util.m23959a((int) C1761R.plurals.fmt_num_comments, (int) j2, a2));
                Object stringBuilder6 = stringBuilder5.toString();
                Intrinsics.m26843a(stringBuilder6, "StringBuilder().apply {\n…yCount))\n    }.toString()");
                videoCrossPostCardBody.f20670d = stringBuilder6;
                videoCrossPostCardBody.getTitleView().setText(videoCrossPostCardBody.f20668b);
                a2 = videoCrossPostCardBody.f20670d;
                if (a2 != null) {
                    if ((((CharSequence) a2).length() > 0 ? 1 : 0) == 1) {
                        videoCrossPostCardBody.getHeaderMetadataView().setText(videoCrossPostCardBody.f20669c);
                        RightIndentTextView metadataView = videoCrossPostCardBody.getMetadataView();
                        metadataView.setText(videoCrossPostCardBody.f20670d);
                        metadataView.setVisibility(0);
                        videoCrossPostCardBody.invalidate();
                        videoCrossPostCardBody.requestLayout();
                    }
                }
                videoCrossPostCardBody.getMetadataView().setVisibility(8);
                videoCrossPostCardBody.invalidate();
                videoCrossPostCardBody.requestLayout();
            }
        }
        invalidate();
        requestLayout();
    }
}
