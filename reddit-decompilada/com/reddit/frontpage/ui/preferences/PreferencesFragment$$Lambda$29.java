package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$29 implements OnPreferenceChangeListener {
    private final PreferencesFragment f29203a;
    private final FrontpageSettings f29204b;

    PreferencesFragment$$Lambda$29(PreferencesFragment preferencesFragment, FrontpageSettings frontpageSettings) {
        this.f29203a = preferencesFragment;
        this.f29204b = frontpageSettings;
    }

    public final boolean m30311a(Object obj) {
        return this.f29203a.m37744d(this.f29204b, obj);
    }
}
