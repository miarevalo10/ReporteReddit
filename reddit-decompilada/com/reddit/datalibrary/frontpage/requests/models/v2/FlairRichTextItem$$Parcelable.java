package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class FlairRichTextItem$$Parcelable implements Parcelable, ParcelWrapper<FlairRichTextItem> {
    public static final Creator<FlairRichTextItem$$Parcelable> CREATOR = new C17421();
    private FlairRichTextItem flairRichTextItem$$0;

    /* compiled from: FlairRichTextItem$$Parcelable */
    static class C17421 implements Creator<FlairRichTextItem$$Parcelable> {
        C17421() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FlairRichTextItem$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FlairRichTextItem$$Parcelable(FlairRichTextItem$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public FlairRichTextItem$$Parcelable(FlairRichTextItem flairRichTextItem) {
        this.flairRichTextItem$$0 = flairRichTextItem;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.flairRichTextItem$$0, parcel, i, new IdentityCollection());
    }

    public static void write(FlairRichTextItem flairRichTextItem, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) flairRichTextItem);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) flairRichTextItem));
        parcel.writeString(flairRichTextItem.emojiMarkup);
        parcel.writeString(flairRichTextItem.emojiUrl);
        parcel.writeString(flairRichTextItem.typeString);
        parcel.writeString(flairRichTextItem.text);
    }

    public FlairRichTextItem getParcel() {
        return this.flairRichTextItem$$0;
    }

    public static FlairRichTextItem read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            FlairRichTextItem flairRichTextItem = new FlairRichTextItem();
            identityCollection.m28661a(a, flairRichTextItem);
            flairRichTextItem.emojiMarkup = parcel.readString();
            flairRichTextItem.emojiUrl = parcel.readString();
            flairRichTextItem.typeString = parcel.readString();
            flairRichTextItem.text = parcel.readString();
            identityCollection.m28661a(readInt, flairRichTextItem);
            return flairRichTextItem;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (FlairRichTextItem) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
