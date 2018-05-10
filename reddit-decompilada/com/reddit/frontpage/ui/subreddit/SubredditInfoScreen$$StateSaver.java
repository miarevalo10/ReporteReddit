package com.reddit.frontpage.ui.subreddit;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import com.evernote.android.state.InjectionHelper;
import com.reddit.frontpage.domain.model.Subreddit;
import java.util.HashMap;

public class SubredditInfoScreen$$StateSaver<T extends SubredditInfoScreen> extends AbstractSubredditHtmlScreen$$StateSaver<T> {
    private static final HashMap<String, Bundler<?>> BUNDLERS = new HashMap();
    private static final InjectionHelper HELPER = new InjectionHelper("com.reddit.frontpage.ui.subreddit.SubredditInfoScreen$$StateSaver", BUNDLERS);

    public void save(T t, Bundle bundle) {
        super.save((AbstractSubredditHtmlScreen) t, bundle);
        HELPER.putParcelable(bundle, "subreddit", t.subreddit);
    }

    public void restore(T t, Bundle bundle) {
        super.restore((AbstractSubredditHtmlScreen) t, bundle);
        t.subreddit = (Subreddit) HELPER.getParcelable(bundle, "subreddit");
    }
}
