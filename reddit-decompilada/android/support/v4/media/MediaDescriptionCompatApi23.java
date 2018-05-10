package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class MediaDescriptionCompatApi23 extends MediaDescriptionCompatApi21 {

    static class Builder extends Builder {
        public static void m10036b(Object obj, Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri m10037h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
