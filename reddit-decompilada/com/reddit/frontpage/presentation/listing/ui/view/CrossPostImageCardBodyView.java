package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.listing.newcard.RightIndentTextView;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.TopCrop;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001?B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u001a\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u0007H\u0002J\u0010\u00103\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J*\u00104\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020/H\u0014J\u0018\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J\u000e\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020/2\u0006\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001a\u0010\u0010R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b#\u0010 R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b'\u0010(R\u0010\u0010*\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0012\u001a\u0004\b,\u0010\u0010¨\u0006@"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostImageCardBodyView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "headerMetadata", "", "headerMetadataView", "Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "getHeaderMetadataView", "()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "headerMetadataView$delegate", "Lkotlin/Lazy;", "imageDimension", "Landroid/graphics/Point;", "lastWidth", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "metadata", "metadataView", "getMetadataView", "metadataView$delegate", "minHeight", "playIcon", "Landroid/widget/ImageView;", "getPlayIcon", "()Landroid/widget/ImageView;", "playIcon$delegate", "preview", "getPreview", "preview$delegate", "progressDrawable", "Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "getProgressDrawable", "()Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "progressDrawable$delegate", "title", "titleView", "getTitleView", "titleView$delegate", "bindImage", "", "previewImage", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;", "width", "generateMetadata", "init", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setPreviewOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setTitleAlpha", "alpha", "update", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CrossPostImageCardBodyView.kt */
public final class CrossPostImageCardBodyView extends LinearLayout {
    static final /* synthetic */ KProperty[] f20664a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostImageCardBodyView.class), "preview", "getPreview()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostImageCardBodyView.class), "titleView", "getTitleView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostImageCardBodyView.class), "headerMetadataView", "getHeaderMetadataView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostImageCardBodyView.class), "metadataView", "getMetadataView()Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostImageCardBodyView.class), "playIcon", "getPlayIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostImageCardBodyView.class), "progressDrawable", "getProgressDrawable()Lcom/reddit/frontpage/animation/SnooProgressDrawable;"))};
    public static final Companion f20665f = new Companion();
    private static final String f20666p = Util.m24027f((int) C1761R.string.unicode_delimiter);
    private static final int f20667q = Util.m24012d((int) C1761R.dimen.link_image_min_height);
    String f20668b;
    String f20669c;
    String f20670d;
    LinkPresentationModel f20671e;
    private final Lazy f20672g;
    private final Lazy f20673h;
    private final Lazy f20674i;
    private final Lazy f20675j;
    private final Lazy f20676k;
    private Point f20677l;
    private final Lazy f20678m;
    private int f20679n;
    private int f20680o;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/CrossPostImageCardBodyView$Companion;", "", "()V", "DELIMITER", "", "getDELIMITER", "()Ljava/lang/String;", "LINK_IMAGE_MIN_HEIGHT", "", "getLINK_IMAGE_MIN_HEIGHT", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CrossPostImageCardBodyView.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public CrossPostImageCardBodyView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CrossPostImageCardBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final ImageView getPlayIcon() {
        return (ImageView) this.f20676k.mo5678b();
    }

    private final ImageView getPreview() {
        return (ImageView) this.f20672g.mo5678b();
    }

    private final SnooProgressDrawable getProgressDrawable() {
        return (SnooProgressDrawable) this.f20678m.mo5678b();
    }

    final RightIndentTextView getHeaderMetadataView() {
        return (RightIndentTextView) this.f20674i.mo5678b();
    }

    final RightIndentTextView getMetadataView() {
        return (RightIndentTextView) this.f20675j.mo5678b();
    }

    final RightIndentTextView getTitleView() {
        return (RightIndentTextView) this.f20673h.mo5678b();
    }

    public /* synthetic */ CrossPostImageCardBodyView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public CrossPostImageCardBodyView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20672g = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$preview$2(this));
        this.f20673h = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$titleView$2(this));
        this.f20674i = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$headerMetadataView$2(this));
        this.f20675j = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$metadataView$2(this));
        this.f20676k = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$playIcon$2(this));
        this.f20677l = new Point();
        this.f20678m = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$progressDrawable$2(this));
        m22983c();
    }

    @TargetApi(21)
    public CrossPostImageCardBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f20672g = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$preview$2(this));
        this.f20673h = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$titleView$2(this));
        this.f20674i = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$headerMetadataView$2(this));
        this.f20675j = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$metadataView$2(this));
        this.f20676k = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$playIcon$2(this));
        this.f20677l = new Point();
        this.f20678m = LazyKt.m26777a((Function0) new CrossPostImageCardBodyView$progressDrawable$2(this));
        m22983c();
    }

    private final void m22983c() {
        this.f20679n = Util.m24012d((int) C1761R.dimen.link_image_min_height);
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
    }

    protected final void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        if (defaultSize != this.f20680o) {
            Point point = this.f20677l;
            point.x = defaultSize;
            point.y = f20667q;
            LinkPresentationModel linkPresentationModel = this.f20671e;
            if (linkPresentationModel == null) {
                Intrinsics.m26844a("link");
            }
            ImageResolution a = LinkUtil.m23775a((Link) new ClientLink(linkPresentationModel.av), FrontpageSettings.a().g(), this.f20677l);
            ImageView preview = getPreview();
            if (preview != null) {
                ImageView playIcon = getPlayIcon();
                if (playIcon != null) {
                    if (a == null) {
                        preview.setVisibility(8);
                    } else {
                        float height = (float) a.getHeight();
                        float width = (float) a.getWidth();
                        if (height >= width) {
                            preview.getLayoutParams().height = (int) (((float) defaultSize) * 0.75f);
                        } else {
                            preview.getLayoutParams().height = (int) Math.max((float) this.f20679n, (((float) defaultSize) / width) * height);
                        }
                        requestLayout();
                        View view = playIcon;
                        LinkPresentationModel linkPresentationModel2 = this.f20671e;
                        if (linkPresentationModel2 == null) {
                            Intrinsics.m26844a("link");
                        }
                        ViewsKt.m24103a(view, Intrinsics.m26845a(linkPresentationModel2.f33975b, LinkType.VIDEO));
                        GlideApp.a(getContext()).b(a.getUrl()).diskCacheStrategy(DiskCacheStrategy.a).transform(new TopCrop()).transition(DrawableTransitionOptions.b()).placeholder(getProgressDrawable()).listener(ImageProgressLoadListener.a(getProgressDrawable(), a.getUrl())).into(preview).f();
                    }
                }
            }
            this.f20680o = defaultSize;
        }
        super.onMeasure(i, i2);
    }

    public final void setTitleAlpha(int i) {
        getTitleView().setTextColor(getTitleView().getTextColors().withAlpha(i));
    }

    public final void setPreviewOnClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        ImageView preview = getPreview();
        if (preview != null) {
            preview.setOnClickListener(onClickListener);
        }
    }
}
