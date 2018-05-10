package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class InboxFilterableListingProvider_MembersInjector implements MembersInjector<InboxFilterableListingProvider> {
    public static void m16251a(InboxFilterableListingProvider inboxFilterableListingProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        inboxFilterableListingProvider.f19435d = remoteRedditApiDataSource;
    }
}
