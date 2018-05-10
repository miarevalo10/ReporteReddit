package com.reddit.frontpage.ui.detail.self;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.detail.FlexContainerDetailScreen;
import com.reddit.frontpage.ui.listing.adapter.ads.LegacyAdsNavigator;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Util;
import org.parceler.Parcels;
import timber.log.Timber;

public class SelfDetailScreen extends FlexContainerDetailScreen {
    private Point aa;

    public final int ag() {
        return 0;
    }

    public static SelfDetailScreen m42157a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new SelfDetailScreen(bundle2);
    }

    public SelfDetailScreen(Bundle bundle) {
        super(bundle);
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.aa = Util.m23955a(am_());
        super.mo7139a(layoutInflater, viewGroup);
        ButterKnife.a(this, this.K);
        this.f39167y.setVisibility(8);
        return this.K;
    }

    public final void mo7683a(int i) {
        if (m42158y() == null) {
            super.mo7683a(i);
            return;
        }
        this.collapsingToolbarLayout.setStatusBarScrimColor(i);
        this.collapsingToolbarLayout.setContentScrimColor(-1426063361 & i);
        this.toolbarImageView.setBackgroundColor(i);
    }

    public final View mo7682T() {
        ImageResolution y = m42158y();
        if (y == null) {
            return null;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f39167y.getContext()).inflate(C1761R.layout.detail_content_self, this.f39167y, false);
        if (this.toolbarImageView != null) {
            int i = this.aa.x;
            int i2 = this.aa.y;
            GlideApp.a(am_()).b(y.getUrl()).override(i, (int) Math.min((((float) i) / ((float) y.getWidth())) * ((float) y.getHeight()), ((float) i2) * ao_().getFraction(C1761R.fraction.max_self_image_height, 1, 1))).into(this.toolbarImageView);
            this.toolbarImageView.setOnClickListener(new SelfDetailScreen$$Lambda$0(this));
            this.toolbarDivider.setVisibility(8);
        }
        return linearLayout;
    }

    final /* synthetic */ void mo7684x() {
        String str = m39101W() ? "onboarding_post_detail" : "post_detail";
        if (LegacyAdsNavigator.m23458a(this.f39153F)) {
            LegacyAdsNavigator.m23457a(aq_(), this.f39153F, str);
        } else {
            am_().startActivity(IntentUtil.m23760b(am_(), this.f39153F, str));
        }
    }

    public final void mo7202a(int i, int i2, Intent intent) {
        super.mo7202a(i, i2, intent);
        if (i == x) {
            switch (i2) {
                case -1:
                    this.z.m23338a(this.f39153F);
                    return;
                case 0:
                    return;
                default:
                    Timber.b("Unrecognized result code %d in BaseDetailFragment", new Object[]{Integer.valueOf(i)});
                    break;
            }
        }
    }

    private ImageResolution m42158y() {
        LinkPreview preview = this.f39153F.getPreview();
        return preview != null ? preview.getSource() : null;
    }
}
