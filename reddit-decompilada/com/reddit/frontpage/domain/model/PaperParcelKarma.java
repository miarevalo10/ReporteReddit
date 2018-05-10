package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;

final class PaperParcelKarma {
    static final Creator<Karma> CREATOR = new C17901();

    static class C17901 implements Creator<Karma> {
        C17901() {
        }

        public final Karma createFromParcel(Parcel parcel) {
            return new Karma((String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 1, parcel.readInt() == 1);
        }

        public final Karma[] newArray(int i) {
            return new Karma[i];
        }
    }

    private PaperParcelKarma() {
    }

    static void writeToParcel(Karma karma, Parcel parcel, int i) {
        StaticAdapters.x.a(karma.getKindWithId(), parcel, i);
        StaticAdapters.x.a(karma.getIconUrl(), parcel, i);
        StaticAdapters.x.a(karma.getBannerUrl(), parcel, i);
        StaticAdapters.x.a(karma.getSubreddit(), parcel, i);
        StaticAdapters.x.a(karma.getSubredditPrefixed(), parcel, i);
        StaticAdapters.x.a(karma.getKeyColor(), parcel, i);
        parcel.writeInt(karma.getLinkKarma());
        parcel.writeInt(karma.getCommentKarmaCount());
        parcel.writeInt(karma.getSubscriberCount());
        parcel.writeInt(karma.getOver18());
        parcel.writeInt(karma.getUserIsSubscriber());
    }
}
