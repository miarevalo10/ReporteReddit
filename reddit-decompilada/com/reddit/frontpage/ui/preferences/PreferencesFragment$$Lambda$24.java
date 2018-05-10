package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$24 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29198a;

    PreferencesFragment$$Lambda$24(FrontpageSettings frontpageSettings) {
        this.f29198a = frontpageSettings;
    }

    public final boolean m30306a(Object obj) {
        return this.f29198a.a.edit().putBoolean("com.reddit.pref.mvp_popular_listing", ((Boolean) obj).booleanValue()).apply();
    }
}
