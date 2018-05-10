package com.reddit.social.domain.functions;

import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import dagger.MembersInjector;

public final class ChannelConversationTransformer_MembersInjector implements MembersInjector<ChannelConversationTransformer> {
    public static void m30615a(ChannelConversationTransformer channelConversationTransformer, FailedMessagesCacheContract failedMessagesCacheContract) {
        channelConversationTransformer.f29573a = failedMessagesCacheContract;
    }
}
