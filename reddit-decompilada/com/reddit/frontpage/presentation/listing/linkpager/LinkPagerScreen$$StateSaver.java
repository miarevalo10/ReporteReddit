package com.reddit.frontpage.presentation.listing.linkpager;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class LinkPagerScreen$$StateSaver<T extends LinkPagerScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putSerializable(bundle, "sort", t.sort);
        HELPER.putSerializable(bundle, "SortTimeFrame", t.sortTimeFrame);
        HELPER.putSerializable(bundle, "listingType", t.listingType);
        HELPER.putInt(bundle, "LinkPosition", t.linkPosition);
        HELPER.putString(bundle, "selectedLinkId", t.selectedLinkId);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.sort = (LinkSortType) HELPER.getSerializable(bundle, "sort");
        t.sortTimeFrame = (SortTimeFrame) HELPER.getSerializable(bundle, "SortTimeFrame");
        t.listingType = (ListingType) HELPER.getSerializable(bundle, "listingType");
        t.linkPosition = HELPER.getInt(bundle, "LinkPosition");
        t.selectedLinkId = HELPER.getString(bundle, "selectedLinkId");
    }
}
