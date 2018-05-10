package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.data.provider.FrontpageLinkListingProvider.FrontpageListingProviderSpec;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class C1539xf8a385bc implements Parcelable, ParcelWrapper<FrontpageListingProviderSpec> {
    public static final Creator<C1539xf8a385bc> CREATOR = new C09381();
    private FrontpageListingProviderSpec frontpageListingProviderSpec$$0;

    /* compiled from: FrontpageLinkListingProvider$FrontpageListingProviderSpec$$Parcelable */
    static class C09381 implements Creator<C1539xf8a385bc> {
        C09381() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new C1539xf8a385bc[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new C1539xf8a385bc(C1539xf8a385bc.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public C1539xf8a385bc(FrontpageListingProviderSpec frontpageListingProviderSpec) {
        this.frontpageListingProviderSpec$$0 = frontpageListingProviderSpec;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1539xf8a385bc.write(this.frontpageListingProviderSpec$$0, parcel, i, new IdentityCollection());
    }

    public static void write(FrontpageListingProviderSpec frontpageListingProviderSpec, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(frontpageListingProviderSpec);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(frontpageListingProviderSpec));
        parcel.writeString(frontpageListingProviderSpec.ownerId);
        i = Integer.TYPE;
        parcel.writeInt(((Integer) InjectionUtil.a(FrontpageListingProviderSpec.class, frontpageListingProviderSpec, "initialSort")).intValue());
        i = Integer.TYPE;
        parcel.writeInt(((Integer) InjectionUtil.a(FrontpageListingProviderSpec.class, frontpageListingProviderSpec, "initalSortTimeframe")).intValue());
    }

    public FrontpageListingProviderSpec getParcel() {
        return this.frontpageListingProviderSpec$$0;
    }

    public static FrontpageListingProviderSpec read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            FrontpageListingProviderSpec frontpageListingProviderSpec = new FrontpageListingProviderSpec(parcel.readString(), parcel.readInt(), parcel.readInt());
            identityCollection.a(a, frontpageListingProviderSpec);
            identityCollection.a(readInt, frontpageListingProviderSpec);
            return frontpageListingProviderSpec;
        } else if (identityCollection.b(readInt) == null) {
            return (FrontpageListingProviderSpec) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
