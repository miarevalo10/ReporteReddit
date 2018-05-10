package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class RedditVideo$$Parcelable implements Parcelable, ParcelWrapper<RedditVideo> {
    public static final Creator<RedditVideo$$Parcelable> CREATOR = new C09611();
    private RedditVideo redditVideo$$0;

    /* compiled from: RedditVideo$$Parcelable */
    static class C09611 implements Creator<RedditVideo$$Parcelable> {
        C09611() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RedditVideo$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RedditVideo$$Parcelable(RedditVideo$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public RedditVideo$$Parcelable(RedditVideo redditVideo) {
        this.redditVideo$$0 = redditVideo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.redditVideo$$0, parcel, i, new IdentityCollection());
    }

    public static void write(RedditVideo redditVideo, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(redditVideo);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(redditVideo));
        parcel.writeInt(redditVideo.duration);
        parcel.writeString(redditVideo.fallbackUrl);
        parcel.writeString(redditVideo.dashUrl);
        parcel.writeInt(redditVideo.isGif);
        parcel.writeInt(redditVideo.width);
        parcel.writeString(redditVideo.transcodingStatus);
        parcel.writeString(redditVideo.scrubberMediaUrl);
        parcel.writeInt(redditVideo.height);
        parcel.writeString(redditVideo.hlsUrl);
    }

    public RedditVideo getParcel() {
        return this.redditVideo$$0;
    }

    public static RedditVideo read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            RedditVideo redditVideo = new RedditVideo();
            identityCollection.a(a, redditVideo);
            redditVideo.duration = parcel.readInt();
            redditVideo.fallbackUrl = parcel.readString();
            redditVideo.dashUrl = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            redditVideo.isGif = z;
            redditVideo.width = parcel.readInt();
            redditVideo.transcodingStatus = parcel.readString();
            redditVideo.scrubberMediaUrl = parcel.readString();
            redditVideo.height = parcel.readInt();
            redditVideo.hlsUrl = parcel.readString();
            identityCollection.a(readInt, redditVideo);
            return redditVideo;
        } else if (identityCollection.b(readInt) == null) {
            return (RedditVideo) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
