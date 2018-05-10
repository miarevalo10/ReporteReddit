package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$3 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29213a;

    PreferencesFragment$$Lambda$3(FrontpageSettings frontpageSettings) {
        this.f29213a = frontpageSettings;
    }

    public final boolean m30316a(Object obj) {
        return PreferencesFragment.m37733l(this.f29213a, obj);
    }
}
