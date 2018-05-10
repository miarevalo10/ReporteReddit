package com.reddit.data.events.datasource.remote;

import io.reactivex.Single;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u000bH'J<\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u000bH'¨\u0006\r"}, d2 = {"Lcom/reddit/data/events/datasource/remote/RemoteEventDataSource;", "", "postEventBatch", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "userAgent", "", "date", "signature", "body", "Lokhttp3/RequestBody;", "postTestEventBatch", "events_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteEventDataSource.kt */
public interface RemoteEventDataSource {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: RemoteEventDataSource.kt */
    public static final class DefaultImpls {
        @POST(a = "v2c")
        public static /* synthetic */ Single postTestEventBatch$default(RemoteEventDataSource remoteEventDataSource, String str, String str2, String str3, RequestBody requestBody, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postTestEventBatch");
            }
            if ((i & 2) != 0) {
                str2 = new Date().toString();
                Intrinsics.a(str2, "Date().toString()");
            }
            return remoteEventDataSource.postTestEventBatch(str, str2, str3, requestBody);
        }

        @POST(a = "https://e.reddit.com/v2c")
        public static /* synthetic */ Single postEventBatch$default(RemoteEventDataSource remoteEventDataSource, String str, String str2, String str3, RequestBody requestBody, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postEventBatch");
            }
            if ((i & 2) != 0) {
                str2 = new Date().toString();
                Intrinsics.a(str2, "Date().toString()");
            }
            return remoteEventDataSource.postEventBatch(str, str2, str3, requestBody);
        }
    }

    @POST(a = "https://e.reddit.com/v2c")
    Single<Response<ResponseBody>> postEventBatch(@Header(a = "User-Agent") String str, @Header(a = "Date") String str2, @Header(a = "X-Signature") String str3, @Body RequestBody requestBody);

    @POST(a = "v2c")
    Single<Response<ResponseBody>> postTestEventBatch(@Header(a = "User-Agent") String str, @Header(a = "Date") String str2, @Header(a = "X-Signature") String str3, @Body RequestBody requestBody);
}
