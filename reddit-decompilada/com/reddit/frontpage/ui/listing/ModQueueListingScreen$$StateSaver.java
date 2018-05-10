package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.HashMap;

public class ModQueueListingScreen$$StateSaver<T extends ModQueueListingScreen> extends LegacySubredditListingScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.listing.ModQueueListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((LegacySubredditListingScreen) t, bundle);
        HELPER.putBoolean(bundle, "ModQueue", t.modQueue);
        HELPER.putString(bundle, "ModQueueType", t.modQueueType);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((LegacySubredditListingScreen) t, bundle);
        t.modQueue = HELPER.getBoolean(bundle, "ModQueue");
        t.mo7241c(HELPER.getString(bundle, "ModQueueType"));
    }
}
