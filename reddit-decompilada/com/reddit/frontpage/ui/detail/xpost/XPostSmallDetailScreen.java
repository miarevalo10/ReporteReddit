package com.reddit.frontpage.ui.detail.xpost;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listing.newcard.XpostSmallCardBodyView;
import com.reddit.frontpage.util.CrosspostUtil;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Util;
import org.parceler.Parcels;

public class XPostSmallDetailScreen extends XPostDetailScreen {
    private int aa = null;

    public static XPostSmallDetailScreen m42484a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new XPostSmallDetailScreen(bundle2);
    }

    public XPostSmallDetailScreen(Bundle bundle) {
        super(bundle);
    }

    final /* synthetic */ void m42486a(Link link) {
        int linkType = link.getLinkType();
        String str = m39101W() ? "onboarding_post_detail" : "post_detail";
        if (linkType != 4) {
            if (linkType != 3) {
                if (linkType == 1) {
                    String str2;
                    if (link.getSubredditDetail() != null) {
                        str2 = link.getSubredditDetail().key_color;
                    } else {
                        str2 = null;
                    }
                    Util.m23967a(Util.m24014d(am_()), Uri.parse(link.getUrl()), Util.m23951a(am_(), str2), link.getName(), str);
                }
                return;
            }
        }
        LinkPreview preview = link.getPreview();
        if (!(preview == null || preview.getSource() == null)) {
            a(IntentUtil.m23760b(am_(), link, str));
        }
    }

    public final int ag() {
        return this.aa;
    }

    public final View mo7682T() {
        XpostSmallCardBodyView xpostSmallCardBodyView = (XpostSmallCardBodyView) LayoutInflater.from(this.f39167y.getContext()).inflate(C1761R.layout.xpost_small_bordered, this.f39167y, false);
        Link b = Util.m23994b(this.f39153F);
        if (b == null) {
            return xpostSmallCardBodyView;
        }
        xpostSmallCardBodyView.m23497a(b);
        this.aa = XPostDetailScreen.m42217a(xpostSmallCardBodyView, CrosspostUtil.m23675a());
        xpostSmallCardBodyView.setOnClickListener(new XPostSmallDetailScreen$$Lambda$0(this, b));
        xpostSmallCardBodyView.setPreviewOnClickListener(new XPostSmallDetailScreen$$Lambda$1(this, b));
        return xpostSmallCardBodyView;
    }
}
