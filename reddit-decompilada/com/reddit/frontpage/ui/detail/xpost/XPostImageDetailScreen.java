package com.reddit.frontpage.ui.detail.xpost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listing.newcard.XpostImageCardBodyView;
import com.reddit.frontpage.util.CrosspostUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Util;
import org.parceler.Parcels;

public class XPostImageDetailScreen extends XPostDetailScreen {
    private int aa = null;

    public static XPostImageDetailScreen m42481a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new XPostImageDetailScreen(bundle2);
    }

    public XPostImageDetailScreen(Bundle bundle) {
        super(bundle);
    }

    final /* synthetic */ void m42483a(Link link) {
        a(IntentUtil.m23760b(am_(), link, m39101W() ? "onboarding_post_detail" : "post_detail"));
    }

    public final int ag() {
        return this.aa;
    }

    public final View mo7682T() {
        XpostImageCardBodyView xpostImageCardBodyView = (XpostImageCardBodyView) LayoutInflater.from(this.f39167y.getContext()).inflate(C1761R.layout.xpost_image_bordered, this.f39167y, false);
        Link b = Util.m23994b(this.f39153F);
        if (b == null) {
            return xpostImageCardBodyView;
        }
        xpostImageCardBodyView.m23495a(b);
        this.aa = XPostDetailScreen.m42217a(xpostImageCardBodyView, CrosspostUtil.m23675a());
        xpostImageCardBodyView.setOnClickListener(new XPostImageDetailScreen$$Lambda$0(this, b));
        xpostImageCardBodyView.setPreviewOnClickListener(new XPostImageDetailScreen$$Lambda$1(this, b));
        return xpostImageCardBodyView;
    }
}
