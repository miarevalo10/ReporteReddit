package com.reddit.frontpage.ui.submit;

import android.net.Uri;
import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.io.File;
import java.util.HashMap;

public class MediaSubmitScreen$$StateSaver<T extends MediaSubmitScreen> extends BaseSubmitScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.submit.MediaSubmitScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseSubmitScreen) t, bundle);
        HELPER.putParcelable(bundle, "sharedMediaUri", t.sharedMediaUri);
        HELPER.putBoolean(bundle, "isGif", t.isGif);
        HELPER.putBoolean(bundle, "isImage", t.isImage);
        HELPER.putInt(bundle, "submitType", t.submitType);
        HELPER.putInt(bundle, "videoProcessState", t.videoProcessState);
        HELPER.putSerializable(bundle, "mediaFile", t.mediaFile);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseSubmitScreen) t, bundle);
        t.sharedMediaUri = (Uri) HELPER.getParcelable(bundle, "sharedMediaUri");
        t.isGif = HELPER.getBoolean(bundle, "isGif");
        t.isImage = HELPER.getBoolean(bundle, "isImage");
        t.submitType = HELPER.getInt(bundle, "submitType");
        t.videoProcessState = HELPER.getInt(bundle, "videoProcessState");
        t.mediaFile = (File) HELPER.getSerializable(bundle, "mediaFile");
    }
}
