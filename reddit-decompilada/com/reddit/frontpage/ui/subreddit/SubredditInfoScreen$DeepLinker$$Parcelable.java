package com.reddit.frontpage.ui.subreddit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class SubredditInfoScreen$DeepLinker$$Parcelable implements Parcelable, ParcelWrapper<DeepLinker> {
    public static final Creator<SubredditInfoScreen$DeepLinker$$Parcelable> CREATOR = new C19131();
    private DeepLinker deepLinker$$0;

    /* compiled from: SubredditInfoScreen$DeepLinker$$Parcelable */
    static class C19131 implements Creator<SubredditInfoScreen$DeepLinker$$Parcelable> {
        C19131() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SubredditInfoScreen$DeepLinker$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SubredditInfoScreen$DeepLinker$$Parcelable(SubredditInfoScreen$DeepLinker$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public SubredditInfoScreen$DeepLinker$$Parcelable(DeepLinker deepLinker) {
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
        parcel.writeString(deepLinker.subredditName);
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
            deepLinker.subredditName = parcel.readString();
            identityCollection.m28661a(readInt, deepLinker);
            return deepLinker;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (DeepLinker) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
