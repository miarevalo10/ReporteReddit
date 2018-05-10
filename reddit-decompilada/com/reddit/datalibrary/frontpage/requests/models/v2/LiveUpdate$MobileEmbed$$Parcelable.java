package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate.MobileEmbed;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class LiveUpdate$MobileEmbed$$Parcelable implements Parcelable, ParcelWrapper<MobileEmbed> {
    public static final Creator<LiveUpdate$MobileEmbed$$Parcelable> CREATOR = new C17471();
    private MobileEmbed mobileEmbed$$0;

    /* compiled from: LiveUpdate$MobileEmbed$$Parcelable */
    static class C17471 implements Creator<LiveUpdate$MobileEmbed$$Parcelable> {
        C17471() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LiveUpdate$MobileEmbed$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LiveUpdate$MobileEmbed$$Parcelable(LiveUpdate$MobileEmbed$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public LiveUpdate$MobileEmbed$$Parcelable(MobileEmbed mobileEmbed) {
        this.mobileEmbed$$0 = mobileEmbed;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.mobileEmbed$$0, parcel, i, new IdentityCollection());
    }

    public static void write(MobileEmbed mobileEmbed, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) mobileEmbed);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) mobileEmbed));
        parcel.writeString(mobileEmbed.original_url);
        parcel.writeInt(mobileEmbed.width);
        parcel.writeInt(mobileEmbed.thumbnail_width);
        parcel.writeString(mobileEmbed.description);
        parcel.writeString(mobileEmbed.provider_url);
        parcel.writeString(mobileEmbed.thumbnail_url);
        parcel.writeString(mobileEmbed.title);
        parcel.writeString(mobileEmbed.provider_name);
        parcel.writeString(mobileEmbed.type);
        parcel.writeString(mobileEmbed.url);
        parcel.writeInt(mobileEmbed.height);
        parcel.writeInt(mobileEmbed.thumbnail_height);
    }

    public MobileEmbed getParcel() {
        return this.mobileEmbed$$0;
    }

    public static MobileEmbed read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            MobileEmbed mobileEmbed = new MobileEmbed();
            identityCollection.m28661a(a, mobileEmbed);
            mobileEmbed.original_url = parcel.readString();
            mobileEmbed.width = parcel.readInt();
            mobileEmbed.thumbnail_width = parcel.readInt();
            mobileEmbed.description = parcel.readString();
            mobileEmbed.provider_url = parcel.readString();
            mobileEmbed.thumbnail_url = parcel.readString();
            mobileEmbed.title = parcel.readString();
            mobileEmbed.provider_name = parcel.readString();
            mobileEmbed.type = parcel.readString();
            mobileEmbed.url = parcel.readString();
            mobileEmbed.height = parcel.readInt();
            mobileEmbed.thumbnail_height = parcel.readInt();
            identityCollection.m28661a(readInt, mobileEmbed);
            return mobileEmbed;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (MobileEmbed) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
