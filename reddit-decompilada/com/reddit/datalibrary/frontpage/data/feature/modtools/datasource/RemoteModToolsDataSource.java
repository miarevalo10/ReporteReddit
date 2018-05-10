package com.reddit.datalibrary.frontpage.data.feature.modtools.datasource;

import com.reddit.datalibrary.frontpage.data.feature.modtools.repo.RedditModToolsRepository.ModToolsActionType;
import com.reddit.datalibrary.frontpage.data.model.ApprovedSubmittersResponse;
import com.reddit.datalibrary.frontpage.data.model.BannedUsersResponse;
import com.reddit.datalibrary.frontpage.data.model.ModToolsPostResponse;
import com.reddit.datalibrary.frontpage.data.model.ModeratorsResponse;
import com.reddit.datalibrary.frontpage.data.model.MutedUsersResponse;
import com.reddit.datalibrary.frontpage.data.model.SubredditRulesResponse;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'J8\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006H'J?\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010H'¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0006H'J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u0019H'J4\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'J.\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0006H'J$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0006H'J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0006H'J$\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0006H'J$\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0006H'J\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J.\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'JD\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006H'J2\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010,\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'J4\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'J2\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0001\u00100\u001a\u00020\u00062\b\b\u0001\u00101\u001a\u00020\u0006H'J\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'J\"\u00103\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'J\"\u00104\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'J\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'J\"\u00106\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'J2\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010,\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'J2\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010,\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u00069"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/modtools/datasource/RemoteModToolsDataSource;", "", "acceptModInvite", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsPostResponse;", "subreddit", "", "params", "", "addApprovedSubmitter", "username", "type", "Lcom/reddit/datalibrary/frontpage/data/feature/modtools/repo/RedditModToolsRepository$ModToolsActionType;", "apiType", "banUser", "duration", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)Lio/reactivex/Single;", "blockUser", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "accountId", "bulkModActions", "action", "ids", "Lokhttp3/RequestBody;", "declineModInvite", "editModerator", "getAllModerators", "Lcom/reddit/datalibrary/frontpage/data/model/ModeratorsResponse;", "after", "getApprovedSubmitters", "Lcom/reddit/datalibrary/frontpage/data/model/ApprovedSubmittersResponse;", "getBannedUsers", "Lcom/reddit/datalibrary/frontpage/data/model/BannedUsersResponse;", "getEditableModerators", "getMutedUsers", "Lcom/reddit/datalibrary/frontpage/data/model/MutedUsersResponse;", "getSubredditRules", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRulesResponse;", "inviteModerator", "muteUser", "modNote", "removeApprovedSubmitter", "id", "removeModerator", "report", "thingId", "reason", "siteReason", "searchAllModerators", "searchApprovedSubmitters", "searchBannedUser", "searchEditableModerators", "searchMutedUser", "unbanUser", "unmuteUser", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteModToolsDataSource.kt */
public interface RemoteModToolsDataSource {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: RemoteModToolsDataSource.kt */
    public static final class DefaultImpls {
        @GET(a = "/api/v1/{subreddit}/banned.json")
        public static /* synthetic */ Single getBannedUsers$default(RemoteModToolsDataSource remoteModToolsDataSource, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBannedUsers");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return remoteModToolsDataSource.getBannedUsers(str, str2);
        }

        @FormUrlEncoded
        @POST(a = "/r/{subreddit}/api/friend")
        public static /* synthetic */ Single banUser$default(RemoteModToolsDataSource remoteModToolsDataSource, String str, Map map, Long l, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: banUser");
            }
            if ((i & 4) != 0) {
                l = null;
            }
            return remoteModToolsDataSource.banUser(str, map, l);
        }

        @GET(a = "/api/v1/{subreddit}/contributors.json")
        public static /* synthetic */ Single getApprovedSubmitters$default(RemoteModToolsDataSource remoteModToolsDataSource, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getApprovedSubmitters");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return remoteModToolsDataSource.getApprovedSubmitters(str, str2);
        }

        @FormUrlEncoded
        @POST(a = "/r/{subreddit}/api/friend")
        public static /* synthetic */ Single addApprovedSubmitter$default(RemoteModToolsDataSource remoteModToolsDataSource, String str, String str2, ModToolsActionType modToolsActionType, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addApprovedSubmitter");
            }
            if ((i & 8) != 0) {
                str3 = "json";
            }
            return remoteModToolsDataSource.addApprovedSubmitter(str, str2, modToolsActionType, str3);
        }

        @GET(a = "/api/v1/{subreddit}/muted.json")
        public static /* synthetic */ Single getMutedUsers$default(RemoteModToolsDataSource remoteModToolsDataSource, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMutedUsers");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return remoteModToolsDataSource.getMutedUsers(str, str2);
        }

        @FormUrlEncoded
        @POST(a = "/r/{subreddit}/api/friend")
        public static /* synthetic */ Single muteUser$default(RemoteModToolsDataSource remoteModToolsDataSource, String str, String str2, String str3, ModToolsActionType modToolsActionType, String str4, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: muteUser");
            }
            if ((i & 4) != null) {
                str3 = null;
            }
            String str5 = str3;
            if ((i & 16) != null) {
                str4 = "json";
            }
            return remoteModToolsDataSource.muteUser(str, str2, str5, modToolsActionType, str4);
        }

        @GET(a = "/api/v1/{subreddit}/moderators.json")
        public static /* synthetic */ Single getAllModerators$default(RemoteModToolsDataSource remoteModToolsDataSource, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllModerators");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return remoteModToolsDataSource.getAllModerators(str, str2);
        }

        @GET(a = "/api/v1/{subreddit}/moderators_editable.json")
        public static /* synthetic */ Single getEditableModerators$default(RemoteModToolsDataSource remoteModToolsDataSource, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEditableModerators");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return remoteModToolsDataSource.getEditableModerators(str, str2);
        }
    }

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/accept_moderator_invite")
    Single<ModToolsPostResponse> acceptModInvite(@Path(a = "subreddit") String str, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/friend")
    Single<ModToolsPostResponse> addApprovedSubmitter(@Path(a = "subreddit") String str, @Field(a = "name") String str2, @Field(a = "type") ModToolsActionType modToolsActionType, @Field(a = "api_type") String str3);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/friend")
    Single<ModToolsPostResponse> banUser(@Path(a = "subreddit") String str, @FieldMap Map<String, String> map, @Field(a = "duration") Long l);

    @POST(a = "api/block_user")
    Single<Response<ResponseBody>> blockUser(@Query(a = "account_id") String str);

    @POST(a = "/api/v1/modactions/{action}")
    @Headers(a = {"Content-Type: application/json"})
    Single<ModToolsPostResponse> bulkModActions(@Path(a = "action") String str, @Body RequestBody requestBody);

    @FormUrlEncoded
    @POST(a = "/api/v1/{subreddit}/decline_mod_invite")
    Single<Response<ResponseBody>> declineModInvite(@Path(a = "subreddit") String str, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/setpermissions.json")
    Single<ModToolsPostResponse> editModerator(@Path(a = "subreddit") String str, @FieldMap Map<String, String> map);

    @GET(a = "/api/v1/{subreddit}/moderators.json")
    Single<ModeratorsResponse> getAllModerators(@Path(a = "subreddit") String str, @Query(a = "after") String str2);

    @GET(a = "/api/v1/{subreddit}/contributors.json")
    Single<ApprovedSubmittersResponse> getApprovedSubmitters(@Path(a = "subreddit") String str, @Query(a = "after") String str2);

    @GET(a = "/api/v1/{subreddit}/banned.json")
    Single<BannedUsersResponse> getBannedUsers(@Path(a = "subreddit") String str, @Query(a = "after") String str2);

    @GET(a = "/api/v1/{subreddit}/moderators_editable.json")
    Single<ModeratorsResponse> getEditableModerators(@Path(a = "subreddit") String str, @Query(a = "after") String str2);

    @GET(a = "/api/v1/{subreddit}/muted.json")
    Single<MutedUsersResponse> getMutedUsers(@Path(a = "subreddit") String str, @Query(a = "after") String str2);

    @GET(a = "/r/{subreddit}/about/rules")
    Single<SubredditRulesResponse> getSubredditRules(@Path(a = "subreddit") String str);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/friend.json")
    Single<ModToolsPostResponse> inviteModerator(@Path(a = "subreddit") String str, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/friend")
    Single<ModToolsPostResponse> muteUser(@Path(a = "subreddit") String str, @Field(a = "name") String str2, @Field(a = "note") String str3, @Field(a = "type") ModToolsActionType modToolsActionType, @Field(a = "api_type") String str4);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/unfriend")
    Single<Response<ResponseBody>> removeApprovedSubmitter(@Path(a = "subreddit") String str, @Field(a = "id") String str2, @Field(a = "type") ModToolsActionType modToolsActionType);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/unfriend.json")
    Single<Response<ResponseBody>> removeModerator(@Path(a = "subreddit") String str, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST(a = "api/report")
    Single<Response<ResponseBody>> report(@Field(a = "thing_id") String str, @Field(a = "reason") String str2, @Field(a = "site_reason") String str3);

    @GET(a = "/api/v1/{subreddit}/moderators.json")
    Single<ModeratorsResponse> searchAllModerators(@Path(a = "subreddit") String str, @Query(a = "username") String str2);

    @GET(a = "/api/v1/{subreddit}/contributors.json")
    Single<ApprovedSubmittersResponse> searchApprovedSubmitters(@Path(a = "subreddit") String str, @Query(a = "username") String str2);

    @GET(a = "/api/v1/{subreddit}/banned.json")
    Single<BannedUsersResponse> searchBannedUser(@Path(a = "subreddit") String str, @Query(a = "username") String str2);

    @GET(a = "/api/v1/{subreddit}/moderators.json")
    Single<ModeratorsResponse> searchEditableModerators(@Path(a = "subreddit") String str, @Query(a = "username") String str2);

    @GET(a = "/api/v1/{subreddit}/muted.json")
    Single<MutedUsersResponse> searchMutedUser(@Path(a = "subreddit") String str, @Query(a = "username") String str2);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/unfriend")
    Single<Response<ResponseBody>> unbanUser(@Path(a = "subreddit") String str, @Field(a = "id") String str2, @Field(a = "type") ModToolsActionType modToolsActionType);

    @FormUrlEncoded
    @POST(a = "/r/{subreddit}/api/unfriend")
    Single<Response<ResponseBody>> unmuteUser(@Path(a = "subreddit") String str, @Field(a = "id") String str2, @Field(a = "type") ModToolsActionType modToolsActionType);
}
