package com.reddit.frontpage.ui.detail.live;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.BaseFrontpageFragment$$StateSaver;
import java.util.HashMap;

public class LiveDetailsFragment$$StateSaver<T extends LiveDetailsFragment> extends BaseFrontpageFragment$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.detail.live.LiveDetailsFragment$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseFrontpageFragment) t, bundle);
        HELPER.putString(bundle, "details", t.details);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseFrontpageFragment) t, bundle);
        t.details = HELPER.getString(bundle, "details");
    }
}
