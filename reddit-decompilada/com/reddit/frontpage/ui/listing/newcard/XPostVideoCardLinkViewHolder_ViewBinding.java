package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;

public class XPostVideoCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private XPostVideoCardLinkViewHolder f34400b;

    public XPostVideoCardLinkViewHolder_ViewBinding(XPostVideoCardLinkViewHolder xPostVideoCardLinkViewHolder, View view) {
        super(xPostVideoCardLinkViewHolder, view);
        this.f34400b = xPostVideoCardLinkViewHolder;
        xPostVideoCardLinkViewHolder.cardBodyView = (SmallCardBodyView) Utils.b(view, C1761R.id.link_card_body, "field 'cardBodyView'", SmallCardBodyView.class);
        xPostVideoCardLinkViewHolder.borderedView = (XpostImageCardBodyView) Utils.b(view, C1761R.id.xpost_large_card_body, "field 'borderedView'", XpostImageCardBodyView.class);
        xPostVideoCardLinkViewHolder.simpleExoPlayerView = (SimpleExoPlayerView) Utils.b(view, C1761R.id.video_player, "field 'simpleExoPlayerView'", SimpleExoPlayerView.class);
        xPostVideoCardLinkViewHolder.videoContainer = Utils.a(view, C1761R.id.video_container, "field 'videoContainer'");
    }

    public final void mo6516a() {
        XPostVideoCardLinkViewHolder xPostVideoCardLinkViewHolder = this.f34400b;
        if (xPostVideoCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34400b = null;
        xPostVideoCardLinkViewHolder.cardBodyView = null;
        xPostVideoCardLinkViewHolder.borderedView = null;
        xPostVideoCardLinkViewHolder.simpleExoPlayerView = null;
        xPostVideoCardLinkViewHolder.videoContainer = null;
        super.mo6516a();
    }
}
