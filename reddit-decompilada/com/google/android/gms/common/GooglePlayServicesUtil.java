package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.internal.zzv;

public final class GooglePlayServicesUtil extends zzp {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        if (zzp.zze(activity, i)) {
            i = 18;
        }
        GoogleApiAvailability.m12790a();
        return GoogleApiAvailability.m12787a(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzp.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return zzp.getErrorString(i);
    }

    public static Context getRemoteContext(Context context) {
        return zzp.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return zzp.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zzp.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return zzp.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        if (zzp.zze(activity, i)) {
            i = 18;
        }
        GoogleApiAvailability.m12790a();
        if (fragment == null) {
            return GoogleApiAvailability.m12795b(activity, i, i2, onCancelListener);
        }
        GoogleApiAvailability.m12790a();
        Dialog a = GoogleApiAvailability.m12789a((Context) activity, i, zzv.m4886a(fragment, zzf.m4928a((Context) activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        GoogleApiAvailability.m12793a(activity, a, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        GoogleApiAvailability a = GoogleApiAvailability.m12790a();
        if (!zzp.zze(context, i)) {
            if (!(i == 9 ? zzp.zzv(context, "com.android.vending") : false)) {
                a.m12799a(context, i);
                return;
            }
        }
        a.m12803b(context);
    }
}
