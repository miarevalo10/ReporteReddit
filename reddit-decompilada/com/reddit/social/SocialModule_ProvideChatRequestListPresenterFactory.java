package com.reddit.social;

import com.reddit.social.presentation.chatrequests.ChatRequestListContract.Presenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideChatRequestListPresenterFactory implements Factory<Presenter> {
    public static Presenter m35416a() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24445f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24445f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
