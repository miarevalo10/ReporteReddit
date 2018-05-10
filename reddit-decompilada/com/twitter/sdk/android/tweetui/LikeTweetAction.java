package com.twitter.sdk.android.tweetui;

import android.view.View;
import android.view.View.OnClickListener;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;
import com.twitter.sdk.android.tweetui.TweetRepository.C29162;
import com.twitter.sdk.android.tweetui.TweetRepository.C29173;
import io.fabric.sdk.android.Fabric;

class LikeTweetAction extends BaseTweetAction implements OnClickListener {
    final Tweet f30774b;
    final TweetRepository f30775c;
    final TweetUi f30776d;
    final TweetScribeClient f30777e;

    static class LikeCallback extends Callback<Tweet> {
        ToggleImageButton f34654a;
        Tweet f34655b;
        Callback<Tweet> f34656c;

        LikeCallback(ToggleImageButton toggleImageButton, Tweet tweet, Callback<Tweet> callback) {
            this.f34654a = toggleImageButton;
            this.f34655b = tweet;
            this.f34656c = callback;
        }

        public final void mo6518a(Result<Tweet> result) {
            this.f34656c.mo6518a((Result) result);
        }

        public final void mo6519a(TwitterException twitterException) {
            if (twitterException instanceof TwitterApiException) {
                TwitterApiException twitterApiException = (TwitterApiException) twitterException;
                int i = twitterApiException.f30687a == null ? 0 : twitterApiException.f30687a.f24023a;
                if (i == 139) {
                    twitterException = new TweetBuilder().m25893a(this.f34655b);
                    twitterException.f24077a = true;
                    this.f34656c.mo6518a(new Result(twitterException.m25892a(), null));
                    return;
                } else if (i != 144) {
                    this.f34654a.setToggledOn(this.f34655b.f24049g);
                    this.f34656c.mo6519a(twitterException);
                    return;
                } else {
                    twitterException = new TweetBuilder().m25893a(this.f34655b);
                    twitterException.f24077a = false;
                    this.f34656c.mo6518a(new Result(twitterException.m25892a(), null));
                    return;
                }
            }
            this.f34654a.setToggledOn(this.f34655b.f24049g);
            this.f34656c.mo6519a(twitterException);
        }
    }

    LikeTweetAction(Tweet tweet, TweetUi tweetUi, Callback<Tweet> callback) {
        this(tweet, tweetUi, callback, new TweetScribeClientImpl(tweetUi));
    }

    private LikeTweetAction(Tweet tweet, TweetUi tweetUi, Callback<Tweet> callback, TweetScribeClient tweetScribeClient) {
        super(callback);
        this.f30774b = tweet;
        this.f30776d = tweetUi;
        this.f30777e = tweetScribeClient;
        this.f30775c = tweetUi.f30783d;
    }

    public void onClick(View view) {
        if (view instanceof ToggleImageButton) {
            ToggleImageButton toggleImageButton = (ToggleImageButton) view;
            TweetRepository tweetRepository;
            long j;
            Callback likeCallback;
            if (this.f30774b.f24049g) {
                this.f30777e.mo5502c(this.f30774b);
                tweetRepository = this.f30775c;
                j = this.f30774b.f24051i;
                likeCallback = new LikeCallback(toggleImageButton, this.f30774b, m25894a());
                tweetRepository.m25926a(new C29173(tweetRepository, likeCallback, Fabric.m26243b(), j, likeCallback));
                return;
            }
            this.f30777e.mo5501b(this.f30774b);
            tweetRepository = this.f30775c;
            j = this.f30774b.f24051i;
            likeCallback = new LikeCallback(toggleImageButton, this.f30774b, m25894a());
            tweetRepository.m25926a(new C29162(tweetRepository, likeCallback, Fabric.m26243b(), j, likeCallback));
        }
    }
}
