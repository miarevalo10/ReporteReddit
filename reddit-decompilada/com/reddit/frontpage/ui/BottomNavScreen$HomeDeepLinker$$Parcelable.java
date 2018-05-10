package com.reddit.frontpage.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class BottomNavScreen$HomeDeepLinker$$Parcelable implements Parcelable, ParcelWrapper<HomeDeepLinker> {
    public static final Creator<BottomNavScreen$HomeDeepLinker$$Parcelable> CREATOR = new C18771();
    private HomeDeepLinker homeDeepLinker$$0;

    /* compiled from: BottomNavScreen$HomeDeepLinker$$Parcelable */
    static class C18771 implements Creator<BottomNavScreen$HomeDeepLinker$$Parcelable> {
        C18771() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BottomNavScreen$HomeDeepLinker$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BottomNavScreen$HomeDeepLinker$$Parcelable(BottomNavScreen$HomeDeepLinker$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public BottomNavScreen$HomeDeepLinker$$Parcelable(HomeDeepLinker homeDeepLinker) {
        this.homeDeepLinker$$0 = homeDeepLinker;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.homeDeepLinker$$0, parcel, i, new IdentityCollection());
    }

    public static void write(HomeDeepLinker homeDeepLinker, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) homeDeepLinker);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) homeDeepLinker));
        parcel.writeInt(homeDeepLinker.homePosition);
    }

    public HomeDeepLinker getParcel() {
        return this.homeDeepLinker$$0;
    }

    public static HomeDeepLinker read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            HomeDeepLinker homeDeepLinker = new HomeDeepLinker(parcel.readInt());
            identityCollection.m28661a(a, homeDeepLinker);
            identityCollection.m28661a(readInt, homeDeepLinker);
            return homeDeepLinker;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (HomeDeepLinker) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
