package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.LinkTitleView;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;

public class VideoCardLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private VideoCardLinkViewHolder f34395b;

    public VideoCardLinkViewHolder_ViewBinding(VideoCardLinkViewHolder videoCardLinkViewHolder, View view) {
        super(videoCardLinkViewHolder, view);
        this.f34395b = videoCardLinkViewHolder;
        videoCardLinkViewHolder.titleView = (LinkTitleView) Utils.b(view, C1761R.id.link_title, "field 'titleView'", LinkTitleView.class);
        videoCardLinkViewHolder.flairView = (LinkFlairView) Utils.b(view, C1761R.id.link_flair, "field 'flairView'", LinkFlairView.class);
        videoCardLinkViewHolder.simpleExoPlayerView = (SimpleExoPlayerView) Utils.b(view, C1761R.id.video_player, "field 'simpleExoPlayerView'", SimpleExoPlayerView.class);
        videoCardLinkViewHolder.videoContainer = Utils.a(view, C1761R.id.video_container, "field 'videoContainer'");
    }

    public final void mo6516a() {
        VideoCardLinkViewHolder videoCardLinkViewHolder = this.f34395b;
        if (videoCardLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34395b = null;
        videoCardLinkViewHolder.titleView = null;
        videoCardLinkViewHolder.flairView = null;
        videoCardLinkViewHolder.simpleExoPlayerView = null;
        videoCardLinkViewHolder.videoContainer = null;
        super.mo6516a();
    }
}
