package com.twitter.sdk.android.tweetui.internal;

import java.util.Locale;

final class MediaTimeUtils {
    static String m25955a(long j) {
        j = (int) (j / 1000);
        int i = j % 60;
        int i2 = (j / 60) % 60;
        if (j / 3600 > null) {
            return String.format(Locale.getDefault(), "%1$d:%2$02d:%3$02d", new Object[]{Integer.valueOf(j / 3600), Integer.valueOf(i2), Integer.valueOf(i)});
        }
        return String.format(Locale.getDefault(), "%1$d:%2$02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }
}
