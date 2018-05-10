package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

@SuppressLint({"CommitPrefEdits"})
class PreferenceManager {
    static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final String PREF_MIGRATION_COMPLETE = "preferences_migration_complete";
    private static final boolean SHOULD_ALWAYS_SEND_REPORTS_DEFAULT = false;
    private final PreferenceStore preferenceStore;

    public static PreferenceManager create(PreferenceStore preferenceStore, CrashlyticsCore crashlyticsCore) {
        if (!preferenceStore.a().getBoolean(PREF_MIGRATION_COMPLETE, false)) {
            PreferenceStore preferenceStoreImpl = new PreferenceStoreImpl(crashlyticsCore);
            crashlyticsCore = (preferenceStore.a().contains(PREF_ALWAYS_SEND_REPORTS_KEY) != null || preferenceStoreImpl.a().contains(PREF_ALWAYS_SEND_REPORTS_KEY) == null) ? null : 1;
            if (crashlyticsCore != null) {
                preferenceStore.a(preferenceStore.b().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, preferenceStoreImpl.a().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false)));
            }
            preferenceStore.a(preferenceStore.b().putBoolean(PREF_MIGRATION_COMPLETE, true));
        }
        return new PreferenceManager(preferenceStore);
    }

    public PreferenceManager(PreferenceStore preferenceStore) {
        this.preferenceStore = preferenceStore;
    }

    void setShouldAlwaysSendReports(boolean z) {
        this.preferenceStore.a(this.preferenceStore.b().putBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, z));
    }

    boolean shouldAlwaysSendReports() {
        return this.preferenceStore.a().getBoolean(PREF_ALWAYS_SEND_REPORTS_KEY, false);
    }
}
