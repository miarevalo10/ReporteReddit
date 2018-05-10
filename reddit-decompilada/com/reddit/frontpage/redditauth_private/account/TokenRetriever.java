package com.reddit.frontpage.redditauth_private.account;

import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.RedirectError;
import com.android.volley.Request.Priority;
import com.android.volley.VolleyError;
import com.instabug.library.model.State;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.account.AuthUtil;
import com.reddit.datalibrary.frontpage.redditauth.api.InterceptingRequestBuilder;
import com.reddit.datalibrary.frontpage.redditauth.api.InterceptingRequestBuilder.OnInterceptListener;
import com.reddit.datalibrary.frontpage.redditauth.api.RedditAuthClient;
import com.reddit.datalibrary.frontpage.redditauth.api.SignedRequestBuilder;
import com.reddit.datalibrary.frontpage.redditauth.api.errors.LoginError;
import com.reddit.datalibrary.frontpage.redditauth.models.AccessTokenResponse;
import com.reddit.datalibrary.frontpage.redditauth.models.LoginResponse;
import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.List;
import java.util.UUID;
import timber.log.Timber;

public class TokenRetriever {

    public static class TokenRetrievalError extends Exception {
        final boolean f21012a;

        public TokenRetrievalError(Throwable th, boolean z) {
            super(th);
            this.f21012a = z;
        }

        public TokenRetrievalError(Throwable th) {
            this(th, false);
        }

        public TokenRetrievalError(String str) {
            super(str);
            this.f21012a = null;
        }
    }

    private static Credentials m23227a(RedditAuthClient redditAuthClient, Scope scope, LoginResponse loginResponse) throws TokenRetrievalError {
        loginResponse = loginResponse.getJson();
        List errors = loginResponse.getErrors();
        if (errors == null || errors.isEmpty()) {
            loginResponse = loginResponse.getData();
            Object cookie = loginResponse.getCookie();
            if (TextUtils.isEmpty(cookie)) {
                return null;
            }
            try {
                String a = AuthUtil.a(cookie);
                String modhash = loginResponse.getModhash();
                redditAuthClient = m23226a(redditAuthClient, a, modhash, scope);
                Credentials credentials = new Credentials(a, modhash, redditAuthClient.getAccessToken(), redditAuthClient.getRefreshToken());
                Timber.b("cookie: %s, modhash: %s, token: %s, refreshtoken: %s", new Object[]{a, modhash, scope, redditAuthClient});
                return credentials;
            } catch (Throwable e) {
                throw new TokenRetrievalError(e);
            }
        }
        throw new TokenRetrievalError(new LoginError((List) errors.get(0)));
    }

    public static AccessTokenResponse m23226a(RedditAuthClient redditAuthClient, String str, String str2, Scope scope) throws TokenRetrievalError {
        String uuid = UUID.randomUUID().toString();
        try {
            new RequestBuilder(redditAuthClient.a, Object.class).a(1).a("api/v1/authorize").c("Cookie", str).c("X-Modhash", str2).b("client_id", Config.c).b("redirect_uri", Config.e).b("scope", scope.toString()).b("state", uuid).b(State.KEY_DURATION, "permanent").b("authorize", "allow").b("response_type", "code").b();
            str = null;
        } catch (Throwable e) {
            str2 = e.getCause();
            if ((str2 instanceof RedirectError) == null) {
                throw new TokenRetrievalError(e);
            }
            str = ((RedirectError) str2).a;
        } catch (Throwable e2) {
            throw new TokenRetrievalError(e2);
        }
        if (str == null || str.a == 302) {
            str = Uri.parse((String) str.c.get(HttpRequest.HEADER_LOCATION));
            Timber.b("parsedLocation=%s", new Object[]{str});
            if (uuid.equals(str.getQueryParameter("state"))) {
                scope = str.getQueryParameter("code");
                if (scope == null) {
                    redditAuthClient = str.getQueryParameter("error");
                    uuid = "No code in redirect url: %s%s";
                    Object[] objArr = new Object[2];
                    objArr[0] = str;
                    if (redditAuthClient != null) {
                        redditAuthClient = String.format(", Detected error: %s", new Object[]{redditAuthClient});
                    } else {
                        redditAuthClient = "";
                    }
                    objArr[1] = redditAuthClient;
                    throw new TokenRetrievalError(String.format(uuid, objArr));
                }
                try {
                    return (AccessTokenResponse) new RequestBuilder(redditAuthClient.a, AccessTokenResponse.class).a(Priority.d).a(1).a("api/v1/access_token").c(HttpRequest.HEADER_AUTHORIZATION, AuthUtil.a(Config.c, Config.d)).b("grant_type", "authorization_code").b("code", scope).b("device_id", Config.g).b("redirect_uri", Config.e).b();
                } catch (Throwable e22) {
                    throw new TokenRetrievalError(e22);
                }
            }
            throw new TokenRetrievalError(String.format("State mismatch: expected %s but got %s", new Object[]{uuid, str.getQueryParameter("state")}));
        }
        throw new TokenRetrievalError(String.format("Did not get a redirect: statusCode=%d", new Object[]{Integer.valueOf(str.a)}));
    }

    public static Credentials m23229a(RedditAuthClient redditAuthClient, String str, String str2, String str3) throws TokenRetrievalError {
        try {
            str = ((LoginResponse) new SignedRequestBuilder(redditAuthClient.a, LoginResponse.class).a(1).a("api/v1/register").b("user", str).b("passwd", str2).b("passwd2", str2).b(State.KEY_EMAIL, str3).b("rem", "true").b("api_type", "json").b()).getJson();
            str2 = str.getErrors();
            if (str2 == null || str2.isEmpty()) {
                str = str.getData();
                try {
                    str2 = AuthUtil.a(str.getCookie());
                    str = str.getModhash();
                    redditAuthClient = m23226a(redditAuthClient, str2, str, Scope.WILD_SCOPE);
                    Credentials credentials = new Credentials(str2, str, redditAuthClient.getAccessToken(), redditAuthClient.getRefreshToken());
                    Timber.b("cookie: %s, modhash: %s, token: %s, refreshtoken: %s", new Object[]{str2, str, r0, redditAuthClient});
                    return credentials;
                } catch (Throwable e) {
                    throw new TokenRetrievalError(e);
                }
            }
            throw new TokenRetrievalError(new LoginError((List) str2.get(0)));
        } catch (Throwable e2) {
            throw new TokenRetrievalError(e2);
        }
    }

    public static Credentials m23228a(RedditAuthClient redditAuthClient, String str, String str2, OnInterceptListener onInterceptListener, Scope scope) throws TokenRetrievalError {
        try {
            RequestBuilder interceptingRequestBuilder = new InterceptingRequestBuilder(redditAuthClient.a, LoginResponse.class, onInterceptListener);
            RedditAuthClient.a(interceptingRequestBuilder, str, str2);
            return m23227a(redditAuthClient, scope, (LoginResponse) interceptingRequestBuilder.b());
        } catch (Throwable e) {
            throw new TokenRetrievalError(e);
        }
    }

    public static Credentials m23230a(RedditAuthClient redditAuthClient, String str, String str2, String str3, Scope scope) throws TokenRetrievalError {
        try {
            RequestBuilder signedRequestBuilder = new SignedRequestBuilder(redditAuthClient.a, LoginResponse.class);
            RedditAuthClient.a(signedRequestBuilder, str, str2);
            signedRequestBuilder.b("otp", str3);
            return m23227a(redditAuthClient, scope, (LoginResponse) signedRequestBuilder.b());
        } catch (Throwable e) {
            throw new TokenRetrievalError(e);
        }
    }

    public static AccessTokenResponse m23225a(RedditAuthClient redditAuthClient, String str) throws TokenRetrievalError {
        try {
            return (AccessTokenResponse) new RequestBuilder(redditAuthClient.a, AccessTokenResponse.class).a(Priority.d).a(1).a("api/v1/access_token").c(HttpRequest.HEADER_AUTHORIZATION, AuthUtil.a(Config.c, Config.d)).b("grant_type", "refresh_token").b("device_id", Config.g).b("refresh_token", str).b();
        } catch (RedditAuthClient redditAuthClient2) {
            boolean z = false;
            if ((redditAuthClient2.getCause() instanceof VolleyError) != null) {
                str = ((VolleyError) redditAuthClient2.getCause()).a;
                str = str != null ? str.a : null;
                if (str >= 400 && str < 500) {
                    z = true;
                }
            }
            throw new TokenRetrievalError(redditAuthClient2, z);
        } catch (Throwable e) {
            throw new TokenRetrievalError(e);
        }
    }
}
