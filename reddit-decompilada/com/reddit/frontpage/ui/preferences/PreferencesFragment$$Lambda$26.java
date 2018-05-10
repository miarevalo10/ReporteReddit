package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$26 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29200a;

    PreferencesFragment$$Lambda$26(FrontpageSettings frontpageSettings) {
        this.f29200a = frontpageSettings;
    }

    public final boolean m30308a(Object obj) {
        return this.f29200a.a.edit().putBoolean("com.reddit.pref.carousel_debug", ((Boolean) obj).booleanValue()).apply();
    }
}
