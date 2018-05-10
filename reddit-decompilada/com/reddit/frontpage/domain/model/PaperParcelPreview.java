package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;
import paperparcel.TypeAdapter;
import paperparcel.internal.ListAdapter;
import paperparcel.internal.ParcelableAdapter;

final class PaperParcelPreview {
    static final Creator<Preview> CREATOR = new C17941();
    static final TypeAdapter<List<Image>> IMAGE_LIST_ADAPTER = new ListAdapter(IMAGE_PARCELABLE_ADAPTER);
    static final TypeAdapter<Image> IMAGE_PARCELABLE_ADAPTER = new ParcelableAdapter();
    static final TypeAdapter<RedditVideo> REDDIT_VIDEO_PARCELABLE_ADAPTER = new ParcelableAdapter();

    static class C17941 implements Creator<Preview> {
        C17941() {
        }

        public final Preview createFromParcel(Parcel parcel) {
            return new Preview((List) PaperParcelPreview.IMAGE_LIST_ADAPTER.a(parcel), (RedditVideo) PaperParcelPreview.REDDIT_VIDEO_PARCELABLE_ADAPTER.a(parcel));
        }

        public final Preview[] newArray(int i) {
            return new Preview[i];
        }
    }

    private PaperParcelPreview() {
    }

    static void writeToParcel(Preview preview, Parcel parcel, int i) {
        IMAGE_LIST_ADAPTER.a(preview.getImages(), parcel, i);
        REDDIT_VIDEO_PARCELABLE_ADAPTER.a(preview.getRedditVideoPreview(), parcel, i);
    }
}
