package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class MediaDescriptionCompatApi21 {

    static class Builder {
        public static Object m856a() {
            return new android.media.MediaDescription.Builder();
        }

        public static void m862a(Object obj, String str) {
            ((android.media.MediaDescription.Builder) obj).setMediaId(str);
        }

        public static void m861a(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setTitle(charSequence);
        }

        public static void m863b(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        public static void m864c(Object obj, CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setDescription(charSequence);
        }

        public static void m858a(Object obj, Bitmap bitmap) {
            ((android.media.MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        public static void m859a(Object obj, Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setIconUri(uri);
        }

        public static void m860a(Object obj, Bundle bundle) {
            ((android.media.MediaDescription.Builder) obj).setExtras(bundle);
        }

        public static Object m857a(Object obj) {
            return ((android.media.MediaDescription.Builder) obj).build();
        }
    }

    public static String m866a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence m868b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m869c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m870d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m871e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m872f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m873g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void m867a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object m865a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }
}
