package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate.MobileEmbed;
import java.util.ArrayList;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class LiveUpdate$$Parcelable implements Parcelable, ParcelWrapper<LiveUpdate> {
    public static final Creator<LiveUpdate$$Parcelable> CREATOR = new C17461();
    private LiveUpdate liveUpdate$$0;

    /* compiled from: LiveUpdate$$Parcelable */
    static class C17461 implements Creator<LiveUpdate$$Parcelable> {
        C17461() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LiveUpdate$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LiveUpdate$$Parcelable(LiveUpdate$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public LiveUpdate$$Parcelable(LiveUpdate liveUpdate) {
        this.liveUpdate$$0 = liveUpdate;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.liveUpdate$$0, parcel, i, new IdentityCollection());
    }

    public static void write(LiveUpdate liveUpdate, Parcel parcel, int i, IdentityCollection identityCollection) {
        int b = identityCollection.m28663b((Object) liveUpdate);
        if (b != -1) {
            parcel.writeInt(b);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) liveUpdate));
        parcel.writeLong(liveUpdate._uniqueId);
        parcel.writeInt(liveUpdate.stricken);
        parcel.writeString(liveUpdate.body_html);
        parcel.writeString(liveUpdate.author);
        parcel.writeString(liveUpdate.name);
        parcel.writeString(liveUpdate.id);
        parcel.writeString(liveUpdate.body);
        parcel.writeLong(liveUpdate.created_utc);
        if (liveUpdate.mobile_embeds == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(liveUpdate.mobile_embeds.size());
        for (MobileEmbed write : liveUpdate.mobile_embeds) {
            LiveUpdate$MobileEmbed$$Parcelable.write(write, parcel, i, identityCollection);
        }
    }

    public LiveUpdate getParcel() {
        return this.liveUpdate$$0;
    }

    public static LiveUpdate read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            LiveUpdate liveUpdate = new LiveUpdate(parcel.readLong());
            identityCollection.m28661a(a, liveUpdate);
            int i = 0;
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            liveUpdate.stricken = z;
            liveUpdate.body_html = parcel.readString();
            liveUpdate.author = parcel.readString();
            liveUpdate.name = parcel.readString();
            liveUpdate.id = parcel.readString();
            liveUpdate.body = parcel.readString();
            liveUpdate.created_utc = parcel.readLong();
            a = parcel.readInt();
            if (a < 0) {
                parcel = null;
            } else {
                ArrayList arrayList = new ArrayList(a);
                while (i < a) {
                    arrayList.add(LiveUpdate$MobileEmbed$$Parcelable.read(parcel, identityCollection));
                    i++;
                }
                parcel = arrayList;
            }
            liveUpdate.mobile_embeds = parcel;
            identityCollection.m28661a(readInt, liveUpdate);
            return liveUpdate;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (LiveUpdate) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
