package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Tweet;

class BaseTweetAction {
    protected Callback<Tweet> f24123a;

    BaseTweetAction(Callback<Tweet> callback) {
        this.f24123a = callback;
    }

    final Callback<Tweet> m25894a() {
        return this.f24123a;
    }
}
