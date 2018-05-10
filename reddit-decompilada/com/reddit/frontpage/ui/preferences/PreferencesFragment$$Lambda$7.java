package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$7 implements OnPreferenceChangeListener {
    private final PreferencesFragment f29220a;
    private final FrontpageSettings f29221b;
    private final ListPreference f29222c;

    PreferencesFragment$$Lambda$7(PreferencesFragment preferencesFragment, FrontpageSettings frontpageSettings, ListPreference listPreference) {
        this.f29220a = preferencesFragment;
        this.f29221b = frontpageSettings;
        this.f29222c = listPreference;
    }

    public final boolean m30320a(Object obj) {
        return this.f29220a.m37735a(this.f29221b, this.f29222c, obj);
    }
}
