package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelSubredditDetail {
    static final Creator<SubredditDetail> CREATOR = new C17981();

    static class C17981 implements Creator<SubredditDetail> {
        C17981() {
        }

        public final SubredditDetail createFromParcel(Parcel parcel) {
            return new SubredditDetail((String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (Boolean) Utils.a(parcel, StaticAdapters.b), (Boolean) Utils.a(parcel, StaticAdapters.b), (String) StaticAdapters.x.a(parcel));
        }

        public final SubredditDetail[] newArray(int i) {
            return new SubredditDetail[i];
        }
    }

    private PaperParcelSubredditDetail() {
    }

    static void writeToParcel(SubredditDetail subredditDetail, Parcel parcel, int i) {
        StaticAdapters.x.a(subredditDetail.getKindWithId(), parcel, i);
        StaticAdapters.x.a(subredditDetail.getKeyColor(), parcel, i);
        StaticAdapters.x.a(subredditDetail.getIconImage(), parcel, i);
        Utils.a(subredditDetail.getOver18(), parcel, i, StaticAdapters.b);
        Utils.a(subredditDetail.getUserIsModerator(), parcel, i, StaticAdapters.b);
        StaticAdapters.x.a(subredditDetail.getDisplayName(), parcel, i);
    }
}
