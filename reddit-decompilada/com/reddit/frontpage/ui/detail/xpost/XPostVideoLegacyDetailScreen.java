package com.reddit.frontpage.ui.detail.xpost;

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
import com.reddit.frontpage.ui.listing.newcard.XpostImageCardBodyView;
import com.reddit.frontpage.util.CrosspostUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;
import org.parceler.Parcels;
import timber.log.Timber;

public class XPostVideoLegacyDetailScreen extends XPostDetailScreen {
    private VideoPlayerOld aa;
    private String ab;
    private boolean ac;
    private int ad = null;

    public static XPostVideoLegacyDetailScreen m42501a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new XPostVideoLegacyDetailScreen(bundle2);
    }

    public XPostVideoLegacyDetailScreen(Bundle bundle) {
        super(bundle);
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.detailList.getRecycledViewPool().a();
        return this.K;
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        if (this.ac != null) {
            this.aa.m24393k();
        }
    }

    protected final void mo6993c(View view) {
        super.mo6993c(view);
        this.aa.m24394l();
    }

    final /* synthetic */ void m42505a(Link link) {
        IntentUtil.m23757a(am_(), link, m39101W() ? "onboarding_post_detail" : "post_detail");
    }

    public final int ag() {
        return this.ad;
    }

    protected final void mo7691P() {
        super.mo7691P();
        if (this.aa != null) {
            if (m39095Q()) {
                if (this.ac && !this.aa.m24391i()) {
                    Timber.b("Scrolled back and playing %s", new Object[]{this.ab});
                    this.aa.m24393k();
                }
            } else if (this.aa.m24391i()) {
                Timber.b("Scrolled away and stopping %s", new Object[]{this.ab});
                this.aa.m24394l();
            }
        }
    }

    public final void mo7690f(boolean z) {
        if (this.aa != null) {
            this.ac = z;
            if (z) {
                this.aa.setVisibility(0);
                this.aa.m24393k();
                return;
            }
            this.aa.m24394l();
        }
    }

    public final View mo7682T() {
        XpostImageCardBodyView xpostImageCardBodyView = (XpostImageCardBodyView) LayoutInflater.from(this.f39167y.getContext()).inflate(C1761R.layout.xpost_video_legacy_bordered, this.f39167y, false);
        Link b = Util.m23994b(this.f39153F);
        if (b == null) {
            return xpostImageCardBodyView;
        }
        xpostImageCardBodyView.m23495a(b);
        int a = CrosspostUtil.m23675a();
        this.aa = (VideoPlayerOld) xpostImageCardBodyView.findViewById(C1761R.id.video_player);
        Point a2 = Util.m23955a(am_());
        ImageResolution a3 = LinkUtil.m23775a(b, FrontpageSettings.a().g(), a2);
        if (a3 == null) {
            return xpostImageCardBodyView;
        }
        a3.getHeight();
        a3.getWidth();
        this.aa.getLayoutParams().height = CrosspostUtil.m23677b(a3, a);
        Drawable snooProgressDrawable = new SnooProgressDrawable(xpostImageCardBodyView.getContext());
        GlideApp.a(am_()).b(a3.getUrl()).placeholder(snooProgressDrawable).listener(ImageProgressLoadListener.a(snooProgressDrawable, a3.getUrl())).into(this.aa.getPreviewImage());
        this.ab = Util.m23963a(b, a2);
        this.aa.m24384a(this.ab, false, false, this.f39153F);
        this.ad = XPostDetailScreen.m42217a(xpostImageCardBodyView, a);
        xpostImageCardBodyView.setOnClickListener(new XPostVideoLegacyDetailScreen$$Lambda$0(this, b));
        this.aa.setOnClickListener(new XPostVideoLegacyDetailScreen$$Lambda$1(this, b));
        return xpostImageCardBodyView;
    }
}
