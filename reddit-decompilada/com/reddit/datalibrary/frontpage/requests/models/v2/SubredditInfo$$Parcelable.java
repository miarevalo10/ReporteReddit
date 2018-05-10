package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class SubredditInfo$$Parcelable implements Parcelable, ParcelWrapper<SubredditInfo> {
    public static final Creator<SubredditInfo$$Parcelable> CREATOR = new C17531();
    private SubredditInfo subredditInfo$$0;

    /* compiled from: SubredditInfo$$Parcelable */
    static class C17531 implements Creator<SubredditInfo$$Parcelable> {
        C17531() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SubredditInfo$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SubredditInfo$$Parcelable(SubredditInfo$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public SubredditInfo$$Parcelable(SubredditInfo subredditInfo) {
        this.subredditInfo$$0 = subredditInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.subredditInfo$$0, parcel, i, new IdentityCollection());
    }

    public static void write(SubredditInfo subredditInfo, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) subredditInfo);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) subredditInfo));
        parcel.writeInt(subredditInfo.over18);
        parcel.writeString(subredditInfo.subreddit_type);
        parcel.writeString(subredditInfo.key_color);
        parcel.writeLong(subredditInfo.subscribers);
        parcel.writeLong(subredditInfo.accounts_active);
        parcel.writeString(subredditInfo.description);
        parcel.writeString(subredditInfo.display_name);
        parcel.writeInt(subredditInfo.is_default);
        parcel.writeString(subredditInfo.url);
        parcel.writeString(subredditInfo.icon_img);
        parcel.writeString(subredditInfo.display_name_prefixed);
        parcel.writeString(subredditInfo.banner_img);
        parcel.writeInt(subredditInfo.wiki_enabled);
        parcel.writeString(subredditInfo.whitelist_status);
        parcel.writeString(subredditInfo.name);
        parcel.writeLong(subredditInfo._id);
        parcel.writeString(subredditInfo.id);
        parcel.writeString(subredditInfo.description_html);
    }

    public SubredditInfo getParcel() {
        return this.subredditInfo$$0;
    }

    public static SubredditInfo read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            SubredditInfo subredditInfo = new SubredditInfo();
            identityCollection.m28661a(a, subredditInfo);
            boolean z = false;
            subredditInfo.over18 = parcel.readInt() == 1;
            subredditInfo.subreddit_type = parcel.readString();
            subredditInfo.key_color = parcel.readString();
            subredditInfo.subscribers = parcel.readLong();
            subredditInfo.accounts_active = parcel.readLong();
            subredditInfo.description = parcel.readString();
            subredditInfo.display_name = parcel.readString();
            subredditInfo.is_default = parcel.readInt() == 1;
            subredditInfo.url = parcel.readString();
            subredditInfo.icon_img = parcel.readString();
            subredditInfo.display_name_prefixed = parcel.readString();
            subredditInfo.banner_img = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            }
            subredditInfo.wiki_enabled = z;
            subredditInfo.whitelist_status = parcel.readString();
            subredditInfo.name = parcel.readString();
            subredditInfo._id = parcel.readLong();
            subredditInfo.id = parcel.readString();
            subredditInfo.description_html = parcel.readString();
            identityCollection.m28661a(readInt, subredditInfo);
            return subredditInfo;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (SubredditInfo) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
