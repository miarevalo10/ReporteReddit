package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class LiveThread$$Parcelable implements Parcelable, ParcelWrapper<LiveThread> {
    public static final Creator<LiveThread$$Parcelable> CREATOR = new C17451();
    private LiveThread liveThread$$0;

    /* compiled from: LiveThread$$Parcelable */
    static class C17451 implements Creator<LiveThread$$Parcelable> {
        C17451() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LiveThread$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LiveThread$$Parcelable(LiveThread$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public LiveThread$$Parcelable(LiveThread liveThread) {
        this.liveThread$$0 = liveThread;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.liveThread$$0, parcel, i, new IdentityCollection());
    }

    public static void write(LiveThread liveThread, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) liveThread);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) liveThread));
        parcel.writeLong(liveThread._uniqueId);
        identityCollection = null;
        if (liveThread.viewer_count_fuzzed == 0) {
            i = -1;
        } else {
            parcel.writeInt(1);
            i = liveThread.viewer_count_fuzzed.booleanValue() != 0 ? 1 : 0;
        }
        parcel.writeInt(i);
        if (liveThread.nsfw == 0) {
            identityCollection = -1;
        } else {
            parcel.writeInt(1);
            if (liveThread.nsfw.booleanValue() != 0) {
                identityCollection = 1;
            }
        }
        parcel.writeInt(identityCollection);
        parcel.writeString(liveThread.description);
        parcel.writeString(liveThread.title);
        parcel.writeString(liveThread.resources_html);
        parcel.writeString(liveThread.subreddit);
        parcel.writeString(liveThread.name);
        parcel.writeString(liveThread.id);
        parcel.writeString(liveThread.websocket_url);
        parcel.writeInt(liveThread.viewer_count);
        parcel.writeString(liveThread.description_html);
        parcel.writeString(liveThread.state);
        parcel.writeLong(liveThread.created_utc);
    }

    public LiveThread getParcel() {
        return this.liveThread$$0;
    }

    public static LiveThread read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            Boolean bool;
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            LiveThread liveThread = new LiveThread(parcel.readLong());
            identityCollection.m28661a(a, liveThread);
            boolean z = false;
            Boolean bool2 = null;
            if (parcel.readInt() < 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() == 1);
            }
            liveThread.viewer_count_fuzzed = bool;
            if (parcel.readInt() >= 0) {
                if (parcel.readInt() == 1) {
                    z = true;
                }
                bool2 = Boolean.valueOf(z);
            }
            liveThread.nsfw = bool2;
            liveThread.description = parcel.readString();
            liveThread.title = parcel.readString();
            liveThread.resources_html = parcel.readString();
            liveThread.subreddit = parcel.readString();
            liveThread.name = parcel.readString();
            liveThread.id = parcel.readString();
            liveThread.websocket_url = parcel.readString();
            liveThread.viewer_count = parcel.readInt();
            liveThread.description_html = parcel.readString();
            liveThread.state = parcel.readString();
            liveThread.created_utc = parcel.readLong();
            identityCollection.m28661a(readInt, liveThread);
            return liveThread;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (LiveThread) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
