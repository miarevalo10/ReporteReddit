package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class LinkFlair$$Parcelable implements Parcelable, ParcelWrapper<LinkFlair> {
    public static final Creator<LinkFlair$$Parcelable> CREATOR = new C17431();
    private LinkFlair linkFlair$$0;

    /* compiled from: LinkFlair$$Parcelable */
    static class C17431 implements Creator<LinkFlair$$Parcelable> {
        C17431() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LinkFlair$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LinkFlair$$Parcelable(LinkFlair$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public LinkFlair$$Parcelable(LinkFlair linkFlair) {
        this.linkFlair$$0 = linkFlair;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.linkFlair$$0, parcel, i, new IdentityCollection());
    }

    public static void write(LinkFlair linkFlair, Parcel parcel, int i, IdentityCollection identityCollection) {
        int b = identityCollection.m28663b((Object) linkFlair);
        if (b == -1) {
            parcel.writeInt(identityCollection.m28660a((Object) linkFlair));
            if (linkFlair.richtext == null) {
                parcel.writeInt(-1);
            } else {
                parcel.writeInt(linkFlair.richtext.size());
                for (FlairRichTextItem write : linkFlair.richtext) {
                    FlairRichTextItem$$Parcelable.write(write, parcel, i, identityCollection);
                }
            }
            parcel.writeString(linkFlair.text);
            parcel.writeString(linkFlair.id);
            parcel.writeString(linkFlair.type);
            b = linkFlair.text_editable != null ? 1 : 0;
        }
        parcel.writeInt(b);
    }

    public LinkFlair getParcel() {
        return this.linkFlair$$0;
    }

    public static LinkFlair read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            List list;
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            LinkFlair linkFlair = new LinkFlair();
            identityCollection.m28661a(a, linkFlair);
            a = parcel.readInt();
            if (a < 0) {
                list = null;
            } else {
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    arrayList.add(FlairRichTextItem$$Parcelable.read(parcel, identityCollection));
                }
                list = arrayList;
            }
            linkFlair.richtext = list;
            linkFlair.text = parcel.readString();
            linkFlair.id = parcel.readString();
            linkFlair.type = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            linkFlair.text_editable = z;
            identityCollection.m28661a(readInt, linkFlair);
            return linkFlair;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (LinkFlair) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
