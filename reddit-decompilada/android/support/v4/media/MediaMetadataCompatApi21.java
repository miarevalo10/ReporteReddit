package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class MediaMetadataCompatApi21 {
    public static void m875a(Object obj, Parcel parcel) {
        ((MediaMetadata) obj).writeToParcel(parcel, 0);
    }
}
