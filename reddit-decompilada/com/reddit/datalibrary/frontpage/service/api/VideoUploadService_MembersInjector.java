package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class VideoUploadService_MembersInjector implements MembersInjector<VideoUploadService> {
    private final Provider<RemoteRedditApiDataSource> remoteRedditApiDataSourceProvider;

    public VideoUploadService_MembersInjector(Provider<RemoteRedditApiDataSource> provider) {
        this.remoteRedditApiDataSourceProvider = provider;
    }

    public static MembersInjector<VideoUploadService> create(Provider<RemoteRedditApiDataSource> provider) {
        return new VideoUploadService_MembersInjector(provider);
    }

    public final void injectMembers(VideoUploadService videoUploadService) {
        injectRemoteRedditApiDataSource(videoUploadService, (RemoteRedditApiDataSource) this.remoteRedditApiDataSourceProvider.get());
    }

    public static void injectRemoteRedditApiDataSource(VideoUploadService videoUploadService, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        videoUploadService.remoteRedditApiDataSource = remoteRedditApiDataSource;
    }
}
