package com.reddit.frontpage.ui.listing.newcard;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkTitleView;

public class ImageCardLinkViewHolder extends LinkViewHolder {
    @BindView
    TextView domainView;
    @BindView
    LinkFlairView flairView;
    @BindView
    ImageView previewView;
    @BindView
    LinkTitleView titleView;
    private final int f37295v;
    private final int f37296w;
    private SnooProgressDrawable f37297x;

    public static ImageCardLinkViewHolder m37622a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return new ImageCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_image_card_link_legacy, viewGroup, false), consumer);
    }

    private ImageCardLinkViewHolder(View view, Consumer<Integer> consumer) {
        super(view);
        view = Util.m24014d(view.getContext());
        this.f37295v = view.getWindow().getDecorView().getWidth();
        this.f37296w = view.getWindow().getDecorView().getHeight();
        this.previewView.setOnClickListener(new ImageCardLinkViewHolder$$Lambda$0(this, consumer));
        this.f37297x = new SnooProgressDrawable(view);
    }

    final /* synthetic */ void m37625a(Consumer consumer) {
        if (this.p != null) {
            if (consumer != null) {
                consumer.mo4813a(Integer.valueOf(d()));
            }
            this.p.mo4993a(this.s);
        }
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.titleView.mo7025a(link);
        this.flairView.m23474a(link);
        ImageResolution a = LinkUtil.m23775a(link, FrontpageSettings.a().g(), new Point(this.f37295v, this.f37296w));
        if (a == null) {
            this.previewView.setVisibility(8);
        } else {
            this.previewView.getLayoutParams().width = this.f37295v;
            this.previewView.getLayoutParams().height = (int) (((1.0f * ((float) this.f37295v)) * ((float) a.getHeight())) / ((float) a.getWidth()));
            this.previewView.setVisibility(0);
            GlideApp.a(this.c.getContext()).b(a.getUrl()).transition(DrawableTransitionOptions.b()).diskCacheStrategy(DiskCacheStrategy.a).listener(ImageProgressLoadListener.a(this.f37297x, a.getUrl())).placeholder(this.f37297x).into(this.previewView).g().f();
        }
        if (!link.isPromoted() || TextUtils.isEmpty(link.getDomain())) {
            this.domainView.setVisibility(8);
            return;
        }
        this.domainView.setVisibility(0);
        this.domainView.setText(link.getDomain());
    }

    protected final void mo7003b(boolean z) {
        this.flairView.setShowLinkFlair(z);
    }

    protected final void mo7001a(int i) {
        this.titleView.setTextColor(this.titleView.getTextColors().withAlpha(i));
    }
}
