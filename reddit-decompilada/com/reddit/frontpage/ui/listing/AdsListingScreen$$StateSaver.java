package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.HashMap;

public class AdsListingScreen$$StateSaver<T extends AdsListingScreen> extends BaseLinkListingScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.listing.AdsListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseLinkListingScreen) t, bundle);
        HELPER.putString(bundle, "adListingId", t.adListingId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseLinkListingScreen) t, bundle);
        t.adListingId = HELPER.getString(bundle, "adListingId");
    }
}
