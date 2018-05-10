package com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote;

import com.reddit.datalibrary.frontpage.data.common.converter.FrontpageListingEnveloped;
import com.reddit.datalibrary.frontpage.data.common.converter.ListingEnveloped;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.CreateEditLinkResponse;
import com.reddit.frontpage.domain.model.ILink;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import io.reactivex.Completable;
import io.reactivex.Single;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H'J8\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00062\u0014\b\u0003\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\b\b\u0003\u0010\u000e\u001a\u00020\u000fH'JZ\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0019\u001a\u00020\u001a2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001cH'J4\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00110\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020 2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0006H'J6\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00110\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00062\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0006H'J\u001e\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00110\u00032\b\b\u0001\u0010#\u001a\u00020\u0006H'JX\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00110\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0019\u001a\u00020\u001a2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001cH'J@\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00110\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u00062\b\b\u0003\u0010\u0013\u001a\u00020\u00142\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'J\u0012\u0010&\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u0006H'J&\u0010)\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u00062\b\b\u0001\u0010*\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020\u001aH'J\u0012\u0010-\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u0006H'J\u0012\u0010.\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u0006H'J\u0012\u0010/\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u0006H'J\u001c\u00100\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u00062\b\b\u0001\u00101\u001a\u00020\u001aH'J\u0012\u00102\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u0006H'J\u0012\u00103\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u0006H'J\u0012\u00104\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u0006H'J\u0012\u00105\u001a\u00020'2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u001c\u00106\u001a\u00020'2\b\b\u0001\u0010(\u001a\u00020\u00062\b\b\u0001\u00107\u001a\u00020\u001aH'J\u0012\u00108\u001a\u00020'2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u00069"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/RemoteLinkDatasource;", "", "edit", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/CreateEditLinkResponse;", "kindWithId", "", "text", "apiType", "getDiscoveryUnitListing", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel;", "path", "options", "", "rawJson", "", "getFrontpageLinks", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/ILink;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "after", "dist", "withAds", "", "layout", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "getHistoryListing", "Lcom/reddit/frontpage/domain/model/Link;", "username", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "getLinkListing", "getLinksByIds", "kindWithIds", "getPopularLinks", "getUserSubmittedPosts", "modApprove", "Lio/reactivex/Completable;", "id", "modDistinguish", "how", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;", "sticky", "modLockComments", "modMarkNsfw", "modMarkSpoiler", "modRemove", "spam", "modUnMarkNsfw", "modUnMarkSpoiler", "modUnlockComments", "save", "setSubredditSticky", "state", "unsave", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteLinkDatasource.kt */
public interface RemoteLinkDatasource {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: RemoteLinkDatasource.kt */
    public static final class DefaultImpls {
        @FrontpageListingEnveloped
        @GET(a = "https://gateway.reddit.com/redditmobile/1/mainfeed")
        public static /* synthetic */ Single getFrontpageLinks$default(RemoteLinkDatasource remoteLinkDatasource, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, ListingViewMode listingViewMode, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFrontpageLinks");
            }
            if ((i & 1) != null) {
                sortType = null;
            }
            if ((i & 2) != null) {
                sortTimeFrame = null;
            }
            if ((i & 4) != null) {
                str = null;
            }
            if ((i & 8) != null) {
                str2 = null;
            }
            if ((i & 16) != null) {
                z = true;
            }
            if ((i & 32) != 0) {
                listingViewMode = null;
            }
            return remoteLinkDatasource.getFrontpageLinks(sortType, sortTimeFrame, str, str2, z, listingViewMode);
        }

        @ListingEnveloped
        @GET(a = "r/popular/{sort}")
        public static /* synthetic */ Single getPopularLinks$default(RemoteLinkDatasource remoteLinkDatasource, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, ListingViewMode listingViewMode, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPopularLinks");
            }
            if ((i & 1) != null) {
                sortType = SortType.f15830c;
            }
            ListingViewMode listingViewMode2 = null;
            String str3 = (i & 2) != null ? null : sortTimeFrame;
            String str4 = (i & 4) != null ? null : str;
            String str5 = (i & 8) != null ? null : str2;
            if ((i & 16) != null) {
                z = true;
            }
            boolean z2 = z;
            if ((i & 32) == null) {
                listingViewMode2 = listingViewMode;
            }
            return remoteLinkDatasource.getPopularLinks(sortType, str3, str4, str5, z2, listingViewMode2);
        }

        @ListingEnveloped
        @GET(a = "{link_listing_path}")
        public static /* synthetic */ Single getLinkListing$default(RemoteLinkDatasource remoteLinkDatasource, String str, SortTimeFrame sortTimeFrame, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLinkListing");
            }
            if ((i & 2) != null) {
                sortTimeFrame = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return remoteLinkDatasource.getLinkListing(str, sortTimeFrame, str2);
        }

        @GET(a = "{path}")
        public static /* synthetic */ Single getDiscoveryUnitListing$default(RemoteLinkDatasource remoteLinkDatasource, String str, Map map, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDiscoveryUnitListing");
            }
            if ((i2 & 2) != null) {
                map = MapsKt.a();
            }
            if ((i2 & 4) != 0) {
                i = 1;
            }
            return remoteLinkDatasource.getDiscoveryUnitListing(str, map, i);
        }

        @ListingEnveloped
        @GET(a = "user/{username}/submitted/{sort}")
        public static /* synthetic */ Single getUserSubmittedPosts$default(RemoteLinkDatasource remoteLinkDatasource, String str, SortType sortType, String str2, SortTimeFrame sortTimeFrame, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserSubmittedPosts");
            }
            if ((i & 2) != null) {
                sortType = SortType.f15833f;
            }
            if ((i & 4) != null) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                sortTimeFrame = null;
            }
            return remoteLinkDatasource.getUserSubmittedPosts(str, sortType, str2, sortTimeFrame);
        }

        @ListingEnveloped
        @GET(a = "user/{username}/{type}")
        public static /* synthetic */ Single getHistoryListing$default(RemoteLinkDatasource remoteLinkDatasource, String str, HistorySortType historySortType, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHistoryListing");
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return remoteLinkDatasource.getHistoryListing(str, historySortType, str2);
        }

        @FormUrlEncoded
        @POST(a = "api/editusertext")
        public static /* synthetic */ Single edit$default(RemoteLinkDatasource remoteLinkDatasource, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: edit");
            }
            if ((i & 4) != 0) {
                str3 = "json";
            }
            return remoteLinkDatasource.edit(str, str2, str3);
        }
    }

    @FormUrlEncoded
    @POST(a = "api/editusertext")
    Single<CreateEditLinkResponse> edit(@Field(a = "thing_id") String str, @Field(a = "text") String str2, @Field(a = "api_type") String str3);

    @GET(a = "{path}")
    Single<DiscoveryUnitListingDataModel> getDiscoveryUnitListing(@Path(a = "path", b = true) String str, @QueryMap Map<String, String> map, @Query(a = "raw_json") int i);

    @FrontpageListingEnveloped
    @GET(a = "https://gateway.reddit.com/redditmobile/1/mainfeed")
    Single<Listing<ILink>> getFrontpageLinks(@Query(a = "sort") SortType sortType, @Query(a = "t") SortTimeFrame sortTimeFrame, @Query(a = "after") String str, @Query(a = "dist") String str2, @Query(a = "withAds") boolean z, @Query(a = "layout") ListingViewMode listingViewMode);

    @ListingEnveloped
    @GET(a = "user/{username}/{type}")
    Single<Listing<Link>> getHistoryListing(@Path(a = "username") String str, @Path(a = "type") HistorySortType historySortType, @Query(a = "after") String str2);

    @ListingEnveloped
    @GET(a = "{link_listing_path}")
    Single<Listing<Link>> getLinkListing(@Path(a = "link_listing_path", b = true) String str, @Query(a = "t") SortTimeFrame sortTimeFrame, @Query(a = "after") String str2);

    @ListingEnveloped
    @GET(a = "by_id/{kindWithIds}")
    Single<Listing<Link>> getLinksByIds(@Path(a = "kindWithIds") String str);

    @ListingEnveloped
    @GET(a = "r/popular/{sort}")
    Single<Listing<Link>> getPopularLinks(@Path(a = "sort") SortType sortType, @Query(a = "t") SortTimeFrame sortTimeFrame, @Query(a = "after") String str, @Query(a = "dist") String str2, @Query(a = "withAds") boolean z, @Query(a = "layout") ListingViewMode listingViewMode);

    @ListingEnveloped
    @GET(a = "user/{username}/submitted/{sort}")
    Single<Listing<Link>> getUserSubmittedPosts(@Path(a = "username") String str, @Path(a = "sort") SortType sortType, @Query(a = "after") String str2, @Query(a = "t") SortTimeFrame sortTimeFrame);

    @POST(a = "/api/approve")
    Completable modApprove(@Query(a = "id") String str);

    @FormUrlEncoded
    @POST(a = "api/distinguish")
    Completable modDistinguish(@Query(a = "id") String str, @Query(a = "how") DistinguishType distinguishType, @Field(a = "sticky") boolean z);

    @POST(a = "/api/lock")
    Completable modLockComments(@Query(a = "id") String str);

    @POST(a = "api/marknsfw")
    Completable modMarkNsfw(@Query(a = "id") String str);

    @POST(a = "api/spoiler")
    Completable modMarkSpoiler(@Query(a = "id") String str);

    @POST(a = "/api/remove")
    Completable modRemove(@Query(a = "id") String str, @Query(a = "spam") boolean z);

    @POST(a = "api/unmarknsfw")
    Completable modUnMarkNsfw(@Query(a = "id") String str);

    @POST(a = "/api/unspoiler")
    Completable modUnMarkSpoiler(@Query(a = "id") String str);

    @POST(a = "/api/unlock")
    Completable modUnlockComments(@Query(a = "id") String str);

    @POST(a = "/api/save")
    Completable save(@Query(a = "id") String str);

    @POST(a = "api/set_subreddit_sticky")
    Completable setSubredditSticky(@Query(a = "id") String str, @Query(a = "state") boolean z);

    @POST(a = "/api/unsave")
    Completable unsave(@Query(a = "id") String str);
}
