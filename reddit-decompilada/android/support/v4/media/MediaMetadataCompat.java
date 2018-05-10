package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new C01091();
    static final ArrayMap<String, Integer> f1270a;
    private static final String[] f1271c = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    private static final String[] f1272d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    private static final String[] f1273e = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    final Bundle f1274b;
    private Object f1275f;

    static class C01091 implements Creator<MediaMetadataCompat> {
        C01091() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }
    }

    public final int describeContents() {
        return 0;
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f1270a = arrayMap;
        arrayMap.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f1270a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f1270a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f1270a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f1270a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f1270a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f1270a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f1270a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f1270a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f1270a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f1270a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f1270a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f1270a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f1270a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f1270a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f1270a.put("android.media.metadata.ART", Integer.valueOf(2));
        f1270a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f1270a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f1270a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f1270a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f1270a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f1270a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f1270a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f1270a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f1270a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f1270a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        f1270a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        f1270a.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        f1270a.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        f1270a.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
        f1270a.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f1274b = parcel.readBundle();
        this.f1274b.setClassLoader(MediaMetadataCompat.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f1274b);
    }

    public static MediaMetadataCompat m874a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        MediaMetadataCompatApi21.m875a(obj, obtain);
        obtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.f1275f = obj;
        return mediaMetadataCompat;
    }
}
