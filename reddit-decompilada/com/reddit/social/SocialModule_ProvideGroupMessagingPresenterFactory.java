package com.reddit.social;

import com.reddit.social.presentation.groupchat.ChatContract.Presenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideGroupMessagingPresenterFactory implements Factory<Presenter> {
    public static Presenter m35423a() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24442c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24442c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
