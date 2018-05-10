package com.reddit.frontpage.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.FrontpageApplication;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoUtil {
    private static final AtomicInteger f21819a = new AtomicInteger(0);

    public static boolean m24055a(Uri uri) {
        uri = uri.getHost();
        if (TextUtils.isEmpty(uri)) {
            return false;
        }
        if (!uri.endsWith(".youtube.com")) {
            if (uri.equals("youtu.be") == null) {
                uri = null;
                boolean z = FrontpageApplication.f27402a.getPackageManager().getLaunchIntentForPackage("com.google.android.youtube") == null;
                if (uri == null && z) {
                    return true;
                }
                return false;
            }
        }
        uri = 1;
        if (FrontpageApplication.f27402a.getPackageManager().getLaunchIntentForPackage("com.google.android.youtube") == null) {
        }
        if (uri == null) {
        }
        return false;
    }

    public static String m24053a(Link link) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(link.getId());
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(link.getInstanceId());
        String stringBuilder2 = stringBuilder.toString();
        if (Util.m24034h(link) != null) {
            return stringBuilder2;
        }
        return String.format(Locale.US, "%s%08d", new Object[]{stringBuilder2, Integer.valueOf(f21819a.getAndIncrement())});
    }

    public static boolean m24056a(String str) {
        return str.endsWith(".mpd");
    }

    public static boolean m24054a() {
        switch (FrontpageSettings.a().h()) {
            case 1:
                return true;
            case 2:
                return NetworkUtil.m23843c();
            default:
                return false;
        }
    }

    public static Bitmap m24052a(Context context, String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
        return mediaMetadataRetriever.getFrameAtTime(1000 * Long.parseLong(mediaMetadataRetriever.extractMetadata(9)), 2);
    }
}
