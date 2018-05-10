package com.reddit.datalibrary.frontpage.data.feature.subreddit.di;

import com.reddit.datalibrary.frontpage.data.provider.MultiredditCommunitiesProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditLoaderProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditNameInfoProvider;
import com.reddit.frontpage.sync.routine.SubredditSyncRoutine;
import javax.inject.Singleton;

@Singleton
public interface SubredditRepositoryComponent {
    void mo2998a(MultiredditCommunitiesProvider multiredditCommunitiesProvider);

    void mo2999a(SubredditLoaderProvider subredditLoaderProvider);

    void mo3000a(SubredditNameInfoProvider subredditNameInfoProvider);

    void mo3001a(SubredditSyncRoutine subredditSyncRoutine);
}
