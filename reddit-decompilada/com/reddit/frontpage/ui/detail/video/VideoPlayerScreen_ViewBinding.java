package com.reddit.frontpage.ui.detail.video;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.SaveMediaScreen_ViewBinding;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;

public class VideoPlayerScreen_ViewBinding extends SaveMediaScreen_ViewBinding {
    private VideoPlayerScreen f34276b;

    public VideoPlayerScreen_ViewBinding(VideoPlayerScreen videoPlayerScreen, View view) {
        super(videoPlayerScreen, view);
        this.f34276b = videoPlayerScreen;
        videoPlayerScreen.videoLayout = (ViewGroup) Utils.b(view, C1761R.id.video_layout, "field 'videoLayout'", ViewGroup.class);
        videoPlayerScreen.simpleExoPlayerView = (SimpleExoPlayerView) Utils.b(view, C1761R.id.video_player, "field 'simpleExoPlayerView'", SimpleExoPlayerView.class);
        videoPlayerScreen.toolbar = (Toolbar) Utils.b(view, C1761R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    public final void mo6499a() {
        VideoPlayerScreen videoPlayerScreen = this.f34276b;
        if (videoPlayerScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34276b = null;
        videoPlayerScreen.videoLayout = null;
        videoPlayerScreen.simpleExoPlayerView = null;
        videoPlayerScreen.toolbar = null;
        super.mo6499a();
    }
}
