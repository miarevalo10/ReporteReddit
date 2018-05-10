package com.instabug.library.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;

public class InstabugMemoryUtils {
    public static boolean isLowMemory() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            ActivityManager activityManager = (ActivityManager) currentActivity.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.lowMemory;
            }
        }
        return true;
    }
}
