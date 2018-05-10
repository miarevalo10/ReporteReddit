package com.reddit.datalibrary.frontpage.data.feature.account.datasource.remote;

import com.reddit.datalibrary.frontpage.data.common.converter.Enveloped;
import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.datalibrary.frontpage.data.model.DefaultAvatar;
import com.reddit.datalibrary.frontpage.data.model.ProfileSettings;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\u00062\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\t\u001a\u00020\u0006H'J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\t\u001a\u00020\u0006H'J4\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00140\u00032\b\b\u0001\u0010\t\u001a\u00020\u00062\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH'J\u0012\u0010\u0015\u001a\u00020\u00122\b\b\u0001\u0010\u0016\u001a\u00020\u0017H'J\u001e\u0010\u0018\u001a\u00020\u00122\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH'¨\u0006\u0019"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/remote/RemoteAccountDataSource;", "", "getAccount", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "username", "", "getFileUploadLease", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FileUploadLease;", "userSubredditDisplayName", "params", "", "getMyAccount", "getUserSubredditSettings", "Lokhttp3/ResponseBody;", "removeAvatar", "Lcom/reddit/datalibrary/frontpage/data/model/DefaultAvatar;", "removeBanner", "Lio/reactivex/Completable;", "updateImage", "Lretrofit2/Response;", "updateShowingActiveCommunities", "body", "Lcom/reddit/datalibrary/frontpage/data/model/ProfileSettings;", "updateUserSubredditSettings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteAccountDataSource.kt */
public interface RemoteAccountDataSource {
    @GET(a = "user/{username}/about.json")
    @Enveloped
    Single<Account> getAccount(@Path(a = "username") String str);

    @FormUrlEncoded
    @POST(a = "/api/v1/style_asset_upload_s3/{user_subreddit_display_name}")
    Single<FileUploadLease> getFileUploadLease(@Path(a = "user_subreddit_display_name") String str, @FieldMap Map<String, String> map);

    @GET(a = "api/v1/me")
    Single<Account> getMyAccount();

    @GET(a = "/r/{user_subreddit_display_name}/about/edit")
    Single<ResponseBody> getUserSubredditSettings(@Path(a = "user_subreddit_display_name") String str);

    @POST(a = "/r/{user_subreddit_display_name}/api/delete_sr_icon")
    Single<DefaultAvatar> removeAvatar(@Path(a = "user_subreddit_display_name") String str);

    @POST(a = "/r/{user_subreddit_display_name}/api/delete_sr_banner")
    Completable removeBanner(@Path(a = "user_subreddit_display_name") String str);

    @FormUrlEncoded
    @PATCH(a = "api/v1/structured_styles/{user_subreddit_display_name}")
    Single<Response<ResponseBody>> updateImage(@Path(a = "user_subreddit_display_name") String str, @FieldMap(a = true) Map<String, String> map);

    @PATCH(a = "/api/v1/me/prefs")
    Completable updateShowingActiveCommunities(@Body ProfileSettings profileSettings);

    @FormUrlEncoded
    @POST(a = "/api/site_admin")
    Completable updateUserSubredditSettings(@FieldMap Map<String, String> map);
}
