package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$19 implements OnPreferenceChangeListener {
    private final EditTextPreference f29189a;
    private final FrontpageSettings f29190b;

    PreferencesFragment$$Lambda$19(EditTextPreference editTextPreference, FrontpageSettings frontpageSettings) {
        this.f29189a = editTextPreference;
        this.f29190b = frontpageSettings;
    }

    public final boolean m30300a(Object obj) {
        return PreferencesFragment.m37725b(this.f29189a, this.f29190b, obj);
    }
}
