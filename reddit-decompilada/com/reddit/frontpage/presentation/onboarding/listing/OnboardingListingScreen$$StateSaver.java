package com.reddit.frontpage.presentation.onboarding.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen$$StateSaver;
import java.util.HashMap;

public class OnboardingListingScreen$$StateSaver<T extends OnboardingListingScreen> extends LinkListingScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((LinkListingScreen) t, bundle);
        HELPER.putParcelable(bundle, "category", t.category);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((LinkListingScreen) t, bundle);
        t.category = (SubredditCategory) HELPER.getParcelable(bundle, "category");
    }
}
