package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$6 implements OnPreferenceChangeListener {
    private final PreferencesFragment f29218a;
    private final FrontpageSettings f29219b;

    PreferencesFragment$$Lambda$6(PreferencesFragment preferencesFragment, FrontpageSettings frontpageSettings) {
        this.f29218a = preferencesFragment;
        this.f29219b = frontpageSettings;
    }

    public final boolean m30319a(Object obj) {
        PreferencesFragment preferencesFragment = this.f29218a;
        this.f29219b.d(((Boolean) obj).booleanValue());
        preferencesFragment.m37741c();
        return true;
    }
}
