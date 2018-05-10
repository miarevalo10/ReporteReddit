package com.reddit.frontpage.presentation.listing.history;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen$$StateSaver;
import java.util.HashMap;

public class HistoryListingScreen$$StateSaver<T extends HistoryListingScreen> extends LinkListingScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.listing.history.HistoryListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((LinkListingScreen) t, bundle);
        HELPER.putBoolean(bundle, "ClearRecentsMenuEnabled", t.clearRecentsMenuEnabled);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((LinkListingScreen) t, bundle);
        t.clearRecentsMenuEnabled = HELPER.getBoolean(bundle, "ClearRecentsMenuEnabled");
    }
}
