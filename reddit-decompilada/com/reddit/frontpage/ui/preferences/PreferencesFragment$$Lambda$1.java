package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class PreferencesFragment$$Lambda$1 implements OnPreferenceClickListener {
    private final PreferencesFragment f29191a;

    PreferencesFragment$$Lambda$1(PreferencesFragment preferencesFragment) {
        this.f29191a = preferencesFragment;
    }

    public final boolean m30301a() {
        SessionManager.b().a(Util.m24019e(this.f29191a.getActivity()), false);
        return true;
    }
}
