package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$32 implements OnPreferenceChangeListener {
    private final PreferencesFragment f29211a;
    private final FrontpageSettings f29212b;

    PreferencesFragment$$Lambda$32(PreferencesFragment preferencesFragment, FrontpageSettings frontpageSettings) {
        this.f29211a = preferencesFragment;
        this.f29212b = frontpageSettings;
    }

    public final boolean m30315a(Object obj) {
        return this.f29211a.m37737a(this.f29212b, obj);
    }
}
