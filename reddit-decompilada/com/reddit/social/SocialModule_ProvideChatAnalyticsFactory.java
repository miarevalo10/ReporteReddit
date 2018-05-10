package com.reddit.social;

import com.reddit.social.analytics.ChatAnalytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatAnalyticsFactory implements Factory<ChatAnalytics> {
    public static ChatAnalytics m35411a() {
        return (ChatAnalytics) Preconditions.m26013a(SocialModule.m24455p(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (ChatAnalytics) Preconditions.m26013a(SocialModule.m24455p(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
