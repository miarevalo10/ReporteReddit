package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class FlairRichTextItem$$Parcelable implements Parcelable, ParcelWrapper<FlairRichTextItem> {
    public static final Creator<FlairRichTextItem$$Parcelable> CREATOR = new C17851();
    private FlairRichTextItem flairRichTextItem$$0;

    /* compiled from: FlairRichTextItem$$Parcelable */
    static class C17851 implements Creator<FlairRichTextItem$$Parcelable> {
        C17851() {
        }

        public final FlairRichTextItem$$Parcelable createFromParcel(Parcel parcel) {
            return new FlairRichTextItem$$Parcelable(FlairRichTextItem$$Parcelable.read(parcel, new IdentityCollection()));
        }

        public final FlairRichTextItem$$Parcelable[] newArray(int i) {
            return new FlairRichTextItem$$Parcelable[i];
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
        parcel.writeString((String) InjectionUtil.m28667a(FlairRichTextItem.class, flairRichTextItem, "emojiMarkup"));
        parcel.writeString((String) InjectionUtil.m28667a(FlairRichTextItem.class, flairRichTextItem, "typeString"));
        parcel.writeString((String) InjectionUtil.m28667a(FlairRichTextItem.class, flairRichTextItem, "emojiUrl"));
        parcel.writeString((String) InjectionUtil.m28667a(FlairRichTextItem.class, flairRichTextItem, "text"));
    }

    public FlairRichTextItem getParcel() {
        return this.flairRichTextItem$$0;
    }

    public static FlairRichTextItem read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            FlairRichTextItem flairRichTextItem = new FlairRichTextItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            identityCollection.m28661a(a, flairRichTextItem);
            identityCollection.m28661a(readInt, flairRichTextItem);
            return flairRichTextItem;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (FlairRichTextItem) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
