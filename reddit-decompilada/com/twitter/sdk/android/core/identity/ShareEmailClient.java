package com.twitter.sdk.android.core.identity;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

class ShareEmailClient extends TwitterApiClient {

    interface EmailService {
        @GET(a = "/1.1/account/verify_credentials.json?include_email=true")
        Call<User> verifyCredentials(@Query(a = "include_entities") Boolean bool, @Query(a = "skip_status") Boolean bool2);
    }

    ShareEmailClient(TwitterSession twitterSession) {
        super(twitterSession);
    }

    protected final void m31743a(Callback<User> callback) {
        ((EmailService) m25845a(EmailService.class)).verifyCredentials(Boolean.valueOf(true), Boolean.valueOf(true)).a(callback);
    }
}
