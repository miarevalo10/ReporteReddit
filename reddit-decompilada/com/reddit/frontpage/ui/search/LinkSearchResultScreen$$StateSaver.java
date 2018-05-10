package com.reddit.frontpage.ui.search;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.HashMap;

public class LinkSearchResultScreen$$StateSaver<T extends LinkSearchResultScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.search.LinkSearchResultScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putBoolean(bundle, "multireddit", t.multireddit);
        HELPER.putInt(bundle, "sortId", t.sortId);
        HELPER.putInt(bundle, "timeframeId", t.timeframeId);
        HELPER.putString(bundle, "query", t.query);
        HELPER.putString(bundle, "searchContext", t.searchContext);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.multireddit = HELPER.getBoolean(bundle, "multireddit");
        t.sortId = HELPER.getInt(bundle, "sortId");
        t.timeframeId = HELPER.getInt(bundle, "timeframeId");
        t.query = HELPER.getString(bundle, "query");
        t.searchContext = HELPER.getString(bundle, "searchContext");
    }
}
