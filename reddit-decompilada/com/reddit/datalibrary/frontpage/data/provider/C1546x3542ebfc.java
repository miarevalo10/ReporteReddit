package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class C1546x3542ebfc implements Parcelable, ParcelWrapper<SubredditListingProviderSpec> {
    public static final Creator<C1546x3542ebfc> CREATOR = new C09411();
    private SubredditListingProviderSpec subredditListingProviderSpec$$0;

    /* compiled from: SubredditLinkListingProvider$SubredditListingProviderSpec$$Parcelable */
    static class C09411 implements Creator<C1546x3542ebfc> {
        C09411() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new C1546x3542ebfc[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new C1546x3542ebfc(C1546x3542ebfc.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public C1546x3542ebfc(SubredditListingProviderSpec subredditListingProviderSpec) {
        this.subredditListingProviderSpec$$0 = subredditListingProviderSpec;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1546x3542ebfc.write(this.subredditListingProviderSpec$$0, parcel, i, new IdentityCollection());
    }

    public static void write(SubredditListingProviderSpec subredditListingProviderSpec, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(subredditListingProviderSpec);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(subredditListingProviderSpec));
        parcel.writeString(subredditListingProviderSpec.ownerId);
        parcel.writeString(subredditListingProviderSpec.subreddit);
    }

    public SubredditListingProviderSpec getParcel() {
        return this.subredditListingProviderSpec$$0;
    }

    public static SubredditListingProviderSpec read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            SubredditListingProviderSpec subredditListingProviderSpec = new SubredditListingProviderSpec(parcel.readString(), parcel.readString());
            identityCollection.a(a, subredditListingProviderSpec);
            identityCollection.a(readInt, subredditListingProviderSpec);
            return subredditListingProviderSpec;
        } else if (identityCollection.b(readInt) == null) {
            return (SubredditListingProviderSpec) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
