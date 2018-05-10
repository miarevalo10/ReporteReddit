package com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote;

import com.reddit.datalibrary.frontpage.data.common.converter.EnvelopeList;
import com.reddit.datalibrary.frontpage.data.common.converter.Enveloped;
import com.reddit.datalibrary.frontpage.data.common.converter.ListingEnveloped;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.data.model.SubredditListingDataModel;
import com.reddit.frontpage.domain.model.Multireddit;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.repository.SubredditRepository.SubredditAction;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0003H'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\r\u001a\u00020\u0007H'J8\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00072\u0014\b\u0003\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00122\b\b\u0003\u0010\u0013\u001a\u00020\u0014H'J \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\u001c\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0007H'J\u001c\u0010\u001b\u001a\u00020\u00172\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u001dH'¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/remote/RemoteSubredditDataSource;", "", "getDefaultSubreddits", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "after", "", "getModeratedSubreddits", "getMultireddits", "", "Lcom/reddit/frontpage/domain/model/Multireddit;", "getSubreddit", "subredditName", "getSubredditListing", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditListingDataModel;", "path", "parameters", "", "rawJson", "", "getSubscribedSubreddits", "postFavorites", "Lio/reactivex/Completable;", "makeFavorite", "", "subredditNames", "setSubscriptionState", "action", "Lcom/reddit/frontpage/domain/repository/SubredditRepository$SubredditAction;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteSubredditDataSource.kt */
public interface RemoteSubredditDataSource {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: RemoteSubredditDataSource.kt */
    public static final class DefaultImpls {
        @ListingEnveloped
        @GET(a = "subreddits/default?limit=100")
        public static /* synthetic */ Single getDefaultSubreddits$default(RemoteSubredditDataSource remoteSubredditDataSource, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDefaultSubreddits");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return remoteSubredditDataSource.getDefaultSubreddits(str);
        }

        @ListingEnveloped
        @GET(a = "subreddits/mine/subscriber?limit=100")
        public static /* synthetic */ Single getSubscribedSubreddits$default(RemoteSubredditDataSource remoteSubredditDataSource, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscribedSubreddits");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return remoteSubredditDataSource.getSubscribedSubreddits(str);
        }

        @ListingEnveloped
        @GET(a = "subreddits/mine/moderator?limit=100")
        public static /* synthetic */ Single getModeratedSubreddits$default(RemoteSubredditDataSource remoteSubredditDataSource, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getModeratedSubreddits");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            return remoteSubredditDataSource.getModeratedSubreddits(str);
        }

        @GET(a = "{subreddit_listing_path}")
        public static /* synthetic */ Single getSubredditListing$default(RemoteSubredditDataSource remoteSubredditDataSource, String str, Map map, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubredditListing");
            }
            if ((i2 & 2) != null) {
                map = MapsKt.a();
            }
            if ((i2 & 4) != 0) {
                i = 1;
            }
            return remoteSubredditDataSource.getSubredditListing(str, map, i);
        }
    }

    @ListingEnveloped
    @GET(a = "subreddits/default?limit=100")
    Single<Listing<Subreddit>> getDefaultSubreddits(@Query(a = "after") String str);

    @ListingEnveloped
    @GET(a = "subreddits/mine/moderator?limit=100")
    Single<Listing<Subreddit>> getModeratedSubreddits(@Query(a = "after") String str);

    @EnvelopeList
    @GET(a = "api/multi/mine")
    Single<List<Multireddit>> getMultireddits();

    @GET(a = "r/{subreddit}/about.json")
    @Enveloped
    Single<Subreddit> getSubreddit(@Path(a = "subreddit") String str);

    @GET(a = "{subreddit_listing_path}")
    Single<SubredditListingDataModel> getSubredditListing(@Path(a = "subreddit_listing_path", b = true) String str, @QueryMap Map<String, String> map, @Query(a = "raw_json") int i);

    @ListingEnveloped
    @GET(a = "subreddits/mine/subscriber?limit=100")
    Single<Listing<Subreddit>> getSubscribedSubreddits(@Query(a = "after") String str);

    @FormUrlEncoded
    @POST(a = "api/favorite")
    Completable postFavorites(@Field(a = "make_favorite") boolean z, @Field(a = "sr_name") String str);

    @FormUrlEncoded
    @POST(a = "api/subscribe")
    Completable setSubscriptionState(@Field(a = "sr_name") String str, @Field(a = "action") SubredditAction subredditAction);
}
