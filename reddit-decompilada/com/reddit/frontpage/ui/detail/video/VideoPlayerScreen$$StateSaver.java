package com.reddit.frontpage.ui.detail.video;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.SaveMediaScreen;
import com.reddit.frontpage.ui.SaveMediaScreen$$StateSaver;
import java.util.HashMap;

public class VideoPlayerScreen$$StateSaver<T extends VideoPlayerScreen> extends SaveMediaScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.detail.video.VideoPlayerScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((SaveMediaScreen) t, bundle);
        HELPER.putBoolean(bundle, "hasNavBar", t.hasNavBar);
        HELPER.putBoolean(bundle, "videoOrientationLandscape", t.videoOrientationLandscape);
        HELPER.putBoolean(bundle, "isPlaying", t.isPlaying);
        HELPER.putBoolean(bundle, "overflowMenuOpen", t.overflowMenuOpen);
        HELPER.putInt(bundle, "videoHeight", t.videoHeight);
        HELPER.putInt(bundle, "videoWidth", t.videoWidth);
        HELPER.putString(bundle, "fullName", t.fullName);
        HELPER.putString(bundle, "imageUri", t.imageUri);
        HELPER.putString(bundle, "gifUri", t.gifUri);
        HELPER.putString(bundle, "mp4Uri", t.mp4Uri);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((SaveMediaScreen) t, bundle);
        t.hasNavBar = HELPER.getBoolean(bundle, "hasNavBar");
        t.videoOrientationLandscape = HELPER.getBoolean(bundle, "videoOrientationLandscape");
        t.isPlaying = HELPER.getBoolean(bundle, "isPlaying");
        t.overflowMenuOpen = HELPER.getBoolean(bundle, "overflowMenuOpen");
        t.videoHeight = HELPER.getInt(bundle, "videoHeight");
        t.videoWidth = HELPER.getInt(bundle, "videoWidth");
        t.fullName = HELPER.getString(bundle, "fullName");
        t.imageUri = HELPER.getString(bundle, "imageUri");
        t.gifUri = HELPER.getString(bundle, "gifUri");
        t.mp4Uri = HELPER.getString(bundle, "mp4Uri");
    }
}
