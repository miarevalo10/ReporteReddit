package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread$;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class LiveThreadProvider$$Parcelable implements Parcelable, ParcelWrapper<LiveThreadProvider> {
    public static final Creator<LiveThreadProvider$$Parcelable> CREATOR = new C09391();
    private LiveThreadProvider liveThreadProvider$$0;

    /* compiled from: LiveThreadProvider$$Parcelable */
    static class C09391 implements Creator<LiveThreadProvider$$Parcelable> {
        C09391() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LiveThreadProvider$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LiveThreadProvider$$Parcelable(LiveThreadProvider$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public LiveThreadProvider$$Parcelable(LiveThreadProvider liveThreadProvider) {
        this.liveThreadProvider$$0 = liveThreadProvider;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.liveThreadProvider$$0, parcel, i, new IdentityCollection());
    }

    public static void write(LiveThreadProvider liveThreadProvider, Parcel parcel, int i, IdentityCollection identityCollection) {
        int b = identityCollection.b(liveThreadProvider);
        if (b != -1) {
            parcel.writeInt(b);
            return;
        }
        parcel.writeInt(identityCollection.a(liveThreadProvider));
        LiveThread$.Parcelable.write(liveThreadProvider.liveThread, parcel, i, identityCollection);
        parcel.writeString(liveThreadProvider.liveThreadId);
        parcel.writeString(liveThreadProvider.providerId);
        parcel.writeString(liveThreadProvider.ownerId);
    }

    public LiveThreadProvider getParcel() {
        return this.liveThreadProvider$$0;
    }

    public static LiveThreadProvider read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            LiveThreadProvider liveThreadProvider = new LiveThreadProvider();
            identityCollection.a(a, liveThreadProvider);
            liveThreadProvider.liveThread = LiveThread$.Parcelable.read(parcel, identityCollection);
            liveThreadProvider.liveThreadId = parcel.readString();
            liveThreadProvider.providerId = parcel.readString();
            liveThreadProvider.ownerId = parcel.readString();
            identityCollection.a(readInt, liveThreadProvider);
            return liveThreadProvider;
        } else if (identityCollection.b(readInt) == null) {
            return (LiveThreadProvider) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
