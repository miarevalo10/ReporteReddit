package com.reddit.frontpage.ui.submit;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.functions.Consumer;

final /* synthetic */ class MediaSubmitScreen$$Lambda$13 implements Consumer {
    private final MediaSubmitScreen f29316a;

    MediaSubmitScreen$$Lambda$13(MediaSubmitScreen mediaSubmitScreen) {
        this.f29316a = mediaSubmitScreen;
    }

    public final void accept(Object obj) {
        BaseSubmitScreen baseSubmitScreen = this.f29316a;
        VideoUpload videoUpload = (VideoUpload) obj;
        Context context = FrontpageApplication.f27402a;
        if (videoUpload.getStatus() == null) {
            obj = VideoUploadService.getUploadFileIntent(context, baseSubmitScreen.mediaFile.getAbsolutePath(), baseSubmitScreen.submitRequestId, baseSubmitScreen.isGif);
        } else {
            obj = VideoUploadService.getSubmitPostIntent(context, baseSubmitScreen.submitRequestId);
        }
        context.startService(obj);
    }
}
