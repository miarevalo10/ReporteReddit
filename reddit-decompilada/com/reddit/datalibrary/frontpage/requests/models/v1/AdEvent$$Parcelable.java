package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import net.hockeyapp.android.UpdateFragment;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class AdEvent$$Parcelable implements Parcelable, ParcelWrapper<AdEvent> {
    public static final Creator<AdEvent$$Parcelable> CREATOR = new C09541();
    private AdEvent adEvent$$0;

    /* compiled from: AdEvent$$Parcelable */
    static class C09541 implements Creator<AdEvent$$Parcelable> {
        C09541() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AdEvent$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AdEvent$$Parcelable(AdEvent$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public AdEvent$$Parcelable(AdEvent adEvent) {
        this.adEvent$$0 = adEvent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.adEvent$$0, parcel, i, new IdentityCollection());
    }

    public static void write(AdEvent adEvent, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(adEvent);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(adEvent));
        i = Integer.TYPE;
        parcel.writeInt(((Integer) InjectionUtil.a(AdEvent.class, adEvent, "type")).intValue());
        parcel.writeString((String) InjectionUtil.a(AdEvent.class, adEvent, UpdateFragment.FRAGMENT_URL));
    }

    public AdEvent getParcel() {
        return this.adEvent$$0;
    }

    public static AdEvent read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            AdEvent adEvent = new AdEvent();
            identityCollection.a(a, adEvent);
            InjectionUtil.a(AdEvent.class, adEvent, "type", Integer.valueOf(parcel.readInt()));
            InjectionUtil.a(AdEvent.class, adEvent, UpdateFragment.FRAGMENT_URL, parcel.readString());
            identityCollection.a(readInt, adEvent);
            return adEvent;
        } else if (identityCollection.b(readInt) == null) {
            return (AdEvent) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
