package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class SubredditDisplayName$$Parcelable implements Parcelable, ParcelWrapper<SubredditDisplayName> {
    public static final Creator<SubredditDisplayName$$Parcelable> CREATOR = new C17521();
    private SubredditDisplayName subredditDisplayName$$0;

    /* compiled from: SubredditDisplayName$$Parcelable */
    static class C17521 implements Creator<SubredditDisplayName$$Parcelable> {
        C17521() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SubredditDisplayName$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SubredditDisplayName$$Parcelable(SubredditDisplayName$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public SubredditDisplayName$$Parcelable(SubredditDisplayName subredditDisplayName) {
        this.subredditDisplayName$$0 = subredditDisplayName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.subredditDisplayName$$0, parcel, i, new IdentityCollection());
    }

    public static void write(SubredditDisplayName subredditDisplayName, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) subredditDisplayName);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) subredditDisplayName));
        parcel.writeString(subredditDisplayName.display_name);
    }

    public SubredditDisplayName getParcel() {
        return this.subredditDisplayName$$0;
    }

    public static SubredditDisplayName read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            SubredditDisplayName subredditDisplayName = new SubredditDisplayName();
            identityCollection.m28661a(a, subredditDisplayName);
            subredditDisplayName.display_name = parcel.readString();
            identityCollection.m28661a(readInt, subredditDisplayName);
            return subredditDisplayName;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (SubredditDisplayName) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
