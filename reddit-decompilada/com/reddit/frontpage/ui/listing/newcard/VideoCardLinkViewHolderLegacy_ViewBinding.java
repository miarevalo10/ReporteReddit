package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.LinkTitleView;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;

public class VideoCardLinkViewHolderLegacy_ViewBinding extends LinkViewHolder_ViewBinding {
    private VideoCardLinkViewHolderLegacy f34394b;

    public VideoCardLinkViewHolderLegacy_ViewBinding(VideoCardLinkViewHolderLegacy videoCardLinkViewHolderLegacy, View view) {
        super(videoCardLinkViewHolderLegacy, view);
        this.f34394b = videoCardLinkViewHolderLegacy;
        videoCardLinkViewHolderLegacy.titleView = (LinkTitleView) Utils.b(view, C1761R.id.link_title, "field 'titleView'", LinkTitleView.class);
        videoCardLinkViewHolderLegacy.flairView = (LinkFlairView) Utils.b(view, C1761R.id.link_flair, "field 'flairView'", LinkFlairView.class);
        videoCardLinkViewHolderLegacy.videoPlayerOld = (VideoPlayerOld) Utils.b(view, C1761R.id.video_player, "field 'videoPlayerOld'", VideoPlayerOld.class);
    }

    public final void mo6516a() {
        VideoCardLinkViewHolderLegacy videoCardLinkViewHolderLegacy = this.f34394b;
        if (videoCardLinkViewHolderLegacy == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34394b = null;
        videoCardLinkViewHolderLegacy.titleView = null;
        videoCardLinkViewHolderLegacy.flairView = null;
        videoCardLinkViewHolderLegacy.videoPlayerOld = null;
        super.mo6516a();
    }
}
