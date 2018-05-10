package com.reddit.frontpage.ui.preferences;

import android.net.Uri;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class PreferencesFragment$$Lambda$14 implements OnPreferenceClickListener {
    private final PreferencesFragment f29183a;

    PreferencesFragment$$Lambda$14(PreferencesFragment preferencesFragment) {
        this.f29183a = preferencesFragment;
    }

    public final boolean m30295a() {
        PreferencesFragment preferencesFragment = this.f29183a;
        Util.m23966a(preferencesFragment.getActivity(), Uri.parse(preferencesFragment.getResources().getString(C1761R.string.user_agreement_uri)));
        return true;
    }
}
