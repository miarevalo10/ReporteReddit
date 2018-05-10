package com.reddit.frontpage.ui.detail.video;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.SaveMediaScreen;
import com.reddit.frontpage.ui.SaveMediaScreen$$StateSaver;
import java.util.HashMap;

public class VideoPlayerScreenLegacy$$StateSaver<T extends VideoPlayerScreenLegacy> extends SaveMediaScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.detail.video.VideoPlayerScreenLegacy$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((SaveMediaScreen) t, bundle);
        HELPER.putInt(bundle, "videoHeight", t.videoHeight);
        HELPER.putInt(bundle, "videoWidth", t.videoWidth);
        HELPER.putString(bundle, "mp4Uri", t.mp4Uri);
        HELPER.putString(bundle, "gifUri", t.gifUri);
        HELPER.putString(bundle, "fullName", t.fullName);
        HELPER.putString(bundle, "imageUri", t.imageUri);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((SaveMediaScreen) t, bundle);
        t.videoHeight = HELPER.getInt(bundle, "videoHeight");
        t.videoWidth = HELPER.getInt(bundle, "videoWidth");
        t.mp4Uri = HELPER.getString(bundle, "mp4Uri");
        t.gifUri = HELPER.getString(bundle, "gifUri");
        t.fullName = HELPER.getString(bundle, "fullName");
        t.imageUri = HELPER.getString(bundle, "imageUri");
    }
}
