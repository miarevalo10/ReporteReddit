package com.reddit.frontpage.ui.search;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class CombinedSearchResultScreen$$StateSaver<T extends CombinedSearchResultScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.search.CombinedSearchResultScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putInt(bundle, "timeframeId", t.timeframeId);
        HELPER.putInt(bundle, "sortId", t.sortId);
        HELPER.putString(bundle, "query", t.query);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.timeframeId = HELPER.getInt(bundle, "timeframeId");
        t.sortId = HELPER.getInt(bundle, "sortId");
        t.query = HELPER.getString(bundle, "query");
    }
}
