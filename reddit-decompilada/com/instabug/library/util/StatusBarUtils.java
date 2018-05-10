package com.instabug.library.util;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.settings.SettingsManager;

public class StatusBarUtils {
    public static void setStatusBar(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(SettingsManager.getInstance().getStatusBarColor());
        }
        if (VERSION.SDK_INT >= 23) {
            activity = activity.getWindow().getDecorView();
            if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                activity.setSystemUiVisibility(8192);
                return;
            }
            activity.setSystemUiVisibility(0);
        }
    }
}
