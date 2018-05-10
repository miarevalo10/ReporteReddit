package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.data.provider.DefaultsLinkProvider.DefaultsLinkProviderSpec;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class DefaultsLinkProvider$DefaultsLinkProviderSpec$$Parcelable implements Parcelable, ParcelWrapper<DefaultsLinkProviderSpec> {
    public static final Creator<DefaultsLinkProvider$DefaultsLinkProviderSpec$$Parcelable> CREATOR = new C09371();
    private DefaultsLinkProviderSpec defaultsLinkProviderSpec$$0;

    /* compiled from: DefaultsLinkProvider$DefaultsLinkProviderSpec$$Parcelable */
    static class C09371 implements Creator<DefaultsLinkProvider$DefaultsLinkProviderSpec$$Parcelable> {
        C09371() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DefaultsLinkProvider$DefaultsLinkProviderSpec$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DefaultsLinkProvider$DefaultsLinkProviderSpec$$Parcelable(DefaultsLinkProvider$DefaultsLinkProviderSpec$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public DefaultsLinkProvider$DefaultsLinkProviderSpec$$Parcelable(DefaultsLinkProviderSpec defaultsLinkProviderSpec) {
        this.defaultsLinkProviderSpec$$0 = defaultsLinkProviderSpec;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.defaultsLinkProviderSpec$$0, parcel, i, new IdentityCollection());
    }

    public static void write(DefaultsLinkProviderSpec defaultsLinkProviderSpec, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(defaultsLinkProviderSpec);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(defaultsLinkProviderSpec));
        parcel.writeString(defaultsLinkProviderSpec.ownerId);
        parcel.writeString(defaultsLinkProviderSpec.subreddit);
    }

    public DefaultsLinkProviderSpec getParcel() {
        return this.defaultsLinkProviderSpec$$0;
    }

    public static DefaultsLinkProviderSpec read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            DefaultsLinkProviderSpec defaultsLinkProviderSpec = new DefaultsLinkProviderSpec(parcel.readString(), parcel.readString());
            identityCollection.a(a, defaultsLinkProviderSpec);
            identityCollection.a(readInt, defaultsLinkProviderSpec);
            return defaultsLinkProviderSpec;
        } else if (identityCollection.b(readInt) == null) {
            return (DefaultsLinkProviderSpec) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
