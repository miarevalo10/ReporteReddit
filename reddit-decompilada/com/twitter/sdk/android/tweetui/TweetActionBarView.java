package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Tweet;

public class TweetActionBarView extends LinearLayout {
    final DependencyProvider f24207a;
    ToggleImageButton f24208b;
    ImageButton f24209c;
    Callback<Tweet> f24210d;

    static class DependencyProvider {
        DependencyProvider() {
        }

        static TweetUi m25919a() {
            return TweetUi.m31786a();
        }
    }

    public TweetActionBarView(Context context) {
        this(context, null, new DependencyProvider());
    }

    public TweetActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new DependencyProvider());
    }

    TweetActionBarView(Context context, AttributeSet attributeSet, DependencyProvider dependencyProvider) {
        super(context, attributeSet);
        this.f24207a = dependencyProvider;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f24208b = (ToggleImageButton) findViewById(C2075R.id.tw__tweet_like_button);
        this.f24209c = (ImageButton) findViewById(C2075R.id.tw__tweet_share_button);
    }

    void setOnActionCallback(Callback<Tweet> callback) {
        this.f24210d = callback;
    }

    void setTweet(Tweet tweet) {
        setLike(tweet);
        setShare(tweet);
    }

    void setLike(Tweet tweet) {
        TweetUi a = DependencyProvider.m25919a();
        if (tweet != null) {
            this.f24208b.setToggledOn(tweet.f24049g);
            this.f24208b.setOnClickListener(new LikeTweetAction(tweet, a, this.f24210d));
        }
    }

    void setShare(Tweet tweet) {
        TweetUi a = DependencyProvider.m25919a();
        if (tweet != null) {
            this.f24209c.setOnClickListener(new ShareTweetAction(tweet, a));
        }
    }
}
