package com.reddit.frontpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.frontpage.DetailHolderScreen.DeepLinker;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class DetailHolderScreen$DeepLinker$$Parcelable implements Parcelable, ParcelWrapper<DeepLinker> {
    public static final Creator<DetailHolderScreen$DeepLinker$$Parcelable> CREATOR = new C17591();
    private DeepLinker deepLinker$$0;

    /* compiled from: DetailHolderScreen$DeepLinker$$Parcelable */
    static class C17591 implements Creator<DetailHolderScreen$DeepLinker$$Parcelable> {
        C17591() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DetailHolderScreen$DeepLinker$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DetailHolderScreen$DeepLinker$$Parcelable(DetailHolderScreen$DeepLinker$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public DetailHolderScreen$DeepLinker$$Parcelable(DeepLinker deepLinker) {
        this.deepLinker$$0 = deepLinker;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.deepLinker$$0, parcel, i, new IdentityCollection());
    }

    public static void write(DeepLinker deepLinker, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) deepLinker);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) deepLinker));
        parcel.writeString(deepLinker.commentContext);
        parcel.writeString(deepLinker.linkId);
        parcel.writeString(deepLinker.comment);
    }

    public DeepLinker getParcel() {
        return this.deepLinker$$0;
    }

    public static DeepLinker read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            DeepLinker deepLinker = new DeepLinker();
            identityCollection.m28661a(a, deepLinker);
            deepLinker.commentContext = parcel.readString();
            deepLinker.linkId = parcel.readString();
            deepLinker.comment = parcel.readString();
            identityCollection.m28661a(readInt, deepLinker);
            return deepLinker;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (DeepLinker) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
