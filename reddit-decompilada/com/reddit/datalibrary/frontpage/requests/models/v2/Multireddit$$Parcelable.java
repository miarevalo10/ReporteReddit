package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class Multireddit$$Parcelable implements Parcelable, ParcelWrapper<Multireddit> {
    public static final Creator<Multireddit$$Parcelable> CREATOR = new C17481();
    private Multireddit multireddit$$0;

    /* compiled from: Multireddit$$Parcelable */
    static class C17481 implements Creator<Multireddit$$Parcelable> {
        C17481() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Multireddit$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Multireddit$$Parcelable(Multireddit$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public Multireddit$$Parcelable(Multireddit multireddit) {
        this.multireddit$$0 = multireddit;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.multireddit$$0, parcel, i, new IdentityCollection());
    }

    public static void write(Multireddit multireddit, Parcel parcel, int i, IdentityCollection identityCollection) {
        int b = identityCollection.m28663b((Object) multireddit);
        if (b != -1) {
            parcel.writeInt(b);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) multireddit));
        parcel.writeString(multireddit.icon_url);
        parcel.writeString(multireddit.path);
        if (multireddit.subreddits == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(multireddit.subreddits.size());
            for (SubredditInfo write : multireddit.subreddits) {
                SubredditInfo$$Parcelable.write(write, parcel, i, identityCollection);
            }
        }
        parcel.writeString(multireddit.key_color);
        parcel.writeString(multireddit.name);
        parcel.writeInt(multireddit.can_edit);
        parcel.writeString(multireddit._username);
    }

    public Multireddit getParcel() {
        return this.multireddit$$0;
    }

    public static Multireddit read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            List list;
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            Multireddit multireddit = new Multireddit();
            identityCollection.m28661a(a, multireddit);
            multireddit.icon_url = parcel.readString();
            multireddit.path = parcel.readString();
            a = parcel.readInt();
            boolean z = false;
            if (a < 0) {
                list = null;
            } else {
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    arrayList.add(SubredditInfo$$Parcelable.read(parcel, identityCollection));
                }
                list = arrayList;
            }
            multireddit.subreddits = list;
            multireddit.key_color = parcel.readString();
            multireddit.name = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            }
            multireddit.can_edit = z;
            multireddit._username = parcel.readString();
            identityCollection.m28661a(readInt, multireddit);
            return multireddit;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (Multireddit) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
