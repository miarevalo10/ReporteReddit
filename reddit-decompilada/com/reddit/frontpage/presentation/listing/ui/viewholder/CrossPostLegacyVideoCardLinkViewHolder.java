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
import com.reddit.frontpage.presentation.listing.ui.view.SmallCardBodyView;
import com.reddit.frontpage.presentation.listing.util.Size;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.ui.listener.RemoteImageAttachStateListener;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u001f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0010H\u0014J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u0007H\u0014R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostLegacyVideoCardLinkViewHolder;", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/LinkViewHolder;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "itemView", "Landroid/view/View;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "(Landroid/view/View;Lcom/reddit/frontpage/ui/listener/Consumer;)V", "cardBodyView", "Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;", "getCardBodyView", "()Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;", "cardBodyView$delegate", "Lkotlin/Lazy;", "isVideoPlayerVisible", "", "()Z", "localBounds", "Landroid/graphics/Rect;", "minPreviewWidth", "mp4Url", "", "progressDrawable", "Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "getProgressDrawable", "()Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "progressDrawable$delegate", "screenHeight", "screenWidth", "videoPlayerOld", "Lcom/reddit/frontpage/widgets/video/VideoPlayerOld;", "getVideoPlayerOld", "()Lcom/reddit/frontpage/widgets/video/VideoPlayerOld;", "videoPlayerOld$delegate", "bindLink", "", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "hasVideo", "notifyOffScreen", "notifyOnScreen", "updateLinkFlairVisibility", "visible", "updateReadStatus", "alpha", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CrossPostLegacyVideoCardLinkViewHolder.kt */
public final class CrossPostLegacyVideoCardLinkViewHolder extends LinkViewHolder implements VisibilityDependent {
    private static final float f36889F = 0.8f;
    static final /* synthetic */ KProperty[] f36890a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostLegacyVideoCardLinkViewHolder.class), "cardBodyView", "getCardBodyView()Lcom/reddit/frontpage/presentation/listing/ui/view/SmallCardBodyView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostLegacyVideoCardLinkViewHolder.class), "videoPlayerOld", "getVideoPlayerOld()Lcom/reddit/frontpage/widgets/video/VideoPlayerOld;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(CrossPostLegacyVideoCardLinkViewHolder.class), "progressDrawable", "getProgressDrawable()Lcom/reddit/frontpage/animation/SnooProgressDrawable;"))};
    public static final Companion f36891b = new Companion();
    private final int f36892A;
    private final int f36893B;
    private final Lazy f36894C;
    private String f36895D;
    private final Rect f36896E;
    private final Lazy f36897x;
    private final Lazy f36898y;
    private final int f36899z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostLegacyVideoCardLinkViewHolder$Companion;", "", "()V", "PERCENTAGE_AREA_EXPOSED_BEFORE_AUTOPLAY", "", "getPERCENTAGE_AREA_EXPOSED_BEFORE_AUTOPLAY", "()F", "create", "Lcom/reddit/frontpage/presentation/listing/ui/viewholder/CrossPostLegacyVideoCardLinkViewHolder;", "parent", "Landroid/view/ViewGroup;", "lastClickPositionListener", "Lcom/reddit/frontpage/ui/listener/Consumer;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CrossPostLegacyVideoCardLinkViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static CrossPostLegacyVideoCardLinkViewHolder m23048a(ViewGroup viewGroup, Consumer<Integer> consumer) {
            Intrinsics.m26847b(viewGroup, "parent");
            Intrinsics.m26847b(consumer, "lastClickPositionListener");
            return new CrossPostLegacyVideoCardLinkViewHolder(ViewGroupsKt.m24100a(viewGroup, C1761R.layout.item_cross_post_legacy_video_card, false), consumer);
        }
    }

    public static final CrossPostLegacyVideoCardLinkViewHolder m37277a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return Companion.m23048a(viewGroup, consumer);
    }

    private final SmallCardBodyView m37280x() {
        return (SmallCardBodyView) this.f36897x.mo5678b();
    }

    private final VideoPlayerOld m37281y() {
        return (VideoPlayerOld) this.f36898y.mo5678b();
    }

    private final SnooProgressDrawable m37282z() {
        return (SnooProgressDrawable) this.f36894C.mo5678b();
    }

    private CrossPostLegacyVideoCardLinkViewHolder(View view, final Consumer<Integer> consumer) {
        super(view);
        this.f36897x = LazyKt.m26777a(new CrossPostLegacyVideoCardLinkViewHolder$cardBodyView$2(view));
        this.f36898y = LazyKt.m26777a(new CrossPostLegacyVideoCardLinkViewHolder$videoPlayerOld$2(view));
        this.f36894C = LazyKt.m26777a(new CrossPostLegacyVideoCardLinkViewHolder$progressDrawable$2(view));
        this.f36896E = new Rect();
        Object d = Util.m24014d(view.getContext());
        Object context = view.getContext();
        Intrinsics.m26843a(context, "itemView.context");
        this.f36899z = context.getResources().getDimensionPixelSize(C1761R.dimen.link_image_min_height);
        Intrinsics.m26843a(d, "context");
        context = d.getWindow();
        Intrinsics.m26843a(context, "context.window");
        context = context.getDecorView();
        Intrinsics.m26843a(context, "context.window.decorView");
        this.f36892A = context.getWidth();
        context = d.getWindow();
        Intrinsics.m26843a(context, "context.window");
        context = context.getDecorView();
        Intrinsics.m26843a(context, "context.window.decorView");
        this.f36893B = context.getHeight();
        m37281y().setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                view = this.m34773O().am;
                if (view == null) {
                    Intrinsics.m26842a();
                }
                OnViewMediaListener onViewMediaListener = this.f34045r;
                if (onViewMediaListener != null) {
                    Consumer consumer = consumer;
                    if (consumer != null) {
                        consumer.mo4813a(Integer.valueOf(this.d()));
                    }
                    onViewMediaListener.mo4828a(view);
                    this.m37281y().m24392j();
                }
            }
        });
        m37280x().setCrossPostPreviewOnClickListener((OnClickListener) new OnClickListener() {
            public final void onClick(View view) {
                view = this.m34773O().am;
                if (view == null) {
                    Intrinsics.m26842a();
                }
                OnViewMediaListener onViewMediaListener = this.f34045r;
                if (onViewMediaListener != null) {
                    onViewMediaListener.mo4828a(view);
                }
            }
        });
        m37280x().setCrossPostEmbedOnClickListener((OnClickListener) new OnClickListener() {
            public final void onClick(View view) {
                view = this.m34773O().am;
                if (view == null) {
                    Intrinsics.m26842a();
                }
                OnViewMediaListener onViewMediaListener = this.f34045r;
                if (onViewMediaListener != null) {
                    onViewMediaListener.mo4830c(view);
                }
            }
        });
        view = m37281y();
        d = m37281y().getPreviewImage();
        Intrinsics.m26843a(d, "videoPlayerOld.previewImage");
        view.addOnAttachStateChangeListener((OnAttachStateChangeListener) new RemoteImageAttachStateListener(d) {
            public final void onViewAttachedToWindow(View view) {
                Intrinsics.m26847b(view, "v");
                this.mo6963a(this.m34773O());
            }
        });
    }

    private final boolean m37275A() {
        m37281y().getLocalVisibleRect(this.f36896E);
        if (this.f36896E.top >= 0) {
            if (this.f36896E.top <= m37281y().getHeight()) {
                Timber.b("[%s]: Percent visible: [%f]", new Object[]{m34773O().f33977d, Float.valueOf(((float) (this.f36896E.bottom - this.f36896E.top)) / ((float) m37281y().getHeight()))});
                if (((float) (this.f36896E.bottom - this.f36896E.top)) / ((float) m37281y().getHeight()) >= f36889F) {
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
        m37280x().m23043a(linkPresentationModel);
        Size size = new Size(this.f36892A, this.f36893B);
        ImageLinkPreviewPresentationModel imageLinkPreviewPresentationModel = linkPresentationModel.f33954G;
        String str = null;
        ImageResolution a = imageLinkPreviewPresentationModel != null ? imageLinkPreviewPresentationModel.m29675a(size) : null;
        if (a == null) {
            ViewsKt.m24109d(m37281y());
            return;
        }
        int i;
        linkPresentationModel = linkPresentationModel.f33955H;
        if (linkPresentationModel != null) {
            str = linkPresentationModel.m29676a(size);
        }
        this.f36895D = str;
        linkPresentationModel = (float) a.getHeight();
        float width = (float) a.getWidth();
        if (linkPresentationModel >= width) {
            i = this.f36892A;
            linkPresentationModel = (int) ((((float) i) / linkPresentationModel) * width);
        } else {
            i = (int) Math.max((float) this.f36899z, (((float) this.f36892A) / width) * linkPresentationModel);
            linkPresentationModel = this.f36892A;
        }
        LayoutParams layoutParams = m37281y().getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = linkPresentationModel;
        if (m37276B()) {
            boolean A = m37275A();
            VideoPlayerOld y = m37281y();
            String str2 = this.f36895D;
            if (str2 == null) {
                Intrinsics.m26842a();
            }
            y.m24383a(str2, A, false);
        } else {
            m37281y().m24392j();
        }
        this.c.requestLayout();
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        GlideApp.a(obj.getContext()).b(a.getUrl()).diskCacheStrategy(DiskCacheStrategy.a).override(linkPresentationModel, i).transition(DrawableTransitionOptions.b()).placeholder(m37282z()).listener(ImageProgressLoadListener.a(m37282z(), a.getUrl())).into(m37281y().getPreviewImage()).f();
    }

    protected final void mo6962a(int i) {
        m37280x().setTitleAlpha(i);
    }

    protected final void mo6967b(boolean z) {
        m37280x().setShowLinkFlair(z);
    }

    private final boolean m37276B() {
        boolean z;
        CharSequence charSequence = this.f36895D;
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
        if (m37276B()) {
            if (!m37281y().m24388f()) {
                VideoPlayerOld y = m37281y();
                String str = this.f36895D;
                if (str == null) {
                    Intrinsics.m26842a();
                }
                y.m24382a(str);
            }
            if (m37275A()) {
                m37281y().m24389g();
            } else {
                m37281y().m24390h();
            }
        }
    }

    public final void aq() {
        if (m37276B()) {
            m37281y().m24392j();
            m37281y().m24395m();
        }
    }
}
