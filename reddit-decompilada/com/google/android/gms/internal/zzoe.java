package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

@zzzv
public final class zzoe implements zzftt {
    CustomTabsSession f14569a;
    CustomTabsClient f14570b;
    CustomTabsServiceConnection f14571c;
    zzof f14572d;

    public static boolean m14110a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzftr.m6249a(context));
                }
            }
        }
        return false;
    }

    public final void mo2066a() {
        this.f14570b = null;
        this.f14569a = null;
    }

    public final void mo2067a(CustomTabsClient customTabsClient) {
        this.f14570b = customTabsClient;
        this.f14570b.m143a();
        if (this.f14572d != null) {
            this.f14572d.mo1718a();
        }
    }
}
