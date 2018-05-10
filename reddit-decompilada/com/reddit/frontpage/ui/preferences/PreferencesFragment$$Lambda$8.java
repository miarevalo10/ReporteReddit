package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$8 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29223a;

    PreferencesFragment$$Lambda$8(FrontpageSettings frontpageSettings) {
        this.f29223a = frontpageSettings;
    }

    public final boolean m30321a(Object obj) {
        return this.f29223a.e(((Boolean) obj).booleanValue());
    }
}
