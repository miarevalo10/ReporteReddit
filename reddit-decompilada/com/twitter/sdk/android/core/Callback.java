package com.twitter.sdk.android.core;

import retrofit2.Call;
import retrofit2.Response;

public abstract class Callback<T> implements retrofit2.Callback<T> {
    public abstract void mo6518a(Result<T> result);

    public abstract void mo6519a(TwitterException twitterException);

    public final void m31703a(Call<T> call, Throwable th) {
        mo6519a(new TwitterException("Request Failure", th));
    }

    public final void m31704a(Call<T> call, Response<T> response) {
        if (response.a.isSuccessful() != null) {
            mo6518a(new Result(response.b, response));
        } else {
            mo6519a(new TwitterApiException(response));
        }
    }
}
