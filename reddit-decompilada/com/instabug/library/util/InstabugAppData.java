package com.instabug.library.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class InstabugAppData {
    private ApplicationInfo applicationInfo;
    private Context context;
    private String packageName;
    private PackageManager pm;

    public InstabugAppData(Context context) {
        this.context = context;
        this.packageName = context.getPackageName();
        this.pm = context.getPackageManager();
        try {
            this.applicationInfo = this.pm.getApplicationInfo(this.packageName, 128);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public String getAppName() {
        return (String) (this.applicationInfo != null ? this.pm.getApplicationLabel(this.applicationInfo) : "(unknown)");
    }

    public int getAppIcon() {
        return this.applicationInfo.icon;
    }

    public Intent getMainIntent() {
        return this.pm.getLaunchIntentForPackage(this.context.getPackageName());
    }
}
