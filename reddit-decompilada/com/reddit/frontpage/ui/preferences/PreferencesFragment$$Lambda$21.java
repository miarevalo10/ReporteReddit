package com.reddit.frontpage.ui.preferences;

import android.content.Context;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$21 implements OnPreferenceChangeListener {
    private final FrontpageSettings f29194a;
    private final Context f29195b;

    PreferencesFragment$$Lambda$21(FrontpageSettings frontpageSettings, Context context) {
        this.f29194a = frontpageSettings;
        this.f29195b = context;
    }

    public final boolean m30303a(Object obj) {
        return PreferencesFragment.m37722a(this.f29194a, this.f29195b, obj);
    }
}
