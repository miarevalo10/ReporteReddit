package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class LegacyLinkPagerScreen$$StateSaver<T extends LegacyLinkPagerScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.listing.LegacyLinkPagerScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putInt(bundle, "pagerPosition", t.pagerPosition);
        HELPER.putInt(bundle, "feedPosition", t.feedPosition);
        HELPER.putString(bundle, "sourcePage", t.sourcePage);
        HELPER.putString(bundle, "listingInstanceId", t.listingInstanceId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.pagerPosition = HELPER.getInt(bundle, "pagerPosition");
        t.feedPosition = HELPER.getInt(bundle, "feedPosition");
        t.sourcePage = HELPER.getString(bundle, "sourcePage");
        t.listingInstanceId = HELPER.getString(bundle, "listingInstanceId");
    }
}
