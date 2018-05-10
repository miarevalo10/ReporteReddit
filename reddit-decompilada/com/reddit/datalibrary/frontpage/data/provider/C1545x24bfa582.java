package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class C1545x24bfa582 implements Parcelable, ParcelWrapper<MultiredditLinkListingProviderSpec> {
    public static final Creator<C1545x24bfa582> CREATOR = new C09401();
    private MultiredditLinkListingProviderSpec multiredditLinkListingProviderSpec$$0;

    /* compiled from: MultiredditLinkListingProvider$MultiredditLinkListingProviderSpec$$Parcelable */
    static class C09401 implements Creator<C1545x24bfa582> {
        C09401() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new C1545x24bfa582[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new C1545x24bfa582(C1545x24bfa582.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public C1545x24bfa582(MultiredditLinkListingProviderSpec multiredditLinkListingProviderSpec) {
        this.multiredditLinkListingProviderSpec$$0 = multiredditLinkListingProviderSpec;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1545x24bfa582.write(this.multiredditLinkListingProviderSpec$$0, parcel, i, new IdentityCollection());
    }

    public static void write(MultiredditLinkListingProviderSpec multiredditLinkListingProviderSpec, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(multiredditLinkListingProviderSpec);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(multiredditLinkListingProviderSpec));
        parcel.writeString(multiredditLinkListingProviderSpec.ownerId);
        parcel.writeString(multiredditLinkListingProviderSpec.multireddit);
    }

    public MultiredditLinkListingProviderSpec getParcel() {
        return this.multiredditLinkListingProviderSpec$$0;
    }

    public static MultiredditLinkListingProviderSpec read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            MultiredditLinkListingProviderSpec multiredditLinkListingProviderSpec = new MultiredditLinkListingProviderSpec(parcel.readString(), parcel.readString());
            identityCollection.a(a, multiredditLinkListingProviderSpec);
            identityCollection.a(readInt, multiredditLinkListingProviderSpec);
            return multiredditLinkListingProviderSpec;
        } else if (identityCollection.b(readInt) == null) {
            return (MultiredditLinkListingProviderSpec) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
