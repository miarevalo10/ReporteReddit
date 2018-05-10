package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$25 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29199a;

    PreferencesFragment$$Lambda$25(FrontpageSettings frontpageSettings) {
        this.f29199a = frontpageSettings;
    }

    public final boolean m30307a(Object obj) {
        return this.f29199a.a.edit().putBoolean("com.reddit.pref.mvp_usp_listing", ((Boolean) obj).booleanValue()).apply();
    }
}
