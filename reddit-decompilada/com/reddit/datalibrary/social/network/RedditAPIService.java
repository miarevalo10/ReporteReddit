package com.reddit.datalibrary.social.network;

import com.reddit.datalibrary.social.model.ReportMessage;
import com.reddit.datalibrary.social.model.UserBriefData;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'JD\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fH'JS\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u0005j\u0002`\u00100\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0001\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0012\"\u00020\u0006H'¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/reddit/datalibrary/social/network/RedditAPIService;", "", "blockUser", "Lio/reactivex/Observable;", "headers", "", "", "userId", "reportUser", "userName", "reason", "details", "Lcom/reddit/datalibrary/social/model/ReportMessage;", "userDataByAccountIds", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/model/UserBriefData;", "Lcom/reddit/datalibrary/social/network/UserBriefDataMap;", "ids", "", "(Ljava/util/Map;[Ljava/lang/String;)Lio/reactivex/Observable;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAPIService.kt */
public interface RedditAPIService {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: RedditAPIService.kt */
    public static final class DefaultImpls {
        @POST(a = "/api/report_user")
        public static /* synthetic */ Observable reportUser$default(RedditAPIService redditAPIService, Map map, String str, String str2, ReportMessage reportMessage, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportUser");
            }
            if ((i & 8) != 0) {
                reportMessage = null;
            }
            return redditAPIService.reportUser(map, str, str2, reportMessage);
        }
    }

    @POST(a = "/api/block_user")
    Observable<Object> blockUser(@HeaderMap Map<String, String> map, @Query(a = "account_id") String str);

    @POST(a = "/api/report_user")
    Observable<Object> reportUser(@HeaderMap Map<String, String> map, @Query(a = "user") String str, @Query(a = "reason") String str2, @Query(a = "details") ReportMessage reportMessage);

    @GET(a = "/api/user_data_by_account_ids")
    Observable<Map<String, UserBriefData>> userDataByAccountIds(@HeaderMap Map<String, String> map, @Query(a = "ids") String... strArr);
}
