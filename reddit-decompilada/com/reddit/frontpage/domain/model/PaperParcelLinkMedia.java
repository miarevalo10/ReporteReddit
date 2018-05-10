package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.TypeAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelLinkMedia {
    static final Creator<LinkMedia> CREATOR = new C17921();
    static final TypeAdapter<RedditVideo> REDDIT_VIDEO_PARCELABLE_ADAPTER = new ParcelableAdapter();

    static class C17921 implements Creator<LinkMedia> {
        C17921() {
        }

        public final LinkMedia createFromParcel(Parcel parcel) {
            return new LinkMedia((RedditVideo) PaperParcelLinkMedia.REDDIT_VIDEO_PARCELABLE_ADAPTER.a(parcel));
        }

        public final LinkMedia[] newArray(int i) {
            return new LinkMedia[i];
        }
    }

    private PaperParcelLinkMedia() {
    }

    static void writeToParcel(LinkMedia linkMedia, Parcel parcel, int i) {
        REDDIT_VIDEO_PARCELABLE_ADAPTER.a(linkMedia.getRedditVideo(), parcel, i);
    }
}
