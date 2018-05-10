package com.reddit.datalibrary.frontpage.data.feature.category.datasource;

import com.reddit.datalibrary.frontpage.data.common.converter.ListingEnveloped;
import com.reddit.datalibrary.frontpage.data.common.converter.RecommendedCategoryType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.RecommendedCategory;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.model.SubredditCategory;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J*\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\nH'J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\nH'¨\u0006\u000e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/category/datasource/RemoteCategoryDataSource;", "", "subredditCategories", "Lio/reactivex/Single;", "", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "subredditsInCategory", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "categoryId", "", "after", "subredditsInRecommended", "Lcom/reddit/datalibrary/frontpage/data/model/RecommendedCategory;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteCategoryDataSource.kt */
public interface RemoteCategoryDataSource {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: RemoteCategoryDataSource.kt */
    public static final class DefaultImpls {
        @ListingEnveloped
        @GET(a = "api/subreddits_in_category")
        public static /* synthetic */ Single subredditsInCategory$default(RemoteCategoryDataSource remoteCategoryDataSource, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subredditsInCategory");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return remoteCategoryDataSource.subredditsInCategory(str, str2);
        }

        @RecommendedCategoryType
        @GET(a = "api/recommended_subreddits")
        public static /* synthetic */ Single subredditsInRecommended$default(RemoteCategoryDataSource remoteCategoryDataSource, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subredditsInRecommended");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return remoteCategoryDataSource.subredditsInRecommended(str);
        }
    }

    @GET(a = "api/available_subreddit_categories")
    Single<List<SubredditCategory>> subredditCategories();

    @ListingEnveloped
    @GET(a = "api/subreddits_in_category")
    Single<Listing<Subreddit>> subredditsInCategory(@Query(a = "category") String str, @Query(a = "after") String str2);

    @RecommendedCategoryType
    @GET(a = "api/recommended_subreddits")
    Single<RecommendedCategory> subredditsInRecommended(@Query(a = "after") String str);
}
