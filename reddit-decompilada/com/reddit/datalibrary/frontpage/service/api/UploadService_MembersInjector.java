package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class UploadService_MembersInjector implements MembersInjector<UploadService> {
    private final Provider<RemoteRedditApiDataSource> remoteRedditApiDataSourceProvider;

    public UploadService_MembersInjector(Provider<RemoteRedditApiDataSource> provider) {
        this.remoteRedditApiDataSourceProvider = provider;
    }

    public static MembersInjector<UploadService> create(Provider<RemoteRedditApiDataSource> provider) {
        return new UploadService_MembersInjector(provider);
    }

    public final void injectMembers(UploadService uploadService) {
        injectRemoteRedditApiDataSource(uploadService, (RemoteRedditApiDataSource) this.remoteRedditApiDataSourceProvider.get());
    }

    public static void injectRemoteRedditApiDataSource(UploadService uploadService, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        uploadService.remoteRedditApiDataSource = remoteRedditApiDataSource;
    }
}
