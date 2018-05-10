package com.reddit.social.presentation.messaginglist.content;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class RedditImageMessageContent_MembersInjector implements MembersInjector<RedditImageMessageContent> {
    public static void m30883a(RedditImageMessageContent redditImageMessageContent, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        redditImageMessageContent.f29914b = remoteRedditApiDataSource;
    }
}
