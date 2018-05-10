package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0436R;
import com.google.android.gms.common.util.zzq;
import com.google.firebase.iid.zzx;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class zza {
    private static zza f8697a;
    private final Context f8698b;
    private Bundle f8699c;
    private Method f8700d;
    private Method f8701e;
    private final AtomicInteger f8702f = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zza(Context context) {
        this.f8698b = context.getApplicationContext();
    }

    @TargetApi(26)
    private final Notification m7436a(CharSequence charSequence, String str, int i, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        Builder smallIcon = new Builder(this.f8698b).setAutoCancel(true).setSmallIcon(i);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.f8700d == null) {
                this.f8700d = m7440a("setChannelId");
            }
            if (this.f8700d == null) {
                this.f8700d = m7440a("setChannel");
            }
            if (this.f8700d == null) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel");
            } else {
                try {
                    this.f8700d.invoke(smallIcon, new Object[]{str2});
                } catch (Throwable e) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
                }
            }
        }
        return smallIcon.build();
    }

    private final android.os.Bundle m7437a() {
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
        r4 = this;
        r0 = r4.f8699c;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = r4.f8699c;
        return r0;
    L_0x0007:
        r0 = 0;
        r1 = r4.f8698b;	 Catch:{ NameNotFoundException -> 0x001b }
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = r4.f8698b;	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x001b }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x001b }
        r1 = r1.getApplicationInfo(r2, r3);	 Catch:{ NameNotFoundException -> 0x001b }
        r0 = r1;
    L_0x001b:
        if (r0 == 0) goto L_0x0028;
    L_0x001d:
        r1 = r0.metaData;
        if (r1 == 0) goto L_0x0028;
    L_0x0021:
        r0 = r0.metaData;
        r4.f8699c = r0;
        r0 = r4.f8699c;
        return r0;
    L_0x0028:
        r0 = android.os.Bundle.EMPTY;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zza.a():android.os.Bundle");
    }

    static synchronized zza m7438a(Context context) {
        zza com_google_firebase_messaging_zza;
        synchronized (zza.class) {
            if (f8697a == null) {
                f8697a = new zza(context);
            }
            com_google_firebase_messaging_zza = f8697a;
        }
        return com_google_firebase_messaging_zza;
    }

    private static String m7439a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    @android.annotation.TargetApi(26)
    private static java.lang.reflect.Method m7440a(java.lang.String r4) {
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
        r0 = android.app.Notification.Builder.class;	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        r1 = 1;	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        r2 = 0;	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        r3 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        r1[r2] = r3;	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        r4 = r0.getMethod(r4, r1);	 Catch:{ NoSuchMethodException -> 0x000f, NoSuchMethodException -> 0x000f }
        return r4;
    L_0x000f:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zza.a(java.lang.String):java.lang.reflect.Method");
    }

    private static void m7441a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    @android.annotation.TargetApi(26)
    private final boolean m7442a(int r5) {
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
        r4 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 1;
        r2 = 26;
        if (r0 == r2) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = 0;
        r2 = r4.f8698b;	 Catch:{ NotFoundException -> 0x0046 }
        r2 = r2.getResources();	 Catch:{ NotFoundException -> 0x0046 }
        r3 = 0;	 Catch:{ NotFoundException -> 0x0046 }
        r2 = r2.getDrawable(r5, r3);	 Catch:{ NotFoundException -> 0x0046 }
        r3 = r2.getBounds();	 Catch:{ NotFoundException -> 0x0046 }
        r3 = r3.height();	 Catch:{ NotFoundException -> 0x0046 }
        if (r3 == 0) goto L_0x0029;	 Catch:{ NotFoundException -> 0x0046 }
    L_0x001e:
        r2 = r2.getBounds();	 Catch:{ NotFoundException -> 0x0046 }
        r2 = r2.width();	 Catch:{ NotFoundException -> 0x0046 }
        if (r2 == 0) goto L_0x0029;	 Catch:{ NotFoundException -> 0x0046 }
    L_0x0028:
        return r1;	 Catch:{ NotFoundException -> 0x0046 }
    L_0x0029:
        r1 = "FirebaseMessaging";	 Catch:{ NotFoundException -> 0x0046 }
        r2 = 72;	 Catch:{ NotFoundException -> 0x0046 }
        r3 = new java.lang.StringBuilder;	 Catch:{ NotFoundException -> 0x0046 }
        r3.<init>(r2);	 Catch:{ NotFoundException -> 0x0046 }
        r2 = "Icon with id: ";	 Catch:{ NotFoundException -> 0x0046 }
        r3.append(r2);	 Catch:{ NotFoundException -> 0x0046 }
        r3.append(r5);	 Catch:{ NotFoundException -> 0x0046 }
        r5 = " uses an invalid gradient. Using fallback icon.";	 Catch:{ NotFoundException -> 0x0046 }
        r3.append(r5);	 Catch:{ NotFoundException -> 0x0046 }
        r5 = r3.toString();	 Catch:{ NotFoundException -> 0x0046 }
        android.util.Log.e(r1, r5);	 Catch:{ NotFoundException -> 0x0046 }
    L_0x0046:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zza.a(int):boolean");
    }

    static boolean m7443a(Bundle bundle) {
        if (!"1".equals(m7439a(bundle, "gcm.n.e"))) {
            if (m7439a(bundle, "gcm.n.icon") == null) {
                return false;
            }
        }
        return true;
    }

    private final java.lang.Integer m7444b(java.lang.String r5) {
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
        r4 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 0;
        r2 = 21;
        if (r0 >= r2) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 != 0) goto L_0x003d;
    L_0x000e:
        r0 = android.graphics.Color.parseColor(r5);	 Catch:{ IllegalArgumentException -> 0x0017 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ IllegalArgumentException -> 0x0017 }
        return r0;
    L_0x0017:
        r0 = "FirebaseMessaging";
        r2 = 54;
        r3 = java.lang.String.valueOf(r5);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Color ";
        r3.append(r2);
        r3.append(r5);
        r5 = " not valid. Notification will use default color.";
        r3.append(r5);
        r5 = r3.toString();
        android.util.Log.w(r0, r5);
    L_0x003d:
        r5 = r4.m7437a();
        r0 = "com.google.firebase.messaging.default_notification_color";
        r2 = 0;
        r5 = r5.getInt(r0, r2);
        if (r5 == 0) goto L_0x005c;
    L_0x004a:
        r0 = r4.f8698b;	 Catch:{ NotFoundException -> 0x0055 }
        r5 = android.support.v4.content.ContextCompat.m719c(r0, r5);	 Catch:{ NotFoundException -> 0x0055 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ NotFoundException -> 0x0055 }
        return r5;
    L_0x0055:
        r5 = "FirebaseMessaging";
        r0 = "Cannot find the color resource referenced in AndroidManifest.";
        android.util.Log.w(r5, r0);
    L_0x005c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zza.b(java.lang.String):java.lang.Integer");
    }

    private static java.lang.Object[] m7445b(android.os.Bundle r5, java.lang.String r6) {
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
        r0 = java.lang.String.valueOf(r6);
        r1 = "_loc_args";
        r1 = java.lang.String.valueOf(r1);
        r2 = r1.length();
        if (r2 == 0) goto L_0x0015;
    L_0x0010:
        r0 = r0.concat(r1);
        goto L_0x001b;
    L_0x0015:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x001b:
        r5 = m7439a(r5, r0);
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 == 0) goto L_0x0027;
    L_0x0026:
        return r1;
    L_0x0027:
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0040 }
        r0.<init>(r5);	 Catch:{ JSONException -> 0x0040 }
        r2 = r0.length();	 Catch:{ JSONException -> 0x0040 }
        r2 = new java.lang.String[r2];	 Catch:{ JSONException -> 0x0040 }
        r3 = 0;	 Catch:{ JSONException -> 0x0040 }
    L_0x0033:
        r4 = r2.length;	 Catch:{ JSONException -> 0x0040 }
        if (r3 >= r4) goto L_0x003f;	 Catch:{ JSONException -> 0x0040 }
    L_0x0036:
        r4 = r0.opt(r3);	 Catch:{ JSONException -> 0x0040 }
        r2[r3] = r4;	 Catch:{ JSONException -> 0x0040 }
        r3 = r3 + 1;
        goto L_0x0033;
    L_0x003f:
        return r2;
    L_0x0040:
        r0 = "FirebaseMessaging";
        r6 = java.lang.String.valueOf(r6);
        r2 = "_loc_args";
        r2 = java.lang.String.valueOf(r2);
        r3 = r2.length();
        if (r3 == 0) goto L_0x0057;
    L_0x0052:
        r6 = r6.concat(r2);
        goto L_0x005d;
    L_0x0057:
        r2 = new java.lang.String;
        r2.<init>(r6);
        r6 = r2;
    L_0x005d:
        r2 = 6;
        r6 = r6.substring(r2);
        r2 = 41;
        r3 = java.lang.String.valueOf(r6);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r5);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Malformed ";
        r3.append(r2);
        r3.append(r6);
        r6 = ": ";
        r3.append(r6);
        r3.append(r5);
        r5 = "  Default value will be used.";
        r3.append(r5);
        r5 = r3.toString();
        android.util.Log.w(r0, r5);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zza.b(android.os.Bundle, java.lang.String):java.lang.Object[]");
    }

    @TargetApi(26)
    private final String m7448c(String str) {
        if (!zzq.m4917i()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.f8698b.getSystemService(NotificationManager.class);
        try {
            String str2;
            if (this.f8701e == null) {
                this.f8701e = notificationManager.getClass().getMethod("getNotificationChannel", new Class[]{String.class});
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.f8701e.invoke(notificationManager, new Object[]{str}) != null) {
                    return str;
                }
                StringBuilder stringBuilder = new StringBuilder(122 + String.valueOf(str).length());
                stringBuilder.append("Notification Channel requested (");
                stringBuilder.append(str);
                stringBuilder.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("FirebaseMessaging", stringBuilder.toString());
            }
            Object string = m7437a().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                str = "FirebaseMessaging";
                str2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
            } else {
                if (this.f8701e.invoke(notificationManager, new Object[]{string}) != null) {
                    return string;
                }
                str = "FirebaseMessaging";
                str2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
            }
            Log.w(str, str2);
            if (this.f8701e.invoke(notificationManager, new Object[]{"fcm_fallback_notification_channel"}) == null) {
                Object newInstance = Class.forName("android.app.NotificationChannel").getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE}).newInstance(new Object[]{"fcm_fallback_notification_channel", this.f8698b.getString(C0436R.string.fcm_fallback_notification_channel_label), Integer.valueOf(3)});
                notificationManager.getClass().getMethod("createNotificationChannel", new Class[]{r11}).invoke(notificationManager, new Object[]{newInstance});
            }
            return "fcm_fallback_notification_channel";
        } catch (Throwable e) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e);
            return null;
        }
    }

    final boolean m7449b(Bundle bundle) {
        if ("1".equals(m7439a(bundle, "gcm.n.noui"))) {
            return true;
        }
        int myPid;
        boolean z;
        CharSequence c;
        CharSequence charSequence;
        CharSequence c2;
        String a;
        Resources resources;
        int identifier;
        Integer b;
        PendingIntent pendingIntent;
        Uri uri;
        Parcelable c3;
        Intent intent;
        Parcelable parcelable;
        PendingIntent pendingIntent2;
        NotificationCompat.Builder a2;
        Notification a3;
        NotificationManager notificationManager;
        long uptimeMillis;
        StringBuilder stringBuilder;
        int identifier2;
        if (!((KeyguardManager) this.f8698b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!zzq.m4915g()) {
                SystemClock.sleep(10);
            }
            myPid = Process.myPid();
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f8698b.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (runningAppProcessInfo.importance == 100) {
                            z = true;
                            if (z) {
                                return false;
                            }
                            c = m7447c(bundle, "gcm.n.title");
                            if (TextUtils.isEmpty(c)) {
                                c = this.f8698b.getApplicationInfo().loadLabel(this.f8698b.getPackageManager());
                            }
                            charSequence = c;
                            c2 = m7447c(bundle, "gcm.n.body");
                            a = m7439a(bundle, "gcm.n.icon");
                            if (!TextUtils.isEmpty(a)) {
                                resources = this.f8698b.getResources();
                                identifier = resources.getIdentifier(a, "drawable", this.f8698b.getPackageName());
                                if (identifier == 0 && m7442a(identifier)) {
                                    b = m7444b(m7439a(bundle, "gcm.n.color"));
                                    a = m7439a(bundle, "gcm.n.sound2");
                                    if (TextUtils.isEmpty(a)) {
                                        a = m7439a(bundle, "gcm.n.sound");
                                    }
                                    pendingIntent = null;
                                    if (TextUtils.isEmpty(a)) {
                                        uri = null;
                                    } else {
                                        if (!"default".equals(a)) {
                                        }
                                        uri = RingtoneManager.getDefaultUri(2);
                                    }
                                    c3 = m7446c(bundle);
                                    if (FirebaseMessagingService.m14895b(bundle)) {
                                        intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                                        m7441a(intent, bundle);
                                        intent.putExtra("pending_intent", c3);
                                        c3 = zzx.m7415a(this.f8698b, this.f8702f.incrementAndGet(), intent);
                                        intent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                                        m7441a(intent, bundle);
                                        pendingIntent = zzx.m7415a(this.f8698b, this.f8702f.incrementAndGet(), intent);
                                    }
                                    parcelable = c3;
                                    pendingIntent2 = pendingIntent;
                                    if (zzq.m4917i()) {
                                    }
                                    a2 = new NotificationCompat.Builder(this.f8698b).m680a(true).m674a(identifier);
                                    if (!TextUtils.isEmpty(charSequence)) {
                                        a2.m679a(charSequence);
                                    }
                                    if (!TextUtils.isEmpty(c2)) {
                                        a2.m682b(c2);
                                        a2.m678a(new NotificationCompat.BigTextStyle().m9997b(c2));
                                    }
                                    if (b != null) {
                                        a2.f1106B = b.intValue();
                                    }
                                    if (uri != null) {
                                        a2.m676a(uri);
                                    }
                                    if (parcelable != null) {
                                        a2.f1123e = parcelable;
                                    }
                                    if (pendingIntent2 != null) {
                                        a2.f1117M.deleteIntent = pendingIntent2;
                                    }
                                    a3 = a2.m673a();
                                    bundle = m7439a(bundle, "gcm.n.tag");
                                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                                        Log.d("FirebaseMessaging", "Showing notification");
                                    }
                                    notificationManager = (NotificationManager) this.f8698b.getSystemService("notification");
                                    if (TextUtils.isEmpty(bundle)) {
                                        uptimeMillis = SystemClock.uptimeMillis();
                                        stringBuilder = new StringBuilder(37);
                                        stringBuilder.append("FCM-Notification:");
                                        stringBuilder.append(uptimeMillis);
                                        bundle = stringBuilder.toString();
                                    }
                                    notificationManager.notify(bundle, 0, a3);
                                    return true;
                                }
                                identifier2 = resources.getIdentifier(a, "mipmap", this.f8698b.getPackageName());
                                if (identifier2 == 0 && m7442a(identifier2)) {
                                    identifier = identifier2;
                                    b = m7444b(m7439a(bundle, "gcm.n.color"));
                                    a = m7439a(bundle, "gcm.n.sound2");
                                    if (TextUtils.isEmpty(a)) {
                                        a = m7439a(bundle, "gcm.n.sound");
                                    }
                                    pendingIntent = null;
                                    if (TextUtils.isEmpty(a)) {
                                        uri = null;
                                    } else if ("default".equals(a) || this.f8698b.getResources().getIdentifier(a, "raw", this.f8698b.getPackageName()) == 0) {
                                        uri = RingtoneManager.getDefaultUri(2);
                                    } else {
                                        String str = "android.resource://";
                                        String packageName = this.f8698b.getPackageName();
                                        StringBuilder stringBuilder2 = new StringBuilder(((5 + String.valueOf(str).length()) + String.valueOf(packageName).length()) + String.valueOf(a).length());
                                        stringBuilder2.append(str);
                                        stringBuilder2.append(packageName);
                                        stringBuilder2.append("/raw/");
                                        stringBuilder2.append(a);
                                        uri = Uri.parse(stringBuilder2.toString());
                                    }
                                    c3 = m7446c(bundle);
                                    if (FirebaseMessagingService.m14895b(bundle)) {
                                        intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                                        m7441a(intent, bundle);
                                        intent.putExtra("pending_intent", c3);
                                        c3 = zzx.m7415a(this.f8698b, this.f8702f.incrementAndGet(), intent);
                                        intent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                                        m7441a(intent, bundle);
                                        pendingIntent = zzx.m7415a(this.f8698b, this.f8702f.incrementAndGet(), intent);
                                    }
                                    parcelable = c3;
                                    pendingIntent2 = pendingIntent;
                                    if (zzq.m4917i() || this.f8698b.getApplicationInfo().targetSdkVersion <= 25) {
                                        a2 = new NotificationCompat.Builder(this.f8698b).m680a(true).m674a(identifier);
                                        if (TextUtils.isEmpty(charSequence)) {
                                            a2.m679a(charSequence);
                                        }
                                        if (TextUtils.isEmpty(c2)) {
                                            a2.m682b(c2);
                                            a2.m678a(new NotificationCompat.BigTextStyle().m9997b(c2));
                                        }
                                        if (b != null) {
                                            a2.f1106B = b.intValue();
                                        }
                                        if (uri != null) {
                                            a2.m676a(uri);
                                        }
                                        if (parcelable != null) {
                                            a2.f1123e = parcelable;
                                        }
                                        if (pendingIntent2 != null) {
                                            a2.f1117M.deleteIntent = pendingIntent2;
                                        }
                                        a3 = a2.m673a();
                                    } else {
                                        a3 = m7436a(charSequence, c2, identifier, b, uri, parcelable, pendingIntent2, m7448c(m7439a(bundle, "gcm.n.android_channel_id")));
                                    }
                                    bundle = m7439a(bundle, "gcm.n.tag");
                                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                                        Log.d("FirebaseMessaging", "Showing notification");
                                    }
                                    notificationManager = (NotificationManager) this.f8698b.getSystemService("notification");
                                    if (TextUtils.isEmpty(bundle)) {
                                        uptimeMillis = SystemClock.uptimeMillis();
                                        stringBuilder = new StringBuilder(37);
                                        stringBuilder.append("FCM-Notification:");
                                        stringBuilder.append(uptimeMillis);
                                        bundle = stringBuilder.toString();
                                    }
                                    notificationManager.notify(bundle, 0, a3);
                                    return true;
                                }
                                StringBuilder stringBuilder3 = new StringBuilder(61 + String.valueOf(a).length());
                                stringBuilder3.append("Icon resource ");
                                stringBuilder3.append(a);
                                stringBuilder3.append(" not found. Notification will use default icon.");
                                Log.w("FirebaseMessaging", stringBuilder3.toString());
                            }
                            myPid = m7437a().getInt("com.google.firebase.messaging.default_notification_icon", 0);
                            if (myPid == 0 || !m7442a(myPid)) {
                                myPid = this.f8698b.getApplicationInfo().icon;
                            }
                            if (myPid == 0 || !m7442a(myPid)) {
                                myPid = 17301651;
                            }
                            identifier = myPid;
                            b = m7444b(m7439a(bundle, "gcm.n.color"));
                            a = m7439a(bundle, "gcm.n.sound2");
                            if (TextUtils.isEmpty(a)) {
                                a = m7439a(bundle, "gcm.n.sound");
                            }
                            pendingIntent = null;
                            if (TextUtils.isEmpty(a)) {
                                uri = null;
                            } else {
                                if ("default".equals(a)) {
                                }
                                uri = RingtoneManager.getDefaultUri(2);
                            }
                            c3 = m7446c(bundle);
                            if (FirebaseMessagingService.m14895b(bundle)) {
                                intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                                m7441a(intent, bundle);
                                intent.putExtra("pending_intent", c3);
                                c3 = zzx.m7415a(this.f8698b, this.f8702f.incrementAndGet(), intent);
                                intent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                                m7441a(intent, bundle);
                                pendingIntent = zzx.m7415a(this.f8698b, this.f8702f.incrementAndGet(), intent);
                            }
                            parcelable = c3;
                            pendingIntent2 = pendingIntent;
                            if (zzq.m4917i()) {
                            }
                            a2 = new NotificationCompat.Builder(this.f8698b).m680a(true).m674a(identifier);
                            if (TextUtils.isEmpty(charSequence)) {
                                a2.m679a(charSequence);
                            }
                            if (TextUtils.isEmpty(c2)) {
                                a2.m682b(c2);
                                a2.m678a(new NotificationCompat.BigTextStyle().m9997b(c2));
                            }
                            if (b != null) {
                                a2.f1106B = b.intValue();
                            }
                            if (uri != null) {
                                a2.m676a(uri);
                            }
                            if (parcelable != null) {
                                a2.f1123e = parcelable;
                            }
                            if (pendingIntent2 != null) {
                                a2.f1117M.deleteIntent = pendingIntent2;
                            }
                            a3 = a2.m673a();
                            bundle = m7439a(bundle, "gcm.n.tag");
                            if (Log.isLoggable("FirebaseMessaging", 3)) {
                                Log.d("FirebaseMessaging", "Showing notification");
                            }
                            notificationManager = (NotificationManager) this.f8698b.getSystemService("notification");
                            if (TextUtils.isEmpty(bundle)) {
                                uptimeMillis = SystemClock.uptimeMillis();
                                stringBuilder = new StringBuilder(37);
                                stringBuilder.append("FCM-Notification:");
                                stringBuilder.append(uptimeMillis);
                                bundle = stringBuilder.toString();
                            }
                            notificationManager.notify(bundle, 0, a3);
                            return true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        c = m7447c(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(c)) {
            c = this.f8698b.getApplicationInfo().loadLabel(this.f8698b.getPackageManager());
        }
        charSequence = c;
        c2 = m7447c(bundle, "gcm.n.body");
        a = m7439a(bundle, "gcm.n.icon");
        if (TextUtils.isEmpty(a)) {
            resources = this.f8698b.getResources();
            identifier = resources.getIdentifier(a, "drawable", this.f8698b.getPackageName());
            if (identifier == 0) {
            }
            identifier2 = resources.getIdentifier(a, "mipmap", this.f8698b.getPackageName());
            if (identifier2 == 0) {
            }
            StringBuilder stringBuilder32 = new StringBuilder(61 + String.valueOf(a).length());
            stringBuilder32.append("Icon resource ");
            stringBuilder32.append(a);
            stringBuilder32.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", stringBuilder32.toString());
        }
        myPid = m7437a().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        myPid = this.f8698b.getApplicationInfo().icon;
        myPid = 17301651;
        identifier = myPid;
        b = m7444b(m7439a(bundle, "gcm.n.color"));
        a = m7439a(bundle, "gcm.n.sound2");
        if (TextUtils.isEmpty(a)) {
            a = m7439a(bundle, "gcm.n.sound");
        }
        pendingIntent = null;
        if (TextUtils.isEmpty(a)) {
            if ("default".equals(a)) {
            }
            uri = RingtoneManager.getDefaultUri(2);
        } else {
            uri = null;
        }
        c3 = m7446c(bundle);
        if (FirebaseMessagingService.m14895b(bundle)) {
            intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
            m7441a(intent, bundle);
            intent.putExtra("pending_intent", c3);
            c3 = zzx.m7415a(this.f8698b, this.f8702f.incrementAndGet(), intent);
            intent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
            m7441a(intent, bundle);
            pendingIntent = zzx.m7415a(this.f8698b, this.f8702f.incrementAndGet(), intent);
        }
        parcelable = c3;
        pendingIntent2 = pendingIntent;
        if (zzq.m4917i()) {
        }
        a2 = new NotificationCompat.Builder(this.f8698b).m680a(true).m674a(identifier);
        if (TextUtils.isEmpty(charSequence)) {
            a2.m679a(charSequence);
        }
        if (TextUtils.isEmpty(c2)) {
            a2.m682b(c2);
            a2.m678a(new NotificationCompat.BigTextStyle().m9997b(c2));
        }
        if (b != null) {
            a2.f1106B = b.intValue();
        }
        if (uri != null) {
            a2.m676a(uri);
        }
        if (parcelable != null) {
            a2.f1123e = parcelable;
        }
        if (pendingIntent2 != null) {
            a2.f1117M.deleteIntent = pendingIntent2;
        }
        a3 = a2.m673a();
        bundle = m7439a(bundle, "gcm.n.tag");
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        notificationManager = (NotificationManager) this.f8698b.getSystemService("notification");
        if (TextUtils.isEmpty(bundle)) {
            uptimeMillis = SystemClock.uptimeMillis();
            stringBuilder = new StringBuilder(37);
            stringBuilder.append("FCM-Notification:");
            stringBuilder.append(uptimeMillis);
            bundle = stringBuilder.toString();
        }
        notificationManager.notify(bundle, 0, a3);
        return true;
    }

    private final String m7447c(Bundle bundle, String str) {
        Object a = m7439a(bundle, str);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        valueOf = m7439a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(valueOf)) {
            return null;
        }
        Resources resources = this.f8698b.getResources();
        int identifier = resources.getIdentifier(valueOf, "string", this.f8698b.getPackageName());
        if (identifier == 0) {
            bundle = "FirebaseMessaging";
            str = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_key");
            str = (valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)).substring(6);
            StringBuilder stringBuilder = new StringBuilder((49 + String.valueOf(str).length()) + String.valueOf(valueOf).length());
            stringBuilder.append(str);
            stringBuilder.append(" resource not found: ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" Default value will be used.");
            Log.w(bundle, stringBuilder.toString());
            return null;
        }
        bundle = m7445b(bundle, str);
        if (bundle == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, bundle);
        } catch (String str2) {
            bundle = Arrays.toString(bundle);
            StringBuilder stringBuilder2 = new StringBuilder((58 + String.valueOf(valueOf).length()) + String.valueOf(bundle).length());
            stringBuilder2.append("Missing format argument for ");
            stringBuilder2.append(valueOf);
            stringBuilder2.append(": ");
            stringBuilder2.append(bundle);
            stringBuilder2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", stringBuilder2.toString(), str2);
            return null;
        }
    }

    private final PendingIntent m7446c(Bundle bundle) {
        Intent intent;
        Object a = m7439a(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(a)) {
            a = m7439a(bundle, "gcm.n.link_android");
            if (TextUtils.isEmpty(a)) {
                a = m7439a(bundle, "gcm.n.link");
            }
            Uri parse = !TextUtils.isEmpty(a) ? Uri.parse(a) : null;
            if (parse != null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(this.f8698b.getPackageName());
                intent.setData(parse);
            } else {
                intent = this.f8698b.getPackageManager().getLaunchIntentForPackage(this.f8698b.getPackageName());
                if (intent == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        } else {
            intent = new Intent(a);
            intent.setPackage(this.f8698b.getPackageName());
            intent.setFlags(268435456);
        }
        if (intent == null) {
            return null;
        }
        intent.addFlags(67108864);
        Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.m14894a(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.f8698b, this.f8702f.incrementAndGet(), intent, 1073741824);
    }
}
