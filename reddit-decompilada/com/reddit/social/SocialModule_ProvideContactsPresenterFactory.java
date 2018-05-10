package com.reddit.social;

import com.reddit.social.presentation.contacts.ContactsContract.Presenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SocialModule_ProvideContactsPresenterFactory implements Factory<Presenter> {
    public static Presenter m35419a() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24441b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(SocialModule.m24441b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
