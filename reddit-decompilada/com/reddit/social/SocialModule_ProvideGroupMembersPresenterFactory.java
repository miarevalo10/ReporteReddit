package com.reddit.social;

import com.reddit.social.presentation.groupchat.GroupMembersContract.Presenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideGroupMembersPresenterFactory implements Factory<Presenter> {
    public static Presenter m35422a() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24444e(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24444e(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
