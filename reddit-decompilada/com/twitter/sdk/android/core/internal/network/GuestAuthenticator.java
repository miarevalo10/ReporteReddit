package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import okhttp3.Authenticator;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class GuestAuthenticator implements Authenticator {
    final GuestSessionProvider f30718a;

    public GuestAuthenticator(GuestSessionProvider guestSessionProvider) {
        this.f30718a = guestSessionProvider;
    }

    public Request authenticate(Route route, Response response) throws IOException {
        route = true;
        int i = 1;
        Response response2 = response;
        while (true) {
            response2 = response2.priorResponse();
            if (response2 == null) {
                break;
            }
            i++;
        }
        if (i >= 2) {
            route = null;
        }
        if (route != null) {
            route = this.f30718a;
            Headers headers = response.request().headers();
            String str = headers.get(HttpRequest.HEADER_AUTHORIZATION);
            String str2 = headers.get("x-guest-token");
            GuestSession guestSession = (str == null || str2 == null) ? null : new GuestSession(new GuestAuthToken("bearer", str.replace("bearer ", ""), str2));
            route = route.m25837a(guestSession);
            if (route == null) {
                route = null;
            } else {
                route = (GuestAuthToken) route.f23922a;
            }
            if (route != null) {
                response = response.request().newBuilder();
                GuestAuthInterceptor.m31745a(response, route);
                return response.build();
            }
        }
        return null;
    }
}
