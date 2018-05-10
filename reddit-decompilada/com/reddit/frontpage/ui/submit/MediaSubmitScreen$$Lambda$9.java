package com.reddit.frontpage.ui.submit;

import android.graphics.Bitmap;
import com.bluelinelabs.conductor.Controller;
import io.reactivex.functions.Consumer;

final /* synthetic */ class MediaSubmitScreen$$Lambda$9 implements Consumer {
    private final MediaSubmitScreen f29324a;

    MediaSubmitScreen$$Lambda$9(MediaSubmitScreen mediaSubmitScreen) {
        this.f29324a = mediaSubmitScreen;
    }

    public final void accept(Object obj) {
        Controller controller = this.f29324a;
        Bitmap bitmap = (Bitmap) obj;
        if (controller.e) {
            controller.f40173B = bitmap;
            controller.videoPreview.setShutterImage(bitmap);
        }
    }
}
