package com.twitter.sdk.android.tweetui;

import android.content.res.Resources;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

final class TweetDateUtils {
    static final SimpleDateFormat f24211a = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
    static final SimpleDateFormat f24212b = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);

    static long m25920a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = -1;
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = f24211a;	 Catch:{ ParseException -> 0x0010 }
        r4 = r2.parse(r4);	 Catch:{ ParseException -> 0x0010 }
        r2 = r4.getTime();	 Catch:{ ParseException -> 0x0010 }
        return r2;
    L_0x0010:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetDateUtils.a(java.lang.String):long");
    }

    static boolean m25922b(String str) {
        return m25920a(str) != -1 ? true : null;
    }

    public static String m25923c(String str) {
        if (str.charAt(0) == '•') {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("• ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    static String m25921a(Resources resources, long j, long j2) {
        long j3 = j - j2;
        if (j3 < 0) {
            f24212b.applyPattern(resources.getString(C2075R.string.tw__relative_date_format_long));
            return f24212b.format(new Date(j2));
        } else if (j3 < 60000) {
            j = (int) (j3 / 1000);
            return resources.getQuantityString(C2075R.plurals.tw__time_secs, j, new Object[]{Integer.valueOf(j)});
        } else if (j3 < 3600000) {
            j = (int) (j3 / 60000);
            return resources.getQuantityString(C2075R.plurals.tw__time_mins, j, new Object[]{Integer.valueOf(j)});
        } else if (j3 < 86400000) {
            j = (int) (j3 / 3600000);
            return resources.getQuantityString(C2075R.plurals.tw__time_hours, j, new Object[]{Integer.valueOf(j)});
        } else {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            j = Calendar.getInstance();
            j.setTimeInMillis(j2);
            Date date = new Date(j2);
            if (instance.get(1) == j.get(1)) {
                f24212b.applyPattern(resources.getString(C2075R.string.tw__relative_date_format_short));
            } else {
                f24212b.applyPattern(resources.getString(C2075R.string.tw__relative_date_format_long));
            }
            return f24212b.format(date);
        }
    }
}
