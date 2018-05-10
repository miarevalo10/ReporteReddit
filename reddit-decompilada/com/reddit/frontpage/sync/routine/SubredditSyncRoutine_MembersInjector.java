package com.reddit.frontpage.sync.routine;

import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import dagger.MembersInjector;

public final class SubredditSyncRoutine_MembersInjector implements MembersInjector<SubredditSyncRoutine> {
    public static void m29926a(SubredditSyncRoutine subredditSyncRoutine, LegacySubredditRepository legacySubredditRepository) {
        subredditSyncRoutine.f28857c = legacySubredditRepository;
    }

    public static void m29927a(SubredditSyncRoutine subredditSyncRoutine, SubredditRepository subredditRepository) {
        subredditSyncRoutine.f28858d = subredditRepository;
    }
}
