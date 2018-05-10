package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccountService {
    @GET(a = "/1.1/account/verify_credentials.json")
    Call<User> verifyCredentials(@Query(a = "include_entities") Boolean bool, @Query(a = "skip_status") Boolean bool2);
}
