package com.reddit.frontpage.domain.repository;

import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditCategory;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/domain/repository/CategoryRepository;", "", "getCategories", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "getSubredditsInCategory", "Lcom/reddit/frontpage/domain/model/Subreddit;", "category", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CategoryRepository.kt */
public interface CategoryRepository {
    Single<List<SubredditCategory>> m22404a();

    Single<List<Subreddit>> m22405a(SubredditCategory subredditCategory);
}
