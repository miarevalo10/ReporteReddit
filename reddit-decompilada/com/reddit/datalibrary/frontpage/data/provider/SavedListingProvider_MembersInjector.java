package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class SavedListingProvider_MembersInjector implements MembersInjector<SavedListingProvider> {
    public static void m16291a(SavedListingProvider savedListingProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        savedListingProvider.f18770c = remoteRedditApiDataSource;
    }
}
