package com.twitter.sdk.android.tweetui;

import android.net.Uri;
import android.text.TextUtils;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.models.Tweet;
import io.fabric.sdk.android.Fabric;
import java.util.List;
import java.util.Locale;

public final class TweetUtils {
    public static void m25941a(List<Long> list, final Callback<List<Tweet>> callback) {
        TweetRepository tweetRepository = TweetUi.m31786a().f30783d;
        Callback c29182 = new LoggingCallback<List<Tweet>>(Fabric.m26243b(), callback) {
            public final void mo6518a(Result<List<Tweet>> result) {
                if (callback != null) {
                    callback.mo6518a((Result) result);
                }
            }
        };
        tweetRepository.f24216a.m31727e().m25847c().lookup(TextUtils.join(",", list), null, null, null).a(new MultiTweetsCallback(tweetRepository, list, c29182));
    }

    static boolean m25942a(Tweet tweet) {
        return (tweet == null || tweet.f24051i <= 0 || tweet.f24038D == null || TextUtils.isEmpty(tweet.f24038D.f24108d) != null) ? null : true;
    }

    static Tweet m25943b(Tweet tweet) {
        if (tweet != null) {
            if (tweet.f24067y != null) {
                return tweet.f24067y;
            }
        }
        return tweet;
    }

    static Uri m25940a(String str, long j) {
        if (j <= 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = String.format(Locale.US, "https://twitter.com/%s/status/%d", new Object[]{"twitter_unknown", Long.valueOf(j)});
        } else {
            str = String.format(Locale.US, "https://twitter.com/%s/status/%d", new Object[]{str, Long.valueOf(j)});
        }
        return Uri.parse(str);
    }
}
