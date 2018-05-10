package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzcv;
import java.util.ArrayList;
import java.util.Collection;

public final class zzac {
    final Context f5423a;
    final zzcv f5424b;
    final View f5425c;

    public zzac(Context context, zzcv com_google_android_gms_internal_zzcv, View view) {
        this.f5423a = context;
        this.f5424b = com_google_android_gms_internal_zzcv;
        this.f5425c = view;
    }

    static Intent m4417a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    static Intent m4418a(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    final ResolveInfo m4419a(Intent intent) {
        return m4420a(intent, new ArrayList());
    }

    final ResolveInfo m4420a(Intent intent, ArrayList<ResolveInfo> arrayList) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = this.f5423a.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    ResolveInfo resolveInfo2 = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                }
            }
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        } catch (Throwable th) {
            zzbs.m4490i().m13246a(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
            return null;
        }
    }
}
