package com.reddit.frontpage.ui.submit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView;

public class MediaSubmitScreen_ViewBinding implements Unbinder {
    private MediaSubmitScreen f29326b;

    public MediaSubmitScreen_ViewBinding(MediaSubmitScreen mediaSubmitScreen, View view) {
        this.f29326b = mediaSubmitScreen;
        mediaSubmitScreen.mediaRoot = (ViewGroup) Utils.b(view, C1761R.id.media_root, "field 'mediaRoot'", ViewGroup.class);
        mediaSubmitScreen.submitTitle = (EditText) Utils.b(view, C1761R.id.submit_title, "field 'submitTitle'", EditText.class);
        mediaSubmitScreen.captureImage = Utils.a(view, C1761R.id.capture_image, "field 'captureImage'");
        mediaSubmitScreen.captureVideo = Utils.a(view, C1761R.id.capture_video, "field 'captureVideo'");
        mediaSubmitScreen.chooseMedia = Utils.a(view, C1761R.id.choose_media, "field 'chooseMedia'");
        mediaSubmitScreen.previewMediaContainer = Utils.a(view, C1761R.id.preview_media_container, "field 'previewMediaContainer'");
        mediaSubmitScreen.videoPreview = (SimpleExoPlayerView) Utils.b(view, C1761R.id.preview_video, "field 'videoPreview'", SimpleExoPlayerView.class);
        mediaSubmitScreen.imagePreview = (ImageView) Utils.b(view, C1761R.id.preview_image, "field 'imagePreview'", ImageView.class);
        mediaSubmitScreen.mediaOptionsContainer = Utils.a(view, C1761R.id.image_upload_options_container, "field 'mediaOptionsContainer'");
        mediaSubmitScreen.clearButton = Utils.a(view, C1761R.id.clear, "field 'clearButton'");
        mediaSubmitScreen.imageIcon = (ImageView) Utils.b(view, C1761R.id.image_icon, "field 'imageIcon'", ImageView.class);
        mediaSubmitScreen.videoIcon = (ImageView) Utils.b(view, C1761R.id.video_icon, "field 'videoIcon'", ImageView.class);
        mediaSubmitScreen.galleryIcon = (ImageView) Utils.b(view, C1761R.id.gallery_icon, "field 'galleryIcon'", ImageView.class);
    }

    public final void m30397a() {
        MediaSubmitScreen mediaSubmitScreen = this.f29326b;
        if (mediaSubmitScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29326b = null;
        mediaSubmitScreen.mediaRoot = null;
        mediaSubmitScreen.submitTitle = null;
        mediaSubmitScreen.captureImage = null;
        mediaSubmitScreen.captureVideo = null;
        mediaSubmitScreen.chooseMedia = null;
        mediaSubmitScreen.previewMediaContainer = null;
        mediaSubmitScreen.videoPreview = null;
        mediaSubmitScreen.imagePreview = null;
        mediaSubmitScreen.mediaOptionsContainer = null;
        mediaSubmitScreen.clearButton = null;
        mediaSubmitScreen.imageIcon = null;
        mediaSubmitScreen.videoIcon = null;
        mediaSubmitScreen.galleryIcon = null;
    }
}
