package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;

class ResetTweetCallback extends Callback<Tweet> {
    BaseTweetView f34659a;
    TweetRepository f34660b;
    Callback<Tweet> f34661c;

    ResetTweetCallback(BaseTweetView baseTweetView, TweetRepository tweetRepository, Callback<Tweet> callback) {
        this.f34659a = baseTweetView;
        this.f34660b = tweetRepository;
        this.f34661c = callback;
    }

    public final void mo6518a(Result<Tweet> result) {
        this.f34660b.m25927b((Tweet) result.f23920a);
        this.f34659a.setTweet((Tweet) result.f23920a);
        if (this.f34661c != null) {
            this.f34661c.mo6518a((Result) result);
        }
    }

    public final void mo6519a(TwitterException twitterException) {
        if (this.f34661c != null) {
            this.f34661c.mo6519a(twitterException);
        }
    }
}
