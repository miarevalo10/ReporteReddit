package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class LinkOEmbed$$Parcelable implements Parcelable, ParcelWrapper<LinkOEmbed> {
    public static final Creator<LinkOEmbed$$Parcelable> CREATOR = new C09571();
    private LinkOEmbed linkOEmbed$$0;

    /* compiled from: LinkOEmbed$$Parcelable */
    static class C09571 implements Creator<LinkOEmbed$$Parcelable> {
        C09571() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LinkOEmbed$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LinkOEmbed$$Parcelable(LinkOEmbed$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public LinkOEmbed$$Parcelable(LinkOEmbed linkOEmbed) {
        this.linkOEmbed$$0 = linkOEmbed;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.linkOEmbed$$0, parcel, i, new IdentityCollection());
    }

    public static void write(LinkOEmbed linkOEmbed, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(linkOEmbed);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(linkOEmbed));
        parcel.writeString(linkOEmbed.thumbnail_url);
    }

    public LinkOEmbed getParcel() {
        return this.linkOEmbed$$0;
    }

    public static LinkOEmbed read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            LinkOEmbed linkOEmbed = new LinkOEmbed();
            identityCollection.a(a, linkOEmbed);
            linkOEmbed.thumbnail_url = parcel.readString();
            identityCollection.a(readInt, linkOEmbed);
            return linkOEmbed;
        } else if (identityCollection.b(readInt) == null) {
            return (LinkOEmbed) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
