package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.google.android.gms.ads.AdRequest;
import com.instabug.chat.model.Attachment;

public final class MediaStoreUtil {
    public static boolean m2872a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= AdRequest.MAX_CONTENT_URL_LENGTH && i2 <= 384;
    }

    public static boolean m2873a(Uri uri) {
        return (uri == null || !"content".equals(uri.getScheme()) || "media".equals(uri.getAuthority()) == null) ? null : true;
    }

    private static boolean m2876d(Uri uri) {
        return uri.getPathSegments().contains(Attachment.TYPE_VIDEO);
    }

    public static boolean m2874b(Uri uri) {
        return (!m2873a(uri) || m2876d(uri) == null) ? null : true;
    }

    public static boolean m2875c(Uri uri) {
        return (m2873a(uri) && m2876d(uri) == null) ? true : null;
    }
}
