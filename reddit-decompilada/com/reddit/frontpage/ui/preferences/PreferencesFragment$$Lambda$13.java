package com.reddit.frontpage.ui.preferences;

import android.net.Uri;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class PreferencesFragment$$Lambda$13 implements OnPreferenceClickListener {
    private final PreferencesFragment f29182a;

    PreferencesFragment$$Lambda$13(PreferencesFragment preferencesFragment) {
        this.f29182a = preferencesFragment;
    }

    public final boolean m30294a() {
        PreferencesFragment preferencesFragment = this.f29182a;
        Util.m23966a(preferencesFragment.getActivity(), Uri.parse(preferencesFragment.getResources().getString(C1761R.string.privacy_policy_uri)));
        return true;
    }
}
