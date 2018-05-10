package com.twitter.sdk.android.tweetui;

import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEvents;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace.Builder;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.ArrayList;
import java.util.List;

class TweetScribeClientImpl implements TweetScribeClient {
    final TweetUi f30779a;

    TweetScribeClientImpl(TweetUi tweetUi) {
        this.f30779a = tweetUi;
    }

    public final void mo5500a(Tweet tweet, String str, boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(ScribeItem.m25886a(tweet));
        tweet = this.f30779a;
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "tweet";
        builder.f23972d = str;
        builder.f23973e = z ? "actions" : "";
        builder.f23974f = "impression";
        tweet.m31787a(builder.m25878a(), arrayList);
        tweet = this.f30779a;
        z = new Builder();
        z.f23969a = "android";
        z.f23970b = "tweet";
        z.f23971c = str;
        z.f23972d = "";
        z.f23973e = "";
        z.f23974f = "impression";
        tweet.m31787a(z.m25878a(), arrayList);
    }

    public final void mo5498a(Tweet tweet) {
        List arrayList = new ArrayList();
        arrayList.add(ScribeItem.m25886a(tweet));
        tweet = this.f30779a;
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "tweet";
        builder.f23973e = "actions";
        builder.f23974f = TheaterModeEvents.NOUN_SHARE;
        tweet.m31787a(builder.m25878a(), arrayList);
    }

    public final void mo5501b(Tweet tweet) {
        List arrayList = new ArrayList();
        arrayList.add(ScribeItem.m25886a(tweet));
        tweet = this.f30779a;
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "tweet";
        builder.f23973e = "actions";
        builder.f23974f = "favorite";
        tweet.m31787a(builder.m25878a(), arrayList);
    }

    public final void mo5502c(Tweet tweet) {
        List arrayList = new ArrayList();
        arrayList.add(ScribeItem.m25886a(tweet));
        tweet = this.f30779a;
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "tweet";
        builder.f23973e = "actions";
        builder.f23974f = "unfavorite";
        tweet.m31787a(builder.m25878a(), arrayList);
    }

    public final void mo5499a(Tweet tweet, String str) {
        List arrayList = new ArrayList();
        arrayList.add(ScribeItem.m25886a(tweet));
        tweet = this.f30779a;
        Builder builder = new Builder();
        builder.f23969a = "tfw";
        builder.f23970b = "android";
        builder.f23971c = "tweet";
        builder.f23972d = str;
        builder.f23973e = "";
        builder.f23974f = "click";
        tweet.m31787a(builder.m25878a(), arrayList);
    }
}
