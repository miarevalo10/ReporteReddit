package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.domain.model.Subreddit;
import java.util.HashMap;

public class LegacySubredditListingScreen$$StateSaver<T extends LegacySubredditListingScreen> extends AdsListingScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.listing.LegacySubredditListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((AdsListingScreen) t, bundle);
        HELPER.putBoolean(bundle, "Subscribed", t.subscribed);
        HELPER.putParcelable(bundle, "SubredditModel", t.subredditModel);
        HELPER.putBoxedInt(bundle, "ThemedKeyColor", t.themedKeyColor);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((AdsListingScreen) t, bundle);
        t.subscribed = HELPER.getBoolean(bundle, "Subscribed");
        t.m42294a((Subreddit) HELPER.getParcelable(bundle, "SubredditModel"));
        t.themedKeyColor = HELPER.getBoxedInt(bundle, "ThemedKeyColor");
    }
}
