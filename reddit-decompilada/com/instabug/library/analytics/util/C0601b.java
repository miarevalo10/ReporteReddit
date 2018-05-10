package com.instabug.library.analytics.util;

import android.content.Intent;
import com.instabug.library.Instabug;
import com.instabug.library.analytics.network.InstabugAnalyticsUploaderService;

/* compiled from: UploaderServiceLauncher */
public class C0601b {
    public static void m8018a() {
        if (Instabug.getApplicationContext() != null) {
            Instabug.getApplicationContext().startService(new Intent(Instabug.getApplicationContext(), InstabugAnalyticsUploaderService.class));
        }
    }
}
