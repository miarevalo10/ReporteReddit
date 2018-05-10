package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.domain.model.LinkType;
import com.reddit.frontpage.presentation.common.DomainUtil;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.util.Size;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0002J*\u0010+\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J(\u0010,\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020%H\u0014J\"\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00172\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020\u0007J\u0010\u00104\u001a\u00020%2\u0006\u00103\u001a\u00020\u0017H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00103\u001a\u00020\u0017H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001c\u0010\u0014R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "domainView", "Landroid/widget/TextView;", "getDomainView", "()Landroid/widget/TextView;", "domainView$delegate", "Lkotlin/Lazy;", "indicatorView", "Landroid/widget/ImageView;", "getIndicatorView", "()Landroid/widget/ImageView;", "indicatorView$delegate", "linkPresentationModel", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "placeholder", "Landroid/graphics/drawable/Drawable;", "thumbnailHeight", "thumbnailView", "getThumbnailView", "thumbnailView$delegate", "thumbnailWidth", "transformation", "Lcom/bumptech/glide/load/Transformation;", "Landroid/graphics/Bitmap;", "type", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailViewType;", "displayPlaceholder", "", "linkType", "Lcom/reddit/frontpage/domain/model/LinkType;", "displayPreview", "url", "", "init", "loadPreview", "width", "height", "imagePreview", "Lcom/reddit/frontpage/presentation/listing/model/ImageLinkPreviewPresentationModel;", "onFinishInflate", "update", "link", "updateCompactExtra", "updateStandardExtra", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkThumbnailView.kt */
public final class LinkThumbnailView extends FrameLayout {
    static final /* synthetic */ KProperty[] f20763a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkThumbnailView.class), "thumbnailView", "getThumbnailView()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkThumbnailView.class), "domainView", "getDomainView()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkThumbnailView.class), "indicatorView", "getIndicatorView()Landroid/widget/ImageView;"))};
    public static final Companion f20764b = new Companion();
    private static final int f20765l = 0;
    private final Lazy f20766c;
    private final Lazy f20767d;
    private final Lazy f20768e;
    private LinkPresentationModel f20769f;
    private int f20770g;
    private int f20771h;
    private LinkThumbnailViewType f20772i;
    private Transformation<Bitmap> f20773j;
    private Drawable f20774k;
    private HashMap f20775m;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView$Companion;", "", "()V", "DEFAULT_RES_ID", "", "getDEFAULT_RES_ID", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkThumbnailView.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20761a;
        public static final /* synthetic */ int[] f20762b;

        static {
            int[] iArr = new int[LinkType.values().length];
            f20761a = iArr;
            iArr[LinkType.VIDEO.ordinal()] = 1;
            f20761a[LinkType.SUBMITTED_VIDEO.ordinal()] = 2;
            f20761a[LinkType.WEBSITE.ordinal()] = 3;
            iArr = new int[LinkType.values().length];
            f20762b = iArr;
            iArr[LinkType.WEBSITE.ordinal()] = 1;
            f20762b[LinkType.SELF_IMAGE.ordinal()] = 2;
            f20762b[LinkType.IMAGE.ordinal()] = 3;
            f20762b[LinkType.VIDEO.ordinal()] = 4;
            f20762b[LinkType.SUBMITTED_VIDEO.ordinal()] = 5;
        }
    }

    public LinkThumbnailView(Context context) {
        this(context, null, 0, 6, null);
    }

    public LinkThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private View m23019a(int i) {
        if (this.f20775m == null) {
            this.f20775m = new HashMap();
        }
        View view = (View) this.f20775m.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f20775m.put(Integer.valueOf(i), view);
        return view;
    }

    private final TextView getDomainView() {
        return (TextView) this.f20767d.mo5678b();
    }

    private final ImageView getIndicatorView() {
        return (ImageView) this.f20768e.mo5678b();
    }

    private final ImageView getThumbnailView() {
        return (ImageView) this.f20766c.mo5678b();
    }

    public LinkThumbnailView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f20766c = LazyKt.m26777a(new LinkThumbnailView$thumbnailView$2(this));
        this.f20767d = LazyKt.m26777a(new LinkThumbnailView$domainView$2(this));
        this.f20768e = LazyKt.m26777a(new LinkThumbnailView$indicatorView$2(this));
        m23021a(context, attributeSet, i, 0);
    }

    public /* synthetic */ LinkThumbnailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    @TargetApi(21)
    public LinkThumbnailView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f20766c = LazyKt.m26777a(new LinkThumbnailView$thumbnailView$2(this));
        this.f20767d = LazyKt.m26777a(new LinkThumbnailView$domainView$2(this));
        this.f20768e = LazyKt.m26777a(new LinkThumbnailView$indicatorView$2(this));
        m23021a(context, attributeSet, i, i2);
    }

    private final void m23021a(Context context, AttributeSet attributeSet, int i, int i2) {
        context = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.LinkThumbnailView, i, i2);
        try {
            i = 1;
            i2 = 0;
            this.f20772i = LinkThumbnailViewType.values()[context.getInteger(1, 0)];
            attributeSet = context.getDimensionPixelOffset(0, 0);
            context = this.f20772i;
            if (context == null) {
                Intrinsics.m26844a("type");
            }
            context = context.f20782e;
            if (attributeSet == null) {
                i = new Transformation[i];
                i[i2] = new CenterCrop();
                attributeSet = (Transformation) new MultiTransformation(i);
            } else {
                attributeSet = new MultiTransformation(new Transformation[]{new CenterCrop(), (Transformation) new RoundedCorners(attributeSet)});
            }
            this.f20773j = attributeSet;
            View.inflate(getContext(), context, this);
            context = this.f20772i;
            if (context == null) {
                Intrinsics.m26844a("type");
            }
            this.f20774k = Util.m24032h(context.f20786i);
        } finally {
            context.recycle();
        }
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        getThumbnailView().addOnAttachStateChangeListener(new LinkThumbnailView$onFinishInflate$1(this, getThumbnailView()));
    }

    public final void m23026a(LinkPresentationModel linkPresentationModel, int i, int i2) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        this.f20769f = linkPresentationModel;
        this.f20770g = i;
        this.f20771h = i2;
        i = FrontpageSettings.a();
        LinkType linkType = linkPresentationModel.f33975b;
        if (linkType != LinkType.SELF) {
            if (i.b()) {
                if (linkType != LinkType.SELF_IMAGE) {
                    Object obj = this.f20772i;
                    if (obj == null) {
                        Intrinsics.m26844a("type");
                    }
                    if (Intrinsics.m26845a(obj, LinkThumbnailViewType.f20778b)) {
                    }
                }
            }
            setVisibility(0);
            if (i.b() != 0) {
                m23022a(linkType);
            } else if (linkPresentationModel.f33954G == 0) {
                m23022a(linkType);
            } else {
                i = new StringBuilder("Loading preview for ");
                i.append(linkPresentationModel);
                RedditLogger.m21982a(i.toString());
                i = getThumbnailView();
                i2 = linkPresentationModel.f33954G;
                int i3 = this.f20770g;
                int i4 = this.f20771h;
                if (i2.f28429a.isEmpty()) {
                    RedditLogger.m21983a((Throwable) new IllegalStateException(), "Can't get a sized preview if no preview sizes are available.");
                } else {
                    if (i3 == 0) {
                        i3 = i.getWidth();
                    }
                    if (i4 == 0) {
                        i4 = i.getHeight();
                    }
                    i = i2.m29675a(new Size(i3, i4)).getUrl();
                    getThumbnailView().setBackgroundResource(C1761R.drawable.rounded_corners_semi_transparent);
                    i2 = new SnooProgressDrawable(getContext());
                    GlideApp.a(getContext()).b(i).diskCacheStrategy(DiskCacheStrategy.a).placeholder((Drawable) i2).listener(ImageProgressLoadListener.a(i2, i)).into(getThumbnailView());
                    setVisibility(0);
                }
            }
            i = this.f20772i;
            if (i == 0) {
                Intrinsics.m26844a("type");
            }
            switch (com.reddit.frontpage.presentation.listing.ui.view.LinkThumbnailViewType.WhenMappings.f20776a[i.ordinal()]) {
                case 1:
                case 2:
                    i = 1;
                    break;
                case 3:
                case 4:
                    i = 0;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (i != 0) {
                switch (WhenMappings.f20761a[linkPresentationModel.f33975b.ordinal()]) {
                    case 1:
                    case 2:
                        linkPresentationModel = C1761R.drawable.ind_thumbnail_video;
                        break;
                    case 3:
                        linkPresentationModel = C1761R.drawable.ind_thumbnail_link;
                        break;
                    default:
                        linkPresentationModel = f20765l;
                        break;
                }
                i = getIndicatorView();
                if (i == 0) {
                    return;
                }
                if (linkPresentationModel != f20765l) {
                    i.setImageResource(linkPresentationModel);
                    i.setVisibility(0);
                    return;
                }
                i.setVisibility(8);
                return;
            }
            FrameLayout frameLayout;
            i = DomainUtil.m22714a(linkPresentationModel.f33974a);
            if (!(Intrinsics.m26845a(linkPresentationModel.f33975b, LinkType.WEBSITE) == null || i == 0)) {
                CharSequence charSequence = (CharSequence) i;
                if ((charSequence.length() > null ? 1 : null) == 1) {
                    linkPresentationModel = getDomainView();
                    linkPresentationModel.setText(charSequence);
                    linkPresentationModel.setVisibility(0);
                    frameLayout = (FrameLayout) m23019a(C1761R.id.domain_background);
                    if (frameLayout != null) {
                        ViewsKt.m24107c(frameLayout);
                    }
                    return;
                }
            }
            getDomainView().setVisibility(8);
            frameLayout = (FrameLayout) m23019a(C1761R.id.domain_background);
            if (frameLayout != null) {
                ViewsKt.m24109d(frameLayout);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    private final void m23022a(LinkType linkType) {
        switch (WhenMappings.f20762b[linkType.ordinal()]) {
            case 1:
                linkType = this.f20772i;
                if (linkType == null) {
                    Intrinsics.m26844a("type");
                }
                linkType = linkType.f20783f;
                break;
            case 2:
            case 3:
                linkType = this.f20772i;
                if (linkType == null) {
                    Intrinsics.m26844a("type");
                }
                linkType = linkType.f20784g;
                break;
            case 4:
            case 5:
                linkType = this.f20772i;
                if (linkType == null) {
                    Intrinsics.m26844a("type");
                }
                linkType = linkType.f20785h;
                break;
            default:
                linkType = f20765l;
                break;
        }
        if (linkType != f20765l) {
            ImageView thumbnailView = getThumbnailView();
            thumbnailView.setBackground(this.f20774k);
            thumbnailView.setImageResource(linkType);
            thumbnailView.setScaleType(ScaleType.CENTER);
        }
    }
}
