package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$30 implements OnPreferenceChangeListener {
    private final PreferencesFragment f29207a;
    private final FrontpageSettings f29208b;

    PreferencesFragment$$Lambda$30(PreferencesFragment preferencesFragment, FrontpageSettings frontpageSettings) {
        this.f29207a = preferencesFragment;
        this.f29208b = frontpageSettings;
    }

    public final boolean m30313a(Object obj) {
        return this.f29207a.m37742c(this.f29208b, obj);
    }
}
