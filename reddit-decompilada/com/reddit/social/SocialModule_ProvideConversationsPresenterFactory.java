package com.reddit.social;

import com.reddit.social.presentation.chatinbox.ChatInboxContract.Presenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideConversationsPresenterFactory implements Factory<Presenter> {
    public static Presenter m35420a() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24440a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24440a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
