package com.reddit.social;

import com.reddit.social.presentation.groupchat.ChatSettingsContract.Presenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideMessagingSettingsPresenterFactory implements Factory<Presenter> {
    public static Presenter m35428a() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24443d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24443d(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
