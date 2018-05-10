package com.instabug.library.core;

import android.app.Activity;
import android.net.Uri;
import com.instabug.library.C0645b;
import com.instabug.library.C0662e;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.Instabug;
import com.instabug.library.OnSdkInvokedCallback;
import com.instabug.library.core.plugin.C0657a;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.p020c.C0650a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.user.C0770a;
import java.util.LinkedHashMap;

public class InstabugCore {
    public static String getSDKVersion() {
        return "4.11.1";
    }

    public static boolean isFeaturesFetchedBefore() {
        C0645b.m8104a();
        return C0645b.m8107b(Instabug.getApplicationContext()) > 0;
    }

    public static State getFeatureState(Feature feature) {
        return C0645b.m8104a().m8113b(feature);
    }

    public static boolean isFeatureAvailable(Feature feature) {
        return C0645b.m8104a().m8112a(feature);
    }

    public static LinkedHashMap<Uri, String> getExtraAttachmentFiles() {
        return SettingsManager.getInstance().getExtraAttachmentFiles();
    }

    public static Runnable getPreReportRunnable() {
        return C0650a.m8115a();
    }

    public static int getStartedActivitiesCount() {
        return C0662e.m8164a().f9591b;
    }

    public static int getPrimaryColor() {
        return SettingsManager.getInstance().getPrimaryColor();
    }

    public static String getUserEmail() {
        return C0770a.m8344b();
    }

    public static String getUsername() {
        return C0770a.m8346c();
    }

    public static String getUserData() {
        return SettingsManager.getInstance().getUserData();
    }

    public static void setUserEmail(String str) {
        C0770a.m8345b(str);
    }

    public static OnSdkInvokedCallback getOnSdkInvokedCallback() {
        return SettingsManager.getInstance().getOnSdkInvokedCallback();
    }

    public static String getTagsAsString() {
        return SettingsManager.getInstance().getTagsAsString();
    }

    public static void setLastContactedAt(long j) {
        SettingsManager.getInstance().setLastContactedAt(j);
    }

    public static boolean isUserLoggedOut() {
        return SettingsManager.getInstance().isUserLoggedOut();
    }

    public static boolean isForegroundBusy() {
        return C0657a.m8161d();
    }

    public static void setFeatureState(Feature feature, State state) {
        C0645b.m8104a().m8110a(feature, state);
    }

    public static int getSessionCount() {
        return SettingsManager.getInstance().getSessionsCount();
    }

    public static long getFirstRunAt() {
        return SettingsManager.getInstance().getFirstRunAt().getTime();
    }

    public static Plugin getXPlugin(Class cls) {
        return C0657a.m8156a(cls);
    }

    public static boolean isReproStepsScreenshotEnabled() {
        return SettingsManager.getInstance().isReproStepsScreenshotEnabled();
    }

    public static boolean isAppOnForeground() {
        return SettingsManager.getInstance().isAppOnForeground();
    }

    public static Activity getTargetActivity() {
        return InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
    }
}
