package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.HashMap;

public class LegacyPopularListingScreen$$StateSaver<T extends LegacyPopularListingScreen> extends AdsListingScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.listing.LegacyPopularListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((AdsListingScreen) t, bundle);
        HELPER.putBoolean(bundle, "CheckedRemoteGeopopular", t.checkedRemoteGeopopular);
        HELPER.putString(bundle, "GeopopularRegionName", t.geopopularRegionName);
        HELPER.putString(bundle, "GeopopularRegionQueryParameterValue", t.geopopularRegionQueryParameterValue);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((AdsListingScreen) t, bundle);
        t.checkedRemoteGeopopular = HELPER.getBoolean(bundle, "CheckedRemoteGeopopular");
        t.m42538b(HELPER.getString(bundle, "GeopopularRegionName"));
        t.m42536a(HELPER.getString(bundle, "GeopopularRegionQueryParameterValue"));
    }
}
