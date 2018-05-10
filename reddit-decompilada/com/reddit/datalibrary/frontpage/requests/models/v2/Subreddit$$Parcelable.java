package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class Subreddit$$Parcelable implements Parcelable, ParcelWrapper<Subreddit> {
    public static final Creator<Subreddit$$Parcelable> CREATOR = new C17511();
    private Subreddit subreddit$$0;

    /* compiled from: Subreddit$$Parcelable */
    static class C17511 implements Creator<Subreddit$$Parcelable> {
        C17511() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Subreddit$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Subreddit$$Parcelable(Subreddit$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public Subreddit$$Parcelable(Subreddit subreddit) {
        this.subreddit$$0 = subreddit;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.subreddit$$0, parcel, i, new IdentityCollection());
    }

    public static void write(Subreddit subreddit, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) subreddit);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) subreddit));
        parcel.writeInt(subreddit.user_favorite);
        parcel.writeInt(subreddit.user_is_subscriber);
        parcel.writeString(subreddit._username);
        parcel.writeInt(subreddit.user_is_moderator);
        parcel.writeInt(subreddit.over18);
        parcel.writeString(subreddit.subreddit_type);
        parcel.writeString(subreddit.key_color);
        parcel.writeLong(subreddit.subscribers);
        parcel.writeLong(subreddit.accounts_active);
        parcel.writeString(subreddit.description);
        parcel.writeString(subreddit.display_name);
        parcel.writeInt(subreddit.is_default);
        parcel.writeString(subreddit.url);
        parcel.writeString(subreddit.icon_img);
        parcel.writeString(subreddit.display_name_prefixed);
        parcel.writeString(subreddit.banner_img);
        parcel.writeInt(subreddit.wiki_enabled);
        parcel.writeString(subreddit.whitelist_status);
        parcel.writeString(subreddit.name);
        parcel.writeLong(subreddit._id);
        parcel.writeString(subreddit.id);
        parcel.writeString(subreddit.description_html);
    }

    public Subreddit getParcel() {
        return this.subreddit$$0;
    }

    public static Subreddit read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            Subreddit subreddit = new Subreddit();
            identityCollection.m28661a(a, subreddit);
            boolean z = false;
            subreddit.user_favorite = parcel.readInt() == 1;
            subreddit.user_is_subscriber = parcel.readInt() == 1;
            subreddit._username = parcel.readString();
            subreddit.user_is_moderator = parcel.readInt() == 1;
            subreddit.over18 = parcel.readInt() == 1;
            subreddit.subreddit_type = parcel.readString();
            subreddit.key_color = parcel.readString();
            subreddit.subscribers = parcel.readLong();
            subreddit.accounts_active = parcel.readLong();
            subreddit.description = parcel.readString();
            subreddit.display_name = parcel.readString();
            subreddit.is_default = parcel.readInt() == 1;
            subreddit.url = parcel.readString();
            subreddit.icon_img = parcel.readString();
            subreddit.display_name_prefixed = parcel.readString();
            subreddit.banner_img = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            }
            subreddit.wiki_enabled = z;
            subreddit.whitelist_status = parcel.readString();
            subreddit.name = parcel.readString();
            subreddit._id = parcel.readLong();
            subreddit.id = parcel.readString();
            subreddit.description_html = parcel.readString();
            identityCollection.m28661a(readInt, subreddit);
            return subreddit;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (Subreddit) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
