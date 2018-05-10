package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;

final /* synthetic */ class PreferencesFragment$$Lambda$2 implements OnPreferenceChangeListener {
    private final String f29205a;
    private final FrontpageSettings f29206b;

    PreferencesFragment$$Lambda$2(String str, FrontpageSettings frontpageSettings) {
        this.f29205a = str;
        this.f29206b = frontpageSettings;
    }

    public final boolean m30312a(Object obj) {
        return this.f29206b.a(TextUtils.equals(this.f29205a, (String) obj), true);
    }
}
