package com.reddit.frontpage.ui.detail.video;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.detail.BaseDetailScreen$$StateSaver;
import java.util.HashMap;

public class VideoDetailScreen$$StateSaver<T extends VideoDetailScreen> extends BaseDetailScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.detail.video.VideoDetailScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseDetailScreen) t, bundle);
        HELPER.putBoolean(bundle, "inLandscape", t.inLandscape);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseDetailScreen) t, bundle);
        t.inLandscape = HELPER.getBoolean(bundle, "inLandscape");
    }
}
