package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.domain.model.ImageResolution;
import com.reddit.frontpage.presentation.listing.model.ImageLinkPreviewPresentationModel;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.model.Mp4LinkPreviewPresentationModel;
import com.reddit.frontpage.presentation.listing.util.Size;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.ui.listener.RemoteImageAttachStateListener;
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import com.reddit.frontpage.ui.listing.newcard.VideoCardLinkViewHolderLegacy.CurrentPlayListener;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.LinkTitleView;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u001f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0016H\u0002J\b\u00103\u001a\u00020/H\u0016J\b\u00104\u001a\u00020/H\u0016J\u0010\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020\u0016H\u0014J\u0010\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\u0007H\u0014R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0014\u001a\u0004\b+\u0010,¨\u0006:"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoCardLinkViewHolderLegacy;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "itemView", "Landroid/view/View;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "(Landroid/view/View;Lcom/reddit/frontpage/ui/listener/Consumer;)V", "currentPlayListener", "Lcom/reddit/frontpage/ui/listing/newcard/VideoCardLinkViewHolderLegacy$CurrentPlayListener;", "getCurrentPlayListener", "()Lcom/reddit/frontpage/ui/listing/newcard/VideoCardLinkViewHolderLegacy$CurrentPlayListener;", "setCurrentPlayListener", "(Lcom/reddit/frontpage/ui/listing/newcard/VideoCardLinkViewHolderLegacy$CurrentPlayListener;)V", "flairView", "Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "getFlairView", "()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "flairView$delegate", "Lkotlin/Lazy;", "isVideoPlayerVisible", "", "()Z", "localBounds", "Landroid/graphics/Rect;", "minPreviewWidth", "mp4Url", "", "progressDrawable", "Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "getProgressDrawable", "()Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "progressDrawable$delegate", "screenHeight", "screenWidth", "titleView", "Lcom/reddit/frontpage/widgets/LinkTitleView;", "getTitleView", "()Lcom/reddit/frontpage/widgets/LinkTitleView;", "titleView$delegate", "videoPlayerOld", "Lcom/reddit/frontpage/widgets/video/VideoPlayerOld;", "getVideoPlayerOld", "()Lcom/reddit/frontpage/widgets/video/VideoPlayerOld;", "videoPlayerOld$delegate", "bindLink", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "hasVideo", "notifyOffScreen", "notifyOnScreen", "updateLinkFlairVisibility", "visible", "updateReadStatus", "alpha", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: VideoCardLinkViewHolderLegacy.kt */
public class VideoCardLinkViewHolderLegacy extends LinkViewHolder implements VisibilityDependent {
    private static final float f36944H = 0.8f;
    static final /* synthetic */ KProperty[] f36945a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolderLegacy.class), "titleView", "getTitleView()Lcom/reddit/frontpage/widgets/LinkTitleView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolderLegacy.class), "flairView", "getFlairView()Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolderLegacy.class), "videoPlayerOld", "getVideoPlayerOld()Lcom/reddit/frontpage/widgets/video/VideoPlayerOld;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(VideoCardLinkViewHolderLegacy.class), "progressDrawable", "getProgressDrawable()Lcom/reddit/frontpage/animation/SnooProgressDrawable;"))};
    public static final Companion f36946x = new Companion();
    private final Lazy f36947A;
    private final int f36948B;
    private final int f36949C;
    private final int f36950D;
    private final Lazy f36951E;
    private String f36952F;
    private final Rect f36953G = new Rect();
    public CurrentPlayListener f36954b;
    private final Lazy f36955y;
    private final Lazy f36956z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoCardLinkViewHolderLegacy$Companion;", "", "()V", "PERCENTAGE_AREA_EXPOSED_BEFORE_AUTOPLAY", "", "getPERCENTAGE_AREA_EXPOSED_BEFORE_AUTOPLAY", "()F", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/VideoCardLinkViewHolderLegacy;", "parent", "Landroid/view/ViewGroup;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: VideoCardLinkViewHolderLegacy.kt */
    public static final class Companion {
        private Companion() {
        }

        public static VideoCardLinkViewHolderLegacy m23071a(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            return new VideoCardLinkViewHolderLegacy(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_video_card_link_old, false), null);
        }

        public static VideoCardLinkViewHolderLegacy m23072a(ViewGroup viewGroup, Consumer<Integer> consumer) {
            Intrinsics.m26847b(viewGroup, "parent");
            Intrinsics.m26847b(consumer, "lastClickPositionListener");
            return new VideoCardLinkViewHolderLegacy(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_video_card_link_old, false), consumer);
        }
    }

    private final SnooProgressDrawable m37328A() {
        return (SnooProgressDrawable) this.f36951E.mo5678b();
    }

    public static final VideoCardLinkViewHolderLegacy m37331a(ViewGroup viewGroup) {
        return Companion.m23071a(viewGroup);
    }

    public static final VideoCardLinkViewHolderLegacy m37332a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return Companion.m23072a(viewGroup, consumer);
    }

    private final LinkTitleView m37335x() {
        return (LinkTitleView) this.f36955y.mo5678b();
    }

    private final LinkFlairView m37336y() {
        return (LinkFlairView) this.f36956z.mo5678b();
    }

    private final VideoPlayerOld m37337z() {
        return (VideoPlayerOld) this.f36947A.mo5678b();
    }

    protected VideoCardLinkViewHolderLegacy(View view, final Consumer<Integer> consumer) {
        Intrinsics.m26847b(view, "itemView");
        super(view);
        this.f36955y = LazyKt.m26777a(new VideoCardLinkViewHolderLegacy$titleView$2(view));
        this.f36956z = LazyKt.m26777a(new VideoCardLinkViewHolderLegacy$flairView$2(view));
        this.f36947A = LazyKt.m26777a(new VideoCardLinkViewHolderLegacy$videoPlayerOld$2(view));
        this.f36951E = LazyKt.m26777a(new VideoCardLinkViewHolderLegacy$progressDrawable$2(view));
        Object d = Util.m24014d(view.getContext());
        Object context = view.getContext();
        Intrinsics.m26843a(context, "itemView.context");
        this.f36948B = context.getResources().getDimensionPixelSize(C1761R.dimen.link_image_min_height);
        Intrinsics.m26843a(d, "context");
        context = d.getWindow();
        Intrinsics.m26843a(context, "context.window");
        context = context.getDecorView();
        Intrinsics.m26843a(context, "context.window.decorView");
        this.f36949C = context.getWidth();
        context = d.getWindow();
        Intrinsics.m26843a(context, "context.window");
        context = context.getDecorView();
        Intrinsics.m26843a(context, "context.window.decorView");
        this.f36950D = context.getHeight();
        m37337z().setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                view = this.f34045r;
                if (view != null) {
                    Consumer consumer = consumer;
                    if (consumer != null) {
                        consumer.mo4813a(Integer.valueOf(this.d()));
                    }
                    view.mo4828a(this.m34773O());
                    this.m37337z().m24392j();
                }
            }
        });
        view = m37337z();
        d = m37337z().getPreviewImage();
        Intrinsics.m26843a(d, "videoPlayerOld.previewImage");
        view.addOnAttachStateChangeListener((OnAttachStateChangeListener) new RemoteImageAttachStateListener(d) {
            public final void onViewAttachedToWindow(View view) {
                Intrinsics.m26847b(view, "v");
                this.mo6963a(this.m34773O());
            }
        });
    }

    private final boolean m37329B() {
        m37337z().getLocalVisibleRect(this.f36953G);
        if (this.f36953G.top >= 0) {
            if (this.f36953G.top <= m37337z().getHeight()) {
                Timber.b("[%s]: Percent visible: [%f]", new Object[]{m34773O().f33977d, Float.valueOf(((float) (this.f36953G.bottom - this.f36953G.top)) / ((float) m37337z().getHeight()))});
                if (((float) (this.f36953G.bottom - this.f36953G.top)) / ((float) m37337z().getHeight()) >= f36944H) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final void mo6963a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        super.mo6963a(linkPresentationModel);
        m37335x().m35294a(linkPresentationModel);
        m37336y().m23475a(linkPresentationModel);
        Size size = new Size(this.f36949C, this.f36950D);
        ImageLinkPreviewPresentationModel imageLinkPreviewPresentationModel = linkPresentationModel.f33954G;
        String str = null;
        ImageResolution a = imageLinkPreviewPresentationModel != null ? imageLinkPreviewPresentationModel.m29675a(size) : null;
        if (a == null) {
            ViewsKt.m24109d(m37337z());
            return;
        }
        int i;
        Mp4LinkPreviewPresentationModel mp4LinkPreviewPresentationModel = linkPresentationModel.f33955H;
        if (mp4LinkPreviewPresentationModel != null) {
            str = mp4LinkPreviewPresentationModel.m29676a(size);
        }
        this.f36952F = str;
        Timber.b("VideoCardLinkViewHolderLegacy: extracted mp4 url [%s] %s", new Object[]{linkPresentationModel.f33999z, this.f36952F});
        linkPresentationModel = (float) a.getHeight();
        float width = (float) a.getWidth();
        if (linkPresentationModel >= width) {
            i = this.f36949C;
            linkPresentationModel = (int) ((((float) i) / linkPresentationModel) * width);
        } else {
            i = (int) Math.max((float) this.f36948B, (((float) this.f36949C) / width) * linkPresentationModel);
            linkPresentationModel = this.f36949C;
        }
        LayoutParams layoutParams = m37337z().getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = linkPresentationModel;
        if (m37330C()) {
            boolean B = m37329B();
            VideoPlayerOld z = m37337z();
            String str2 = this.f36952F;
            if (str2 == null) {
                Intrinsics.m26842a();
            }
            z.m24383a(str2, B, false);
        } else {
            m37337z().m24392j();
        }
        this.c.requestLayout();
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        GlideApp.a(obj.getContext()).b(a.getUrl()).diskCacheStrategy(DiskCacheStrategy.a).override(linkPresentationModel, i).transition(DrawableTransitionOptions.b()).placeholder(m37328A()).listener(ImageProgressLoadListener.a(m37328A(), a.getUrl())).into(m37337z().getPreviewImage()).f();
    }

    protected final void mo6967b(boolean z) {
        m37336y().setShowLinkFlair(z);
    }

    protected final void mo6962a(int i) {
        m37335x().setTextColor(m37335x().getTextColors().withAlpha(i));
    }

    private final boolean m37330C() {
        boolean z;
        CharSequence charSequence = this.f36952F;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                z = false;
                return z;
            }
        }
        z = true;
        if (z) {
        }
    }

    public final void ap() {
        if (m37330C()) {
            if (!m37337z().m24388f()) {
                VideoPlayerOld z = m37337z();
                String str = this.f36952F;
                if (str == null) {
                    Intrinsics.m26842a();
                }
                z.m24382a(str);
            }
            CurrentPlayListener currentPlayListener = this.f36954b;
            if (currentPlayListener == null) {
                Intrinsics.m26844a("currentPlayListener");
            }
            if (!currentPlayListener.mo4992a()) {
                if (m37329B()) {
                    m37337z().m24389g();
                    currentPlayListener = this.f36954b;
                    if (currentPlayListener == null) {
                        Intrinsics.m26844a("currentPlayListener");
                    }
                    currentPlayListener.mo4991a(true);
                    return;
                }
                m37337z().m24390h();
                currentPlayListener = this.f36954b;
                if (currentPlayListener == null) {
                    Intrinsics.m26844a("currentPlayListener");
                }
                currentPlayListener.mo4991a(false);
            }
        }
    }

    public final void aq() {
        if (m37330C()) {
            CurrentPlayListener currentPlayListener = this.f36954b;
            if (currentPlayListener == null) {
                Intrinsics.m26844a("currentPlayListener");
            }
            currentPlayListener.mo4991a(false);
            m37337z().m24392j();
            m37337z().m24395m();
        }
    }
}
