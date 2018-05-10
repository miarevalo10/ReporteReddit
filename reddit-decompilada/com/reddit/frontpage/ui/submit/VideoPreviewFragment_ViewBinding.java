package com.reddit.frontpage.ui.submit;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.video.ClippingBarView;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;

public class VideoPreviewFragment_ViewBinding implements Unbinder {
    private VideoPreviewFragment f29343b;

    public VideoPreviewFragment_ViewBinding(VideoPreviewFragment videoPreviewFragment, View view) {
        this.f29343b = videoPreviewFragment;
        videoPreviewFragment.videoLayout = (ViewGroup) Utils.b(view, C1761R.id.video_layout, "field 'videoLayout'", ViewGroup.class);
        videoPreviewFragment.gifSwitch = (SwitchCompat) Utils.b(view, C1761R.id.gif_switch, "field 'gifSwitch'", SwitchCompat.class);
        videoPreviewFragment.simpleExoPlayerView = (SimpleExoPlayerView) Utils.b(view, C1761R.id.video_player, "field 'simpleExoPlayerView'", SimpleExoPlayerView.class);
        videoPreviewFragment.clippingBarView = (ClippingBarView) Utils.b(view, C1761R.id.clipping_view, "field 'clippingBarView'", ClippingBarView.class);
    }

    public final void m30402a() {
        VideoPreviewFragment videoPreviewFragment = this.f29343b;
        if (videoPreviewFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29343b = null;
        videoPreviewFragment.videoLayout = null;
        videoPreviewFragment.gifSwitch = null;
        videoPreviewFragment.simpleExoPlayerView = null;
        videoPreviewFragment.clippingBarView = null;
    }
}
