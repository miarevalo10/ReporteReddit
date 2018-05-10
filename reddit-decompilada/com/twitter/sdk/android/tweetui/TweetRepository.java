package com.twitter.sdk.android.tweetui;

import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;
import io.fabric.sdk.android.Logger;
import java.util.List;

class TweetRepository {
    final TwitterCore f24216a;
    final Handler f24217b;
    final LruCache<Long, Tweet> f24218c;
    final LruCache<Long, FormattedTweetText> f24219d;
    private final SessionManager<TwitterSession> f24220e;

    class C20761 implements Runnable {
        final /* synthetic */ Callback f24213a;
        final /* synthetic */ Tweet f24214b;
        final /* synthetic */ TweetRepository f24215c;

        C20761(TweetRepository tweetRepository, Callback callback, Tweet tweet) {
            this.f24215c = tweetRepository;
            this.f24213a = callback;
            this.f24214b = tweet;
        }

        public void run() {
            this.f24213a.mo6518a(new Result(this.f24214b, null));
        }
    }

    class MultiTweetsCallback extends Callback<List<Tweet>> {
        final Callback<List<Tweet>> f34662a;
        final List<Long> f34663b;
        final /* synthetic */ TweetRepository f34664c;

        MultiTweetsCallback(TweetRepository tweetRepository, List<Long> list, Callback<List<Tweet>> callback) {
            this.f34664c = tweetRepository;
            this.f34662a = callback;
            this.f34663b = list;
        }

        public final void mo6518a(Result<List<Tweet>> result) {
            if (this.f34662a != null) {
                this.f34662a.mo6518a(new Result(Utils.m25946a(this.f34663b, (List) result.f23920a), result.f23921b));
            }
        }

        public final void mo6519a(TwitterException twitterException) {
            this.f34662a.mo6519a(twitterException);
        }
    }

    class SingleTweetCallback extends Callback<Tweet> {
        final Callback<Tweet> f34665a;
        final /* synthetic */ TweetRepository f34666b;

        SingleTweetCallback(TweetRepository tweetRepository, Callback<Tweet> callback) {
            this.f34666b = tweetRepository;
            this.f34665a = callback;
        }

        public final void mo6518a(Result<Tweet> result) {
            Tweet tweet = (Tweet) result.f23920a;
            this.f34666b.m25927b(tweet);
            if (this.f34665a != null) {
                this.f34665a.mo6518a(new Result(tweet, result.f23921b));
            }
        }

        public final void mo6519a(TwitterException twitterException) {
            this.f34665a.mo6519a(twitterException);
        }
    }

    class C29162 extends LoggingCallback<TwitterSession> {
        final /* synthetic */ long f37609a;
        final /* synthetic */ Callback f37610b;
        final /* synthetic */ TweetRepository f37611c;

        C29162(TweetRepository tweetRepository, Callback callback, Logger logger, long j, Callback callback2) {
            this.f37611c = tweetRepository;
            this.f37609a = j;
            this.f37610b = callback2;
            super(callback, logger);
        }

        public final void mo6518a(Result<TwitterSession> result) {
            this.f37611c.f24216a.m31724a((TwitterSession) result.f23920a).m25846b().create(Long.valueOf(this.f37609a), Boolean.valueOf(false)).a(this.f37610b);
        }
    }

    class C29173 extends LoggingCallback<TwitterSession> {
        final /* synthetic */ long f37612a;
        final /* synthetic */ Callback f37613b;
        final /* synthetic */ TweetRepository f37614c;

        C29173(TweetRepository tweetRepository, Callback callback, Logger logger, long j, Callback callback2) {
            this.f37614c = tweetRepository;
            this.f37612a = j;
            this.f37613b = callback2;
            super(callback, logger);
        }

        public final void mo6518a(Result<TwitterSession> result) {
            this.f37614c.f24216a.m31724a((TwitterSession) result.f23920a).m25846b().destroy(Long.valueOf(this.f37612a), Boolean.valueOf(false)).a(this.f37613b);
        }
    }

    TweetRepository(Handler handler, SessionManager<TwitterSession> sessionManager) {
        this(handler, sessionManager, TwitterCore.m31719a());
    }

    private TweetRepository(Handler handler, SessionManager<TwitterSession> sessionManager, TwitterCore twitterCore) {
        this.f24216a = twitterCore;
        this.f24217b = handler;
        this.f24220e = sessionManager;
        this.f24218c = new LruCache(20);
        this.f24219d = new LruCache(20);
    }

    final FormattedTweetText m25925a(Tweet tweet) {
        if (tweet == null) {
            return null;
        }
        FormattedTweetText formattedTweetText = (FormattedTweetText) this.f24219d.get(Long.valueOf(tweet.f24051i));
        if (formattedTweetText != null) {
            return formattedTweetText;
        }
        formattedTweetText = TweetTextUtils.m25936a(tweet);
        if (!(formattedTweetText == null || TextUtils.isEmpty(formattedTweetText.f24167a))) {
            this.f24219d.put(Long.valueOf(tweet.f24051i), formattedTweetText);
        }
        return formattedTweetText;
    }

    final void m25927b(Tweet tweet) {
        this.f24218c.put(Long.valueOf(tweet.f24051i), tweet);
    }

    final void m25926a(Callback<TwitterSession> callback) {
        TwitterSession twitterSession = (TwitterSession) this.f24220e.mo5463a();
        if (twitterSession == null) {
            callback.mo6519a(new TwitterAuthException("User authorization required"));
        } else {
            callback.mo6518a(new Result(twitterSession, null));
        }
    }
}
