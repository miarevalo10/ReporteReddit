package com.reddit.datalibrary.frontpage.data.feature.legacy;

import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LegacyLocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyRemoteSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditDisplayName;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SubredditUtil;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import timber.log.Timber;

@Deprecated
public class LegacySubredditRepository {
    final LegacyRemoteSubredditDataSource f10418a;
    public final LegacyLocalSubredditDataSource f10419b;

    interface SubredditRetriever {
        Listing<Subreddit> mo2932a(String str) throws Exception;
    }

    @Inject
    public LegacySubredditRepository(LegacyRemoteSubredditDataSource legacyRemoteSubredditDataSource, LegacyLocalSubredditDataSource legacyLocalSubredditDataSource) {
        this.f10418a = legacyRemoteSubredditDataSource;
        this.f10419b = legacyLocalSubredditDataSource;
    }

    public final void m8850a() throws Exception {
        LegacyRemoteSubredditDataSource legacyRemoteSubredditDataSource = this.f10418a;
        legacyRemoteSubredditDataSource.getClass();
        this.f10419b.mo2936a(m8848a(LegacySubredditRepository$$Lambda$0.m15922a(legacyRemoteSubredditDataSource)));
    }

    public final void m8851a(Session session) throws Exception {
        Listing<Subreddit> a = m8848a(new LegacySubredditRepository$$Lambda$1(this, session));
        for (Subreddit displayName : a) {
            SubredditUtil.b(displayName.getDisplayName(), true);
        }
        m8849a((Listing) a);
        FrontpageSettings a2 = FrontpageSettings.m9011a();
        if (!a2.f10758a.getBoolean("com.reddit.frontpage.has_synced_local_favorites", false)) {
            Collection hashSet = new HashSet();
            LegacyLocalSubredditDataSource legacyLocalSubredditDataSource = this.f10419b;
            FrontpageApplication frontpageApplication = FrontpageApplication.a;
            for (SubredditDisplayName displayName2 : legacyLocalSubredditDataSource.mo2939c()) {
                hashSet.add(displayName2.getDisplayName());
            }
            Timber.b("Syncing localy stored favorites to server: %s", new Object[]{hashSet});
            if (!hashSet.isEmpty()) {
                this.f10418a.mo2949a(hashSet);
            }
            a2.f10758a.edit().putBoolean("com.reddit.frontpage.has_synced_local_favorites", true).apply();
        }
        this.f10419b.mo2934a(session, (Listing) a);
    }

    public final void m8852b(Session session) throws Exception {
        Listing a = m8848a(new LegacySubredditRepository$$Lambda$2(this, session));
        m8849a(a);
        this.f10419b.mo2938b(session, a);
    }

    private void m8849a(Listing<Subreddit> listing) {
        Set hashSet = new HashSet();
        LegacyLocalSubredditDataSource legacyLocalSubredditDataSource = this.f10419b;
        FrontpageApplication frontpageApplication = FrontpageApplication.a;
        for (SubredditDisplayName displayName : legacyLocalSubredditDataSource.mo2937b()) {
            hashSet.add(displayName.getDisplayName());
        }
        for (Subreddit subreddit : listing) {
            subreddit.setUserFavorite(hashSet.contains(subreddit.getDisplayName()));
        }
    }

    private static Listing<Subreddit> m8848a(SubredditRetriever subredditRetriever) throws Exception {
        String str = null;
        Listing listing = null;
        do {
            Listing a = subredditRetriever.mo2932a(str);
            if (listing == null) {
                listing = a;
            } else {
                listing.add(a);
            }
            str = listing.getAfter();
        } while (str != null);
        return listing;
    }

    public final void m8853c(Session session) throws Exception {
        this.f10419b.mo2935a(session, this.f10418a.mo2952c());
    }
}
