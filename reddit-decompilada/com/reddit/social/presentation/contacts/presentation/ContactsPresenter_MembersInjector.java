package com.reddit.social.presentation.contacts.presentation;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.analytics.ChatAnalytics;
import dagger.MembersInjector;

public final class ContactsPresenter_MembersInjector implements MembersInjector<ContactsPresenter> {
    public static void m30751a(ContactsPresenter contactsPresenter, ChatDataRepositoryContract chatDataRepositoryContract) {
        contactsPresenter.f29709a = chatDataRepositoryContract;
    }

    public static void m30752a(ContactsPresenter contactsPresenter, ChatAnalytics chatAnalytics) {
        contactsPresenter.f29710b = chatAnalytics;
    }
}
