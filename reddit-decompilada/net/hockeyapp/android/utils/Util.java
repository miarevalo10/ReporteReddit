package net.hockeyapp.android.utils;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class Util {
    private static final Pattern f26619a = Pattern.compile("[0-9a-f]+", 2);
    private static final ThreadLocal<DateFormat> f26620b = new C21631();

    static class C21631 extends ThreadLocal<DateFormat> {
        C21631() {
        }

        protected final /* synthetic */ Object initialValue() {
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    }

    public static String m28233a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Failed to encode param ");
            stringBuilder.append(str);
            HockeyLog.m28206a(stringBuilder.toString(), e);
            return "";
        }
    }

    public static boolean m28240b(String str) {
        return (TextUtils.isEmpty(str) || Patterns.EMAIL_ADDRESS.matcher(str).matches() == null) ? null : true;
    }

    public static Notification m28231a(Context context, PendingIntent pendingIntent, String str, String str2, int i, String str3) {
        Builder builder;
        if (VERSION.SDK_INT >= 26) {
            builder = new Builder(context, str3);
        } else {
            builder = new Builder(context);
        }
        builder.setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).setSmallIcon(i);
        if (VERSION.SDK_INT >= 16) {
            return builder.build();
        }
        return builder.getNotification();
    }

    public static void m28236a(Context context, Notification notification, String str, CharSequence charSequence) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(str, charSequence, 3));
        }
        notificationManager.notify(2, notification);
    }

    public static void m28235a(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(2);
    }

    public static void m28237a(View view, CharSequence charSequence) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(VERSION.SDK_INT < 16 ? 8 : 16384);
            obtain.getText().add(charSequence);
            obtain.setSource(view);
            obtain.setEnabled(view.isEnabled());
            obtain.setClassName(view.getClass().getName());
            obtain.setPackageName(view.getContext().getPackageName());
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    public static boolean m28239b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                context = connectivityManager.getActiveNetworkInfo();
                if (context == null || context.isConnected() == null) {
                    return false;
                }
                return true;
            }
        } catch (Throwable e) {
            HockeyLog.m28206a("Exception thrown when check network is connected", e);
        }
        return false;
    }

    public static java.lang.String m28241c(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.getPackageManager();
        r1 = r3.getApplicationInfo();	 Catch:{ NameNotFoundException -> 0x0010 }
        r1 = r1.packageName;	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0010 }
        r1 = r0.getApplicationInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r1 = 0;
    L_0x0011:
        if (r1 == 0) goto L_0x001a;
    L_0x0013:
        r3 = r0.getApplicationLabel(r1);
        r3 = (java.lang.String) r3;
        return r3;
    L_0x001a:
        r0 = net.hockeyapp.android.C2158R.string.hockeyapp_crash_dialog_app_name_fallback;
        r3 = r3.getString(r0);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.Util.c(android.content.Context):java.lang.String");
    }

    public static java.lang.String m28232a(java.io.InputStream r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.BufferedReader;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r3);
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0.<init>(r1, r2);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x0011:
        r2 = r0.readLine();	 Catch:{ IOException -> 0x0026 }
        if (r2 == 0) goto L_0x0020;	 Catch:{ IOException -> 0x0026 }
    L_0x0017:
        r1.append(r2);	 Catch:{ IOException -> 0x0026 }
        r2 = 10;	 Catch:{ IOException -> 0x0026 }
        r1.append(r2);	 Catch:{ IOException -> 0x0026 }
        goto L_0x0011;
    L_0x0020:
        r3.close();	 Catch:{ IOException -> 0x002d }
        goto L_0x002d;
    L_0x0024:
        r0 = move-exception;
        goto L_0x0032;
    L_0x0026:
        r0 = move-exception;
        r2 = "Failed to convert stream to string";	 Catch:{ all -> 0x0024 }
        net.hockeyapp.android.utils.HockeyLog.m28206a(r2, r0);	 Catch:{ all -> 0x0024 }
        goto L_0x0020;
    L_0x002d:
        r3 = r1.toString();
        return r3;
    L_0x0032:
        r3.close();	 Catch:{ IOException -> 0x0035 }
    L_0x0035:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.Util.a(java.io.InputStream):java.lang.String");
    }

    public static byte[] m28238a(byte[] bArr, String str) throws NoSuchAlgorithmException {
        str = MessageDigest.getInstance(str);
        str.update(bArr);
        return str.digest();
    }

    public static String m28234a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            while (toHexString.length() < 2) {
                StringBuilder stringBuilder2 = new StringBuilder("0");
                stringBuilder2.append(toHexString);
                toHexString = stringBuilder2.toString();
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }
}
