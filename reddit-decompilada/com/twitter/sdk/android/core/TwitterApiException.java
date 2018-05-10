package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.models.ApiError;
import com.twitter.sdk.android.core.models.ApiErrors;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import io.fabric.sdk.android.Fabric;
import retrofit2.Response;

public class TwitterApiException extends TwitterException {
    public final ApiError f30687a;
    private final TwitterRateLimit f30688b;
    private final int f30689c;
    private final Response f30690d;

    public TwitterApiException(Response response) {
        this(response, m31718a(response), new TwitterRateLimit(response.a.headers()), response.a.code());
    }

    private static ApiError m31717a(String str) {
        try {
            ApiErrors apiErrors = (ApiErrors) new GsonBuilder().a(new SafeListAdapter()).a(new SafeMapAdapter()).a().a(str, ApiErrors.class);
            if (!apiErrors.f24024a.isEmpty()) {
                return (ApiError) apiErrors.f24024a.get(0);
            }
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Invalid json: ");
            stringBuilder.append(str);
            Fabric.m26243b().mo5568c("Twitter", stringBuilder.toString(), e);
        }
        return null;
    }

    private TwitterApiException(Response response, ApiError apiError, TwitterRateLimit twitterRateLimit, int i) {
        StringBuilder stringBuilder = new StringBuilder("HTTP request failed, Status: ");
        stringBuilder.append(i);
        super(stringBuilder.toString());
        this.f30687a = apiError;
        this.f30688b = twitterRateLimit;
        this.f30689c = i;
        this.f30690d = response;
    }

    private static ApiError m31718a(Response response) {
        try {
            String p = response.c.source().mo6754a().m36541v().m36535p();
            if (!TextUtils.isEmpty(p)) {
                return m31717a(p);
            }
        } catch (Response response2) {
            Fabric.m26243b().mo5568c("Twitter", "Unexpected response", response2);
        }
        return null;
    }
}
