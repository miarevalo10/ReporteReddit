package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class LinkMedia$$Parcelable implements Parcelable, ParcelWrapper<LinkMedia> {
    public static final Creator<LinkMedia$$Parcelable> CREATOR = new C09561();
    private LinkMedia linkMedia$$0;

    /* compiled from: LinkMedia$$Parcelable */
    static class C09561 implements Creator<LinkMedia$$Parcelable> {
        C09561() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LinkMedia$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LinkMedia$$Parcelable(LinkMedia$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public LinkMedia$$Parcelable(LinkMedia linkMedia) {
        this.linkMedia$$0 = linkMedia;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.linkMedia$$0, parcel, i, new IdentityCollection());
    }

    public static void write(LinkMedia linkMedia, Parcel parcel, int i, IdentityCollection identityCollection) {
        int b = identityCollection.b(linkMedia);
        if (b != -1) {
            parcel.writeInt(b);
            return;
        }
        parcel.writeInt(identityCollection.a(linkMedia));
        RedditVideo$$Parcelable.write(linkMedia.redditVideo, parcel, i, identityCollection);
        LinkOEmbed$$Parcelable.write(linkMedia.oembed, parcel, i, identityCollection);
    }

    public LinkMedia getParcel() {
        return this.linkMedia$$0;
    }

    public static LinkMedia read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            LinkMedia linkMedia = new LinkMedia();
            identityCollection.a(a, linkMedia);
            linkMedia.redditVideo = RedditVideo$$Parcelable.read(parcel, identityCollection);
            linkMedia.oembed = LinkOEmbed$$Parcelable.read(parcel, identityCollection);
            identityCollection.a(readInt, linkMedia);
            return linkMedia;
        } else if (identityCollection.b(readInt) == null) {
            return (LinkMedia) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
