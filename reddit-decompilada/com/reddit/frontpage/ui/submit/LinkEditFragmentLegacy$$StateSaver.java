package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import java.util.HashMap;

public class LinkEditFragmentLegacy$$StateSaver<T extends LinkEditFragmentLegacy> extends EditFragmentLegacy$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.submit.LinkEditFragmentLegacy$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("link", new ParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((EditFragmentLegacy) t, bundle);
        HELPER.putWithBundler(bundle, "link", t.link);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((EditFragmentLegacy) t, bundle);
        t.link = (Link) HELPER.getWithBundler(bundle, "link");
    }
}
