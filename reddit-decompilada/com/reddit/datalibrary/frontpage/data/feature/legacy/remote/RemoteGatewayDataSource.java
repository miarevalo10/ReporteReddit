package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007H'J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0007H'¨\u0006\u000f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteGatewayDataSource;", "", "appConfig", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/requests/models/config/AppConfiguration;", "headers", "", "", "deviceId", "installOrigin", "experiments", "userId", "markAllNotificationsRead", "Lio/reactivex/Completable;", "types", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteGatewayDataSource.kt */
public interface RemoteGatewayDataSource {
    @FormUrlEncoded
    @POST(a = "redditmobile/1/android/config")
    Single<AppConfiguration> appConfig(@HeaderMap Map<String, String> map, @Field(a = "device_id") String str, @Field(a = "store") String str2, @Field(a = "experiments") String str3, @Field(a = "user_id") String str4);

    @FormUrlEncoded
    @POST(a = "redditmobile/1/inbox/mark_all_read")
    Completable markAllNotificationsRead(@Field(a = "types") String str);
}
