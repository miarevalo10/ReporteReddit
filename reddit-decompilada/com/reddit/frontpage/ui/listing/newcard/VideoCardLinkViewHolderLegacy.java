package com.reddit.frontpage.ui.listing.newcard;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.BindView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.ui.listener.RemoteImageAttachStateListener;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkTitleView;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import timber.log.Timber;

public class VideoCardLinkViewHolderLegacy extends LinkViewHolder implements VisibilityDependent {
    private String f37307A;
    private final Rect f37308B = new Rect();
    @BindView
    LinkFlairView flairView;
    @BindView
    LinkTitleView titleView;
    public CurrentPlayListener f37309v;
    @BindView
    VideoPlayerOld videoPlayerOld;
    private int f37310w;
    private int f37311x;
    private int f37312y;
    private SnooProgressDrawable f37313z;

    public interface CurrentPlayListener {
        void mo4991a(boolean z);

        boolean mo4992a();
    }

    public static VideoCardLinkViewHolderLegacy m37664a(ViewGroup viewGroup) {
        return new VideoCardLinkViewHolderLegacy(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_video_card_link_old_legacy, viewGroup, false), null);
    }

    public static VideoCardLinkViewHolderLegacy m37665a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return new VideoCardLinkViewHolderLegacy(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_video_card_link_old_legacy, viewGroup, false), consumer);
    }

    private VideoCardLinkViewHolderLegacy(View view, final Consumer<Integer> consumer) {
        super(view);
        Context d = Util.m24014d(view.getContext());
        this.f37310w = view.getContext().getResources().getDimensionPixelSize(C1761R.dimen.link_image_min_height);
        this.f37311x = d.getWindow().getDecorView().getWidth();
        this.f37312y = d.getWindow().getDecorView().getHeight();
        this.videoPlayerOld.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoCardLinkViewHolderLegacy f21380b;

            public void onClick(View view) {
                if (this.f21380b.p != null) {
                    if (consumer != null) {
                        consumer.mo4813a(Integer.valueOf(this.f21380b.d()));
                    }
                    this.f21380b.p.mo4993a(this.f21380b.s);
                    this.f21380b.videoPlayerOld.m24392j();
                }
            }
        });
        this.videoPlayerOld.addOnAttachStateChangeListener(new RemoteImageAttachStateListener(this, this.videoPlayerOld.getPreviewImage()) {
            final /* synthetic */ VideoCardLinkViewHolderLegacy f29142a;

            public void onViewAttachedToWindow(View view) {
                this.f29142a.mo7002a(this.f29142a.s);
            }
        });
        this.f37313z = new SnooProgressDrawable(2, d);
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.titleView.mo7025a(link);
        this.flairView.m23474a(link);
        Point point = new Point(this.f37311x, this.f37312y);
        ImageResolution a = LinkUtil.m23775a(link, FrontpageSettings.a().g(), point);
        if (a == null) {
            this.videoPlayerOld.setVisibility(8);
            return;
        }
        int i;
        int i2;
        this.f37307A = Util.m23963a(link, point);
        Timber.b("VideoCardLinkViewHolderLegacy: extracted mp4 url [%s] %s", new Object[]{link.getTitle(), this.f37307A});
        float height = (float) a.getHeight();
        float width = (float) a.getWidth();
        if (height >= width) {
            i = this.f37311x;
            i2 = (int) ((((float) i) / height) * width);
        } else {
            i = (int) Math.max((float) this.f37310w, (((float) this.f37311x) / width) * height);
            i2 = this.f37311x;
        }
        this.videoPlayerOld.getLayoutParams().height = i;
        this.videoPlayerOld.getLayoutParams().width = i2;
        if (m37666x()) {
            this.videoPlayerOld.m24384a(this.f37307A, m37667y(), false, link);
        } else {
            this.videoPlayerOld.m24392j();
        }
        this.c.requestLayout();
        GlideApp.a(this.c.getContext()).b(a.getUrl()).diskCacheStrategy(DiskCacheStrategy.a).override(i2, i).placeholder(this.f37313z).transition(DrawableTransitionOptions.b()).listener(ImageProgressLoadListener.a(this.f37313z, a.getUrl())).into(this.videoPlayerOld.getPreviewImage()).f();
    }

    protected final void mo7003b(boolean z) {
        this.flairView.setShowLinkFlair(z);
    }

    protected final void mo7001a(int i) {
        this.titleView.setTextColor(this.titleView.getTextColors().withAlpha(i));
    }

    private boolean m37666x() {
        return !TextUtils.isEmpty(this.f37307A);
    }

    private boolean m37667y() {
        this.videoPlayerOld.getLocalVisibleRect(this.f37308B);
        if (this.f37308B.top > this.videoPlayerOld.getHeight()) {
            return false;
        }
        Timber.b("[%s]: Percent visible: [%f]", new Object[]{this.s.getId(), Float.valueOf(((float) (this.f37308B.bottom - this.f37308B.top)) / ((float) this.videoPlayerOld.getHeight()))});
        if (((float) (this.f37308B.bottom - this.f37308B.top)) / ((float) this.videoPlayerOld.getHeight()) >= 0.8f) {
            return true;
        }
        return false;
    }

    public final void ap() {
        if (m37666x()) {
            if (!this.videoPlayerOld.m24388f()) {
                this.videoPlayerOld.m24383a(this.f37307A, true, false);
            }
            if (!this.f37309v.mo4992a()) {
                if (m37667y()) {
                    this.videoPlayerOld.m24389g();
                    this.f37309v.mo4991a(true);
                    return;
                }
                this.videoPlayerOld.m24390h();
                this.f37309v.mo4991a(false);
            }
        }
    }

    public final void aq() {
        if (m37666x()) {
            this.f37309v.mo4991a(false);
            this.videoPlayerOld.m24392j();
            this.videoPlayerOld.m24395m();
        }
    }
}
