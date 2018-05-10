package com.reddit.frontpage.ui.submit;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Function;

final /* synthetic */ class MediaSubmitScreen$$Lambda$12 implements Function {
    private final MediaSubmitScreen f29315a;

    MediaSubmitScreen$$Lambda$12(MediaSubmitScreen mediaSubmitScreen) {
        this.f29315a = mediaSubmitScreen;
    }

    public final Object apply(Object obj) {
        String displayName;
        BaseSubmitScreen baseSubmitScreen = this.f29315a;
        VideoUpload videoUpload = (VideoUpload) obj;
        videoUpload.setTitle(baseSubmitScreen.submitTitle.getText().toString().trim());
        if (baseSubmitScreen.originSubreddit != null) {
            displayName = baseSubmitScreen.originSubreddit.getDisplayName();
        } else {
            displayName = baseSubmitScreen.selectedSubredditData.subredditName;
        }
        videoUpload.setSubreddit(displayName);
        videoUpload.setOriginalDuration(baseSubmitScreen.f40174C);
        videoUpload.setDuration(baseSubmitScreen.f40175D);
        videoUpload.setSource(baseSubmitScreen.f40176E);
        videoUpload.setGif(baseSubmitScreen.isGif);
        if (baseSubmitScreen.f40172A) {
            videoUpload.setStatus(0);
        }
        videoUpload.update();
        return videoUpload;
    }
}
