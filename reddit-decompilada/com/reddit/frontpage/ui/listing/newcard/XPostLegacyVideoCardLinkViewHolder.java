package com.reddit.frontpage.ui.listing.newcard;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
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
import com.reddit.frontpage.util.CrosspostUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import timber.log.Timber;

public class XPostLegacyVideoCardLinkViewHolder extends LinkViewHolder implements VisibilityDependent {
    private final Rect f37314A = new Rect();
    @BindView
    SmallCardBodyView cardBodyView;
    private final int f37315v;
    @BindView
    VideoPlayerOld videoPlayerOld;
    private final int f37316w;
    private final int f37317x;
    private final SnooProgressDrawable f37318y;
    private String f37319z;

    public static XPostLegacyVideoCardLinkViewHolder m37686a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return new XPostLegacyVideoCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_xpost_legacy_video_card_legacy, viewGroup, false), consumer);
    }

    private XPostLegacyVideoCardLinkViewHolder(View view, Consumer<Integer> consumer) {
        super(view);
        Context d = Util.m24014d(view.getContext());
        this.f37315v = view.getContext().getResources().getDimensionPixelSize(C1761R.dimen.link_image_min_height);
        this.f37316w = d.getWindow().getDecorView().getWidth();
        this.f37317x = d.getWindow().getDecorView().getHeight();
        this.videoPlayerOld.setOnClickListener(new XPostLegacyVideoCardLinkViewHolder$$Lambda$0(this, consumer));
        this.cardBodyView.setXpostPreviewOnClickListener(new XPostLegacyVideoCardLinkViewHolder$$Lambda$1(this));
        this.cardBodyView.setXpostEmbedOnClickListener(new XPostLegacyVideoCardLinkViewHolder$$Lambda$2(this));
        this.videoPlayerOld.addOnAttachStateChangeListener(new RemoteImageAttachStateListener(this, this.videoPlayerOld.getPreviewImage()) {
            final /* synthetic */ XPostLegacyVideoCardLinkViewHolder f29143a;

            public void onViewAttachedToWindow(View view) {
                this.f29143a.mo7002a(this.f29143a.s);
            }
        });
        this.f37318y = new SnooProgressDrawable(2, d);
    }

    final /* synthetic */ void m37690a(Consumer consumer) {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            if (consumer != null) {
                consumer.mo4813a(Integer.valueOf(d()));
            }
            this.p.mo4993a(b);
            this.videoPlayerOld.m24392j();
        }
    }

    final /* synthetic */ void m37693y() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.p.mo4993a(b);
        }
    }

    final /* synthetic */ void m37692x() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.p.mo4995c(b);
        }
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.cardBodyView.m23486a(link);
        Link b = Util.m23994b(link);
        Point point = new Point(this.f37316w, this.f37317x);
        ImageResolution a = LinkUtil.m23775a(b, FrontpageSettings.a().g(), point);
        if (a == null) {
            this.videoPlayerOld.setVisibility(8);
            return;
        }
        int i;
        this.f37319z = Util.m23963a(b, point);
        int a2 = CrosspostUtil.m23675a();
        float height = (float) a.getHeight();
        float width = (float) a.getWidth();
        if (height >= width) {
            i = (int) ((((float) a2) * width) / height);
        } else {
            int max = (int) Math.max((float) this.f37315v, (((float) a2) * height) / width);
            i = a2;
            a2 = max;
        }
        this.videoPlayerOld.getLayoutParams().height = a2;
        this.videoPlayerOld.getLayoutParams().width = i;
        if (m37687z()) {
            this.videoPlayerOld.m24384a(this.f37319z, m37685A(), false, link);
        } else {
            this.videoPlayerOld.m24392j();
        }
        this.c.requestLayout();
        GlideApp.a(this.c.getContext()).b(a.getUrl()).diskCacheStrategy(DiskCacheStrategy.a).override(i, a2).transition(DrawableTransitionOptions.b()).placeholder(this.f37318y).listener(ImageProgressLoadListener.a(this.f37318y, a.getUrl())).into(this.videoPlayerOld.getPreviewImage()).f();
    }

    protected final void mo7001a(int i) {
        this.cardBodyView.setTitleAlpha(i);
    }

    protected final void mo7003b(boolean z) {
        this.cardBodyView.setShowLinkFlair(z);
    }

    private boolean m37687z() {
        return !TextUtils.isEmpty(this.f37319z);
    }

    private boolean m37685A() {
        this.videoPlayerOld.getLocalVisibleRect(this.f37314A);
        if (this.f37314A.top >= 0) {
            if (this.f37314A.top <= this.videoPlayerOld.getHeight()) {
                Timber.b("[%s]: Percent visible: [%f]", new Object[]{this.s.getId(), Float.valueOf(((float) (this.f37314A.bottom - this.f37314A.top)) / ((float) this.videoPlayerOld.getHeight()))});
                if (((float) (this.f37314A.bottom - this.f37314A.top)) / ((float) this.videoPlayerOld.getHeight()) >= 0.8f) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final void ap() {
        if (m37687z()) {
            if (!this.videoPlayerOld.m24388f()) {
                this.videoPlayerOld.m24383a(this.f37319z, true, false);
            }
            if (m37685A()) {
                this.videoPlayerOld.m24389g();
            } else {
                this.videoPlayerOld.m24390h();
            }
        }
    }

    public final void aq() {
        if (m37687z()) {
            this.videoPlayerOld.m24392j();
            this.videoPlayerOld.m24395m();
        }
    }
}
