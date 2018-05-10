package com.reddit.social;

import com.reddit.social.presentation.chatrequests.ChatRequestContract.Presenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatRequestPresenterFactory implements Factory<Presenter> {
    public static Presenter m35417a() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24446g(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24446g(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
