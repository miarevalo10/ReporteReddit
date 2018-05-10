package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.social.analytics.ChatAnalytics;
import dagger.MembersInjector;

public final class GroupMembersPresenter_MembersInjector implements MembersInjector<GroupMembersPresenter> {
    public static void m30770a(GroupMembersPresenter groupMembersPresenter, ChatDataRepositoryContract chatDataRepositoryContract) {
        groupMembersPresenter.f29739a = chatDataRepositoryContract;
    }

    public static void m30771a(GroupMembersPresenter groupMembersPresenter, ChatAnalytics chatAnalytics) {
        groupMembersPresenter.f29740b = chatAnalytics;
    }
}
