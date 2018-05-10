package com.twitter.sdk.android.core.internal.oauth;

import android.net.Uri;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.TwitterApi;
import io.fabric.sdk.android.services.network.UrlUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class OAuth1aService extends OAuthService {
    public OAuthApi f30721a = ((OAuthApi) this.f23968e.a(OAuthApi.class));

    interface OAuthApi {
        @POST(a = "/oauth/access_token")
        Call<ResponseBody> getAccessToken(@Header(a = "Authorization") String str, @Query(a = "oauth_verifier") String str2);

        @POST(a = "/oauth/request_token")
        Call<ResponseBody> getTempToken(@Header(a = "Authorization") String str);
    }

    public OAuth1aService(TwitterCore twitterCore, SSLSocketFactory sSLSocketFactory, TwitterApi twitterApi) {
        super(twitterCore, sSLSocketFactory, twitterApi);
    }

    public final String m31748a(TwitterAuthConfig twitterAuthConfig) {
        return Uri.parse("twittersdk://callback").buildUpon().appendQueryParameter("version", this.f23965b.getVersion()).appendQueryParameter("app", twitterAuthConfig.f23926a).build().toString();
    }

    public static OAuthResponse m31746a(String str) {
        str = UrlUtils.m26422a(str, false);
        String str2 = (String) str.get("oauth_token");
        String str3 = (String) str.get("oauth_token_secret");
        String str4 = (String) str.get("screen_name");
        long parseLong = str.containsKey("user_id") ? Long.parseLong((String) str.get("user_id")) : 0;
        if (str2 != null) {
            if (str3 != null) {
                return new OAuthResponse(new TwitterAuthToken(str2, str3), str4, parseLong);
            }
        }
        return null;
    }

    public final Callback<ResponseBody> m31747a(final Callback<OAuthResponse> callback) {
        return new Callback<ResponseBody>(this) {
            final /* synthetic */ OAuth1aService f34641b;

            public final void mo6518a(Result<ResponseBody> result) {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(((ResponseBody) result.f23920a).byteStream()));
                    while (true) {
                        try {
                            result = bufferedReader2.readLine();
                            if (result != null) {
                                stringBuilder.append(result);
                            } else {
                                try {
                                    break;
                                } catch (Result<ResponseBody> result2) {
                                    callback.mo6519a(new TwitterAuthException(result2.getMessage(), result2));
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            result2 = th;
                            bufferedReader = bufferedReader2;
                        }
                    }
                    bufferedReader2.close();
                    String stringBuilder2 = stringBuilder.toString();
                    OAuthResponse a = OAuth1aService.m31746a(stringBuilder2);
                    if (a == null) {
                        Callback callback = callback;
                        StringBuilder stringBuilder3 = new StringBuilder("Failed to parse auth response: ");
                        stringBuilder3.append(stringBuilder2);
                        callback.mo6519a(new TwitterAuthException(stringBuilder3.toString()));
                        return;
                    }
                    callback.mo6518a(new Result(a, null));
                } catch (Throwable th2) {
                    result2 = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw result2;
                }
            }

            public final void mo6519a(TwitterException twitterException) {
                callback.mo6519a(twitterException);
            }
        };
    }
}
