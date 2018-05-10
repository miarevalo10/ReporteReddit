package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class CombinedSearchProvider$$StateSaver<T extends CombinedSearchProvider> extends BaseOtherProvider$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.datalibrary.frontpage.data.provider.CombinedSearchProvider$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseOtherProvider) t, bundle);
        HELPER.putInt(bundle, "mTimeframeId", t.mTimeframeId);
        HELPER.putInt(bundle, "mSortId", t.mSortId);
        HELPER.putString(bundle, "mLinksAfter", t.mLinksAfter);
        HELPER.putString(bundle, "mSubredditsAfter", t.mSubredditsAfter);
        HELPER.putString(bundle, "mQuery", t.mQuery);
        HELPER.putSerializable(bundle, "mLinks", t.mLinks);
        HELPER.putSerializable(bundle, "mSubreddits", t.mSubreddits);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseOtherProvider) t, bundle);
        t.mTimeframeId = HELPER.getInt(bundle, "mTimeframeId");
        t.mSortId = HELPER.getInt(bundle, "mSortId");
        t.mLinksAfter = HELPER.getString(bundle, "mLinksAfter");
        t.mSubredditsAfter = HELPER.getString(bundle, "mSubredditsAfter");
        t.mQuery = HELPER.getString(bundle, "mQuery");
        t.mLinks = (ArrayList) HELPER.getSerializable(bundle, "mLinks");
        t.mSubreddits = (ArrayList) HELPER.getSerializable(bundle, "mSubreddits");
    }
}
