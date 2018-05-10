package com.reddit.datalibrary.social.network;

import com.google.gson.JsonElement;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H'¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/social/network/GatewayAPIService;", "", "androidConfig", "Lio/reactivex/Observable;", "Lcom/google/gson/JsonElement;", "headers", "", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GatewayAPIService.kt */
public interface GatewayAPIService {
    @GET(a = "/android/config")
    Observable<JsonElement> androidConfig(@HeaderMap Map<String, String> map);
}
