package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterException;
import io.fabric.sdk.android.Logger;

abstract class LoggingCallback<T> extends Callback<T> {
    private final Callback f34657a;
    private final Logger f34658b;

    LoggingCallback(Callback callback, Logger logger) {
        this.f34657a = callback;
        this.f34658b = logger;
    }

    public final void mo6519a(TwitterException twitterException) {
        this.f34658b.mo5568c("TweetUi", twitterException.getMessage(), twitterException);
        if (this.f34657a != null) {
            this.f34657a.mo6519a(twitterException);
        }
    }
}
