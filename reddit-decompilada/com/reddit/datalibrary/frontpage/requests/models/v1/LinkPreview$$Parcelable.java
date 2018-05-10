package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class LinkPreview$$Parcelable implements Parcelable, ParcelWrapper<LinkPreview> {
    public static final Creator<LinkPreview$$Parcelable> CREATOR = new C09581();
    private LinkPreview linkPreview$$0;

    /* compiled from: LinkPreview$$Parcelable */
    static class C09581 implements Creator<LinkPreview$$Parcelable> {
        C09581() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LinkPreview$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LinkPreview$$Parcelable(LinkPreview$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public LinkPreview$$Parcelable(LinkPreview linkPreview) {
        this.linkPreview$$0 = linkPreview;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.linkPreview$$0, parcel, i, new IdentityCollection());
    }

    public static void write(LinkPreview linkPreview, Parcel parcel, int i, IdentityCollection identityCollection) {
        int b = identityCollection.b(linkPreview);
        if (b != -1) {
            parcel.writeInt(b);
            return;
        }
        parcel.writeInt(identityCollection.a(linkPreview));
        parcel.writeParcelable(linkPreview.mp4, i);
        parcel.writeParcelable(linkPreview.gif, i);
        if (linkPreview.mp4Resolutions == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(linkPreview.mp4Resolutions.size());
            for (ImageResolution writeParcelable : linkPreview.mp4Resolutions) {
                parcel.writeParcelable(writeParcelable, i);
            }
        }
        parcel.writeParcelable(linkPreview.source, i);
        if (linkPreview.gifResolutions == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(linkPreview.gifResolutions.size());
            for (ImageResolution writeParcelable2 : linkPreview.gifResolutions) {
                parcel.writeParcelable(writeParcelable2, i);
            }
        }
        RedditVideo$$Parcelable.write(linkPreview.redditVideoPreview, parcel, i, identityCollection);
        parcel.writeParcelable(linkPreview.obfuscated, i);
        if (linkPreview.sourceResolutions == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(linkPreview.sourceResolutions.size());
            for (ImageResolution writeParcelable3 : linkPreview.sourceResolutions) {
                parcel.writeParcelable(writeParcelable3, i);
            }
        }
        if (linkPreview.obfuscatedResolutions == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(linkPreview.obfuscatedResolutions.size());
        for (ImageResolution writeParcelable4 : linkPreview.obfuscatedResolutions) {
            parcel.writeParcelable(writeParcelable4, i);
        }
    }

    public LinkPreview getParcel() {
        return this.linkPreview$$0;
    }

    public static LinkPreview read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            List list;
            int i;
            int a = identityCollection.a(IdentityCollection.a);
            LinkPreview linkPreview = new LinkPreview();
            identityCollection.a(a, linkPreview);
            linkPreview.mp4 = (ImageResolution) parcel.readParcelable(LinkPreview$$Parcelable.class.getClassLoader());
            linkPreview.gif = (ImageResolution) parcel.readParcelable(LinkPreview$$Parcelable.class.getClassLoader());
            a = parcel.readInt();
            int i2 = 0;
            List list2 = null;
            if (a < 0) {
                list = null;
            } else {
                list = new ArrayList(a);
                for (i = 0; i < a; i++) {
                    list.add((ImageResolution) parcel.readParcelable(LinkPreview$$Parcelable.class.getClassLoader()));
                }
            }
            linkPreview.mp4Resolutions = list;
            linkPreview.source = (ImageResolution) parcel.readParcelable(LinkPreview$$Parcelable.class.getClassLoader());
            a = parcel.readInt();
            if (a < 0) {
                list = null;
            } else {
                list = new ArrayList(a);
                for (i = 0; i < a; i++) {
                    list.add((ImageResolution) parcel.readParcelable(LinkPreview$$Parcelable.class.getClassLoader()));
                }
            }
            linkPreview.gifResolutions = list;
            linkPreview.redditVideoPreview = RedditVideo$$Parcelable.read(parcel, identityCollection);
            linkPreview.obfuscated = (ImageResolution) parcel.readParcelable(LinkPreview$$Parcelable.class.getClassLoader());
            a = parcel.readInt();
            if (a < 0) {
                list = null;
            } else {
                list = new ArrayList(a);
                for (i = 0; i < a; i++) {
                    list.add((ImageResolution) parcel.readParcelable(LinkPreview$$Parcelable.class.getClassLoader()));
                }
            }
            linkPreview.sourceResolutions = list;
            a = parcel.readInt();
            if (a >= 0) {
                list2 = new ArrayList(a);
                while (i2 < a) {
                    list2.add((ImageResolution) parcel.readParcelable(LinkPreview$$Parcelable.class.getClassLoader()));
                    i2++;
                }
            }
            linkPreview.obfuscatedResolutions = list2;
            identityCollection.a(readInt, linkPreview);
            return linkPreview;
        } else if (identityCollection.b(readInt) == null) {
            return (LinkPreview) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
