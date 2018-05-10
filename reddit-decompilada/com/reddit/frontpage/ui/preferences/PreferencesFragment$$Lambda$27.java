package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$27 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29201a;

    PreferencesFragment$$Lambda$27(FrontpageSettings frontpageSettings) {
        this.f29201a = frontpageSettings;
    }

    public final boolean m30309a(Object obj) {
        return this.f29201a.a.edit().putBoolean("com.reddit.pref.onboarding_enabled_override", ((Boolean) obj).booleanValue()).apply();
    }
}
