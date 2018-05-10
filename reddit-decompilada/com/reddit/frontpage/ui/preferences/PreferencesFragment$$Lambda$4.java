package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$4 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29214a;

    PreferencesFragment$$Lambda$4(FrontpageSettings frontpageSettings) {
        this.f29214a = frontpageSettings;
    }

    public final boolean m30317a(Object obj) {
        return this.f29214a.a(((Boolean) obj).booleanValue());
    }
}
