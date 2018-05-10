package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;

final class PaperParcelRedditVideo {
    static final Creator<RedditVideo> CREATOR = new C17951();

    static class C17951 implements Creator<RedditVideo> {
        C17951() {
        }

        public final RedditVideo createFromParcel(Parcel parcel) {
            return new RedditVideo((String) StaticAdapters.x.a(parcel), parcel.readInt(), (String) StaticAdapters.x.a(parcel), parcel.readInt(), parcel.readInt(), (String) StaticAdapters.x.a(parcel), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel));
        }

        public final RedditVideo[] newArray(int i) {
            return new RedditVideo[i];
        }
    }

    private PaperParcelRedditVideo() {
    }

    static void writeToParcel(RedditVideo redditVideo, Parcel parcel, int i) {
        StaticAdapters.x.a(redditVideo.getDashUrl(), parcel, i);
        parcel.writeInt(redditVideo.getDuration());
        StaticAdapters.x.a(redditVideo.getFallBackUrl(), parcel, i);
        parcel.writeInt(redditVideo.getHeight());
        parcel.writeInt(redditVideo.getWidth());
        StaticAdapters.x.a(redditVideo.getHlsUrl(), parcel, i);
        parcel.writeInt(redditVideo.isGif());
        StaticAdapters.x.a(redditVideo.getScrubbedMediaUrl(), parcel, i);
        StaticAdapters.x.a(redditVideo.getTranscodingStatus(), parcel, i);
    }
}
