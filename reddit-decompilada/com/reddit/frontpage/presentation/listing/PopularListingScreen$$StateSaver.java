package com.reddit.frontpage.presentation.listing;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen$$StateSaver;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

public class PopularListingScreen$$StateSaver<T extends PopularListingScreen> extends LinkListingScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.listing.PopularListingScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((LinkListingScreen) t, bundle);
        HELPER.putString(bundle, "GeopopularRegionName", t.geopopularRegionName);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((LinkListingScreen) t, bundle);
        bundle = HELPER.getString(bundle, "GeopopularRegionName");
        Intrinsics.m26847b(bundle, "<set-?>");
        t.geopopularRegionName = bundle;
    }
}
