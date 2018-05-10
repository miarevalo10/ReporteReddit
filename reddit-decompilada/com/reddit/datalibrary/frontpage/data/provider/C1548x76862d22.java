package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.data.provider.UserSubmittedListingProvider.Filter;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class C1548x76862d22 implements Parcelable, ParcelWrapper<UserSubmittedListingProviderSpec> {
    public static final Creator<C1548x76862d22> CREATOR = new C09421();
    private UserSubmittedListingProviderSpec userSubmittedListingProviderSpec$$0;

    /* compiled from: UserSubmittedListingProvider$UserSubmittedListingProviderSpec$$Parcelable */
    static class C09421 implements Creator<C1548x76862d22> {
        C09421() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new C1548x76862d22[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new C1548x76862d22(C1548x76862d22.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public C1548x76862d22(UserSubmittedListingProviderSpec userSubmittedListingProviderSpec) {
        this.userSubmittedListingProviderSpec$$0 = userSubmittedListingProviderSpec;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1548x76862d22.write(this.userSubmittedListingProviderSpec$$0, parcel, i, new IdentityCollection());
    }

    public static void write(UserSubmittedListingProviderSpec userSubmittedListingProviderSpec, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(userSubmittedListingProviderSpec);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(userSubmittedListingProviderSpec));
        parcel.writeString(userSubmittedListingProviderSpec.ownerId);
        parcel.writeString(userSubmittedListingProviderSpec.username);
        parcel.writeSerializable(userSubmittedListingProviderSpec.filter);
    }

    public UserSubmittedListingProviderSpec getParcel() {
        return this.userSubmittedListingProviderSpec$$0;
    }

    public static UserSubmittedListingProviderSpec read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            UserSubmittedListingProviderSpec userSubmittedListingProviderSpec = new UserSubmittedListingProviderSpec(parcel.readString(), parcel.readString(), (Filter) parcel.readSerializable());
            identityCollection.a(a, userSubmittedListingProviderSpec);
            identityCollection.a(readInt, userSubmittedListingProviderSpec);
            return userSubmittedListingProviderSpec;
        } else if (identityCollection.b(readInt) == null) {
            return (UserSubmittedListingProviderSpec) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
