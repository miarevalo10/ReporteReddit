package com.reddit.social;

import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatPerformanceAnalyticsFactory implements Factory<ChatPerformanceAnalyticsContract> {
    public static ChatPerformanceAnalyticsContract m35415a() {
        return (ChatPerformanceAnalyticsContract) Preconditions.m26013a(SocialModule.m24460u(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (ChatPerformanceAnalyticsContract) Preconditions.m26013a(SocialModule.m24460u(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
