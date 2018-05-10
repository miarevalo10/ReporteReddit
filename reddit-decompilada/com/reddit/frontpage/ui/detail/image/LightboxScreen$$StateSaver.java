package com.reddit.frontpage.ui.detail.image;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.SaveMediaScreen;
import com.reddit.frontpage.ui.SaveMediaScreen$$StateSaver;
import java.util.HashMap;

public class LightboxScreen$$StateSaver<T extends LightboxScreen> extends SaveMediaScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.detail.image.LightboxScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((SaveMediaScreen) t, bundle);
        HELPER.putInt(bundle, "imageHeight", t.imageHeight);
        HELPER.putInt(bundle, "imageWidth", t.imageWidth);
        HELPER.putString(bundle, "fullname", t.fullname);
        HELPER.putString(bundle, "domain", t.domain);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((SaveMediaScreen) t, bundle);
        t.imageHeight = HELPER.getInt(bundle, "imageHeight");
        t.imageWidth = HELPER.getInt(bundle, "imageWidth");
        t.fullname = HELPER.getString(bundle, "fullname");
        t.domain = HELPER.getString(bundle, "domain");
    }
}
