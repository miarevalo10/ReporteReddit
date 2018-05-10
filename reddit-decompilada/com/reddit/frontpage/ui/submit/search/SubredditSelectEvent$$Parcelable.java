package com.reddit.frontpage.ui.submit.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class SubredditSelectEvent$$Parcelable implements Parcelable, ParcelWrapper<SubredditSelectEvent> {
    public static final Creator<SubredditSelectEvent$$Parcelable> CREATOR = new C19111();
    private SubredditSelectEvent subredditSelectEvent$$0;

    /* compiled from: SubredditSelectEvent$$Parcelable */
    static class C19111 implements Creator<SubredditSelectEvent$$Parcelable> {
        C19111() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SubredditSelectEvent$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SubredditSelectEvent$$Parcelable(SubredditSelectEvent$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public SubredditSelectEvent$$Parcelable(SubredditSelectEvent subredditSelectEvent) {
        this.subredditSelectEvent$$0 = subredditSelectEvent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.subredditSelectEvent$$0, parcel, i, new IdentityCollection());
    }

    public static void write(SubredditSelectEvent subredditSelectEvent, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) subredditSelectEvent);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) subredditSelectEvent));
        parcel.writeString(subredditSelectEvent.requestId);
        parcel.writeString(subredditSelectEvent.subredditName);
        parcel.writeString(subredditSelectEvent.subredditId);
        parcel.writeString(subredditSelectEvent.icon);
        parcel.writeString(subredditSelectEvent.keyColor);
    }

    public SubredditSelectEvent getParcel() {
        return this.subredditSelectEvent$$0;
    }

    public static SubredditSelectEvent read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            Parcel subredditSelectEvent = new SubredditSelectEvent(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            identityCollection.m28661a(a, subredditSelectEvent);
            identityCollection.m28661a(readInt, subredditSelectEvent);
            return subredditSelectEvent;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (SubredditSelectEvent) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
