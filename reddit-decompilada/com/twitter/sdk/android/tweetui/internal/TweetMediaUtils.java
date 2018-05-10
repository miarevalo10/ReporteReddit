package com.twitter.sdk.android.tweetui.internal;

import android.os.Build.VERSION;
import com.instabug.chat.model.Attachment;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.VideoInfo.Variant;
import java.util.ArrayList;
import java.util.List;

public final class TweetMediaUtils {
    public static List<MediaEntity> m25970a(Tweet tweet) {
        List<MediaEntity> arrayList = new ArrayList();
        tweet = tweet.f24047e;
        if (tweet == null || tweet.f24104b == null || tweet.f24104b.size() <= 0) {
            return arrayList;
        }
        for (int i = 0; i <= tweet.f24104b.size() - 1; i++) {
            MediaEntity mediaEntity = (MediaEntity) tweet.f24104b.get(i);
            if (mediaEntity.f34649e != null && m25974c(mediaEntity)) {
                arrayList.add(mediaEntity);
            }
        }
        return arrayList;
    }

    public static MediaEntity m25973c(Tweet tweet) {
        for (MediaEntity mediaEntity : m25976e(tweet)) {
            if (mediaEntity.f34649e != null) {
                Object obj;
                if (!Attachment.TYPE_VIDEO.equals(mediaEntity.f34649e)) {
                    if (!"animated_gif".equals(mediaEntity.f34649e)) {
                        obj = null;
                        if (obj != null) {
                            return mediaEntity;
                        }
                    }
                }
                obj = 1;
                if (obj != null) {
                    return mediaEntity;
                }
            }
        }
        return null;
    }

    public static boolean m25975d(Tweet tweet) {
        MediaEntity c = m25973c(tweet);
        return (c == null || m25969a(c) == null) ? null : true;
    }

    private static boolean m25974c(MediaEntity mediaEntity) {
        return "photo".equals(mediaEntity.f34649e);
    }

    public static Variant m25969a(MediaEntity mediaEntity) {
        for (Variant variant : mediaEntity.f34650f.f24114b) {
            Object obj = 1;
            if (VERSION.SDK_INT >= 21 && "application/x-mpegURL".equals(variant.f24111a)) {
                continue;
            } else if ("video/mp4".equals(variant.f24111a)) {
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                return variant;
            }
        }
        return null;
    }

    public static boolean m25971b(MediaEntity mediaEntity) {
        return "animated_gif".equals(mediaEntity.f34649e);
    }

    private static List<MediaEntity> m25976e(Tweet tweet) {
        List<MediaEntity> arrayList = new ArrayList();
        if (!(tweet.f24046d == null || tweet.f24046d.f24104b == null)) {
            arrayList.addAll(tweet.f24046d.f24104b);
        }
        if (!(tweet.f24047e == null || tweet.f24047e.f24104b == null)) {
            arrayList.addAll(tweet.f24047e.f24104b);
        }
        return arrayList;
    }

    public static boolean m25972b(Tweet tweet) {
        MediaEntity mediaEntity;
        tweet = m25976e(tweet);
        for (int size = tweet.size() - 1; size >= 0; size--) {
            mediaEntity = (MediaEntity) tweet.get(size);
            if (mediaEntity.f34649e != null && m25974c(mediaEntity)) {
                break;
            }
        }
        mediaEntity = null;
        if (mediaEntity != null) {
            return true;
        }
        return null;
    }
}
