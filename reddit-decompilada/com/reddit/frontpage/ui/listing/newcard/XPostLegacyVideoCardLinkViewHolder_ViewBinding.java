package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;

public class XPostLegacyVideoCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private XPostLegacyVideoCardLinkViewHolder f34398b;

    public XPostLegacyVideoCardLinkViewHolder_ViewBinding(XPostLegacyVideoCardLinkViewHolder xPostLegacyVideoCardLinkViewHolder, View view) {
        super(xPostLegacyVideoCardLinkViewHolder, view);
        this.f34398b = xPostLegacyVideoCardLinkViewHolder;
        xPostLegacyVideoCardLinkViewHolder.cardBodyView = (SmallCardBodyView) Utils.b(view, C1761R.id.link_card_body, "field 'cardBodyView'", SmallCardBodyView.class);
        xPostLegacyVideoCardLinkViewHolder.videoPlayerOld = (VideoPlayerOld) Utils.b(view, C1761R.id.video_player, "field 'videoPlayerOld'", VideoPlayerOld.class);
    }

    public final void mo6516a() {
        XPostLegacyVideoCardLinkViewHolder xPostLegacyVideoCardLinkViewHolder = this.f34398b;
        if (xPostLegacyVideoCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34398b = null;
        xPostLegacyVideoCardLinkViewHolder.cardBodyView = null;
        xPostLegacyVideoCardLinkViewHolder.videoPlayerOld = null;
        super.mo6516a();
    }
}
