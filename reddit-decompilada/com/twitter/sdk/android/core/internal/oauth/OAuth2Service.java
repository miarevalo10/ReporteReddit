package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.TwitterApi;
import io.fabric.sdk.android.Fabric;
import javax.net.ssl.SSLSocketFactory;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class OAuth2Service extends OAuthService {
    public OAuth2Api f30722a = ((OAuth2Api) this.f23968e.a(OAuth2Api.class));

    interface OAuth2Api {
        @FormUrlEncoded
        @POST(a = "/oauth2/token")
        @Headers(a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        Call<OAuth2Token> getAppAuthToken(@Header(a = "Authorization") String str, @Field(a = "grant_type") String str2);

        @POST(a = "/1.1/guest/activate.json")
        Call<GuestTokenResponse> getGuestToken(@Header(a = "Authorization") String str);
    }

    class C27251 extends Callback<OAuth2Token> {
        final /* synthetic */ Callback f34644a;
        final /* synthetic */ OAuth2Service f34645b;

        public C27251(OAuth2Service oAuth2Service, Callback callback) {
            this.f34645b = oAuth2Service;
            this.f34644a = callback;
        }

        public final void mo6518a(Result<OAuth2Token> result) {
            final OAuth2Token oAuth2Token = (OAuth2Token) result.f23920a;
            retrofit2.Callback c27241 = new Callback<GuestTokenResponse>(this) {
                final /* synthetic */ C27251 f34643b;

                public final void mo6518a(Result<GuestTokenResponse> result) {
                    this.f34643b.f34644a.mo6518a(new Result(new GuestAuthToken(oAuth2Token.f30723c, oAuth2Token.f30724d, ((GuestTokenResponse) result.f23920a).f23954a), null));
                }

                public final void mo6519a(TwitterException twitterException) {
                    Fabric.m26243b().mo5568c("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", twitterException);
                    this.f34643b.f34644a.mo6519a(twitterException);
                }
            };
            OAuth2Api oAuth2Api = this.f34645b.f30722a;
            StringBuilder stringBuilder = new StringBuilder("Bearer ");
            stringBuilder.append(oAuth2Token.f30724d);
            oAuth2Api.getGuestToken(stringBuilder.toString()).a(c27241);
        }

        public final void mo6519a(TwitterException twitterException) {
            Fabric.m26243b().mo5568c("Twitter", "Failed to get app auth token", twitterException);
            if (this.f34644a != null) {
                this.f34644a.mo6519a(twitterException);
            }
        }
    }

    public OAuth2Service(TwitterCore twitterCore, SSLSocketFactory sSLSocketFactory, TwitterApi twitterApi) {
        super(twitterCore, sSLSocketFactory, twitterApi);
    }
}
