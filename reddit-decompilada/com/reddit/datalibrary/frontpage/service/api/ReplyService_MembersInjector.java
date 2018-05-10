package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ReplyService_MembersInjector implements MembersInjector<ReplyService> {
    private final Provider<RemoteRedditApiDataSource> remoteRedditApiDataSourceProvider;

    public ReplyService_MembersInjector(Provider<RemoteRedditApiDataSource> provider) {
        this.remoteRedditApiDataSourceProvider = provider;
    }

    public static MembersInjector<ReplyService> create(Provider<RemoteRedditApiDataSource> provider) {
        return new ReplyService_MembersInjector(provider);
    }

    public final void injectMembers(ReplyService replyService) {
        injectRemoteRedditApiDataSource(replyService, (RemoteRedditApiDataSource) this.remoteRedditApiDataSourceProvider.get());
    }

    public static void injectRemoteRedditApiDataSource(ReplyService replyService, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        replyService.remoteRedditApiDataSource = remoteRedditApiDataSource;
    }
}
