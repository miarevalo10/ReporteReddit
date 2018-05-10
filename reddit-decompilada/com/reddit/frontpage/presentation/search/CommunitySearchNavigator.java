package com.reddit.frontpage.presentation.search;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchNavigator;", "", "navigateToAccount", "", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "navigateToCommunitySearchSubmission", "query", "", "navigateToSubreddit", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchNavigator.kt */
public interface CommunitySearchNavigator {
    void mo7425a(Account account);

    void mo7426a(Subreddit subreddit);

    void mo7427a(String str);
}
