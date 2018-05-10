package com.reddit.frontpage.ui.detail.video;

import android.view.View;
import android.view.ViewGroup;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.SaveMediaScreen_ViewBinding;
import com.reddit.frontpage.widgets.video.VideoPlayerOld;

public class VideoPlayerScreenLegacy_ViewBinding extends SaveMediaScreen_ViewBinding {
    private VideoPlayerScreenLegacy f34275b;

    public VideoPlayerScreenLegacy_ViewBinding(VideoPlayerScreenLegacy videoPlayerScreenLegacy, View view) {
        super(videoPlayerScreenLegacy, view);
        this.f34275b = videoPlayerScreenLegacy;
        videoPlayerScreenLegacy.videoLayout = (ViewGroup) Utils.b(view, C1761R.id.video_layout, "field 'videoLayout'", ViewGroup.class);
        videoPlayerScreenLegacy.videoPlayerOld = (VideoPlayerOld) Utils.b(view, C1761R.id.video_player, "field 'videoPlayerOld'", VideoPlayerOld.class);
    }

    public final void mo6499a() {
        VideoPlayerScreenLegacy videoPlayerScreenLegacy = this.f34275b;
        if (videoPlayerScreenLegacy == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34275b = null;
        videoPlayerScreenLegacy.videoLayout = null;
        videoPlayerScreenLegacy.videoPlayerOld = null;
        super.mo6499a();
    }
}
