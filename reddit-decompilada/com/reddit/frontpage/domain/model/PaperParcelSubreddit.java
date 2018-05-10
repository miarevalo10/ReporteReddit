package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import paperparcel.internal.StaticAdapters;
import paperparcel.internal.Utils;

final class PaperParcelSubreddit {
    static final Creator<Subreddit> CREATOR = new C17961();

    static class C17961 implements Creator<Subreddit> {
        C17961() {
        }

        public final Subreddit createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            return new Subreddit((String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readLong(), (Long) Utils.a(parcel2, StaticAdapters.e), parcel.readLong(), (String) StaticAdapters.x.a(parcel2), (String) StaticAdapters.x.a(parcel2), parcel.readInt() == 1, (Boolean) Utils.a(parcel2, StaticAdapters.b), (String) StaticAdapters.x.a(parcel2), (Boolean) Utils.a(parcel2, StaticAdapters.b), (String) StaticAdapters.x.a(parcel2), (Boolean) Utils.a(parcel2, StaticAdapters.b), (Boolean) Utils.a(parcel2, StaticAdapters.b), (Boolean) Utils.a(parcel2, StaticAdapters.b), (Boolean) Utils.a(parcel2, StaticAdapters.b), (Boolean) Utils.a(parcel2, StaticAdapters.b), (Boolean) Utils.a(parcel2, StaticAdapters.b));
        }

        public final Subreddit[] newArray(int i) {
            return new Subreddit[i];
        }
    }

    private PaperParcelSubreddit() {
    }

    static void writeToParcel(Subreddit subreddit, Parcel parcel, int i) {
        StaticAdapters.x.a(subreddit.getId(), parcel, i);
        StaticAdapters.x.a(subreddit.getKindWithId(), parcel, i);
        StaticAdapters.x.a(subreddit.getDisplayName(), parcel, i);
        StaticAdapters.x.a(subreddit.getDisplayNamePrefixed(), parcel, i);
        StaticAdapters.x.a(subreddit.getIconImg(), parcel, i);
        StaticAdapters.x.a(subreddit.getKeyColor(), parcel, i);
        StaticAdapters.x.a(subreddit.getBannerImg(), parcel, i);
        StaticAdapters.x.a(subreddit.getHeaderImg(), parcel, i);
        StaticAdapters.x.a(subreddit.getTitle(), parcel, i);
        StaticAdapters.x.a(subreddit.getDescription(), parcel, i);
        StaticAdapters.x.a(subreddit.getDescriptionHtml(), parcel, i);
        StaticAdapters.x.a(subreddit.getPublicDescription(), parcel, i);
        StaticAdapters.x.a(subreddit.getPublicDescriptionHtml(), parcel, i);
        parcel.writeLong(subreddit.getSubscribers());
        Utils.a(subreddit.getAccountsActive(), parcel, i, StaticAdapters.e);
        parcel.writeLong(subreddit.getCreatedUtc());
        StaticAdapters.x.a(subreddit.getSubredditType(), parcel, i);
        StaticAdapters.x.a(subreddit.getUrl(), parcel, i);
        parcel.writeInt(subreddit.getOver18());
        Utils.a(subreddit.getWikiEnabled(), parcel, i, StaticAdapters.b);
        StaticAdapters.x.a(subreddit.getWhitelistStatus(), parcel, i);
        Utils.a(subreddit.getNewModMailEnabled(), parcel, i, StaticAdapters.b);
        StaticAdapters.x.a(subreddit.getSubmitType(), parcel, i);
        Utils.a(subreddit.getAllowImages(), parcel, i, StaticAdapters.b);
        Utils.a(subreddit.getAllowVideos(), parcel, i, StaticAdapters.b);
        Utils.a(subreddit.getSpoilersEnabled(), parcel, i, StaticAdapters.b);
        Utils.a(subreddit.getUserIsModerator(), parcel, i, StaticAdapters.b);
        Utils.a(subreddit.getUserIsSubscriber(), parcel, i, StaticAdapters.b);
        Utils.a(subreddit.getUserHasFavorited(), parcel, i, StaticAdapters.b);
    }
}
