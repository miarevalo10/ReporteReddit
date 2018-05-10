package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$31 implements OnPreferenceChangeListener {
    private final PreferencesFragment f29209a;
    private final FrontpageSettings f29210b;

    PreferencesFragment$$Lambda$31(PreferencesFragment preferencesFragment, FrontpageSettings frontpageSettings) {
        this.f29209a = preferencesFragment;
        this.f29210b = frontpageSettings;
    }

    public final boolean m30314a(Object obj) {
        return this.f29209a.m37740b(this.f29210b, obj);
    }
}
