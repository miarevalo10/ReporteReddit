package com.reddit.datalibrary.frontpage.service.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.TranscodingCompleteEvent;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class VideoUploadService$TranscodingCompleteEvent$$Parcelable implements Parcelable, ParcelWrapper<TranscodingCompleteEvent> {
    public static final Creator<VideoUploadService$TranscodingCompleteEvent$$Parcelable> CREATOR = new C17561();
    private TranscodingCompleteEvent transcodingCompleteEvent$$0;

    /* compiled from: VideoUploadService$TranscodingCompleteEvent$$Parcelable */
    static class C17561 implements Creator<VideoUploadService$TranscodingCompleteEvent$$Parcelable> {
        C17561() {
        }

        public final VideoUploadService$TranscodingCompleteEvent$$Parcelable createFromParcel(Parcel parcel) {
            return new VideoUploadService$TranscodingCompleteEvent$$Parcelable(VideoUploadService$TranscodingCompleteEvent$$Parcelable.read(parcel, new IdentityCollection()));
        }

        public final VideoUploadService$TranscodingCompleteEvent$$Parcelable[] newArray(int i) {
            return new VideoUploadService$TranscodingCompleteEvent$$Parcelable[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public VideoUploadService$TranscodingCompleteEvent$$Parcelable(TranscodingCompleteEvent transcodingCompleteEvent) {
        this.transcodingCompleteEvent$$0 = transcodingCompleteEvent;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.transcodingCompleteEvent$$0, parcel, i, new IdentityCollection());
    }

    public static void write(TranscodingCompleteEvent transcodingCompleteEvent, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) transcodingCompleteEvent);
        if (i == -1) {
            parcel.writeInt(identityCollection.m28660a((Object) transcodingCompleteEvent));
            parcel.writeString(transcodingCompleteEvent.key);
            i = transcodingCompleteEvent.success != null ? 1 : 0;
        }
        parcel.writeInt(i);
    }

    public TranscodingCompleteEvent getParcel() {
        return this.transcodingCompleteEvent$$0;
    }

    public static TranscodingCompleteEvent read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            String readString = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            parcel = new TranscodingCompleteEvent(readString, z);
            identityCollection.m28661a(a, parcel);
            identityCollection.m28661a(readInt, parcel);
            return parcel;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (TranscodingCompleteEvent) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
