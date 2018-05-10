package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.Tweet;

public class TweetView extends BaseTweetView {
    protected final double mo5503a(int i) {
        return i == 4 ? 1.0d : 1.5d;
    }

    String getViewTypeName() {
        return "default";
    }

    public TweetView(Context context, Tweet tweet) {
        super(context, tweet);
    }

    public TweetView(Context context, Tweet tweet, int i) {
        super(context, tweet, i);
    }

    TweetView(Context context, Tweet tweet, int i, DependencyProvider dependencyProvider) {
        super(context, tweet, i, dependencyProvider);
    }

    public TweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int getLayout() {
        return C2075R.layout.tw__tweet;
    }

    final void mo5504a() {
        super.mo5504a();
        setVerifiedCheck(this.d);
    }

    private void setVerifiedCheck(Tweet tweet) {
        if (tweet == null || tweet.f24038D == null || tweet.f24038D.f24109e == null) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
    }
}
