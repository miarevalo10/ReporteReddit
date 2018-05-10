package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ComposeService_MembersInjector implements MembersInjector<ComposeService> {
    private final Provider<RemoteRedditApiDataSource> remoteRedditApiDataSourceProvider;

    public ComposeService_MembersInjector(Provider<RemoteRedditApiDataSource> provider) {
        this.remoteRedditApiDataSourceProvider = provider;
    }

    public static MembersInjector<ComposeService> create(Provider<RemoteRedditApiDataSource> provider) {
        return new ComposeService_MembersInjector(provider);
    }

    public final void injectMembers(ComposeService composeService) {
        injectRemoteRedditApiDataSource(composeService, (RemoteRedditApiDataSource) this.remoteRedditApiDataSourceProvider.get());
    }

    public static void injectRemoteRedditApiDataSource(ComposeService composeService, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        composeService.remoteRedditApiDataSource = remoteRedditApiDataSource;
    }
}
