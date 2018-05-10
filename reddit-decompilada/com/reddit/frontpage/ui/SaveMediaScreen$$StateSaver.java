package com.reddit.frontpage.ui;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import java.util.HashMap;

public class SaveMediaScreen$$StateSaver<T extends SaveMediaScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.SaveMediaScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putSerializable(bundle, "link", t.link);
        HELPER.putString(bundle, "mediaUri", t.mediaUri);
        HELPER.putString(bundle, "sourcePage", t.sourcePage);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.link = (Link) HELPER.getSerializable(bundle, "link");
        t.mediaUri = HELPER.getString(bundle, "mediaUri");
        t.sourcePage = HELPER.getString(bundle, "sourcePage");
    }
}
