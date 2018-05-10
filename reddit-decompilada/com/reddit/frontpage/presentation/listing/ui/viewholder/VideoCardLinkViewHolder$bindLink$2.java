package com.reddit.frontpage.presentation.listing.ui.viewholder;

import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: VideoCardLinkViewHolder.kt */
final class VideoCardLinkViewHolder$bindLink$2 implements Runnable {
    final /* synthetic */ VideoCardLinkViewHolder f20849a;

    VideoCardLinkViewHolder$bindLink$2(VideoCardLinkViewHolder videoCardLinkViewHolder) {
        this.f20849a = videoCardLinkViewHolder;
    }

    public final void run() {
        this.f20849a.mo6968v().m23532j().m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_OVERFLOW);
    }
}
