package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage.UserSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$0 implements OnPreferenceChangeListener {
    private final UserSettings f29177a;

    PreferencesFragment$$Lambda$0(UserSettings userSettings) {
        this.f29177a = userSettings;
    }

    public final boolean m30290a(Object obj) {
        return PreferencesFragment.m37723a(this.f29177a, obj);
    }
}
