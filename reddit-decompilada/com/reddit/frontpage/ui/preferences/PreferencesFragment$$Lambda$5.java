package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import android.support.v7.preference.SwitchPreferenceCompat;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$5 implements OnPreferenceChangeListener {
    private final PreferencesFragment f29215a;
    private final FrontpageSettings f29216b;
    private final SwitchPreferenceCompat f29217c;

    PreferencesFragment$$Lambda$5(PreferencesFragment preferencesFragment, FrontpageSettings frontpageSettings, SwitchPreferenceCompat switchPreferenceCompat) {
        this.f29215a = preferencesFragment;
        this.f29216b = frontpageSettings;
        this.f29217c = switchPreferenceCompat;
    }

    public final boolean m30318a(Object obj) {
        return this.f29215a.m37736a(this.f29216b, this.f29217c, obj);
    }
}
