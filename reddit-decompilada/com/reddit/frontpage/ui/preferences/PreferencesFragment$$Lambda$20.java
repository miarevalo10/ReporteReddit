package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$20 implements OnPreferenceChangeListener {
    private final EditTextPreference f29192a;
    private final FrontpageSettings f29193b;

    PreferencesFragment$$Lambda$20(EditTextPreference editTextPreference, FrontpageSettings frontpageSettings) {
        this.f29192a = editTextPreference;
        this.f29193b = frontpageSettings;
    }

    public final boolean m30302a(Object obj) {
        return PreferencesFragment.m37721a(this.f29192a, this.f29193b, obj);
    }
}
