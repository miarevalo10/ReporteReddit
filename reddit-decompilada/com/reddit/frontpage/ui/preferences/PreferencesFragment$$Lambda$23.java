package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$23 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29197a;

    PreferencesFragment$$Lambda$23(FrontpageSettings frontpageSettings) {
        this.f29197a = frontpageSettings;
    }

    public final boolean m30305a(Object obj) {
        return this.f29197a.a.edit().putBoolean("com.reddit.pref.mvp_frontpage_listing", ((Boolean) obj).booleanValue()).apply();
    }
}
