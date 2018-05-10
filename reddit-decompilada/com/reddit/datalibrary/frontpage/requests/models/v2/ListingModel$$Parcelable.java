package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class ListingModel$$Parcelable implements Parcelable, ParcelWrapper<ListingModel> {
    public static final Creator<ListingModel$$Parcelable> CREATOR = new C17441();
    private ListingModel listingModel$$0;

    /* compiled from: ListingModel$$Parcelable */
    static class C17441 implements Creator<ListingModel$$Parcelable> {
        C17441() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ListingModel$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ListingModel$$Parcelable(ListingModel$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public ListingModel$$Parcelable(ListingModel listingModel) {
        this.listingModel$$0 = listingModel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.listingModel$$0, parcel, i, new IdentityCollection());
    }

    public static void write(ListingModel listingModel, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) listingModel);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) listingModel));
        parcel.writeString(listingModel.adDistance);
        new AutoParcelConverter().mo6362c(listingModel.entities, parcel);
        parcel.writeString(listingModel.before);
        parcel.writeString(listingModel.after);
        if (listingModel.entityIds == 0) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(listingModel.entityIds.size());
            for (Long l : listingModel.entityIds) {
                if (l == null) {
                    parcel.writeInt(-1);
                } else {
                    parcel.writeInt(1);
                    parcel.writeLong(l.longValue());
                }
            }
        }
        if (listingModel.videoLinks == 0) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(listingModel.videoLinks.size());
        for (SubmittedVideoLink writeSerializable : listingModel.videoLinks) {
            parcel.writeSerializable(writeSerializable);
        }
    }

    public ListingModel getParcel() {
        return this.listingModel$$0;
    }

    public static ListingModel read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            Set set;
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            ListingModel listingModel = new ListingModel();
            identityCollection.m28661a(a, listingModel);
            listingModel.adDistance = parcel.readString();
            listingModel.entities = (List) new AutoParcelConverter().mo6361c(parcel);
            listingModel.before = parcel.readString();
            listingModel.after = parcel.readString();
            a = parcel.readInt();
            int i = 0;
            List list = null;
            if (a < 0) {
                set = null;
            } else {
                set = new HashSet(a);
                for (int i2 = 0; i2 < a; i2++) {
                    Object obj;
                    if (parcel.readInt() < 0) {
                        obj = null;
                    } else {
                        obj = Long.valueOf(parcel.readLong());
                    }
                    set.add(obj);
                }
            }
            listingModel.entityIds = set;
            a = parcel.readInt();
            if (a >= 0) {
                list = new ArrayList(a);
                while (i < a) {
                    list.add((SubmittedVideoLink) parcel.readSerializable());
                    i++;
                }
            }
            listingModel.videoLinks = list;
            identityCollection.m28661a(readInt, listingModel);
            return listingModel;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (ListingModel) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
