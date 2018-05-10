package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;

final class PaperParcelSubredditCategory {
    static final Creator<SubredditCategory> CREATOR = new C17971();

    static class C17971 implements Creator<SubredditCategory> {
        C17971() {
        }

        public final SubredditCategory createFromParcel(Parcel parcel) {
            return new SubredditCategory((String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel), (String) StaticAdapters.x.a(parcel));
        }

        public final SubredditCategory[] newArray(int i) {
            return new SubredditCategory[i];
        }
    }

    private PaperParcelSubredditCategory() {
    }

    static void writeToParcel(SubredditCategory subredditCategory, Parcel parcel, int i) {
        StaticAdapters.x.a(subredditCategory.getId(), parcel, i);
        StaticAdapters.x.a(subredditCategory.getName(), parcel, i);
        StaticAdapters.x.a(subredditCategory.getColor(), parcel, i);
        StaticAdapters.x.a(subredditCategory.getIcon(), parcel, i);
    }
}
