package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;

final class PaperParcelKarmaItem {
    static final Creator<KarmaItem> CREATOR = new C17501();

    static class C17501 implements Creator<KarmaItem> {
        C17501() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new KarmaItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new KarmaItem((String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), parcel.readInt(), parcel.readInt(), parcel.readInt(), (int[]) StaticAdapters.q.a(parcel), (int[]) StaticAdapters.q.a(parcel), parcel.readInt() == 1, (String) StaticAdapters.x.a(parcel));
        }
    }

    private PaperParcelKarmaItem() {
    }

    static void writeToParcel(KarmaItem karmaItem, Parcel parcel, int i) {
        StaticAdapters.x.a(karmaItem.iconImage, parcel, i);
        StaticAdapters.x.a(karmaItem.bannerImage, parcel, i);
        StaticAdapters.x.a(karmaItem.subredditName, parcel, i);
        StaticAdapters.x.a(karmaItem.subredditDisplayNamePrefixed, parcel, i);
        StaticAdapters.x.a(karmaItem.keyColor, parcel, i);
        parcel.writeInt(karmaItem.linkKarma);
        parcel.writeInt(karmaItem.commentKarma);
        parcel.writeInt(karmaItem.subscribers);
        StaticAdapters.q.a(karmaItem.iconSize, parcel, i);
        StaticAdapters.q.a(karmaItem.bannerSize, parcel, i);
        parcel.writeInt(karmaItem.isSubscribed);
        StaticAdapters.x.a(karmaItem.name, parcel, i);
    }
}
