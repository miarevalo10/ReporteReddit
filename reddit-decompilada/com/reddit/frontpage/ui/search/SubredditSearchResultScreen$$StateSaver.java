package com.reddit.frontpage.ui.search;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.BaseScreen$$StateSaver;
import java.util.ArrayList;
import java.util.HashMap;

public class SubredditSearchResultScreen$$StateSaver<T extends SubredditSearchResultScreen> extends BaseScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.search.SubredditSearchResultScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((BaseScreen) t, bundle);
        HELPER.putString(bundle, "after", t.after);
        HELPER.putString(bundle, "query", t.query);
        HELPER.putSerializable(bundle, "subreddits", t.subreddits);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((BaseScreen) t, bundle);
        t.after = HELPER.getString(bundle, "after");
        t.query = HELPER.getString(bundle, "query");
        t.subreddits = (ArrayList) HELPER.getSerializable(bundle, "subreddits");
    }
}
