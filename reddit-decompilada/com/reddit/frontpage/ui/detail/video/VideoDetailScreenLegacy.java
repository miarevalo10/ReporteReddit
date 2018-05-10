package com.reddit.frontpage.ui.detail.video;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.ui.detail.FlexContainerDetailScreen;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import org.parceler.Parcels;
import timber.log.Timber;

public class VideoDetailScreenLegacy extends FlexContainerDetailScreen {
    VideoPlayerOld aa;
    private Link ab;
    private String ac;
    private boolean ad;

    public static VideoDetailScreenLegacy m42203a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new VideoDetailScreenLegacy(bundle2);
    }

    public VideoDetailScreenLegacy(Bundle bundle) {
        super(bundle);
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.detailList.getRecycledViewPool().a();
        return this.K;
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        if (this.ad != null) {
            this.aa.m24384a(this.ac, true, false, this.ab);
        }
    }

    protected final void mo7209b(Activity activity) {
        super.mo7209b(activity);
        if (this.aa != null) {
            this.aa.m24393k();
        }
    }

    protected final void mo6993c(View view) {
        super.mo6993c(view);
        this.aa.m24392j();
    }

    final /* synthetic */ void mo7684x() {
        IntentUtil.m23757a(am_(), this.ab, m39101W() ? "onboarding_post_detail" : "post_detail");
    }

    protected final void mo7691P() {
        super.mo7691P();
        if (m39095Q()) {
            if (this.ad && !this.aa.m24391i()) {
                Timber.b("Scrolled back and playing %s", new Object[]{this.ac});
                this.aa.m24393k();
            }
        } else if (this.aa.m24391i()) {
            Timber.b("Scrolled away and stopping %s", new Object[]{this.ac});
            this.aa.m24394l();
        }
    }

    public final void mo7690f(boolean z) {
        if (this.aa != null) {
            this.ad = z;
            if (z) {
                this.aa.setVisibility(0);
                this.aa.m24393k();
                return;
            }
            this.aa.m24394l();
        }
    }

    public final View mo7682T() {
        View inflate = LayoutInflater.from(this.f39167y.getContext()).inflate(C1761R.layout.detail_content_video_legacy, this.f39167y, false);
        this.aa = (VideoPlayerOld) inflate.findViewById(C1761R.id.video_player);
        this.ab = this.f39153F;
        Point a = Util.m23955a(am_());
        ImageResolution a2 = LinkUtil.m23775a(this.ab, FrontpageSettings.a().g(), a);
        if (a2 != null) {
            Drawable snooProgressDrawable = new SnooProgressDrawable(inflate.getContext());
            GlideApp.a(am_()).b(a2.getUrl()).placeholder(snooProgressDrawable).listener(ImageProgressLoadListener.a(snooProgressDrawable, a2.getUrl())).into(this.aa.getPreviewImage());
        }
        this.ac = Util.m23963a(this.ab, a);
        this.aa.setOnClickListener(new VideoDetailScreenLegacy$$Lambda$0(this));
        this.aa.m24384a(this.ac, Util.m24028f(this.ab), false, this.ab);
        return inflate;
    }

    public final int ag() {
        if (this.f39153F.getPreview() == null) {
            return 0;
        }
        ImageResolution source = this.f39153F.getPreview().getSource();
        return ((int) ((((float) am_().getWindow().getDecorView().getWidth()) * ((float) source.getHeight())) / ((float) source.getWidth()))) + 1;
    }
}
