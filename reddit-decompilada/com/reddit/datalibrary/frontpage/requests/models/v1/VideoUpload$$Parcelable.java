package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class VideoUpload$$Parcelable implements Parcelable, ParcelWrapper<VideoUpload> {
    public static final Creator<VideoUpload$$Parcelable> CREATOR = new C09621();
    private VideoUpload videoUpload$$0;

    /* compiled from: VideoUpload$$Parcelable */
    static class C09621 implements Creator<VideoUpload$$Parcelable> {
        C09621() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VideoUpload$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VideoUpload$$Parcelable(VideoUpload$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public VideoUpload$$Parcelable(VideoUpload videoUpload) {
        this.videoUpload$$0 = videoUpload;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.videoUpload$$0, parcel, i, new IdentityCollection());
    }

    public static void write(VideoUpload videoUpload, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(videoUpload);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(videoUpload));
        parcel.writeString(videoUpload.thumbnail);
        parcel.writeString(videoUpload.videoKey);
        parcel.writeInt(videoUpload.gif);
        parcel.writeString(videoUpload.filePath);
        parcel.writeString(videoUpload.source);
        parcel.writeString(videoUpload.title);
        parcel.writeLong(videoUpload.uploadDuration);
        parcel.writeString(videoUpload.uploadError);
        parcel.writeString(videoUpload.subreddit);
        parcel.writeInt(videoUpload.videoHeight);
        parcel.writeInt(videoUpload.duration);
        parcel.writeInt(videoUpload.videoWidth);
        parcel.writeInt(videoUpload.originalDuration);
        parcel.writeString(videoUpload.uploadUrl);
        parcel.writeString(videoUpload.posterUrl);
        parcel.writeString(videoUpload.requestId);
        parcel.writeInt(videoUpload.id);
        parcel.writeLong(videoUpload.timestamp);
        parcel.writeInt(videoUpload.status);
        parcel.writeInt(videoUpload.attempts);
    }

    public VideoUpload getParcel() {
        return this.videoUpload$$0;
    }

    public static VideoUpload read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            VideoUpload videoUpload = new VideoUpload();
            identityCollection.a(a, videoUpload);
            videoUpload.thumbnail = parcel.readString();
            videoUpload.videoKey = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            videoUpload.gif = z;
            videoUpload.filePath = parcel.readString();
            videoUpload.source = parcel.readString();
            videoUpload.title = parcel.readString();
            videoUpload.uploadDuration = parcel.readLong();
            videoUpload.uploadError = parcel.readString();
            videoUpload.subreddit = parcel.readString();
            videoUpload.videoHeight = parcel.readInt();
            videoUpload.duration = parcel.readInt();
            videoUpload.videoWidth = parcel.readInt();
            videoUpload.originalDuration = parcel.readInt();
            videoUpload.uploadUrl = parcel.readString();
            videoUpload.posterUrl = parcel.readString();
            videoUpload.requestId = parcel.readString();
            videoUpload.id = parcel.readInt();
            videoUpload.timestamp = parcel.readLong();
            videoUpload.status = parcel.readInt();
            videoUpload.attempts = parcel.readInt();
            identityCollection.a(readInt, videoUpload);
            return videoUpload;
        } else if (identityCollection.b(readInt) == null) {
            return (VideoUpload) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
