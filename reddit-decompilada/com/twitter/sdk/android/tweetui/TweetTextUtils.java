package com.twitter.sdk.android.tweetui;

import android.text.TextUtils;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.UrlEntity;
import com.twitter.sdk.android.tweetui.internal.util.HtmlEntities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class TweetTextUtils {
    static FormattedTweetText m25936a(Tweet tweet) {
        if (tweet == null) {
            return null;
        }
        FormattedTweetText formattedTweetText = new FormattedTweetText();
        if (tweet.f24046d != null) {
            List<UrlEntity> list = tweet.f24046d.f24103a;
            if (list != null) {
                for (UrlEntity formattedUrlEntity : list) {
                    formattedTweetText.f24168b.add(new FormattedUrlEntity(formattedUrlEntity));
                }
            }
            List<MediaEntity> list2 = tweet.f24046d.f24104b;
            if (list2 != null) {
                for (MediaEntity formattedMediaEntity : list2) {
                    formattedTweetText.f24169c.add(new FormattedMediaEntity(formattedMediaEntity));
                }
            }
        }
        if (!TextUtils.isEmpty(tweet.f24035A)) {
            tweet = HtmlEntities.f24283a.m25995a(tweet.f24035A);
            StringBuilder stringBuilder = new StringBuilder(tweet.f24281a);
            m25938a(formattedTweetText.f24168b, tweet.f24282b);
            m25938a(formattedTweetText.f24169c, tweet.f24282b);
            m25937a(stringBuilder, formattedTweetText);
            formattedTweetText.f24167a = stringBuilder.toString();
        }
        return formattedTweetText;
    }

    private static void m25938a(List<? extends FormattedUrlEntity> list, List<int[]> list2) {
        if (!(list == null || list2 == null)) {
            if (!list2.isEmpty()) {
                int size = list2.size();
                int i = 0;
                int i2 = i;
                for (FormattedUrlEntity formattedUrlEntity : list) {
                    int i3 = 0;
                    int i4 = i;
                    while (i < size) {
                        int[] iArr = (int[]) list2.get(i);
                        int i5 = iArr[0];
                        int i6 = iArr[1];
                        i5 = i6 - i5;
                        if (i6 < formattedUrlEntity.f24170c) {
                            i2 += i5;
                            i4++;
                        } else if (i6 < formattedUrlEntity.f24171d) {
                            i3 += i5;
                        }
                        i++;
                    }
                    formattedUrlEntity.f24170c -= i2;
                    formattedUrlEntity.f24171d -= i3 + i2;
                    i = i4;
                }
            }
        }
    }

    private static void m25937a(StringBuilder stringBuilder, FormattedTweetText formattedTweetText) {
        List arrayList = new ArrayList();
        int length = stringBuilder.length() - 1;
        int i = 0;
        while (i < length) {
            if (Character.isHighSurrogate(stringBuilder.charAt(i)) && Character.isLowSurrogate(stringBuilder.charAt(i + 1))) {
                arrayList.add(Integer.valueOf(i));
            }
            i++;
        }
        m25939b(formattedTweetText.f24168b, arrayList);
        m25939b(formattedTweetText.f24169c, arrayList);
    }

    private static void m25939b(List<? extends FormattedUrlEntity> list, List<Integer> list2) {
        if (list != null) {
            for (FormattedUrlEntity formattedUrlEntity : list) {
                int i = formattedUrlEntity.f24170c;
                int i2 = 0;
                Iterator it = list2.iterator();
                while (it.hasNext() && ((Integer) it.next()).intValue() - i2 <= i) {
                    i2++;
                }
                formattedUrlEntity.f24170c += i2;
                formattedUrlEntity.f24171d += i2;
            }
        }
    }
}
