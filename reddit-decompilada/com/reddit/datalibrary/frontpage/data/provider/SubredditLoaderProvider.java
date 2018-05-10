package com.reddit.datalibrary.frontpage.data.provider;

import com.raizlabs.android.dbflow.structure.Model;
import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.frontpage.FrontpageApplication;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

public abstract class SubredditLoaderProvider extends LoaderProvider<Subreddit> {
    private static final Map<String, Boolean> f18771b = new HashMap();
    @Inject
    LegacySubredditRepository f18772a;

    public final /* synthetic */ Model mo3804a(int i) {
        return m19751b(i);
    }

    public final Subreddit m19751b(int i) {
        Subreddit subreddit = (Subreddit) super.mo3804a(i);
        if (subreddit == null) {
            return 0;
        }
        String displayName = subreddit.getDisplayName();
        if (f18771b.containsKey(displayName)) {
            subreddit.setUserFavorite(((Boolean) f18771b.get(displayName)).booleanValue());
        }
        return subreddit;
    }

    public SubredditLoaderProvider() {
        super(11);
        FrontpageApplication.e().mo2999a(this);
    }
}
