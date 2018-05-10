package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0436R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzi;

public final class zzu {
    private static final SimpleArrayMap<String, String> f5958a = new SimpleArrayMap();

    public static String m4876a(Context context) {
        return context.getResources().getString(C0436R.string.common_google_play_services_notification_channel_name);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4877a(android.content.Context r3, int r4) {
        /*
        r0 = r3.getResources();
        r1 = 20;
        if (r4 == r1) goto L_0x0081;
    L_0x0008:
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x007a;
            case 2: goto L_0x0073;
            case 3: goto L_0x006c;
            case 4: goto L_0x006b;
            case 5: goto L_0x005d;
            case 6: goto L_0x006b;
            case 7: goto L_0x004f;
            case 8: goto L_0x004a;
            case 9: goto L_0x0045;
            case 10: goto L_0x0040;
            case 11: goto L_0x003b;
            default: goto L_0x000c;
        };
    L_0x000c:
        switch(r4) {
            case 16: goto L_0x0036;
            case 17: goto L_0x0028;
            case 18: goto L_0x006b;
            default: goto L_0x000f;
        };
    L_0x000f:
        r3 = "GoogleApiAvailability";
        r0 = 33;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r0);
        r0 = "Unexpected error code ";
        r2.append(r0);
        r2.append(r4);
        r4 = r2.toString();
    L_0x0024:
        android.util.Log.e(r3, r4);
        return r1;
    L_0x0028:
        r4 = "GoogleApiAvailability";
        r0 = "The specified account could not be signed in.";
        android.util.Log.e(r4, r0);
        r4 = "common_google_play_services_sign_in_failed_title";
        r3 = m4878a(r3, r4);
        return r3;
    L_0x0036:
        r3 = "GoogleApiAvailability";
        r4 = "One of the API components you attempted to connect to is not available.";
        goto L_0x0024;
    L_0x003b:
        r3 = "GoogleApiAvailability";
        r4 = "The application is not licensed to the user.";
        goto L_0x0024;
    L_0x0040:
        r3 = "GoogleApiAvailability";
        r4 = "Developer error occurred. Please see logs for detailed information";
        goto L_0x0024;
    L_0x0045:
        r3 = "GoogleApiAvailability";
        r4 = "Google Play services is invalid. Cannot recover.";
        goto L_0x0024;
    L_0x004a:
        r3 = "GoogleApiAvailability";
        r4 = "Internal error occurred. Please see logs for detailed information";
        goto L_0x0024;
    L_0x004f:
        r4 = "GoogleApiAvailability";
        r0 = "Network error occurred. Please retry request later.";
        android.util.Log.e(r4, r0);
        r4 = "common_google_play_services_network_error_title";
        r3 = m4878a(r3, r4);
        return r3;
    L_0x005d:
        r4 = "GoogleApiAvailability";
        r0 = "An invalid account was specified when connecting. Please provide a valid account.";
        android.util.Log.e(r4, r0);
        r4 = "common_google_play_services_invalid_account_title";
        r3 = m4878a(r3, r4);
        return r3;
    L_0x006b:
        return r1;
    L_0x006c:
        r3 = com.google.android.gms.C0436R.string.common_google_play_services_enable_title;
        r3 = r0.getString(r3);
        return r3;
    L_0x0073:
        r3 = com.google.android.gms.C0436R.string.common_google_play_services_update_title;
        r3 = r0.getString(r3);
        return r3;
    L_0x007a:
        r3 = com.google.android.gms.C0436R.string.common_google_play_services_install_title;
        r3 = r0.getString(r3);
        return r3;
    L_0x0081:
        r4 = "GoogleApiAvailability";
        r0 = "The current user profile is restricted and could not use authenticated features.";
        android.util.Log.e(r4, r0);
        r4 = "common_google_play_services_restricted_profile_title";
        r3 = m4878a(r3, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzu.a(android.content.Context, int):java.lang.String");
    }

    private static String m4878a(Context context, String str) {
        synchronized (f5958a) {
            String str2 = (String) f5958a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str = String.valueOf(str);
                Log.w(str3, str.length() != 0 ? str4.concat(str) : new String(str4));
                return null;
            }
            Object string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str = String.valueOf(str);
                Log.w(str3, str.length() != 0 ? str4.concat(str) : new String(str4));
                return null;
            }
            f5958a.put(str, string);
            return string;
        }
    }

    private static String m4879a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a = m4878a(context, str);
        if (a == null) {
            a = resources.getString(C0436R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a, new Object[]{str2});
    }

    private static java.lang.String m4880b(android.content.Context r2) {
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
        r0 = r2.getPackageName();
        r1 = com.google.android.gms.internal.zzbhf.m5574a(r2);	 Catch:{ NameNotFoundException -> 0x0011, NameNotFoundException -> 0x0011 }
        r1 = r1.m5573b(r0);	 Catch:{ NameNotFoundException -> 0x0011, NameNotFoundException -> 0x0011 }
        r1 = r1.toString();	 Catch:{ NameNotFoundException -> 0x0011, NameNotFoundException -> 0x0011 }
        return r1;
    L_0x0011:
        r2 = r2.getApplicationInfo();
        r2 = r2.name;
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 == 0) goto L_0x001e;
    L_0x001d:
        return r0;
    L_0x001e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzu.b(android.content.Context):java.lang.String");
    }

    public static String m4881b(Context context, int i) {
        String a = i == 6 ? m4878a(context, "common_google_play_services_resolution_required_title") : m4877a(context, i);
        return a == null ? context.getResources().getString(C0436R.string.common_google_play_services_notification_ticker) : a;
    }

    public static String m4882c(Context context, int i) {
        Resources resources = context.getResources();
        String b = m4880b(context);
        if (i == 5) {
            return m4879a(context, "common_google_play_services_invalid_account_text", b);
        }
        if (i == 7) {
            return m4879a(context, "common_google_play_services_network_error_text", b);
        }
        if (i == 9) {
            return resources.getString(C0436R.string.common_google_play_services_unsupported_text, new Object[]{b});
        } else if (i == 20) {
            return m4879a(context, "common_google_play_services_restricted_profile_text", b);
        } else {
            switch (i) {
                case 1:
                    return resources.getString(C0436R.string.common_google_play_services_install_text, new Object[]{b});
                case 2:
                    if (zzi.m4902a(context)) {
                        return resources.getString(C0436R.string.common_google_play_services_wear_update_text);
                    }
                    return resources.getString(C0436R.string.common_google_play_services_update_text, new Object[]{b});
                case 3:
                    return resources.getString(C0436R.string.common_google_play_services_enable_text, new Object[]{b});
                default:
                    switch (i) {
                        case 16:
                            return m4879a(context, "common_google_play_services_api_unavailable_text", b);
                        case 17:
                            return m4879a(context, "common_google_play_services_sign_in_failed_text", b);
                        case 18:
                            return resources.getString(C0436R.string.common_google_play_services_updating_text, new Object[]{b});
                        default:
                            return resources.getString(C0436R.string.common_google_play_services_unknown_issue, new Object[]{b});
                    }
            }
        }
    }

    public static String m4883d(Context context, int i) {
        return i == 6 ? m4879a(context, "common_google_play_services_resolution_required_text", m4880b(context)) : m4882c(context, i);
    }

    public static String m4884e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                i = C0436R.string.common_google_play_services_install_button;
                break;
            case 2:
                i = C0436R.string.common_google_play_services_update_button;
                break;
            case 3:
                i = C0436R.string.common_google_play_services_enable_button;
                break;
            default:
                i = 17039370;
                break;
        }
        return resources.getString(i);
    }
}
