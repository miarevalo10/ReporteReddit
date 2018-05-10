package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SubmitService_MembersInjector implements MembersInjector<SubmitService> {
    private final Provider<RemoteRedditApiDataSource> remoteRedditApiDataSourceProvider;
    private final Provider<RemoteWebSocketDataSource> remoteWebSocketDataSourceProvider;

    public SubmitService_MembersInjector(Provider<RemoteRedditApiDataSource> provider, Provider<RemoteWebSocketDataSource> provider2) {
        this.remoteRedditApiDataSourceProvider = provider;
        this.remoteWebSocketDataSourceProvider = provider2;
    }

    public static MembersInjector<SubmitService> create(Provider<RemoteRedditApiDataSource> provider, Provider<RemoteWebSocketDataSource> provider2) {
        return new SubmitService_MembersInjector(provider, provider2);
    }

    public final void injectMembers(SubmitService submitService) {
        injectRemoteRedditApiDataSource(submitService, (RemoteRedditApiDataSource) this.remoteRedditApiDataSourceProvider.get());
        injectRemoteWebSocketDataSource(submitService, (RemoteWebSocketDataSource) this.remoteWebSocketDataSourceProvider.get());
    }

    public static void injectRemoteRedditApiDataSource(SubmitService submitService, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        submitService.remoteRedditApiDataSource = remoteRedditApiDataSource;
    }

    public static void injectRemoteWebSocketDataSource(SubmitService submitService, RemoteWebSocketDataSource remoteWebSocketDataSource) {
        submitService.remoteWebSocketDataSource = remoteWebSocketDataSource;
    }
}
