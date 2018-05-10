package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.instabug.library.model.NetworkLog;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.core.models.Tweet;
import io.fabric.sdk.android.Fabric;

class ShareTweetAction implements OnClickListener {
    final Tweet f24199a;
    final TweetUi f24200b;
    final TweetScribeClient f24201c;

    ShareTweetAction(Tweet tweet, TweetUi tweetUi) {
        this(tweet, tweetUi, new TweetScribeClientImpl(tweetUi));
    }

    private ShareTweetAction(Tweet tweet, TweetUi tweetUi, TweetScribeClient tweetScribeClient) {
        this.f24199a = tweet;
        this.f24200b = tweetUi;
        this.f24201c = tweetScribeClient;
    }

    public void onClick(View view) {
        Context context = view.getContext();
        view = view.getResources();
        if (this.f24199a != null) {
            if (this.f24199a.f24038D != null) {
                this.f24201c.mo5498a(this.f24199a);
                String string = view.getString(C2075R.string.tw__share_subject_format, new Object[]{this.f24199a.f24038D.f24106b, this.f24199a.f24038D.f24108d});
                String string2 = view.getString(C2075R.string.tw__share_content_format, new Object[]{this.f24199a.f24038D.f24108d, Long.valueOf(this.f24199a.f24051i)});
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.SUBJECT", string);
                intent.putExtra("android.intent.extra.TEXT", string2);
                intent.setType(NetworkLog.PLAIN_TEXT);
                if (IntentUtils.m25838a(context, Intent.createChooser(intent, view.getString(C2075R.string.tw__share_tweet))) == null) {
                    Fabric.m26243b().mo5570e("TweetUi", "Activity cannot be found to handle share intent");
                }
            }
        }
    }
}
