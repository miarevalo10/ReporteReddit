package com.reddit.frontpage.widgets.video;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.reddit.frontpage.C1761R;

public class VideoPlayerOld_ViewBinding implements Unbinder {
    private VideoPlayerOld f29560b;

    public VideoPlayerOld_ViewBinding(VideoPlayerOld videoPlayerOld, View view) {
        this.f29560b = videoPlayerOld;
        videoPlayerOld.videoFrame = (AspectRatioFrameLayout) Utils.b(view, C1761R.id.video_frame, "field 'videoFrame'", AspectRatioFrameLayout.class);
        videoPlayerOld.shutter = Utils.a(view, C1761R.id.shutter, "field 'shutter'");
        videoPlayerOld.previewImage = (ImageView) Utils.b(view, C1761R.id.video_preview_image, "field 'previewImage'", ImageView.class);
        videoPlayerOld.playIcon = Utils.a(view, C1761R.id.video_play_icon, "field 'playIcon'");
        videoPlayerOld.spinner = Utils.a(view, C1761R.id.video_progress_spinner, "field 'spinner'");
    }

    public void mo6543a() {
        VideoPlayerOld videoPlayerOld = this.f29560b;
        if (videoPlayerOld == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29560b = null;
        videoPlayerOld.videoFrame = null;
        videoPlayerOld.shutter = null;
        videoPlayerOld.previewImage = null;
        videoPlayerOld.playIcon = null;
        videoPlayerOld.spinner = null;
    }
}
