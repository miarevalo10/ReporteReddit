package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzcf;

public abstract class zzv implements OnClickListener {
    public static zzv m4885a(Activity activity, Intent intent, int i) {
        return new zzw(intent, activity, i);
    }

    public static zzv m4886a(Fragment fragment, Intent intent, int i) {
        return new zzx(intent, fragment, i);
    }

    public static zzv m4887a(zzcf com_google_android_gms_common_api_internal_zzcf, Intent intent) {
        return new zzy(intent, com_google_android_gms_common_api_internal_zzcf);
    }

    protected abstract void mo1631a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo1631a();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
