package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.requests.models.v2.ListParcelerBundler;
import java.util.HashMap;
import java.util.List;

public class UserSubmittedListingScreen$$StateSaver<T extends UserSubmittedListingScreen> extends BaseLinkListingScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.listing.UserSubmittedListingScreen$$StateSaver", BUNDLERS);

    static {
        BUNDLERS.put("karmaList", new ListParcelerBundler());
    }

    public void save(T t, Bundle bundle) {
        super.save((BaseLinkListingScreen) t, bundle);
        HELPER.putBoolean(bundle, "karmaListLoaded", t.karmaListLoaded);
        HELPER.putBoolean(bundle, "isContributor", t.isContributor);
        HELPER.putInt(bundle, "karmaListPosition", t.karmaListPosition);
        HELPER.putInt(bundle, "karmaListPositionOffset", t.karmaListPositionOffset);
        HELPER.putWithBundler(bundle, "karmaList", t.karmaList);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseLinkListingScreen) t, bundle);
        t.karmaListLoaded = HELPER.getBoolean(bundle, "karmaListLoaded");
        t.isContributor = HELPER.getBoolean(bundle, "isContributor");
        t.karmaListPosition = HELPER.getInt(bundle, "karmaListPosition");
        t.karmaListPositionOffset = HELPER.getInt(bundle, "karmaListPositionOffset");
        t.karmaList = (List) HELPER.getWithBundler(bundle, "karmaList");
    }
}
