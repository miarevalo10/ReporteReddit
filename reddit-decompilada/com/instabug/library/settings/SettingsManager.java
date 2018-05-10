package com.instabug.library.settings;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.instabug.library.C0645b;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.OnSdkDismissedCallback;
import com.instabug.library.OnSdkInvokedCallback;
import com.instabug.library.broadcast.LastContactedChangedBroadcast;
import com.instabug.library.internal.storage.AttachmentsUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;

public class SettingsManager {
    public static final String INSTABUG_SHARED_PREF_NAME = "instabug";
    public static final boolean VERBOSE = false;
    private static SettingsManager settingsManager;
    private boolean DEBUG = false;
    private boolean reproStepsScreenshotEnable;

    private SettingsManager() {
    }

    public static void init(Context context) {
        settingsManager = new SettingsManager();
        C0755b.m8319a(context);
        C0754a.m8315a();
    }

    public static SettingsManager getInstance() {
        if (settingsManager == null) {
            settingsManager = new SettingsManager();
        }
        return settingsManager;
    }

    public boolean isDebugEnabled() {
        return this.DEBUG;
    }

    public void setDebugEnabled(boolean z) {
        this.DEBUG = z;
    }

    public String getAppToken() {
        return C0755b.m8318a().f9877a.getString("ib_app_token", null);
    }

    public void setAppToken(String str) {
        C0755b.m8318a().f9877a.edit().putString("ib_app_token", str).apply();
    }

    public Runnable getPreInvocationRunnable() {
        return C0754a.m8316b().f9863h;
    }

    public void setPreInvocationRunnable(Runnable runnable) {
        C0754a.m8316b().f9863h = runnable;
    }

    public Runnable getPreReportRunnable() {
        return C0754a.m8316b().f9864i;
    }

    public OnSdkInvokedCallback getOnSdkInvokedCallback() {
        return C0754a.m8316b().f9867l;
    }

    public void setOnSdkInvokedCallback(OnSdkInvokedCallback onSdkInvokedCallback) {
        C0754a.m8316b().f9867l = onSdkInvokedCallback;
    }

    public String getUserData() {
        return C0645b.m8104a().m8113b(Feature.USER_DATA) == State.ENABLED ? C0755b.m8318a().f9877a.getString("ib_user_data", "") : "";
    }

    public void setUserData(String str) {
        C0755b.m8318a().f9877a.edit().putString("ib_user_data", str).apply();
    }

    public Locale getInstabugLocale(Context context) {
        C0754a b = C0754a.m8316b();
        if (b.f9856a == null) {
            if (VERSION.SDK_INT >= 24) {
                b.f9856a = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                b.f9856a = context.getResources().getConfiguration().locale;
            }
        }
        return b.f9856a;
    }

    public void setInstabugLocale(Locale locale) {
        C0754a.m8316b().f9856a = locale;
    }

    public boolean isIntroMessageEnabled() {
        return C0755b.m8318a().f9877a.getBoolean("ib_is_intro_message_enabled", true);
    }

    public void setIntroMessageEnabled(boolean z) {
        C0755b.m8318a().f9877a.edit().putBoolean("ib_is_intro_message_enabled", z).apply();
    }

    public void addExtraAttachmentFile(Uri uri, String str) {
        C0754a.m8316b().m8317a(uri, str);
    }

    public void addExtraAttachmentFile(byte[] bArr, String str) {
        C0754a.m8316b().m8317a(AttachmentsUtility.getUriFromBytes(Instabug.getApplicationContext(), bArr, str), str);
    }

    public void clearExtraAttachmentFiles() {
        C0754a.m8316b().f9861f.clear();
    }

    public LinkedHashMap<Uri, String> getExtraAttachmentFiles() {
        return C0754a.m8316b().f9861f;
    }

    public String getUserEmail() {
        return C0755b.m8318a().f9877a.getString("ib_default_email", "");
    }

    public void setUserEmail(String str) {
        C0755b.m8318a().f9877a.edit().putString("ib_default_email", str).apply();
    }

    public String getIdentifiedUserEmail() {
        return C0755b.m8318a().f9877a.getString("ib_identified_email", "");
    }

    public void setIdentifiedUserEmail(String str) {
        C0755b.m8318a().f9877a.edit().putString("ib_identified_email", str).apply();
    }

    public boolean isDeviceRegistered() {
        return C0755b.m8318a().f9877a.getBoolean("ib_device_registered", false);
    }

    public void setIsDeviceRegistered(boolean z) {
        C0755b.m8318a().f9877a.edit().putBoolean("ib_device_registered", z).apply();
    }

    public boolean isFirstRun() {
        return C0755b.m8318a().f9877a.getBoolean("ib_first_run", true);
    }

    public void setIsFirstRun(boolean z) {
        C0755b a = C0755b.m8318a();
        a.f9877a.edit().putBoolean("ib_first_run", z).apply();
        a.f9877a.edit().putLong("ib_first_run_at", System.currentTimeMillis()).apply();
    }

    public Date getFirstRunAt() {
        return new Date(C0755b.m8318a().f9877a.getLong("ib_first_run_at", 0));
    }

    public void setFirstRunAt(long j) {
        C0755b.m8318a().f9877a.edit().putLong("ib_first_run_at", j).apply();
    }

    @Deprecated
    public long getLastContactedAt() {
        return C0755b.m8318a().f9877a.getLong(LastContactedChangedBroadcast.LAST_CONTACTED_AT, 0);
    }

    @Deprecated
    public void setLastContactedAt(long j) {
        C0755b.m8318a().f9877a.edit().putLong(LastContactedChangedBroadcast.LAST_CONTACTED_AT, j).apply();
    }

    public boolean isAppOnForeground() {
        return C0755b.m8318a().f9877a.getBoolean("ib_pn", true);
    }

    public void setIsAppOnForeground(boolean z) {
        C0755b.m8318a().f9877a.edit().putBoolean("ib_pn", z).apply();
    }

    public int getLastMigrationVersion() {
        return C0755b.m8318a().f9877a.getInt("last_migration_version", 0);
    }

    public void setLastMigrationVersion(int i) {
        C0755b.m8318a().f9877a.edit().putInt("last_migration_version", i).apply();
    }

    public boolean isFirstDismiss() {
        return C0755b.m8318a().f9877a.getBoolean("ib_first_dismiss", true);
    }

    public void setIsFirstDismiss(boolean z) {
        C0755b.m8318a().f9877a.edit().putBoolean("ib_first_dismiss", z).apply();
    }

    public int getPrimaryColor() {
        return C0754a.m8316b().f9859d;
    }

    public void setPrimaryColor(int i) {
        C0754a.m8316b().f9859d = i;
    }

    public InstabugColorTheme getTheme() {
        return InstabugColorTheme.valueOf(C0755b.m8318a().f9877a.getString("ib_color_theme", InstabugColorTheme.InstabugColorThemeLight.name()));
    }

    public void setTheme(InstabugColorTheme instabugColorTheme) {
        C0755b.m8318a().f9877a.edit().putString("ib_color_theme", instabugColorTheme.name()).apply();
    }

    public String getUsername() {
        return C0755b.m8318a().f9877a.getString("ib_default_username", "");
    }

    public void setUsername(String str) {
        C0755b.m8318a().f9877a.edit().putString("ib_default_username", str).apply();
    }

    public String getUuid() {
        return C0755b.m8318a().f9877a.getString("ib_uuid", null);
    }

    public void setUuid(String str) {
        C0755b.m8318a().f9877a.edit().putString("ib_uuid", str).apply();
    }

    public String getMD5Uuid() {
        return C0755b.m8318a().f9877a.getString("ib_md5_uuid", null);
    }

    public void setMD5Uuid(String str) {
        C0755b.m8318a().f9877a.edit().putString("ib_md5_uuid", str).apply();
    }

    public ArrayList<String> getTags() {
        return C0754a.m8316b().f9857b;
    }

    public void addTags(String... strArr) {
        Collections.addAll(C0754a.m8316b().f9857b, strArr);
    }

    public void resetTags() {
        C0754a.m8316b().f9857b = new ArrayList();
    }

    public String getTagsAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList = C0754a.m8316b().f9857b;
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) arrayList.get(i));
                if (i != size - 1) {
                    stringBuilder.append(", ");
                }
            }
        }
        return stringBuilder.toString();
    }

    public long getSessionStartedAt() {
        return C0754a.m8316b().f9862g;
    }

    public void setSessionStartedAt(long j) {
        C0754a.m8316b().f9862g = j;
    }

    public boolean isVideoProcessorBusy() {
        return C0754a.m8316b().f9868m;
    }

    public void setVideoProcessorBusy(boolean z) {
        C0754a.m8316b().f9868m = z;
    }

    public InstabugCustomTextPlaceHolder getCustomPlaceHolders() {
        return C0754a.m8316b().f9858c;
    }

    public void setCustomPlaceHolders(InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder) {
        C0754a.m8316b().f9858c = instabugCustomTextPlaceHolder;
    }

    public boolean isUserLoggedOut() {
        return C0755b.m8318a().f9877a.getBoolean("ib_is_user_logged_out", true);
    }

    public void setUserLoggedOut(boolean z) {
        C0755b.m8318a().f9877a.edit().putBoolean("ib_is_user_logged_out", z).apply();
    }

    public boolean shouldMakeUUIDMigrationRequest() {
        return C0755b.m8318a().f9877a.getBoolean("ib_should_make_uuid_migration_request", false);
    }

    public void setShouldMakeUUIDMigrationRequest(boolean z) {
        C0755b.m8318a().f9877a.edit().putBoolean("ib_should_make_uuid_migration_request", z).apply();
    }

    public void setCurrentSDKVersion(String str) {
        C0755b a = C0755b.m8318a();
        a.f9877a.edit().putString("ib_sdk_version", str).apply();
        a.f9877a.edit().putBoolean("ib_is_sdk_version_set", true).apply();
    }

    public String getLastSDKVersion() {
        return C0755b.m8318a().f9877a.getString("ib_sdk_version", "4.11.1");
    }

    public boolean isSDKVersionSet() {
        return C0755b.m8318a().f9877a.getBoolean("ib_is_sdk_version_set", false);
    }

    public int getStatusBarColor() {
        return C0754a.m8316b().f9860e;
    }

    public void setStatusBarColor(int i) {
        C0754a.m8316b().f9860e = i;
    }

    public void setRequestedOrientation(int i) {
        C0754a.m8316b().f9869n = i;
    }

    public int getRequestedOrientation() {
        return C0754a.m8316b().f9869n;
    }

    public void resetRequestedOrientation() {
        C0754a.m8316b().f9869n = -2;
    }

    public int getSessionsCount() {
        return C0755b.m8318a().m8320b();
    }

    public void incrementSessionsCount() {
        C0755b a = C0755b.m8318a();
        a.f9877a.edit().putInt("ib_sessions_count", a.m8320b() + 1).apply();
    }

    public boolean isPromptOptionsScreenShown() {
        return C0754a.m8316b().f9865j;
    }

    public void setPromptOptionsScreenShown(boolean z) {
        C0754a.m8316b().f9865j = z;
    }

    public boolean isRequestPermissionScreenShown() {
        return C0754a.m8316b().f9872q;
    }

    public void setRequestPermissionScreenShown(boolean z) {
        C0754a.m8316b().f9872q = z;
    }

    public OnSdkDismissedCallback getOnSdkDismissedCallback() {
        return C0754a.m8316b().f9866k;
    }

    public void setOnSdkDismissedCallback(OnSdkDismissedCallback onSdkDismissedCallback) {
        C0754a.m8316b().f9866k = onSdkDismissedCallback;
    }

    public void setAutoScreenRecordingEnabled(boolean z) {
        C0754a.m8316b().f9873r = z;
    }

    public boolean autoScreenRecordingEnabled() {
        return C0754a.m8316b().f9873r;
    }

    public void setAutoScreenRecordingMaxDuration(int i) {
        C0754a b = C0754a.m8316b();
        if (i > 30000) {
            i = 30000;
        }
        b.f9874s = i;
    }

    public int autoScreenRecordingMaxDuration() {
        return C0754a.m8316b().f9874s;
    }

    public boolean isScreenCurrentlyRecorded() {
        return C0754a.m8316b().f9870o;
    }

    public void setScreenCurrentlyRecorded(boolean z) {
        C0754a.m8316b().f9870o = z;
    }

    public boolean isAutoScreenRecordingDenied() {
        return C0754a.m8316b().f9871p;
    }

    public void setAutoScreenRecordingDenied(boolean z) {
        C0754a.m8316b().f9871p = z;
    }

    public void setReproStepsScreenshotEnabled(boolean z) {
        C0754a.m8316b().f9875t = z;
    }

    public boolean isReproStepsScreenshotEnabled() {
        return C0754a.m8316b().f9875t;
    }
}
