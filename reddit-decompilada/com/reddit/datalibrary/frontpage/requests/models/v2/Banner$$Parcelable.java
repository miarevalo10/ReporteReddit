package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class Banner$$Parcelable implements Parcelable, ParcelWrapper<Banner> {
    public static final Creator<Banner$$Parcelable> CREATOR = new C17401();
    private Banner banner$$0;

    /* compiled from: Banner$$Parcelable */
    static class C17401 implements Creator<Banner$$Parcelable> {
        C17401() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Banner$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Banner$$Parcelable(Banner$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public Banner$$Parcelable(Banner banner) {
        this.banner$$0 = banner;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.banner$$0, parcel, i, new IdentityCollection());
    }

    public static void write(Banner banner, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) banner);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) banner));
        parcel.writeLong(banner._uniqueId);
        parcel.writeString(banner.background_color);
        parcel.writeInt(banner.num_votes);
        parcel.writeString(banner.title_text);
        parcel.writeInt(banner.min_android_version);
        parcel.writeString(banner.deeplink_url);
        parcel.writeInt(banner.show_right_arrow);
        parcel.writeString(banner.id);
        parcel.writeString(banner.title_tag);
        parcel.writeString(banner.title_tag_icon);
    }

    public Banner getParcel() {
        return this.banner$$0;
    }

    public static Banner read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            Banner banner = new Banner(parcel.readLong());
            identityCollection.m28661a(a, banner);
            banner.background_color = parcel.readString();
            banner.num_votes = parcel.readInt();
            banner.title_text = parcel.readString();
            banner.min_android_version = parcel.readInt();
            banner.deeplink_url = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            banner.show_right_arrow = z;
            banner.id = parcel.readString();
            banner.title_tag = parcel.readString();
            banner.title_tag_icon = parcel.readString();
            identityCollection.m28661a(readInt, banner);
            return banner;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (Banner) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
